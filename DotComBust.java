import java.util.*;

public class DotComBust {
	
	private GameHelper helper = new GameHelper();
	private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
	private int numOfGuesses = 0;
	
	private void setUpGame()
	{
		//first make some dot coms and give them locations
		DotCom one = new DotCom();
		one.setName("Amor.com");
		DotCom two = new DotCom();
		two.setName("Mahal.com");
		DotCom three = new DotCom();
		three.setName("Dich.com");
		
		dotComsList.add(one);
		dotComsList.add(two);
		dotComsList.add(three);
		
		System.out.println("Your goal is to sink three dot coms.");
		System.out.println("Amor.com, Mahal.com, Dich.com");
		System.out.println("Try to sink them all in the fewest amount of guesses");
		
		for (DotCom dotComToSet : dotComsList)
		{
			ArrayList<String> newLocation = helper.placeDotCom(3);
			dotComToSet.setLocationCells(newLocation);
		}	
	}//setUpGame
	
	private void checkUserGuess(String userGuess)
	{
		numOfGuesses++;
		String result = "miss";
		
		for (int x=0; x<dotComsList.size(); x++)
		{
			result = dotComsList.get(x).checkYourself(userGuess);
			
			if (result.equals("hit"))
			{
				break;
			}
			
			if (result.equals("kill"))
			{
				dotComsList.remove(x);				//check check check (dotComToTest)
				break;
			}
		}//for loop
		
		System.out.println(result);
	}//checkUserGuess
	
	private void finishGame()
	{
		System.out.println("All Dot Coms are dead! Stock now worthless!!!");
		
		if (numOfGuesses <=18)
		{
			System.out.println("It only took you " + numOfGuesses + "guesses.");
			System.out.println("You got out before your options sank.");
		}
		else
		{
			System.out.println("Took you long enough." +  numOfGuesses + "guesses.");
			System.out.println("Fish are dancing with your options");
		}
	}//finishGame
	
	private void startPlaying()
	{
		while (!dotComsList.isEmpty())
		{
			String userGuess = helper.getUserInput("Enter a guess");
			checkUserGuess(userGuess);		
		}
		
		finishGame();
	}//startPlaying
	
	public static void main(String[] args)
	{
		DotComBust game = new DotComBust();
		game.setUpGame();
		game.startPlaying();
	}

}//main class
