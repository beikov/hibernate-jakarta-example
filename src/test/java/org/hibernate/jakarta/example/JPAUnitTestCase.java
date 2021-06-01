package org.hibernate.jakarta.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUnitTestCase {

	private EntityManagerFactory entityManagerFactory;

	@Before
	public void init() {
		entityManagerFactory = Persistence.createEntityManagerFactory( "templatePU" );
	}

	@After
	public void destroy() {
		entityManagerFactory.close();
	}

	@Test
	public void testJakarta() throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();

		Person person = new Person();
		person.setFirstName( "John" );
		person.setLastName( "Smith" );
		entityManager.persist( person );

		Person p = entityManager.createQuery( "select p from Person p", Person.class )
				.getSingleResult();
		Assert.assertNotNull( p );

		entityManager.getTransaction().commit();
		entityManager.close();
	}


}
