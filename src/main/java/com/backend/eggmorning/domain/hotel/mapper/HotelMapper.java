package com.backend.eggmorning.domain.hotel.mapper;

import com.backend.eggmorning.domain.hotel.dto.HotelDTO;
import com.backend.eggmorning.domain.hotel.entity.Hotel;

public class HotelMapper {
	public static HotelDTO convertToHotelDTO(Hotel hotel) {
		HotelDTO hotelDto = new HotelDTO();

		hotelDto.setName(hotel.getName());
		hotelDto.setHotelNo(hotel.getHotelNo());
		hotelDto.setName(hotel.getName());
		hotelDto.setAddress(hotel.getAddress());
		hotelDto.setPhone(hotel.getPhone());
		hotelDto.setLevel(hotel.getLevel());
		hotelDto.setRating(hotel.getRating());
		hotelDto.setThumbnail(hotel.getThumbnail());
		hotelDto.setRegdate(hotel.getRegdate());

		return hotelDto;
	}
}
