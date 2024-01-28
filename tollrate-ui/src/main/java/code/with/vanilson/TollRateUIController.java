package code.with.vanilson;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;

@Controller

@Slf4j
public class TollRateUIController {
    private final WebClient.Builder builder;

    public TollRateUIController(WebClient.Builder builder) {
        this.builder = builder;
    }

    @RequestMapping("/dashboard")
    public String getTollRate(@RequestParam(defaultValue = "1000") Integer stationId, Model m) {

        TollRate rate = builder.build().get()
                .uri("http://tollrate-service/tollrate/" + stationId)
                .retrieve()
                .bodyToMono(TollRate.class)
                .block();
        log.info("stationId {}: ", stationId);
        m.addAttribute("rate", rate);
        return "dashboard";
    }
}
