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

import com.SpringBoot.loncotoBack.metier.Site;
import com.SpringBoot.loncotoBack.repositories.ISiteRepository;

@Controller
@RequestMapping("/sites")
public class SiteController {

	@Autowired
	private ISiteRepository siteRepository;

	// Renvoie un site à partir de son ID
	@RequestMapping(value = "/{id:[0-9]+}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = { "http://localhost:4200" }, methods = { RequestMethod.GET })
	public Site findById(@PathVariable("id") int id) {
		return siteRepository.findOne(id);
	}

	// Renvoie toute la liste des sites répertoriés
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = { "http://localhost:4200" }, methods = { RequestMethod.GET })
	public Page<Site> findAllMateriel(@PageableDefault(page = 0, size = 5) Pageable pr) {
		return siteRepository.findAll(pr);
	}

	// renvoie la liste des sites d'un client
	@RequestMapping(value = "/client/{id:[0-9]+}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = { "http://localhost:4200" }, methods = { RequestMethod.GET })
	public Page<Site> findSiteByClient_Id(@PathVariable("id") int id,
			@PageableDefault(page = 0, size = 5) Pageable pr) {
		return siteRepository.findSiteByClients_Id(id, pr);
	}

	// ********************************************************************************************
	// UPDATE/ADD/DELETE
	// ********************************************************************************************

	// ADD
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = { "http://localhost:4200" }, methods = { RequestMethod.POST })

	public Site saveSite(@RequestBody Site i) {
		return siteRepository.save(i);
	}

	// UPDATE
	@RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = { "http://localhost:4200" }, methods = { RequestMethod.PUT })

	public Site updateSite(@RequestBody Site i) {
		return siteRepository.save(i);

	}

	// DELETE
	@RequestMapping(value = "/remove/{id:[0-9]+}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = { "http://localhost:4200" }, methods = { RequestMethod.DELETE })
	public Map<String, String> removeSite(@PathVariable("id") int id) {
		siteRepository.delete(id);
		HashMap<String, String> result = new HashMap<>();
		result.put("site_deleted_id", "" + id);
		return result;
	}

}
