
public class Card {
	private char suit;
	private char rank;
	
	public Card(char r, char s){
		rank = r;
		suit = s;
	}
	
	public void display(){
		if (rank == 'T') 
			System.out.printf("10%s ",suit);
		else
			System.out.printf("%s%s, ",rank,suit);
	}

	public int getValue(){
	    if (rank == 'A') {
	    	return 1;
	    }
	    else if(rank == 'T' || rank == 'J' || rank == 'Q' || rank == 'K') {
	    	return 10;
	    }
	    else {
	    	return Character.getNumericValue(rank); 
	    }
	}

	public char getRank(){
		return rank;
	}

	public char getSuit(){
		return suit;
	}
	
}

