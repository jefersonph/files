/*
 * Copyright 2004 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.myfaces.examples.schedule;

import java.util.Date;

import javax.faces.event.ActionEvent;

import org.apache.myfaces.custom.schedule.model.DefaultScheduleEntry;
import org.apache.myfaces.custom.schedule.model.SimpleScheduleModel;

/**
 * Backing bean for the add appointment, remove appointment and add holiday
 * forms in the schedule demo.
 * 
 * @author Jurgen Lust (latest modification by $Author$)
 * @version $Revision$
 */
public class AppointmentBean
{
    private Date appointmentStart;
    private Date appointmentEnd;
    private Date holidayDate;
    private String holidayName;
    private String appointmentTitle;
    private String appointmentLocation;
    private String appointmentComments;
    private ScheduleBean scheduleBean;

    /**
     * @return Returns the appointmentComments.
     */
    public String getAppointmentComments()
    {
        return appointmentComments;
    }

    /**
     * @param appointmentComments The appointmentComments to set.
     */
    public void setAppointmentComments(String appointmentComments)
    {
        this.appointmentComments = appointmentComments;
    }

    /**
     * @return Returns the appointmentEnd.
     */
    public Date getAppointmentEnd()
    {
        return appointmentEnd;
    }

    /**
     * @param appointmentEnd The appointmentEnd to set.
     */
    public void setAppointmentEnd(Date appointmentEnd)
    {
        this.appointmentEnd = appointmentEnd;
    }

    /**
     * @return Returns the appointmentLocation.
     */
    public String getAppointmentLocation()
    {
        return appointmentLocation;
    }

    /**
     * @param appointmentLocation The appointmentLocation to set.
     */
    public void setAppointmentLocation(String appointmentLocation)
    {
        this.appointmentLocation = appointmentLocation;
    }

    /**
     * @return Returns the appointmentStart.
     */
    public Date getAppointmentStart()
    {
        return appointmentStart;
    }

    /**
     * @param appointmentStart The appointmentStart to set.
     */
    public void setAppointmentStart(Date appointmentStart)
    {
        this.appointmentStart = appointmentStart;
    }

    /**
     * @return Returns the appointmentTitle.
     */
    public String getAppointmentTitle()
    {
        return appointmentTitle;
    }

    /**
     * @param appointmentTitle The appointmentTitle to set.
     */
    public void setAppointmentTitle(String appointmentTitle)
    {
        this.appointmentTitle = appointmentTitle;
    }

    /**
     * @return Returns the holidayDate.
     */
    public Date getHolidayDate()
    {
        return holidayDate;
    }

    /**
     * @param holidayDate The holidayDate to set.
     */
    public void setHolidayDate(Date holidayDate)
    {
        this.holidayDate = holidayDate;
    }

    /**
     * @return Returns the holidayName.
     */
    public String getHolidayName()
    {
        return holidayName;
    }

    /**
     * @param holidayName The holidayName to set.
     */
    public void setHolidayName(String holidayName)
    {
        this.holidayName = holidayName;
    }

    /**
     * @return Returns the scheduleBean.
     */
    public ScheduleBean getScheduleBean()
    {
        return scheduleBean;
    }

    /**
     * @param scheduleBean The scheduleBean to set.
     */
    public void setScheduleBean(ScheduleBean scheduleBean)
    {
        this.scheduleBean = scheduleBean;
    }

    /**
     * This method is called when the 'add appointment' button is pressed.
     * 
     * @param event the actionEvent
     */
    public void addAppointment(ActionEvent event)
    {
        if (scheduleBean == null)
            return;
        if (!appointmentStart.before(appointmentEnd))
            return;
        if (appointmentTitle == null || appointmentTitle.length() < 1)
            return;
        SimpleScheduleModel model = (SimpleScheduleModel) scheduleBean
                .getModel();
        DefaultScheduleEntry appointment = new DefaultScheduleEntry();
        //we need a unique id, let's take the current time in milliseconds
        appointment.setId(String.valueOf(System.currentTimeMillis()));
        appointment.setStartTime(appointmentStart);
        appointment.setEndTime(appointmentEnd);
        appointment.setTitle(appointmentTitle);
        appointment.setSubtitle(appointmentLocation == null ? ""
                : appointmentLocation);
        appointment.setDescription(appointmentComments == null ? ""
                : appointmentComments);
        model.addEntry(appointment);
        model.refresh();
        appointmentStart = new Date();
        appointmentEnd = new Date();
        appointmentTitle = "";
        appointmentLocation = "";
        appointmentComments = "";
    }

    /**
     * This method is called when the 'remove appointment' button is pressed.
     * 
     * @param event the actionEvent
     */
    public void removeAppointment(ActionEvent event)
    {
        if (scheduleBean == null)
            return;
        SimpleScheduleModel model = (SimpleScheduleModel) scheduleBean
                .getModel();
        model.removeEntry(model.getSelectedEntry());
        model.setSelectedEntry(null);
        model.refresh();
    }

    /**
     * This method is called when the 'add holiday' button is pressed.
     * 
     * @param event the actionEvent
     */
    public void addHoliday(ActionEvent event)
    {
        if (scheduleBean == null)
            return;
        if (holidayDate == null)
            return;
        SimpleScheduleModel model = (SimpleScheduleModel) scheduleBean
                .getModel();
        if (holidayName != null && holidayName.length() < 1)
            holidayName = null;
        model.setHoliday(holidayDate, holidayName);
        model.refresh();
        holidayDate = new Date();
        holidayName = "";
    }
}
