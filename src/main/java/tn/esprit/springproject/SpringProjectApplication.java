package tn.esprit.springproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.EventListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.EnableScheduling;
import tn.esprit.springproject.Service.iFoyerService;

@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages = {"tn.esprit.springproject","tn.esprit.springproject.corsconfiguration"})
public class SpringProjectApplication {
    @Autowired
    private iFoyerService foyerService;

    public static void main(String[] args) {
        SpringApplication.run(SpringProjectApplication.class, args);
    }



}
