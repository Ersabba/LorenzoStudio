package com.ericsson.urm.persistence.dto.mgre.datatype;

import java.util.Date;

import com.ericsson.mgre.enumeration.Provenienza;
import com.ericsson.urm.device.driver.datatype.ComponentId;

public class CrzRegistroAttAss extends CrzRegistro {

	private static final long serialVersionUID = 1L;

	public CrzRegistroAttAss(ComponentId componente, String crz,
			String matricolaLenntCliente, String gen, String t1, String t2,
			String t3, String t4, Date dataRil, Date acqDate,
			Provenienza provenienza, String esito, String crzDate,
			String lenntPrimitivo, String lenntDate, RegEnergyType type) {
		
		super(componente, crz, matricolaLenntCliente, gen, t1, t2, t3, t4, dataRil,
				acqDate, provenienza, esito, crzDate, lenntPrimitivo, lenntDate, type);
		
	}
	
	
	

}
