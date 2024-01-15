/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lukaszborak.javaproject1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.stream.Collectors;

class Simulation implements Serializable {
    private List<User> users;
    private List<Channel> channels;
    private volatile List<Media> media;
    private volatile List<Thread> threads;
    private Semaphore semaphore; //unused yet
    private boolean active;

    private static final List<String> USER_NAMES = List.of(
        "Alice", "Bob", "Charlie", "David", "Eva", "Frank", "Grace", "Hank", "Ivy", "Jack",
        "John", "Kate", "Liam", "Mia", "Noah", "Olivia", "Penny", "Quinn", "Riley", "Sam"
    );
    private static final List<String> CHANNEL_NAMES = List.of(
        "TechHub", "GourmetDelight", "AdventureQuest", "FitnessFiesta", "ArtisansCorner",
        "ScienceSphere", "MusicMingle", "FashionFiesta", "BookWorms", "TravelTreasures",
        "TechTrends", "FoodieFun", "ExplorerZone", "HealthHaven", "CraftyCreatives",
        "InnoScience", "MelodyMania", "StyleSpectrum", "PageTurners", "WanderlustWorld"
    );
    private static final Random random = new Random();
    
    public Simulation() {
        this.users = new ArrayList<>();
        this.channels = new ArrayList<>();
        this.media = new ArrayList<>();
        this.semaphore = new Semaphore(1);
        this.threads = new ArrayList<>();
        this.active = false;
    }
    
    public void addMedia(Media md) {
        this.media.add(md);
    }
    
    public boolean Active() {
        return this.active;
    }
    
    private User getRandomUserWithoutChannel() {
        List<User> usersWithoutChannel = users.stream()
                .filter(user -> user.getChannel() == null)
                .collect(Collectors.toList());
        if (!usersWithoutChannel.isEmpty()) {
            return usersWithoutChannel.get(random.nextInt(usersWithoutChannel.size()));
        }
        return null;
    }
    
    /* Button functionalities */
    public void start() {
        // Initial setup
        this.active = true;
        int numUsers = random.nextInt(91) + 10;
        int numChannels = random.nextInt(numUsers-10) + 10;
        for (int i = 0; i < numUsers; i++) {
            String userName = USER_NAMES.get(random.nextInt(USER_NAMES.size()));
            User user = new User(this, "thumbnail soon", userName + i, new Date(), random.nextBoolean());
            users.add(user);
            Thread userThread = new Thread(user);
            threads.add(userThread);
            userThread.start();
        }
        for (int i = 0; i < numChannels; i++) {
            String channelName = CHANNEL_NAMES.get(random.nextInt(CHANNEL_NAMES.size()));
            User userWithoutChannel = getRandomUserWithoutChannel();
            if (userWithoutChannel != null) {
                Channel channel = new Channel(this, userWithoutChannel, channelName + i);
                userWithoutChannel.setChannel(channel); // assign the channel to user
                channels.add(channel);
                Thread channelThread = new Thread(channel);
                threads.add(channelThread);
                channelThread.start();  
            }
        }
        // Users subscribe to channels
        for (User user : users) {
            int channelsToSubscribe = random.nextInt(channels.size()) + 1;
            for (int i = 0; i < channelsToSubscribe; i++) {
                int channelIndex = random.nextInt(channels.size());
                user.subscribeToChannel(channels.get(channelIndex));
            }
        }
    }
    
    public void resume() {
        this.active = true;
    }
    public void stop() {
        this.active = false;
    }
    public void save(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(this);
            System.out.println("Simulation saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Simulation load(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            Simulation loadedSimulation = (Simulation) ois.readObject();
            System.out.println("Simulation loaded successfully.");
            return loadedSimulation;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /* Jlist functionalities */
    public List<String> getUsernames() {
        List<String> usernames = new ArrayList<>();
        for (User user : users) {
            usernames.add(user.getName());
        }
        return usernames;
    }
    public List<String> getMediaNames() {
        List<String> medianames = new ArrayList<>();
        for (Media med : media) {
            medianames.add(med.getName());
        }
        return medianames;
    }
    public List<String> getChannelNames() {
        List<String> channelnames = new ArrayList<>();
        for (Channel channel : channels) {
            channelnames.add(channel.getName());
        }
        return channelnames;
    }
     
    /* Details tab functionality */
    public String getDetails(String name) {
        for (Media med : media) {
            if (med.getName().equals(name)) {
                return med.toString();
            }
        }
        for (User user : users) {
            if (user.getName().equals(name)) {
                return user.toString();
            }
        }
        for (Channel channel : channels) {
            if (channel.getName().equals(name)) {
                return channel.toString();
            }
        }
        return "Entity details will appear here...";
    }
    
    public List getUsers() {
        return users;
    }
    public List getChannels() {
        return channels;
    }
    public List getMedia() {
        return media;
    }
}