package com.ericsson.urm.device.driver.programmingdisplay;

import java.io.Serializable;

import com.ericsson.urm.device.driver.energytotalizer.InstallationParameterRequest;
import com.ericsson.urm.device.driver.registersblockprogramming.Block1;

public class DisplayProgrammingParameterRequest implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	//BT 32
	private InstallationParameterRequest installationParameterRequest = null;

	//BT 40
	private Block1 block1 = null;
	
	public Block1 getBlock1() {
		return block1;
	}
	public void setBlock1(Block1 block1) {
		this.block1 = block1;
	}
	public InstallationParameterRequest getInstallationParameterRequest() {
		return installationParameterRequest;
	}
	public void setInstallationParameterRequest(
			InstallationParameterRequest installationParameterRequest) {
		this.installationParameterRequest = installationParameterRequest;
	}	

}
