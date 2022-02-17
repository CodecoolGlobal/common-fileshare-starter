package com.codecool.fileshare.repository;

import com.codecool.fileshare.dto.ImageDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

@Repository
public interface ImageRepository extends JpaRepository<ImageDTO, UUID>{
}
