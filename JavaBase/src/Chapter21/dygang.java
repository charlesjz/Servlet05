package Chapter21;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class dygang {

	private final String USER_AGENT = "Mozilla/5.0";

	public static void main(String[] args) throws Exception {
		
		File f=new File("D:/dygang.log");
		FileWriter fw=new FileWriter(f, true);
		BufferedWriter bf=new BufferedWriter(fw);
		PrintWriter pw=new PrintWriter(bf);

		Pattern pattern1;
		Matcher matcher1;

		String url = "http://www.dygang.net";
		dygang http = new dygang();
		String sr1=http.sendGet(url);
		System.out.println(sr1);
		
		String regex1="http:\\/\\/www\\.dygang\\.net\\/e\\/search\\/result\\/\\?searchid=\\d{6}";
		pattern1 = Pattern.compile("http://www.dygang.net/e/search/result/\\?searchid=\\d{6}");//replace regex1
		matcher1 = pattern1.matcher(sr1);
		
		Set <String>linkSet1 = new HashSet<>(); //linkSet1: HomePage HyperLinks
		Set <String>linkSet2 = new HashSet<>(); //linkSet2: SubPage HyperLinks, MultiPage
		
		String regex2="http:\\/\\/www\\.dygang\\.net\\/.{2}\\/\\d{8}\\/\\d{5}.htm";
		Pattern pattern2=Pattern.compile("<td width.*?http.*?htm.*?/td>");// replace regex2
		Matcher matcher2=null;

		while(matcher1.find()){
			linkSet1.add(matcher1.group());
		}
		
		linkSet1.forEach(System.out::println);
		
		for(String set1:linkSet1){
			String sr2="";
			String linkStr="";
			int page=0;
			do{
				linkStr=set1.substring(0, set1.indexOf("?"))+"index.php?page=" + page + "&" + set1.substring(set1.indexOf("?")+1);
				System.out.println(linkStr);
				
				sr2=http.sendGet(linkStr);
//				System.out.println(sr2);
				matcher2 = pattern2.matcher(sr2);
				
				while(matcher2.find()){
					if(matcher2.group().contains("<table"))
						continue;
					linkSet2.add(matcher2.group());
					pw.println(matcher2.group());
				}
				System.out.println(linkSet2.size());
				page++;
			}while(sr2.contains("ÏÂÒ»Ò³"));
						
		}
		
		System.out.println("==========Step 3===========");
		String linkStr3="";
		String filmName="";
		for(String set2:linkSet2){
			linkStr3=set2.substring(set2.indexOf("http"), set2.indexOf("target")-2);
			pw.println(linkStr3);
			filmName=set2.substring(set2.indexOf("classlinkclass")+16,set2.length()-9);
			pw.println(filmName);
		}
		
		pw.flush();
		pw.close();
		bf.close();
		fw.close();
		
	}
	
	
	
	
	
	
	
	// HTTP GET request
	public String sendGet(String url) throws Exception {

		
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
//		System.out.println(response.toString());
		
		return response.toString();

	}

}
