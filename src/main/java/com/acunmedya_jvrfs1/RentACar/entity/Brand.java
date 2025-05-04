package com.acunmedya_jvrfs1.RentACar.entity;

import com.acunmedya_jvrfs1.RentACar.common.entity.BaseEntity;
import jakarta.persistence.*;
import org.hibernate.annotations.SQLRestriction;

import java.util.List;

@Entity  //veritabanı tablosu olduğunu işaret eder
@Table(name = "brands") //Tablo ismini temsil eder
@SQLRestriction(value = "deleted_at IS NULL")
public class Brand extends BaseEntity {

    @Id //primary key alanı
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Otomatik artan Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "brand",cascade = CascadeType.ALL)
    private List<Model> models;

    public Brand(){

    }

    public Brand(int id, String name,List<Model> models) {
        this.id = id;
        this.name = name;
        this.models= models;
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

    public List<Model> getModels() {
        return models;
    }

    public void setModels(List<Model> models) {
        this.models = models;
    }
}
