package com.acco.dataflow;

import java.util.List;
import java.util.Map;

public interface ObservableData {
	public void addSubs(Subscriber s);
	public void deleteSubs(Subscriber s);
	public void notifySubs();
	public List<List<Map<String,Object>>> getData();
}
