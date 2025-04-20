package com.acunmedya_jvrfs1.RentACar.repository;

import com.acunmedya_jvrfs1.RentACar.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<Model,Integer> {
}
