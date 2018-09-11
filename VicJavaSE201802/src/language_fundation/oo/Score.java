package language_fundation.oo;

public enum Score {
	
	A ( 90, 100, "Grade A", "Excellent score, eligible for Coop"), 
	B ( 80, 89.9, "Grade B", "Good score, eligible for Coop" ), 
	C ( 70, 79.9, "Grade C", "Fair score, eligible for Coop" ), 
	Pass ( 60, 69.9, "Grade D", "Average score, not eligible for Coop" ), 
	Fail ( 0, 59.9, "Grade E", "Bad score, not eligible for Coop" );
	
	private Score ( double minScore, double maxScore, String displayName, String description ) {
		this.minScore = minScore;
		this.maxScore = maxScore;
		this.displayName = displayName;
		this.description = description;
	}
	
	private double minScore;
	private double maxScore;
	private String displayName;
	private String description;
	
	public boolean isEligibleForCoop ( ) {
		return this.minScore >= 70;
	}

	public double getMinScore() {
		return minScore;
	}

	public double getMaxScore() {
		return maxScore;
	}

	public String getDisplayName() {
		return displayName;
	}

	public String getDescription() {
		return description;
	}
	
	
	
//	public static Score string2Score ( String scoreValue ) {
//		if ( "A".equalsIgnoreCase( scoreValue ) ) {
//			return Score.A;
//		} else if ( "B".equalsIgnoreCase( scoreValue ) ) {
//			return Score.B;
//		} else if ( "C".equalsIgnoreCase( scoreValue ) ) {
//			return Score.C;
//		} else if ( "Pass".equalsIgnoreCase( scoreValue ) ) {
//			return Score.Pass;
//		} else if ( "Fail".equalsIgnoreCase( scoreValue ) ) {
//			return Score.Fail;
//		} else {
//			return null;
//		}
//	}



}
