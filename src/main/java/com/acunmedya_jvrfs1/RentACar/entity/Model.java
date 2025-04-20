package com.acunmedya_jvrfs1.RentACar.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity  //veritabanı tablosu olduğunu işaret eder
@Table(name = "models") //Tablo ismini temsil eder
public class Model {

    @Id //primary key alanı
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Otomatik artan Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;


    @ManyToOne()
    @JoinColumn(name = "brandId")
    private Brand brand;

    @OneToMany(mappedBy = "model")
    private List<Car> cars;

    public Model(){

    }

    public Model(int id, String name, Brand brand,List<Car> cars) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.cars = cars;
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

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
