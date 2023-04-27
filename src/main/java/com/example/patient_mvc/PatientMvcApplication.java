package com.example.patient_mvc;

import com.example.patient_mvc.entities.Patient;
import com.example.patient_mvc.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class PatientMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientMvcApplication.class, args);
    }

    //@Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository){

        return args -> {
            patientRepository.save(
                    new Patient(null,"yassine",new Date(),false,120)
            );
            patientRepository.save(
                    new Patient(null,"malak",new Date(),true,150)
            );
            patientRepository.save(
                    new Patient(null,"manal",new Date(),false,180)
            );
            patientRepository.save(
                    new Patient(null,"Mohammed",new Date(),true,520)
            );

            patientRepository.findAll().forEach(p->{
                System.out.println(p.getNom());
            });
        };

    }

    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
