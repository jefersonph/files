/*
 * Copyright (c) 2005 Your Corporation. All Rights Reserved.
 */
package org.apache.myfaces.examples.misc;

import java.io.Serializable;

/**
 * @author Sylvain Vieujot (latest modification by $Author$)
 * @version $Revision$ $Date$
 */
public class TestCheckBox implements Serializable
{
    private boolean checked;
    private String text;

 
    public boolean isChecked() {
        return checked;
    }
    public void setChecked(boolean checked) {
        this.checked = checked;
    }
    
    
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
}
