package pe.edu.upc.pethealth.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gonzalo on 16/11/2017.
 */

public class Appointment {
    private int id;
    private String vetName;
    private String veterinaryName;
    private String petName;
    private String date;
    private String description;
    private String prescription;

    public Appointment() {
    }

    public Appointment(int id, String vetName, String veterinaryName, String petName, String date, String description, String prescription) {
        this.id = id;
        this.vetName = vetName;
        this.veterinaryName = veterinaryName;
        this.petName = petName;
        this.date = date;
        this.description = description;
        this.prescription = prescription;
    }

    public int getId() {
        return id;
    }

    public Appointment setId(int id) {
        this.id = id;
        return this;
    }

    public String getVetName() {
        return vetName;
    }

    public Appointment setVetName(String vetName) {
        this.vetName = vetName;
        return this;
    }

    public String getVeterinaryName() {
        return veterinaryName;
    }

    public Appointment setVeterinaryName(String veterinaryName) {
        this.veterinaryName = veterinaryName;
        return this;
    }

    public String getPetName() {
        return petName;
    }

    public Appointment setPetName(String petName) {
        this.petName = petName;
        return this;
    }

    public String getDate() {
        return date;
    }

    public Appointment setDate(String date) {
        this.date = date;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Appointment setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getPrescription() {
        return prescription;
    }

    public Appointment setPrescription(String prescription) {
        this.prescription = prescription;
        return this;
    }

    public static Appointment from(JSONObject jsonObject){
        Appointment appointment = new Appointment();
        try {
            appointment.setId(jsonObject.getInt("appointmentId"))
                    .setVetName("vet")
                    .setVeterinaryName("veterinary")
                    .setPetName("pet")
                    .setDate("date")
                    .setDescription("description")
                    .setPrescription("prescriptiomn");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return appointment;
    }

    public static List<Appointment> from(JSONArray jsonArray){
        List<Appointment> appointments = new ArrayList<>();
        try{
            for(int i = 0; i<jsonArray.length();i++){
                appointments.add(from(jsonArray.getJSONObject(i)));
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
        return  appointments;
    }
}
