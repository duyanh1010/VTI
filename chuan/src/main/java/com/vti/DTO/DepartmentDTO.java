package com.vti.DTO;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class DepartmentDTO {
	private short id;

	private String name;

	public DepartmentDTO(short id, String name) {
		this.id = id;
		this.name = name;
	}

	public DepartmentDTO(String name) {
		super();
		this.name = name;
	}

}
