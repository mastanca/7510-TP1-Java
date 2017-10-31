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

    @Test
    public void testNormalizeDatabase() {
        String str1 = "varon ( nicolas ) .";
        Assert.assertEquals("varon(nicolas).", dbLoader.normalize(str1));
        String str2 = "mujer(maria) .";
        Assert.assertEquals("mujer(maria).", dbLoader.normalize(str2));
        String str3 = "tio(X, Y, Z):- varon(X),\thermano(X, Z),padre(Z, Y).\n";
        Assert.assertEquals("tio(X, Y, Z) :- varon(X), hermano(X, Z), padre(Z, Y).", dbLoader.normalize(str3));
    }
}
