package com.vti.service;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.vti.entity.Account;
import com.vti.repository.IAccountRepository;
import com.vti.ultis.FileUltis;

@Service
public class FileService implements IFileService {
	@Autowired
	private IAccountRepository accountRepository;

	private FileUltis fileManager = new FileUltis();
	private String linkFolder = "E:\\VTI Academy 2\\Java Advance\\2. Spring\\Lab8,TichHopFrontEnd_Lab3\\Source_Frontend Basic\\img";

	@Override
	public String uploadImage(MultipartFile image, short id) throws IOException {
		String nameImage = new Date().getTime() + "." + fileManager.getFormatFile(image.getOriginalFilename());

		String path = linkFolder + "\\" + nameImage;

		fileManager.createNewMultiPartFile(path, image);

		// TODO save link file to database
		Account account = accountRepository.getById(id);
		account.setPathImage(nameImage);
		accountRepository.save(account);
		// return link uploaded file
		return path;

	}

	@Override
	public File dowwnloadImage(String nameImage) throws IOException {
		String path = linkFolder + "\\" + nameImage;

		return new File(path);

	}

	@Override
	public String getImgNameByID(short id) {
		Account account = accountRepository.getById(id);
		return account.getPathImage();
	}

}
