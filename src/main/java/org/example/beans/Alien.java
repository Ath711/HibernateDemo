package org.example.beans;

import jakarta.persistence.*;


/*
 each class corresponds to one table in DB
 and each object corresponds to one row in table

 @Entity   specifies table in DB with which this entity or class is mapped

 @Entity(name = "NewAlien")  if we don't want class name to be table name which is default, we can provide one

 the above annotation will also set Entity name as NewAlien, Basically there are 3 things
 class name, entity name and table name
 table name is derived from entity name
*/

// if we don't want to change the entity name
@Entity
@Table(name = "NewAlien")
public class Alien {

    @Id  // alienId will be considered as primary key now
    private int alienId;

    @Transient // aName will not be stored in DB
    private String aName;


    @Column(name = "alienColor")
    // we can also set column names in table, if we don't want one with default that is variable names
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
