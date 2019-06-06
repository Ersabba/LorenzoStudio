package net.igorkromin;

import com.ericsson.urm.exceptions.URMBusinessException;
import com.ericsson.bizlib.utils.HomeFactoryException;
import com.ericsson.urm.thor.ws.datatypes.Result;
import com.ericsson.urm.thor.ws.datatypes.ResultCode;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.ws.BindingType;
import javax.xml.ws.Holder;
import java.util.Date;

@WebService(
        name="WsExamplePortType",
        portName="WsExamplePort",
        serviceName="WsExampleService",
        targetNamespace="http://igorkromin.net"
)
@SOAPBinding(
        style=SOAPBinding.Style.DOCUMENT,
        use=SOAPBinding.Use.LITERAL,
        parameterStyle=SOAPBinding.ParameterStyle.WRAPPED
)
@BindingType(value = javax.xml.ws.soap.SOAPBinding.SOAP12HTTP_BINDING)
public class WsExampleImpl {

    public WsExampleImpl() {
        super();
    }

    @WebMethod()
    public void getData(
            @XmlElement(required=true)
            @WebParam(mode = WebParam.Mode.IN, name = "dataId")
                    String dataId,
            @WebParam(mode = WebParam.Mode.OUT, name = "returnData")
                    Holder<String> returnData
    ) {
        returnData.value = (new ExampleData(dataId)).toString();
    }


    @WebMethod()
    public Result terminateStandbyCCS(@WebParam(name="idCCS") String idCCS,
                                      @WebParam(name="operatore") String operatore) {

        String clientInfo = "test";

        Result result = new Result();

        // Check ARGUMENTS //
        String missMsg = "";
        char sep = ',';
        if(idCCS==null || idCCS.trim().length()==0) {
            missMsg = "idCCS"+sep;
        }
        if(missMsg.length()>0) {
            missMsg = "ILLEGAL_ARGS" + missMsg;

            result.setResultCode(ResultCode.ILLEGAL_ARGUMENTS);
            result.setMessage(missMsg);
            return result;
        }

        String prefixServ = "Terminate standby CCS:"+idCCS;

        try {
            long res =  50;
            if(res==0){
                throw new HomeFactoryException("Taskexecutor creation failed");
            }
            result.setResultCode(ResultCode.SUCCESS);
            result.setMessage("");
        } catch (HomeFactoryException t) {
            result.setResultCode(ResultCode.FAILED);
            result.setMessage("Generic error");
        }

        return result;
    }
}