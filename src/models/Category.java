package models;

import java.time.LocalDate;
import java.time.OffsetDateTime;

public class Category {
    private int id;
    private String name;

    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String description;
    private String catName;

    public int getID() { return id; }
    public void setID(int value) { this.id = value; }

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }
     public Category(int id,String name, String description) {
         this.id=id;
        this.name = name;
        this.description = description;
    }
    public String getCatName() { return catName; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public LocalDate getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDate value) { this.createdAt = value; }

    public LocalDate getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDate value) { this.updatedAt = value; }

    public String getDescription() { return description==null?"":description ; }
    public void setDescription(String value) { this.description = value; }
}
