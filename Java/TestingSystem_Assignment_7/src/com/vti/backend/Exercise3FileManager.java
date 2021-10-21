package com.vti.backend;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.util.Scanner;

import com.vti.entity.ScannerUtils;

public class Exercise3FileManager {
	public static final String FILE_EXISTS = "File is exits!";
	public static final String FILE_NOT_EXISTS = "Error! File Not Exist.";
	public static final String FOLDER_EXISTS = "Folder is exits!";
	public static final String FOLDER_NOT_EXISTS = "Folder is not exits!";
	public static final String PATH_NOT_FOLDER = "Error! Path is not folder.";
	public static final String SOURCE_FILE_NOT_EXISTS = "Source File is not exits!";
	public static final String DESTINATION_FILE_EXISTS = "Destination File is exits!";
	public static final String NEW_FILE_EXISTS = "Error! New File Exist.";
	public static final String CREATE_FILE_SUCCESS = "Create file success!";
	public static final String CREATE_FILE_FAIL = "Create file fail!";
	public static final String DELETE_FILE_SUCCESS = "Delete file success!";
	public static final String DELETE_FILE_FAIL = "Delete file fail!";
	public static void Question1() {

//	Question 1: Check File is exists

		System.out.println("Moi ban nhap vao duong dan 1 file");
		String str = ScannerUtils.inputString();

		File file = new File(str);
		if (file.exists()) {
			System.out.println("file co ton tai");
		} else {
			System.out.println("file nay khong ton tai");
		}
	}
	//c2 check file
	public static boolean isFileExists(String pathFile) {
		return new File(pathFile).exists() ? true : false;
	}
	// check foder
	public static boolean isFolderExists(String pathFolder) {
		return new File(pathFolder).exists() ? true : false;
	}
	// Question 2: Create new file
	public static void Question2()   {
		try {
			System.out.println("Moi ban nhap vao duong dan 1 file");
			String str = ScannerUtils.inputString();
			File file = new File(str);
			if (file.exists()) {
				throw new Exception("Error! File Exist.");
			} else {
				file.createNewFile();
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	// Question 4: Delete file
	public static void Question4() throws Exception {
		System.out.println("Moi ban nhap vao duong dan 1 file");
		String str = ScannerUtils.inputString();
		File file = new File(str);
		if (file.exists()) {
			file.delete();
			System.out.println("Delete successfully!");
		} else {
			throw new Exception("Error! file not exist");
		}
	}
	// Question5: Check path is File or Folder
	public static void Question5() {
		System.out.println("Moi ban nhap vao duong dan 1 file");
		String str = ScannerUtils.inputString();
		File file = new File(str);
		System.out.println(file.isDirectory() ? "Path is Folder" : "Path is file");
	}

	// Question 6: Get all File name of Folder
	public static void Question6() {
		System.out.println("Moi ban nhap vao duong dan ");
		String str = ScannerUtils.inputString();
		File file = new File(str);
		for (String li : file.list()) {
			System.out.println(li);
		}
	}
// Question 7: Copy File cho tryen tham so k nhap nua 
	public static void copyFile(String sourceFile, String destinationPath) throws Exception {

		if (!isFileExists(sourceFile)) {
			throw new Exception(SOURCE_FILE_NOT_EXISTS);
		}
		String[] s = sourceFile.split("/");
		String nameFile = s[s.length - 1];
		String destinationFile = destinationPath + "//" + nameFile;
		if (isFileExists(destinationFile)) {
			throw new Exception(DESTINATION_FILE_EXISTS);
		}
		File source = new File(sourceFile);
		File dest = new File(destinationPath);
		Files.copy(source.toPath(), dest.toPath());
	}
	// Question 8: Moving file
		public static void moveFile(String sourceFile, String destinationPath) throws Exception {

			if (!isFileExists(sourceFile)) {
				throw new Exception(SOURCE_FILE_NOT_EXISTS);
			}
			File source = new File(sourceFile);
			File dest = new File(destinationPath);
			Files.move(source.toPath(), dest.toPath());
		}

		// Question 9: Rename File
		public static void renameFile(String pathFile, String newName) throws Exception {

			if (!isFileExists(pathFile)) {
				throw new Exception(FILE_NOT_EXISTS);
			}
			if (isFileExists(newName)) {
				throw new Exception(NEW_FILE_EXISTS);
			}
			File oldFile = new File(pathFile);
			File newFile = new File(newName);
			oldFile.renameTo(newFile);
		}

		// Question 10: Create new folder
		public static void createNewFolder(String newPathFolder) throws Exception {

			if (isFolderExists(newPathFolder)) {
				throw new Exception(FOLDER_EXISTS);
			}

			new File(newPathFolder).mkdir();
		}

		// Question 11: Download File
		public static void downloadFile(String fileLink, String pathFolder) throws Exception {

			if (!isFolderExists(pathFolder)) {
				createNewFolder(pathFolder);
			}

			// get name file
			String s[] = fileLink.split("/");
			String name = s[s.length - 1];

			String pathFile = pathFolder + "/" + name;

			// connect to URL
			URL url = new URL(fileLink);
			URLConnection connection = url.openConnection();

			// get size of file
			int size = connection.getContentLength();

			// read file from internet
			InputStream inputStream = connection.getInputStream();

			// save file
			FileOutputStream output = new FileOutputStream(pathFile);
			int byteDownload = 0;
			byte[] b = new byte[1024];
			// get length
			int length = inputStream.read(b);
			while (length != -1) {

				byteDownload += length;
				System.out.println(byteDownload * 100f / size + "%");

				// write content downloaded from 0 -> length to ouput
				output.write(b, 0, length);
				length = inputStream.read(b);
			}
			output.close();
			inputStream.close();
			System.out.println("Download success");
		}

}
