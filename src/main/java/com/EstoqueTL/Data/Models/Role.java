package com.EstoqueTL.Data.Models;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority{
    ESTOQUE,
    USER,
    ADMIN;

	@Override
	public String getAuthority() {
		return name();
	}
}