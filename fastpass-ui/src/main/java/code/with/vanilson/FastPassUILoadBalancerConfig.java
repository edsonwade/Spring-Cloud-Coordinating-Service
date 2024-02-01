package code.with.vanilson;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class FastPassUILoadBalancerConfig {
    @Bean
    @Primary
    TollServiceInstanceListSupplier serviceInstanceListSupplier() {
        return new TollServiceInstanceListSupplier("fastpass-service");
    }
}
