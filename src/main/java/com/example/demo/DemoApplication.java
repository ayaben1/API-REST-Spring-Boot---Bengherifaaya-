package com.example.demo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.example.demo.entities.Livre;
import com.example.demo.repos.LivreRepo;
import com.example.demo.entities.*;
@EnableAutoConfiguration

@EntityScan(basePackages = {"com.example.demo.entities"})
@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Autowired
	private LivreRepo Livrerepository;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
    Livrerepository.save(new Livre((long)1,"auteur","maison1",new Date(),"auteur",110,2215,new Date(),true));
    Livrerepository.save(new Livre((long)2,"auteur2","maison2",new Date(),"auteur2",300,921415,new Date(),false));
	
	}
	
}
