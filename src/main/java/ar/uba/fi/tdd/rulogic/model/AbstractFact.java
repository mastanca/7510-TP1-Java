package ar.uba.fi.tdd.rulogic.model;

public abstract class AbstractFact {
    public String name;

    public AbstractFact(String str) {
        this.name = str.replaceAll("\\(.*$", "");
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractFact that = (AbstractFact) o;

        return getName() != null ? getName().equals(that.getName()) : that.getName() == null;
    }

    @Override
    public int hashCode() {
        return getName() != null ? getName().hashCode() : 0;
    }
}
