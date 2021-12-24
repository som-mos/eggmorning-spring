package com.backend.eggmorning.domain.hotel.entity;

import java.sql.Timestamp;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name="HOTEL")
@AllArgsConstructor	// 필요한지 확인해보기 , 모든 필드 값을 파라미터로 받는 생성자를 만듦
@NoArgsConstructor	// 파라미터가 없는 생성자를 생성합니다.
public class Hotel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hotelNo;
	private String name;
	private String address;
	private String phone;
	private String level;
	private double rating;
	private String thumbnail;
	private Timestamp regdate;
	private Timestamp moddate;
}
