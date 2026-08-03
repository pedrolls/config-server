package br.com.erudio.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@ConfigurationProperties("greeting-service")
@RefreshScope //Atualiza as propriedades sem precisar para a aplicacao. Precisa ser classe e não record
public class GreetingConfig {

    public GreetingConfig() {}

    private String greeting;
    private String defaultValue;

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public String getGreeting() {
        return greeting;
    }
}
