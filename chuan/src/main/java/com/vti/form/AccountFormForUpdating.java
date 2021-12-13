package com.vti.form;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class AccountFormForUpdating {
	private String email;
	private String username;
	private String fullname;
	private short departmentId;
	private short positionId;
}
