package com.irecruit.elastic.repository;
import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.irecruit.pojo.Requisition;

public interface RequisitionIndexRepository extends ElasticsearchRepository<Requisition, String> {
	List<Requisition> findByPositionStartingWithOrClientStartingWithAllIgnoreCaseOrStatusStartingWithOrderByUpdatedDateDesc(String requisitionId, String position, String client,String status);
	Requisition findByRequisitionIdStartingWithAllIgnoreCase(String requisitionId);
	List<Requisition> findByCreatedBy(String CreatedById);
	
}