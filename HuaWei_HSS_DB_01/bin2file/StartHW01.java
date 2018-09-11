package bin2file;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;


public class StartHW01 {

	public static void action(String directory, String filename) throws Exception {

   	 long begin_time, end_time;
	 begin_time=System.currentTimeMillis();

		String dir = directory;
		
		String a;
		long Addr_of_a=0,k=0;
		int j=0;

		FileInputStream fis = new FileInputStream(dir + filename);
		DataInputStream dis = new DataInputStream(fis);
		BufferedInputStream bis = new BufferedInputStream(dis);

		FileOutputStream fos = new FileOutputStream(dir +filename+"_128.TXT");
		DataOutputStream dos = new DataOutputStream(fos);
		PrintWriter pw = new PrintWriter(dos);

//		bis.skip(1024);
		
		j=128;
		byte[] bb = new byte[j];
//		line:1
		for(int i=0;i<64;i++){
			bis.read(bb);
			a=StringUtil.toHex(bb);
			pw.write("("+Addr_of_a+"):"+a);
			pw.write("\n");
			Addr_of_a+=j;
		}
//		line:65
		j=56;
		bb=new byte[j];
		for(int i=0;i<1024;i++){
			bis.read(bb);
			a=StringUtil.toHex(bb);
			pw.write("("+Addr_of_a+"):"+a);
			pw.write("\n");
			Addr_of_a+=j;
		}
//		line:1089
		j=40;
		bb=new byte[j];
		for(int i=0;i<1124;i++){
			bis.read(bb);
			a=StringUtil.toHex(bb);
			pw.write("("+Addr_of_a+"):"+a);
			pw.write("\n");
			Addr_of_a+=j;
		}
		
		k=44;
		bis.skip(k);
		Addr_of_a+=k;
		pw.write("..."+k+"...\n");

//		line:2214
		j=56;
		bb=new byte[j];
		for(int i=0;i<21;i++){
			bis.read(bb);
			a=StringUtil.toHex(bb);
			pw.write("("+Addr_of_a+"):"+a);
			pw.write("\n");
			Addr_of_a+=j;
		}
		
		k=3032;
		pw.write("("+Addr_of_a+")\n");
		bis.skip(k);
		Addr_of_a+=k;
		Addr_of_a-=60;
		pw.write("..."+k+","+Addr_of_a+"...\n");

//		line:2236
		j=32;
		bb=new byte[j];
		for(int i=0;i<1408;i++){
			bis.read(bb);
			a=StringUtil.toHex(bb);
			pw.write("("+Addr_of_a+"):"+a);
			pw.write("\n");
			Addr_of_a+=j;
		}
		
//		line:3644
		j=8;
		bb=new byte[j];
		for(int i=0;i<1;i++){
			bis.read(bb);
			a=StringUtil.toHex(bb);
			pw.write("("+Addr_of_a+"):"+a);
			pw.write("\n");
			Addr_of_a+=j;
		}
//		line:3645
		j=40;
		bb=new byte[j];
		for(int i=0;i<203;i++){
			bis.read(bb);
			a=StringUtil.toHex(bb);
			pw.write("("+Addr_of_a+"):"+a);
			pw.write("\n");
			Addr_of_a+=j;
		}
//		line:3848 "Metatable"
		j=128;
		bb=new byte[j];
		for(int i=0;i<255;i++){
			bis.read(bb);
			a=StringUtil.toHex(bb);
			pw.write("("+Addr_of_a+"):"+a);
			pw.write("\n");
			Addr_of_a+=j;
		}
		
		k=24;
		bis.skip(k);
		Addr_of_a+=k;
		pw.write("..."+k+"...\n");

//		line:4104
		j=84;
		bb=new byte[j];
		for(int i=0;i<14;i++){
			bis.read(bb);
			a=StringUtil.toHex(bb);
			pw.write("("+Addr_of_a+"):"+a);
			pw.write("\n");
			Addr_of_a+=j;
		}
		
		k=16;
		bis.skip(k);
		Addr_of_a+=k;
		pw.write("..."+k+"...\n");

//		line:4118
		j=84;
		bb=new byte[j];
		for(int i=0;i<12;i++){
			bis.read(bb);
			a=StringUtil.toHex(bb);
			pw.write("("+Addr_of_a+"):"+a);
			pw.write("\n");
			Addr_of_a+=j;
		}
		
		k=16;
		bis.skip(k);
		Addr_of_a+=k;
		pw.write("..."+k+"...\n");

//		line:4133
		j=84;
		bb=new byte[j];
		for(int i=0;i<12;i++){
			bis.read(bb);
			a=StringUtil.toHex(bb);
			pw.write("("+Addr_of_a+"):"+a);
			pw.write("\n");
			Addr_of_a+=j;
		}
		
		k=16;
		bis.skip(k);
		Addr_of_a+=k;
		pw.write("..."+k+"...\n");

//		line:4144
		j=84;
		bb=new byte[j];
		for(int i=0;i<12;i++){
			bis.read(bb);
			a=StringUtil.toHex(bb);
			pw.write("("+Addr_of_a+"):"+a);
			pw.write("\n");
			Addr_of_a+=j;
		}
		
		k=16;
		bis.skip(k);
		Addr_of_a+=k;
		pw.write("..."+k+"...\n");

//		line:4157
		j=84;
		bb=new byte[j];
		for(int i=0;i<12;i++){
			bis.read(bb);
			a=StringUtil.toHex(bb);
			pw.write("("+Addr_of_a+"):"+a);
			pw.write("\n");
			Addr_of_a+=j;
		}
		
		k=16;
		bis.skip(k);
		Addr_of_a+=k;
		pw.write("..."+k+"...\n");

//		line:4169
		j=84;
		bb=new byte[j];
		for(int i=0;i<12;i++){
			bis.read(bb);
			a=StringUtil.toHex(bb);
			pw.write("("+Addr_of_a+"):"+a);
			pw.write("\n");
			Addr_of_a+=j;
		}
		
		k=16;
		bis.skip(k);
		Addr_of_a+=k;
		pw.write("..."+k+"...\n");

//		line:4184
		j=84;
		bb=new byte[j];
		for(int i=0;i<12;i++){
			bis.read(bb);
			a=StringUtil.toHex(bb);
			pw.write("("+Addr_of_a+"):"+a);
			pw.write("\n");
			Addr_of_a+=j;
		}
		
		k=16;
		bis.skip(k);
		Addr_of_a+=k;
		pw.write("..."+k+"...\n");

//		line:4196
		j=84;
		bb=new byte[j];
		for(int i=0;i<12;i++){
			bis.read(bb);
			a=StringUtil.toHex(bb);
			pw.write("("+Addr_of_a+"):"+a);
			pw.write("\n");
			Addr_of_a+=j;
		}
		
		k=16;
		bis.skip(k);
		Addr_of_a+=k;
		pw.write("..."+k+"...\n");

//		line:4211
		j=84;
		bb=new byte[j];
		for(int i=0;i<12;i++){
			bis.read(bb);
			a=StringUtil.toHex(bb);
			pw.write("("+Addr_of_a+"):"+a);
			pw.write("\n");
			Addr_of_a+=j;
		}
		
		for (int loop=0;loop<153;loop++){
		k=16;
		bis.skip(k);
		Addr_of_a+=k;
		pw.write("..."+k+"...\n");
		
		j=84;
		bb=new byte[j];
		for(int i=0;i<12;i++){
			bis.read(bb);
			a=StringUtil.toHex(bb);
			pw.write("("+Addr_of_a+"):"+a);
			pw.write("\n");
			Addr_of_a+=j;
		}
		}
		
//		line:6213
		k=16;
		bis.skip(k);
		Addr_of_a+=k;
		pw.write("..."+k+"...\n");
		
		j=84;
		bb=new byte[j];
		for(int i=0;i<12;i++){
			bis.read(bb);
			a=StringUtil.toHex(bb);
			pw.write("("+Addr_of_a+"):"+a);
			pw.write("\n");
			Addr_of_a+=j;
		}
		
		bis.skip(0x7072000-Addr_of_a);
		Addr_of_a=0x7072000;
		j=30;
		bb=new byte[j];
		for(int i=0;i<1000;i++){
			bis.read(bb);
			a=StringUtil.toHex(bb);
			pw.write("("+Addr_of_a+"):"+a);
			pw.write("\n");
			Addr_of_a+=j;
		}

		

		

		bis.close();
		dis.close();
		fis.close();
		pw.close();
		dos.close();
		fos.close();
		
   	 end_time=System.currentTimeMillis();
     System.out.println(filename+"   During:   "+(end_time-begin_time));

	}
	

}
