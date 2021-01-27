package com.api.image.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.api.image.exception.FailedException;

@Service
public class ImageStorageService {

	// définer le path qui on a save notre images
	@Value("${upload.path}")
	private String path;

	// ***************** Saving Image in Server *****************
	public String saveFileOfImage(MultipartFile image, String imageName) throws IOException {

		if (imageName == null)
			throw new FailedException("Image Name is Null");

		Path imagePath = Paths.get(path + imageName);

		// stoker dans serveur
		Files.copy(image.getInputStream(), imagePath, StandardCopyOption.REPLACE_EXISTING);
		return imageName;
	}

	// ***************** Displaying Image *****************
	public byte[] readFileOfImage(String imageName) throws IOException {

		if (imageName == null)
			throw new FailedException("Image Name is Null");

		Path imagePath = Paths.get(path + imageName);
		return Files.readAllBytes(imagePath);
	}

	// ***************** Deleting Image *****************
	/*
	 * public void deleteFileToImage(String imageName) throws IOException { if
	 * (imageName == null) throw new FailedException("Image Name is Null");
	 * 
	 * Path imagePath = Paths.get(path + imageName); Files.delete(imagePath); }
	 */
}
