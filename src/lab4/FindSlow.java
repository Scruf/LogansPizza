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
import java.util.Map;
public class FindSlow {
  ArrayList<Integer> list;
    public FindSlow(){
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
    public void findSlow()
    {
       
      int j;                    
     int key;              
     int i;  

     for (j = 1; j < list.size(); j++)   
    {
           key = list.get(j);
           for(i = j - 1; (i >= 0) && (list.get(i)< key); i--)   
          {
              list.set(i+1, list.get(i));
                
          }
           list.set(i+1, key);

     }
      Collections.reverse(list);
      int median = 0;
      int sum = 0;
     if(list.size()%2==0)
     {
        
         median = list.get(list.size()/2);
        
         for(int x=0;x<list.size();x++)
         {
            
             if(x!=list.size()/2+1)

             {
                 int diff =0; 
                 if(median>list.get(x))
                     diff=median-list.get(x);
                 else
                     diff=list.get(x)-median;
                  
                 sum+=diff;
             }
         }
             
     }
     else
             {
                   
                 median = list.get(list.size()/2+1);
               for(int x=0;x<list.size();x++)
                   
         {
           
             if(x!=list.size()/2 &&  x!=list.size()/2+1 && x!=list.size()/2-1)
                {
                 int diff =0; 
                 if(median>list.get(x))
                     diff=median-list.get(x);
                 else
                     diff=list.get(x)-median;
              
                 sum+=diff;
             }
         
            
               
         }
              }
              System.out.print("Optimal store location: "+median+"\n");
              System.out.print("Sum of distances: "+sum+"\n");
              System.out.print("Elapsed time: "+System.currentTimeMillis()+"\n");
    }
}
