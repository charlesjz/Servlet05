package huawei;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import bin2file.StringUtil;
import huawei.HWUtil;

public class _0x00002000 {

	public static void action(String directory, String filename) throws Exception {

   	 long begin_time, end_time;
	 begin_time=System.currentTimeMillis();

		String dir = directory;
		
		String a;

		FileInputStream fis = new FileInputStream(dir + filename);
		DataInputStream dis = new DataInputStream(fis);
		BufferedInputStream bis = new BufferedInputStream(dis);

		FileOutputStream fos = new FileOutputStream(dir + filename + "_2000_result.TXT");
		DataOutputStream dos = new DataOutputStream(fos);
		PrintWriter pw = new PrintWriter(dos);

//		bis.skip(0);
		bis.skip(0x00002000);
		

		byte[] bb = new byte[56];
		StringBuffer sb;
		for (int i=0;i<100;i++){
			bis.read(bb);
//			pw.write(StringUtil.toHex(bb)+"\n");
//			sb=new StringBuffer("");
			
//			for(int j=0;j<32;j++){
//				if((bb[j]&0xff)==0x00) break;
//				sb.append((char)bb[j]);
//			}
//			pw.write(sb.toString()+"\n");
			
			sb=new StringBuffer();
			sb.append(Integer.toHexString(i)+",  0x");
			if((bb[3]&0xff)<0x10){sb.append("0");}
			sb.append(Integer.toHexString((bb[3]&0xff)));		
			if((bb[2]&0xff)<0x10){sb.append("0");}
			sb.append(Integer.toHexString((bb[2]&0xff)));		
			if((bb[1]&0xff)<0x10){sb.append("0");}
			sb.append(Integer.toHexString((bb[1]&0xff)));		
			if((bb[0]&0xff)<0x10){sb.append("0");}
			sb.append(Integer.toHexString((bb[0]&0xff)));	
			sb.append(",  0x");
			if((bb[7]&0xff)<0x10){sb.append("0");}
			sb.append(Integer.toHexString((bb[7]&0xff)));		
			if((bb[6]&0xff)<0x10){sb.append("0");}
			sb.append(Integer.toHexString((bb[6]&0xff)));		
			if((bb[5]&0xff)<0x10){sb.append("0");}
			sb.append(Integer.toHexString((bb[5]&0xff)));		
			if((bb[4]&0xff)<0x10){sb.append("0");}
			sb.append(Integer.toHexString((bb[4]&0xff)));	
			sb.append(",  0x");
			if((bb[11]&0xff)<0x10){sb.append("0");}
			sb.append(Integer.toHexString((bb[11]&0xff)));		
			if((bb[10]&0xff)<0x10){sb.append("0");}
			sb.append(Integer.toHexString((bb[10]&0xff)));		
			if((bb[9]&0xff)<0x10){sb.append("0");}
			sb.append(Integer.toHexString((bb[9]&0xff)));		
			if((bb[8]&0xff)<0x10){sb.append("0");}
			sb.append(Integer.toHexString((bb[8]&0xff)));	
			sb.append(",  0x");
			if((bb[15]&0xff)<0x10){sb.append("0");}
			sb.append(Integer.toHexString((bb[15]&0xff)));		
			if((bb[14]&0xff)<0x10){sb.append("0");}
			sb.append(Integer.toHexString((bb[14]&0xff)));		
			if((bb[13]&0xff)<0x10){sb.append("0");}
			sb.append(Integer.toHexString((bb[13]&0xff)));		
			if((bb[12]&0xff)<0x10){sb.append("0");}
			sb.append(Integer.toHexString((bb[12]&0xff)));	
			sb.append(",  0x");
			if((bb[19]&0xff)<0x10){sb.append("0");}
			sb.append(Integer.toHexString((bb[19]&0xff)));		
			if((bb[18]&0xff)<0x10){sb.append("0");}
			sb.append(Integer.toHexString((bb[18]&0xff)));		
			if((bb[17]&0xff)<0x10){sb.append("0");}
			sb.append(Integer.toHexString((bb[17]&0xff)));		
			if((bb[16]&0xff)<0x10){sb.append("0");}
			sb.append(Integer.toHexString((bb[16]&0xff)));	
			sb.append(",  0x");
			if((bb[23]&0xff)<0x10){sb.append("0");}
			sb.append(Integer.toHexString((bb[23]&0xff)));		
			if((bb[22]&0xff)<0x10){sb.append("0");}
			sb.append(Integer.toHexString((bb[22]&0xff)));		
			if((bb[21]&0xff)<0x10){sb.append("0");}
			sb.append(Integer.toHexString((bb[21]&0xff)));		
			if((bb[20]&0xff)<0x10){sb.append("0");}
			sb.append(Integer.toHexString((bb[20]&0xff)));	
			sb.append(",  0x");
			if((bb[27]&0xff)<0x10){sb.append("0");}
			sb.append(Integer.toHexString((bb[27]&0xff)));		
			if((bb[26]&0xff)<0x10){sb.append("0");}
			sb.append(Integer.toHexString((bb[26]&0xff)));		
			if((bb[25]&0xff)<0x10){sb.append("0");}
			sb.append(Integer.toHexString((bb[25]&0xff)));		
			if((bb[24]&0xff)<0x10){sb.append("0");}
			sb.append(Integer.toHexString((bb[24]&0xff)));	
			sb.append(",  0x");
			if((bb[31]&0xff)<0x10){sb.append("0");}
			sb.append(Integer.toHexString((bb[31]&0xff)));		
			if((bb[30]&0xff)<0x10){sb.append("0");}
			sb.append(Integer.toHexString((bb[30]&0xff)));		
			if((bb[29]&0xff)<0x10){sb.append("0");}
			sb.append(Integer.toHexString((bb[29]&0xff)));		
			if((bb[28]&0xff)<0x10){sb.append("0");}
			sb.append(Integer.toHexString((bb[28]&0xff)));	
			sb.append(",  0x");
			if((bb[35]&0xff)<0x10){sb.append("0");}
			sb.append(Integer.toHexString((bb[35]&0xff)));		
			if((bb[34]&0xff)<0x10){sb.append("0");}
			sb.append(Integer.toHexString((bb[34]&0xff)));		
			if((bb[33]&0xff)<0x10){sb.append("0");}
			sb.append(Integer.toHexString((bb[33]&0xff)));		
			if((bb[32]&0xff)<0x10){sb.append("0");}
			sb.append(Integer.toHexString((bb[32]&0xff)));	
			sb.append(",  0x");
			if((bb[39]&0xff)<0x10){sb.append("0");}
			sb.append(Integer.toHexString((bb[39]&0xff)));		
			if((bb[38]&0xff)<0x10){sb.append("0");}
			sb.append(Integer.toHexString((bb[38]&0xff)));		
			if((bb[37]&0xff)<0x10){sb.append("0");}
			sb.append(Integer.toHexString((bb[37]&0xff)));		
			if((bb[36]&0xff)<0x10){sb.append("0");}
			sb.append(Integer.toHexString((bb[36]&0xff)));	
			a=sb.toString();
			pw.write(a+"\n");
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
	
	public static void analyse(String directory, String filename) throws Exception {

	   	 long begin_time, end_time;
		 begin_time=System.currentTimeMillis();

			String dir = directory;
			
			FileInputStream fis = new FileInputStream(dir + filename);
			DataInputStream dis = new DataInputStream(fis);
			BufferedInputStream bis = new BufferedInputStream(dis);

			FileOutputStream fos = new FileOutputStream(dir +filename+"_2000_analyse.TXT");
			DataOutputStream dos = new DataOutputStream(fos);
			PrintWriter pw = new PrintWriter(dos);

			bis.skip(0x00002000);
			

			byte[] bb = new byte[56];

			long[] a0 = new long[100];
			long[] a1 = new long[100];
			long[] a2 = new long[100];
			long[] a3 = new long[100];
			long[] a4 = new long[100];
			long[] a5 = new long[100];
			int[] a6 =new int[100];
			int[] a7 =new int[100];
			int[] a8 =new int[100];
			int[] a9 =new int[100];
			
			
			for (int i=0;i<100;i++){
				bis.read(bb);
				a0[i]=StringUtil.reversedVal(bb, 0);
				a1[i]=StringUtil.reversedVal(bb, 4);
				a2[i]=StringUtil.reversedVal(bb, 8);
				a3[i]=StringUtil.reversedVal(bb, 12);
				a4[i]=StringUtil.reversedVal(bb, 16);
				a5[i]=StringUtil.reversedVal(bb, 20);
				a6[i]=(bb[24]&0xff)+(bb[25]&0xff)*0x100;
				a7[i]=(bb[28]&0xff)+(bb[29]&0xff)*0x100;
				a8[i]=(bb[32]&0xff)+(bb[33]&0xff)*0x100;
				a9[i]=(bb[36]&0xff)+(bb[37]&0xff)*0x100;
				pw.write("  0x"+Long.toHexString(a0[i])+", 0x"+   Long.toHexString(a1[i])+", 0x"+   Long.toHexString(a2[i])+", 0x"+   Long.toHexString(a3[i])+", 0x"+   Long.toHexString(a4[i])+
						 ", 0x"+Long.toHexString(a5[i])+", 0x"+Integer.toHexString(a6[i])+", 0x"+Integer.toHexString(a7[i])+", 0x"+Integer.toHexString(a8[i])+", 0x"+Integer.toHexString(a9[i])+"\n");
			}
			bis.close();
			dis.close();
			fis.close();
			pw.close();
			dos.close();
			fos.close();
			
			long addr_begin=0;
			for (int i=0;i<100;i++){
				if(a3[i]==0) break;
				if(a3[i]==-1) continue;
				
				int length=a7[i];
				int cnt=a8[i];
				addr_begin=HWUtil.findBegin(dir, filename, a3[i]);
				fis = new FileInputStream(dir + filename);
				dis = new DataInputStream(fis);
				bis = new BufferedInputStream(dis);

				fos = new FileOutputStream(dir +filename+"_(0x"+Integer.toHexString(i)+")_0x"+Long.toHexString(a3[i])+"_0x"+Long.toHexString(addr_begin)+".txt");
				dos = new DataOutputStream(fos);
				pw = new PrintWriter(dos);
				
				bis.skip(addr_begin+8);

				byte[] cc = new byte[length];
				for (int j=0;j<cnt;j++){
					bis.read(cc);
					if((cc[0]&0xff)==0) break;
					pw.write(StringUtil.toHex(cc));
					pw.write("\n");
				}
				pw.flush();
				bis.close();
				dis.close();
				fis.close();

				if(a4[i]==-1||a4[i]==a3[i]) continue;
				addr_begin=HWUtil.findBegin(dir, filename, a4[i]);
				fis = new FileInputStream(dir + filename);
				dis = new DataInputStream(fis);
				bis = new BufferedInputStream(dis);

 				bis.skip(addr_begin+8);

				for (int j=0;j<cnt;j++){
					bis.read(cc);
					if((cc[0]&0xff)==0) break;
					pw.write(StringUtil.toHex(cc));
					pw.write("\n");
				}
				pw.flush();
				bis.close();
				dis.close();
				fis.close();

				if(a5[i]==-1) continue;
				addr_begin=HWUtil.findBegin(dir, filename, a5[i]);
				fis = new FileInputStream(dir + filename);
				dis = new DataInputStream(fis);
				bis = new BufferedInputStream(dis);

 				bis.skip(addr_begin+8);

				for (int j=0;j<cnt;j++){
					bis.read(cc);
					if((cc[0]&0xff)==0) break;
					pw.write(StringUtil.toHex(cc));
					pw.write("\n");
				}
				pw.flush();
				bis.close();
				dis.close();
				fis.close();
				pw.close();
				dos.close();
				fos.close();
			}
			
	   	 end_time=System.currentTimeMillis();
	     System.out.println(filename+"   During:   "+(end_time-begin_time));

		}

}
