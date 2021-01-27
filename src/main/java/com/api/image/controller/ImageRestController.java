package com.api.image.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.api.image.entity.Image;
import com.api.image.service.ImageService;
import com.api.image.service.ImageStorageService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ImageRestController {

	@Autowired
	private ImageStorageService fileRepositoryService;

	@Autowired
	private ImageService imageService;

	// ********************* Get Images (Download) *******************

	@GetMapping(path = "/getImage/{imageName}", produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] getFile(@PathVariable("imageName") String imageName) throws IOException {

		return fileRepositoryService.readFileOfImage(imageName);
	}

	// ********************* Post Images (Upload) *********************

	@PostMapping("/postImage")
	public String uploadImageOther(@RequestParam("image") MultipartFile fileImg) throws IOException {

		String imageName = fileImg.getOriginalFilename();

		Image image = new Image();
		image.setName(imageName);
		imageService.saveImage(image);
		fileRepositoryService.saveFileOfImage(fileImg, imageName);

		return imageName;
	}

}
