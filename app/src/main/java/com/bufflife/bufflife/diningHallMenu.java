package com.bufflife.bufflife;

import android.app.Activity;
import android.provider.DocumentsContract;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

/**
 * Created by danielyedidovich on 11/11/15.
 */
public class diningHallMenu extends Activity{
    private static String sewallDiningWeb = "https://housing.colorado.edu/sites/default/files/menus/week_menu_table_v3.html";
    private static String libbyDiningWeb = "https://housing.colorado.edu/sites/default/files/menus/week_menu_table_v4.html";
    private static Document sewallMenu;
    private static Document libbyMenu;

    //gets full html of the menus
    public static void getMenuHTML() throws IOException {
        sewallMenu = Jsoup.connect(sewallDiningWeb).get();
        libbyMenu = Jsoup.connect(libbyDiningWeb).get();
    }

    //fetches the text in the Sewall Menu website
    public static String getMenuSewall() {
        Element sewallElement = sewallMenu.getElementById("Mon");
        return sewallElement.text();
    }

    //fetches the text in the Libby Menu website
    public static String getMenuLibby() {
        Element libbyElement = libbyMenu.getElementById("Mon");
        return libbyElement.text();
    }
}
