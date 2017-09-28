package pe.edu.upc.pethealth.models;

import android.os.Bundle;

/**
 * Created by genob on 18/09/2017.
 */

public class MyPet {
    private int id;
    private String name;
    private String race;
    private int age;
    private String description;
    private int image;




    public MyPet() {

    }

    public MyPet(int id, String name, String race, int age, String description, int image) {
        this.id = id;
        this.name = name;
        this.race = race;
        this.age = age;
        this.description = description;
        this.image = image;
    }


    public int getId(){
        return id;
    }

    public MyPet setId(int id){
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public MyPet setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public MyPet setDescription(String description) {
        this.description = description;
        return this;
    }

    public int getImage() {
        return image;
    }

    public MyPet setImage(int image) {
        this.image = image;
        return this;
    }

    public String getRace() {
        return race;
    }

    public MyPet setRace(String race) {
        this.race = race;
        return this;
    }

    public int getAge() {
        return age;
    }

    public MyPet setAge(int age) {
        this.age = age;
        return this;
    }

    public Bundle toBundle(){
        Bundle bundle = new Bundle();
        bundle.putInt("id",id);
        bundle.putString("name",name);
        bundle.putString("race",race);
        bundle.putInt("age",age);
        bundle.putString("description",description);
        bundle.putInt("image",image);
        return bundle;
    }

    public static MyPet from(Bundle bundle){
        MyPet myPet = new MyPet();
        myPet.setId(bundle.getInt("id"))
                .setName(bundle.getString("name"))
                .setRace(bundle.getString("race"))
                .setAge(bundle.getInt("age"))
                .setDescription(bundle.getString("description"))
                .setImage(bundle.getInt("image"));
        return myPet;

    }
}
