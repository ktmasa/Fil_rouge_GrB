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

import com.SpringBoot.loncotoBack.metier.Article;
import com.SpringBoot.loncotoBack.repositories.IArticleRepository;

@Controller
@RequestMapping("/articles")
public class ArticleController {
	
	@Autowired
	IArticleRepository articleRepository;

	
		@RequestMapping(value = "/{id:[0-9]+}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
		@ResponseBody
		@CrossOrigin(origins = {"http://localhost:4200"}, methods = {RequestMethod.GET})
		public Article findByIId(@PathVariable("id") int id){
			return articleRepository.findOne(id);
		}
		
		
	
		@RequestMapping(value = "/list", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
		@ResponseBody
		@CrossOrigin(origins = {"http://localhost:4200"}, methods = {RequestMethod.GET})
		public Page<Article> findAll(@PageableDefault(page=0,size=5) Pageable pr){
			return articleRepository.findAll(pr);
		}

	
		@RequestMapping(value="/save",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
		@ResponseBody
		@CrossOrigin(origins = {"http://localhost:4200"}, methods = {RequestMethod.POST})
		public Article saveArticle(@RequestBody Article i) {
			return articleRepository.save(i);
		}
		
		
	
		@RequestMapping(value="/save",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
		@ResponseBody
		@CrossOrigin(origins = {"http://localhost:4200"}, methods = {RequestMethod.PUT})
		public Article updateArticle(@RequestBody Article i) {
			return articleRepository.save(i);
		
		}

	
		@RequestMapping(value="/remove/{id:[0-9]+}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
		@ResponseBody
		@CrossOrigin(origins = {"http://localhost:4200"}, methods = {RequestMethod.DELETE})
		public Map<String, String> removeArticle(@PathVariable("id") int id) {
			articleRepository.delete(id);
			HashMap<String, String> result = new HashMap<>();
			result.put("article_deleted_id", "" + id);
			return result;
		}
	
	
}
