package ioc.basic3;

public class VicCollegeStudentDao implements StudentDao {
	
	private DBUtil dbUtil;
//= new DBUtilVicCourseImpl();
//	
//	{
//		System.out.println( "Reading database connection information from a local properties file . . ." );
//		((DBUtilVicCourseImpl)dbUtil).setDbURL( "http://localhost:3609/vic-course-db" );
//		((DBUtilVicCourseImpl)dbUtil).setDbUsername ( "root" );
//		((DBUtilVicCourseImpl)dbUtil).setDbPassword ( "password123" );
//	}
	

	@Override
	public void saveStudent(String student) {
		// connect to database
		this.dbUtil.connectToDB();
		// compose SQL statement
		String sql = "INSERT INTO STUDENT VALUES ( " + student + ");";
		// execute SQL
		// save student record to database
		this.dbUtil.insertRecord(sql);
		// commit transaction
		// disconnect from database
	}

	@Override
	public void saveEnrollment(String student, String course) {
		// connect to database
		this.dbUtil.connectToDB();
		// compose SQL statement
		String sql = "INSERT INTO ENROLLMENT VALUES ( " + student + ", " + course + ");";
		// execute SQL
		// save enrollment record along with student info.
		this.dbUtil.insertRecord(sql);
		// commit transaction
		// disconnect from database
	}

	public DBUtil getDbUtil() {
		return dbUtil;
	}

	public void setDbUtil(DBUtil dbUtil) {
		this.dbUtil = dbUtil;
	}
	
	

}
