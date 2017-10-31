package ar.uba.fi.tdd.rulogic;

import ar.uba.fi.tdd.rulogic.model.Fact;
import ar.uba.fi.tdd.rulogic.model.Rule;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DBLoader {
    private List facts;
    private List rules;

    public DBLoader(String filename) throws IOException, URISyntaxException {
        Supplier<Stream<String>> dataSupplier = () -> {
            try {
                return Files.lines(Paths.get(ClassLoader.getSystemClassLoader()
                        .getResource(filename).toURI())).map(Normalizer::normalize);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            return null;
        };
        this.facts = dataSupplier.get().filter(str -> !str.contains(":-")).map(Fact::new).collect(Collectors.toList());
        this.rules = dataSupplier.get().filter(str -> str.contains(":-")).map(Rule::new).collect(Collectors.toList());
    }

    public List getFacts() {
        return facts;
    }

    public List getRules() {
        return rules;
    }
}
