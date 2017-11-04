package ar.uba.fi.tdd.rulogic.model;

public abstract class AbstractFact {
    public String name;

    public AbstractFact(String str) {
        if (str.contains("(")) {
            this.name = str.replaceAll("\\(.*$", "");
        } else {
            this.name = str;
        }
    }

    public String getName() {
        return name;
    }

    public Boolean nameMatches(String name) {
        return this.name.equals(name);
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
