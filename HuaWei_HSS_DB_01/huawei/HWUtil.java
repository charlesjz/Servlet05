package huawei;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import bin2file.StringUtil;

public class HWUtil {
	public static long findBegin(String dir, String filename, long addr_begin) throws Exception{
		FileInputStream fis = new FileInputStream(dir + filename);
		DataInputStream dis = new DataInputStream(fis);
		BufferedInputStream bis = new BufferedInputStream(dis);

		bis.skip(addr_begin);
		byte[] cc = new byte[32];
		bis.read(cc);
		long result=StringUtil.reversedVal(cc, 0x10);
//		System.out.println(dir+filename);
//		System.out.println(Long.toHexString(addr_begin));
//		System.out.println(Long.toHexString(result));
		bis.close();
		dis.close();
		fis.close();

		return result;
	}

	public static void printtable(String dir, String filename, int length, int cnt, long addrBegin) throws Exception {
		FileInputStream fis = new FileInputStream(dir + filename);
		DataInputStream dis = new DataInputStream(fis);
		BufferedInputStream bis = new BufferedInputStream(dis);

		FileOutputStream fos = new FileOutputStream(dir +filename+"_0x"+Long.toHexString(addrBegin)+".txt");
		DataOutputStream dos = new DataOutputStream(fos);
		PrintWriter pw = new PrintWriter(dos);

		bis.skip(addrBegin+8);

		byte[] cc = new byte[length];

		for (int i=0;i<cnt;i++){
			if (length>200) break;
			bis.read(cc);
			pw.write(StringUtil.toHex(cc));
			pw.write("\n");
		}

		
	}



}
