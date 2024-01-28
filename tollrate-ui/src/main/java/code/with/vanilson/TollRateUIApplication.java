package code.with.vanilson;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
public class TollRateUIApplication {
    public static void main(String[] args) {
        run(TollRateUIApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public WebClient.Builder loadBalancedWebClientBuilder() {
        return WebClient.builder();
    }
}