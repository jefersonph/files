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
package org.apache.myfaces.examples.misc;

import org.apache.myfaces.custom.navmenu.NavigationMenuItem;
import org.apache.myfaces.examples.util.GuiUtil;

import java.util.List;
import java.util.ArrayList;

/**
 * @author Thomas Spiegl (latest modification by $Author$)
 * @version $Revision$ $Date$
 */
public class NavigationMenu
{
    public NavigationMenuItem[] getInfoItems()
    {
        String label = GuiUtil.getMessageResource("nav_Info", null);
        NavigationMenuItem[] menu= new NavigationMenuItem[1];

        menu[0] = new NavigationMenuItem(label, null, null, true);

        NavigationMenuItem[] items = new NavigationMenuItem[2];
        menu[0].setNavigationMenuItems(items);

        label = GuiUtil.getMessageResource("nav_Contact", null);
        items[0] = new NavigationMenuItem(label, "go_contact", "images/help.gif", false);

        label = GuiUtil.getMessageResource("nav_Copyright", null);
        items[1] = new NavigationMenuItem(label, "go_copyright", "images/help.gif", false);

        return menu;
    }

    public List getPanelNavigationItems()
    {
        List menu = new ArrayList();
        // Products
        NavigationMenuItem products = new NavigationMenuItem("#{example_messages['panelnav_products']}", "#{navigationMenu.getAction}");
        menu.add(products);
        products.add(new NavigationMenuItem("#{example_messages['panelnav_serach']}", "#{navigationMenu.getAction}"));
        products.add(new NavigationMenuItem("#{example_messages['panelnav_serach_acc']}", "#{navigationMenu.getAction}"));
        products.add(new NavigationMenuItem("#{example_messages['panelnav_search_adv']}", "#{navigationMenu.getAction}"));
        // Shop
        menu.add(new NavigationMenuItem("#{example_messages['panelnav_shop']}", "#{navigationMenu.getAction}"));
        // Corporate Info
        NavigationMenuItem corporateInfo = new NavigationMenuItem("#{example_messages['panelnav_corporate']}", "#{navigationMenu.getAction}");
        menu.add(corporateInfo);
        corporateInfo.add(new NavigationMenuItem("#{example_messages['panelnav_news']}", "#{navigationMenu.getAction}"));
        corporateInfo.add(new NavigationMenuItem("#{example_messages['panelnav_investor']}", "#{navigationMenu.getAction}"));
        // Contact
        menu.add(new NavigationMenuItem("#{example_messages['panelnav_contact']}", "#{navigationMenu.getAction}"));
        return menu;
    }

    public String getAction()
    {
        return "go_panelnavigation_2";
    }
}
