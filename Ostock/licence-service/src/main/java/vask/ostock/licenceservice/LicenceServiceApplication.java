package vask.ostock.licenceservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;
import vask.ostock.licenceservice.util.UserContextInterceptor;

import java.util.Collections;
import java.util.List;

@SpringBootApplication
@RefreshScope
@EnableFeignClients
@ConfigurationPropertiesScan
@EnableDiscoveryClient
public class LicenceServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LicenceServiceApplication.class, args);

    }

    @LoadBalanced
    @Bean
    public RestTemplate getRestTemplate() {
        RestTemplate template = new RestTemplate();
        List<ClientHttpRequestInterceptor> interceptors = template.getInterceptors();
        if (interceptors.isEmpty()) {
            template.setInterceptors(Collections.singletonList(
                    new UserContextInterceptor()));
        } else {
            interceptors.add(new UserContextInterceptor());
            template.setInterceptors(interceptors);
        }
        return template;
    }
}
