package ar.uba.fi.tdd.rulogic.model;

import org.junit.Assert;
import org.junit.Test;

public class AbstractFactTest {
    @Test
    public void testNameMatches() {
        Fact fact = new Fact("varon(jose)");
        Fact fact2 = new Fact("varon(pepe)");
        Assert.assertTrue(fact.nameMatches(fact2.getName()));
    }
}
