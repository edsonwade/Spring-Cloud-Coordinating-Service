package code.with.vanilson;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/toll-rates")
public class TollRateController {

    List<TollRate> tollRates = List.of(
            new TollRate(1, 5.6f,
                    "2024-01-28T12:48:56.27"),
            new TollRate(2, 3.4f,
                    "2024-01-28T12:49:57.29"),
            new TollRate(3, 45.4f,
                    "2024-01-29T12:49:57.29"),
            new TollRate(4, 3.4f,
                    "2024-01-30T12:49:57.29")
    );

    @GetMapping
    public ResponseEntity<List<TollRate>> listAllRates() {
        return ResponseEntity.ok(Collections.unmodifiableList(tollRates));
    }

    @GetMapping(value = "/{stationId}")
    public ResponseEntity<TollRate> listRatesById(@PathVariable(name = "stationId") Integer stationId) {
        var tollRate = tollRates.stream()
                .filter(rate -> stationId.equals(rate.getStationId()))
                .findFirst()
                .orElseThrow(
                        () -> new TollRateByIdNotFoundException(" rate with id " + stationId + " was not founded"));
        return ResponseEntity.ok().body(tollRate);

    }
}

