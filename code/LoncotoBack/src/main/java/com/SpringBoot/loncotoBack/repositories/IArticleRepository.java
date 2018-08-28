package com.SpringBoot.loncotoBack.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.SpringBoot.loncotoBack.metier.Article;

public interface IArticleRepository extends PagingAndSortingRepository<Article, Integer> {

}
