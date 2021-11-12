package com.backend.sommos.domain.hotel.dto;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
