package de.supercode.fotomanagment.controller;

import de.supercode.fotomanagment.model.Photo;
import de.supercode.fotomanagment.services.PhotoService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/photos")
public class PhotoController {
    PhotoService photoService;

    public  PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @GetMapping
    public ArrayList<Photo> getAllPhotos(@RequestParam(required = false) String fileName){
        if(fileName == null)
            return photoService.getAllPhotos();
        else
            return photoService.getPhoto(fileName);
    }

    @PostMapping
    public void addPhoto(@RequestBody Photo photo){
        photoService.addPhoto(photo);
    }

    @PutMapping("/{fileName}")
    public Photo updatePhoto(@PathVariable String fileName, @RequestBody Photo photo) {
        return  photoService.updatePhoto(fileName, photo);
    }

    @DeleteMapping("/{fileName}")
    public void deletePhoto(@PathVariable String fileName) {
        photoService.deletePhoto(fileName);
    }
    @GetMapping("/{fileName}")
    public Photo findbyPhotoName(@PathVariable String fileName){
        return photoService.findbyPhotoName(fileName);
    }

    @GetMapping("/filter")
    public List<Photo> filterbyType(@RequestParam("type") String typeName){
        return  photoService.filterbyType(typeName);
    }
    @GetMapping("/sort")
    public List<Photo> filterbySize(@RequestParam("ascending") boolean ascending){
        return photoService.filterbySize(ascending);
    }
    @GetMapping("/filterByPath")
    public List<Photo> filterbyPath(@RequestParam("path") String path){
        return photoService.filterbyPath(path);
    }

}
