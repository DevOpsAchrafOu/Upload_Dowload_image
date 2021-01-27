package com.api.image.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.image.dao.ImageRepository;
import com.api.image.entity.Image;

@Service
public class ImageServiceImpl implements ImageService {

	@Autowired
	private ImageRepository imageRepository;

	// ************* Save Image in Table of BD ***************
	@Override
	public Image saveImage(Image image) {
		if (imageRepository.findByName(image.getName()).isPresent()) {
			return imageRepository.findByName(image.getName()).get();
		} else {
			return imageRepository.save(image);
		}
	}

	// ************* Upload Image in Table of BD ***************
	@Override
	public Image updateImageName(String name, Long id) {
		if (imageRepository.findByName(name).isPresent()) {
			return null;
		} else {
			Image image = imageRepository.findById(id).get();
			image.setName(name);
			return imageRepository.save(image);
		}
	}

}
