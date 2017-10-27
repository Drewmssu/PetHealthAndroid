package pe.edu.upc.pethealth.repositories;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.pethealth.R;
import pe.edu.upc.pethealth.models.MyPet;

/**
 * Created by genob on 18/09/2017.
 */

public class MyPetsRepository {
    public static List<MyPet> getMyPets(){
        List<MyPet> myPets = new ArrayList<>();
        myPets.add(new MyPet(1,"Argos","JACK RUSSEL",2,"Caracteristicas principales:\n color blanco con marron", R.mipmap.ic_launcher));
        myPets.add(new MyPet(2,"Freyja","JACK RUSSEL",2,"Caracteristicas principales:\n color blanco con marron", R.mipmap.ic_launcher));
        myPets.add(new MyPet(3,"Aura","COCKER SPANIEL",2,"Orejas Grandes", R.mipmap.ic_launcher));
        myPets.add(new MyPet(4,"Atom","LABRADOR",1,"Raza: LABRADOR\n Edad: 2 anios", R.mipmap.ic_launcher));
        return myPets;
    }
}
