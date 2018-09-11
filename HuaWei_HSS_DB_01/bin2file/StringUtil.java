package bin2file;

import java.util.Arrays;

/**
 * �ַ����Ĺ����� 
 */
public class StringUtil {
	
	public static String repeat(String s, int n){
		StringBuilder str = new StringBuilder();
		for(int i=0; i<n; i++){
			str.append(s);
		}
		return str.toString();
	}
	
	/**
	 * ����������Ϊ�ַ���
	 *  String[] ary = {"192","168","0","4"}
	 *  Srting ip = "192.168.0.4"
	 * @param ary
	 * @param s
	 * @return
	 * 		//1 ���ж����鳤�ȣ� �����0���ͷ���""
		//2 ����StringBuilder ����[0]
		//3 ��[1]ѭ���������� 
		//4 ÿ����StringBuilder����׷��: s, [i]
		//5 ���ؽ��
	 */
	public static String join(
			Object[] ary, String s){
		if(ary==null || ary.length==0){
			return "";
		}
		String buf = ary[0].toString();
		for(int i=1; i<ary.length; i++){
			buf+=s+ary[i];
		}
		return buf;
	}
	
	public static String rightPad(
			String s, int length, char c){
		String buf = "";
		buf+=s;
		for(int i=0; i<length-s.length(); i++){
			buf+=c;
		}
		return buf.toString();
	}
	/**
	 * Ϊ�ַ��� s ���������, ����ַ���c, ���
	 * �������length
	 *   s = "jerry" ����䵽 10���ַ��� ���ո�
	 *   s = "     jerry"
	 * @param s
	 * @param length
	 * @param c
	 * @return
	 */
	public static String leftPad(
			String s, int length, char c){
		// s="Jerry"  length=10  c='-'
		String buf = "";
		//buf=[-----Jerry]
		//i=1
		for(int i=0; i<length-s.length(); i++){
			buf+=c;
		}
		buf+=s;
		return buf;
	}
	
	
	/**
	 * ���ַ���strת��ΪGBK���� ��HEX �ı�
	 * 1 str ת��Ϊ GBK ����
	 * 2 ��GBK��������Ϊ16�����ַ���
	 * str = "��"; encoding="GBK"
	 * ����: "d6 d0"
	 */
	public static String hexCodes(
			String str, String encoding) //"GBK"
		throws Exception {//str = "ABC��"
		byte[] ary = str.getBytes(encoding);
		return toHex(ary);//ary[65,66,67,-42,-48]
	}
	//������ÿ��byte����ת��Ϊ16�����ַ�����������
	public static String toHexblank(byte[] ary){
		//String str = "";//{5,6,67,-42,-48}
		StringBuilder buf = new StringBuilder();
		for(int i=0; i<ary.length; i++){
			int b = ary[i] & 0xff;
			if(b<=0xf){//һλ��16������
				buf.append('0');
			}
			String hex = Integer.toHexString(b);
			//str += hex+" ";
			buf.append(hex).append(" ");
		}
		return buf.toString();
	}
	public static String toHex(byte[] ary){
		//String str = "";//{5,6,67,-42,-48}
		StringBuilder buf = new StringBuilder();
		for(int i=0; i<ary.length; i++){
			int b = ary[i] & 0xff;
			if(b<=0xf){//һλ��16������
				buf.append('0');
			}
			String hex = Integer.toHexString(b);
			buf.append(hex);
		}
		return buf.toString();
	}
	
	public static String getHost(String email){
		return email.substring(email.indexOf("@")+1);
	}
	
	public static String getUsername(String email){
		return email.substring(0, email.indexOf("@"));
	}
	
	/** ����ַ����Ƿ��ǻ���(Palindrome) */
	public static boolean isPalindrome(String s){
		for(int i=0; i<s.length()/2; i++){
			if(s.charAt(i)!=s.charAt(s.length()-1-i)){
				//���κ�һ���ַ���ͬ, �Ͳ��ǻ�����
				return false;
			}
		}
		return true;//�ǻ���
	}
	
	/** ����key��str�����е�λ�� */
	public static int[] indexAll(
			String str, String key){
		int[] all = {};//������
		int index=0;
		while((index=str.indexOf(key, index))!=-1){
			all = Arrays.copyOf(all, all.length+1);
			all[all.length-1] = index;//���뵽�������
			index+=key.length();
		}
		return all;
	}
	public static int[] indexAll(
			String str, char key){
		return null;
	}
	public static String toString(byte b){
		return ""+(b&0xff);
	}
	
	public static String toUpperCase(String str){
		str=str.replace('a', 'A');
		str=str.replace('b', 'B');
		str=str.replace('c', 'C');
		str=str.replace('d', 'D');
		str=str.replace('e', 'E');
		str=str.replace('f', 'F');
		str=str.replace('g', 'G');
		str=str.replace('h', 'H');
		str=str.replace('i', 'I');
		str=str.replace('j', 'J');
		str=str.replace('k', 'K');
		str=str.replace('l', 'L');
		str=str.replace('m', 'M');
		str=str.replace('n', 'N');
		str=str.replace('o', 'O');
		str=str.replace('p', 'P');
		str=str.replace('q', 'Q');
		str=str.replace('r', 'R');
		str=str.replace('s', 'S');
		str=str.replace('t', 'T');
		str=str.replace('u', 'U');
		str=str.replace('v', 'V');
		str=str.replace('w', 'W');
		str=str.replace('x', 'X');
		str=str.replace('y', 'Y');
		str=str.replace('z', 'Z');
		
		return str;
	}
	public static long reversedVal(byte[] ary, int begin){
		long result = 0;
		result=(ary[begin]&0xff)+
		       (ary[begin+1]&0xff)*0x100+
		       (ary[begin+2]&0xff)*0x10000+
		       (ary[begin+3]&0xff)*0x1000000;
		return result;
	}
	
}
