package payBill;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class PayBills {
	int n=0;
	int p=0;
	float amount=0.0f;
	public static void main(String filename){
		try{
			String encoding="GBK";
			File file=new File(filename);
	        if(file.isFile() && file.exists()){
	            InputStreamReader read = new InputStreamReader(
	            new FileInputStream(file),encoding);
	            BufferedReader bufferedReader = new BufferedReader(read);
	            String lineTxt = null;
	            while((lineTxt = bufferedReader.readLine()) != null){
	                System.out.println(lineTxt);
	            }
	            read.close();
	        }else{
	        	System.out.println("Can't find the file!");
	        }
		}catch (Exception e) {
			System.out.println("Read wrong data!");
			e.printStackTrace();
		}
	}
	

}
