package com.vti.backend;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Exercise4 {
	public static String readFile(String pathFile) throws Exception {
		if (!Exercise3FileManager.isFileExists(pathFile)) {
			throw new Exception(Exercise3FileManager.FILE_NOT_EXISTS);
		}
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(pathFile);
			byte[] b = new byte[1024];
			int length = fileInputStream.read(b);
			String content = "";
			while (length > -1) {
				content = new String(b, 0, length);
				length = fileInputStream.read(b);
			}

			return content;

		} finally {
			fileInputStream.close();
		}
	}

	public static void writeFile(String pathFile, String content, boolean isContinuing) throws Exception {

		if (!Exercise3FileManager.isFileExists(pathFile)) {
			throw new Exception(Exercise3FileManager.FILE_NOT_EXISTS);
		}

		FileOutputStream fileOutputStream = null;

		try {

			fileOutputStream = new FileOutputStream(pathFile, isContinuing);
			fileOutputStream.write(content.getBytes());

		} finally {

			fileOutputStream.close();
		}
	}

	public static Object readObject(String pathFile) throws Exception {

		if (!Exercise3FileManager.isFileExists(pathFile)) {
			throw new Exception(Exercise3FileManager.FILE_NOT_EXISTS);
		}

		FileInputStream fileInputStream = null;
		ObjectInputStream objectInputStream = null;

		try {
			fileInputStream = new FileInputStream(new File(pathFile));
			objectInputStream = new ObjectInputStream(fileInputStream);

			return objectInputStream.readObject();

		} finally {

			fileInputStream.close();
			objectInputStream.close();
		}
	}

	public static void writeObject(Object object, String pathFile) throws Exception {

		FileOutputStream fileOutputStream = null;
		ObjectOutputStream objectOutputStream = null;

		try {
			fileOutputStream = new FileOutputStream(pathFile);
			objectOutputStream = new ObjectOutputStream(fileOutputStream);

			objectOutputStream.writeObject(object);

		} finally {

			fileOutputStream.close();
			objectOutputStream.close();
		}
	}

}
