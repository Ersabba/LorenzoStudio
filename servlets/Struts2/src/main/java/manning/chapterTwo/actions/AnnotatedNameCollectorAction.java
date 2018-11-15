package manning.chapterTwo.actions;


import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;

/* 
 * Annotations version of the pass through action.  This action does
 * nothing, but we have to provide this class since annotations
 * are inherently based in a Java class.  We extend ActionSupport 
 * to get its empty logic execute method which does nothing but 
 * forward to the success result, which defaults to the only result 
 * defined in this case.   
 */

@Namespaces(value = {@Namespace("/chapterTwo")})
@Action(value = "AnnotatedNameCollector")
@Result(location="/chapterTwo/AnnotatedNameCollector.jsp")
public class AnnotatedNameCollectorAction extends ActionSupport {
	

}
