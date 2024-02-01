package code.with.vanilson;

import org.springframework.cloud.client.DefaultServiceInstance;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import reactor.core.publisher.Flux;


import java.util.List;

public class TollServiceInstanceListSupplier implements ServiceInstanceListSupplier {

    private final String serviceId;

    public TollServiceInstanceListSupplier(String serviceId) {
        this.serviceId = serviceId;
    }

    @Override
    public String getServiceId() {
        return serviceId;
    }

    @Override
    public Flux<List<ServiceInstance>> get() {
        var number = new StringBuilder();
        return Flux.just(List.of(
                new DefaultServiceInstance(serviceId + "1", serviceId, "localhost",
                        63598, false)

        ));
    }

}
