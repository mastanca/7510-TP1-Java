package ar.uba.fi.tdd.rulogic.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FactTest {
    @Test
    public void testFactCreation() {
        Fact fact = new Fact("varon(juan)");
        Assert.assertEquals(fact.getName(), "varon");
        List<String> statements = new ArrayList<>();
        statements.add("juan");
        Assert.assertTrue(fact.getStatements().equals(statements));
    }

    @Test
    public void testEquals() {
        Fact fact = new Fact("varon(juan)");
        Fact fact2 = new Fact("varon(juan)");
        Assert.assertTrue(fact.equals(fact2));
        Assert.assertEquals(fact.hashCode(), fact.hashCode());
    }
}
