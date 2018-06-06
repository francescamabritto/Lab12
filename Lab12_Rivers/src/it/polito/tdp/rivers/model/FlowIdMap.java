package it.polito.tdp.rivers.model;

import java.util.HashMap;

public class FlowIdMap extends HashMap<Integer, Flow>{
	
	public Flow get(Flow flow) {
		Flow old = super.get(flow.getId());
		if(old != null) 
			return old;
		else
			old = flow;
		
		super.put(old.getId(), old);
		return old;
	
	}
	
}
