package com.ericsson.mgre.biz.reductionsMgmt.reductions;

import java.io.Serializable;

import com.ericsson.mgre.biz.networkMgmt.utils.ParamChecker;
import com.ericsson.mgre.biz.networkMgmt.utils.ParamUtils;

// Referenced classes of package com.ericsson.mgre.biz.reductionsMgmt.reductions:
//            ConfigAlleggEmerg

public class ConfigAlleggEmergDTO implements Serializable {

    Long coeffLimitazione;

    public ConfigAlleggEmergDTO() { }

    public ConfigAlleggEmergDTO(ConfigAlleggEmerg cae) {
        setCoeffLimitazione(cae.getCoeffLimitazione());
    }

    public static void setConfigAlleggEmerg(ConfigAlleggEmerg configalleggemerg, ConfigAlleggEmergDTO configalleggemergdto) { }

    public String toString() {
        return new String("{coeff. di limitazione: " + coeffLimitazione + "}");
    }

    public void setCoeffLimitazione(Long value) {
        coeffLimitazione = ParamUtils.nullSafeValue(value);
    }

    public void checkCoeffLimitazione() throws Exception {
        ParamChecker.checkCoeffLimitazione(coeffLimitazione);
    }

    public Long getCoeffLimitazione() {
        return ParamUtils.nullSafeValue(coeffLimitazione);
    }

    public void check() throws Exception {
        checkCoeffLimitazione();
    }

}