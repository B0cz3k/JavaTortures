/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lukaszborak.javaproject1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

class User implements Runnable, Serializable {
    private final Simulation simulation;
    private final String thumbnail;
    private final String name;
    private final Date joinDate;
    private Channel myChannel;
    private List<Channel> followingChannels;
    private final boolean premium;
    private volatile Media currentMedia;
    private volatile Queue<Media> queue;

    public User(Simulation sim, String thumb, String nm, Date date, boolean prem) {
        this.simulation = sim;
        this.thumbnail = thumb;
        this.name = nm;
        this.joinDate = date;
        this.followingChannels = new ArrayList<>();
        this.premium = prem;
        this.currentMedia = null;
        this.myChannel = null;
        this.queue = new LinkedList<>();
    }

    public void subscribeToChannel(Channel channel) {
        if (!this.followingChannels.contains(channel)) {
            this.followingChannels.add(channel);
            channel.addFollower(this);
        }
    }
    @Override
    public String toString() {
        String string_channels = "";
        String string_queue = "";
        String current = "Nothing";
        String string_myChannel = "-";
        for (Channel channel : this.followingChannels) {
            string_channels += "\n";
            string_channels = string_channels + " - " + channel.getName();
        }
        for (Media media : this.queue) {
            string_queue += "\n";
            string_queue = string_queue + " - " + media.getName();
        }
        if (this.currentMedia != null) {
            current = this.currentMedia.getName();
        }
        if (this.myChannel != null) {
            string_myChannel = this.myChannel.getName();
        }
        return this.thumbnail + "\nUsername: " + this.name + "\nJoin date: " + 
                this.joinDate + "\nChannel: " + string_myChannel + "\nPremium user?: " 
                + this.premium + "\nFollowing " + this.followingChannels.size() + 
                " channels\nList of following channels: " + string_channels + 
                "\nCurrently watching: " + current + "\n" + this.queue.size() + 
                " videos in queue\nQueue: " + string_queue + "\n";
    }
    @Override
    public void run() {
        Random random = new Random();
        try {
            Thread.sleep(1000);
            while (simulation.Active()) {
                synchronized (this.queue) {
                    try {
                        while (this.queue.isEmpty()) {
                            this.queue.wait(1000);
                            if (!simulation.Active()) {
                                break;
                            }
                        }
                        if (!this.queue.isEmpty()) {
                            synchronized (this) {
                                try {
                                    this.currentMedia = this.queue.poll();
                                    if (random.nextFloat() > 0.5) { // user likes the content
                                        this.currentMedia.like();
                                    }
                                    if (this.currentMedia instanceof Stream stream) { // increment the views / currently watching
                                        stream.watching();
                                        Thread.sleep(1000);
                                    } else {
                                        Video video = (Video) currentMedia;
                                        video.viewed();
                                        Thread.sleep(500);
                                    }
                                    if (this.currentMedia instanceof Stream stream) {
                                        stream.leaving();
                                    }
                                } catch (InterruptedException ex) {
                                    Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        }
                    } catch (InterruptedException e) {
                        Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, e);
                    }
                }
            }
        } catch (InterruptedException e) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public Channel getChannel() {
        return this.myChannel;
    }
    public void setChannel(Channel ch) {
        this.myChannel = ch;
    }
    public String getThumbnail() {
        return this.thumbnail;
    }
    public String getName() {
        return this.name;
    }
    public Date getJoinDate() {
        return this.joinDate;
    }
    public List<Channel> getFollowingChannels() {
        return this.followingChannels;
    }
    public boolean isPremium() {
        return this.premium;
    }
    public Media getCurrentMedia() {
        return this.currentMedia;
    }
    public void setCurrentMedia(Media currentMedia) {
        this.currentMedia = currentMedia;
    }
    public Queue<Media> getQueue() {
        return this.queue;
    }
    public void addToQueue(Media md) {
        synchronized(this.queue) {
           this.queue.add(md);
            this.queue.notify(); // notify that the queue is no longer empty 
        }
    }
}