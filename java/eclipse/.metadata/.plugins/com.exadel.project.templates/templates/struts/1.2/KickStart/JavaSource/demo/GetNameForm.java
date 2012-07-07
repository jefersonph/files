/*
 * GetNameForm.java
 *
 * Created by Exadel Struts Studio
 */

package demo;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;

public class GetNameForm extends ActionForm {
    private String name="";

    public GetNameForm() {
    }

    public void reset(ActionMapping actionMapping, HttpServletRequest request) {
        this.name="";
    }

    public ActionErrors validate(ActionMapping actionMapping, HttpServletRequest request) {
        ActionErrors errs = new ActionErrors();
        return errs;
    }

    public String getName() {
        return this.name;    
    }

    public void setName(String name) {
        this.name = (name==null?"":name);
    }
}