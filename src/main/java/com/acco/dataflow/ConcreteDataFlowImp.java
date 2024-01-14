package com.acco.dataflow;

import java.util.List;
import java.util.Map;

public class ConcreteDataFlowImp implements ObservableData {
	private List<List<Map<String,Object>>> data;
	private List<Subscriber> subscribers;
	
	
	
	@Override
	public void addSubs(Subscriber s) {
		subscribers.add(s);

	}

	@Override
	public void deleteSubs(Subscriber s) {
		subscribers.remove(s);

	}

	@Override
	public void notifySubs() {
		for(Subscriber s:subscribers)
		{
			s.update(this);
		}

	}

	@Override
	public List<List<Map<String, Object>>> getData() {
		return data;
	}

}
