package com.backend.eggmorning.domain.hotel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.eggmorning.domain.hotel.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {
    List<Hotel> findTop5ByOrderByRatingDesc();
}


