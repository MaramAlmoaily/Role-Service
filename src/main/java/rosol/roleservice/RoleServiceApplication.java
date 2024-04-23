package rosol.roleservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import rosol.roleservice.model.AppRole;
import rosol.roleservice.service.RoleCommandService;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Role Service Springboot starting point
 */
@SpringBootApplication
public class RoleServiceApplication {
@Autowired
RoleCommandService roleCommandService;

    public static void main(String[] args){
        SpringApplication.run(RoleServiceApplication.class, args);
    }

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Bean
    public CommandLineRunner startup() {
        return args -> {
            LocalDate date = LocalDate.of(1991, 10, 5);
            AppRole role1 = roleCommandService.createActiveRole("Daniel", "Lozano");

            System.out.println("Database initialized!");

        };

    }
    }

