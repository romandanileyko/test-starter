package configuration;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import properties.TestProperties;
import service.TestDynamicBean;

import java.util.Map;
import java.util.Properties;

@Configuration
public class DynamicBeanConfiguration implements ApplicationContextAware {

    private TestProperties testProperties;

    public DynamicBeanConfiguration(TestProperties testProperties) {
        this.testProperties = testProperties;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ConfigurableApplicationContext configurableApplicationContext = (ConfigurableApplicationContext) applicationContext;
        for (Map.Entry<String, Properties> entry: testProperties.getProperties().entrySet()) {
            String beanName = entry.getKey();
            ConfigurableListableBeanFactory beanFactory = configurableApplicationContext.getBeanFactory();
            TestDynamicBean dynamicBean = (TestDynamicBean) beanFactory.createBean(TestDynamicBean.class, AutowireCapableBeanFactory.AUTOWIRE_BY_NAME, false);
            createDynamicBean(entry, beanName, beanFactory, dynamicBean);
        }
    }

    private void createDynamicBean(Map.Entry<String, Properties> entry, String beanName, ConfigurableListableBeanFactory beanFactory, TestDynamicBean dynamicBean) {
        for (Map.Entry<Object, Object> properties: entry.getValue().entrySet()) {
            dynamicBean.setServiceName(beanName);
            dynamicBean.setValue(properties.getValue().toString());
            beanFactory.autowireBean(dynamicBean);
            beanFactory.registerSingleton(beanName, dynamicBean);
        }
    }
}

