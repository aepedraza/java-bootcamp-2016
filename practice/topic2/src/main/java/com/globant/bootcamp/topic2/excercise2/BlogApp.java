package com.globant.bootcamp.topic2.excercise2;

import java.util.LinkedList;

import com.globant.bootcamp.topic2.excercise2.entity.BlogEntry;
import com.globant.bootcamp.topic2.excercise2.entity.User;

public class BlogApp {
	private final LinkedList<BlogEntry> entryList;
	private final LinkedList<BlogEntry> recentList;
	final static int RECENT_MAX_SIZE = 10;
	final static String ADMIN_USERNAME = "administrator";
	final static String ADMIN_PASSWORD = "adminpass";

	public BlogApp() {
		entryList = new LinkedList<>();
		recentList = new LinkedList<>();
	}

	public BlogApp(final LinkedList<BlogEntry> entryList, final LinkedList<BlogEntry> recentList) {
		this.entryList = entryList;
		this.recentList = recentList;
	}

	public void postEntry(final BlogEntry entry) {
		entryList.addFirst(entry);
		recentList.addFirst(entry);
		if (recentList.size() > RECENT_MAX_SIZE)
			recentList.removeLast();
	}

	public LinkedList<BlogEntry> getEntryList() {
		return entryList;
	}

	public LinkedList<BlogEntry> getRecentList() {
		return recentList;
	}

	public void deletePost(final User loggedUser, final BlogEntry entry) throws IllegalAccessException {
		if (isAdmin(loggedUser)) {
			final int entryListIndex = entryList.indexOf(entry);
			entryList.remove(entryListIndex);
			if (recentList.contains(entry)) {
				final int recentListIndex = recentList.indexOf(entry);
				recentList.remove(recentListIndex);
			}
		} else
			throw new IllegalAccessException("Only Administrator can delete posts!");
	}

	private boolean isAdmin(final User loggedUser) {
		return loggedUser.getName().equals(ADMIN_USERNAME) && loggedUser.getPassword().equals(ADMIN_PASSWORD);
	}
}
