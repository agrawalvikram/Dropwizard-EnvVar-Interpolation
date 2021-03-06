package minisu.dropwizard.interpolation;

import org.apache.commons.lang3.text.StrLookup;

public class EnvironmentVariableLookup extends StrLookup {

    @Override
    public String lookup(String key) {
        String value = System.getenv(key);

        if (value == null) {
            throw new EnvironmentException("The environment variable '" + key
                    + "' is not defined; could not substitute the expression '${"
                    + key + "}'.");
        }

        return value;
    }
}