package code.with.vanilson;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/fast-pass")
public class FastPassController {

    List<FastPass> fastPass = List.of(
            new FastPass("1", "vanilson wayne", "919890102", 567.45),
            new FastPass("2", "sonia wayne", "99999999", 1000.00),
            new FastPass("3", "william wayne", "00000000", 2000.00)

    );

    @GetMapping
    public ResponseEntity<List<FastPass>> listAllRates() {
        return ResponseEntity.ok(Collections.unmodifiableList(fastPass));
    }

    @GetMapping(value = "/fastPassId")

    public ResponseEntity<FastPass> getFastPass(@RequestParam(name = "fastPassId") String fastPassId) {
        var fastPass1 = fastPass.stream()
                .filter(rate -> fastPassId.equals(rate.getFastPassId()))
                .findFirst()
                .orElseThrow(
                        () -> new FastPassByIdNotFoundException(" rate with id " + fastPassId + " was not founded"));
        return ResponseEntity.ok().body(fastPass1);

    }

}
