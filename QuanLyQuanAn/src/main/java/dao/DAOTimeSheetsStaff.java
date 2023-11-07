package dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import model.TimeSheetsStaff;
import util.HibernateUtil;

@Component
public class DAOTimeSheetsStaff implements DAOCRUDInterface<TimeSheetsStaff> {
	private static final SessionFactory sf = HibernateUtil.getSessionFactory();
	
	@Override
	public TimeSheetsStaff get(long id) {
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
		
	}

	public List<TimeSheetsStaff> getList(){
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();


		String sql = "from TimeSheetsStaff";
		List<TimeSheetsStaff> lSheetsStaffs = ss.createQuery(sql, TimeSheetsStaff.class).list();
		System.out.println(lSheetsStaffs.size());
		
		tr.commit();
		ss.close();
		
		return lSheetsStaffs;
	}
	
//	public Map<String, Integer> countTimeSheets(List<Long> listIdStaff){
//		Session ss = sf.openSession();
//		Transaction tr = ss.beginTransaction();
//		
//		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//		int month = timestamp.getMonth() + 1;
//		int year = timestamp.getYear() + 1900;
//		
//		List<TimeSheetsStaff> lSheetsStaffs = new ArrayList<TimeSheetsStaff>();
//		Map<String, Integer> lCount = new HashMap<>();
//		String sql = "from TimeSheetsStaff as tss where MONTH(timestamp) = :month and YEAR(timestamp) = :year and tss.stafff.idStaff = :idStaff";
//		for(int i = 0; i < listIdStaff.size(); i++) {
//				lSheetsStaffs = ss.createQuery(sql, TimeSheetsStaff.class).setParameter("month", month)
//													.setParameter("year", year)
//													.setParameter("idStaff", listIdStaff.get(i))
//													.list();
//				lCount.put("Nhân viên " + listIdStaff.get(i), lSheetsStaffs.size());
//		}
//		
//		
//			
//		tr.commit();
//		ss.close();
//		
//		return lCount;
//	}
	
	public String postTimeSheetsStaff(TimeSheetsStaff t, long idStaff) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		int hour = timestamp.getHours();
		String message = "";
		t.setTimestamp(timestamp);
	
		
		if(hour > 8 && hour < 18) {
			ss.save(t);
			String sql = "update TimeSheetsStaff as tss set tss.stafff.idStaff = :idStaff where tss.id = :id";
			int result = ss.createQuery(sql).setParameter("idStaff", idStaff)
											.setParameter("id", t.getId()).executeUpdate();
			tr.commit();
			message = "Chấm công thành công";
		}else {
			message = "Không trong thời gian chấm công";
		}
		
		
		ss.close();
		return message;
	}
	
	public boolean checkTimeKeeping(long idStaff) {
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
		
		
		String sql = "from TimeSheetsStaff as tss where DAY(tss.timestamp) = :day and MONTH(tss.timestamp) = :month and "
				+ "YEAR(tss.timestamp) = :year and tss.stafff.idStaff = :idStaff";
		TimeSheetsStaff tss = ss.createQuery(sql, TimeSheetsStaff.class).setParameter("day", date.get("day"))
																		.setParameter("month", date.get("month"))
																		.setParameter("year", date.get("year"))
																		.setParameter("idStaff", idStaff)
																		.setMaxResults(1)
																		.uniqueResult();
	
		tr.commit();
		boolean isExist = false;
		
		if(tss == null) {
			isExist = false;
		}else {
			isExist = true;
		}
		ss.close();
		return isExist;
	}
}
