package ar.uba.fi.tdd.rulogic.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FactTest {
    @Test
    public void testFactCreation() {
        Fact fact = new Fact("varon(juan).");
        Assert.assertEquals(fact.getName(), "varon");
        List statements = new ArrayList <String>();
        statements.add("juan");
        Assert.assertTrue(fact.getStatements().equals(statements));
    }
}
