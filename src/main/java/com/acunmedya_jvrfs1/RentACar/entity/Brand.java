package com.acunmedya_jvrfs1.RentACar.entity;

import jakarta.persistence.*;

@Entity  //veritabanı tablosu olduğunu işaret eder
@Table(name = "brands") //Tablo ismini temsil eder
public class Brand {

    @Id //primary key alanı
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Otomatik artan Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    public Brand(){

    }

    public Brand(int id, String name) {
        this.id = id;
        this.name = name;
    }

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
}
