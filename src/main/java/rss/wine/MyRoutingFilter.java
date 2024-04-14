package rss.wine;

import jdk.jfr.Category;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.cloud.gateway.config.HttpClientProperties;
import org.springframework.cloud.gateway.filter.NettyRoutingFilter;
import org.springframework.cloud.gateway.filter.headers.HttpHeadersFilter;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.netty.http.client.HttpClient;

import java.util.List;

@Component
public class MyRoutingFilter extends NettyRoutingFilter {
  ApplicationContext context;

  public MyRoutingFilter(ApplicationContext context, HttpClient httpClient, ObjectProvider<List<HttpHeadersFilter>> headersFiltersProvider, HttpClientProperties properties) {
    super(httpClient, headersFiltersProvider, properties);
    this.context = context;
  }

  @Override
  protected HttpClient getHttpClient(Route route, ServerWebExchange exchange) {
    return super.getHttpClient(route, exchange);
  }

  @Override
  public int getOrder() {
    return super.getOrder()-1;
  }
}
