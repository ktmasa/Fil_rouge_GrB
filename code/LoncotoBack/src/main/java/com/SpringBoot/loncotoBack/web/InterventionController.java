package com.SpringBoot.loncotoBack.web;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

import com.SpringBoot.loncotoBack.metier.Intervention;
import com.SpringBoot.loncotoBack.repositories.IInterventionRepository;

@Controller
@RequestMapping("/interventions")
public class InterventionController {

	@Autowired
	private IInterventionRepository interventionRepository;

	// ***************************************************************************************
	// GLOBAL
	// ***************************************************************************************

	// recupere une intervention
	@RequestMapping(value = "/{id:[0-9]+}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = { "http://localhost:4200" }, methods = { RequestMethod.GET })
	public Intervention findByIId(@PathVariable("id") int id) {
		return interventionRepository.findOne(id);
	}

	// liste de toute les interventions
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = { "http://localhost:4200" }, methods = { RequestMethod.GET })
	public Page<Intervention> findAll(@PageableDefault(page = 0, size = 5) Pageable pr) {
		return interventionRepository.findAll(pr);
	}

	// liste des interventions avant une date donnée
	@RequestMapping(value = "/datebefore/{dateRealisation}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = { "http://localhost:4200" }, methods = { RequestMethod.GET })
	public Page<Intervention> findAllWithFixedDateTimeBefore(
			@PathVariable("dateRealisation") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateRealisation,
			@PageableDefault(page = 0, size = 5) Pageable pr) {
		return interventionRepository.findAllWithFixedDateTimeBefore(dateRealisation, pr);
	}

	// liste des interventions apres une date donnée
	@RequestMapping(value = "/dateafter/{dateRealisation}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = { "http://localhost:4200" }, methods = { RequestMethod.GET })
	public Page<Intervention> findAllWithFixedDateTimeAfter(
			@PathVariable("dateRealisation") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateRealisation,
			@PageableDefault(page = 0, size = 5) Pageable pr) {
		return interventionRepository.findAllWithFixedDateTimeAfter(dateRealisation, pr);
	}

	// ***************************************************************************************
	// UPDATE POST DELETE
	// ***************************************************************************************

	// insert une intervention
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = { "http://localhost:4200" }, methods = { RequestMethod.POST })
	public Intervention saveIntervention(@RequestBody Intervention i) {
		return interventionRepository.save(i);
	}

	// update une intervention
	@RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = { "http://localhost:4200" }, methods = { RequestMethod.PUT })

	public Intervention updateIntervention(@RequestBody Intervention i) {
		return interventionRepository.save(i);
	}

	// delete une intervention avec un certain ID
	@RequestMapping(value = "/remove/{id:[0-9]+}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = { "http://localhost:4200" }, methods = { RequestMethod.DELETE })
	public Map<String, String> removeIntervention(@PathVariable("id") int id) {
		interventionRepository.delete(id);
		HashMap<String, String> result = new HashMap<>();
		result.put("intervention_deleted_id", "" + id);
		return result;
	}

	// ***************************************************************************************
	// GLOBAL DATE
	// ***************************************************************************************

	// liste de tout les intervention trie par date
	@RequestMapping(value = "/dateorder", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = { "http://localhost:4200" }, methods = { RequestMethod.GET })
	public Page<Intervention> findAllOrderDateReal(@PageableDefault(page = 0, size = 15) Pageable pr) {
		return interventionRepository.findAllByOrderByDateRealisation(pr);

	}

	// liste des interventions une date donnée
	@RequestMapping(value = "/date", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = { "http://localhost:4200" }, methods = { RequestMethod.GET })
	public Page<Intervention> findByDateRealisation(
			@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
			@PageableDefault(page = 0, size = 5) Pageable pr) {
		return interventionRepository.findByDateRealisation(date, pr);

	}

	// liste des interventions entre 2 dates
	@RequestMapping(value = "/dates", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = { "http://localhost:4200" }, methods = { RequestMethod.GET })
	public Page<Intervention> findAllDateRealisationBetween(
			@RequestParam("startdate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateStart,
			@RequestParam("enddate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateEnd,
			@PageableDefault(page = 0, size = 5) Pageable pr) {
		return interventionRepository.findByDateRealisationBetween(dateStart, dateEnd, pr);
	}

	// ***************************************************************************************
	// INTERVENANT DATE
	// ***************************************************************************************

	// recupere la liste d'intervention d'un intervenant donnée
	@RequestMapping(value = "/intervenant/{id:[0-9]+}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = { "http://localhost:4200" }, methods = { RequestMethod.GET })
	public Page<Intervention> findByIntervenant_Id(@PathVariable("id") int id,
			@PageableDefault(page = 0, size = 5) Pageable pr) {
		return interventionRepository.findByIntervenant_Id(id, pr);
	}
	
	//recupere la prochaine intervention de l'intervenant
	@RequestMapping(value = "/intervenant/next/{id:[0-9]+}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = { "http://localhost:4200" }, methods = { RequestMethod.GET })
	public Intervention nextInterventionIntervenant(@PathVariable("id") int id,
			@PageableDefault(page = 0, size = 15) Pageable pr) {

		List<Intervention> interventionList = interventionRepository
				.findAllWithFixedDateAfterOfIntervenant(LocalDate.now(), id, pr).getContent();
		if (interventionList == null) {
			return null;
		}else {
			if(interventionList.get(0).getStatus().equals("Realisee")) {
				if(interventionList.size()==1) {
					return null;
				}else {
					return interventionList.get(1);
				}
			}else {
				return interventionList.get(0);	
			}
		}
	}
	
	//recupere les anciennes interventions de l'intervenant
	@RequestMapping(value = "/intervenant/datebefore", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = { "http://localhost:4200" }, methods = { RequestMethod.GET })
	public Page<Intervention> findWithFixedDateBeforeOfIntervenant(
			@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate creationDateTime,
			@RequestParam("id") int interId, @PageableDefault(page = 0, size = 15) Pageable pr) {
		return interventionRepository.findWithFixedDateBeforeOfIntervenant(creationDateTime, interId, pr);
	}

	//recupere les prochaines intervention prevu de l'intervenant
	@RequestMapping(value = "/intervenant/dateafter", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = { "http://localhost:4200" }, methods = { RequestMethod.GET })
	public Page<Intervention> findAllWithFixedDateAfterOfIntervenant(
			@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate creationDateTime,
			@RequestParam("id") int interId, @PageableDefault(page = 0, size = 5)  Pageable pr){
		
		return interventionRepository.findAllWithFixedDateAfterOfIntervenant(creationDateTime, interId, pr);
	}
	
	
	//recupere l'intervention d'un intervenant à une date donnée
	@RequestMapping(value = "/intervenant/date", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = { "http://localhost:4200" }, methods = { RequestMethod.GET })
	public Page<Intervention> findAllWithFixedDateOfIntervenant(
			@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate creationDateTime, 
			@RequestParam("id") int interId, @PageableDefault(page = 0, size = 5)  Pageable pr){
		return interventionRepository.findAllWithFixedDateOfIntervenant(creationDateTime, interId, pr);
	}
	
	//recupere la liste des interventions entre 2 dates d'un intervenant
	@RequestMapping(value = "/intervenant/dates", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = { "http://localhost:4200" }, methods = { RequestMethod.GET })
	public Page<Intervention> findAllBetweendDateOfIntervenant(
			@RequestParam("startdate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDateTime,
			@RequestParam("enddate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDateTime,
			@RequestParam("id") int interId, @PageableDefault(page = 0, size = 5)  Pageable pr){
		return interventionRepository.findAllBetweendDateOfIntervenant(startDateTime, endDateTime, interId, pr);
		
	}
	
	//recupere la liste des interventions d'un intervenant ordonnee par date.
	@RequestMapping(value = "/intervenant/dateorder", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = { "http://localhost:4200" }, methods = { RequestMethod.GET })
	public Page<Intervention> findAllWithIntervenantOrder(@RequestParam("id") int interId, @PageableDefault(page = 0, size = 5) Pageable pr){
		return interventionRepository.findAllWithIntervenantOrder(interId, pr);
		
	}

	/*
	 * NOT WORKING
	 * 
	 * @RequestMapping(value = "/clientsite", method = RequestMethod.GET, produces =
	 * MediaType.APPLICATION_JSON_UTF8_VALUE)
	 * 
	 * @ResponseBody
	 * 
	 * @CrossOrigin(origins = { "http://localhost:4200" }, methods = {
	 * RequestMethod.GET }) public Page<Intervention>
	 * findByClientSite(@RequestParam("clientId") int
	 * idclient,@RequestParam("idsite") int idsite,@PageableDefault(page = 0, size =
	 * 5) Pageable pr) { return
	 * interventionRepository.findInterventionByClientSite(idsite, idclient, pr); }
	 */

	// ***************************************************************************************
	// CLIENT DATE
	// ***************************************************************************************

	// recupere la liste des intervention d'un client donnée
	@RequestMapping(value = "/client/{id:[0-9]+}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = { "http://localhost:4200" }, methods = { RequestMethod.GET })
	Page<Intervention> getInterventionFromClient(@PathVariable("id") int clientid,
			@PageableDefault(page = 0, size = 5) Pageable pr) {
		return interventionRepository.findInterventionByClient(clientid, pr);
	}

	// recupere la liste des intervention d'un materiel donnée
	@RequestMapping(value = "/materiel/{id:[0-9]+}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = { "http://localhost:4200" }, methods = { RequestMethod.GET })
	Page<Intervention> getInterventionFromMateriel(@PathVariable("id") int materielid,
			@PageableDefault(page = 0, size = 5) Pageable pr) {
		return interventionRepository.findInterventionByMateriel(materielid, pr);
	}

	//recupere la prochaine intervention du client
		@RequestMapping(value = "/client/next/{id:[0-9]+}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		@ResponseBody
		@CrossOrigin(origins = { "http://localhost:4200" }, methods = { RequestMethod.GET })
		public Intervention nextInterventionClient(@PathVariable("id") int id,
				@PageableDefault(page = 0, size = 15) Pageable pr) {

			List<Intervention> interventionList = interventionRepository
					.findAllWithFixedDateAfterOfClient(LocalDate.now(), id, pr).getContent();
			if (interventionList == null) {
				return null;
			}else {
				if(interventionList.get(0).getStatus().equals("Realisee")) {
					if(interventionList.size()==1) {
						return null;
					}else {
						return interventionList.get(1);
					}
				}else {
					return interventionList.get(0);	
				}
			}
		}
		
		//recupere les anciennes interventions du client
		@RequestMapping(value = "/client/datebefore", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		@ResponseBody
		@CrossOrigin(origins = { "http://localhost:4200" }, methods = { RequestMethod.GET })
		public Page<Intervention> findWithFixedDateBeforeOfClient(
				@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate creationDateTime,
				@RequestParam("id") int clientId, @PageableDefault(page = 0, size = 15) Pageable pr) {
			return interventionRepository.findAllWithFixedDateBeforeOfClient(creationDateTime, clientId, pr);
		}

		//recupere les prochaines intervention prevu du client
		@RequestMapping(value = "/client/dateafter", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		@ResponseBody
		@CrossOrigin(origins = { "http://localhost:4200" }, methods = { RequestMethod.GET })
		public Page<Intervention> findAllWithFixedDateAfterOfClient(
				@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate creationDateTime,
				@RequestParam("id") int interId, @PageableDefault(page = 0, size = 5)  Pageable pr){
			
			return interventionRepository.findAllWithFixedDateAfterOfClient(creationDateTime, interId, pr);
		}
		
		
		//recupere l'intervention d'un client à une date donnée
		@RequestMapping(value = "/client/date", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		@ResponseBody
		@CrossOrigin(origins = { "http://localhost:4200" }, methods = { RequestMethod.GET })
		public Page<Intervention> findAllWithFixedDateOfClient(
				@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate creationDateTime, 
				@RequestParam("id") int interId, @PageableDefault(page = 0, size = 5)  Pageable pr){
			return interventionRepository.findAllWithFixedDateOfClient(creationDateTime, interId, pr);
		}
		
		//recupere la liste des interventions entre 2 dates d'un client
		@RequestMapping(value = "/client/dates", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		@ResponseBody
		@CrossOrigin(origins = { "http://localhost:4200" }, methods = { RequestMethod.GET })
		public Page<Intervention> findAllBetweendDateOfClient(
				@RequestParam("startdate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDateTime,
				@RequestParam("enddate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDateTime,
				@RequestParam("id") int interId, @PageableDefault(page = 0, size = 5)  Pageable pr){
			return interventionRepository.findAllBetweenDateOfClient(startDateTime, endDateTime, interId, pr);
			
		}
		
		//recupere la liste des interventions d'un client ordonnee par date.
		@RequestMapping(value = "/client/dateorder", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		@ResponseBody
		@CrossOrigin(origins = { "http://localhost:4200" }, methods = { RequestMethod.GET })
		public Page<Intervention> findAllWithClientOrder(@RequestParam("id") int interId, @PageableDefault(page = 0, size = 5) Pageable pr){
			return interventionRepository.findAllWithClientOrder(interId, pr);
		}

}
