package com.backend.sommos.domain.hotel.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor	// 필요한지 확인해보기 , 모든 필드 값을 파라미터로 받는 생성자를 만듦
@NoArgsConstructor	// 파라미터가 없는 생성자를 생성합니다.
public class Hotel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int seq;

}
