package org.example.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


// each class corresponds to one table in DB
// and each object corresponds to one row in table
@Entity  // specifies table in DB with which this entity or class is mapped
public class Alien {

    @Id  // alienId will be considered as primary key now
    private int alienId;
    private String aName;
    private String color;

    public int getAlienId() {
        return alienId;
    }

    public void setAlienId(int alienId) {
        this.alienId = alienId;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
