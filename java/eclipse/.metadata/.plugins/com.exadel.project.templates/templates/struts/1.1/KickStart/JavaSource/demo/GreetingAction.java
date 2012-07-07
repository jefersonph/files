/*
 * GreetingAction.java
 *
 * Created by Exadel Struts Studio
 */

package demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class GreetingAction extends org.apache.struts.action.Action {

    // Global Forwards
    public static final String GLOBAL_FORWARD_getName = "getName";

    // Local Forwards
    private static final String FORWARD_sayhello = "sayhello";

    public GreetingAction() {
    }

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String name = ((demo.GetNameForm)form).getName();
        String greeting = "Hello, "+name+"!";
        request.setAttribute("greeting", greeting);
        return mapping.findForward(FORWARD_sayhello);
    }
}