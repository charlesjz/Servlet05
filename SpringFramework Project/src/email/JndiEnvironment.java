/*
 * Created on Aug 9, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package email;

import java.util.Iterator;
import java.util.Properties;

import javax.naming.Context;

/**
 * @author gaod
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class JndiEnvironment extends Properties {

		
	public JndiEnvironment ( Properties props )
	{
		System.out.println ( "Context.INITIAL_CONTEXT_FACTORY = " + Context.INITIAL_CONTEXT_FACTORY );
		System.out.println ( "Context.PROVIDER_URL = " + Context.PROVIDER_URL );
		Iterator it = props.keySet().iterator();
		while ( it.hasNext ( ) )
		{
			Object key = it.next ( );
			System.out.print ( "Key: " + key + "(" + key.getClass() + ")" );
			System.out.println ( ", Value: " + props.get ( key ) );
		}
	}
	
	
	public JndiEnvironment ( String initialContext, String url )
	{
		put ( Context.INITIAL_CONTEXT_FACTORY, initialContext );
		put ( Context.PROVIDER_URL, url );
	}

}
