package cz.mvcr.datavalidator.rdf;

import java.io.File;
import java.net.URL;

public class TestUtils {

    public static File fileFromResource(String fileName) {
        final URL url = Thread.currentThread().getContextClassLoader().
                getResource(fileName);
        if (url == null) {
            throw new RuntimeException("Required resource '"
                    + fileName + "' is missing.");
        }
        return new File(url.getPath());
    }

}
