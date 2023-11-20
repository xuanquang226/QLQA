package dao;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import model.Role;
import util.HibernateUtil;

@Repository
public class DAORole implements DAOCRUDInterface<Role>{
	private static final SessionFactory sf = HibernateUtil.getSessionFactory();
	@Override
	public Role get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String put(Role t, long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void post(Role t) {
		// TODO Auto-generated method stub
		
	}
	
	public Role getRole(String name) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		String sql = "from Role as r where r.name = :name";
		Role role = ss.createQuery(sql, Role.class).setParameter("name", name).getSingleResult();
		
		tr.commit();
		ss.close();
		return role;
	}

}
