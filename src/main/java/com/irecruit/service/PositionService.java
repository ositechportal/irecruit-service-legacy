package com.irecruit.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irecruit.elastic.repository.PositionSearchService;
import com.irecruit.mongo.repository.PositionRepository;
import com.irecruit.mongo.repository.SequenceRepository;
import com.irecruit.pojo.Position;
import com.irecruit.pojo.PositionAggregate;
import com.irecruit.pojo.Requisition;

@Service
public class PositionService implements IPositionService {

	private static final String ACTIVE = "Active";
	private static final String PRIORITY_LOW = "Low";

	@Autowired
	PositionRepository positionRepository;

	@Autowired
	SequenceRepository sequenceRepository;

	@Autowired
	PositionSearchService positionSearchService;

	public void preparePosition(Position position) {
		positionRepository.preparePosition(position);
	}

	public void updatePosition(Position position) {
		try {
			position.setUpdatedDate(new Date());
			Position updatedPosition = positionRepository.updatePosition(position);
			positionSearchService.updatePositionIndex(updatedPosition);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Position> retrievePositionByClient(String client) {
		return positionRepository.retrievePositionByClient(client);
	}

	public List<Position> retrieveAllPositions() {
		return positionRepository.retrieveAllPositions();
	}

	public List<Position> retrievePositionsbasedOnDesignation(String designation) {
		return positionRepository.retrievePositionsbasedOnDesignation(designation);
	}

	public Position retrievePositionsbasedOnJobCode(String jobcode) {
		return positionRepository.retrievePositionsbasedOnJobCode(jobcode);
	}

	public List<Position> retrievePositionsbasedOnRequisitionId(String requisitionId) {
		return positionRepository.retrievePositionsbasedOnrequisitionId(requisitionId);
	}
	
	public Position deletePositionBasedOnJC(String jobcode) {
		return positionRepository.deletePositionBasedOnJC(jobcode);
	}

	public List<Position> retrievePositionbasedOnLocation(String location) {
		return positionRepository.retrievePositionbasedOnLocation(location);
	}

	public List<PositionAggregate> retrieveAllPositionsAggregate() {
		return positionRepository.retrieveAllPositionsAggregateFromElastic();
	}
	
	public List<Position> retrievePositionsbasedOnPositionType(String positionType) {
		return positionRepository.retrievePositionsbasedOnPositionType(positionType);
	}
	

	@Override
	public void createRequitionPosition(Requisition requisition) {
		for (int i = 1; i <= Integer.valueOf(requisition.getNoOfPositions()); i++) {
			try {
				Position position = buildPosition(requisition, i);
				positionRepository.preparePosition(position);
				positionSearchService.addPositionIndex(position);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private Position buildPosition(Requisition requisition, int sequence) {
		Position position = new Position();
		ArrayList<String> interviewRounds = getInterviewRounds();
		position.setStatus(ACTIVE);
		position.setPriority(PRIORITY_LOW);
		position.setClient(requisition.getClient());
		position.setRequisitionId(requisition.getRequisitionId());
		position.setDesignation(requisition.getPosition());
		position.setLocation(requisition.getLocation());
		position.setMinExpYear(requisition.getMinExpYear());
		position.setMaxExpYear(requisition.getMaxExpYear());
		position.setPrimarySkills(requisition.getSkillType());
		position.setInterviewRounds(interviewRounds);
		position.setHiringManager(requisition.getRequisitionManager());
		position.setJobcode("JOB_" + sequenceRepository.getNextSequenceId("JOB"));
		position.setCreatedBy(requisition.getCreatedBy());
		position.setUpdatedBy(requisition.getCreatedBy());
		position.setJobProfile(requisition.getJobDescription());
		position.setTargetDate(requisition.getTargetDate());
		position.setUpdatedDate(new Date());
		position.setCreatedDate(new Date());
		position.setUpdatedBy(requisition.getUpdatedBy());
		position.setCreatedBy(requisition.getUpdatedBy());
		return position;
	}

	private ArrayList<String> getInterviewRounds() {
		ArrayList<String> interviewRounds = new ArrayList<>();
		interviewRounds.add("Technical Round 1");
		interviewRounds.add("Technical Round 2");
		interviewRounds.add("Hr Round");
		interviewRounds.add("Manager Round");
		return interviewRounds;
	}
}