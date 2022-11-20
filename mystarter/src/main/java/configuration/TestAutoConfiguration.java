package configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Scope;
import properties.TestProperties;
import service.TestDynamicBean;
import service.TestService;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Configuration
@EnableConfigurationProperties(TestProperties.class)
public class TestAutoConfiguration {
    @Bean
    public TestService testService(TestProperties properties) {
        return new TestService(properties);
    }

    @Bean
    @Scope(ConfigurableListableBeanFactory.SCOPE_PROTOTYPE)
    public DynamicBeanConfiguration dynamicBeanConfiguration(TestProperties properties) {
        return new DynamicBeanConfiguration(properties);
    }
}
