package com.ericsson.urm.persistence.dto.mgre.datatype;

import java.util.Date;

import com.ericsson.mgre.enumeration.Provenienza;
import com.ericsson.urm.device.driver.datatype.ComponentId;

public class CrzRegistroEr extends CrzRegistro {

	private static final long serialVersionUID = 1L;
	
	private String reattivaInduttivaErogata;
	private String reattivaCapacitativaErogata;

	
	public CrzRegistroEr(ComponentId componente, String crz,
			String matricolaLenntCliente, String gen, String t1, String t2,
			String t3, String t4, Date dataRil, Date acqDate,
			Provenienza provenienza, String esito, String crzDate,
			String lenntPrimitivo, String lenntDate,
			String reattivaInduttivaErogata, String reattivaCapacitativaErogata, RegEnergyType type) {
		super(componente, crz, matricolaLenntCliente, gen, t1, t2, t3, t4,
				dataRil, acqDate, provenienza, esito, crzDate, lenntPrimitivo,
				lenntDate, type);
		this.reattivaInduttivaErogata = reattivaInduttivaErogata;
		this.reattivaCapacitativaErogata = reattivaCapacitativaErogata;
	}

	public String getReattivaInduttivaErogata() {
		return reattivaInduttivaErogata;
	}

	public void setReattivaInduttivaErogata(String reattivaInduttivaErogata) {
		this.reattivaInduttivaErogata = reattivaInduttivaErogata;
	}

	public String getReattivaCapacitativaErogata() {
		return reattivaCapacitativaErogata;
	}

	public void setReattivaCapacitativaErogata(String reattivacapacitativaErogata) {
		this.reattivaCapacitativaErogata = reattivacapacitativaErogata;
	}
	
}
