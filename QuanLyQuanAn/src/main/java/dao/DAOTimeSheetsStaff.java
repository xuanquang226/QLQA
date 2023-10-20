package dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import model.TimeSheetsStaff;
import util.HibernateUtil;

@Component
public class DAOTimeSheetsStaff implements DAOCRUDInterface<TimeSheetsStaff> {

	@Override
	public TimeSheetsStaff get(long id) {
		// TODO Auto-generated method stub
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		TimeSheetsStaff timeSheetsStaff = ss.get(TimeSheetsStaff.class, id);
		tr.commit();
		ss.close();
		return timeSheetsStaff;
	}

	@Override
	public String put(TimeSheetsStaff t, long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void post(TimeSheetsStaff t) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		ss.save(t);
		String sql = "update TimeSheetsStaff as tss set tss.stafff.idStaff = :idStaff where tss.id = :id";
		int result = ss.createQuery(sql).setParameter("idStaff", t.getStaff().getIdStaff())
										.setParameter("id", t.getId()).executeUpdate();
		tr.commit();
		ss.close();
	}

	public List<TimeSheetsStaff> getList(){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();


		String sql = "from TimeSheetsStaff";
		List<TimeSheetsStaff> lSheetsStaffs = ss.createQuery(sql, TimeSheetsStaff.class).list();
		System.out.println(lSheetsStaffs.size());
		
		tr.commit();
		ss.close();
		
		return lSheetsStaffs;
	}
	
	public List<Integer> countTimeSheets(List<Long> listIdStaff){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		int month = timestamp.getMonth() + 1;
		int year = timestamp.getYear() + 1900;
		
		List<TimeSheetsStaff> lSheetsStaffs = new ArrayList<TimeSheetsStaff>();
		List<Integer> lCount = new ArrayList<Integer>();
		String sql = "from TimeSheetsStaff as tss where MONTH(timestamp) = :month and YEAR(timestamp) = :year and tss.stafff.idStaff = :idStaff";
		for(int i = 0; i < listIdStaff.size(); i++) {
				lSheetsStaffs = ss.createQuery(sql, TimeSheetsStaff.class).setParameter("month", month)
													.setParameter("year", year)
													.setParameter("idStaff", listIdStaff.get(i))
													.list();
				lCount.add(lSheetsStaffs.size());
		}
		
		
			
		tr.commit();
		ss.close();
		
		return lCount;
	}
	
	public void postTimeSheetsStaff(long idStaff, long idTimeSheets) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		String sql = "insert into TimeSheetsStaff as tss values(0, tss.id)";
		
	}
}
