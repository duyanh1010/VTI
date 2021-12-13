package com.vti.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.DTO.DepartmentDTO;
import com.vti.entity.Department;
import com.vti.form.DepartmentFormForCreating;
import com.vti.form.DepartmentFormForUpdating;
import com.vti.service.IDepartmentService;

@RestController
@RequestMapping(value = "api/v1/departments")
@CrossOrigin("*") // phân quyền, những ứng dụng nào có thể vào được đường link trên
public class DepartmentController {
	@Autowired
	private IDepartmentService service;

	@GetMapping() // Get lấy dữ liệu
	public ResponseEntity<?> getAllDepartments() {
		List<Department> entities = service.getAllDepartments();
		List<DepartmentDTO> dtos = new ArrayList<>();
		// convert entities --> dtos
		for (Department entity : entities) {
			DepartmentDTO dto = new DepartmentDTO(entity.getId(), entity.getName());
			dtos.add(dto);
		}
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}

//	Lấy department theo ID 
	@GetMapping(value = "/{id}") // Get lấy dữ liệu
	public ResponseEntity<?> getDepartmentByID(@PathVariable(name = "id") short id) {
		return new ResponseEntity<Department>(service.getDepartmentByID(id), HttpStatus.OK);
	}

//	Lấy department theo Tên
	@GetMapping(value = "/name/{name}") // Get lấy dữ liệu
	public ResponseEntity<?> getDepartmentByName(@PathVariable(name = "name") String name) {
		return new ResponseEntity<Department>(service.getByName(name), HttpStatus.OK);
	}

//	Tạo mới Department
	@PostMapping // Post là tạo mới
	public ResponseEntity<?> createDepartment(@RequestBody DepartmentFormForCreating form) {
		service.createDepartment(form);
		return new ResponseEntity<String>("Tạo thành công!!!", HttpStatus.CREATED);
	}

//	Update department
	@PutMapping(value = "/{id}") // Put là update
	public ResponseEntity<?> updateDepartment(@PathVariable(name = "id") short id,
			@RequestBody DepartmentFormForUpdating form) {
		service.updateDepartment(id, form);
		return new ResponseEntity<String>("Sửa thành công!!!", HttpStatus.OK);
	}

//	Xoá Department
	@DeleteMapping(value = "/{id}") // Delete là để xoá
	public ResponseEntity<?> deleteDepartment(@PathVariable(name = "id") short id) {
		service.deleteDepartment(id);
		return new ResponseEntity<String>("Xoá thành công!!!", HttpStatus.OK);
	}

}
