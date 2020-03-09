package com.ericsson.communication.responsetype;

import java.util.Vector;

import com.ericsson.communication.CommandResponseType;
import com.ericsson.communication.CommandResponseTypeEnumeration;
import com.ericsson.communication.responsetype.util.FileADD;

public class Parser169File extends CommandResponseType {

	private static final long serialVersionUID = -1L;
	
	private Vector parFile;

    public CommandResponseTypeEnumeration getCommandResponseType() {
        return CommandResponseTypeEnumeration.PARSER_169_FILE;
    }

    public boolean isValid() {
        return true;
    }

	/**
	 * Permette di settare il vettore contenente il parsing del file
	 *
	 * @param par Vettore con il parsing del file.
	 *
	 */
    public void setParVector(Vector par) {
        this.parFile = par;
    }

	/**
	 * Restituisce la grandezza del vettore con il parsing del file
	 *
	 */
    public int getVectSize() {
		//Vector par = (Vector) getResponseTypeBody().getResult("FILE_STREAM");
		//setParVector(par);
		return this.parFile.size();
	}

	/**
	 * Restituisce la matricola dell'apparto che si trova in anagrafica
	 *
	 * @param i  record interessato.
	 */
	public String getItemMtr(int i) {
		FileADD fileSCM = (FileADD) this.parFile.elementAt(i);
		return fileSCM.getMtr();
	}

	/**
	 * Restituisce il gruppo del Lennt
	 *
	 * @param i record interessato.
	 */
	public String getItemGruppo(int i) {
		FileADD fileSAL = (FileADD) this.parFile.elementAt(i);
		return fileSAL.getGruppo();
	}

	/**
	 * Restituisce il progressivo dell'apparato
	 *
	 * @param i  record interessato.
	 */
	public String getItemProgr(int i) {
		FileADD fileSCM = (FileADD) this.parFile.elementAt(i);
		return fileSCM.getProgressivo();
	}

	/**
	 * Restituisce la fase del Lennt
	 *
	 * @param i  record interessato.
	 */
	public String getItemFase(int i) {
		FileADD fileSAL = (FileADD) this.parFile.elementAt(i);
		return fileSAL.getfase();
	}

	/**
	 * Restituisce il nome del file associato al Lennt
	 *
	 * @param i  record interessato.
	 */
	public String getItemNomeFile(int i) {
		FileADD fileSCM = (FileADD) this.parFile.elementAt(i);
		return fileSCM.getNomeFile();
	}

	/**
	 * Restituisce la matricola dell'A-Link eventualmente associato al Lennt
	 *
	 * @param i  record interessato.
	 */
	public String getItemTu(int i) {
		FileADD fileSAL = (FileADD) this.parFile.elementAt(i);
		return fileSAL.getMtrTut();
	}

	/**
	 * Restituisce la data di associazione del Lennt
	 *
	 * @param i  record interessato.
	 */
	public String getItemDataAssociazioneLennt(int i) {
		FileADD fileSAL = (FileADD) this.parFile.elementAt(i);
		return fileSAL.getDataAssociazioneLennt();
	}

	/**
	 * Restituisce l'ora di associazione del Lennt
	 *
	 * @param i  record interessato.
	 */
	public String getItemOraAssociazioneLennt(int i) {
		FileADD fileSAL = (FileADD) this.parFile.elementAt(i);
		return fileSAL.getOraAssociazioneLennt();
	}
}
