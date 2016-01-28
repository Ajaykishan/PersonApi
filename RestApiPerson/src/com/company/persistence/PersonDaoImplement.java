package com.company.persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.derby.iapi.sql.PreparedStatement;

import com.company.entity.Person;

public class PersonDaoImplement {

	private EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("PersistenceUnit");

	public Person retrieve(int id) {
		EntityManager em = emf.createEntityManager();

		Person person = null;

		try {
			person = em.find(Person.class, id);
		} finally {
			em.close();
		}

		return person;
	}

	public void save(Person person) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();

		try {
			transaction.begin();
			em.merge(person);
			transaction.commit();
		} catch (Exception e) {
			System.out.println("Error Saving person: " + e.getMessage());
			transaction.rollback();
		} finally {
			em.close();
		}

	}

	public List<Person> retrieveAll() {
		List<Person> personList = new ArrayList<Person>();
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT p FROM Person p");
		personList = query.getResultList();
		for (Person person : personList) {
			System.out.println("" + person.toString());

		}
		System.out.println("Size: " + personList.size());
		em.close();
		return personList;
	}

	public Person retrieveById(int id) {
		EntityManager em = emf.createEntityManager();
		Person personObj = em.find(Person.class, id);
		em.close();
		return personObj;
	}

	public Person deleteById(int id) {

		EntityManager em = emf.createEntityManager();
		Person personObj = em.find(Person.class, id);
		if (personObj != null) {
			em.getTransaction().begin();
			em.remove(personObj);
			em.getTransaction().commit();
			em.close();
		}
		return personObj;

	}

	public Person updateById(int id, Person personObject) {

		EntityManager em = emf.createEntityManager();
		Person personObj = em.find(Person.class, id);
		if (personObj != null) {
			em.getTransaction().begin();
			em.merge(personObject);
			em.getTransaction().commit();
		} else {
			personObject = null;
		}
		em.close();
		return personObject;

	}

}
