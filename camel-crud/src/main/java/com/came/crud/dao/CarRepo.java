package com.came.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.came.crud.entities.Car;

public interface CarRepo extends JpaRepository<Car, Long>{

}
