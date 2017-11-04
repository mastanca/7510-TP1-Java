package ar.uba.fi.tdd.rulogic.model;

import ar.uba.fi.tdd.rulogic.DBLoader;
import ar.uba.fi.tdd.rulogic.Normalizer;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class KnowledgeBase {
    private DBLoader loader;

    public KnowledgeBase() throws IOException, URISyntaxException {
        this.loader = new DBLoader("rules.db");
    }

    @SuppressWarnings("unchecked")
    public boolean answer(String query) {
        query = Normalizer.normalize(query);
        Fact queryFact = new Fact(query);
        if (anyFactMatches(queryFact)) {
            return true;
        } else {
            Predicate<Rule> matchingNamePredicate = rule -> rule.nameMatches(queryFact.getName());
            List<Rule> matchingRules = (List<Rule>) loader.getRules().stream().filter(matchingNamePredicate).collect(Collectors.toList());
            if (matchingRules.isEmpty()) {
                return false;
            }
            Rule matchingNameRule = matchingRules.get(0);
            List<Fact> replacedFacts = matchingNameRule.getReplacedFacts(queryFact);
            Predicate<Fact> allFactMatchPredicate = this::anyFactMatches;
            return replacedFacts.stream().allMatch(allFactMatchPredicate);
        }
    }

    @SuppressWarnings("unchecked")
    private boolean anyFactMatches(Fact query) {
        Predicate<Fact> factPredicate = fact -> fact.equals(query);
        return loader.getFacts().stream().anyMatch(factPredicate);
    }

}
