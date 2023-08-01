package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sf = buildSessionFactory();
	
	private static SessionFactory buildSessionFactory() {
		try {
			return new Configuration().configure().buildSessionFactory();
		}catch(Exception e) {
			System.out.println("Khong the tao session");
			return null;
		}
	}
	
	
	public static SessionFactory getSessionFactory() {
		return sf;
	}
	
	public static void closeSessionFactory() {
		sf.close();
	}
	
}
