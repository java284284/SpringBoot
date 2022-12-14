package com.ispan.springbootdemo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ispan.springbootdemo.model.GoodPhoto;
import com.ispan.springbootdemo.service.GoodPhotoService;

@Controller
public class GoodPhotoController {
	
	@Autowired
	private GoodPhotoService gService;
	
	@PostMapping("/fileupload")
	public String uploadNewPhoto(@RequestParam("photoName") String photoName, 
			                     @RequestParam("file") MultipartFile file ) {
		
		String nameAfterTrim = photoName.trim();
		
		try {
			GoodPhoto newPhoto = new GoodPhoto();
			newPhoto.setPhotoName(nameAfterTrim);
			newPhoto.setPhotoFile(file.getBytes());
			
			gService.insertPhoto(newPhoto);
			
			return "goodphoto/uploadSuccessPage";
		} catch (IOException e) {
			e.printStackTrace();
			return "index";
		}
	}
	
	@GetMapping("/listPhoto")
	public String listPhoto(Model model) {
		List<GoodPhoto> allPhoto = gService.getAllPhoto();
		
		model.addAttribute("goodPhotoList", allPhoto);
		
		return "goodphoto/listPhoto";
	}
	
	@GetMapping("/downloadImage/{id}")
	public ResponseEntity<byte[]> downloadImage(@PathVariable Integer id){
		GoodPhoto photo1 = gService.getPhotoById(id);
		
		byte[] photoFile = photo1.getPhotoFile();
		
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.IMAGE_JPEG);
		
		
		return new ResponseEntity<byte[]>(photoFile,header,HttpStatus.OK);
	}

}