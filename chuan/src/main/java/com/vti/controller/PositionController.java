package com.vti.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.DTO.PositionDTO;
import com.vti.entity.Position;
import com.vti.service.IPossitionService;

@RestController
@RequestMapping(value = "api/v1/positions")
@CrossOrigin("*") // phân quyền, những ứng dụng nào có thể vào được đường link trên
public class PositionController {
	@Autowired
	private IPossitionService service;

	@GetMapping() // Get lấy dữ liệu
	public ResponseEntity<?> getAllPossition() {
		List<Position> entities = service.getAllPosition();
		List<PositionDTO> dtos = new ArrayList<>();
		for (Position entity : entities) {
			PositionDTO dto = new PositionDTO(entity.getId(), entity.getName().toString());
			dtos.add(dto);
		}
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
}
