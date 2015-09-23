/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

/**
 *
 * @author Egor Aliaksander Kozitski
 * @param list -> will hold a list of integers on which finding median
 * Sort the distances and choose the location of the middle element 
 * (if the number of elements is even, choose the midpoint between the two middle elements)
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

public class FindSlow {
    /*
    *Creating a reference to a list
    */
  ArrayList<Integer> list;
    public FindSlow(){
        //initializing the list
        list = new ArrayList<Integer>();
    }
    /*
    *@method void populate will read information from a file and populate a list.
     * method populate will take string as its argument
    *@param name will hold the name of the file
    */
    public void populate(String name) 
    {
       
       /*
        * @param reader will read the file into the string 
        */
        try{
        String dummy= " ";
        BufferedReader reader = new BufferedReader(new FileReader(name));
        while((dummy=reader.readLine())!=null)
        {
            // list will take a string and split by space and take the second element and parsing it 
            //to an integer
           list.add(Integer.parseInt(dummy.split(" ")[1]));
        }
        reader.close();
     }catch(Exception ex)
     {
         System.out.print("File was not found");
     }
    
    }
    /*
    *@method findSlow() will sort the list by using insertion sort
    1* and it will find the median 
    */
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
    
    
      int median = 0;
      int sum = 0;
      /*
      *if statment will check  if the size of list is odd or even
      *  if the size is even then the middle is between twom mid points
      *     otherwise the middlepoint is in the middle
      *@param leftMid will hold the index of the list/2 -1 
      *@param righMid will hold the index of the list /2
      *@param temp  will find the middle of the list
      *@param val will calculate the meian distance
      */
     if(list.size()%2==0)
     {
       
         int  leftMid =(list.size()/2)-1 ;
         
         int righMid =list.size()/2;
         
         double  temp = (leftMid+righMid)/2;
        
         median = list.get((int) Math.floor(temp));
         int val = (median+list.get((int) Math.floor(temp)+1))/2;
      
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
      long end = System.currentTimeMillis();
      long differ = end - begining;
              System.out.print("Optimal store location: "+median+"\n");
              System.out.print("Sum of distances: "+sum+"\n");
              System.out.print("Elapsed time: "+differ+"\n");
    }
    public static void main(String []args)
    {
        FindSlow slow = new FindSlow();
        slow.populate("DataSet.txt");
        slow.findSlow();
    }
}
