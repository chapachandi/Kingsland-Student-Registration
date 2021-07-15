package view.tm;

import javafx.scene.control.Button;

public class StudentTM {
    private String id;
    private String name;
    private String address;
    private String contact;
    private String dob;

    public StudentTM() {
    }

    private String gendeer;

    public StudentTM(String id, String name, String address, String contact, String dob, String gendeer) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.dob = dob;
        this.gendeer = gendeer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGendeer() {
        return gendeer;
    }

    public void setGendeer(String gendeer) {
        this.gendeer = gendeer;
    }
}
