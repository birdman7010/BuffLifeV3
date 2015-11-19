package com.bufflife.bufflife;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.Calendar;

/**
 * Created by danielyedidovich on 11/11/15.
 * last edited by Kyle Knight 11/18/2015  had to change to async task to work
 * We could also simplify to only show meals based on time of day but I think it makes more sense to see the whole week.
 * Also my I'm only getting a saturday value for the calendar date and it is definitely not saturday...
 */
public class diningHallMenu extends Activity{
        private static String sewallDiningWeb = "http://housing.colorado.edu/sites/default/files/menus/week_menu_table_v3.html";
        private static String libbyDiningWeb = "http://housing.colorado.edu/sites/default/files/menus/week_menu_table_v4.html";

        TextView sewallTextView;
        TextView libbyTextView;
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dininghallmenu);

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
        @Override
        public String doInBackground(String... strings){
            carrier=strings[1];
            Log.d("isCON", "Connecting");
            Document doc = null;
            try {
                doc = Jsoup.connect(strings[0]).get();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Log.d("isCON", "Connected");
            Calendar today= Calendar.getInstance();
            if(today.DAY_OF_WEEK == Calendar.MONDAY)
                title = "Breakfast: "+doc.getElementById("breakfastRow").getElementsByClass("mon").text()+"\n\nLunch: ";
            else if(today.DAY_OF_WEEK == Calendar.TUESDAY)
                title = "Breakfast: "+doc.getElementById("breakfastRow").getElementsByClass("tues").text()+"\n\nLunch: ";
            else if(today.DAY_OF_WEEK == Calendar.WEDNESDAY)
                title = "Breakfast: "+doc.getElementById("breakfastRow").getElementsByClass("wed").text()+"\n\nLunch: ";
            else if(today.DAY_OF_WEEK == Calendar.THURSDAY)
                title = "Breakfast: "+doc.getElementById("breakfastRow").getElementsByClass("thur").text()+"\n\nLunch: ";
            else if(today.DAY_OF_WEEK == Calendar.FRIDAY)
                title = "Breakfast: "+doc.getElementById("breakfastRow").getElementsByClass("fri").text()+"\n\nLunch: ";
            else title ="Breakfast: No Meal Served\n\nLunch: ";
            Log.d("Menu practice", "Breakfast [" + title + "]");

            if(today.DAY_OF_WEEK == Calendar.MONDAY)
                title += doc.getElementById("lunchRow").getElementsByClass("mon").text()+"\n\nDinner: ";
            else if(today.DAY_OF_WEEK == Calendar.TUESDAY)
                title += doc.getElementById("lunchRow").getElementsByClass("tues").text()+"\n\nDinner: ";
            else if(today.DAY_OF_WEEK == Calendar.WEDNESDAY)
                title += doc.getElementById("lunchRow").getElementsByClass("wed").text()+"\n\nDinner: ";
            else if(today.DAY_OF_WEEK == Calendar.THURSDAY)
                title += doc.getElementById("lunchRow").getElementsByClass("thur").text()+"\n\nDinner: ";
            else if(today.DAY_OF_WEEK == Calendar.FRIDAY)
                title += doc.getElementById("lunchRow").getElementsByClass("fri").text()+"\n\nDinner: ";
            else if(today.DAY_OF_WEEK == Calendar.SATURDAY)
                title += doc.getElementById("lunchRow").getElementsByClass("sat").text()+"\n\nDinner: ";
            else if(today.DAY_OF_WEEK == Calendar.SUNDAY)
                title += doc.getElementById("lunchRow").getElementsByClass("sun").text()+"\n\nDinner: ";
            Log.d("Menu practice", "Lunch [" + title + "]");


            if(today.DAY_OF_WEEK == Calendar.MONDAY)
                title += doc.getElementById("dinnerRow").getElementsByClass("mon").text()+"\n\n";
            else if(today.DAY_OF_WEEK == Calendar.TUESDAY)
                title += doc.getElementById("dinnerRow").getElementsByClass("tues").text()+"\n\n";
            else if(today.DAY_OF_WEEK == Calendar.WEDNESDAY)
                title += doc.getElementById("dinnerRow").getElementsByClass("wed").text()+"\n\n";
            else if(today.DAY_OF_WEEK == Calendar.THURSDAY)
                title += doc.getElementById("dinnerRow").getElementsByClass("thur").text()+"\n\n";
            else if(today.DAY_OF_WEEK == Calendar.FRIDAY)
                title += doc.getElementById("dinnerRow").getElementsByClass("fri").text()+"\n\n";
            else if(today.DAY_OF_WEEK == Calendar.SATURDAY)
                title += doc.getElementById("dinnerRow").getElementsByClass("sat").text()+"\n\n";
            else if(today.DAY_OF_WEEK == Calendar.SUNDAY)
                title += doc.getElementById("dinnerRow").getElementsByClass("sun").text()+"\n\n";
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
