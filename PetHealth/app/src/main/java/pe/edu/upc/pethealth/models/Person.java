package pe.edu.upc.pethealth.models;

import android.os.Bundle;

/**
 * Created by User on 9/29/2017.
 */

public class Person  extends User{
        private int id;
        private String name;
        private String lastName;
        private String dni;
        private String address;
        private String phone;

        public Person() {
        }

    public Person(int id, String name,String lastName, String dni,String phone, String address) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
        this.address = address;
        this.phone = phone;
    }

    public int getId() {
            return id;
        }

        public Person setId(int id) {
            this.id = id;
            return this;
        }

        public String getName() {
            return name;
        }

        public Person setName(String name) {
            this.name = name;
            return this;
        }

        public String getLastName() {
            return lastName;
        }

        public Person setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public String getDni() {
            return dni;
        }

        public Person setDni(String dni) {
            this.dni = dni;
            return this;
        }

        public String getAddress() {
            return address;
        }

        public Person setAddress(String address) {
            this.address = address;
            return this;
        }

        public String getPhone() {
            return phone;
        }

        public Person setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Bundle toBundle(){
            Bundle bundle = new Bundle();
            bundle.putInt("id", id);
            bundle.putString("name", name);
            bundle.putString("last_name", lastName);
            bundle.putString("dni", dni);
            bundle.putString("address", address);
            bundle.putString("phone", phone);

            return bundle;
        }

        public static Person from(Bundle bundle){
            Person person = new Person();
            person.setId(bundle.getInt("id"))
                    .setName(bundle.getString("name"))
                    .setLastName(bundle.getString("last_name"))
                    .setDni(bundle.getString("dni"))
                    .setAddress(bundle.getString("address"))
                    .setPhone(bundle.getString("phone"));

            return person;
        }

}
