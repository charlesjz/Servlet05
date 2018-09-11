package bin2file;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;


public class StartHW02 {

	public static void action(String directory, String filename, long Addr_Begin) throws Exception {

   	 long begin_time, end_time;
	 begin_time=System.currentTimeMillis();

		String dir = directory;
		
		String a;
		long Addr_of_temp=Addr_Begin;
		int j=0,loop;

		FileInputStream fis = new FileInputStream(dir + filename);
		DataInputStream dis = new DataInputStream(fis);
		BufferedInputStream bis = new BufferedInputStream(dis);

		FileOutputStream fos = new FileOutputStream(dir +filename+".TXT");
		DataOutputStream dos = new DataOutputStream(fos);
		PrintWriter pw = new PrintWriter(dos);
		

		bis.skip(Addr_of_temp);
		
	    System.out.println("Address begin from: 0x"+Long.toHexString(Addr_of_temp));

		//line:1
		j=48;
		byte[] bb = new byte [j];
		bis.read(bb);
		a="";
		for (int i=0;i<32;i++){
			if (bb[8+i] == 0){
				break;
			}
			a=a+(char)bb[8+i];
		}
		System.out.println("Table_name:"+a);

		//line:2
		j=48;
		bb = new byte[j];
		bis.read(bb);
		loop=bb[0];
				
		System.out.println("Field_number:"+loop+", "+"Length:"+(int)(bb[8]&0xff));
		
		//line:3...
		j=84;
		bb = new byte[j];
		for (int k=0;k<loop;k++){
		  bis.read(bb);
			a="";
			for (int i=0;i<32;i++){
				if (bb[8+i] == 0){
					break;
				}
				a=a+(char)bb[8+i];
			}
			System.out.println(a+",        SN: "+(bb[40]&0xff)+",     Length: "+(bb[52]&0xff)+",     Begin: "+(bb[56]&0xff));

		}

		bis.close();
		dis.close();
		fis.close();
		pw.close();
		dos.close();
		fos.close();
		
   	 end_time=System.currentTimeMillis();
     System.out.println(filename+"   During:   "+(end_time-begin_time));
     System.out.println("\n\n");

	}
	

}
