package com.backend.eggmorning.domain.hotel.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class HotelDTO {
	private int hotelNo;
	private String name;
	private String address;
	private String phone;
	private String level;
	private double rating;
	private String thumbnail;
	private Timestamp regdate;
}
