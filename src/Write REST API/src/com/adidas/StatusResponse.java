package com.adidas;

public enum StatusResponse {
	SUCCESS("Success"), ERROR("Error"), DUPLICATEPRODUCT("Duplicate product"),
	INFORMATION("Information"),IDNULL("Product id can not be null"),IDNOTPRESENT("Product ID is not present in the DB");

	final private String status;

	StatusResponse(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

}
