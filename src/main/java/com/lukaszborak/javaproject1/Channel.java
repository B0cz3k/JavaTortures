/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lukaszborak.javaproject1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

class Channel implements Runnable, Serializable {
    private final int id;
    private Simulation simulation;
    private final User owner;
    private final String name;
    private List<User> followers;
    private List<Media> myVideos;
    
    private static final List<String> VIDEO_TITLES = List.of(
        "The Quantum Revolution", "Culinary Masterclass", "Journey to the Unknown", "Fitness for Life", "Artistry Unleashed",
        "Space Odyssey", "Harmony in Music", "Fashion Forward", "Literary Escapade", "Wanderlust Chronicles",
        "Future Tech Trends", "Gastronomic Delights", "Mystical Journeys", "Wellness Wonders", "Creative Expressions",
        "Celestial Explorations", "Symphony of Sounds", "Trendsetting Styles", "Bookworm Bonanza", "Global Adventures"
    );
    private static final List<String> STREAM_TITLES = List.of(
        "Live Coding Session", "Cooking Extravaganza", "Outdoor Expedition", "Fitness Live Workout", "Art Q&A Session",
        "Science Talk Show", "Music Jam Session", "Fashion Trends Update", "Book Club Live", "Travel Diaries Live",
        "CodeCrafting Live", "Gourmet Gala Live", "Nature Quest Live", "Wellness Workout Live", "Artistic Insights Live",
        "Cosmic Conversations", "Melodic Moments Live", "Style Showcase Live", "Literary Lounge Live", "Explorer's Journal Live"
    );
    private static final List<String> VIDEO_DESCRIPTIONS = List.of(
        "Explore the mysteries of quantum physics and its game-changing impact on technology and our understanding of the cosmos.",
        "Indulge your senses in the world of gastronomy as master chefs showcase their culinary expertise and reveal the artistry behind each dish.",
        "Embark on an enthralling expedition into the unknown, filled with surprises, discoveries, and captivating adventures.",
        "Discover sustainable and effective fitness routines designed to enhance your well-being and promote a healthy lifestyle.",
        "Immerse yourself in a world where creativity knows no bounds. Witness the unveiling of artistic expressions that defy convention.",
        "Embark on a mesmerizing journey through the cosmos, exploring the wonders of space and our place in the universe.",
        "Experience the perfect blend of harmonious melodies and insightful discussions, bringing you the joy of music and intellectual exploration.",
        "Dive into the ever-evolving world of fashion, where trends are set, and style is a form of self-expression.",
        "Join a literary escapade that transcends genres and takes you on a thought-provoking journey through the written word.",
        "Satiate your wanderlust with chronicles from around the world, as adventurers share their awe-inspiring travel experiences.",
        "Stay ahead of the curve by exploring the latest trends in future technology and innovations that shape our digital landscape.",
        "Savor the delights of gourmet cuisine as culinary experts showcase mouthwatering dishes and culinary craftsmanship.",
        "Embark on mystical journeys that unravel ancient legends, folklore, and the enchanting stories that shape diverse cultures.",
        "Improve your overall well-being with insights into wellness wonders that promote a balanced and healthy lifestyle.",
        "Witness the power of creativity as artists express themselves through various mediums, pushing the boundaries of imagination.",
        "Embark on celestial explorations, unraveling the mysteries of the universe, and gaining a deeper understanding of cosmic phenomena.",
        "Experience a symphony of sounds that transport you to musical realms, showcasing the diversity of genres and the beauty of composition.",
        "Stay ahead in the world of fashion by witnessing trendsetting styles that redefine the boundaries of personal expression.",
        "Delve into a bookworm's bonanza, exploring literary masterpieces, book recommendations, and engaging discussions on literature.",
        "Join global adventures that take you to far-reaching corners of the earth, discovering cultures, traditions, and the beauty of diverse landscapes."
    );
    private static final List<String> STREAM_DESCRIPTIONS = List.of(
        "Engage in a live coding session, where programmers showcase their skills, share insights, and tackle real-world coding challenges.",
        "Experience a cooking extravaganza with live demonstrations of delicious recipes, cooking tips, and interactive Q&A sessions with chefs.",
        "Embark on an outdoor expedition with thrilling adventures, nature exploration, and live storytelling from the heart of the wilderness.",
        "Get active with a fitness live workout, featuring energetic routines, fitness tips, and interactive sessions to keep you in shape.",
        "Participate in an art Q&A session, where artists discuss their work, techniques, and answer questions from an enthusiastic audience.",
        "Engage in enlightening discussions on various scientific topics, discoveries, and breakthroughs in a captivating science talk show.",
        "Immerse yourself in a live music jam session, featuring talented musicians, diverse genres, and the magic of spontaneous musical collaboration.",
        "Stay stylish and informed with a live update on fashion trends, runway highlights, and discussions on the latest in the world of fashion.",
        "Join a lively book club live session, where readers discuss their favorite books, share recommendations, and explore literary themes.",
        "Embark on travel diaries live, where globetrotters share their real-time adventures, travel tips, and cultural discoveries from around the world.",
        "Experience live coding in action with a code crafting live session, where programmers build and demonstrate software solutions.",
        "Indulge in a gourmet gala live, featuring culinary delights, cooking demonstrations, and interactive discussions with food enthusiasts.",
        "Explore nature in real-time with a nature quest live session, showcasing the beauty of the great outdoors and wildlife adventures.",
        "Stay fit and active with a wellness workout live session, offering exercise routines, health tips, and interactive fitness challenges.",
        "Gain insights into the artistic process with an artistic insights live session, where creators share their inspiration and creative techniques.",
        "Engage in cosmic conversations that delve into space exploration, astronomy, and discussions on the mysteries of the cosmos.",
        "Experience melodic moments live with captivating musical performances, live concerts, and a celebration of the beauty of music.",
        "Stay trendy with a style showcase live session, featuring fashion influencers, style tips, and a showcase of the latest in fashion.",
        "Join a literary lounge live session, where book lovers gather to discuss literature, book recommendations, and literary analysis.",
        "Embark on an explorer's journal live session, where adventurers share real-time accounts of their journeys, discoveries, and cultural encounters."
    );
    private static final Random random = new Random();
    
    public Channel(int index, Simulation sim, User owner, String nm) {
        this.id = index;
        this.simulation = sim;
        this.owner = owner;
        this.name = nm;
        this.followers = new ArrayList<>();
        this.myVideos = new ArrayList<>();
    }
    
    public void updateSimulation(Simulation sim) {
        this.simulation = sim;
    }
    
    public void addFollower(User user) {
        if (!this.followers.contains(user)) {
            this.followers.add(user);
            user.subscribeToChannel(this);
        }
    }
    public void notifyFollowers(Media md) {
        List<User> followersCopy;
        synchronized (this.followers) {
            followersCopy = new ArrayList<>(this.followers);
        }
        for (User follower : followersCopy) {
            if (md.isPremium()) {
                if (follower.isPremium()) {
                    synchronized (follower) {
                        follower.addToQueue(md);
                    }
                }
            } else {
                synchronized (follower) {
                    follower.addToQueue(md);
                }
            }
        }
    }
    public void publish(int i) {
        if (random.nextFloat() > 0.5) {
            int index = random.nextInt(VIDEO_TITLES.size());
            String videoTitle = VIDEO_TITLES.get(index);
            String videoDescription = VIDEO_DESCRIPTIONS.get(index);
            Video video = new Video(this, "thumbnail.png", videoTitle + i + this.id, videoDescription, random.nextInt(30) + 1, new Date(), random.nextBoolean());
            this.myVideos.add(video); // add to the channel's list of videos
            this.simulation.addMedia(video); // add video to media list in simulation
            notifyFollowers(video); // notify all folowers that a new video has been posted
        } else {
            int index = random.nextInt(STREAM_TITLES.size());
            String streamTitle = STREAM_TITLES.get(index);
            String streamDescription = STREAM_DESCRIPTIONS.get(index);
            Stream stream = new Stream(this, "thumbnail.png", streamTitle + i + this.id, streamDescription, new Date());
            this.myVideos.add(stream); // add to the channel's list of videos
            this.simulation.addMedia(stream); // add stream to media list in simulation
            notifyFollowers(stream); // notify all folowers that a new video has been posted
        }
    }
    @Override
    public String toString() {
        String string_followers = "";
        String string_videos = "";
        for (User follower : this.followers) {
            string_followers += "\n";
            string_followers = string_followers + " - " + follower.getName();
        }
        for (Media med : this.myVideos) {
            string_videos += "\n";
            string_videos = string_videos + " - " + med.getName();
        }
        return "Name: " + this.name + "\nOwner: " + this.owner.getName() + 
                "\nNumber of followers: " + this.followers.size() + 
                "\nList of followers: " + string_followers + "\nNumber of videos: " + 
                this.myVideos.size() + "\nList of videos: " + string_videos;
    }
    
    private List<Stream> getActiveStreams() {
        List<Stream> streams = new ArrayList<>();
        for (Media media : this.myVideos) {
            if (media instanceof Stream stream) {
                if (stream.getEndTime() == null) {
                    streams.add(stream);
                }
            }
        }
        return streams;
    }
    @Override
    public void run() {
        int counter = 0;
        synchronized(this.simulation) {
            publish(counter);
        }
        while (simulation.Active()) {
            try {
                if (random.nextFloat() > 0.6) { // publishing at random moments
                    synchronized(this.simulation) {
                        publish(counter);
                    }
                    counter += 1;
                    if (random.nextFloat() > 0.6) { // channel decides to end the stream
                        List<Stream> activeStreams = getActiveStreams();
                        if (!activeStreams.isEmpty()) {
                            int randomIndex = random.nextInt(activeStreams.size());
                            Stream randomStream = activeStreams.get(randomIndex);
                            randomStream.setEndTime(new Date());
                        }
                    }
                }
                Thread.sleep(800);
            } catch (InterruptedException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public List<User> getFollowers() {
        return this.followers;
    }
    public void addFollowers(List<User> followers) {
        this.followers.addAll(followers);
    }
    public List<Media> getMyVideos() {
        return this.myVideos;
    }
    public void setMyVideos(List<Media> myVideos) {
        this.myVideos = myVideos;
    }
    public String getName() {
        return this.name;
    }
}