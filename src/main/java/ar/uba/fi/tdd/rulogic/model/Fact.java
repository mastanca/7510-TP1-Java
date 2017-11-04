package ar.uba.fi.tdd.rulogic.model;

import java.util.Arrays;
import java.util.List;

public class Fact extends AbstractFact {
    private List<String> statements;

    public Fact(String str, List<String> statements) {
        super(str);
        this.statements = statements;
    }

    public Fact(String stringFact) {
        super(stringFact);
        this.statements = Arrays.asList(stringFact.
                replaceAll("^.*\\(", "").
                replaceAll("\\)$", "").
                split(", "));
    }

    public List<String> getStatements() {
        return statements;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Fact fact = (Fact) o;

        return getStatements() != null ? getStatements().equals(fact.getStatements()) : fact.getStatements() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getStatements() != null ? getStatements().hashCode() : 0);
        return result;
    }
}
