package com.SpringBoot.loncotoBack.web;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.SpringBoot.loncotoBack.metier.Intervenant;
import com.SpringBoot.loncotoBack.repositories.IIntervenantRepository;

@Controller
@RequestMapping("/intervenants")
public class IntervenantController {

	@Autowired
	private IIntervenantRepository intervenantRepository;
	
	//retourne un intervenant à partir d'une ID 
	@RequestMapping(value = "/{id:[0-9]+}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = {"http://localhost:4200"}, methods = {RequestMethod.GET})
	public Intervenant findById(@PathVariable("id") int id){
		return intervenantRepository.findOne(id);
	}
	
	//retourne la liste des intervenants
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = {"http://localhost:4200"}, methods = {RequestMethod.GET})
	public  Page<Intervenant> findAllIntervenant(@PageableDefault(page=0,size=5) Pageable pr){
		return intervenantRepository.findAll(pr);
	}
	
	//retourne la liste des intervenants d'une specialité donnée et disponible une date donnée. 
	@RequestMapping(value = "/dispo", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = {"http://localhost:4200"}, methods = {RequestMethod.GET})
	public Page<Intervenant> findFixedDateDisponibleIntervenant(@RequestParam("spe")  String spe,@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, @PageableDefault(page=0,size=5) Pageable pr){
	return intervenantRepository.findWithFixedDateDispoIntervenant(spe,date, pr);	
	}
	
	
	@RequestMapping(value="/save",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = {"http://localhost:4200"}, methods = {RequestMethod.POST})
	
	public Intervenant saveIntervenant(@RequestBody Intervenant i) {
		return intervenantRepository.save(i);
	}
	
	

	@RequestMapping(value="/save",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = {"http://localhost:4200"}, methods = {RequestMethod.PUT})
	
	public Intervenant updateIntervenant(@RequestBody Intervenant i) {
		return intervenantRepository.save(i);
	
	}

	@RequestMapping(value="/remove/{id:[0-9]+}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = {"http://localhost:4200"}, methods = {RequestMethod.DELETE})
	public Map<String, String> removeIntervenant(@PathVariable("id") int id) {
		intervenantRepository.delete(id);
		HashMap<String, String> result = new HashMap<>();
		result.put("intervenant_deleted_id", "" + id);
		return result;
	}
	
}
