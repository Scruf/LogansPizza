/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

/**
 *
 * @author ekozi
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

public class FindFast {
	ArrayList < Integer > list;
	public FindFast() {
		list = new ArrayList < Integer > ();
	}
	public void populate(String name) {

		try {
			String dummy = " ";
			BufferedReader reader = new BufferedReader(new FileReader(name));
			while ((dummy = reader.readLine()) != null) {
				list.add(Integer.parseInt(dummy.split(" ")[1]));
			}
			reader.close();
		} catch (Exception ex) {
			System.out.print("File was not found");
		}

	}
     
       private double find_median(ArrayList<Integer> list)
       {
           int k =(int)Math.floor( list.size()/2);
       
           double med1 = fastSelect(list,k);
           double med2 = fastSelect(list,k-1);
         
         
           
           double actual_mid = 0;
           if(list.size()%2==0)
           {
              
               actual_mid = (int)Math.floor(med1+med2)/2;
           }
           else
               actual_mid = fastSelect(list,k-1);
           return actual_mid;
               
       }
	public static int fastSelect(ArrayList<Integer> list, int k)
	{
	
		while(!list.isEmpty()){
			
			int count = 0;
			int pivot = list.get(list.size()/2); 
			ArrayList<Integer> smallestList = new ArrayList<Integer>();
        	ArrayList<Integer> largestList = new ArrayList<Integer>();
			
        	for(Integer l : list){
                    if(l<pivot)
                        smallestList.add(l);
                    else if(l>pivot)
                        largestList.add(l);
                    else
                        count++;
                }
        	
        	
        	
        	int m = smallestList.size();
        	
        	if(k >= m && k < m + count){
        		return pivot;
        	}
        	
        	if(m > k){
        		list = smallestList;
        	}
        	else{
        		k = (k - m -count);
        		list = largestList;
        	}
		}
		return 0;
        }
	public void findFastest()
        {
            double var = find_median(list);
            System.out.println();
            System.out.print(var);
            
        }
        public static void main(String []args)
        {
            FindFast fast = new FindFast();
            fast.populate("DataSet.txt");
            fast.findFastest();
            
        }
}