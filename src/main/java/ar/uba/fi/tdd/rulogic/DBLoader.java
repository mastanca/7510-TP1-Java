package ar.uba.fi.tdd.rulogic;

import ar.uba.fi.tdd.rulogic.model.Fact;
import ar.uba.fi.tdd.rulogic.model.Rule;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DBLoader {
    private List facts;
    private List rules;

    public DBLoader(String filename) throws IOException, URISyntaxException {
        ClassLoader classLoader = getClass().getClassLoader();
        Stream<String> data = Files.lines(Paths.get(ClassLoader.getSystemClassLoader()
                .getResource(filename).toURI()));
        this.facts = data.filter(str -> !str.contains(":-")).map(Fact::new).collect(Collectors.toList());
        this.rules = new ArrayList<Rule>();
    }

    public List getFacts() {
        return facts;
    }

    public List getRules() {
        return rules;
    }

    public String normalize(String line) {
        return line.replaceAll("\\s\\(\\s", "(").
                replaceAll("\\s\\)\\s", ")").
                replaceAll("\\)\\s*\\.$", "\\)\\.").
                replaceAll("\\t", " ").
                replaceAll("[,!?;]", "$0 ").replaceAll("\\s+", " ").
                replaceAll("\\):", "\\) :")
                .trim();
    }
}
