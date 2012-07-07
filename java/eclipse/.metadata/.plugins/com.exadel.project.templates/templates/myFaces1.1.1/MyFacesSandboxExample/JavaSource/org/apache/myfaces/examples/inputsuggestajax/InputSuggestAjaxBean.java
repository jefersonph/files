package org.apache.myfaces.examples.inputsuggestajax;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: Bierbrauer
 * Date: 08.07.2005
 * Time: 10:19:39
 * To change this template use File | Settings | File Templates.
 */
public class InputSuggestAjaxBean
{
    public List getItems(String prefix)
    {
        List li = new ArrayList();
        li.add(prefix+1);
        li.add(prefix+2);        
        li.add(prefix+3);
        li.add(prefix+4);
        li.add(prefix+5);
        li.add(prefix+6);
        return li;
    }
    
    
    public List getItems(String prefix, Integer maxSize) {
    	
    	List li = new ArrayList();
    	
    	for(int i = 0; i < maxSize.intValue(); i++) {
    		li.add(prefix+ " " +(i+1));
    	}
    	
    	return li;
    }
}