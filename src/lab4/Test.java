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
public class Test {
    public static void main(String []args)
    {
        FindSlow slow = new FindSlow();
        slow.populate("DataSet.txt");
        slow.findSlow();
    }
}
