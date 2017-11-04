package ar.uba.fi.tdd.rulogic.model;

import ar.uba.fi.tdd.rulogic.utils.ZipMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.collect.Streams.zip;

public class Rule extends AbstractFact {
    private List<String> variables;
    private List<Fact> unreplacedFacts;

    public Rule(String rule) {
        super(rule);
        this.variables = Arrays.asList(rule.replaceAll("^.*\\(", "").
                replaceAll("\\).*", "").
                split(", "));
        Collections.sort(this.variables);
        this.unreplacedFacts = Arrays.stream(rule.replaceAll("^.*:- ", "").
                replaceAll("\\), ", ");").split(";")).
                map(Fact::new).collect(Collectors.toList());
    }

    public List<String> getVariables() {
        return variables;
    }

    public List getUnreplacedFacts() {
        return unreplacedFacts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rule rule = (Rule) o;

        if (!getName().equals(rule.getName())) return false;
        if (!getVariables().equals(rule.getVariables())) return false;
        return getUnreplacedFacts().equals(rule.getUnreplacedFacts());
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getVariables().hashCode();
        result = 31 * result + getUnreplacedFacts().hashCode();
        return result;
    }

    public List<Fact> getReplacedFacts(Fact queryFact) {
        List<ZipMap> zippedVars = zip(variables.stream(), queryFact.getStatements().stream(), ZipMap::new).collect(Collectors.toList());
        List<String> keys = new ArrayList<>();
        for (ZipMap zipMap : zippedVars) {
            keys.add(zipMap.getKey());
        }
        List<Fact> replacedFacts = new ArrayList<>();
        for (int i = 0; i < unreplacedFacts.size(); i++) {
            List<String> statements = unreplacedFacts.get(i).getStatements();
            List<String> replacedStatements = new ArrayList<>();
            for (int j = 0; j < statements.size(); j++) {
                for (String key : keys) {
                    if (statements.get(j).equals(key)) {
                        statements.set(j, zippedVars.stream().filter(zipMap -> zipMap.getKey().equals(key)).collect(Collectors.toList()).get(0).getValue());
                    }
                }
                replacedStatements.add(statements.get(j));
            }
            replacedFacts.add(new Fact(unreplacedFacts.get(i).getName(), replacedStatements));
        }
        return replacedFacts;
    }
}
