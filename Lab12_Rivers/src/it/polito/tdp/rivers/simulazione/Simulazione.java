package it.polito.tdp.rivers.simulazione;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import it.polito.tdp.rivers.model.River;



public class Simulazione {
	
	// Coda degli eventi
	private PriorityQueue<Event> queue;
	
	// Parametri di simulazione 
	private double fMed;
	private double fOutMin;
	private List< Double> listaC ;
	private double sumCForDay = 0.0;
	private double p = 0.05;

	// Modello del mondo // Stato del sistema 
	private double Q;
	private double c;
	
	
	// Valori da calcolare // Output
	 private int n; // numero di giorni in cui non si è potuta garantire l’erogazione minima;
	 private double cMed; // occupazione media del bacino nel corso della simulazione.
	
	
	public void init(int k, River r) {
		
		// inizializzo le variabili di simulazione
	
		this.fMed = r.getFlowAvg() * 60 * 24;
		this.Q = k * fMed  * 30 ;
		this.cMed = 0;
		this.listaC = new ArrayList<>();
		this.n = 0;
		
		this.c = Q / 2 ;
		this.listaC.add(c);
		
		// inizializza la coda degli eventi
		this.queue = new PriorityQueue<>();

		
		for(int i = 0; i < 365; i++) {
			
			if(Math.random() > this.p) 
				this.fOutMin =  0.8 * fMed;
			else 
				this.fOutMin =  10 * 0.8 * fMed;
			
			this.queue.add(new Event(fOutMin, i));
		}
		
	}
	
	public void run() {
		Event e;
		while((e = queue.poll()) != null) {
			processEvent(e);
			System.out.println(e);
		}
	}

	private void processEvent(Event e) {
		double fDiff = this.fMed - e.getFOut();
		if(fDiff >= 0) {
			this.listaC.add(fDiff);
		}
		else {
			if((this.c + fDiff) >= 0) {
				c = c + fDiff;
				this.listaC.add(c);
			}else {
				c = 0; 
				this.listaC.add(c);
				this.n ++ ;
			}
		}
		
		for(Double d: listaC) {
			sumCForDay += d;
		}
		this.cMed = sumCForDay/listaC.size();

	}

	public int getN() {
		return n;
	}

	public double getcMed() {
		return cMed;
	}

	public PriorityQueue<Event> getQueue() {
		return this.queue;
	}

	public double getfMed() {
		return fMed;
	}
	
	
	
	
}
