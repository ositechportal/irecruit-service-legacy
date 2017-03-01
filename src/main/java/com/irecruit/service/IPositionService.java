package com.irecruit.service;

import java.util.List;

import com.irecruit.pojo.Position;
import com.irecruit.pojo.PositionAggregate;
import com.irecruit.pojo.Requisition;

public interface IPositionService {
	public void preparePosition(Position position);

	public void updatePosition(Position position);

	public List<Position> retrievePositionByClient(String client);

	public List<Position> retrieveAllPositions();

	public List<Position> retrievePositionsbasedOnDesignation(String designation);

	public Position retrievePositionsbasedOnJobCode(String jobcode);

	public List<Position> retrievePositionsbasedOnRequisitionId(String requisitionId);

	public Position deletePositionBasedOnJC(String jobcode);

	public List<Position> retrievePositionbasedOnLocation(String location);

	public List<PositionAggregate> retrieveAllPositionsAggregate();

	public void createRequitionPosition(Requisition requisition);

	public List<Position> retrievePositionsbasedOnPositionType(String positionType);
}
