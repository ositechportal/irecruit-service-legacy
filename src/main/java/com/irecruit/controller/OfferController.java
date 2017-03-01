package com.irecruit.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import com.irecruit.mongo.repository.OfferRepository;
import com.irecruit.pojo.Offer;
import com.irecruit.pojo.OfferApprover;
import com.irecruit.service.OfferService;

@Controller
public class OfferController {

	private static final String MSG_START = "{\"msg\":\"";
	private static final String MSG_END = "\"}";
	@Autowired
	private OfferService offerService;

	@Autowired
	private OfferRepository offerRepository;

	@ResponseBody
	//@Secured({ "ROLE_ADMIN", "ROLE_HR" })
	@RequestMapping(value = "/save-offer", method = RequestMethod.POST)
	public ResponseEntity<Offer> saveOfferDetails(@RequestBody Offer offer) {
		offerService.prepareOffer(offer);
		return new ResponseEntity<Offer>(offer, HttpStatus.OK);
	}

	@ResponseBody
	//@Secured({ "ROLE_HR", "ROLE_REQUISITION_MANAGER", "ROLE_REQUISITION_APPROVER" })
	@RequestMapping(value = "/offer", method = RequestMethod.GET)
	public ResponseEntity<?> retrieveOffer(@RequestParam(value = "emailId", required = true) String emailId)
			throws Exception {
		Offer offerdetail = offerService.getOfferDetail(emailId);
		return new ResponseEntity<Offer>(offerdetail, HttpStatus.OK);
	}

	@ResponseStatus(HttpStatus.OK)
	//@Secured({ "ROLE_ADMIN", "ROLE_HR" })
	@RequestMapping(value = "/upload-offer-letter", method = RequestMethod.POST)
	public ResponseEntity<String> uploadOfferLetter(HttpServletRequest request,
			@RequestParam(value = "file") MultipartFile multipartFile,
			@RequestParam(value = "candidateId", required = true) String candidateId) throws Exception {
		offerRepository.saveResumeInBucket(multipartFile, candidateId);
		return new ResponseEntity<String>("Resume Uploaded Successfully", HttpStatus.OK);
	}

	//@Secured({ "ROLE_HR" })
	@ResponseBody
	@RequestMapping(value = "/approveOffer", method = RequestMethod.POST)
	public ResponseEntity<?> offerToBeApproved(@RequestBody Offer offer) throws Exception {
		offerService.offerToBeApproved(offer);
		if (offer.getApprovalList() == null) {
			offer.setApprovalList(new ArrayList<OfferApprover>());
		}
		offer.getApprovalList().add(offer.getApproval());
		offer.getApprovalList().get(offer.getApprovalList().size()-1).setComment(null);
		offer.getApprovalList().get(offer.getApprovalList().size()-1).setStatus(null);
		offerService.prepareOffer(offer);
		String jsonObj = MSG_START + "Offer saved and Notification send to " + offer.getApproval().getName()
				+ " Successfully" + MSG_END;
		return new ResponseEntity<String>(jsonObj, HttpStatus.OK);
	}

	//@Secured({ "ROLE_REQUISITION_APPROVER" })
	@ResponseBody
	@RequestMapping(value = "/offerStatus", method = RequestMethod.POST)
	public ResponseEntity<?> approveOffer(@RequestBody Offer offer) throws Exception {
		offerService.approveOffer(offer);
		if(offer.getApprovalList().size()>0){
			offer.getApprovalList().get(offer.getApprovalList().size()-1).setComment(offer.getApproval().getComment());
			offer.getApprovalList().get(offer.getApprovalList().size()-1).setStatus(offer.getApproval().getStatus());
			offer.getApprovalList().get(offer.getApprovalList().size()-1).setApproved(offer.getApproval().isApproved());
		}
		offerService.prepareOffer(offer);
		
		String jsonObj = MSG_START + "Offer saved and Notification send to " + offer.getRecruiter().getName()
				+ " Successfully" + MSG_END;
		return new ResponseEntity<String>(jsonObj, HttpStatus.OK);
	}
}
