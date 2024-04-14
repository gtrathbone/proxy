package rss.wine;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.gateway.config.HttpClientProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties(prefix="gateway")
public class HttpClientConfig {
  private Map<String, String> test;
  private Map<String, HttpClientProperties> httpclients;

  public Map<String, String> getTest() {
    return test;
  }

  public void setTest(Map<String, String> test) {
    this.test = test;
  }

  public Map<String, HttpClientProperties> getHttpclients() {
    return httpclients;
  }

  public void setHttpclients(Map<String, HttpClientProperties> httpclients) {
    this.httpclients = httpclients;
  }
}
