package com.backend.sommos.domain.hotel.contoroller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.backend.sommos.domain.hotel.dto.HotelDTO;
import com.backend.sommos.domain.hotel.entity.Hotel;
import com.backend.sommos.domain.hotel.mapper.HotelMapper;
import com.backend.sommos.domain.hotel.service.HotelService;

@Scope()
@Controller()
@RequestMapping("hotel")
public class HotelController {
	private HotelService hotelService;

	@Autowired
	public HotelController(@Qualifier("hotelService") HotelService hotelService) {
		this.hotelService = hotelService;
	}

	@ResponseBody
	@GetMapping("ranking/top")
	public List<HotelDTO> getTopRatingHotel(@RequestParam("size") int size) {
		List<Hotel> hotels = hotelService.getTopHotels(size);
		return hotels.stream().map(hotel -> HotelMapper.convertToHotelDTO(hotel)).collect(Collectors.toList());
	}
}







