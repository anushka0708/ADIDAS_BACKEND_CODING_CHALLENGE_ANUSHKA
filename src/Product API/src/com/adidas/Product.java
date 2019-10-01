package com.adidas;

import java.util.HashMap;

public class Product {
	private String id;
	private String name;
	private String model_number;
	private String product_type;
	private HashMap<String, String> meta_data ;
	private HashMap<String, Double> pricing_information ;
	private HashMap<String,String> product_description;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getModel_number() {
		return model_number;
	}
	public void setModel_number(String model_number) {
		this.model_number = model_number;
	}
	public String getProduct_type() {
		return product_type;
	}
	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}
	public HashMap<String, String> getMeta() {
		return meta_data;
	}
	public void setMeta(HashMap<String, String> meta) {
		this.meta_data = meta;
	}
	public HashMap<String, String> getProduct_description() {
		return product_description;
	}
	public void setProduct_description(HashMap<String, String> product_description) {
		this.product_description = product_description;
	}
	public HashMap<String, Double> getPricing_information() {
		return pricing_information;
	}
	public void setPricing_information(HashMap<String, Double> pricing_information) {
		this.pricing_information = pricing_information;
	}
}
