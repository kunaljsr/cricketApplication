package com.example.es.repo;


import com.example.es.model.MatchEs;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;



public interface MatchElasticRepo extends ElasticsearchRepository<MatchEs, String> {
}
