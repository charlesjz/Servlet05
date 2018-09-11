package maple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;


public class WordMap2 {

	static String letterString;
	
	
	
	public String[][] word={{"H","S","E","C","D"},
			{"T","G","H","A","Q"},
			{"M","U","N","I","R"},
			{"E","O","L","S","B"},
			{"S","T","R","I","T"}};
	
	private String[][] wordCross;
	
	public void setWordCross(WordCross wordCross) {
		this.wordCross = word;
	}
	

	String getLetter(int x, int y){
		return wordCross[x][y];
	}
	
//	@Test
//	public void test1(){
//		for(String[] strs:wordMap){
//			for(String str:strs){
//				System.out.println(str);
//			}
//		}
//		System.out.println(wordMap[0][3]);
//	}
	
	@Test
	public void test02() {
		
		List<String> wordList = new ArrayList<>(Arrays.asList("h","hg","hgh","hghi"));
		System.out.println(wordList.size());

		Chain wordChain =new Chain();
		System.out.println("========1=========");

		System.out.println(wordChain.getCurrentDirection());
		
		System.out.println("========2=========");
		
		System.out.println(wordChain.getRoute().length);
		
		wordList.stream().filter((word)->word.startsWith("hg")).forEach(System.out::println);
		
		init();
		
		System.out.println("letterString:"+letterString);
		
		
//		isRightRoute();
//		
//		isAnWord();
//		
		


	}


//	private boolean isAnWord() {
//		if(wordList.stream().filter((word)->word.startsWith("hg")).lenth()>0)
//		return 
//}
//
//
//	private boolean isRightRoute() {
//
//	return 
//}


	private void init() {
		Cell head = new Cell(0,0);
		letterString=""+word[0][0];
		
	}
	

}
