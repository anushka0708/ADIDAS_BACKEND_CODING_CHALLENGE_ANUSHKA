package com.adidas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.sql.*;
import com.adidas.Product;
import com.adidas.Connect;
public class ProductService{

	public Product getProduct(String productID,Connect c) {
		Connection con = c.dbConnection;
		Product productObject = new Product();
		try {
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from product where id = '"+productID+"'");

			while(rs.next()) {
				productObject.setId(rs.getString("id"));
				productObject.setName(rs.getString("name"));
				productObject.setModel_number(rs.getString("model_number"));
				productObject.setProduct_type(rs.getString("product_type"));

				HashMap<String,String> metaData  = new HashMap<String,String>();
				metaData.put("page_title", rs.getString("meta_title"));
				metaData.put("site_name",rs.getString("site_name"));
				metaData.put("description",rs.getString("description"));
				metaData.put("keywords",rs.getString("keywords"));
				metaData.put("canonical",rs.getString("canonical"));
				productObject.setMeta(metaData);

				HashMap<String,Double> pricingInformation  = new HashMap<String,Double>();
				pricingInformation.put("standard_price",rs.getDouble("standard_price"));
				pricingInformation.put("standard_price_no_vat",rs.getDouble("standard_price_no_vat"));
				pricingInformation.put("currentPrice",rs.getDouble("currentPrice"));
				productObject.setPricing_information(pricingInformation);

				HashMap<String, String> description = new HashMap<String, String>();
				description.put("title",rs.getString("description_title"));
				description.put("subtitle",rs.getString("subtitle"));
				description.put("text",rs.getString("text"));
				productObject.setProduct_description(description);
				return productObject;
			}
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	public Collection<Product> getProducts(Connect c) {
		final Collection<Product> products = new ArrayList<>();;
		Connection con = c.dbConnection;
		try {
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from product");  
			while(rs.next()) {    			
				Product productObject = new Product();

				productObject.setId(rs.getString("id"));
				productObject.setName(rs.getString("name"));
				productObject.setModel_number(rs.getString("model_number"));
				productObject.setProduct_type(rs.getString("product_type"));

				HashMap<String,String> metaData  = new HashMap<String,String>();
				metaData.put("page_title", rs.getString("meta_title"));
				metaData.put("site_name",rs.getString("site_name"));
				metaData.put("description",rs.getString("description"));
				metaData.put("keywords",rs.getString("keywords"));
				metaData.put("canonical",rs.getString("canonical"));
				productObject.setMeta(metaData);

				HashMap<String,Double> pricingInformation  = new HashMap<String,Double>();
				pricingInformation.put("standard_price",rs.getDouble("standard_price"));
				pricingInformation.put("standard_price_no_vat",rs.getDouble("standard_price_no_vat"));
				pricingInformation.put("currentPrice",rs.getDouble("currentPrice"));
				productObject.setPricing_information(pricingInformation);

				HashMap<String, String> description = new HashMap<String, String>();
				description.put("title",rs.getString("description_title"));
				description.put("subtitle",rs.getString("subtitle"));
				description.put("text",rs.getString("text"));
				productObject.setProduct_description(description);

				products.add(productObject);
			}
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();

		} catch(SQLException e ) {
			e.printStackTrace();
			return null;
		}

		return products;
	}

}
