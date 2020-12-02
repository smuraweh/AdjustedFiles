

import javax.swing.JButton;
import javax.swing.JFileChooser;


import java.util.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.*; 
import java.util.LinkedList;


public class Add {
	
	
	 // Function to remove duplicates from an ArrayList 
    public static <T> ArrayList<T> removeDuplicates(ArrayList<T> list) 
    { 
  
        // Create a new ArrayList 
        ArrayList<T> newList = new ArrayList<T>(); 
  
        // Traverse through the first list 
        for (T element : list) { 
  
            // If this element is not present in newList 
            // then add it 
            if (!newList.contains(element)) { 
  
                newList.add(element); 
            } 
        } 
  
        // return the new list 
        return newList; 
    } 
    
    public static <T> List<T> convert(List<T> newList) 
    { 
  
        List<T> ASURITE = new LinkedList<>(); 
        for (T t : newList) { 

            ASURITE.add(t); 
        } 

        return ASURITE; 
    }
    public static <T> List<T> converttimes(List<T> newTime) 
    { 
  
        List<T> ATIME = new LinkedList<>(); 
        for (T t : newTime) { 

            ATIME.add(t); 
        } 

        return ATIME; 
    }
    
    
	public void addAttendance() {
		// TODO Auto-generated method stub
		
		//LinkedList<String> ASURITE = new LinkedList<>(); 
		ArrayList<Double> TIME = new ArrayList<>();
		
		//Hashtable<String, String> attend = new Hashtable<>(); 
		ArrayList<String> ASUR = new ArrayList<>();
		

		
		JButton open = new JButton();
		JFileChooser fc = new JFileChooser();
		fc.setCurrentDirectory(new java.io.File("."));
		fc.setDialogTitle("Select CSV FILE");
	//	fc.setFileSelectionMode("JFileChooser.") possibly make only csv files selectable
		if (fc.showOpenDialog(open) == JFileChooser.APPROVE_OPTION)
		{
			//stuff if approved file
		}
		System.out.println(fc.getSelectedFile().getAbsolutePath());
		
		String path = fc.getSelectedFile().getAbsolutePath();
		 String line = "";
		 try {
		 BufferedReader reader = new BufferedReader(new FileReader(path));
		 
		 while((line = reader.readLine()) != null) {
			 String[] stuff = line.split(",");
			ASUR.add(stuff[0]);
		
			double dnum = Double.parseDouble(stuff[1]);
			TIME.add(dnum);
			
		
		 }
		 
		 ArrayList<String> newList = removeDuplicates(ASUR);
		 ArrayList<Double> newTIME = new ArrayList<>();
		 int size =  newList.size();
		 int size2 =  ASUR.size();
		 int k = 0;
		 double g = 0;
		 int i = 0;
		 int q= 0;
		 
		while(i < size)
		{
			
			
			q=0;
			 k = 0;
			 g = 0; 
		 while ( k < size2)
		 {
			 boolean isEqual = ASUR.get(k).equals(newList.get(i)); 
			 
			 if( q == 0)
			 {
				g = g + TIME.get(k);
				
				 newTIME.add(g);
			//	 System.out.println(k);
				 k++;
			//	 System.out.println(g);
				 q++;
				 if(i >0)
				 {
					 g = g - TIME.get(0);
					 newTIME.set(i, g);
				 }
				 
			 }
			 
			 else if(isEqual)
			 {
				 g = g + TIME.get(k);
				 newTIME.set(i, g);
				 k++;
				 
			 }
			
			 else 
			 {
				 k++;
			 }
			
		 }
		 i++;
		}
		
		List<String> ASURITE = convert(newList); 
		List<Double> ATIME = converttimes(newTIME); 
		System.out.println(ASURITE);
		System.out.println(ATIME);
		 
		 }catch(FileNotFoundException a) {
			 System.out.println("AAAAAAA");
		 }catch(IOException a) {
			 System.out.println("AAAAAAAX2");
		 }
			  
		 }
	

}
