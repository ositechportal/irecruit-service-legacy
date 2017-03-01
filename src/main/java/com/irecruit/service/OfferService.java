package com.irecruit.service;

import javax.mail.MessagingException;

import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irecruit.mongo.repository.OfferRepository;
import com.irecruit.pojo.Offer;

@Service
public class OfferService{

	@Autowired
	OfferRepository OfferRepository;

	@Autowired
	private NotificationService notificationService;
	
	public void prepareOffer(Offer offerDetail) {
		OfferRepository.saveOffer(offerDetail);
	}
	
	public Offer getOfferDetail(String emailId) {
		return OfferRepository.retrieveOfferDetails(emailId);
	}
	
	public void offerToBeApproved(Offer offer) {
		try {
			notificationService.sendOfferApprovalNotification(offer);
		} catch (ResourceNotFoundException | ParseErrorException | MethodInvocationException | MessagingException e) {
			e.printStackTrace();
		}
	}
	public void approveOffer(Offer offer) {
		try {
			notificationService.approvedNotification(offer);;
		} catch (ResourceNotFoundException | ParseErrorException | MethodInvocationException | MessagingException e) {
			e.printStackTrace();
		}
	}
	
}