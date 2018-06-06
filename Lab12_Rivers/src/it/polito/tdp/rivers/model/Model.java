package it.polito.tdp.rivers.model;

import java.time.LocalDate;
import java.util.List;

import it.polito.tdp.rivers.db.RiversDAO;

public class Model {
	private RiversDAO dao;
	private RiverIdMap riverIdMap;
	private LocalDate startDate;
	private LocalDate endDate;
	
	private River selectedRiver;
	
	
	public Model() {
		dao = new RiversDAO();
		riverIdMap = new RiverIdMap();
	}
	
	public List<River> getAllRivers() {
		return dao.getAllRivers(riverIdMap);
	}


	public LocalDate getStartDate(River river) {
		if(river.getFlows() ==null || river.getFlows().isEmpty()) {
			this.updateSelectedRiver(river);
		}
		return river.getStartDate();			
	}

	public LocalDate getEndDate(River river) {
		if(river.getFlows() ==null || river.getFlows().isEmpty()) {
			this.updateSelectedRiver(river);
		}
		return river.getEndDate();
	}

	public int getNumMeasurement(River river) {
		if(river.getFlows() ==null || river.getFlows().isEmpty()) {
			this.updateSelectedRiver(river);
		}
		return river.getFlows().size();
	}

	public String getFMed(River river) {
		if(river.getFlows() ==null || river.getFlows().isEmpty()) {
			this.updateSelectedRiver(river);
		}
		return Double.toString(river.getFlowAvg());
	}

	public void updateSelectedRiver(River river) {
		this.selectedRiver = river;
		this.selectedRiver.updateAllData((this.dao.getFlowsForRiver(this.selectedRiver)));	
	}
	
	







}