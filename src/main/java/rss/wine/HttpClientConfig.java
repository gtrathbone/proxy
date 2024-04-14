package rss.wine;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.gateway.config.HttpClientProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties("gateway.httpclient")
public class HttpClientConfig {
  Map<String, HttpClientProperties> configurations;

  public Map<String, HttpClientProperties> getConfigurations() {
    return configurations;
  }

  public void setConfigurations(Map<String, HttpClientProperties> configurations) {
    this.configurations = configurations;
  }
}
