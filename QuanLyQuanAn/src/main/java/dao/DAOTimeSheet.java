package dao;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import model.TimeSheets;
import util.HibernateUtil;

@Repository
public class DAOTimeSheet implements DAOCRUDInterface<TimeSheets> {
	private static final SessionFactory sf = HibernateUtil.getSessionFactory();
	

	@Override
	public TimeSheets get(long id) {
		// TODO Auto-generated method stub
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		TimeSheets timeSheet = ss.get(TimeSheets.class, id);
		
		tr.commit();
		ss.close();
		return timeSheet;
	}

	@Override
	public String put(TimeSheets t, long id) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		
		
		return null;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void post(TimeSheets t) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		ss.saveOrUpdate(t);
		
		tr.commit();
		ss.close();
	}

	
	public long postAndGetID(TimeSheets t) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		ss.save(t);
		tr.commit();
		ss.close();
		return t.getId();
	}
	
	public TimeSheets getTimeSheetsWithDate() {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        int day = timestamp.getDate();
        int month = timestamp.getMonth() + 1;
        int year = timestamp.getYear() + 1900;
        Map<String, Integer> date = new HashMap<>();
        
        date.put("day", day);
        date.put("month", month);
        date.put("year", year);
        
		String sql = "from TimeSheets as ts where DAY(ts.dateTimeKeeping) = :day and MONTH(ts.dateTimeKeeping) = :month and YEAR(ts.dateTimeKeeping) = :year";
		
		TimeSheets timesheets = ss.createQuery(sql, TimeSheets.class).setParameter("day", date.get("day"))
																	.setParameter("month", date.get("month"))
																	.setParameter("year", date.get("year"))
																	.setMaxResults(1)
																	.uniqueResult();
		tr.commit();
		ss.close();
		
		return timesheets;
	}
}
