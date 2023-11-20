package dao;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import model.Payroll;
import model.PayrollStaff;
import util.HibernateUtil;

@Repository
public class DAOPayroll implements DAOCRUDInterface<Payroll> {
	
	private static final SessionFactory sf  = HibernateUtil.getSessionFactory();
	
	@Override
	public Payroll get(long id) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		Payroll pr = ss.get(Payroll.class, id);
		tr.commit();
		ss.close();
		return pr;
	}

	@Override
	public String put(Payroll t, long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void post(Payroll t) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		ss.save(t);
		tr.commit();
		ss.close();
	}
	
	public PayrollStaff getPRS(long idStaff, long idPayroll) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		String sql = "from PayrollStaff as prs where prs.id in (select prs.id from Payroll as pr inner join PayrollStaff as prs on pr.id = :idPayroll) and prs.staff.idStaff = :idStaff";
		PayrollStaff prs = ss.createQuery(sql, PayrollStaff.class).setParameter("idStaff", idStaff).setParameter("idPayroll", idPayroll).uniqueResult();
		
		tr.commit();
		ss.close();
		return prs;
	}
	
	public long postAndGetIDPayroll(Payroll pr) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
	
		ss.saveOrUpdate(pr);
		long idPayroll = pr.getId();
			
		tr.commit();
		ss.close();
		return idPayroll;
	}
	
	public long queryPayrollAndGetIdPayroll(int month, int year) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		String sql = "from Payroll as pr where MONTH(dateCreatePayroll) = :month and YEAR(dateCreatePayroll) = :year";
		Payroll pr = ss.createQuery(sql, Payroll.class).setParameter("month", month)
															.setParameter("year", year)
															.uniqueResult();
		long idPayroll = 0;
		if(pr != null) {
			idPayroll = pr.getId();
		}
		
		tr.commit();
		ss.close();
		return idPayroll;
	}
	
	public boolean checkPayrollExist(int month, int year) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		String sql = "from Payroll as pr where MONTH(dateCreatePayroll) = :month and YEAR(dateCreatePayroll) = :year";
		Payroll pr = ss.createQuery(sql, Payroll.class).setParameter("month", month)
															.setParameter("year", year)
															.uniqueResult();
		tr.commit();
		ss.close();
		if(pr != null) {
			return true;
		}else {
			return false;
		}
				
	}

}
