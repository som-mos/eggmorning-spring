package com.backend.eggmorning.domain.user.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userNo;
	private String name;
	private String email;
	@JsonIgnore private String salt;
	@JsonIgnore private String password;
	private boolean enabled;
	private String nickname;
	private String phone;
	private String address;
	private Date regDate;
	private Date modDate;

	@ManyToMany()
	@JoinTable(
			name="USER_ROLE",
			joinColumns = {@JoinColumn(name="user_no")},
			inverseJoinColumns = {@JoinColumn(name="role_no")}
	)
	private List<Role> roles;

	public User(String name, String password){
		this.name = name;
		this.password = password;
	}

}
