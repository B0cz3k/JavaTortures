/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lukaszborak.javaproject1;

import java.io.Serializable;

class Media implements Serializable {
    private final Channel channel;
    private final String thumbnail;
    private final String name;
    private final String description;
    private volatile int numLikes;
    private final boolean premium;

    public Media(Channel ch, String thumb, String nm, String desc, boolean prem) {
        this.channel = ch;
        this.thumbnail = thumb;
        this.name = nm;
        this.description = desc;
        this.numLikes = 0;
        this.premium = prem;
    }
    public boolean isPremium() {
        return this.premium;
    }
    public Channel getChannel() {
        return this.channel;
    }
    public String getThumbnail() {
        return this.thumbnail;
    }
    public String getName() {
        return this.name;
    }
    public String getDescription() {
        return this.description;
    }
    public int getNumLikes() {
        return this.numLikes;
    }
    public void like() {
        this.numLikes += 1;
    }
}