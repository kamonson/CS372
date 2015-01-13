/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw3;

import java.util.HashMap;
import java.util.ArrayList;

/**
 *
 * @author kamonson17
 */
public class EventManager {

    HashMap<String, Events> hashEvents = new HashMap<String, Events>();
    HashMap<String, HashMap> hashDays = new HashMap<String, HashMap>();
    HashMap<String, HashMap> hashMonth = new HashMap<String, HashMap>();
    HashMap<String, HashMap> hashYear = new HashMap<String, HashMap>();
    private String year = "none";
    private String month = "none";
    private String day = "none";
    private String eventNumber = "none";
    private int RunningNumber = 0;

    public void addEvent(String Y, String M, String D, String ET, String EB) {
        this.RunningNumber += RunningNumber; //this makes it start at 1
        Events e = new Events(Y, M, D, ET, EB, RunningNumber);//does the add
        //cascade of maps containing maps for easy look up
        hashEvents.put(e.getEventNumber(), e);
        hashDays.put(e.getDay(), hashEvents);
        hashMonth.put(e.getMonth(), hashDays);
        hashYear.put(e.getYear(), hashMonth);
    }

    public ArrayList getDaysEventsTitle(String Y, String M, String D) {
        ArrayList<String> array = new ArrayList<String>();
        for (int i = 0; i < hashEvents.size(); i++) {
            if (hashEvents.get(String.join(Y + M + D + String.valueOf(i))) == null) {
                continue;
            } else {
                array.add(hashEvents.get(String.join(Y + M + D + String.valueOf(i))).getEventTitle());
            }
        }
        return array;
    }

    public ArrayList getDaysEventsBody(String Y, String M, String D) {
        ArrayList<String> array = new ArrayList<String>();
        for (int i = 0; i < hashEvents.size(); i++) {
            if (hashEvents.get(String.join(Y + M + D + String.valueOf(i))) == null) {
                continue;
            } else {
                array.add(hashEvents.get(String.join(Y + M + D + String.valueOf(i))).getEventBody());
            }
        }
        return array;
    }

    public ArrayList getDaysEvents(String Y, String M, String D) {
        ArrayList<Events> array = new ArrayList<Events>();
        for (int i = 0; i < hashEvents.size(); i++) {
            if (hashEvents.get(String.join(Y + M + D + String.valueOf(i))) == null) {
                continue;
            } else {
                array.add(hashEvents.get(String.join(Y + M + D + String.valueOf(i))));
            }
        }
        return array;
    }
}