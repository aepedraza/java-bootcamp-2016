package com.globant.bootcamp.topic2.excercise2.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;

public class BlogEntry {
	private String title;
	private String body;
	private final LocalDateTime createdAt;
	private User user;

	public BlogEntry(final String title, final String body, final User user) {
		this.title = title;
		this.body = body;
		this.user = user;
		this.createdAt = LocalDateTime.now();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(final String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(final String body) {
		this.body = body;
	}

	public User getUser() {
		return user;
	}

	public void setUser(final User user) {
		this.user = user;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public String getFormattedCreatedAt() {
		final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss.SSS", Locale.getDefault());
		return createdAt.format(formatter);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((body == null) ? 0 : body.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		final BlogEntry other = (BlogEntry) obj;
		return Objects.equals(body, other.getBody()) || Objects.equals(title, other.getTitle());
	}

	@Override
	public String toString() {
		return "BlogEntry [title=" + title + ", body=" + body + ", user=" + user.getName() + ", createdAt=" + getFormattedCreatedAt() + "]";
	}
}
