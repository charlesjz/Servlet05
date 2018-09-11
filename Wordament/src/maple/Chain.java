package maple;

public class Chain {
	private int currentDirection;
	private Cell head;
	private int[] route;
		/*
		 * FLOAT         0
		 * UU UP         1
		 * UR UP-RIGHT   2
		 * RR RIGHT      3
		 * DR DOWN-RIGHT 4
		 * DD DOWN       5
		 * DL DOWN-LEFT  6
		 * LL LEFT       7
		 * UL UP-LEFT    8
		 */
	public final int FLOAT=0;
	public final int UU=1;
	public final int UR=2;
	public final int RR=3;
	public final int DR=4;
	public final int DD=5;
	public final int DL=6;
	public final int LL=7;
	public final int UL=8;
	
//	public Chain() {}
	
	public Chain(){
		head= new Cell(0,0);
		currentDirection=FLOAT;
		route=new int[]{currentDirection};
	}

	public int getCurrentDirection() {
		return currentDirection;
	}

	public void setCurrentDirection(int currentDirection) {
		this.currentDirection = currentDirection;
	}

	public Cell getHead() {
		return head;
	}

	public void setHead(Cell head) {
		this.head = head;
	}

	public int[] getRoute() {
		return route;
	}

	public void setRoute(int[] route) {
		this.route = route;
	}

	public int getFLOAT() {
		return FLOAT;
	}

	public int getUU() {
		return UU;
	}

	public int getUR() {
		return UR;
	}

	public int getRR() {
		return RR;
	}

	public int getDR() {
		return DR;
	}

	public int getDD() {
		return DD;
	}

	public int getDL() {
		return DL;
	}

	public int getLL() {
		return LL;
	}

	public int getUL() {
		return UL;
	}

	public String getWord() {
		String word="";
		word=getLetter[0][0];
		for(int r:route){
		}
		
		return word;
	}

}
