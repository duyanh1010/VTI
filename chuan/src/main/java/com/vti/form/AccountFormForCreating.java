package com.vti.form;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class AccountFormForCreating {
	private String email;
	private String username;
	private String fullname;
	private String password = "$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi";
	private short departmentId;
	private short positionId;
}

