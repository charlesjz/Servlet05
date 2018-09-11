package ioc.basic3;

import org.springframework.beans.factory.BeanNameAware;

public class VicCollegeStudentService implements StudentService, BeanNameAware {
	
	private StudentDao studentDao;
	private boolean daoAvailable;
	
	VicCollegeStudentService ( ) {
		this.studentDao = new VicCollegeStudentDao ( );
	}
	
	public void checkDaoInjectionStatus ( ) {
		this.daoAvailable = this.studentDao != null;
		System.out.println( "this.daoAvailable = " + this.daoAvailable );
	}

	@Override
	public void register(String student) {
		this.studentDao.saveStudent ( student );
		System.out.println( student + " has been registered in Vic College." );
	}

	@Override
	public void enroll(String student, String courseName) {
		this.studentDao.saveEnrollment(student, courseName);
		System.out.println( student + " has been enrolled the course of " + courseName + " in Vic College." );
	}

	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	public void setBeanName(String myName) {
		System.out.println( this.getClass().getName() + "'s ID is: " + myName );
		
	}

	public boolean isDaoAvailable() {
		return daoAvailable;
	}

	public void setDaoAvailable(boolean daoAvailable) {
		this.daoAvailable = daoAvailable;
	}

}
