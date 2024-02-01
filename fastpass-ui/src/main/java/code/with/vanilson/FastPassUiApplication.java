package code.with.vanilson;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

import static org.springframework.boot.SpringApplication.run;

@LoadBalancerClient(value = "fastpass-service",
        configuration = FastPassUILoadBalancerConfig.class)
@SpringBootApplication
public class FastPassUiApplication {
    public static void main(String[] args) {
        run(FastPassUiApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public WebClient.Builder loaBuilder() {
        return WebClient.builder();
    }

}