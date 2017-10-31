package ar.uba.fi.tdd.rulogic;

public class Normalizer {
    public static String normalize(String line) {
        return line.replaceAll("\\s\\(\\s", "(").
                replaceAll("\\s\\)\\s", ")").
                replaceAll("\\)\\s*\\.$", "\\)\\.").
                replaceAll("\\t", " ").
                replaceAll("[,!?;]", "$0 ").replaceAll("\\s+", " ").
                replaceAll("\\):", "\\) :").
                trim().
                replaceAll("\\.$", "");
    }
}
