import ar.uba.fi.tdd.rulogic.Normalizer;
import org.junit.Assert;
import org.junit.Test;

public class NormalizerTest {
    @Test
    public void testNormalizeDatabase() {
        String str1 = "varon ( nicolas ) .";
        Assert.assertEquals("varon(nicolas)", Normalizer.normalize(str1));
        String str2 = "mujer(maria) .";
        Assert.assertEquals("mujer(maria)", Normalizer.normalize(str2));
        String str3 = "tio(X, Y, Z):- varon(X),\thermano(X, Z),padre(Z, Y).\n";
        Assert.assertEquals("tio(X, Y, Z) :- varon(X), hermano(X, Z), padre(Z, Y)", Normalizer.normalize(str3));
    }
}
