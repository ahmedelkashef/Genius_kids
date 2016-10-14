package com.example.ahmedelkashef.ziziniakids;

/**
 * Created by ahmedelkashef on 10/13/2016.
 */
public class Student {
    private  String Name;
    private  String CLASS;
    private  String Password;
    private  String Nursery;
    private  String Email;
    private double Age;

    public double getAge() {
        return Age;
    }

    public void setAge(double age) {
        Age = age;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNursery() {
        return Nursery;
    }

    public void setNursery(String nursery) {
        Nursery = nursery;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }


    public String getCLASS() {
        return CLASS;
    }

    public void setClass(String aClass) {
        CLASS = aClass;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    private  String ID;


}
