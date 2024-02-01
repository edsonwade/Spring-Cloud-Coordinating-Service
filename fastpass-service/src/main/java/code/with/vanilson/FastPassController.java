package code.with.vanilson;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class FastPassController {

    List<FastPass> customers;

    public FastPassController() {

        customers = new ArrayList<>();
        customers.add(new FastPass("800", "Omar Zidan", "555-123-4567", 19.50f));
        customers.add(new FastPass("801", "Maggie Bell", "555-321-7654", 11.25f));
        customers.add(new FastPass("802", "Tiffany Wallace", "555-987-6543", 35.05f));

    }

    @RequestMapping(path = "/fastpass", params = {"fastpassid"})
    public FastPass getFastPassById(@RequestParam String fastpassid) {
        System.out.println("fast pass retrieved for " + fastpassid);
        return customers.stream().filter(customer -> fastpassid.equals(customer.getFastPassId())).findAny()
                .orElse(new FastPass());
    }
}
