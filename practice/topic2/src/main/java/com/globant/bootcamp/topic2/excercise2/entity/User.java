package com.globant.bootcamp.topic2.excercise2.entity;

import java.util.Objects;

public class User {

	private String name;
	private String password;

	public User(final String name, final String password) {
		this.name = name;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final User other = (User) obj;
		return Objects.equals(name, other.getName()) && Objects.equals(password, other.getPassword());
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + "]";
	}
}
