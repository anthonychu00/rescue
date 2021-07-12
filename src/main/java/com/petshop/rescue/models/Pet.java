package com.petshop.rescue.models;

import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "myPets")
public class Pet {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "dateArrived")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateArrived;

    @Column(name = "animalType")
    private String animalType;

    @Column(name = "age")
    private int age;

    public Pet(){

    }

    public Pet(Date dateArrived, String animalType, int age){
        this.dateArrived = dateArrived;
        this.animalType = animalType;
        this.age = age;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Date getDateArrived(){
        return dateArrived;
    }

    public void setDateArrived(Date dateArrived){
        this.dateArrived = dateArrived;
    }

    public String getAnimalType(){
        return animalType;
    }

    public void setAnimalType(String animalType){
        this.animalType = animalType;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }
}
