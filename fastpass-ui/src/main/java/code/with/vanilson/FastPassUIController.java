package code.with.vanilson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;

@Controller
public class FastPassUIController {

    private final WebClient.Builder webClientBuilder;

    public FastPassUIController(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    @RequestMapping(path = "/customerdetails")
    public String getFastPassCustomerDetails(@RequestParam(defaultValue = "800") String fastpassid, Model m) {


        FastPassUICustomer customer = webClientBuilder.build().get()
                .uri("http://fastpass-service/fastpass?fastpassid=" + fastpassid)
                .retrieve()
                .bodyToMono(FastPassUICustomer.class)
                .block();

        System.out.println("fastpassid: " + fastpassid);
        m.addAttribute("customer", customer);
        return "console";

    }
}
