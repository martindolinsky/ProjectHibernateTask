package demo;

import entity.Hobby;
import entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Martin Dolinsky
 */
public class CreateHobby {
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

			Hobby hobby1 = new Hobby("football","outdoor");
			Hobby hobby2 = new Hobby("gaming","indoor");

			person.add(hobby1);
			person.add(hobby2);

			session.save(hobby1);
			session.save(hobby2);

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
