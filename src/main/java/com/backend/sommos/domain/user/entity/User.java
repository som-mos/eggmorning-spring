package com.backend.sommos.domain.user.entity;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Data
@Entity
@AllArgsConstructor	// 필요한지 확인해보기 , 모든 필드 값을 파라미터로 받는 생성자를 만듦
@NoArgsConstructor	// 파라미터가 없는 생성자를 생성합니다.
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_no;
	private String name;
	private String email;
	private String password;
	private boolean enabled;
	private String nickname;
	private String phone;
	private String address;
	private Date signup;

	public User(String name, String password){
		this.name = name;
		this.password = password;
	}

}
