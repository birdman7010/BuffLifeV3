package com.bufflife.bufflife;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.Calendar;

/**
 * Created by danielyedidovich on 11/11/15.
 */
public class diningHallMenu extends Activity{
    private static String sewallDiningWeb = "http://housing.colorado.edu/sites/default/files/menus/week_menu_table_v3.html";
    private static String libbyDiningWeb = "http://housing.colorado.edu/sites/default/files/menus/week_menu_table_v4.html";
    private static Document sewallMenu;
    private static Document libbyMenu;

    //gets full html of the menus
    public static void getMenuHTML() throws IOException {
        sewallMenu = Jsoup.connect(sewallDiningWeb).get();
        libbyMenu = Jsoup.connect(libbyDiningWeb).get();
    }

    //fetches the text in the Sewall Menu website
    public static String getMenuSewall(){
        Element sewallElement;
        try {
            sewallMenu = Jsoup.connect(sewallDiningWeb).get();
        }catch (IOException ex)
        {
            return "Could not connect to dining website Sewall menu";
        }
        if(Calendar.DAY_OF_WEEK == Calendar.MONDAY)
            sewallElement = libbyMenu.getElementById("Mon");
        else if(Calendar.DAY_OF_WEEK == Calendar.TUESDAY)
            sewallElement = libbyMenu.getElementById("Tues");
        else if(Calendar.DAY_OF_WEEK == Calendar.WEDNESDAY)
            sewallElement = libbyMenu.getElementById("Wed");
        else if(Calendar.DAY_OF_WEEK == Calendar.THURSDAY)
            sewallElement = libbyMenu.getElementById("Thur");
        else if(Calendar.DAY_OF_WEEK == Calendar.FRIDAY)
            sewallElement = libbyMenu.getElementById("Fri");
        else if(Calendar.DAY_OF_WEEK == Calendar.SATURDAY)
            sewallElement = libbyMenu.getElementById("Sat");
        else if(Calendar.DAY_OF_WEEK == Calendar.SUNDAY)
            sewallElement = libbyMenu.getElementById("Sun");
        else
            return "Could not find menu for date specified";
        return sewallElement.text();
    }

    //fetches the text in the Libby Menu website
    public static String getMenuLibby(){
        Element libbyElement;
        try {
            libbyMenu = Jsoup.connect(libbyDiningWeb).get();
        }catch (IOException ex)
        {
            return "Could not connect to dining website Libby menu";
        }
        if(Calendar.DAY_OF_WEEK == Calendar.MONDAY)
            libbyElement = libbyMenu.getElementById("Mon");
        else if(Calendar.DAY_OF_WEEK == Calendar.TUESDAY)
            libbyElement = libbyMenu.getElementById("Tues");
        else if(Calendar.DAY_OF_WEEK == Calendar.WEDNESDAY)
            libbyElement = libbyMenu.getElementById("Wed");
        else if(Calendar.DAY_OF_WEEK == Calendar.THURSDAY)
            libbyElement = libbyMenu.getElementById("Thur");
        else if(Calendar.DAY_OF_WEEK == Calendar.FRIDAY)
            libbyElement = libbyMenu.getElementById("Fri");
        else if(Calendar.DAY_OF_WEEK == Calendar.SATURDAY)
            libbyElement = libbyMenu.getElementById("Sat");
        else if(Calendar.DAY_OF_WEEK == Calendar.SUNDAY)
            libbyElement = libbyMenu.getElementById("Sun");
        else
            return "Could not find menu for date specified";

        return libbyElement.text();
    }

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dininghallmenu);

        TextView sewallTextView = (TextView)findViewById(R.id.sewallMenuDisplay);
        TextView libbyTextView = (TextView)findViewById(R.id.libbyMenuDisplay);

        libbyTextView.setText(getMenuLibby());
        sewallTextView.setText(getMenuSewall());
    }
}
