package com.backend.sommos.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class User {

	@Id
	@Column(name = "seq")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int seq;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "enabled")
	private boolean enabled;

}
