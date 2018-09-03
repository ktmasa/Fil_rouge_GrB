package com.SpringBoot.loncotoBack.web;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.SpringBoot.loncotoBack.metier.Image;
import com.SpringBoot.loncotoBack.metier.Intervention;
import com.SpringBoot.loncotoBack.repositories.IImageRepository;
import com.SpringBoot.loncotoBack.utilitary.FileStorageManager;

@Controller
@RequestMapping("/imageapi")
public class ImageController {
	@Autowired
	private IImageRepository imageRepository;
	
	@Autowired
	private FileStorageManager fsm;
	
//	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value="/upload/{id:[0-9]+}",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<Object> upload(@RequestParam("image") MultipartFile file) {
		// on ne supporte que les JPG et PNG
		if (!file.getContentType().equals(MediaType.IMAGE_JPEG_VALUE) &&
				!file.getContentType().equals(MediaType.IMAGE_PNG_VALUE)) {
			Map<String, String> result = new HashMap<>();
			result.put("erreur", "seul jpeg et png sont pris en compte");
			return new ResponseEntity<Object>(result, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
		}
		try {
			// copie effectivement le fichier uploadé dans notre répertoire
			String storageName = fsm.saveFile(file.getInputStream());
			Image img = new Image(0,storageName,file.getOriginalFilename(),file.getContentType());
			img = imageRepository.save(img);
			//ici setting 
			return new ResponseEntity<Object>(img, HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	// pas de produces=...json  car on renvoie une image, c'est a dire du binaire
	@RequestMapping(value="/download/{id:[0-9]+}",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<FileSystemResource> imageData(@PathVariable("id") long id) {
		Image img = imageRepository.findOne(id);
		if (img == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		// on récupere le fichier
		Optional<File> fichier = fsm.readFile(img.getStorageName());
		if (fichier.isPresent()) {
			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.parseMediaType(img.getContentType())); // type image
			header.setContentDispositionFormData("attachment", img.getFileName()); // nom fichier
			header.setContentLength(fichier.get().length()); // taille du fichier
			
			return new ResponseEntity<FileSystemResource>(
					new FileSystemResource(fichier.get()),  // contenu du fichier
					header,
					HttpStatus.ACCEPTED);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="/remove/{id:[0-9]+}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = {"http://localhost:4200"}, methods = {RequestMethod.DELETE})
	public  Map<String, String> removeImage(@PathVariable("id") long id) throws IOException {
		Image img = imageRepository.findOne(id);
		Optional<File> fichier = fsm.readFile(img.getStorageName());
		boolean destroyed = false;
		if (fichier.isPresent()) {
			destroyed = fsm.deleteFile(img.getStorageName());
		}
		HashMap<String, String> result = new HashMap<>();
		if(destroyed) {
			imageRepository.delete(img);
			result.put("image_deleted_id", "" + id);
		}
		
		else {
			result.put("image_not_deleted_id", "" + id);
		}
		return result;
	}
	
	@RequestMapping(value="/getlist/{id:[0-9]+}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = {"http://localhost:4200"}, methods = {RequestMethod.DELETE})
	public List<Long> getImageId(@PathVariable("id") int id) {
		List<Long> listId = new ArrayList<Long>();
		List<Image> images = imageRepository.findByIntervention_Id(id);
		for(Image i : images) {
			listId.add(i.getId());
		}
		return listId;
	}
}
