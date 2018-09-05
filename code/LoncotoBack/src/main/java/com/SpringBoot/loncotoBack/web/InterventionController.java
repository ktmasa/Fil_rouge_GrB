package com.SpringBoot.loncotoBack.web;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
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

import com.SpringBoot.loncotoBack.metier.Intervention;
import com.SpringBoot.loncotoBack.repositories.IInterventionRepository;

@Controller
@RequestMapping("/interventions")
public class InterventionController {
	
	@Autowired
	private IInterventionRepository interventionRepository;
	
	//recupere la liste des intervention d'un client donnée
	
	@RequestMapping(value = "/clientlist/{id:[0-9]+}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = {"http://localhost:4200"}, methods = {RequestMethod.GET})
	Page<Intervention> getInterventionFromClient(@PathVariable("id") int clientid,@PageableDefault(page=0,size=5) Pageable pr){
		return interventionRepository.findInterventionByClient(clientid,pr);
	}
	
	
	//recupere la liste des intervention d'un materiel donnée
	@RequestMapping(value = "/materiellist/{id:[0-9]+}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = {"http://localhost:4200"}, methods = {RequestMethod.GET})
	Page<Intervention> getInterventionFromMateriel(@PathVariable("id") int materielid,@PageableDefault(page=0,size=5) Pageable pr){
		return interventionRepository.findInterventionByMateriel(materielid,pr);
	}
	
	
	//recupere la list d'intervention d'un intervenant donnée
	@RequestMapping(value = "/intervenantlist/{id:[0-9]+}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = {"http://localhost:4200"}, methods = {RequestMethod.GET})
	public Page<Intervention> findByIntervenant_Id(@PathVariable("id") int id, @PageableDefault(page=0,size=5) Pageable pr){
		return interventionRepository.findByIntervenant_Id(id, pr);
	}
	
	
	//recupere une intervention
	@RequestMapping(value = "/{id:[0-9]+}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = {"http://localhost:4200"}, methods = {RequestMethod.GET})
	public Intervention findByIId(@PathVariable("id") int id){
		return interventionRepository.findOne(id);
	}
	
	//liste de toute les interventions
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = {"http://localhost:4200"}, methods = {RequestMethod.GET})
	public Page<Intervention> findAll(@PageableDefault(page=0,size=5) Pageable pr){
		return interventionRepository.findAll(pr);
	}
	
	//liste de tout les intervention trie par date
	@RequestMapping(value = "/dateorder", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = {"http://localhost:4200"}, methods = {RequestMethod.GET})
	public Page<Intervention> findAllOrderDateReal(@PageableDefault(page=0,size=15) Pageable pr){
		return interventionRepository.findAllByOrderByDateRealisation(pr);
		
	}
	
	
	//insert une intervention
	@RequestMapping(value="/save",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = {"http://localhost:4200"}, methods = {RequestMethod.POST})
	
	public Intervention saveIntervention(@RequestBody Intervention i) {
		return interventionRepository.save(i);
	}
	
	
	//update une intervention
	@RequestMapping(value="/save",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = {"http://localhost:4200"}, methods = {RequestMethod.PUT})
	
	public Intervention updateIntervention(@RequestBody Intervention i) {
		return interventionRepository.save(i);
	
	}
	
	
	//delete une intervention avec un certain ID
	@RequestMapping(value="/remove/{id:[0-9]+}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = {"http://localhost:4200"}, methods = {RequestMethod.DELETE})
	public Map<String, String> removeIntervention(@PathVariable("id") int id) {
		interventionRepository.delete(id);
		HashMap<String, String> result = new HashMap<>();
		result.put("intervention_deleted_id", "" + id);
		return result;
	}
	
	@RequestMapping(value = "/next/client/{id:[0-9]+}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = {"http://localhost:4200"}, methods = {RequestMethod.GET})
	public Intervention nextInterventionClient(@PathVariable("id") int id, @PageableDefault(page=0,size=15) Pageable pr){
		List<Intervention> interventionList = interventionRepository.findAllWithFixedDateAfterOfClient(LocalDate.now(), id,pr).getContent();
		if(interventionList == null) {
			return null;
		}else {
			return interventionList.get(0);
		}
		
		
	}
	
	@RequestMapping(value = "/next/intervenant/{id:[0-9]+}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = {"http://localhost:4200"}, methods = {RequestMethod.GET})
	public  Intervention nextInterventionIntervenant(@PathVariable("id") int id,@PageableDefault(page=0,size=15) Pageable pr){
		List<Intervention> interventionList = interventionRepository.findAllWithFixedDateAfterOfIntervenant(LocalDate.now(), id,pr).getContent();
		if(interventionList == null) {
			return null;
		}else {
			return interventionList.get(0);
		}
		
	}
	
	
	
	
	
}
