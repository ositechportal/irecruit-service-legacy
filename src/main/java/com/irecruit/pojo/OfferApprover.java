package com.irecruit.pojo;

import java.util.Date;

import org.springframework.data.annotation.LastModifiedDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OfferApprover { 
	String emailId;
	String name;
	boolean isApproved;
	String comment;
	String status;
	@LastModifiedDate
	private Date updatedDate;
}
