/*
 * Created on Sep 8, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package hibernate;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Currency;

import javax.naming.Name;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.engine.SessionImplementor;
import org.hibernate.type.Type;
import org.hibernate.usertype.CompositeUserType;

/**
 * @author gaod
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class AccountCompositeType implements CompositeUserType {

	/* (non-Javadoc)
	 * @see org.hibernate.usertype.CompositeUserType#getPropertyNames()
	 */
	public String[] getPropertyNames() {

		return new String[] { "type", "currency" };
	}

	/* (non-Javadoc)
	 * @see org.hibernate.usertype.CompositeUserType#getPropertyTypes()
	 */
	public Type[] getPropertyTypes() {

		return new Type[] { Hibernate.STRING, Hibernate.STRING };
	}

	/* (non-Javadoc)
	 * @see org.hibernate.usertype.CompositeUserType#getPropertyValue(java.lang.Object, int)
	 */
	public Object getPropertyValue(Object component, int property)
		throws HibernateException {

		AccountType accountType = (AccountType)component;
		return property == 0 ? Character.toString ( accountType.getType() ) : accountType.getCurrency().toString();
	}

	/* (non-Javadoc)
	 * @see org.hibernate.usertype.CompositeUserType#setPropertyValue(java.lang.Object, int, java.lang.Object)
	 */
	public void setPropertyValue(Object component, int property, Object value)
		throws HibernateException {

		AccountType accountType = (AccountType)component;
		switch ( property )
		{
			case 0 :
				accountType.setType ( ((String)value).toCharArray()[0] );
				break;
			case 1 :
				accountType.setCurrency ( Currency.getInstance ( ((String)value).trim() ) );
				break;
		}
	}

	/* (non-Javadoc)
	 * @see org.hibernate.usertype.CompositeUserType#returnedClass()
	 */
	public Class returnedClass() {

		return AccountType.class;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.usertype.CompositeUserType#equals(java.lang.Object, java.lang.Object)
	 */
	public boolean equals(Object x, Object y) throws HibernateException {

		if ( x == y ) return true;
		if ( x == null || y == null ) return false;
		return ( x.equals ( y ) );
	}

	/* (non-Javadoc)
	 * @see org.hibernate.usertype.CompositeUserType#hashCode(java.lang.Object)
	 */
	public int hashCode(Object arg0) throws HibernateException {

		return arg0.hashCode();
	}

	/* (non-Javadoc)
	 * @see org.hibernate.usertype.CompositeUserType#nullSafeGet(java.sql.ResultSet, java.lang.String[], org.hibernate.engine.SessionImplementor, java.lang.Object)
	 */
	public Object nullSafeGet(
		ResultSet resultSet,
		String[] names,
		SessionImplementor session,
		Object owner)
		throws HibernateException, SQLException {

//		System.out.println ( "owner = " + owner );
		
		if ( resultSet.wasNull() ) return null;
		return new AccountType ( resultSet.getString ( names[0] ).toCharArray()[0],
								  Currency.getInstance ( resultSet.getString ( names[1] ).trim() ) );
	}

	/* (non-Javadoc)
	 * @see org.hibernate.usertype.CompositeUserType#nullSafeSet(java.sql.PreparedStatement, java.lang.Object, int, org.hibernate.engine.SessionImplementor)
	 */
	public void nullSafeSet(
		PreparedStatement statement,
		Object value,
		int index,
		SessionImplementor session)
		throws HibernateException, SQLException {

		if ( value == null )
		{
			statement.setNull ( index, Types.CHAR );
			statement.setNull ( index + 1, Types.CHAR );
		}
		else
		{
			AccountType accountType = (AccountType)value;
			statement.setString ( index, Character.toString ( accountType.getType() ) );
			statement.setString ( index + 1, accountType.getCurrency().toString() );
		}
	}

	/* (non-Javadoc)
	 * @see org.hibernate.usertype.CompositeUserType#deepCopy(java.lang.Object)
	 */
	public Object deepCopy(Object arg0) throws HibernateException {

		//System.out.println ( "deepCopy: arg0 = " + arg0 );
		return arg0;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.usertype.CompositeUserType#isMutable()
	 */
	public boolean isMutable() {

		return false;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.usertype.CompositeUserType#disassemble(java.lang.Object, org.hibernate.engine.SessionImplementor)
	 */
	public Serializable disassemble(Object arg0, SessionImplementor arg1)
		throws HibernateException {

		return (Serializable)arg0;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.usertype.CompositeUserType#assemble(java.io.Serializable, org.hibernate.engine.SessionImplementor, java.lang.Object)
	 */
	public Object assemble(
		Serializable arg0,
		SessionImplementor arg1,
		Object arg2)
		throws HibernateException {

		return arg0;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.usertype.CompositeUserType#replace(java.lang.Object, java.lang.Object, org.hibernate.engine.SessionImplementor, java.lang.Object)
	 */
	public Object replace(
		Object arg0,
		Object arg1,
		SessionImplementor arg2,
		Object arg3)
		throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

}
