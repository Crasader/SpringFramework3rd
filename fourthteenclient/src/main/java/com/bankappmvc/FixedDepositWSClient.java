package com.bankappmvc;

import com.bankappmvc.domain.FixedDepositDetails;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class FixedDepositWSClient {
    private static Logger logger = Logger.getLogger(FixedDepositWSClient.class);

    private static ApplicationContext context;

//    public static void main(String[] args) {
//        context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext.xml");
//        getFixedDepositList(context.getBean(RestTemplate.class));
//    }

    private static void getFixedDepositList(RestTemplate restTemplate) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "application/json");
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        ParameterizedTypeReference<List<FixedDepositDetails>> typeReference = new ParameterizedTypeReference<List<FixedDepositDetails>>() {
        };

        ResponseEntity<List<FixedDepositDetails>> responseEntity = restTemplate
                .exchange("http://localhost:8081/fixedDeposit",
                        HttpMethod.GET, requestEntity, typeReference);

        List<FixedDepositDetails> fixedDepositDetailses = responseEntity.getBody();
        logger.info("List of fixed deposit details: \n " + fixedDepositDetailses);
    }
}
