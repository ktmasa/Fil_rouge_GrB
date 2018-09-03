package com.SpringBoot.loncotoBack.web;

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

import com.SpringBoot.loncotoBack.metier.Site;
import com.SpringBoot.loncotoBack.repositories.ISiteRepository;

@Controller
@RequestMapping("/sites")
public class SiteController {
	
	@Autowired
	private ISiteRepository siteRepository;
	
	@RequestMapping(value = "/{id:[0-9]+}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = {"http://localhost:4200"}, methods = {RequestMethod.GET})
	public Site findById(@PathVariable("id") int id){
		return siteRepository.findOne(id);
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = {"http://localhost:4200"}, methods = {RequestMethod.GET})
	public  Page<Site> findAllMateriel(int id,@PageableDefault(page=0,size=5) Pageable pr){
		return siteRepository.findAll(pr);
	}
	
	
	
	@RequestMapping(value = "/clientlist/{id:[0-9]+}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = {"http://localhost:4200"}, methods = {RequestMethod.GET})
	public Page<Site> findSiteByClient_Id(@PathVariable("id") int id,@PageableDefault(page=0,size=5) Pageable pr){
		return siteRepository.findSiteByClient_Id(id,pr);
	}
	
	
	
}
