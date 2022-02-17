package com.codecool.fileshare.dto;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table
public class ImageDTO {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    String category;
    @Lob
    @Type(type = "org.hibernate.type.BinaryType")
    @Column(name = "content")
    private byte[] content;
    String extension;

    public ImageDTO() {
    }

    public ImageDTO(String category, byte[] content, String extension) {
        this.category = category;
        this.content = content;
        this.extension = extension;
    }

    public ImageDTO(UUID id, String category, byte[] content, String extension) {
        this.id = id;
        this.category = category;
        this.content = content;
        this.extension = extension;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
}
