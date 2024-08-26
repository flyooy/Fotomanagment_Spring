package de.supercode.fotomanagment.repository;

import de.supercode.fotomanagment.model.Photo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Component
public class PhotoRepository {
    public static long actualid = 0;
    public ArrayList<Photo> photos = new ArrayList<>();

    public PhotoRepository(){
        this.photos = new ArrayList<>();
    }

    public void addPhoto(Photo newPhoto){
        List<Photo> dublicatePhotosByName = photos.stream()
                        .filter(photo->photo.getFileName().equals(newPhoto.getFileName()))
        .collect(Collectors.toList());
         if(!dublicatePhotosByName.isEmpty()) {throw new IllegalArgumentException("Duplikat erkannt basierend auf dem Dateinamen: " + newPhoto.getFileName());}
        newPhoto.setId(actualid++);
        this.photos.add(newPhoto);
    }

    public Photo getPhoto(String fileName){
        return this.photos.stream().filter(photo->photo.getFileName().equals(fileName)).findFirst().orElseThrow();
    }

    public ArrayList<Photo> getAllPhotos(){
        return this.photos;
    }

    public Photo updatePhoto(String fileName,Photo newPhoto){
        int photoIndex = IntStream.range(0,photos.size())
                .filter(i -> photos.get(i).getFileName().equals(fileName)).findFirst().orElse(-1);
        if (photoIndex != -1) {
            photos.set(photoIndex, newPhoto);
            return newPhoto;
        }
        return null;
    }

    public void deletePhoto(String fileName){
        Photo photo = getPhoto(fileName);
        if(photo != null){
           photos.remove(photo);
        }
    }

    public Photo findbyPhotoName(String fileName){
        return photos.stream().filter(photo->photo.getFileName().equals(fileName)).findFirst().orElse(null);
    }

    public List<Photo> filterbyType(String typeName){
        return photos.stream().filter(photo->photo.getFileType().equals(typeName)).collect(Collectors.toList());
    }

    public List<Photo> filterbySize(boolean ascending){
        return photos.stream().
                sorted((photo1,photo2)->ascending ? Long.compare(photo1.getSize(), photo2.getSize()): Long.compare(photo2.getSize(), photo1.getSize()))
                .collect(Collectors.toList());
    }

    public List<Photo> filterbyPath(String path){
        return photos.stream().filter(photo->photo.getPath().startsWith(path))
                     .collect(Collectors.toList());
    }

}
