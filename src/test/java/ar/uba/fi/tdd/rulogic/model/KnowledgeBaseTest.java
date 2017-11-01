package ar.uba.fi.tdd.rulogic.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import static org.mockito.MockitoAnnotations.initMocks;

public class KnowledgeBaseTest {

    @InjectMocks
    private KnowledgeBase knowledgeBase;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
    }

    @Test
    public void testTruth() {
        Assert.assertTrue(this.knowledgeBase.answer("varon(hector)"));
    }

    @Test
    public void testFalse() {
        Assert.assertFalse(this.knowledgeBase.answer("varon(maria)"));
    }
}
