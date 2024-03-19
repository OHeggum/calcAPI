package com.example.calcapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
@RestController
@RequestMapping("/calculate")
public class CalcController {

	public final static Logger LOGGER =
			Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	@PostMapping("/add")
	public ResponseEntity<Double> add(@RequestBody CalculationRequest request) {
		double result = request.getOp1() + request.getOp2();
		String asString = request.getOp1() + " + " + request.getOp2() + " = " + result;
		LOGGER.log(Level.INFO, asString);
		return ResponseEntity.ok(result);
	}

	@PostMapping("/subtract")
	public ResponseEntity<Double> subtract(@RequestBody CalculationRequest request) {
		double result = request.getOp1() - request.getOp2();
		String asString = request.getOp1() + " - " + request.getOp2() + " = " + result;
		LOGGER.log(Level.INFO, asString);
		return ResponseEntity.ok(result);
	}

	@PostMapping("/multiply")
	public ResponseEntity<Double> multiply(@RequestBody CalculationRequest request) {
		double result = request.getOp1() * request.getOp2();
		String asString = request.getOp1() + " * " + request.getOp2() + " = " + result;
		LOGGER.log(Level.INFO, asString);
		return ResponseEntity.ok(result);
	}

	@PostMapping("/divide")
	public ResponseEntity<Double> divide(@RequestBody CalculationRequest request) {
		double result = request.getOp1() / request.getOp2();
		String asString = request.getOp1() + " / " + request.getOp2() + " = " + result;
		LOGGER.log(Level.INFO, asString);
		return ResponseEntity.ok(result);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/calculate/**").allowedOrigins("http://localhost:5173");
			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(CalcController.class, args);
	}

	public static class CalculationRequest {
		private double op1;
		private double op2;

		public double getOp1() {
			return op1;
		}

		public double getOp2() {
			return op2;
		}
	}
}
