package com.acunmedya_jvrfs1.RentACar.service.dtos.responses.car;

public record GetListCarResponse(int id,int modelId,String modelName,int modelYear,String plate,double dailyPrice,int kilometer) {
}
