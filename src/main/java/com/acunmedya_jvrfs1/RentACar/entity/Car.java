package com.acunmedya_jvrfs1.RentACar.entity;

import jakarta.persistence.*;

@Entity  //veritabanı tablosu olduğunu işaret eder
@Table(name = "cars") //Tablo ismini temsil eder
public class Car {

    @Id //primary key alanı
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Otomatik artan Id
    @Column(name = "id")
    private int id;

    @Column(name = "modelYear")
    private int modelYear;

    @Column(name = "plate")
    private String plate;

    @Column(name = "dailyPrice")
    private double dailyPrice;

    @Column(name = "kilometer")
    private int kilometer;

    @ManyToOne()
    @JoinColumn(name = "modelId")
    private Model model;

    public Car(){

    }

    public Car(int id, int modelYear, String plate, double dailyPrice, int kilometer, Model model) {
        this.id = id;
        this.modelYear = modelYear;
        this.plate = plate;
        this.dailyPrice = dailyPrice;
        this.kilometer = kilometer;
        this.model = model;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public double getDailyPrice() {
        return dailyPrice;
    }

    public void setDailyPrice(double dailyPrice) {
        this.dailyPrice = dailyPrice;
    }

    public int getKilometer() {
        return kilometer;
    }

    public void setKilometer(int kilometer) {
        this.kilometer = kilometer;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }
}
