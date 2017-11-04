package ar.uba.fi.tdd.rulogic.utils;

public class ZipMap {
    private String key;
    private String value;

    public ZipMap(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
