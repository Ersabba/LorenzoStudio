package com.ericsson.urm.device.driver;

import java.util.List;
import java.util.Map;

public interface IDriverStatistics {
	public int getCreatedCommands();
	public int getSentCommandsSuccess();
	
	public List<Map.Entry<Integer, Boolean>> getHistoryCommandResults();
}
