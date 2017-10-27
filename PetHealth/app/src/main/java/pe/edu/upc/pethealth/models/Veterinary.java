package pe.edu.upc.pethealth.models;

import android.os.Bundle;

/**
 * Created by genob on 26/10/2017.
 */

public class Veterinary {
    private String id;
    private String name;
    private String preVideo;
    private String phoneNumber;
    private String altitude;
    private String latitude;
    private String openingHours;

    public Veterinary() {
    }

    public Veterinary(String id, String name, String preVideo, String phoneNumber, String altitude, String latitude, String openingHours) {
        this.id = id;
        this.name = name;
        this.preVideo = preVideo;
        this.phoneNumber = phoneNumber;
        this.altitude = altitude;
        this.latitude = latitude;
        this.openingHours = openingHours;
    }

    public String getId() {
        return id;
    }

    public Veterinary setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Veterinary setName(String name) {
        this.name = name;
        return this;
    }

    public String getPreVideo() {
        return preVideo;
    }

    public Veterinary setPreVideo(String preVideo) {
        this.preVideo = preVideo;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Veterinary setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getAltitude() {
        return altitude;
    }

    public Veterinary setAltitude(String altitude) {
        this.altitude = altitude;
        return this;
    }

    public String getLatitude() {
        return latitude;
    }

    public Veterinary setLatitude(String latitude) {
        this.latitude = latitude;
        return this;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public Veterinary setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
        return this;
    }
    public Bundle toBundle(){
        Bundle bundle = new Bundle();
        bundle.putString("id",id);
        bundle.putString("name",name);
        bundle.putString("pre_video",preVideo);
        bundle.putString("phone_number",phoneNumber);
        bundle.putString("altitude",altitude);
        bundle.putString("latitude",latitude);
        bundle.putString("opening_hours",openingHours);
        return bundle;
    }
    public static Veterinary from(Bundle bundle){
        Veterinary veterinary = new Veterinary();
        veterinary.setId(bundle.getString("id"))
                .setName(bundle.getString("name"))
                .setPreVideo(bundle.getString("pre_video"))
                .setPhoneNumber(bundle.getString("phone_number"))
                .setAltitude(bundle.getString("altitude"))
                .setLatitude(bundle.getString("latitude"))
                .setOpeningHours(bundle.getString("opening_hours"));
        return veterinary;
    }
}
