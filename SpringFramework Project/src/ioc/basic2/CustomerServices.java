/*
 * Created on Aug 29, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package ioc.basic2;

import java.util.Set;

/**
 * @author gaod
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public interface CustomerServices {
	
	public void increaseCreditLimit ( Customer customer ) throws CustomerNotAvailableException;
	
	public void increaseCreditLimit ( ) throws CustomerNotAvailableException;

	public int getCreditIncreaseLimit();

}
