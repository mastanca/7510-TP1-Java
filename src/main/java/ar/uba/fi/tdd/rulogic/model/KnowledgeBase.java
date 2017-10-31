package ar.uba.fi.tdd.rulogic.model;

import ar.uba.fi.tdd.rulogic.DBLoader;
import ar.uba.fi.tdd.rulogic.Normalizer;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.function.Predicate;

public class KnowledgeBase {
    private DBLoader loader;

    public KnowledgeBase() throws IOException, URISyntaxException {
        this.loader = new DBLoader("rules.db");
    }

    public boolean answer(String query) {
        query = Normalizer.normalize(query);
        Fact queryFact = new Fact(query);
        if (anyFactMatches(queryFact)) {
            return true;
        } else {
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    private boolean anyFactMatches(Fact query) {
        Predicate<Fact> factPredicate = fact -> fact.equals(query);
        return loader.getFacts().stream().anyMatch(factPredicate);
    }

}
