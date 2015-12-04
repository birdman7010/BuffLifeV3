package com.bufflife.bufflife;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Calendar;
import java.util.Formatter;
import java.util.Locale;

/**
<<<<<<< Updated upstream
 * Created by danielyedidovich on 11/11/15.
 * last edited by Kyle Knight 11/18/2015  had to change to async task to work
 * We could also simplify to only show meals based on time of day but I think it makes more sense to see the whole week.
 * Also my I'm only getting a saturday value for the calendar date and it is definitely not saturday...
=======
 * Created by danielyedidovich
>>>>>>> Stashed changes
 */
public class diningHallMenu extends Activity{
    //URL of the dining hall menus
    private static String sewallDiningWeb = "http://housing.colorado.edu/sites/default/files/menus/week_menu_table_v3.html";
    private static String libbyDiningWeb = "http://housing.colorado.edu/sites/default/files/menus/week_menu_table_v4.html";

    private AppCompatActivity appCompatActivity;

    TextView sewallTextView;
    TextView libbyTextView;

    public void onCreate(Bundle savedInstanceState)
    {
        //Create the page
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dininghallmenu);

        //Pull down the HTML for the menu URLs
        sewallTextView = (TextView)findViewById(R.id.sewallMenuDisplay);
        libbyTextView = (TextView)findViewById(R.id.libbyMenuDisplay);

        ( new diningHallMenuBackground() ).execute(new String[]{sewallDiningWeb,"sewall"});

        ( new diningHallMenuBackground() ).execute(new String[]{libbyDiningWeb,"libby"});
        sewallTextView.setText("Loading...");
        libbyTextView.setText("Loading...");

    }


    /**
     * Created by Kyle on 11/12/2015.
     */
    public class diningHallMenuBackground extends AsyncTask<String,Void,String> {
        String title;
        String carrier;
        Calendar calendar = Calendar.getInstance();

        @Override
        public String doInBackground(String... strings){
            carrier=strings[1];
            Log.d("isCON", "Connecting");
            Document doc = null;
            //connect to the menus
            try {
                doc = Jsoup.connect(strings[0]).get();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Log.d("isCON", "Connected");
            Elements links = null;
            /*
            Looking at the day of the week, searching for the tags that then pertain for that day of the week and meal
            the for loop just loops for the items that match those tags
             */
            if(calendar.get(Calendar.DAY_OF_WEEK) == calendar.MONDAY) {
                title = "Breakfast: \n";
                links = doc.select("tr#breakfastRow td.mon li");
                for (Element element: links)
                    title += element.text() + "\n";
                title += "\n\nLunch: \n";
                links = doc.select("tr#lunchRow td.mon li");
                for (Element element: links)
                    title += element.text() + "\n";
                title += "\n\nDinner: \n";
                links = doc.select("tr#dinnerRow td.mon li");
                for (Element element: links)
                    title += element.text() + "\n";
            }
            else if(calendar.get(Calendar.DAY_OF_WEEK) == calendar.TUESDAY) {
                title = "Breakfast: \n";
                links = doc.select("tr#breakfastRow td.tues li");
                for (Element element: links)
                    title += element.text() + "\n";
                title += "\n\nLunch: \n";
                links = doc.select("tr#lunchRow td.tues li");
                for (Element element: links)
                    title += element.text() + "\n";
                links = doc.select("tr#lunchRow td.'tues here' li");
                for (Element element: links)
                    title += element.text() + "\n";
                title += "\n\nDinner: \n";
                links = doc.select("tr#dinnerRow td.tues li");
                for (Element element: links)
                    title += element.text() + "\n";
            }
            else if(calendar.get(Calendar.DAY_OF_WEEK) == calendar.WEDNESDAY) {
                title = "Breakfast: \n";
                links = doc.select("tr#breakfastRow td.wed li");
                for (Element element: links)
                    title += element.text() + "\n";
                title += "\n\nLunch: \n";
                links = doc.select("tr#lunchRow td.wed li");
                for (Element element: links)
                    title += element.text() + "\n";
                title += "\n\nDinner: \n";
                links = doc.select("tr#dinnerRow td.wed li");
                for (Element element: links)
                    title += element.text() + "\n";
            }
            else if(calendar.get(Calendar.DAY_OF_WEEK) == calendar.THURSDAY) {
                title = "Breakfast: \n";
                links = doc.select("tr#breakfastRow td.thurs li");
                for (Element element: links)
                    title += element.text() + "\n";
                title += "\n\nLunch: \n";
                links = doc.select("tr#lunchRow td.thurs li");
                for (Element element: links)
                    title += element.text() + "\n";
                title += "\n\nDinner: \n";
                links = doc.select("tr#dinnerRow td.thurs li");
                for (Element element: links)
                    title += element.text() + "\n";
            }
            else if(calendar.get(Calendar.DAY_OF_WEEK) == calendar.FRIDAY) {
                title = "Breakfast: \n\n";
                links = doc.select("tr#breakfastRow td.fri li");
                for (Element element: links)
                    title += element.text() + "\n";
                title += "\n\nLunch: \n";
                links = doc.select("tr#lunchRow td.fri li");
                for (Element element: links)
                    title += element.text() + "\n";
                title += "\n\nDinner: \n";
                links = doc.select("tr#dinnerRow td.fri li");
                for (Element element: links)
                    title += element.text() + "\n";
            }
            else if(calendar.get(Calendar.DAY_OF_WEEK) == calendar.SATURDAY) {
                title ="Breakfast: \nNo Meal Served\n\nLunch: \n";
                links = doc.select("tr#lunchRow td.sat li");
                for (Element element: links)
                    title += element.text() + "\n";
                title += "\nDinner: \n";
                links = doc.select("tr#dinnerRow td.sat li");
                for (Element element: links)
                    title += element.text() + "\n";
            }
            else if(calendar.get(Calendar.DAY_OF_WEEK) == calendar.SUNDAY) {
                title ="Breakfast: No Meal Served\n\nLunch: \n";
                links = doc.select("tr#lunchRow td.sun li");
                for (Element element: links)
                    title += element.text() + "\n";
                title += "\n\nDinner: \n";
                links = doc.select("tr#dinnerRow td.sun li");
                for (Element element: links)
                    title += element.text() + "\n";
            }
            else {
                title ="Could not determine menu";
            }
            Log.d("Menu practice", "Breakfast [" + title + "]");
            Log.d("Menu practice", "Lunch [" + title + "]");
            Log.d("Menu practice", "Dinner [" + title + "]");


            return title;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (carrier=="sewall")
                sewallTextView.setText(title);
            else
                libbyTextView.setText(title);
        }
    }

}
