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

/**
 * <H1> view sewall and libby dining halls daily menu</H1>
 * This class opens the sewall and libby dining hall menu online a scrapes them using jsoup. Then it posts the menu available in each hall for the current day.
 * @author Daniel Yedidovich
 * @author edited by Kyle Knight 11/18/2015
 * @since 11/11/2015
 * had to change to async task to make it work
 *
 */
public class diningHallMenu extends Activity{
    //menu URLs
    private static String sewallDiningWeb = "http://housing.colorado.edu/sites/default/files/menus/week_menu_table_v3.html";
    private static String libbyDiningWeb = "http://housing.colorado.edu/sites/default/files/menus/week_menu_table_v4.html";

    private AppCompatActivity appCompatActivity;

    TextView sewallTextView;
    TextView libbyTextView;
/**
 * This method that calls the background methods when this piece of the app is opened. While waiting to display the menu it displays a basic loading screen.
 */
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dininghallmenu);

        sewallTextView = (TextView)findViewById(R.id.sewallMenuDisplay);
        libbyTextView = (TextView)findViewById(R.id.libbyMenuDisplay);

        ( new diningHallMenuBackground() ).execute(new String[]{sewallDiningWeb,"sewall"});

        (new diningHallMenuBackground() ).execute(new String[]{libbyDiningWeb,"libby"});
        sewallTextView.setText("Loading...");
        libbyTextView.setText("Loading...");

    }


    /**
     * <H1> Background Website Scraper</H1>
     * This class runs the jsoup scraping on a separate string so the the phone OS doesn't kill the thread for taking too long to respond.
     * @author Created by Kyle on 11/12/2015
     */
    public class diningHallMenuBackground extends AsyncTask<String,Void,String> {
        String currentMenu;
        String selectedHall;
        Calendar calendar = Calendar.getInstance();
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter();

        /**
         *
         * @param whichHall a single string that had to be passed as an array of strings due to inheritance.
         * @return currentMenu returns the parsed menu data to be displayed on screen depending on the day of the week.
         */
        @Override
        public String doInBackground(String... whichHall){

            selectedHall=whichHall[1];
            Log.d("isCON", "Connecting");
            Document doc = null;
            //pull down and parse the menu HTML
            try {
                doc = Jsoup.connect(whichHall[0]).get();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Log.d("isCON", "Connected");
            Elements links = null;
            //Find the items that match the tags for the day of the week and the specific meal
            if(calendar.get(Calendar.DAY_OF_WEEK) == calendar.MONDAY) {
                currentMenu = "Breakfast: \n";
                links = doc.select("tr#breakfastRow td.mon li");
                for (Element element: links)
                    currentMenu += element.text() + "\n";
                currentMenu += "\n\nLunch: \n";
                links = doc.select("tr#lunchRow td.mon li");
                for (Element element: links)
                    currentMenu += element.text() + "\n";
                currentMenu += "\n\nDinner: \n";
                links = doc.select("tr#dinnerRow td.mon li");
                for (Element element: links)
                    currentMenu += element.text() + "\n";
            }
            else if(calendar.get(Calendar.DAY_OF_WEEK) == calendar.TUESDAY) {
                currentMenu = "Breakfast: \n";
                links = doc.select("tr#breakfastRow td.tues li");
                for (Element element: links)
                    currentMenu += element.text() + "\n";
                currentMenu += "\n\nLunch: \n";
                links = doc.select("tr#lunchRow td.tues li");
                for (Element element: links)
                    currentMenu += element.text() + "\n";
                links = doc.select("tr#lunchRow td.'tues here' li");
                for (Element element: links)
                    currentMenu += element.text() + "\n";
                currentMenu += "\n\nDinner: \n";
                links = doc.select("tr#dinnerRow td.tues li");
                for (Element element: links)
                    currentMenu += element.text() + "\n";
            }
            else if(calendar.get(Calendar.DAY_OF_WEEK) == calendar.WEDNESDAY) {
                currentMenu = "Breakfast: \n";
                links = doc.select("tr#breakfastRow td.wed li");
                for (Element element: links)
                    currentMenu += element.text() + "\n";
                currentMenu += "\n\nLunch: \n";
                links = doc.select("tr#lunchRow td.wed li");
                for (Element element: links)
                    currentMenu += element.text() + "\n";
                currentMenu += "\n\nDinner: \n";
                links = doc.select("tr#dinnerRow td.wed li");
                for (Element element: links)
                    currentMenu += element.text() + "\n";
            }
            else if(calendar.get(Calendar.DAY_OF_WEEK) == calendar.THURSDAY) {
                currentMenu = "Breakfast: \n";
                links = doc.select("tr#breakfastRow td.thurs li");
                for (Element element: links)
                    currentMenu += element.text() + "\n";
                currentMenu += "\n\nLunch: \n";
                links = doc.select("tr#lunchRow td.thurs li");
                for (Element element: links)
                    currentMenu += element.text() + "\n";
                currentMenu += "\n\nDinner: \n";
                links = doc.select("tr#dinnerRow td.thurs li");
                for (Element element: links)
                    currentMenu += element.text() + "\n";
            }
            else if(calendar.get(Calendar.DAY_OF_WEEK) == calendar.FRIDAY) {
                currentMenu = "Breakfast: \n\n";
                links = doc.select("tr#breakfastRow td.fri li");
                for (Element element: links)
                    currentMenu += element.text() + "\n";
                currentMenu += "\n\nLunch: \n";
                links = doc.select("tr#lunchRow td.fri li");
                for (Element element: links)
                    currentMenu += element.text() + "\n";
                currentMenu += "\n\nDinner: \n";
                links = doc.select("tr#dinnerRow td.fri li");
                for (Element element: links)
                    currentMenu += element.text() + "\n";
            }
            else if(calendar.get(Calendar.DAY_OF_WEEK) == calendar.SATURDAY) {
                currentMenu ="Breakfast: \nNo Meal Served\n\nLunch: \n";
                links = doc.select("tr#lunchRow td.sat li");
                for (Element element: links)
                    currentMenu += element.text() + "\n";
                currentMenu += "\nDinner: \n";
                links = doc.select("tr#dinnerRow td.sat li");
                for (Element element: links)
                    currentMenu += element.text() + "\n";
            }
            else if(calendar.get(Calendar.DAY_OF_WEEK) == calendar.SUNDAY) {
                currentMenu ="Breakfast: No Meal Served\n\nLunch: \n";
                links = doc.select("tr#lunchRow td.sun li");
                for (Element element: links)
                    currentMenu += element.text() + "\n";
                currentMenu += "\n\nDinner: \n";
                links = doc.select("tr#dinnerRow td.sun li");
                for (Element element: links)
                    currentMenu += element.text() + "\n";
            }
            else {
                currentMenu ="Could not determine menu";
            }
            Log.d("Menu practice", "Breakfast [" + currentMenu + "]");
            Log.d("Menu practice", "Lunch [" + currentMenu + "]");
            Log.d("Menu practice", "Dinner [" + currentMenu + "]");


            return currentMenu;
        }

        /**
         * This method posts the returned menu to the screen
         * @param s included to please the inherited method
         */
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (selectedHall =="sewall")
                sewallTextView.setText(currentMenu);
            else
                libbyTextView.setText(currentMenu);
        }
    }

}
