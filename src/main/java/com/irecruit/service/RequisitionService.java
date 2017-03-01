package com.irecruit.service;

import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irecruit.elastic.repository.RequisitionSearchService;
import com.irecruit.mongo.repository.RequisitionRepository;
import com.irecruit.pojo.Requisition;
import com.irecruit.pojo.RequisitionApproverDetails;

@Service
public class RequisitionService implements IRequisitionService {
	// TODO:move status code into ENUM
	private static final String REJECTED = "REJECTED";
	private static final String INITIATED = "INITIATED";
	private static final String APPROVED = "APPROVED";
	private static final String PARTIALY_APPROVED = "PARTIALY APPROVED";

	@Autowired
	private RequisitionRepository requisitionRepository;

	@Autowired
	RequisitionSearchService requisitionSearchService;

	@Autowired
	PositionService positionService;

	@Autowired
	private JobRequisitionNotificationService jobRequisitionNotificationService;

	private static final String REQUISITION_HAS_APPROVED_SUCCESSFULLY = " Requisition has been approved successfully ";

	@Override
	public void prepareRequisition(Requisition requisition) {
		requisition.setStatus(INITIATED);
		Requisition persistedRequisition = requisitionRepository
				.prepareRequisition(requisition);
		requisitionSearchService.addRequisitionIndex(persistedRequisition);
		try {
			jobRequisitionNotificationService.sendNotification(requisition);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public RequisitionApproverDetails updateRequisition(Requisition requisition)
			throws AddressException, MessagingException {
		Requisition updatereq = requisitionRepository
				.updateRequisition(requisition);
		requisitionSearchService.updateRequisitionIndex(updatereq);
		return jobRequisitionNotificationService.sendNotification(updatereq);
	}

	@Override
	public void updateRequisition1(Requisition requisition)
			throws AddressException, MessagingException {
		Requisition updatereq = requisitionRepository
				.updateRequisition(requisition);
		requisitionSearchService.updateRequisitionIndex(updatereq);

	}

	@Override
	public String approveRequisition(Requisition requisition)
			throws AddressException, MessagingException {
		if ((requisition.getApproval2() == null && requisition.getApproval1()
				.isApproved())
				|| (requisition.getApproval2() != null
						&& requisition.getApproval1().isApproved() && requisition
						.getApproval2().isApproved())) {
			requisition.setStatus(APPROVED);
			positionService.createRequitionPosition(requisition);
			updateRequisition1(requisition);
			
			try {
				jobRequisitionNotificationService.sendNotificationForFullyApproved(requisition);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
			
			return requisition.getRequisitionId()
					+ REQUISITION_HAS_APPROVED_SUCCESSFULLY + " and "
					+ requisition.getNoOfPositions()
					+ " positions created successfully";
		} else {
			requisition.setStatus(PARTIALY_APPROVED);
			updateRequisition1(requisition);

			try {
				jobRequisitionNotificationService.sendNotification(requisition);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
			return requisition.getRequisitionId()
					+ REQUISITION_HAS_APPROVED_SUCCESSFULLY
					+ ", sent approve request notification to "
					+ requisition.getApproval2().getName();
		}

	}

	@Override
	public Requisition retrieveRequisitionBasedOnId(String requisitionId) {
		return requisitionRepository
				.retrieveRequisitionBasedOnId(requisitionId);
	}

	@Override
	public void rejectRequisition(Requisition requisition) {
		requisition.setStatus(REJECTED);
		try {
			updateRequisition1(requisition);
			jobRequisitionNotificationService.sendNotification(requisition);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (javax.mail.MessagingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void cloneRequisition(Requisition requisition) {
		prepareRequisition(requisition);
	}

	@Override
	public List<Requisition> retrieveAllRequistions() {
		return requisitionRepository.retrieveAllRequisitions();
	}
}