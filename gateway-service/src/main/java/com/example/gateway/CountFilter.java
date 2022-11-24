package com.example.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Calendar;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class CountFilter extends AbstractGatewayFilterFactory<CountFilter.Config> {


    public static Logger LOG = LoggerFactory.getLogger(CountFilter.class);
    private static AtomicInteger count = new AtomicInteger();

    public CountFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        GatewayFilter gatewayFilter = (((exchange, chain) -> {
            LOG.info("La request vino desde: " + exchange.getRequest().getPath());
            LOG.info("La request vino desde: " + exchange.getRequest().getURI());
            LOG.info("La cantidad de peticiones al gateway es: " + count.incrementAndGet());
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                LOG.info("Finalizo la request. Tiempo de respuesta: " + Calendar.getInstance().getTime());
            }));
        }));

        return gatewayFilter;
    }

    public static class Config {
        //Put the configuration properties
    }
}

