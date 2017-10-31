package ar.uba.fi.tdd.rulogic.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Rule {
    private String name;
    private List<String> variables;
    private List unreplacedFacts;

    public Rule(String rule) {
        this.name = rule.replaceAll("\\(.*$", "");
        this.variables = Arrays.asList(rule.replaceAll("^.*\\(", "").
                replaceAll("\\).*", "").
                split(", "));
        Collections.sort(this.variables);
        this.unreplacedFacts = Arrays.stream(rule.replaceAll("^.*:- ", "").
                replaceAll("\\), ", ");").split(";")).
                map(Fact::new).collect(Collectors.toList());
    }

    public String getName() {
        return name;
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
}
