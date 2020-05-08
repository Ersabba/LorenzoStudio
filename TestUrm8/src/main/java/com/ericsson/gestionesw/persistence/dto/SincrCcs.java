package com.ericsson.gestionesw.persistence.dto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity()
@Table(name="GRE_SINCR_CCS")
public class SincrCcs implements Serializable {

	public enum Esito {
		SUCCESS,FAILED;
	}

	private static final long serialVersionUID = -1L;

	@Id
	@SequenceGenerator(name = "greSincrCcsIdGenerator", sequenceName = "SQN_GRE_SINCR_CCS",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="greSincrCcsIdGenerator")
	@Column(name="ID", unique=true, nullable=false)
	private Long id;

	@Column(name="MTRCCS")
	private String matricolaCcs		= null;

	@Column(name="IPCCS")
	private String ipCcs			= null;

	@Column(name="RELEASE")
	private String release			= null;

	@Column(name="DATASINCR")
	@Temporal(TemporalType.TIMESTAMP)
	private Date   dataSincr		= null;

	@Column(name="MARCA_ORARIA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date   marcaOraria      = null;

	@Column(name="ESITO")
	@Enumerated(EnumType.STRING)
	private Esito esito;

	public SincrCcs() {
		super();
	}

	public SincrCcs(String matricolaCcs, String ipCcs, String release,
					Date dataSincr, Date marcaOraria, boolean esito) {
		super();
		this.matricolaCcs 	= matricolaCcs;
		this.ipCcs 			= ipCcs;
		this.release 		= release;
		this.dataSincr 		= dataSincr;
		this.marcaOraria 	= marcaOraria;
		this.esito			= esito?Esito.SUCCESS:Esito.FAILED;
	}

	public String getMatricolaCcs() {
		return matricolaCcs;
	}

	public void setMatricolaCcs(String matricolaCcs) {
		this.matricolaCcs = matricolaCcs;
	}

	public String getIpCcs() {
		return ipCcs;
	}

	public void setIpCcs(String ipCcs) {
		this.ipCcs = ipCcs;
	}

	public String getRelease() {
		return release;
	}

	public void setRelease(String release) {
		this.release = release;
	}

	public Date getDataSincr() {
		return dataSincr;
	}

	public void setDataSincr(Date dataSincr) {
		this.dataSincr = dataSincr;
	}

	public Date getMarcaOraria() {
		return marcaOraria;
	}

	public void setMarcaOraria(Date marcaOraria) {
		this.marcaOraria = marcaOraria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SincrCcs sincrCcs = (SincrCcs) o;
		return id.equals(sincrCcs.id) &&
				Objects.equals(matricolaCcs, sincrCcs.matricolaCcs) &&
				Objects.equals(ipCcs, sincrCcs.ipCcs) &&
				Objects.equals(release, sincrCcs.release) &&
				Objects.equals(dataSincr, sincrCcs.dataSincr) &&
				Objects.equals(marcaOraria, sincrCcs.marcaOraria) &&
				esito == sincrCcs.esito;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, matricolaCcs, ipCcs, release, dataSincr, marcaOraria, esito);
	}

	@Override
	public String toString() {
		return "SincrCcs{" +
				"id=" + id +
				", matricolaCcs='" + matricolaCcs + '\'' +
				", ipCcs='" + ipCcs + '\'' +
				", release='" + release + '\'' +
				", dataSincr=" + dataSincr +
				", marcaOraria=" + marcaOraria +
				", esito=" + esito +
				'}';
	}
}
