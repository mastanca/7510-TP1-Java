package ar.uba.fi.tdd.rulogic;

import ar.uba.fi.tdd.rulogic.model.Fact;
import ar.uba.fi.tdd.rulogic.model.Rule;

import java.util.ArrayList;
import java.util.List;

public class DBLoader {
    private List facts;
    private List rules;

    public DBLoader() {
        this.facts = new ArrayList<Fact>();
        this.rules = new ArrayList<Rule>();
    }

    public List getFacts() {
        return facts;
    }

    public List getRules() {
        return rules;
    }
}
