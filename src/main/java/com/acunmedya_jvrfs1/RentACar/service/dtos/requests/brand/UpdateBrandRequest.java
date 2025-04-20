package com.acunmedya_jvrfs1.RentACar.service.dtos.requests.brand;

public class UpdateBrandRequest {

    private int id;
    private String name;

    public UpdateBrandRequest(){

    }

    public UpdateBrandRequest(int id,String name) {
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
