package com.adidas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
public class ProductService{

	public StatusResponse addProduct(Product product,Connect c) {
		Connection con = c.dbConnection;
		try {

			String query = " insert into product (id,name, model_number, product_type, standard_price,standard_price_no_vat,"
					+ "currentPrice,meta_title,description_title,subtitle,text,site_name,description,"
					+ "canonical,keywords)"
					+ " values (?, ?, ?, ?, ?,?,?,?, ?, ?, ?, ?,?,?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setString(1,product.getId());
			preparedStmt.setString(2,product.getName());
			preparedStmt.setString(3,product.getModel_number());
			preparedStmt.setString(4,product.getProduct_type());
			preparedStmt.setDouble(5,product.getPricing_information().get("standard_price"));
			preparedStmt.setDouble(6,product.getPricing_information().get("standard_price_no_vat"));	
			preparedStmt.setDouble(7,product.getPricing_information().get("currentPrice"));		
			preparedStmt.setString(8,product.getMeta().get("page_title"));
			preparedStmt.setString(9,product.getProduct_description().get("title"));
			preparedStmt.setString(10,product.getProduct_description().get("subtitle"));
			preparedStmt.setString(11,product.getProduct_description().get("text"));
			preparedStmt.setString(12,product.getMeta().get("site_name"));
			preparedStmt.setString(13,product.getMeta().get("description"));
			preparedStmt.setString(14,product.getMeta().get("canonical"));
			preparedStmt.setString(15,product.getMeta().get("keywords"));
			preparedStmt.execute();			

		} 
		catch(SQLIntegrityConstraintViolationException e){
			e.printStackTrace();
			return StatusResponse.DUPLICATEPRODUCT;
		}
		catch (SQLException e) {
			e.printStackTrace();
			return StatusResponse.ERROR;			
		}
		return StatusResponse.SUCCESS;

	}

	public StatusResponse updateProduct(Product product,Connect c) {
		Connection con = c.dbConnection;
		try {

			String query = " update product set id = '" + product.getId() + "',name = '" + product.getName() + "', model_number ='" + product.getModel_number() + 
					"', product_type='" + product.getProduct_type()+ "', standard_price='" + product.getPricing_information().get("standard_price") + "',standard_price_no_vat='" + 
					product.getPricing_information().get("standard_price_no_vat") + "',currentPrice='" + product.getPricing_information().get("currentPrice")+ "',meta_title='" + product.getMeta().get("page_title") + 
					"',description_title='" + product.getProduct_description().get("title") + "',subtitle='" + product.getProduct_description().get("subtitle")+ 
					"',text='" + product.getProduct_description().get("text")+ "',site_name='" + product.getMeta().get("site_name")
					+"',description='" + product.getMeta().get("description") + "',canonical='" + product.getMeta().get("canonical") + "',keywords='" +
					product.getMeta().get("keywords") +"' where id= '" + product.getId() + "'";

			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.execute();			

		} catch (SQLException e) {
			e.printStackTrace();
			return StatusResponse.ERROR;			
		}
		return StatusResponse.SUCCESS;

	}


	public StatusResponse deleteProduct(String productID,Connect c) {
		Connection con = c.dbConnection;
		try {
			String query = " DELETE FROM product where id = '"+productID+"'";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.execute();
		}  catch (SQLException e) {
			e.printStackTrace();
			return StatusResponse.ERROR;			
		}
		return StatusResponse.SUCCESS;

	}


}
