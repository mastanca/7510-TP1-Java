import ar.uba.fi.tdd.rulogic.DBLoader;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class DBLoaderTest {
    private DBLoader dbLoader = new DBLoader("rules.db");

    public DBLoaderTest() throws IOException, URISyntaxException {
    }

    @Test
    public void testLoadFromFile() {
        Assert.assertEquals(dbLoader.getFacts().size(), 15);
    }
}
