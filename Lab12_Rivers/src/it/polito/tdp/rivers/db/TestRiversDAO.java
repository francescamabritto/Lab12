package it.polito.tdp.rivers.db;

import it.polito.tdp.rivers.model.RiverIdMap;

public class TestRiversDAO {

	public static void main(String[] args) {
		RiversDAO dao = new RiversDAO();
		RiverIdMap riverIdMap = new RiverIdMap();
		System.out.println(dao.getAllRivers(riverIdMap));
	}

}
