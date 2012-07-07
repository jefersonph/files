/**
 * Copyright 2004 by Irian Marinschek & Spiegl Software OEG
 */
package org.apache.myfaces.examples.collapsiblepanel;

/**
 * @author Martin Marinschek
 * @version $Revision$ $Date$
 *          <p/>
 *          $Log$
 *          Revision 1.3  2006/05/03 14:48:50  igels
 *          *** empty log message ***
 *
 *          Revision 1.1  2006/04/19 08:09:32  igels
 *          *** empty log message ***
 *
 *          Revision 1.1  2005/11/08 14:50:14  igels
 *          *** empty log message ***
 *
 */
public class CollapsiblePanelBean
{
    private boolean _collapsed;

    public boolean isCollapsed()
    {
        return _collapsed;
    }

    public void setCollapsed(boolean collapsed)
    {
        _collapsed = collapsed;
    }
}
