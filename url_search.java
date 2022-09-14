import java.io.*;
import java.util.*;

public class url_search {

	// C:\Users\shiva\OneDrive\Desktop\Practical\PS-3\question.txt
	
	public static ArrayList<String> URLlist;

	public static void main(String[] args) throws FileNotFoundException{
		
		URLlist = new ArrayList<String>();
		
		Scanner file_loc= new Scanner(System.in);
		System.out.println("Please enter the location of your file: ");
		String path= file_loc.nextLine();   
		
		File inFile = new File(path);
		Scanner sc = new Scanner(inFile);
		
		while (sc.hasNextLine())
		{      
			    String line = sc.nextLine();
			    String[] words = line.split("\\s");
			    
			    for(int i = 0; i < words.length ; i++){
			    	if (words[i].matches("\\b((https?)://|(www))\\S+"))
			    		URLlist.add(words[i]);
			    }
		}

		if(URLlist == null)
		{
			System.out.println("No URL found in document");
		}
		else
		{
			int [] fr = new int [URLlist.size()];  
        	int visited = -1;  
        	for(int i = 0; i < URLlist.size(); i++)
			{  
            	int count = 1;  
            	for(int j = i+1; j < URLlist.size(); j++)
				{  
					// System.out.println("Element " + URLlist.get(j));
                	if(URLlist.get(i).equals(URLlist.get(j)))
					{  
                    	count++;  
                    	fr[j] = visited;  
                }  
				// System.out.println("    " + URLlist.get(i) + "    |    " + count); 
            }  
            if(fr[i] != visited)  
                fr[i] = count;  
        }  
  
        //Displays the frequency of each element present in array  
        System.out.println("---------------------------------------");  
        System.out.println(" URL | Occurrences");  
        System.out.println("---------------------------------------");  
        for(int i = 0; i < fr.length; i++){  
            if(fr[i] != visited)  
                System.out.println("    " + URLlist.get(i) + "    |    " + fr[i]);  
        }     			
		
		}
		
	}	
}	