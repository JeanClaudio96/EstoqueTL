package com.EstoqueTL.Data.Models;

import org.springframework.security.core.GrantedAuthority;

public enum UserRole implements GrantedAuthority{
    ESTOQUISTA("estoquista"),
    USER("user"),
    ADMIN("admin");

	private String role;

	UserRole(String role){
		this.role = role;
	}

	UserRole() {

	}

	public String getRole() {
		return role;
	}

	@Override
	public String getAuthority() {
		return name();
	}
}