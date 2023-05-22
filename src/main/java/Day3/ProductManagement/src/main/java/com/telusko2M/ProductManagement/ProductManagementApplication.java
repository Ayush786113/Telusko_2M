package com.telusko2M.ProductManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ProductManagementApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ProductManagementApplication.class, args);

		Service service = context.getBean(Service.class);

		System.out.println("\n============================================================================================\n");

		for(Product product : service.getAllProducts())
//		for(Product product : service.getProductByName("keyboard"))
//		for(Product product : service.getProductByPlace("black table"))
//		for(Product product : service.getProductWithText("cable"))
//		for(Product product : service.getProductsOutOfWarranty(2023))
		{
			System.out.println(product);
		}


		System.out.println("\n============================================================================================\n");
	}

}
