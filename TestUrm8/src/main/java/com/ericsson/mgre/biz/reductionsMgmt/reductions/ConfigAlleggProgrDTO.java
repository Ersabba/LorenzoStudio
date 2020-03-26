package com.ericsson.mgre.biz.reductionsMgmt.reductions;

import java.io.Serializable;

import com.ericsson.mgre.biz.networkMgmt.utils.ParamChecker;
import com.ericsson.mgre.biz.networkMgmt.utils.ParamUtils;

public class ConfigAlleggProgrDTO implements Serializable {

    String codConfigAll;
    String giornoSettimana;
    Integer oraFine;
    Integer oraInizio;
    Long coeffLimitazione;

    public ConfigAlleggProgrDTO() { }

    public ConfigAlleggProgrDTO(ConfigAlleggProgr cap) {
        setCodConfigAll(cap.getCodConfigAll());
        setGiornoSettimana(cap.getGiornoSettimana());
        setOraInizio(cap.getOraInizio());
        setOraFine(cap.getOraFine());
        setCoeffLimitazione(cap.getCoeffLimitazione());
    }

    public static void setConfigAlleggProgr(ConfigAlleggProgr cap, ConfigAlleggProgrDTO capd) {
        cap.setOraInizio(capd.getOraInizio());
        cap.setOraFine(capd.getOraFine());
        cap.setCoeffLimitazione(capd.getCoeffLimitazione());
    }

    public String toString() {
        return new String("{piano allegg.: " + codConfigAll + ", giorno: " + giornoSettimana + ", quarto d'ora d'inizio: " + oraInizio + ", quarto d'ora di fine: " + oraFine + ", coeff. di limitazione: " + coeffLimitazione + "}");
    }

    public void setCodConfigAll(String value) {
        codConfigAll = ParamUtils.nullSafeValue(value);
    }

    public void checkCodConfigAll() throws Exception {
        String name = "identificativo di piano di alleggerimento";
        ParamUtils.checkNotNull(name, codConfigAll);
    }

    public String getCodConfigAll() {
        return ParamUtils.nullSafeValue(codConfigAll);
    }

    public void setGiornoSettimana(String value) {
        giornoSettimana = ParamUtils.nullSafeValue(value);
    }

    public void checkGiornoSettimana() throws Exception {
        ParamChecker.checkGiornoSettimana(giornoSettimana);
    }

    public String getGiornoSettimana() {
        return ParamUtils.nullSafeValue(giornoSettimana);
    }

    public void setCoeffLimitazione(Long value) {
        coeffLimitazione = ParamUtils.nullSafeValue(value);
    }

    public void checkCoeffLimitazione() throws Exception {
        ParamChecker.checkCoeffLimitazione(coeffLimitazione);
    }

    public Long getCoeffLimitazione()
    {
        return ParamUtils.nullSafeValue(coeffLimitazione);
    }

    public void setOraInizio(Integer value) {
        oraInizio = ParamUtils.nullSafeValue(value);
    }

    public Integer getOraInizio() {
        return ParamUtils.nullSafeValue(oraInizio);
    }

    public void setOraFine(Integer value) {
        oraFine = ParamUtils.nullSafeValue(value);
    }

    public Integer getOraFine() {
        return ParamUtils.nullSafeValue(oraFine);
    }

    public void check() throws Exception {
        checkCodConfigAll();
        checkGiornoSettimana();
        ParamChecker.checkInizioFineAlleggerimento(oraInizio, oraFine);
    }

    public static void check(ConfigAlleggProgrDTO capd[]) throws Exception {
        String name = "giorni del piano di alleggerimento programmato";
        ParamUtils.checkRange(name, new Integer(capd.length), 8, 8);
        String giornoSettimana = null;
        String codConfigAll = capd[0].getCodConfigAll();
        for(int i = 0; i < capd.length; i++) {
            capd[i].check();
            if(!capd[i].getCodConfigAll().equals(codConfigAll))
                throw new Exception("Il valore -" + capd[i].getCodConfigAll() + "- per l'identificativo del piano di alleggerimento specificato per il giorno -" + capd[i].getGiornoSettimana() + "- \350 differente dal valore -" + codConfigAll + "- specificato per il giorno -" + giornoSettimana + "-.");
            codConfigAll = capd[i].getCodConfigAll();
            if(capd[i].getGiornoSettimana().equals(giornoSettimana))
                throw new Exception("Il valore -" + giornoSettimana + "- per il giorno della settimana. E' duplicato per il piano di alleggerimento -" + codConfigAll + "-.");
            giornoSettimana = capd[i].getGiornoSettimana();
        }
    }
}
