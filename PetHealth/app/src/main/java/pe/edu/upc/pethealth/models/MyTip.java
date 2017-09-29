package pe.edu.upc.pethealth.models;

import android.os.Bundle;

/**
 * Created by genob on 28/09/2017.
 */

public class MyTip {
    private int id;
    private int image;
    private String tittle;
    private String description;

    public MyTip(int id, int image, String tittle, String description) {
        this.id = id;
        this.image = image;
        this.tittle = tittle;
        this.description = description;
    }

    public MyTip() {
    }

    public int getId() {
        return id;
    }

    public MyTip setId(int id) {
        this.id = id;
        return this;
    }

    public int getImage() {
        return image;
    }

    public MyTip setImage(int image) {
        this.image = image;
        return this;
    }

    public String getTittle() {
        return tittle;
    }

    public MyTip setTittle(String tittle) {
        this.tittle = tittle;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public MyTip setDescription(String description) {
        this.description = description;
        return this;
    }

    public Bundle toBundle(){
        Bundle bundle = new Bundle();
        bundle.putInt("id",id);
        bundle.putInt("image",image);
        bundle.putString("tittle",tittle);
        bundle.putString("description",description);
        return bundle;
    }
    public static MyTip from(Bundle bundle){
        MyTip myTip = new MyTip();
        myTip.setId(bundle.getInt("id"))
                .setImage(bundle.getInt("image"))
                .setTittle(bundle.getString("tittle"))
                .setDescription(bundle.getString("description"));
        return myTip;
    }
}
