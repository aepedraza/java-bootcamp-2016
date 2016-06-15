package com.globant.bootcamp.topic1;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MavenClassUTest {
	private MavenClass mavenClass;

	@Before
	public void setUp() throws Exception {
		mavenClass = new MavenClass();
	}

	@After
	public void tearDown() throws Exception {
		mavenClass = null;
	}

	@Test
	public void doSomethingTest() {
		mavenClass.doSomething();
		
		assertThat(mavenClass, is(notNullValue()));
	}

}
