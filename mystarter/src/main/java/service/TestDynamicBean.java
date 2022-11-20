package service;

public class TestDynamicBean {
    private String serviceName;
    private String value;

    public void doSomething() {
        System.out.println(serviceName + " " + value);
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String printSomething() {
        return "serviceName: " + serviceName + " value: " + value;
    }
}
