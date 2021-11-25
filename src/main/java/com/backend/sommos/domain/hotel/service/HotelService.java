package com.backend.sommos.domain.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.backend.sommos.domain.hotel.entity.Hotel;
import com.backend.sommos.domain.hotel.repository.HotelRepository;

@Service("hotelService")
public class HotelService {

	private HotelRepository hotelRepository;

	@Autowired
	public HotelService(@Qualifier("hotelRepository")HotelRepository hotelRepository){
		this.hotelRepository = hotelRepository;
	}

	public List<Hotel> getTopHotels(int size){
		return hotelRepository.findAll(PageRequest.of(0, size, Sort.by(Sort.Direction.ASC, "rating"))).getContent();
	}
}
