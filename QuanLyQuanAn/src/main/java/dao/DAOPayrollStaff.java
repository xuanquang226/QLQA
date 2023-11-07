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

import model.Payroll;
import model.PayrollStaff;
import model.Staff;
import model.TimeSheetsStaff;
import util.HibernateUtil;

@Component
public class DAOPayrollStaff implements DAOCRUDInterface<PayrollStaff> {
	
	private static final SessionFactory sf = HibernateUtil.getSessionFactory();
	
	@Override
	public PayrollStaff get(long id) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		PayrollStaff prs = ss.get(PayrollStaff.class, id);
		tr.commit();
		ss.close();
		return prs;
	}

	@Override
	public String put(PayrollStaff t, long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void post(PayrollStaff t) {
		
	}
	
	public void postPayrollStaff(long idPayroll) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		// Lấy ds nhân viên + mức lương của nhân viên trong 1 ngày(Staff)
		String sql = "from Staff";
		List<Staff> lStaff = ss.createQuery(sql, Staff.class).list();
		
		List<Long> listIdStaff = new ArrayList<Long>();
		
		for(Staff staff :lStaff) {
			listIdStaff.add(staff.getIdStaff());
		}
		
		tr.commit();
		
		
		// Số lần nhân viên chấm công trong 1 tháng(TimeSheetsStaff)
		tr = ss.beginTransaction();
//		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//		int month = timestamp.getMonth() + 1;
//		int year = timestamp.getYear() + 1900;
		
		// Lấy idPayroll -> ngày tháng cần duyệt số lần chấm công 
		Payroll payroll = ss.get(Payroll.class, idPayroll);
		int month = payroll.getDateCreatePayroll().getMonth() + 1;
		int year = payroll.getDateCreatePayroll().getYear() + 1900;
		tr.commit();
		
		
		tr = ss.beginTransaction();		
		List<TimeSheetsStaff> lSheetsStaffs = new ArrayList<TimeSheetsStaff>();
		Map<Long, Integer> lCount = new HashMap<>();
		String sql2 = "from TimeSheetsStaff as tss where MONTH(timestamp) = :month and YEAR(timestamp) = :year and tss.stafff.idStaff = :idStaff";
		for(int i = 0; i < listIdStaff.size(); i++) {
				lSheetsStaffs = ss.createQuery(sql2, TimeSheetsStaff.class).setParameter("month", month)
													.setParameter("year", year)
													.setParameter("idStaff", listIdStaff.get(i))
													.list();
				lCount.put(listIdStaff.get(i), lSheetsStaffs.size());
		}
		tr.commit();
		
		// Mức lương của idStaff thêm vào payrollstaff
		Map<Long, Double> salaryOfIdStaff = new HashMap<Long, Double>();

		for(int i = 0; i < lStaff.size(); i++) {
			int position = i;
			lCount.forEach((idStaff, count) ->{
				if(lStaff.get(position).getIdStaff() == idStaff) {
					double salary = lStaff.get(position).getoDaySalary() * count;
					salaryOfIdStaff.put(idStaff, salary);
				}			
			});
		}
		
		// Tạo payrollstaff
		salaryOfIdStaff.forEach((idStaff, salary) -> {
			Transaction tr1 = ss.beginTransaction();
			PayrollStaff payrollStaff = new PayrollStaff();
			payrollStaff.setSalary(salary);
			
			Staff staff = ss.get(Staff.class, idStaff);
			payrollStaff.setStaff(staff);
			payrollStaff.setPayroll(payroll);
			lCount.forEach((idStaff2, count) ->{
				if(idStaff == idStaff2) {
					payrollStaff.setCount(count);
				}
			});
								
			ss.save(payrollStaff);
			tr1.commit();
		});

		ss.close();
	}

	public List<PayrollStaff> getListPayrollStaff(long idPayroll){
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		String sql = "from PayrollStaff where payroll.id = :idPayroll";
		List<PayrollStaff> payrollStaffList = ss.createQuery(sql, PayrollStaff.class).setParameter("idPayroll", idPayroll).getResultList();
		
		tr.commit();
		ss.close();
		
		return payrollStaffList;
	}
	
}
