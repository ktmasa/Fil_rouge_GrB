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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.SpringBoot.loncotoBack.metier.Client;
import com.SpringBoot.loncotoBack.repositories.IClientRepository;

@Controller
@RequestMapping("/clients")
public class ClientController {
	
	@Autowired
	private IClientRepository clientRepository;
	
	//retourne le client avec l'id
	@RequestMapping(value = "/{id:[0-9]+}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = {"http://localhost:4200"}, methods = {RequestMethod.GET})
	public Client findById(@PathVariable("id") int id) {
		return clientRepository.findOne(id);
	}
	
	//retourne la liste de tout les clients
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = {"http://localhost:4200"}, methods = {RequestMethod.GET})
	public Page<Client> findAllClient(@PageableDefault(page=0,size=5) Pageable pr){
		return clientRepository.findAll(pr);
	}
	
	
	//recherche par nom entreprise -> http://localhost:8080/clients/searchent/?enterprise=JohnLegend
	@RequestMapping(value = "/search/enterprise", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = {"http://localhost:4200"}, methods = {RequestMethod.GET})
	public Page<Client> findByEntreprise(@RequestParam("name")String entreprise, Pageable pr){
		return clientRepository.findByEntreprise(entreprise,pr);
	}
	
	//recherche par siret
	@RequestMapping(value = "/search/siret", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = {"http://localhost:4200"}, methods = {RequestMethod.GET})
	public Page<Client> findBySiret(@RequestParam("name")String siret, Pageable pr){
		return clientRepository.findBySiret(siret, pr);
	}
	
	
	@RequestMapping(value="/save",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = {"http://localhost:4200"}, methods = {RequestMethod.POST})
	public Client saveClient(@RequestBody Client i) {
		return clientRepository.save(i);
	}
	
	

	@RequestMapping(value="/save",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = {"http://localhost:4200"}, methods = {RequestMethod.PUT})
	public Client updateClient(@RequestBody Client i) {
		return clientRepository.save(i);
	
	}


	@RequestMapping(value="/remove/{id:[0-9]+}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = {"http://localhost:4200"}, methods = {RequestMethod.DELETE})
	public Map<String, String> removeClient(@PathVariable("id") int id) {
		clientRepository.delete(id);
		HashMap<String, String> result = new HashMap<>();
		result.put("client_deleted_id", "" + id);
		return result;
	}
	

}
