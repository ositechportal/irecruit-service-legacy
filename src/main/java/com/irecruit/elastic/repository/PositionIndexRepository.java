package com.irecruit.elastic.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.irecruit.pojo.Position;

public interface PositionIndexRepository extends ElasticsearchRepository<Position, String>{

}
