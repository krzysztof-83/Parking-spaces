package com.parkingspacesapp.ParkingSpaces;

import com.parkingspacesapp.ParkingSpaces.common.AuditorProvider;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef="auditorProvider")
public class AppConfiguration {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    AuditorAware<String> auditorProvider() {
        return new AuditorProvider();
    }
}
