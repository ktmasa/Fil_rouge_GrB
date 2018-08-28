package com.SpringBoot.loncotoBack.web;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.SpringBoot.loncotoBack.metier.Intervention;
import com.SpringBoot.loncotoBack.repositories.IInterventionRepository;

@Controller
@RequestMapping("/interventions")
public class InterventionControleur {
	
	@Autowired
	IInterventionRepository interventionRepository;
	
	@RequestMapping(value = "/clientlist/{id:[0-9]+}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = {"http://localhost:4200"}, methods = {RequestMethod.GET})
	Page<Intervention> getInterventionFromClient(@PathVariable("id") int clientid,@PageableDefault(page=0,size=5) Pageable pr){
		List<Intervention> interventions = interventionRepository.findFromClient(clientid);
		Page<Intervention> pi =  new PageImpl<>(interventions,pr,interventions.size());
		return pi;
	}
}
