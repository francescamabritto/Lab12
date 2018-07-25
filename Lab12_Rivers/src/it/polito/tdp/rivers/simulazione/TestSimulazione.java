package it.polito.tdp.rivers.simulazione;

import java.util.PriorityQueue;

import it.polito.tdp.rivers.model.Model;
import it.polito.tdp.rivers.model.River;

public class TestSimulazione {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Simulazione sim = new Simulazione();
        Model model = new Model();
        
		River r = new River(2, "Vatnsdalsa River");
		model.updateSelectedRiver(r);
		System.out.println(r.toString());
		
		sim.init(1, r);
		PriorityQueue<Event> queue = sim.getQueue();
		
		Event[] arr = new Event[10];
		
		for(Event d: queue.toArray(arr))
			System.out.println(d);
		
		sim.run();
		System.out.format("AVEGARE FLUX IN: %f\n",  sim.getfMed());
		System.out.format("AVERAGE LEVEL: %f NUM FAILURES: %d\n", sim.getcMed(), sim.getN());
		
	}

}
