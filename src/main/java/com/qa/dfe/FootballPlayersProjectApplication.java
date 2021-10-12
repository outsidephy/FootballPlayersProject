package com.qa.dfe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.qa.dfe.rest.DFEController;

@SpringBootApplication
public class FootballPlayersProjectApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(FootballPlayersProjectApplication.class, args);

		DFEController controllerBean = context.getBean(DFEController.class);

		System.out.println(controllerBean);

		
	}

}
