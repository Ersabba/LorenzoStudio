package com.ericsson.mgre.biz.countersMgmt.utils;

public class ParamChecker {

    public ParamChecker() { }

    public static void checkMatricolaLenntCliente(String value)
        throws Exception
    {
        String name = "identificativo di LENNT di cliente";
        ParamUtils.checkNotNull(name, value);
        ParamUtils.checkNumeric(name, value);
        ParamUtils.checkLength(name, value, 13, 13);
    }

    public static void checkNumeroUtenza(String value)
        throws Exception
    {
        String name = "numero di utenza";
        ParamUtils.checkNotNull(name, value);
        ParamUtils.checkNumeric(name, value);
        ParamUtils.checkLength(name, value, 9, 9);
    }

    public static void checkNomeMt(String value)
        throws Exception
    {
        String name = "mnemonico linea MT";
        ParamUtils.checkLength(name, value, 0, 12);
    }

    public static void checkIdRel(String value)
        throws Exception
    {
        String name = "identificativo relativo";
        ParamUtils.checkNotNull(name, value);
        ParamUtils.checkNumeric(name, value);
        ParamUtils.checkLength(name, value, 2, 2);
    }

    public static void checkMatricolaLennt(String value)
        throws Exception
    {
        String name = "identificativo di LENNT di trasformatore";
        ParamUtils.checkNotNull(name, value);
        ParamUtils.checkNumeric(name, value);
        ParamUtils.checkLength(name, value, 13, 13);
    }

    public static void checkMatricolaAL(String value)
        throws Exception
    {
        String name = "identificativo di ACEA link";
        ParamUtils.checkNotNull(name, value);
        ParamUtils.checkNumeric(name, value);
        ParamUtils.checkLength(name, value, 13, 13);
    }

    public static void checkCodConcentratore(String value)
        throws Exception
    {
        String name = "identificativo di concentratore";
        ParamUtils.checkNotNull(name, value);
        ParamUtils.checkNumeric(name, value);
        ParamUtils.checkLength(name, value, 13, 13);
    }

    public static void checkCodGruppoApplicativo(String value)
        throws Exception
    {
        String name = "identificativo di gruppo applicativo";
        ParamUtils.checkNotNull(name, value);
        ParamUtils.checkNumeric(name, value);
        ParamUtils.checkLength(name, value, 8, 8);
    }

    public static void checkCodCabinaSecondaria(String value)
        throws Exception
    {
        String name = "identificativo di cabina secondaria";
        ParamUtils.checkNotNull(name, value);
        ParamUtils.checkLength(name, value, 6, 6);
        ParamUtils.checkNumeric(name, value);
    }

    public static void checkCodLineaMt(String value)
        throws Exception
    {
        String name = "identificativo di linea MT";
        ParamUtils.checkNotNull(name, value);
        ParamUtils.checkLength(name, value, 13, 13);
        checkCodCabinaSecondaria(value.substring(0, 6));
        checkCodCabinaSecondaria(value.substring(7));
        if(value.charAt(6) != '-')
            throw new Exception("il formato dell'identificativo di linea deve essere xxxxxx-yyyyyy");
        else
            return;
    }

    public static void checkMatricolaTrasformatore(String value)
        throws Exception
    {
        String name = "matricola trasformatore";
        ParamUtils.checkLength(name, value, 7, 7);
    }

    public static void checkCodTiputt(String value)
        throws Exception
    {
        String name = "tipo di utente";
        ParamUtils.checkNotNull(name, value);
        ParamUtils.checkLength(name, value, 4, 4);
        ParamUtils.checkNumeric(name, value);
    }

    public static void checkTensioneMt(String value)
        throws Exception
    {
        String name = "tensione MT";
        String valueSet[] = {
            "20 kV", "8.4 kV"
        };
        ParamUtils.checkValueSet(name, value, valueSet);
    }

    public static void checkTensioneMtIngresso(String value)
        throws Exception
    {
        String name = "tensione MT in ingresso";
        String valueSet[] = {
            "20 kV", "8.4 kV"
        };
        ParamUtils.checkValueSet(name, value, valueSet);
    }

    public static void checkTensioneUscita(String value)
        throws Exception
    {
        String name = "tensione in uscita";
        String valueSet[] = {
            "220 V", "380 V", "220 V e 380 V"
        };
        ParamUtils.checkValueSet(name, value, valueSet);
    }

    public static void checkSegnalazioneRgdat(String value)
        throws Exception
    {
        String name = "segnalazione da RGDAT";
        String valueSet[] = {
            "SC", "ASV", "51A", "67S", "67A"
        };
        ParamUtils.checkValueSet(name, value, valueSet);
    }

    public static void checkSezioneConcentratore(String value)
        throws Exception
    {
        String name = "sezione concentratore";
        String valueSet[] = {
            "ACB", "ACE"
        };
        ParamUtils.checkValueSet(name, value, valueSet);
    }

    public static void checkPotenzaTrasformatore(Integer value)
        throws Exception
    {
        String name = "potenza trasformatore";
        Integer valueSet[] = {
            new Integer(160), new Integer(250), new Integer(400), new Integer(630), new Integer(1250)
        };
        ParamUtils.checkValueSet(name, value, valueSet);
    }

    public static int checkGiornoSettimana(String value)
        throws Exception
    {
        String name = "giorno della settimana";
        String valueSet[] = {
            "Lunedi", "Martedi", "Mercoledi", "Giovedi", "Venerdi", "Sabato", "Domenica", "Festivo Infrasettimanale"
        };
        return ParamUtils.checkValueSet(name, value, valueSet);
    }

    public static void checkStatoAlleggerimento(String value)
        throws Exception
    {
        String name = "stato di alleggerimento";
        String valueSet[] = {
            "Attivo", "Disattivo"
        };
        ParamUtils.checkValueSet(name, value, valueSet);
    }

    public static void checkStatoFunzionamento(String value)
        throws Exception
    {
        String name = "stato di funzionamento";
        String valueSet[] = {
            "OK", "KO"
        };
        ParamUtils.checkValueSet(name, value, valueSet);
    }

    public static void checkPresenzaDatiSegr(String value)
        throws Exception
    {
        String name = "presenza dati segregati";
        String valueSet[] = {
            "S", "N"
        };
        ParamUtils.checkValueSet(name, value, valueSet);
    }

    public static void checkPeriodoCurveDiCarico(String value)
        throws Exception
    {
        String name = "periodo curve di carico";
        String valueSet[] = {
            "M", "G"
        };
        ParamUtils.checkValueSet(name, value, valueSet);
    }

    public static void checkStatoRaggiungibilita(String value)
        throws Exception
    {
        String name = "stato di raggiungibilit\340";
        String valueSet[] = {
            "raggiungibile", "non raggiungibile"
        };
        ParamUtils.checkValueSet(name, value, valueSet);
    }

    public static void checkLingua(String value)
        throws Exception
    {
        String name = "lingua";
        String valueSet[] = {
            "IT", "DE", "ES", "EN", "FR"
        };
        ParamUtils.checkValueSet(name, value, valueSet);
    }

    public static void checkStatoConcentratore(String value)
        throws Exception
    {
        String name = "stato di concentratore";
        String valueSet[] = {
            "primario", "secondario", "armadietto di espansione"
        };
        ParamUtils.checkValueSet(name, value, valueSet);
    }

    public static void checkTipoModem(String value)
        throws Exception
    {
        String name = "tipo di modem";
        String valueSet[] = {
            "GSM", "GPRS", "PSTN"
        };
        ParamUtils.checkValueSet(name, value, valueSet);
    }

    public static void checkMese(String value)
        throws Exception
    {
        String name = "mese";
        String valueSet[] = {
            "gennaio", "febbraio", "marzo", "aprile", "maggio", "giugno", "luglio", "agosto", "settembre", "ottobre",
            "novembre", "dicembre"
        };
        ParamUtils.checkValueSet(name, value, valueSet);
    }

    public static void checkAnnoPreCor(String value)
        throws Exception
    {
        String name = "anno di riferimento";
        String valueSet[] = {
            "precedente", "corrente"
        };
        ParamUtils.checkValueSet(name, value, valueSet);
    }

    public static void checkQuartoDora(String name, Integer value)
        throws Exception
    {
        ParamUtils.checkRange(name, value, 1, 96);
    }

    public static void checkCoeffLimitazione(Long value)
        throws Exception
    {
        String name = "coefficiente di limitazione";
        Long valueSet[] = {
            new Long(0L), new Long(10L), new Long(20L), new Long(30L), new Long(40L), new Long(50L), new Long(60L), new Long(70L), new Long(80L), new Long(90L),
            new Long(100L)
        };
        ParamUtils.checkValueSet(name, value, valueSet);
    }

    public static void checkInizioFineAlleggerimento(Integer valueInizio, Integer valueFine)
        throws Exception
    {
        String nameInizio = "quarto d'ora di inizio";
        String nameFine = "quarto d'ora di fine";
        ParamUtils.checkGreater(nameInizio, valueInizio, nameFine, valueFine);
        checkQuartoDora(nameInizio, valueInizio);
        checkQuartoDora(nameFine, valueFine);
    }
}