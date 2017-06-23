package com.cipil.first;

import com.cipil.first.model.Menu;
import com.cipil.first.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

//for jsr310 java 8 java.time.*
@EntityScan(
        basePackageClasses = {CipilApplication.class, Jsr310JpaConverters.class}
)
@SpringBootApplication
public class CipilApplication {

	public static void main(String[] args) {
		SpringApplication.run(CipilApplication.class, args);
	}

}
