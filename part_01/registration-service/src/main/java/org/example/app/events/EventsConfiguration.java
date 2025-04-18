package org.example.app.events;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class EventsConfiguration {


    @Bean
    WebClient eventsWebClient(@Value("${services.events.url}") String baseUrl) {
        return WebClient.builder()
                .baseUrl(baseUrl)
                .build();
    }


    @Bean
    EventsClient eventsClient(WebClient eventsWebClient) {
        return HttpServiceProxyFactory
                    .builderFor(WebClientAdapter.create(eventsWebClient))
                    .build()
                    .createClient(EventsClient.class);
    }
}
