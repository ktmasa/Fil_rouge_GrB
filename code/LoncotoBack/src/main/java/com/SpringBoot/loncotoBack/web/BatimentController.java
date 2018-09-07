package com.SpringBoot.loncotoBack.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.SpringBoot.loncotoBack.metier.Batiment;
import com.SpringBoot.loncotoBack.repositories.IBatimentRepository;

@Controller
@RequestMapping("/batiments")
public class BatimentController {
		@Autowired
		IBatimentRepository batimentRepository;
		
		@RequestMapping(value = "/{id:[0-9]+}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
		@ResponseBody
		@CrossOrigin(origins = {"http://localhost:4200"}, methods = {RequestMethod.GET})
		public Batiment findByIId(@PathVariable("id") int id){
			return batimentRepository.findOne(id);
		}	
		
		@RequestMapping(value = "/list", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
		@ResponseBody
		@CrossOrigin(origins = {"http://localhost:4200"}, methods = {RequestMethod.GET})
		public Page<Batiment> findAll(@PageableDefault(page=0,size=5) Pageable pr){
			return batimentRepository.findAll(pr);
		}

	
		@RequestMapping(value="/save",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
		@ResponseBody
		@CrossOrigin(origins = {"http://localhost:4200"}, methods = {RequestMethod.POST})
		public Batiment saveBatiment(@RequestBody Batiment i) {
			return batimentRepository.save(i);
		}
		
		
		
		@RequestMapping(value="/save",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
		@ResponseBody
		@CrossOrigin(origins = {"http://localhost:4200"}, methods = {RequestMethod.PUT})
		public Batiment updateBatiment(@RequestBody Batiment i) {
			return batimentRepository.save(i);
		
		}

	
		@RequestMapping(value="/remove/{id:[0-9]+}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
		@ResponseBody
		@CrossOrigin(origins = {"http://localhost:4200"}, methods = {RequestMethod.DELETE})
		public Map<String, String> removeBatiment(@PathVariable("id") int id) {
			batimentRepository.delete(id);
			HashMap<String, String> result = new HashMap<>();
			result.put("batiment_deleted_id", "" + id);
			return result;
		}


}
