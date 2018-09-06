package com.SpringBoot.loncotoBack.web;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.SpringBoot.loncotoBack.metier.Materiel;
import com.SpringBoot.loncotoBack.repositories.IMaterielRepository;

@Controller
@RequestMapping("/materiels")
public class MaterielController {
	
	@Autowired
	private IMaterielRepository materielRepository;
	
	@RequestMapping(value = "/client/{id:[0-9]+}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = {"http://localhost:4200"}, methods = {RequestMethod.GET})
	public Page<Materiel> findMaterielByClient(@PathVariable("id") int id,@PageableDefault(page=0,size=5) Pageable pr){
		return materielRepository.findByClient_Id(id, pr);
	}
	
	
	@RequestMapping(value = "/{id:[0-9]+}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = {"http://localhost:4200"}, methods = {RequestMethod.GET})
	public Materiel findById(@PathVariable("id") int id){
		return materielRepository.findOne(id);
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = {"http://localhost:4200"}, methods = {RequestMethod.GET})
	public  Page<Materiel> findAllMateriel(@PageableDefault(page=0,size=5) Pageable pr){
		return materielRepository.findAll(pr);
	}
	
}
