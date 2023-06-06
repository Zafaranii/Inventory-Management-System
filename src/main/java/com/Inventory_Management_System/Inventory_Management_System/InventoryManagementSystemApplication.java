package com.Inventory_Management_System.Inventory_Management_System;

import Services.ProductService;
import jakarta.persistence.Entity;
import model.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@EntityScan({"Model"})
@EnableJpaRepositories({"Repositories"})
@ComponentScan({"Services","Controller"})
@SpringBootApplication
public class InventoryManagementSystemApplication {


	public static void main(String[] args) {


		ApplicationContext context = SpringApplication.run(InventoryManagementSystemApplication.class, args);



		}


	}
