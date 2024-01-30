package code.with.vanilson;

import lombok.extern.slf4j.Slf4j;

import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreakerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Controller

@Slf4j
public class TollRateUIController {
    private final WebClient.Builder builder;
    private final ReactiveCircuitBreakerFactory circuitBreakerFactory;

    public TollRateUIController(WebClient.Builder builder, ReactiveCircuitBreakerFactory circuitBreakerFactory) {
        this.builder = builder;
        this.circuitBreakerFactory = circuitBreakerFactory;
    }

    @RequestMapping("/dashboard")
    public String getTollRate(@RequestParam(defaultValue = "1000") Integer stationId, Model m) {

        var rcb = circuitBreakerFactory.create("tollrate-cb");

        Mono<TollRate> rate = rcb.run(builder.build().get()
                        .uri("http://tollrate-service/tollrate/" + stationId)
                        .retrieve()
                        .bodyToMono(TollRate.class),
                // throw exception if the call fails
                throwable -> getDefaultRate());

        log.info("stationId {}: ", stationId);
        m.addAttribute("rate", rate.block());
        return "dashboard";
    }

    private Mono<TollRate> getDefaultRate() {
        log.info("Fallback method called");
        return Mono.just(new TollRate(0, 2.00f, ""));
    }
}
