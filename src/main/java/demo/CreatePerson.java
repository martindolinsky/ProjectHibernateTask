package demo;

import entity.Hobby;
import entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Martin Dolinsky
 */
public class CreatePerson {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Person.class)
				.addAnnotatedClass(Hobby.class)
				.buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {
			Person person = new Person("Martin", "9911110123");

			session.beginTransaction();

			session.save(person);

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
