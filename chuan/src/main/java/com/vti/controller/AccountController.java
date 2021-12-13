package com.vti.controller;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.DTO.AccountDTO;
import com.vti.entity.Account;
import com.vti.form.AccountFormForCreating;
import com.vti.form.AccountFormForUpdating;
import com.vti.service.IAccountService;

@RestController
@RequestMapping(value = "api/v1/accounts")
@CrossOrigin("*") // phÃ¢n quyá»�n, nhá»¯ng á»©ng dá»¥ng nÃ o cÃ³ thá»ƒ vÃ o Ä‘Æ°á»£c Ä‘Æ°á»�ng link trÃªn
public class AccountController {
	@Autowired
	private IAccountService service;

	@GetMapping() // Get láº¥y dá»¯ liá»‡u
	public ResponseEntity<?> getAllAccount(Pageable pageable, @RequestParam(required = false) String search) {
		Page<Account> entitiesPage = service.getAllAccount(pageable, search);

//		chuyá»ƒn Ä‘á»•i DTO sang Page https://stackoverflow.com/questions/39036771/how-to-map-pageobjectentity-to-pageobjectdto-in-spring-data-rest

		Page<AccountDTO> dtoPage = entitiesPage.map(new Function<Account, AccountDTO>() {
			@Override
			public AccountDTO apply(Account entity) {
				// convert entities --> dtos
					AccountDTO dto = new AccountDTO(entity.getId(), entity.getEmail(), entity.getUsername(),
							entity.getFullname(), entity.getDepartment().getName(),
							entity.getPosition().getName().toString(), entity.getCreateDate());
				
				return dto;
			}
		});
		return new ResponseEntity<>(dtoPage, HttpStatus.OK);
	}

//	Láº¥y department theo ID 
	@GetMapping(value = "/{id}") // Get láº¥y dá»¯ liá»‡u
	public ResponseEntity<?> getAccountById(@PathVariable(name = "id") short id) {
		Account account = service.getAccountById(id);
		AccountDTO dto = new AccountDTO(account.getId(), account.getEmail(), account.getUsername(),
				account.getFullname(), account.getDepartment().getName(), account.getPosition().getName().toString(),
				account.getCreateDate());
		return new ResponseEntity<AccountDTO>(dto, HttpStatus.OK);
	}

//	Láº¥y department theo TÃªn
//	@GetMapping(value = "/name/{name}") // Get láº¥y dá»¯ liá»‡u
//	public ResponseEntity<?> getAccountByName(@PathVariable(name = "name") String name) {
//		return new ResponseEntity<Account>(service.getAccountByName(name), HttpStatus.OK);
//	}

//	Táº¡o má»›i Department
	@PostMapping // Post lÃ  táº¡o má»›i
	public ResponseEntity<?> createAccount(@RequestBody AccountFormForCreating form) {
		service.createAccount(form);
		return new ResponseEntity<String>("Táº¡o thÃ nh cÃ´ng!!!", HttpStatus.CREATED);
	}

//	Update department
	@PutMapping(value = "/{id}") // Put lÃ  update
	public ResponseEntity<?> updateAccount(@PathVariable(name = "id") short id,
			@RequestBody AccountFormForUpdating form) {
		service.updateAccount(id, form);
		return new ResponseEntity<String>("Sá»­a thÃ nh cÃ´ng!!!", HttpStatus.OK);
	}

//	XoÃ¡ Department
	@DeleteMapping(value = "/{id}") // Delete lÃ  Ä‘á»ƒ xoÃ¡
	public ResponseEntity<?> deleteAccount(@PathVariable(name = "id") short id) {
		service.deleteAccount(id);
		return new ResponseEntity<String>("XoÃ¡ thÃ nh cÃ´ng!!!", HttpStatus.OK);
	}
	
	@GetMapping(value = "/UsernameExists/{name}")
	public ResponseEntity<?> existsByName(@PathVariable(name = "name") String name) {
	return new ResponseEntity<>(service.existsByUsername(name),
	HttpStatus.OK);
	}
	@GetMapping(value = "/EmailExists/{email}")
	public ResponseEntity<?> existsByEmail(@PathVariable(name = "email") String email) {
	return new ResponseEntity<>(service.existsByEmail(email), HttpStatus.OK);
	}

}
