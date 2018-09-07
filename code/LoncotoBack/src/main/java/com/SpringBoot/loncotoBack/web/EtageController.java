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

import com.SpringBoot.loncotoBack.metier.Etage;
import com.SpringBoot.loncotoBack.repositories.IEtageRepository;

@Controller
@RequestMapping("/etages")
public class EtageController {

	@Autowired
	IEtageRepository etageRepository;

	@RequestMapping(value = "/{id:[0-9]+}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = { "http://localhost:4200" }, methods = { RequestMethod.GET })
	public Etage findByIId(@PathVariable("id") int id) {
		return etageRepository.findOne(id);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = { "http://localhost:4200" }, methods = { RequestMethod.GET })
	public Page<Etage> findAll(@PageableDefault(page = 0, size = 5) Pageable pr) {
		return etageRepository.findAll(pr);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = { "http://localhost:4200" }, methods = { RequestMethod.POST })

	public Etage saveEtage(@RequestBody Etage i) {
		return etageRepository.save(i);
	}

	@RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = { "http://localhost:4200" }, methods = { RequestMethod.PUT })

	public Etage updateEtage(@RequestBody Etage i) {
		return etageRepository.save(i);

	}

	@RequestMapping(value = "/remove/{id:[0-9]+}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = { "http://localhost:4200" }, methods = { RequestMethod.DELETE })
	public Map<String, String> removeEtage(@PathVariable("id") int id) {
		etageRepository.delete(id);
		HashMap<String, String> result = new HashMap<>();
		result.put("etage_deleted_id", "" + id);
		return result;
	}

}
