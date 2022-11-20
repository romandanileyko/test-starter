package properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Properties;

@Configuration
@ConfigurationProperties(prefix = "config")
public class TestProperties {
    private String message;
    private HashMap<String, Properties> properties = new HashMap();

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HashMap<String, Properties> getProperties() {
        return properties;
    }

    public void setProperties(HashMap<String, Properties> properties) {
        this.properties = properties;
    }
}
