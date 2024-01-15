/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lukaszborak.javaproject1;

import java.io.Serializable;
import java.util.Date;

class Stream extends Media implements Serializable{
    private final Date startTime;
    private volatile Date endTime;
    private volatile int numWatching;

    public Stream(Channel ch, String thumb, String nm, String desc, Date start) {
        super(ch, thumb, nm, desc, false);
        this.startTime = start;
        this.endTime = null;
        this.numWatching = 0;
    }

    @Override
    public String toString() {
        if (this.endTime == null) {
            return getThumbnail() + "\nPosted on channel: " + getChannel().getName() + 
                    "\nTitle: " + getName() + "\nDescription: " + 
                    getDescription() + "\nStarted at: " + this.startTime + 
                    "\nUsers watching: " + this.numWatching + "\nLikes: " + 
                    getNumLikes() + "\n";
        } else {
            return getThumbnail() + "\nPosted on channel: " + getChannel().getName() + 
                    "\nTitle: " + getName() + "\nDescription: " + 
                    getDescription() + "\nStarted at: " + this.startTime + 
                    "\nFinished at: " + this.endTime + "\nLikes: " + 
                    getNumLikes() + "\n";
        }
    }
    
    public Date getEndTime() {
        return this.endTime;
    }
    public void setEndTime(Date end) {
        this.endTime = end;
    }
    public void watching() {
        this.numWatching += 1;
    }
    public void leaving() {
        this.numWatching -= 1;
    }
}