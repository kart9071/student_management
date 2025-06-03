package com.example.model;

public class User {
    private int id;
    private String name;
    private String username;
    private String password;
    private String role;

    //no-args constructor
    public User(){

    }
    //constructor
    public User(int id, String name,String username, String password, String role) {
        this.id = id;
        this.name=name;
        this.username = username;
        this.password = password;
        this.role=role;
    }
    // Getter and Setter for id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public void setUsername(String username){
        this.username=username;
    }

    public void setPassword(String password){
        this.password=password;
    }

    public String getRole(){
        return role;
    }

    public void setRole(String role){
        this.role=role;
    }
}
