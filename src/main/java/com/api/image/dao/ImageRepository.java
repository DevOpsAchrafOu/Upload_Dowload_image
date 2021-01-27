package com.api.image.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.image.entity.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
	public Optional<Image> findByName(String name);
}
