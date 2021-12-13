package com.vti.DTO;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class PositionDTO {
	private short id;

	private String name;

	public PositionDTO(short id, String name) {
		this.id = id;
		this.name = name;
	}

	public PositionDTO(String name) {
		super();
		this.name = name;
	}
}
