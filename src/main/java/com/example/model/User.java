package com.example.model;

public class User {
    private int id;
    private String name;
    private String username;
    private String password;
    private String role;

    private String dob;
    private String gender;
    private String email;
    private String phone;

    private String guardianName;
    private String guardianRelation;
    private String guardianPhone;
    private String guardianEmail;

    private String address;
    private String photoFileName;

    // No-args constructor
    public User() {
    }

    // Constructor with all fields (optional)
    public User(int id, String name, String username, String password, String role,
                String dob, String gender, String email, String phone,
                String guardianName, String guardianRelation, String guardianPhone, String guardianEmail,
                String address, String photoFileName) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.role = role;
        this.dob = dob;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.guardianName = guardianName;
        this.guardianRelation = guardianRelation;
        this.guardianPhone = guardianPhone;
        this.guardianEmail = guardianEmail;
        this.address = address;
        this.photoFileName = photoFileName;
    }

    // Getters and Setters
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getGuardianName() {
        return guardianName;
    }

    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }


    public String getGuardianRelation() {
        return guardianRelation;
    }

    public void setGuardianRelation(String guardianRelation) {
        this.guardianRelation = guardianRelation;
    }


    public String getGuardianPhone() {
        return guardianPhone;
    }

    public void setGuardianPhone(String guardianPhone) {
        this.guardianPhone = guardianPhone;
    }


    public String getGuardianEmail() {
        return guardianEmail;
    }

    public void setGuardianEmail(String guardianEmail) {
        this.guardianEmail = guardianEmail;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getPhotoFileName() {
        return photoFileName;
    }

    public void setPhotoFileName(String photoFileName) {
        this.photoFileName = photoFileName;
    }
}
