package demo;

import entity.Hobby;
import entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Martin Dolinsky
 */
public class GetPersonHobbies {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Person.class)
				.addAnnotatedClass(Hobby.class)
				.buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {
			session.beginTransaction();

			int id = 1;
			Person person = session.get(Person.class, id);

			System.out.println(person.getHobbyList());

			session.getTransaction().commit();

			System.out.println("Done!");

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.close();
			sessionFactory.close();
		}
	}
}
