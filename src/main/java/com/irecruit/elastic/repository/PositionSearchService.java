package com.irecruit.elastic.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.irecruit.pojo.Position;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PositionSearchService {

	@Autowired
	private PositionIndexRepository positionIndexRepository;

	@Autowired
	private PositionIndexQueryRepository indexRepositoryImpl;

	public List<Position> getAllPostions() {
		Iterable<Position> position = positionIndexRepository.findAll();
		List<Position> positionList = Lists.newArrayList(position);
		/*try {
			Collections.sort(positionList, new Comparator<Position>() {
				public int compare(Position o1, Position o2) {
					return o2.getUpdatedDate().compareTo(o1.getUpdatedDate());
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}*/

		return positionList;
	}

	public List<Position> getPostionByDesignationOrClient(String data) throws Exception {
		List<Position> positionList = indexRepositoryImpl
				.findPositionsByDesignationStartingWithOrClientStartingWithAllIgnoreCase(data);
		return positionList;

	}

	public Position addPositionIndex(Position position) {
		Position positionData = positionIndexRepository.save(position);
		return positionData;
	}

	public void updatePositionIndex(Position position) throws Exception {
		if (positionIndexRepository.exists(position.getJobcode())) {
			positionIndexRepository.delete(position.getJobcode());
			addPositionIndex(position);
		} else {
			addPositionIndex(position);
		}
	}

}
