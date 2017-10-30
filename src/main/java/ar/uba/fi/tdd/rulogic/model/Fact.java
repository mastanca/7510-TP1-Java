package ar.uba.fi.tdd.rulogic.model;

import java.util.Arrays;
import java.util.List;

public class Fact {
    private String name;
    private List statements;

    public Fact(String stringFact) {
        this.name = stringFact.replaceAll("\\(.*$", "");
        this.statements = Arrays.asList(stringFact.replaceAll("^.*\\(", "").replaceAll("\\)\\.$", "").split(", "));
    }

    public String getName() {
        return name;
    }

    public List getStatements() {
        return statements;
    }
}
