package it.polito.tdp.rivers.db;

import java.sql.Connection;

public class TestConnection {

	public static void main(String[] args) {

		
		
		Connection conn = DBConnect.getConnection();
		
		if(conn==null)
			System.out.print("Connection failed.");
		else
			System.out.print("Connection successful.");

	}
}
