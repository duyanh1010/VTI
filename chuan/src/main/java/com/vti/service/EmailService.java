package com.vti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.vti.entity.Account;
import com.vti.repository.RegistrationUserTokenRepository;

@Component
@Service
public class EmailService implements IEmailService {

	@Autowired
	private IAccountService accountService;

	@Autowired
	private RegistrationUserTokenRepository registrationUserTokenRepository;

	@Autowired
	private JavaMailSender mailSender;

	/*
	 * @see
	 * com.vti.service.IEmailService#sendRegistrationUserConfirm(java.lang.String)
	 */
	@Override
	public void sendRegistrationUserConfirm(String email) {

		Account account = accountService.getAccountByEmail(email);// lấy lại account vừa insert

		String token = registrationUserTokenRepository.findByUserId(account.getId());// lấy lại token

		String confirmationUrl = "http://localhost:8080/api/v1/accountsRegister/activeUser?token=" + token;

		String subject = "Xác Nhận Đăng Ký Account";
		String content = "Bạn đã đăng ký thành công. Click vào link dưới đây để kích hoạt tài khoản \n"
				+ confirmationUrl;

		sendEmail(email, subject, content);

	}

	private void sendEmail(final String recipientEmail, final String subject, final String content) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(recipientEmail);
		message.setSubject(subject);
		message.setText(content);

		mailSender.send(message);
	}
}
