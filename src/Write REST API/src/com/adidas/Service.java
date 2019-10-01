package com.adidas;

import static spark.Spark.delete;
import static spark.Spark.post;
import static spark.Spark.put;
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
		port(8080);
		if(args.length!=3){
			System.out.println("USAGE: java -jar Write_REST_API.jar <connectionURL> <userName> <password>");
			System.exit(1);
		}

		driverClassName="com.mysql.cj.jdbc.Driver";
		connectionURL=args[0];
		userName=args[1];
		passWord=args[2];
		dbConnection = new Connect(driverClassName,connectionURL,userName,passWord);

		final ProductService productService = new ProductService();

		//add a new product
		post("/products", (request, response) -> {
			response.type("application/json");

			Product product = new Gson().fromJson(request.body(), Product.class);
			StatusResponse res=productService.addProduct(product,dbConnection);
			if(res.equals(StatusResponse.ERROR))
				return new Gson().toJson(new StandardResponse(StatusResponse.ERROR, "400:Product is not added. Please check the request body and provide a valid product."));
			else if(res.equals(StatusResponse.DUPLICATEPRODUCT))
				return new Gson().toJson(new StandardResponse(StatusResponse.ERROR, "409: Product ID already exists"));
			else return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, "201:Product has been added successfully"));
		});

		//update a product where id
		put("/products/:id", (request, response) -> {
			response.type("application/json");
			Product product = new Gson().fromJson(request.body(), Product.class);
			StatusResponse res=productService.updateProduct(product,dbConnection);
			if(res.equals(StatusResponse.ERROR))
				return new Gson().toJson(new StandardResponse(StatusResponse.ERROR, "400:Product is not updated."));
			else return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, "Product has been updated successfully"));
		});

		//delete product
		delete("/products/:id", (request, response) -> {
			response.type("application/json");
			StatusResponse res=productService.deleteProduct(request.params(":id"),dbConnection);
			if(res.equals(StatusResponse.ERROR))
				return new Gson().toJson(new StandardResponse(StatusResponse.ERROR, "400:Product is not deleted."));
			else return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, "200:Product has been deleted successfully"));
		});



	}

}
