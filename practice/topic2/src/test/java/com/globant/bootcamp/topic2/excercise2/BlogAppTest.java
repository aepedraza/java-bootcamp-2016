package com.globant.bootcamp.topic2.excercise2;

import static com.globant.bootcamp.topic2.excercise2.BlogApp.*;
import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.globant.bootcamp.topic2.excercise2.entity.BlogEntry;
import com.globant.bootcamp.topic2.excercise2.entity.User;

/* Requirements:
 * 	+ Any user can post a blog entry.
 * 	+ The app must keep a list of 10 most recent posts.
 * 	+ When a blog entry is posted, it's added automatically to the most recent list.
 * 	+ Post must be ordered in descending chronological order.
 *  + When the "most recent list" is full, the older post is discarded from that list.
 * 	+ Posts can be deleted only by administrator.
 * 	+ Deleted post are removed from most recent list also if present
 * 	+ When the user attempting to delete a post is not administrator, the app must throw an Exception.
 */
public class BlogAppTest {

	private BlogApp blogApp;
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

	@Before
	public void setUp() throws Exception {
		blogApp = new BlogApp();
	}

	@After
	public void tearDown() throws Exception {
		blogApp = null;
	}

	@Test
	public void postBlogEntryBySomeUser() {
		final User user = new User("username", "password");
		final BlogEntry entry = new BlogEntry("Entry Tittle", "The body of the entry. Blah blah blah", user);

		blogApp.postEntry(entry);

		assertFalse(blogApp.getEntryList().isEmpty());
		assertEquals(1, blogApp.getEntryList().size());
	}

	@Test
	public void addNewPostToMostRecentList() {
		final User user = new User("username", "password");
		final BlogEntry entry = new BlogEntry("Entry Tittle", "The body of the entry. Blah blah blah", user);

		blogApp.postEntry(entry);

		assertFalse(blogApp.getRecentList().isEmpty());
		assertEquals(1, blogApp.getRecentList().size());
	}

	@Test
	public void truncateRecentListOn10Items() {
		final User user = new User("username", "password");
		addUserEntries(user, RECENT_MAX_SIZE + 1);

		assertEquals(RECENT_MAX_SIZE, blogApp.getRecentList().size());
	}

	@Test
	public void orderPostInDescendingChronologicalOrder() {
		final User user = new User("username", "password");
		addUserEntries(user, RECENT_MAX_SIZE + 1);

		final Iterator<BlogEntry> it = blogApp.getEntryList().iterator();
		BlogEntry current = it.next();
		BlogEntry next = it.next();
		while (it.hasNext()) {
			logger.info("Comparing current {} with next {}", current.getCreatedAt(), next.getCreatedAt());
			assertTrue(current.getCreatedAt().isAfter(next.getCreatedAt()));
			current = next;
			next = it.next();
		}
	}

	@Test
	public void discardOlderPostWhenRecentListIsFull() {
		final User user = new User("username", "password");
		addUserEntries(user, RECENT_MAX_SIZE + 1);

		final BlogEntry lastEntry = blogApp.getEntryList().getLast();
		assertFalse(blogApp.getRecentList().contains(lastEntry));
	}

	@Test
	public void PostOnlyDeletedByAdministrator() {
		final User user = new User("username", "password");
		final User admin = new User(ADMIN_USERNAME, ADMIN_PASSWORD);

		addUserEntries(user, 2);
		try {
			blogApp.deletePost(admin, blogApp.getEntryList().getFirst());
		} catch (final IllegalAccessException e) {
			e.printStackTrace();
		}

		assertEquals(1, blogApp.getEntryList().size());
	}

	@Test
	public void deletedPostRemovedFromRecentListCaseIsPresent() {
		final User user = new User("username", "password");
		final User admin = new User(ADMIN_USERNAME, ADMIN_PASSWORD);

		addUserEntries(user, 2);
		try {
			blogApp.deletePost(admin, blogApp.getEntryList().getFirst());
		} catch (final IllegalAccessException e) {
			e.printStackTrace();
		}

		assertEquals(1, blogApp.getRecentList().size());
	}

	@Test
	public void deletedPostRemovedFromRecentListCaseNotPresent() {
		final User user = new User("username", "password");
		final User admin = new User(ADMIN_USERNAME, ADMIN_PASSWORD);

		addUserEntries(user, RECENT_MAX_SIZE + 1);
		try {
			blogApp.deletePost(admin, blogApp.getEntryList().getLast());
		} catch (final IllegalAccessException e) {
			e.printStackTrace();
		}

		assertEquals(RECENT_MAX_SIZE, blogApp.getRecentList().size());
	}

	@Test(expected = IllegalAccessException.class)
	public void notAdminUserAttemptToDeletePost() throws IllegalAccessException {
		final User user = new User("username", "password");

		addUserEntries(user, 3);
		blogApp.deletePost(user, blogApp.getEntryList().getFirst());
	}

	private void addUserEntries(final User user, final int amount) {
		BlogEntry entry;
		for (int i = 1; i <= amount; i++) {
			entry = new BlogEntry("Tittle " + i, "Body " + i, user);
			blogApp.postEntry(entry);
			logger.info("Added {}", entry);
			try {
				Thread.sleep(20);
			} catch (final InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
