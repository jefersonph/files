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

import java.util.ArrayList;
import java.util.Date;

import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.apache.myfaces.custom.calendar.HtmlInputCalendar;
import org.apache.myfaces.custom.schedule.model.ScheduleModel;
import org.apache.myfaces.custom.schedule.model.SimpleScheduleModel;
import org.apache.myfaces.custom.schedule.util.ScheduleUtil;

/**
 * This is a simple demo of the Schedule component.
 * The entries are stored in the session.
 * A real application would typically use a custom implementation
 * of the ScheduleModel.
 * 
 * @author Jurgen Lust (latest modification by $Author$)
 * @version $Revision$
 */
public class ScheduleBean
{

    //~ Instance fields --------------------------------------------------------

    private Date date = new Date();
    private HtmlInputCalendar dateInput;
    private HtmlSelectOneMenu modeInput;
    private Integer mode = new Integer(ScheduleModel.WORKWEEK);
    private SimpleScheduleModel model;
    private String theme;
    private Boolean tooltip;
    private Boolean readonly;

    //~ Constructors -----------------------------------------------------------

    /**
     * Creates a new SimpleScheduleBackingBean object.
     */
    public ScheduleBean()
    {
        super();
        initModel();
    }

    //~ Methods ----------------------------------------------------------------

    /**
     * @param date The date to set.
     */
    public void setDate(Date date)
    {
        this.date = date;
    }

    /**
     * @return Returns the date.
     */
    public Date getDate()
    {
        return date;
    }

    /**
     * @param dateInput The dateInput to set.
     */
    public void setDateInput(HtmlInputCalendar dateInput)
    {
        this.dateInput = dateInput;
    }

    /**
     * @return Returns the dateInput.
     */
    public HtmlInputCalendar getDateInput()
    {
        return dateInput;
    }

    /**
     * @param mode The mode to set.
     */
    public void setMode(Integer mode)
    {
        this.mode = mode;
    }

    /**
     * @return Returns the mode.
     */
    public Integer getMode()
    {
        return mode;
    }

    /**
     * @param modeInput The modeInput to set.
     */
    public void setModeInput(HtmlSelectOneMenu modeInput)
    {
        this.modeInput = modeInput;
    }

    /**
     * @return Returns the modeInput.
     */
    public HtmlSelectOneMenu getModeInput()
    {
        return modeInput;
    }

    /**
     * <p>
     * get the SelectItems for the mode SelectOneRadio
     * </p>
     *
     * @return an ArrayList of SelectItems
     */
    public ArrayList getModeItems()
    {
        ArrayList items = new ArrayList();
        items.add(new SelectItem(new Integer(ScheduleModel.DAY), "day"));
        items.add(new SelectItem(new Integer(ScheduleModel.WORKWEEK),
                "workweek"));
        items.add(new SelectItem(new Integer(ScheduleModel.WEEK), "week"));
        items.add(new SelectItem(new Integer(ScheduleModel.MONTH), "month"));

        return items;
    }

    /**
     * <p>
     * The theme that will be used to render the schedule
     * </p>
     * 
     * @return Returns the theme.
     */
    public String getTheme()
    {
        return theme;
    }

    /**
     * <p>
     * The theme that will be used to render the schedule
     * </p>
     * 
     * @param theme The theme to set.
     */
    public void setTheme(String theme)
    {
        this.theme = theme;
    }

    /**
     * @param model The model to set.
     */
    public void setModel(SimpleScheduleModel model)
    {
        this.model = model;
    }

    /**
     * @return Returns the model.
     */
    public ScheduleModel getModel()
    {
        return model;
    }

    /**
     * <p>
     * a String describing the selected entry on the schedule
     * </p>
     *
     * @return the entry as a string
     */
    public String getSelectedEntry()
    {
        if ((model == null) || (model.getSelectedEntry() == null))
        {
            return "no entry selected";
        }

        StringBuffer entry = new StringBuffer();
        entry.append(model.getSelectedEntry().getTitle());
        entry.append(": ");
        entry.append(model.getSelectedEntry().getStartTime());
        entry.append(" - ");
        entry.append(model.getSelectedEntry().getEndTime());

        String returnString = entry.toString();

        return returnString;
    }

    /**
     * Is there an entry currently selected?
     * 
     * @return if an entry is currently selected
     */
    public boolean isEntrySelected()
    {
        return model != null && model.getSelectedEntry() != null;
    }

    /**
     * <p>
     * action listener for the schedule component.
     * </p>
     *
     * @param actionEvent the action event
     */
    public void scheduleActionPerformed(ActionEvent actionEvent)
    {
    }

    /**
     * <p>
     * When a date is selected in the calendar component, navigate to that date
     * in the schedule component.
     * </p>
     *
     * @param event the action event
     */
    public void calendarValueChanged(ValueChangeEvent event)
    {
        if (date != null
                && ScheduleUtil.truncate(date).equals(
                        ScheduleUtil.truncate((Date) dateInput.getValue())))
            return;
        this.date = (Date) dateInput.getValue();
        model.setSelectedDate(date);
        model.refresh();
    }

    /**
     * <p>
     * When a different mode is selected, apply this mode to the schedule
     * component.
     * </p>
     *
     * @param event the action event
     */
    public void modeValueChanged(ValueChangeEvent event)
    {
        if (mode != null && mode.equals((Integer) modeInput.getValue()))
            return;
        this.mode = (Integer) modeInput.getValue();
        model.setMode(mode.intValue());
        model.refresh();
        this.date = model.getSelectedDate();
        dateInput.setValue(model.getSelectedDate());
    }

    /**
     * <p>
     * When the read-only setting is changed, clear the selection of the
     * schedule.
     * </p>
     *
     * @param event the action event
     */
    public void readonlyValueChanged(ValueChangeEvent event)
    {
        if (getModel() != null)
            getModel().setSelectedEntry(null);
    }

    /**
     * Initialize the demo
     */
    private void initModel()
    {
        if (model == null)
        {
            model = new SimpleScheduleModel();
        }

        this.date = new Date();

        model.setMode(mode.intValue());

        model.setSelectedDate(this.date);
    }

    /**
     * <p>
     * Should the schedule be readonly?
     * </p>
     * 
     * @return Returns the readonly.
     */
    public Boolean getReadonly()
    {
        return readonly;
    }

    /**
     * <p>
     * Should the schedule be readonly?
     * </p>
     * 
     * @param readonly The readonly to set.
     */
    public void setReadonly(Boolean readonly)
    {
        this.readonly = readonly;
    }

    /**
     * <p>
     * Should tooltips be shown on the schedule?
     * </p>
     * 
     * @return Returns the tooltip.
     */
    public Boolean getTooltip()
    {
        return tooltip;
    }

    /**
     * <p>
     * Should tooltips be shown on the schedule?
     * </p>
     * 
     * @param tooltip The tooltip to set.
     */
    public void setTooltip(Boolean tooltip)
    {
        this.tooltip = tooltip;
    }
}
