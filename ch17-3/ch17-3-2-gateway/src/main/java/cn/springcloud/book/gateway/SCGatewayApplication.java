package cn.springcloud.book.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SCGatewayApplication {

	@Bean
	public RouteLocator testRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("add_request_parameter_route", r ->
						r.path("/addRequestParameter").filters(f -> f.addRequestParameter("example", "ValueB"))
								.uri("http://localhost:8071/test/addRequestParameter"))
				.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(SCGatewayApplication.class, args);
	}
}
