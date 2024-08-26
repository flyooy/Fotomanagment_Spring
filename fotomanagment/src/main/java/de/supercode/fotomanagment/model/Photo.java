package de.supercode.fotomanagment.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Photo {
    private long id;
    private String fileName;
    private long size;
    private LocalDateTime createdDate;
    private String fileType;
    private String path;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Photo photo = (Photo) o;
        return id == photo.id && size == photo.size && Objects.equals(fileName, photo.fileName) && Objects.equals(createdDate, photo.createdDate) && Objects.equals(fileType, photo.fileType) && Objects.equals(path, photo.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fileName, size, createdDate, fileType, path);
    }
}
