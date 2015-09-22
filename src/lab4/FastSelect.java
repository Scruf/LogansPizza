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

public class FastSelect {
ArrayList<Integer> list;
    public FastSelect(){
        list = new ArrayList<Integer>();
    }
    public void populate(String name) 
    {
       
        try{
        String dummy= " ";
        BufferedReader reader = new BufferedReader(new FileReader(name));
        while((dummy=reader.readLine())!=null)
        {
           list.add(Integer.parseInt(dummy.split(" ")[1]));
        }
        reader.close();
     }catch(Exception ex)
     {
         System.out.print("File was not found");
     }
    
    }
    private int fastSelect(ArrayList<Integer> list, int number)
    {
         ArrayList<Integer> smallestList = new ArrayList<Integer>();
            ArrayList<Integer> largestList = new ArrayList<Integer>();
           
            
                
        while(!list.isEmpty())
        {
            try {
    Thread.sleep(2000);                 //1000 milliseconds is one second.
} catch(InterruptedException ex) {
    Thread.currentThread().interrupt();
}
          int pivot = list.size()/2;
          int count = 0;
            for(Integer l : list)
            {
              if(pivot==l)
                  count++;
                if(l<pivot)
                    smallestList.add(l);
                else
                    largestList.add(l);
                    
            }
            System.out.print(" the size of the smallest "+smallestList.size());
            System.out.println();
            System.out.print("the size of the largesr is " +largestList.size());
            if (number>=smallestList.size() && number<smallestList.size()+count)
            {
                System.out.print("Pivot is "+pivot);
                System.out.println();
                return pivot;
            }
                
            else if (smallestList.size()>number)
            {
          
              System.out.print(" Size of the smalles in else if "+smallestList.size());
              System.out.println();
              System.out.print("Number is"+number);
              System.out.println();
              list.clear();
              
              for(Integer l : smallestList)
              {
                  list.add(l);
                  
              }
              System.out.print(smallestList);
              System.out.println();
              System.out.print("----------------------------");
              System.out.print(list);
              smallestList.clear();
             
            }
            else{
                System.out.print(" Size of the smalles in else "+smallestList.size());
              System.out.println();
                number = number - smallestList.size() - count;
                  list.clear();
                  System.out.print("Number in another else is "+number);
                  System.out.println();
              for(Integer i : largestList)
                  list.add(i);
              largestList.clear();
            
            }
            
        }
        return 0;
       
    }
    public void finFastest(int number)
    {
        System.out.print(fastSelect(list,number));
    }
}