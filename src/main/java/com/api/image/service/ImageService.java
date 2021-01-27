package com.api.image.service;

import com.api.image.entity.Image;

public interface ImageService {

	public Image saveImage(Image photo);

	public Image updateImageName(String name, Long id);
}
