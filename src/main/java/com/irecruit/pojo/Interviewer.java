package com.irecruit.pojo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Interviewer {
	List<RoundUser> technicalRound1;
	List<RoundUser> technicalRound2;
	List<RoundUser> hrRound;
	List<RoundUser> managerRound;
	/*
	public Interviewer(List<RoundUser> technicalRound1, List<RoundUser> technicalRound2, List<RoundUser> hrRound,
			List<RoundUser> managerRound) {
		super();
		this.technicalRound1 = technicalRound1;
		this.technicalRound2 = technicalRound2;
		this.hrRound = hrRound;
		this.managerRound = managerRound;
	}
	public Interviewer() {
	}
	public List<RoundUser> getTechnicalRound1() {
		return technicalRound1;
	}
	public void setTechnicalRound1(List<RoundUser> technicalRound1) {
		this.technicalRound1 = technicalRound1;
	}
	public List<RoundUser> getTechnicalRound2() {
		return technicalRound2;
	}
	public void setTechnicalRound2(List<RoundUser> technicalRound2) {
		this.technicalRound2 = technicalRound2;
	}
	public List<RoundUser> getHrRound() {
		return hrRound;
	}
	public void setHrRound(List<RoundUser> hrRound) {
		this.hrRound = hrRound;
	}
	public List<RoundUser> getManagerRound() {
		return managerRound;
	}
	public void setManagerRound(List<RoundUser> managerRound) {
		this.managerRound = managerRound;
	}
	
	*/
}
