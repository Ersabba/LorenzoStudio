package datatable.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;

@Action(value = "modificatrps", results = {@Result(name = "success", location = "/exercise/modificaTRPS.jsp") })
@Namespaces(value={@Namespace("/")})
public class ModificaTrpsAction extends ActionSupport {
}
