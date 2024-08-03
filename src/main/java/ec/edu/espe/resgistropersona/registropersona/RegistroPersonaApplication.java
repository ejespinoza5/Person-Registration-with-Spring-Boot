package ec.edu.espe.resgistropersona.registropersona;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class RegistroPersonaApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(RegistroPersonaApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(RegistroPersonaApplication.class);
    }
}