package pe.edu.upc.pethealth.models;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.pethealth.R;

/**
 * Created by genob on 18/09/2017.
 */

public class MyPetsRepository {
    public static List<MyPet> getMyPets(){
        List<MyPet> myPets = new ArrayList<>();
        myPets.add(new MyPet(1,"Argos","Raza: JACK RUSSEL\n Edad: 2 anios", R.mipmap.ic_launcher));
        myPets.add(new MyPet(2,"Freyja","Raza: JACK RUSSEL\n Edad: 2 anios", R.mipmap.ic_launcher));
        myPets.add(new MyPet(3,"Aura","Raza: COCKER SPANIEL\n Edad: 2 meses", R.mipmap.ic_launcher));
        myPets.add(new MyPet(4,"Atom","Raza: LABRADOR\n Edad: 2 anios", R.mipmap.ic_launcher));
        return myPets;
    }
}
