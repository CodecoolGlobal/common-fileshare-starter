package com.codecool.fileshare.repository;

import com.codecool.fileshare.dto.ImageDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ImageRepository extends JpaRepository<ImageDTO, UUID>{
    @Query("select content from ImageDTO where id = ?1 ")
    byte[] getByteById(UUID id);
}
