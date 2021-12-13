package com.vti.DTO;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class LoginInforDTO {
	private short id;

	private String fullName;
	
	private String role;

	private String status;
	
	public LoginInforDTO(short id, String fullName, String role, String status) {
		this.id = id;
		this.fullName = fullName;
		this.role = role;
		this.status = status;
	}

	public LoginInforDTO() {
		super();
	}

}
