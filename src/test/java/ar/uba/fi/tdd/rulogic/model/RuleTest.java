package ar.uba.fi.tdd.rulogic.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RuleTest {
    @Test
    public void testRuleCreation() {
        Rule rule = new Rule("hijo(X, Y) :- varon(X), padre(Y, X)");
        Assert.assertEquals("hijo", rule.getName());
        List<String> variables = new ArrayList<>();
        variables.add("X");
        variables.add("Y");
        Assert.assertTrue(rule.getVariables().equals(variables));
        List<Fact> facts = new ArrayList<>();
        facts.add(new Fact("varon(X)"));
        facts.add(new Fact("padre(Y, X)"));
        Assert.assertTrue(rule.getUnreplacedFacts().equals(facts));
    }
}
