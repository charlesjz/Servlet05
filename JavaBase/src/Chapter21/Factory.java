package Chapter21;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;


class InetAddressTest
{
	public static void main(String args[]) throws UnknownHostException {
		InetAddress Address = InetAddress.getLocalHost();
		System.out.println(Address);
		Address = InetAddress.getByName("www.goldmapleclub.com");
		System.out.println(Address);
		InetAddress SW[] = InetAddress.getAllByName("www.nba.com");
	for (int i=0; i<SW.length; i++)
		System.out.println(SW[i]);

	


	//�жϵ�ǰϵͳ�Ƿ�֧��Java AWT Desktop��չ
	        if(java.awt.Desktop.isDesktopSupported()){
	            try{
	                //����һ��URIʵ��,ע�ⲻ��URL
	                java.net.URI uri=java.net.URI.create("http://www.dalian-jw.gov.cn/portal/afcc3edda04f3983ed5a47c1b8bd535f/function/level2_lhsf");
	                //��ȡ��ǰϵͳ������չ
	                java.awt.Desktop dp=java.awt.Desktop.getDesktop();
	                //�ж�ϵͳ�����Ƿ�֧��Ҫִ�еĹ���
	                if(dp.isSupported(java.awt.Desktop.Action.BROWSE)){
	                    //��ȡϵͳĬ�������������
	                    dp.browse(uri);
	                }
	            }catch(java.lang.NullPointerException e){
	                //��ΪuriΪ��ʱ�׳��쳣
	            }catch(java.io.IOException e){
	                //��Ϊ�޷���ȡϵͳĬ�������
	            }
	            
	            System.out.println("��������֤�룺");
	            Scanner scanner=new Scanner(System.in);
	            String str=scanner.next();
	            System.out.println(str);
	            String cardnum="04595430";
	            
	            

	        }
	}
}