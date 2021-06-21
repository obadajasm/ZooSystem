package models;

import java.time.LocalDate;

public class Animal {
    private int id;
    private String name;
    private String gender;
    private LocalDate birthdate;
    private int categoryID;
    private String categoryName;
   
    private int weight;
    private int isSick;
    private LocalDate createdAt;
    private LocalDate updatedAt;

    public String getCategoryName() { return categoryName ; }
    public void setCategoryName(String catName) {
    categoryName=catName;
            }
    public int getID() { return id; }

    public Animal(String name, String gender, LocalDate birthdate, int categoryID, int weight) {
        this.name = name;
        this.gender = gender;
        this.birthdate = birthdate;
        this.categoryID = categoryID;
        this.weight = weight;
    }
    public Animal(int id,String name, String gender, LocalDate birthdate, int categoryID, int weight) {
        this.id=id;
        this.name = name;
        this.gender = gender;
        this.birthdate = birthdate;
        this.categoryID = categoryID;
        this.weight = weight;
    }
    public void setID(int value) { this.id = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

   

    public String getGender() { return gender; }
    public void setGender(String value) { this.gender = value; }

    public LocalDate getBirthdate() { return birthdate; }
    public void setBirthdate(LocalDate value) { this.birthdate = value; }

    public int getCategoryID() { return categoryID; }
    public void setCategoryID(int value) { this.categoryID = value; }

    public int getWeight() { return weight; }
    public void setWeight(int value) { this.weight = value; }

    public int getIsSick() { return isSick; }
    public void setIsSick(int value) { this.isSick = value; }

    public LocalDate getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDate value) { this.createdAt = value; }

    public LocalDate getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDate value) { this.updatedAt = value; }
}

