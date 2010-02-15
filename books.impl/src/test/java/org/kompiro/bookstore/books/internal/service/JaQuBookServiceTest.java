package org.kompiro.bookstore.books.internal.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class JaQuBookServiceTest {
	
	private JaQuBookService service;


	@Before
	public void before() throws Exception {
		service = new JaQuBookService();
		JaQuBookService.setDb("jdbc:h2:mem:");
	}
	
	@Test
	public void register() throws Exception {
		service.register("test", "test", 100);
		assertThat(service.find("test").size(),is(1));
		service.register("test2", "test2", 100);
		assertThat(service.find(null).size(),is(2));
	}
	
}
