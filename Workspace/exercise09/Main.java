/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package exercise9;

/**
 *
 * @author student
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

    	 Stck stack = new Stack(25);
    	 int last;
         stack.push(4);
         stack.push(3);
         stack.push(8);
         stack.push(1);
         stack.push(9);
         stack.push(10);
         while (last!=-1) {
            int elem = stack.pop();
            System.out.print(elem);
         }
 
      
    }

}
