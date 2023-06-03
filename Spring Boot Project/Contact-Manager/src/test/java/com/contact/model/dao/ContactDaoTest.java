package com.contact.model.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.contact.model.Contact;


class ContactDaoTest {

	private DriverManagerDataSource dataSource;
	private ContactDao dao;

	@Test
	void testSave() {
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/crud_app");
		dataSource.setUsername("root");
		dataSource.setPassword("password");
		dao = new ContactDaoImpl(dataSource);

		Contact c = new Contact("Pabitra", "Pabitra@gmail.com", "india", "3452342");
		int i = dao.save(c);

		assertTrue(i > 0);

	}

	@Test
	void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	void testGet() {
		fail("Not yet implemented");
	}

	@Test
	void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	void testList() {
		fail("Not yet implemented");
	}

}
