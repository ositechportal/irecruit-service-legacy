package com.irecruit.pojo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document(indexName = "requisitions",type = "requisition", shards = 1, replicas = 0, refreshInterval = "-1")
public class Requisition extends AuditEntity{
	@Id
	String requisitionId;
	String position;
	String noOfPositions;
	String client;
	String minExpYear;
	String maxExpYear;
	String requisitionDate;
	String targetDate;
	String location;
	String jobDescription;
	String jobTitle;
	List<Qualification> qualifications;
	ArrayList<String> skillType;
	RequisitionUser approval1;
	RequisitionUser approval2;
	String comment;
	UserVO requisitionManager;
	String status;
}
