package ar.uba.fi.tdd.rulogic.model;

import java.util.Arrays;
import java.util.List;

public class Fact {
    private String name;
    private List statements;

    public Fact(String stringFact) {
        this.name = stringFact.replaceAll("\\(.*$", "");
        this.statements = Arrays.asList(stringFact.
                replaceAll("^.*\\(", "").
                replaceAll("\\)$", "").
                split(", "));
    }

    public String getName() {
        return name;
    }

    public List getStatements() {
        return statements;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fact fact = (Fact) o;

        if (!getName().equals(fact.getName())) return false;
        return getStatements().equals(fact.getStatements());
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getStatements().hashCode();
        return result;
    }
}
