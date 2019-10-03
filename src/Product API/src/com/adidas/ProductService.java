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
				
				if(rs.getString("name")==null)
					productObject.setName("NA");
				else productObject.setName(rs.getString("name"));
				
				if(rs.getString("model_number")==null)
					productObject.setModel_number("NA");
				else productObject.setModel_number(rs.getString("model_number"));
				
				if(rs.getString("product_type")==null)
					productObject.setProduct_type("NA");
				else productObject.setProduct_type(rs.getString("product_type"));

				HashMap<String,String> metaData  = new HashMap<String,String>();
				if(rs.getString("page_title")==null)
					metaData.put("page_title", "NA");
				else metaData.put("page_title", rs.getString("page_title"));
				
				if(rs.getString("site_name")==null)
					metaData.put("site_name","NA");
				else metaData.put("site_name",rs.getString("site_name"));
				
				if(rs.getString("description")==null)
					metaData.put("description","NA");
				else metaData.put("description",rs.getString("description"));
				
				if(rs.getString("keywords")==null)
					metaData.put("keywords","NA");
				else metaData.put("keywords",rs.getString("keywords"));
				
				if(rs.getString("canonical")==null)
					metaData.put("canonical","NA");
				else metaData.put("canonical",rs.getString("canonical"));
				
				productObject.setMeta(metaData);

				HashMap<String,Double> pricingInformation  = new HashMap<String,Double>();
				pricingInformation.put("standard_price",rs.getDouble("standard_price"));
				pricingInformation.put("standard_price_no_vat",rs.getDouble("standard_price_no_vat"));
				pricingInformation.put("currentPrice",rs.getDouble("currentPrice"));
				productObject.setPricing_information(pricingInformation);

				HashMap<String, String> description = new HashMap<String, String>();
				if(rs.getString("title")==null)
					description.put("title","NA");
				else description.put("title",rs.getString("title"));
				
				if(rs.getString("subtitle")==null)
					description.put("subtitle","NA");
				else description.put("subtitle",rs.getString("subtitle"));
				
				if(rs.getString("text")==null)
					description.put("text","NA");
				else description.put("text",rs.getString("text"));
				
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
				
				if(rs.getString("name")==null)
					productObject.setName("NA");
				else productObject.setName(rs.getString("name"));
				
				if(rs.getString("model_number")==null)
					productObject.setModel_number("NA");
				else productObject.setModel_number(rs.getString("model_number"));
				
				if(rs.getString("product_type")==null)
					productObject.setProduct_type("NA");
				else productObject.setProduct_type(rs.getString("product_type"));

				HashMap<String,String> metaData  = new HashMap<String,String>();
				if(rs.getString("page_title")==null)
					metaData.put("page_title", "NA");
				else metaData.put("page_title", rs.getString("page_title"));
				
				if(rs.getString("site_name")==null)
					metaData.put("site_name","NA");
				else metaData.put("site_name",rs.getString("site_name"));
				
				if(rs.getString("description")==null)
					metaData.put("description","NA");
				else metaData.put("description",rs.getString("description"));
				
				if(rs.getString("keywords")==null)
					metaData.put("keywords","NA");
				else metaData.put("keywords",rs.getString("keywords"));
				
				if(rs.getString("canonical")==null)
					metaData.put("canonical","NA");
				else metaData.put("canonical",rs.getString("canonical"));
				
				productObject.setMeta(metaData);

				HashMap<String,Double> pricingInformation  = new HashMap<String,Double>();
				pricingInformation.put("standard_price",rs.getDouble("standard_price"));
				pricingInformation.put("standard_price_no_vat",rs.getDouble("standard_price_no_vat"));
				pricingInformation.put("currentPrice",rs.getDouble("currentPrice"));
				productObject.setPricing_information(pricingInformation);

				HashMap<String, String> description = new HashMap<String, String>();
				if(rs.getString("title")==null)
					description.put("title","NA");
				else description.put("title",rs.getString("title"));
				
				if(rs.getString("subtitle")==null)
					description.put("subtitle","NA");
				else description.put("subtitle",rs.getString("subtitle"));
				
				if(rs.getString("text")==null)
					description.put("text","NA");
				else description.put("text",rs.getString("text"));
				
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
