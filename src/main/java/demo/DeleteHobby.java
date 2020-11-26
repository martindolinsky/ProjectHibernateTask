package demo;

import entity.Hobby;
import entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Martin Dolinsky
 */
public class DeleteHobby {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Person.class)
				.addAnnotatedClass(Hobby.class)
				.buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try{
			session.beginTransaction();

			int id = 10;
			Hobby hobby = session.get(Hobby.class, id);

			session.delete(hobby);

			session.getTransaction().commit();
			System.out.println("Done!");
		}finally {
			session.close();
			sessionFactory.close();
		}
	}
}
