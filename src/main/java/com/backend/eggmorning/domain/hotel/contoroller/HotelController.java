package com.backend.eggmorning.domain.hotel.contoroller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.backend.eggmorning.domain.hotel.dto.HotelDTO;
import com.backend.eggmorning.domain.hotel.entity.Hotel;
import com.backend.eggmorning.domain.hotel.mapper.HotelMapper;
import com.backend.eggmorning.domain.hotel.service.HotelService;
import com.backend.eggmorning.global.security.annotation.Public;

@Controller()
@RequestMapping("hotel")
public class HotelController {
	private HotelService hotelService;

	public HotelController(HotelService hotelService) {
		this.hotelService = hotelService;
	}

	@Public
	@ResponseBody
	@GetMapping("ranking/top")
	public List<HotelDTO> getTopRatingHotel(@RequestParam("size") int size) {
		List<Hotel> hotels = hotelService.getTopHotels(size);
		return hotels.stream().map(hotel -> HotelMapper.convertToHotelDTO(hotel)).collect(Collectors.toList());
	}
}







