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

import com.SpringBoot.loncotoBack.metier.Materiel;
import com.SpringBoot.loncotoBack.repositories.IMaterielRepository;

@Controller
@RequestMapping("/materiels")
public class MaterielController {
	
	@Autowired
	private IMaterielRepository materielRepository;
	
	// renvoie la liste des materiaux d'un client
	@RequestMapping(value = "/client/{id:[0-9]+}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = {"http://localhost:4200"}, methods = {RequestMethod.GET})
	public Page<Materiel> findMaterielByClient(@PathVariable("id") int id,@PageableDefault(page=0,size=5) Pageable pr){
		return materielRepository.findByClient_Id(id, pr);
	}
	
	// Renvoie un materiel à partir de son ID
	@RequestMapping(value = "/{id:[0-9]+}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = {"http://localhost:4200"}, methods = {RequestMethod.GET})
	public Materiel findById(@PathVariable("id") int id){
		return materielRepository.findOne(id);
	}
	// Renvoie toute la liste des materiaux répertoriés
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = {"http://localhost:4200"}, methods = {RequestMethod.GET})
	public  Page<Materiel> findAllMateriel(@PageableDefault(page=0,size=5) Pageable pr){
		return materielRepository.findAll(pr);
	}
	
	//*************************************************************************************************/
	//ADD/DELETE/UPDATE
	//*************************************************************************************************/
	
	// ADD
		@RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		@ResponseBody
		@CrossOrigin(origins = { "http://localhost:4200" }, methods = { RequestMethod.POST })

		public Materiel saveMateriel(@RequestBody Materiel i) {
			return materielRepository.save(i);
		}

		// UPDATE
		@RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		@ResponseBody
		@CrossOrigin(origins = { "http://localhost:4200" }, methods = { RequestMethod.PUT })

		public Materiel updateMateriel(@RequestBody  Materiel i) {
			return materielRepository.save(i);

		}

		// DELETE
		@RequestMapping(value = "/remove/{id:[0-9]+}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		@ResponseBody
		@CrossOrigin(origins = { "http://localhost:4200" }, methods = { RequestMethod.DELETE })
		public Map<String, String> removeMateriel(@PathVariable("id") int id) {
			materielRepository.delete(id);
			HashMap<String, String> result = new HashMap<>();
			result.put("materiel_deleted_id", "" + id);
			return result;
		}
	
}
