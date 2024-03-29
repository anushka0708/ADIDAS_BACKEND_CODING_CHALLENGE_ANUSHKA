package com.adidas;

import static spark.Spark.get;
import static spark.Spark.port;

import java.sql.SQLException;

import com.google.gson.Gson;

public class Service {
	static String driverClassName;
	static String connectionURL;
	static String userName;
	static String passWord;
	static Connect dbConnection;
	public static void main(String[] args) throws SQLException {
		port(8088);
		if(args.length!=3){
			System.out.println("USAGE: java -jar Product_API.jar <connectionURL> <userName> <password>");
			System.exit(1);
		}
		driverClassName="com.mysql.cj.jdbc.Driver";
		connectionURL=args[0];
		userName=args[1];
		passWord=args[2];
		dbConnection = new Connect(driverClassName,connectionURL,userName,passWord);
		

		final ProductService productService = new ProductService();

		//get all products
		get("/products", (request, response) -> {
			response.type("application/json");
			if(productService.getProducts(dbConnection).isEmpty())
				return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, "100:No products have been found"));
			else
				return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, new Gson().toJsonTree(productService.getProducts(dbConnection))));
		});

		//get product by id
		get("/products/:id", (request, response) -> {
			response.type("application/json");
			Product productObj=productService.getProduct(request.params(":id"),dbConnection);
			if(productObj==null)
				return new Gson().toJson(new StandardResponse(StatusResponse.INFORMATION, "100:Product ID not found"));
			else
				return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, new Gson().toJsonTree(productObj)));
		});

	}

}
