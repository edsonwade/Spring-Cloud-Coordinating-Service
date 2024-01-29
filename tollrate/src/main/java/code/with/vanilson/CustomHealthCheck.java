package code.with.vanilson;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CustomHealthCheck implements HealthIndicator {
    int errorCode = 0;

    @Override
    public Health health() {

        log.info("Health check performed, error code is {}: ", errorCode);

        if (errorCode > 3 && errorCode < 4) {
            errorCode++;
            return Health.down()
                    .withDetail("Custom Error Code", errorCode)
                    .build();
        } else {
            errorCode++;
            return Health.up().build();
        }
    }
}
