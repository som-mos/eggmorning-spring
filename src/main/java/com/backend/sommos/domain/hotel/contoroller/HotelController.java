package com.backend.sommos.domain.hotel.contoroller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.backend.sommos.domain.hotel.dto.HotelDTO;
import com.backend.sommos.domain.hotel.entity.Hotel;
import com.backend.sommos.domain.hotel.mapper.HotelMapper;
import com.backend.sommos.domain.hotel.service.HotelService;

@Controller()
@RequestMapping("hotel")
public class HotelController {

    private HotelService hotelService;

    @Autowired
    public HotelController(@Qualifier("hotelService") HotelService hotelService) {
        this.hotelService = hotelService;
    }

//    @ResponseBody
//    @GetMapping("ranking/top")
//    public List<HotelDTO> getTopRatingHotel(){
//        return hotelService.getTop3RatingHotel().stream().map(hotel-> HotelMapper.convertToHotelDTO(hotel)).collect(Collectors.toList());
//    }

    @ResponseBody
    @GetMapping("ranking/top/{number}")
    public List<HotelDTO> getTopRatingHotel(@PathVariable("number") int number){

        if(number == 1){

        }
        return hotelService.getTop3RatingHotel().stream().map(hotel-> HotelMapper.convertToHotelDTO(hotel)).collect(Collectors.toList());
    }
}







