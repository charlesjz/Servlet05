package maple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordList {
	List<String> wordList = new ArrayList<>(Arrays.asList("hg"));

	public List<String> getWordList() {
		return wordList;
	}

	public void setWordList(List<String> wordList) {
		this.wordList = wordList;
	}

}
