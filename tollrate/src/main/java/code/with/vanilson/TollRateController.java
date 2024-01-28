package code.with.vanilson;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class TollRateController {

    List<TollRate> tollRates;

    public TollRateController() {

        tollRates = new ArrayList<>();
        tollRates.add(new TollRate(1000, 0.55f, Instant.now().toString()));
        tollRates.add(new TollRate(1001, 1.05f, Instant.now().toString()));
        tollRates.add(new TollRate(1002, 0.60f, Instant.now().toString()));
        tollRates.add(new TollRate(1003, 1.00f, Instant.now().toString()));

    }

    @GetMapping(value = "tollrate")
    public ResponseEntity<List<TollRate>> listAllRates() {
        return ResponseEntity.ok(Collections.unmodifiableList(tollRates));
    }

    @RequestMapping(value = "/tollrate/{stationId}")
    public ResponseEntity<TollRate> listRatesById(@PathVariable int stationId) {
        var tollRate = tollRates.stream()
                .filter(rate -> stationId == rate.getStationId())
                .findAny()
                .orElse(new TollRate());
        return ResponseEntity.ok().body(tollRate);

    }
}

