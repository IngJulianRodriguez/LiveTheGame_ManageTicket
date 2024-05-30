package com.livethegame.ManageTicket.services;

import com.livethegame.ManageTicket.dto.LogRecordRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Base64;

@Service
public class MonitoringService {


    @Value("${server.Monitoring.url}")
    private String MonitoringUrlServer;

    @Value("${spring.application.name}")
    private String serviceName;

    public void registerSuccessLog(String serviceId, String information){
        registerLog(serviceId, information, 1L);
    }
    public void registerControlledExceptionLog(String serviceId, String information){
        registerLog(serviceId, information, 2L);
    }
    public void registerNotControlledExceptionLog(String serviceId, String information){
        registerLog(serviceId, information, 3L);
    }
    @Async
    private void registerLog(String serviceId, String information, Long typeId) {
        try {
            LogRecordRequest logRecordRequest = new LogRecordRequest();
            logRecordRequest.setService_name(serviceName);
            logRecordRequest.setService_id_value(serviceId);
            logRecordRequest.setInformation(information);
            logRecordRequest.setType_id(typeId);


            WebClient webClient = WebClient.builder()
                    .baseUrl(MonitoringUrlServer)
                    .defaultHeader(HttpHeaders.AUTHORIZATION, "Basic " + encodeCredentials("admin", "admin"))
                    .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                    .build();

            webClient.method(HttpMethod.POST)
                    .uri("/monitoring/create-log")
                    .body(BodyInserters.fromValue(logRecordRequest))
                    .retrieve()
                    .bodyToMono(String.class)
                    .subscribe(response -> {
                        System.out.println("Respuesta del servidor: " + response);
                    });
        }catch (Exception e){

        }
    }

    private String encodeCredentials(String username, String password) {
        return Base64.getEncoder().encodeToString((username + ":" + password).getBytes());
    }

}
