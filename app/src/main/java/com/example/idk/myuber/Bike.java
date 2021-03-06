package com.example.idk.myuber;

/**
 * Created by Gabriel on 3/14/2015.
 * description: this class represents the bike that is ready for usage among other users of the app that you are able to click on, on the map.
 */
public class Bike {
    //the bike class has 6 method variables

   private int bike_rating;
   private String owner_name;
   private Boolean isAvailable;
   private String lat;//coords latitude
   private String lon;//coords longitude
   private String bike_id;// a string because we are not doing math with it. it also represents the bike as an identification

   //bike class constructor takes in parameters from the inputs of the user to be stored... somewhere.

    public Bike(int bike_rating, String owner_name, Boolean isAvailable, String lat, String lon, String bike_id){
        this.bike_rating = bike_rating;
        this.owner_name = owner_name;
        this.isAvailable = isAvailable;
        this.lat = lat;
        this.lon = lon;
        this.bike_id = bike_id;
    }
    //getters and setters for the method variables
    //NEED: figure out where to connect the the variables to.

    public int getBike_rating(){
        return  bike_rating;
    }
    public String getOwner_name(){
        return owner_name;
    }
    public Boolean getIsAvailable(){ return isAvailable; }
    public String getLat() { return lat; }
    public String getLon() { return lon; }
    public String getBike_id() { return bike_id; }

    public void setBike_rating(int bike_rating){
        this.bike_rating = bike_rating;
    }
    public void setOwner_name(String owner_name){
        this.owner_name = owner_name;
    }
    public void setIsAvailable(Boolean isAvailable) { this.isAvailable = isAvailable; }
    public void setLat(String lat) { this.lat = lat; }
    public void setLon(String lon) { this.lon = lon; }
    public void setBike_id(String bike_id) { this.bike_id = bike_id; }

}
