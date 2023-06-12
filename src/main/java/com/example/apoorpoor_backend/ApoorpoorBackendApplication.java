package com.example.apoorpoor_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@EnableJpaAuditing
@EnableCaching
@EnableScheduling //Caching
@SpringBootApplication
public class ApoorpoorBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApoorpoorBackendApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry){
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:8080", "http://localhost:3000", "http://127.0.0.1:3000", "http://3.34.85.5:8080", "http://192.168.25.2:3000",
                                "https://apoorpoor.vercel.app", "https://apoorpoor.com")
                        .allowedOriginPatterns("*")
                        .exposedHeaders("Set-Cookie", "USER_ROLE", "ACCESS_KEY", "REFRESH_KEY", "NICKNAME_FLAG", "USER_ID")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD", "PATCH")
                        //.allowedHeaders()
                        .allowCredentials(true)
                        .maxAge(3600);
            }
        };
    }
}
