package com.irecruit.service;

import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.irecruit.pojo.Requisition;
import com.irecruit.pojo.RequisitionApproverDetails;


public interface IRequisitionService {
	public void prepareRequisition(Requisition requisition);
	public RequisitionApproverDetails updateRequisition(Requisition requisition) throws AddressException, MessagingException;
	public void rejectRequisition(Requisition requisition);
	public void cloneRequisition(Requisition requisition);
	public List<Requisition> retrieveAllRequistions();
	public String approveRequisition(Requisition requisition) throws AddressException, MessagingException;
	public Requisition retrieveRequisitionBasedOnId(String requisitionId);
	void updateRequisition1(Requisition requisition) throws AddressException,
			MessagingException;
	
}