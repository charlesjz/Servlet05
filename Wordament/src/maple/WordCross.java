package maple;

public class WordCross {
	
	private String[][] letterMatrix;

	public String[][] getLetterMatrix() {
		return letterMatrix;
	}
	public String getLetterMatrix(int x, int y) {
		return letterMatrix[x][y];
	}

	public void setLetterMatrix(String[][] letterMatrix) {
		this.letterMatrix = letterMatrix;
	}
	
	

}
