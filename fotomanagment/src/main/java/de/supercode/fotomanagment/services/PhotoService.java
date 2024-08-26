package de.supercode.fotomanagment.services;

import de.supercode.fotomanagment.model.Photo;
import de.supercode.fotomanagment.repository.PhotoRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PhotoService {
    PhotoRepository photoRepository;

    public PhotoService(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    public void addPhoto(Photo photo) {
        photoRepository.addPhoto(photo);
    }

    public ArrayList<Photo> getAllPhotos() {
        return photoRepository.getAllPhotos();
    }

    public ArrayList<Photo> getPhoto(String fileName ){
        return new ArrayList<Photo>(List.of(photoRepository.getPhoto(fileName)));
    }

    public Photo updatePhoto(String fileName, Photo photo) {
        return photoRepository.updatePhoto(fileName, photo);
    }

    public void deletePhoto(String fileName) {
        photoRepository.deletePhoto(fileName);
    }

    public Photo findbyPhotoName(String fileName){
        return photoRepository.findbyPhotoName(fileName);
    }

    public List<Photo> filterbyType(String typeName) {
        return photoRepository.filterbyType(typeName);
    }
    public List<Photo> filterbySize(boolean ascending){
        return photoRepository.filterbySize(ascending);
    }
    public List<Photo> filterbyPath(String path){
        return photoRepository.filterbyPath(path);
    }
}
