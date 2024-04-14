package rss.wine;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.factory.AbstractNameValueGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.http.HttpClient;
import java.util.Arrays;
import java.util.List;

@Component
public class MyHttpClientGatewayFilterFactory extends AbstractGatewayFilterFactory<MyHttpClientGatewayFilterFactory.Config> {

  public MyHttpClientGatewayFilterFactory() {
    super(Config.class);
  }

  @Override
  public GatewayFilter apply(Config config) {

    return new GatewayFilter() {
      @Override
      public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        exchange.getAttributes().put("HTTP_CONNECTION", config.getBeanName());
        return chain.filter(exchange);
      }
    };
  }

  @Override
  public List<String> shortcutFieldOrder() {
    return List.of("beanName");
  }

  public static class Config {
    private String beanName;

    public Config() {
    }

    public String getBeanName() {
      return beanName;
    }

    public void setBeanName(String beanName) {
      this.beanName = beanName;
    }
  }
}
