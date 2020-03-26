package com.ericsson.mgre.interruzioni;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.ericsson.mgre.exception.CsvCabinaException;
import com.ericsson.mgre.exception.CsvCabinaException.ErrorCode;
import com.ericsson.urm.persistence.dto.mgre.ClusterCabina;
import com.ericsson.urm.persistence.dto.mgre.ClusterCcs;
import com.ericsson.urm.persistence.dto.mgre.ClusterCsvInvalido;
import com.ericsson.urm.persistence.dto.mgre.ClusterInterruttore;
import com.ericsson.urm.persistence.dto.mgre.datatype.StatoClusterCabina;
import com.ericsson.urm.util.DateUtil;

public class CsvCabinaGUI implements Serializable {
	private static final long	serialVersionUID	= 1L;

	public static final String DATE_FORMAT 				= 		"dd/MM/yyyy";
	public static final String SEPARATOR 			= 		" "; // deve essere riconoscibile dalla split senza regexp
	
	private List<ClusterCsvInvalido> clusterCsvInvalidoList = null;
	private ClusterCabina clusterCabina = null;
	private Source source = null;
	
	public static enum Source {
		CSV,
		CABINA
	}
	
	public CsvCabinaGUI(List<ClusterCsvInvalido> clusterCsvInvalidoList, ClusterCabina clusterCabina, Source source) {
		if (source == null)
			throw new IllegalArgumentException("source is required.");
		
		if (source == Source.CSV && (clusterCsvInvalidoList == null || clusterCsvInvalidoList.isEmpty())) 
			throw new CsvCabinaException(ErrorCode.OPERATION_NOT_ALLOWED);
		
		if (source == Source.CABINA && clusterCabina == null) 
			throw new CsvCabinaException(ErrorCode.OPERATION_NOT_ALLOWED);
		
		switch (source) {
			case CSV:
				this.clusterCsvInvalidoList = clusterCsvInvalidoList;
				break;
			case CABINA:
				this.clusterCabina = clusterCabina;
				break;
			default:
				throw new CsvCabinaException(ErrorCode.INTERNAL);
		}
		
		this.source = source;
	}
	
	public List<ClusterCsvInvalido> getClusterCsvInvalidoList() {
		return clusterCsvInvalidoList;
	}

	public ClusterCabina getClusterCabina() {
		return clusterCabina;
	}

	/*
	public void setClusterCsvInvalidoList(List<ClusterCsvInvalido> clusterCsvInvalidoList) {
		this.clusterCsvInvalidoList = clusterCsvInvalidoList;
	}


	public void setClusterCabina(ClusterCabina clusterCabina) {
		this.clusterCabina = clusterCabina;
	}
	

	public void setSource(Source source) {
		this.source = source;
	}
	*/

	public Source getSource() {
		return source;
	}

	public String getId() {
		switch (source) {
			case CSV:
				return getNomeFile() + "|" + getDataAcquisizione().getTime();
			case CABINA:
				return Long.toString(clusterCabina.getIdClusterCabina());
			default: 
				throw new CsvCabinaException(ErrorCode.INTERNAL);
		}
	}
	
	public Long getId(int i) {
		switch (source) {
			case CSV:
				return clusterCsvInvalidoList.get(i).getId();
			case CABINA:
				int k = 0;
				Iterator<ClusterCcs> it = clusterCabina.getConcentratori().iterator();
				
				while(it.hasNext()) {
					ClusterCcs clusterCcs = it.next();
					Iterator<ClusterInterruttore> it2 = clusterCcs.getInterruttori().iterator();
					
					while(it2.hasNext()) {
						ClusterInterruttore ci = it2.next();
						
						if (k == i)
							return ci.getIdClusterInterruttore();
						
						k++;
					}
				}
				throw new IllegalArgumentException("Wrong index value: " + i);
			default: 
				throw new CsvCabinaException(ErrorCode.INTERNAL);
		}
	}
	
	public int getRecordCount() {
		switch (source) {
			case CSV:
				return clusterCsvInvalidoList.size();
			case CABINA:
				int i = 0;
				for (ClusterCcs cc : clusterCabina.getConcentratori()) 
					i += cc.getInterruttori().size();
				
				return i;
			default: 
				throw new CsvCabinaException(ErrorCode.INTERNAL);
		}
	}
	
	public String getNomeFile() {
		switch (source) {
			case CSV:
				return clusterCsvInvalidoList.get(0).getFileName();
			case CABINA:
				return clusterCabina.getFileName();
			default: 
				throw new CsvCabinaException(ErrorCode.INTERNAL);
		}
	}
	
	public String getCodCabina() {
		switch (source) {
			case CSV:
				Set<String> codCabinaSet = new HashSet<String>();
				String codCabinaList = "";
				
				for(ClusterCsvInvalido clusterCsvInvalido : clusterCsvInvalidoList) 
					codCabinaSet.add(clusterCsvInvalido.getCodCabinaSecondaria());
				
				for (String codCabina : codCabinaSet) 
					codCabinaList += codCabina + SEPARATOR;
				
				return codCabinaList.trim();
			case CABINA:
				return clusterCabina.getCodCabinaSecondaria();
			default: 
				throw new CsvCabinaException(ErrorCode.INTERNAL);
		}
	}
	
	public String getDataInterruzione() {
		switch (source) {
			case CSV:
				Set<String> dataInterruzioneSet = new HashSet<String>();
				String dataInterruzioneList = "";
				
				for(ClusterCsvInvalido clusterCsvInvalido : clusterCsvInvalidoList) 
					dataInterruzioneSet.add("" + clusterCsvInvalido.getDataInterruzione());
				
				for (String dataInterruzione : dataInterruzioneSet) 
					dataInterruzioneList += dataInterruzione + SEPARATOR;
				
				return dataInterruzioneList.trim();
			case CABINA:
				return DateUtil.formatDate(clusterCabina.getDataInterruzione(), DATE_FORMAT);
			default: 
				throw new CsvCabinaException(ErrorCode.INTERNAL);
		}
	}
	
	public StatoClusterCabina getStato() {
		switch (source) {
			case CSV:
				return StatoClusterCabina.NON_VALIDO;
			case CABINA:
				return clusterCabina.getStato();
			default: 
				throw new CsvCabinaException(ErrorCode.INTERNAL);
		}
	}
	
	public String getCodCabina(int i) {
		switch (source) {
			case CSV:
				return clusterCsvInvalidoList.get(i).getCodCabinaSecondaria();
			case CABINA:
				return clusterCabina.getCodCabinaSecondaria();
			default: 
				throw new CsvCabinaException(ErrorCode.INTERNAL);
		}
	}
	
	public void setCodCabina(String codCabina, int i) {
		switch (source) {
			case CSV:
				clusterCsvInvalidoList.get(i).setCodCabinaSecondaria(codCabina);
				break;
			case CABINA:
				throw new CsvCabinaException(ErrorCode.OPERATION_NOT_ALLOWED);
			default: 
				throw new CsvCabinaException(ErrorCode.INTERNAL);
		}
	}
	
	public String getCodConcentratore(int i) {
		switch (source) {
			case CSV:
				return clusterCsvInvalidoList.get(i).getCodConcentratore();
			case CABINA:
				int k = 0;
				Iterator<ClusterCcs> it = clusterCabina.getConcentratori().iterator();
				
				while(it.hasNext()) {
					ClusterCcs clusterCcs = it.next();
					Iterator<ClusterInterruttore> it2 = clusterCcs.getInterruttori().iterator();
					
					while(it2.hasNext()) {
						ClusterInterruttore ci = it2.next();
						
						if (k == i)
							return ci.getClusterCcs().getCodConcentratore();
						
						k++;
					}
				}
				throw new IllegalArgumentException("Wrong index value: " + i);
			default: 
				throw new CsvCabinaException(ErrorCode.INTERNAL);
		}
	}
	
	public void setCodConcentratore(String codConcentratore, int i) {
		switch (source) {
			case CSV:
				clusterCsvInvalidoList.get(i).setCodConcentratore(codConcentratore);
				break;
			case CABINA:
				if (codConcentratore == null || codConcentratore.isEmpty())
					throw new IllegalArgumentException("CodConcentratore cannot be null or empty");
				Set<String> codiciCcs = new HashSet<String>();
				for (ClusterCcs ccs : clusterCabina.getConcentratori())
					codiciCcs.add(ccs.getCodConcentratore());
				
				int k = 0;
				Iterator<ClusterCcs> it = clusterCabina.getConcentratori().iterator();
				boolean found = false;
				while(it.hasNext()) {
					ClusterCcs clusterCcs = it.next();
					Iterator<ClusterInterruttore> it2 = clusterCcs.getInterruttori().iterator();
					
					while(it2.hasNext()) {
						ClusterInterruttore ci = it2.next();
						
						if (k == i) {
							found = true;
							String oldCodCcs = ci.getClusterCcs().getCodConcentratore();
							if (oldCodCcs.equals(codConcentratore))
								return;
							else {
								// se si vuole cambiare ccs, bisogna vedere se esiste già quel ccs. in tal caso si sposta solo l'interrutt.
								if (codiciCcs.contains(codConcentratore)) {
									for (ClusterCcs ccs : clusterCabina.getConcentratori()) {
										if (ccs.getCodConcentratore().equals(codConcentratore)) {
											ccs.getInterruttori().add(ci);
											ci.setClusterCcs(ccs);
										}
									}
								}
								else {
									// non esisteva, va creato il nuovo ccs
									ClusterCcs newCcs = new ClusterCcs();
									newCcs.setClusterCabina(clusterCcs.getClusterCabina());
									clusterCabina.getConcentratori().add(newCcs);
									newCcs.setCodConcentratore(codConcentratore);
									newCcs.setCodTrasformatore(clusterCcs.getCodTrasformatore());
									newCcs.getInterruttori().add(ci);
									newCcs.setMatricolaTrasformatore(clusterCcs.getMatricolaTrasformatore());
									newCcs.setStatoFileInterruzioni(clusterCcs.getStatoFileInterruzioni());
									newCcs.setStatoFileLogInterruzioni(clusterCcs.getStatoFileLogInterruzioni());
									ci.setClusterCcs(newCcs);
								}
								it2.remove();
								break;
							}
						}
						k++;
					}
				}
				if (!found)
					throw new IllegalArgumentException("Wrong index value: " + i);
				
				for (Iterator<ClusterCcs> ccsIter = clusterCabina.getConcentratori().iterator(); ccsIter.hasNext(); ) {
					if (ccsIter.next().getInterruttori().isEmpty())
						ccsIter.remove();
				}
				break;
			default: 
				throw new CsvCabinaException(ErrorCode.INTERNAL);
		}
	}
	
	public String getCodInterruttore(int i) {
		switch (source) {
			case CSV:
				return clusterCsvInvalidoList.get(i).getCodInterruttore();
			case CABINA:
				int k = 0;
				Iterator<ClusterCcs> it = clusterCabina.getConcentratori().iterator();
				
				while(it.hasNext()) {
					ClusterCcs clusterCcs = it.next();
					Iterator<ClusterInterruttore> it2 = clusterCcs.getInterruttori().iterator();
					
					while(it2.hasNext()) {
						ClusterInterruttore ci = it2.next();
						
						if (k == i)
							return ci.getCodInterruttore();
						
						k++;
					}
				}
				throw new IllegalArgumentException("Wrong index value: " + i);
			default: 
				throw new CsvCabinaException(ErrorCode.INTERNAL);
		}
	}
	
	public void setCodInterruttore(String codInterruttore, int i) {
		switch (source) {
			case CSV:
				clusterCsvInvalidoList.get(i).setCodInterruttore(codInterruttore);
				break;
			case CABINA:
				int k = 0;
				Iterator<ClusterCcs> it = clusterCabina.getConcentratori().iterator();
				
				while(it.hasNext()) {
					ClusterCcs clusterCcs = it.next();
					Iterator<ClusterInterruttore> it2 = clusterCcs.getInterruttori().iterator();
					
					while(it2.hasNext()) {
						ClusterInterruttore ci = it2.next();
						
						if (k == i) {
							ci.setCodInterruttore(codInterruttore);
							return;
						}
						
						k++;
					}
				}
				throw new IllegalArgumentException("Wrong index value: " + i);
			default: 
				throw new CsvCabinaException(ErrorCode.INTERNAL);
		}
	}
	
	public String getDataInterruzione(int i) {
		switch (source) {
			case CSV:
				return clusterCsvInvalidoList.get(i).getDataInterruzione();
			case CABINA:
				return DateUtil.formatDate(clusterCabina.getDataInterruzione(), DATE_FORMAT);
			default: 
				throw new CsvCabinaException(ErrorCode.INTERNAL);
		}
	}
	
	public void setDataInterruzione(String data, int i) {
		switch (source) {
			case CSV:
				clusterCsvInvalidoList.get(i).setDataInterruzione(data);
				break;
			case CABINA: 
				throw new CsvCabinaException(ErrorCode.OPERATION_NOT_ALLOWED);
			default:
				throw new CsvCabinaException(ErrorCode.INTERNAL);
		}
	}
	
	public String getOraInterruzione(int i) {
		switch (source) {
			case CSV:
				return clusterCsvInvalidoList.get(i).getOraInterruzione();
			case CABINA:
				int k = 0;
				Iterator<ClusterCcs> it = clusterCabina.getConcentratori().iterator();
				
				while(it.hasNext()) {
					ClusterCcs clusterCcs = it.next();
					Iterator<ClusterInterruttore> it2 = clusterCcs.getInterruttori().iterator();
					
					while(it2.hasNext()) {
						ClusterInterruttore ci = it2.next();
						
						if (k == i)
							return ci.getOraInterrProvoc();
						
						k++;
					}
				}
				throw new IllegalArgumentException("Wrong index value: " + i);
			default: 
				throw new CsvCabinaException(ErrorCode.INTERNAL);
		}
	}
	
	public void setOraInterruzione(String ora, int i) {
		switch (source) {
			case CSV:
				clusterCsvInvalidoList.get(i).setOraInterruzione(ora);
				break;
			case CABINA:
				int k = 0;
				Iterator<ClusterCcs> it = clusterCabina.getConcentratori().iterator();
				
				while(it.hasNext()) {
					ClusterCcs clusterCcs = it.next();
					Iterator<ClusterInterruttore> it2 = clusterCcs.getInterruttori().iterator();
					
					while(it2.hasNext()) {
						ClusterInterruttore ci = it2.next();
						
						if (k == i) {
							ci.setOraInterrProvoc(ora);
							return;
						}
						
						k++;
					}
				}
				throw new IllegalArgumentException("Wrong index value: " + i);
			default: 
				throw new CsvCabinaException(ErrorCode.INTERNAL);
		}
	}
	
	public String getMatricolaTrasformatore(int i) {
		switch (source) {
			case CSV:
				return clusterCsvInvalidoList.get(i).getMatricolaTrasformatore();
			case CABINA:
				int k = 0;
				Iterator<ClusterCcs> it = clusterCabina.getConcentratori().iterator();
				
				while(it.hasNext()) {
					ClusterCcs clusterCcs = it.next();
					Iterator<ClusterInterruttore> it2 = clusterCcs.getInterruttori().iterator();
					
					while(it2.hasNext()) {
						ClusterInterruttore ci = it2.next();
						
						if (k == i)
							return ci.getClusterCcs().getMatricolaTrasformatore();
						
						k++;
					}
				}
				throw new IllegalArgumentException("Wrong index value: " + i);
			default: 
				throw new CsvCabinaException(ErrorCode.INTERNAL);
		}
	}
	
	public void setMatricolaTrasformatore(String matrTr, int i) {
		switch (source) {
			case CSV:
				clusterCsvInvalidoList.get(i).setMatricolaTrasformatore(matrTr);
				break;
			case CABINA:
				int k = 0;
				Iterator<ClusterCcs> it = clusterCabina.getConcentratori().iterator();
				
				while(it.hasNext()) {
					ClusterCcs clusterCcs = it.next();
					Iterator<ClusterInterruttore> it2 = clusterCcs.getInterruttori().iterator();
					
					while(it2.hasNext()) {
						ClusterInterruttore ci = it2.next();
						
						if (k == i) {
							ci.getClusterCcs().setMatricolaTrasformatore(matrTr);
							return;
						}
						
						k++;
					}
				}
				throw new IllegalArgumentException("Wrong index value: " + i);
			default: 
				throw new CsvCabinaException(ErrorCode.INTERNAL);
		}
	}
	
	public String getCodiceTrasformatore(int i) {
		switch (source) {
			case CSV:
				return clusterCsvInvalidoList.get(i).getCodiceTrasformatore();
			case CABINA:
				int k = 0;
				Iterator<ClusterCcs> it = clusterCabina.getConcentratori().iterator();
				
				while(it.hasNext()) {
					ClusterCcs clusterCcs = it.next();
					Iterator<ClusterInterruttore> it2 = clusterCcs.getInterruttori().iterator();
					
					while(it2.hasNext()) {
						ClusterInterruttore ci = it2.next();
						
						if (k == i)
							return ci.getClusterCcs().getCodTrasformatore();
						
						k++;
					}
				}
				throw new IllegalArgumentException("Wrong index value: " + i);
			default: 
				throw new CsvCabinaException(ErrorCode.INTERNAL);
		}
	}
	
	public void setCodiceTrasformatore(String codTr, int i) {
		switch (source) {
			case CSV:
				clusterCsvInvalidoList.get(i).setCodiceTrasformatore(codTr);
				break;
			case CABINA:
				int k = 0;
				Iterator<ClusterCcs> it = clusterCabina.getConcentratori().iterator();
				
				while(it.hasNext()) {
					ClusterCcs clusterCcs = it.next();
					Iterator<ClusterInterruttore> it2 = clusterCcs.getInterruttori().iterator();
					
					while(it2.hasNext()) {
						ClusterInterruttore ci = it2.next();
						
						if (k == i) {
							ci.getClusterCcs().setCodTrasformatore(codTr);
							return;
						}
						
						k++;
					}
				}
				throw new IllegalArgumentException("Wrong index value: " + i);
			default: 
				throw new CsvCabinaException(ErrorCode.INTERNAL);
		}
	}
	
	public Date getDataAcquisizione() {
		switch (source) {
			case CSV:
				return clusterCsvInvalidoList.get(0).getAcquisitionTimestamp();
			case CABINA:
				return clusterCabina.getDataAcqFile();
			default:
				throw new CsvCabinaException(ErrorCode.INTERNAL);
		}
	}
	
	// METODI DI BUSINESS PER REGOLE DI EDITABILITà DA GUI
	
	public boolean isCodCabinaEditable() {
		return this.source == Source.CSV;
	}

	public boolean isCodConcentratoreEditable() {
		if (this.source == Source.CSV)
			return true;
		switch (this.clusterCabina.getStato()) {
			case VALIDO:
			case VALIDO_SCADUTO:
			case DA_APPROVARE:
				return true;
			default:
					return false;
		}
	}

	public boolean isCodInterruttoreEditable() {
		if (this.source == Source.CSV)
			return true;
		switch (this.clusterCabina.getStato()) {
			case VALIDO:
			case VALIDO_SCADUTO:
			case DA_APPROVARE:
				return true;
			default:
					return false;
		}
	}

	public boolean isDataInterruzioneEditable() {
		return this.source == Source.CSV;
		}

	public boolean isOraInterruzioneEditable() {
		if (this.source == Source.CSV)
			return true;
		switch (this.clusterCabina.getStato()) {
			case VALIDO:
			case VALIDO_SCADUTO:
			case DA_APPROVARE:
				return true;
			default:
					return false;
		}
	}

	public boolean isCodiceTrasformatoreEditable() {
		if (this.source == Source.CSV)
			return true;
		switch (this.clusterCabina.getStato()) {
			case VALIDO:
			case VALIDO_SCADUTO:
			case DA_APPROVARE:
				return true;
			default:
					return false;
		}
	}

	public boolean isMatricolaTrasformatoreEditable() {
		if (this.source == Source.CSV)
			return true;
		switch (this.clusterCabina.getStato()) {
			case VALIDO:
			case VALIDO_SCADUTO:
			case DA_APPROVARE:
				return true;
			default:
					return false;
		}
	}
}
