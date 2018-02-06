import java.util.ArrayList;

public class DotCom {
	
	private ArrayList<String> locationCells;
	private String theName;
	
	public void setLocationCells(ArrayList<String> locs)
	{
		locationCells = locs;
	}
	
	public void setName(String name)
	{
		theName = name;
	}
	
	public String checkYourself(String userInput)
	{
		String result = "miss";
		
		int guess = Integer.parseInt(userInput);
		int index = locationCells.indexOf(guess);
		
		if (index >= 0)
		{
			locationCells.remove(index);
			if (locationCells.isEmpty())
			{
				result = "kill";
				System.out.println("You sunk " + theName + ";");	
			}
			else
				result = "hit";			
		}
		
		System.out.println(result);
		
		return result;
		
	}//checkYourself
}
