package com.irecruit.mongo.repository;

import static org.elasticsearch.action.search.SearchType.COUNT;
import static org.elasticsearch.index.query.QueryBuilders.matchAllQuery;
import static org.elasticsearch.search.aggregations.AggregationBuilders.terms;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.StringTerms;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.ResultsExtractor;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.irecruit.pojo.Position;
import com.irecruit.pojo.PositionAggregate;

@Repository
public class PositionRepository {

	private static final String _ID = "_id";

	@Autowired
	private MongoOperations mongoOperations;

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;

	@Autowired
	private Client client;

	public void preparePosition(Position position) {
		mongoOperations.save(position);

	}

	public Position updatePosition(Position position) {
		mongoOperations.save(position);
		return position;
	}

	public List<Position> retrievePositionByClient(String client) {
		Query query = new Query();
		query.addCriteria(Criteria.where("client")
				.regex(Pattern.compile(client, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE)));
		List<Position> positionDatails = mongoOperations.find(query, Position.class);
		return positionDatails;
	}

	public List<Position> retrieveAllPositions() {
		List<Position> positionDatails = mongoOperations.findAll(Position.class);
		return positionDatails;
	}

	public List<Position> retrievePositionsbasedOnDesignation(String designation) {
		Query query = new Query();
		query.addCriteria(Criteria.where("designation").is(designation));
		List<Position> positionDatails = mongoOperations.find(query, Position.class);
		return positionDatails;
	}

	public List<Position> retrievePositionsbasedOnrequisitionId(String requisitionId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("requisitionId").regex(requisitionId));
		List<Position> positionDetail = mongoOperations.find(query, Position.class);
		return positionDetail;
	}

	public Position retrievePositionsbasedOnJobCode(String jobcode) {
		Query query = new Query();
		query.addCriteria(Criteria.where(_ID).regex(jobcode));
		Position positionDetail = mongoOperations.findOne(query, Position.class);
		return positionDetail;
	}

	public Position deletePositionBasedOnJC(String jobcode) {
		Query query = new Query();
		query.addCriteria(Criteria.where(_ID).regex(jobcode));
		return mongoOperations.findAndRemove(query, Position.class);
	}

	public List<Position> retrievePositionbasedOnLocation(String location) {
		Query query = new Query();
		query.addCriteria(Criteria.where("location").regex(location));
		List<Position> positionDetail = mongoOperations.find(query, Position.class);
		return positionDetail;
	}

	public List<PositionAggregate> retrieveAllPositionsAggregate() {
		Aggregation agg = newAggregation(group("designation").count().as("total"),
				project("total").and("designation").previousOperation(), sort(Sort.Direction.DESC, "total"));

		AggregationResults<PositionAggregate> groupResults = mongoTemplate.aggregate(agg, Position.class,
				PositionAggregate.class);
		List<PositionAggregate> result = groupResults.getMappedResults();
		return result;
	}

	public List<PositionAggregate> retrieveAllPositionsAggregateFromElastic() {

		List<PositionAggregate> list = new ArrayList<PositionAggregate>();

		SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(matchAllQuery()).withSearchType(COUNT)
				.withIndices("position").withTypes("positions")
				.addAggregation(terms("designations").field("designation")).build();

		Aggregations aggregations = elasticsearchTemplate.query(searchQuery, new ResultsExtractor<Aggregations>() {
			@Override
			public Aggregations extract(SearchResponse response) {
				return response.getAggregations();
			}
		});
		StringTerms subjects = (StringTerms) aggregations.asMap().get("designations");
		for (Terms.Bucket bucket : subjects.getBuckets()) {
			PositionAggregate positionAggregate = new PositionAggregate();
			positionAggregate.setDesignation((String) bucket.getKey());
			positionAggregate.setTotal(bucket.getDocCount());
			list.add(positionAggregate);
		}
		return list;
	}

	public List<Position> retrievePositionsbasedOnPositionType(String positionType) {
		Query query = new Query();
		query.addCriteria(Criteria.where("positionType").regex(positionType));
		List<Position> positionDetail = mongoOperations.find(query, Position.class);
		return positionDetail;
	}

	public void updatePublishStatus(Position position) {
		mongoOperations.save(position);
	}
}
