package com.irecruit.pojo;

import java.util.List;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@org.springframework.data.elasticsearch.annotations.Document(indexName = "jobDescriptions",type = "jobDescription", shards = 1, replicas = 0, refreshInterval = "-1")
public class JobDescription {
	@Id
	String jobDescriptionName;
	String client;
	List<String> skills;
	String jobDescriptionDetails;
}