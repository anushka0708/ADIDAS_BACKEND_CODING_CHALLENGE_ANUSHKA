package com.adidas;

public enum StatusResponse {
	SUCCESS("Success"), ERROR("Error"), DUPLICATEPRODUCT("Duplicate product"),INFORMATION("Information");

	final private String status;

	StatusResponse(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

}
