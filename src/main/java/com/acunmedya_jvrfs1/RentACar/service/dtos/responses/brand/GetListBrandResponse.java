package com.acunmedya_jvrfs1.RentACar.service.dtos.responses.brand;

public class GetListBrandResponse {
    private int id;
    private String name;

    public GetListBrandResponse(){

    }

    public GetListBrandResponse(int id,String name) {
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
