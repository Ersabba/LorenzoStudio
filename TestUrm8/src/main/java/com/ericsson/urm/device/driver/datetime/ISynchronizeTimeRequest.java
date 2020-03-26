package com.ericsson.urm.device.driver.datetime;

import java.io.Serializable;
import java.util.Date;

public interface ISynchronizeTimeRequest extends Serializable {

	public Date getDate();

}
