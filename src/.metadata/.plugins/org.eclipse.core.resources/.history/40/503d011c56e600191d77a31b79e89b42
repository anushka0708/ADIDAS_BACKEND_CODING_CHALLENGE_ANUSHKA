package com.adidas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.HashMap;
public class ProductService{

	public StatusResponse addProduct(Product product,Connect c) {
		Connection con = c.dbConnection;
		if(product.getId()==null|| product.getId()=="" || product.getId().length()==0)
			return StatusResponse.IDNULL;

		try {

			String query = " insert into product (id,name, model_number, product_type, standard_price,standard_price_no_vat,"
					+ "currentPrice,page_title,title,subtitle,text,site_name,description,"
					+ "canonical,keywords)"
					+ " values (?, ?, ?, ?, ?,?,?,?, ?, ?, ?, ?,?,?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setString(1,product.getId());
			preparedStmt.setString(2,product.getName());
			preparedStmt.setString(3,product.getModel_number());
			preparedStmt.setString(4,product.getProduct_type());
			if(product.getPricing_information().get("standard_price")==null)
				preparedStmt.setDouble(5,0);
			else preparedStmt.setDouble(5,product.getPricing_information().get("standard_price"));
			if(product.getPricing_information().get("standard_price_no_vat")==null)
				preparedStmt.setDouble(6,0);
			else preparedStmt.setDouble(6,product.getPricing_information().get("standard_price_no_vat"));
			if(product.getPricing_information().get("currentPrice")==null)
				preparedStmt.setDouble(7,0);
			else preparedStmt.setDouble(7,product.getPricing_information().get("currentPrice"));		
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
		catch(Exception e){
			e.printStackTrace();
			return StatusResponse.ERROR;
		}
		return StatusResponse.SUCCESS;

	}

	public StatusResponse updateProduct(Product product,Connect c) {

		if(product.getId()==null|| product.getId()=="" || product.getId().length()==0)
			return StatusResponse.IDNULL;
		Connection con = c.dbConnection;
		try {			

			String query = " update product set id=? ,name=? , model_number=? , product_type=? , standard_price=? ,standard_price_no_vat=? ,"
					+ "currentPrice=? ,page_title=? ,title=? ,subtitle=? ,text=? ,site_name=? ,description=? ,"
					+ "canonical=? ,keywords=? where id= '" + product.getId() +"'";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setString(1,product.getId());
			preparedStmt.setString(2,product.getName());
			preparedStmt.setString(3,product.getModel_number());
			preparedStmt.setString(4,product.getProduct_type());
			if(product.getPricing_information().get("standard_price")==null)
				preparedStmt.setDouble(5,0);
			else preparedStmt.setDouble(5,product.getPricing_information().get("standard_price"));
			if(product.getPricing_information().get("standard_price_no_vat")==null)
				preparedStmt.setDouble(6,0);
			else preparedStmt.setDouble(6,product.getPricing_information().get("standard_price_no_vat"));
			if(product.getPricing_information().get("currentPrice")==null)
				preparedStmt.setDouble(7,0);
			else preparedStmt.setDouble(7,product.getPricing_information().get("currentPrice"));
			preparedStmt.setString(8,product.getMeta().get("page_title"));
			preparedStmt.setString(9,product.getProduct_description().get("title"));
			preparedStmt.setString(10,product.getProduct_description().get("subtitle"));
			preparedStmt.setString(11,product.getProduct_description().get("text"));
			preparedStmt.setString(12,product.getMeta().get("site_name"));
			preparedStmt.setString(13,product.getMeta().get("description"));
			preparedStmt.setString(14,product.getMeta().get("canonical"));
			preparedStmt.setString(15,product.getMeta().get("keywords"));
			preparedStmt.execute();					

		} catch (SQLException e) {
			e.printStackTrace();
			return StatusResponse.ERROR;			
		}
		catch(Exception e){
			e.printStackTrace();
			return StatusResponse.ERROR;
		}

		return StatusResponse.SUCCESS;

	}


	public StatusResponse deleteProduct(String productID,Connect c) {
		Connection con = c.dbConnection;
		try {
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from product where id = '"+productID+"'");
			while(rs.next()){
				String query = " DELETE FROM product where id = '"+productID+"'";
				PreparedStatement preparedStmt = con.prepareStatement(query);
				preparedStmt.execute();
				return StatusResponse.SUCCESS;
			}			
		}  catch (SQLException e) {
			e.printStackTrace();
			return StatusResponse.ERROR;			
		}
		catch(Exception e){
			e.printStackTrace();
			return StatusResponse.ERROR;
		}
		return StatusResponse.IDNOTPRESENT;

	}

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
				metaData.put("page_title", rs.getString("page_title"));
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
				description.put("title",rs.getString("title"));
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

}
