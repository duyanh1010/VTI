package com.vti.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.DTO.LoginInforDTO;
import com.vti.entity.Account;
import com.vti.service.IAccountService;

@RestController
@RequestMapping(value = "api/v1/login")
@CrossOrigin("*")
//bỏ lỗi bảo mật, cho chạy trên cả link local, postman,...vs code
public class LoginController {
	@Autowired
	private IAccountService service;

	@GetMapping()
	public ResponseEntity<?> login(Principal principal) {
		String username = principal.getName();
		Account entity = service.getAccountByUsername(username);

		LoginInforDTO loginInforDTO = new LoginInforDTO(entity.getId(), entity.getFullname(), entity.getRole(), entity.getStatus().toString());
		return new ResponseEntity<>(loginInforDTO, HttpStatus.OK);
	}

}
