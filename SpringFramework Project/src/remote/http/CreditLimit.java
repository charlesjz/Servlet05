/*
 * Created on Sep 4, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package remote.http;

/**
 * @author gaod
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public interface CreditLimit {
	
	public final static int CREDIT_LIMIT_NOT_ALLOWED = -1;
	
	public int getCreditLimit ( );
	public void setCreditLimit ( int limit );

}
