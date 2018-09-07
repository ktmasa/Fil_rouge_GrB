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

import com.SpringBoot.loncotoBack.metier.SousFamille;
import com.SpringBoot.loncotoBack.repositories.ISousFamilleRepository;

@Controller
@RequestMapping("/sousfamilles")
public class SousFamilleController {
	
		@Autowired
		ISousFamilleRepository sousFamilleRepository;
	
	
		@RequestMapping(value = "/{id:[0-9]+}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
		@ResponseBody
		@CrossOrigin(origins = {"http://localhost:4200"}, methods = {RequestMethod.GET})
		public SousFamille findByIId(@PathVariable("id") int id){
			return sousFamilleRepository.findOne(id);
		}
		
		
	
		@RequestMapping(value = "/list", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
		@ResponseBody
		@CrossOrigin(origins = {"http://localhost:4200"}, methods = {RequestMethod.GET})
		public Page<SousFamille> findAll(@PageableDefault(page=0,size=5) Pageable pr){
			return sousFamilleRepository.findAll(pr);
		}

	
		@RequestMapping(value="/save",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
		@ResponseBody
		@CrossOrigin(origins = {"http://localhost:4200"}, methods = {RequestMethod.POST})
		public SousFamille saveSousFamille(@RequestBody SousFamille i) {
			return sousFamilleRepository.save(i);
		}
		
		
	
		@RequestMapping(value="/save",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
		@ResponseBody
		@CrossOrigin(origins = {"http://localhost:4200"}, methods = {RequestMethod.PUT})
		public SousFamille updateSousFamille(@RequestBody SousFamille i) {
			return sousFamilleRepository.save(i);
		
		}

		@RequestMapping(value="/remove/{id:[0-9]+}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
		@ResponseBody
		@CrossOrigin(origins = {"http://localhost:4200"}, methods = {RequestMethod.DELETE})
		public Map<String, String> removeSousFamille(@PathVariable("id") int id) {
			sousFamilleRepository.delete(id);
			HashMap<String, String> result = new HashMap<>();
			result.put("sous_famille_deleted_id", "" + id);
			return result;
		}

}
