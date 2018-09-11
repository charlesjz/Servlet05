/*
 * Created on Aug 29, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package remote.http;

import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author David Gao
 *
 * This sample is written based on sample4e (using declarative transaction management) and
 * demostrates the Spring HTTP invoker function.
 * 
 * This is the service provider (server) side to register the service. Please refer to 
 * sample5b.client package for client side implementation.
 * 
 */
public class Sample5b {

	/**
	 * 
	 */
	public Sample5b() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		try
		{
			ApplicationContext beanFactory = new FileSystemXmlApplicationContext ( "remote/http/sample.xml" );
			System.out.println ( "The BeanFactory instance obtained." );

			System.out.println ( "NCT Bank Services ( CustomerService and AccountService ) has started, type \"EXIT\" to terminate . . ." );
			while ( ( new LineNumberReader ( new InputStreamReader ( System.in ) ) ).readLine ( ).equalsIgnoreCase ( "EXIT" ) );

			System.out.println ( "done." );
		}
		catch ( Exception e )
		{
			e.printStackTrace ( System.err );
		}

	}
}
