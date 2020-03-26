package com.ericsson.mgre.ejb.session.reading;

import java.util.HashSet;
import java.util.Set;

import com.ericsson.mgre.datatypes.Componente;
import com.ericsson.urm.persistence.dto.mgre.CurvaCaricoConfig;
import com.ericsson.urm.persistence.dto.mgre.LenntCliente;
import com.ericsson.urm.persistence.dto.mgre.TotAttAss;
import com.ericsson.urm.persistence.dto.mgre.CurvaCaricoConfig.AbilDisponibCampioni;


public class StatoAbilitazioneLenntBO {

	private String				matricola;
	private LenntCliente		lenntCliente;
	private TotAttAss			totAttAss;
	private CurvaCaricoConfig	curvaCaricoConfig;

	
	public CurvaCaricoConfig getCurvaCaricoConfig() {
		return curvaCaricoConfig;
	}

	public StatoAbilitazioneLenntBO(String matricola) {
		if (matricola == null || matricola.length() == 0)
			throw new IllegalArgumentException("Matricola null");
		this.matricola = matricola;
	}

	public void setLenntCliente(LenntCliente lc) {
		if (lc != null && !lc.getMatricolaLenntCliente().equalsIgnoreCase(matricola))
			throw new IllegalArgumentException("Operation not allowed. Lennt id '" + lc.getMatricolaLenntCliente() + "' differs from original id '"
												+ matricola);
		this.lenntCliente = lc;
	}

	public void setTotAttAss(TotAttAss taa) {
		if (taa != null && !taa.getMatricolaLenntCliente().equalsIgnoreCase(matricola))
			throw new IllegalArgumentException("Operation not allowed. Lennt id '" + taa.getMatricolaLenntCliente() + "' differs from original id '"
												+ matricola);
		this.totAttAss = taa;
	}

	public void setCurvaCaricoConfig(CurvaCaricoConfig ccc) {
		if (ccc != null && !ccc.getMatricolaLenntCliente().equalsIgnoreCase(matricola))
			throw new IllegalArgumentException("Operation not allowed. Lennt id '" + ccc.getMatricolaLenntCliente() + "' differs from original id '"
												+ matricola);
		this.curvaCaricoConfig = ccc;
	}

	public String getMatricola() {
		return matricola;
	}

	public boolean isAnagrafatoERaggiunto() {
		return lenntCliente != null && totAttAss != null;
	}

	public boolean isAbilitatoLetturaCampioni() {
		return curvaCaricoConfig != null && AbilDisponibCampioni.A.toString().equals(curvaCaricoConfig.getAbilDisponibCampioni());
	}

	public Set<Componente> getComponentiAbilitateLettura() {
		Set<Componente> componentiAbilitate = new HashSet<Componente>();
		if (isAnagrafatoERaggiunto() && isAbilitatoLetturaCampioni()) {
			if (Boolean.TRUE.equals(curvaCaricoConfig.getAbilAttAss()))
				componentiAbilitate.add(Componente.ATT_ASS);
			if (Boolean.TRUE.equals(curvaCaricoConfig.getAbilAttEr()))
				componentiAbilitate.add(Componente.ATT_ER);
			if (Boolean.TRUE.equals(curvaCaricoConfig.getAbilReattCapAss()))
				componentiAbilitate.add(Componente.REATT_CAP_ASS);
			if (Boolean.TRUE.equals(curvaCaricoConfig.getAbilReattCapEr()))
				componentiAbilitate.add(Componente.REATT_CAP_ER);
			if (Boolean.TRUE.equals(curvaCaricoConfig.getAbilReattIndAss()))
				componentiAbilitate.add(Componente.REATT_IND_ASS);
			if (Boolean.TRUE.equals(curvaCaricoConfig.getAbilReattIndEr()))
				componentiAbilitate.add(Componente.REATT_IND_ER);
		}
		return componentiAbilitate;
	}
}
