package com.SpringBoot.loncotoBack.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.SpringBoot.loncotoBack.metier.Famille;
import com.SpringBoot.loncotoBack.repositories.IFamilleRepository;

@Controller
@RequestMapping("/familles")
public class FamilleController {
	
		IFamilleRepository familleRepository;
	
		@RequestMapping(value = "/{id:[0-9]+}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
		@ResponseBody
		@CrossOrigin(origins = {"http://localhost:4200"}, methods = {RequestMethod.GET})
		public Famille findByIId(@PathVariable("id") int id){
			return familleRepository.findOne(id);
		}
		
		
	
		@RequestMapping(value = "/list", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
		@ResponseBody
		@CrossOrigin(origins = {"http://localhost:4200"}, methods = {RequestMethod.GET})
		public Page<Famille> findAll(@PageableDefault(page=0,size=5) Pageable pr){
			return familleRepository.findAll(pr);
		}

	
		@RequestMapping(value="/save",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
		@ResponseBody
		@CrossOrigin(origins = {"http://localhost:4200"}, methods = {RequestMethod.POST})
		
		public Famille saveFamille(@RequestBody Famille i) {
			return familleRepository.save(i);
		}
		
		
		@RequestMapping(value="/save",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
		@ResponseBody
		@CrossOrigin(origins = {"http://localhost:4200"}, methods = {RequestMethod.PUT})
		public Famille updateFamille(@RequestBody Famille i) {
			return familleRepository.save(i);
		
		}

		@RequestMapping(value="/remove/{id:[0-9]+}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
		@ResponseBody
		@CrossOrigin(origins = {"http://localhost:4200"}, methods = {RequestMethod.DELETE})
		public Map<String, String> removeFamille(@PathVariable("id") int id) {
			familleRepository.delete(id);
			HashMap<String, String> result = new HashMap<>();
			result.put("famille_deleted_id", "" + id);
			return result;
		}

}
