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

public class FindSlow {
  ArrayList<Integer> list;
    public FindSlow(){
        list = new ArrayList<Integer>();
    }
    public void populate(String name) 
    {
        System.out.print("Populating the file");
       
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
     long begining = System.currentTimeMillis();
     for (j = 1; j < list.size(); j++)   
    {
           key = list.get(j);
           for(i = j - 1; (i >= 0) && (list.get(i)> key); i--)   
          {
              list.set(i+1, list.get(i));
                
          }
           list.set(i+1, key);

     }
     long end = System.currentTimeMillis();
    System.out.print(list);
    System.out.println();
      int median = 0;
      int sum = 0;
     if(list.size()%2==0)
     {
       
         int  leftMid =(list.size()/2)-1 ;
         
         int righMid =list.size()/2;
         
         double  temp = (leftMid+righMid)/2;
        
         median = list.get((int) Math.floor(temp));
         int val = (median+list.get((int) Math.floor(temp)+1))/2;
         System.out.print(" "+val+" "+list.get((int) Math.floor(temp)+1));
         median = val;
         for (Integer l : list)
             sum+=Math.abs(median-l);
         
       
             
     }
     else
             {
                   
                 median = list.get((int)(Math.ceil(list.size()/2)));
               for(int x=0;x<list.size();x++)
                   
         {
           
           
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
    public static void main(String []args)
    {
        FindSlow slow = new FindSlow();
        slow.populate("DataSet.txt");
        slow.findSlow();
    }
}
