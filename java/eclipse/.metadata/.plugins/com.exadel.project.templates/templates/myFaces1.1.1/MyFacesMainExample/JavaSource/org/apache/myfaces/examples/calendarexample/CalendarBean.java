/**
 * Copyright 2004 by Irian Marinschek & Spiegl Software OEG
 */
package org.apache.myfaces.examples.calendarexample;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.io.Serializable;

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
public class CalendarBean implements Serializable
{
    private static Log log = LogFactory.getLog(CalendarBean.class);

    private List _dates;

    private String _text;
    private Date _firstDate;
    private Date _secondDate;

    public List getDates()
    {
        if(_dates == null)
        {
            _dates = new ArrayList();

            for(int i=0; i<3; i++)
                _dates.add(new DateHolder());
        }

        return _dates;
    }

    public void setDates(List dates)
    {
        _dates = dates;
    }

    public String getText()
    {
        return _text;
    }

    public void setText(String text)
    {
        _text = text;
    }

    public Date getFirstDate()
    {
        return _firstDate;
    }

    public void setFirstDate(Date firstDate)
    {
        _firstDate = firstDate;
    }

    public Date getSecondDate()
    {
        return _secondDate;
    }

    public void setSecondDate(Date secondDate)
    {
        _secondDate = secondDate;
    }

    public String submitMethod()
    {
        log.info("submit method called");

        return "submit";
    }


}
