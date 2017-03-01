package com.irecruit.elastic.repository;

import java.util.List;

import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Repository;

import com.irecruit.pojo.Profile;
import com.mongodb.QueryBuilder;

@Repository
public class ProfileIndexQueryRepository {

	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;

	List<Profile> findProfilesByEmailIdStartingWithOrCandidateNameStartingWithOrDesignationStartingWithAllIgnoreCase(String query) {
		MultiMatchQueryBuilder qb = QueryBuilders.multiMatchQuery(query, "emailId", "candidateName", "designation");
		SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(qb).withPageable(new PageRequest(0, 100))
				.build();
		return elasticsearchTemplate.queryForList(searchQuery, Profile.class);
	}

}
