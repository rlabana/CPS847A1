import java.io.*;
import java.util.*;

public class GameHelper {
	
	private static final String alphabet = "abcdef";
	private int gridLength = 7;
	private int gridSize = 49;
	private int[] grid = new int[gridSize];
	private int comCount = 0;
	
	
	public String getUserInput(String prompt)
	{
		String inputLine = null;
		System.out.print(prompt + " ");
		try
		{
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			inputLine = in.readLine();
			
			if (inputLine.length() == 0 )
				return null;
		}
		catch (IOException e)
		{
			System.out.println("IOException: " + e);
		}
		
		return inputLine.toLowerCase();
	}//getUserInput
	
	public ArrayList<String> placeDotCom(int comSize)
	{
		ArrayList<String> alphaCells = new ArrayList<String>();
		String[] alphacoords = new String[comSize];
		String temp = null;
		int[] coords = new int[comSize];
		int attempts = 0;
		boolean success = false;
		int location = 0;
		
		comCount++;												//nth dot.com to place
		int increment = 1;										//set horizontal increment
		if ((comCount % 2) == 1)								//if odd dot.com [place vertically]
		{
			increment = gridLength;								//set vertical increment
		}
		
		while (!success & attempts++ < 200)
		{
			location = (int) (Math.random() * gridSize);		//get random starting point
			System.out.println("try: " + location);
			
			int x= 0;											//nth position in dot.com to place
			success = true;
			while (success && x<comSize)						//look for adjacent unused spots
			{
				if (grid[location] == 0)						//if not already used
				{
					coords[x++] = location;						//save location
					location += increment;						//try "next" adjacent
					if (location >= gridSize)					//out of bounds = "bottom"
					{
						success = false;
					}
					if (x>0 && (location % gridLength == 0))	//out of bounds - right edge
					{
						success = false;
					}
				}
				else											//found already used location
				{
					System.out.println(" used " + location);
					success = false;
				}
			}//while
		}//outer while
		
		int x = 0;												//turn location into alpha coordinates
		int row = 0;
		int column = 0;
		
		while (x < comSize)
		{
			grid[coords[x]] = 1;								//mark master grid pts as "used"
			row = (int) (coords[x] / gridLength);				//get row value		
			column = coords[x] % gridLength;					//get numeric column value
			temp = String.valueOf(alphabet.charAt(column));		//convert to alpha
			
			alphaCells.add(temp.concat(Integer.toString(row)));
			x++;
			System.out.println(   "coord" +x+ "=" + alphaCells.get(x-1)); 
		}//while
		
		return alphaCells;	
		
	}//placeDotCom

}
