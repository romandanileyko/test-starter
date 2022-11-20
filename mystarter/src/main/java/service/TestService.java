package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import properties.TestProperties;

@Service
public class TestService {
    private TestProperties properties;

    @Autowired
    public TestService(TestProperties properties) {
        this.properties = properties;
    }
    public String generateString() {
        return String.format("%s", properties.getMessage());
    }
}
