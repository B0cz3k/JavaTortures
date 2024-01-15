/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lukaszborak.javaproject1;

import java.io.Serializable;
import java.util.Date;

class Video extends Media implements Serializable {
    private final int duration;
    private final Date uploadDate;
    private volatile int numViews;

    public Video(Channel ch, String thumb, String nm, String desc, int time, Date date, boolean prem) {
        super(ch, thumb, nm, desc, prem);
        this.duration = time;
        this.uploadDate = date;
        this.numViews = 0;
    }

    @Override
    public String toString() {
        return getThumbnail() + "\nPosted on channel: " + getChannel().getName() + 
                "\nTitle: " + getName() + "\nDescription: " + 
                getDescription() + "\nUpload date: " + this.uploadDate + 
                "\nDuration: " + this.duration + " minutes\nViews: " + this.numViews + 
                "\nLikes: " + getNumLikes() + "\nPremium? " + isPremium() + "\n";
    }
    public void viewed() {
        this.numViews += 1;
    }
}