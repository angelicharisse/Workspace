/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package exercise9;


/**
 *
 * @author student
 */
public class Stack {

    int size = 25;
    int last;
    int[] Stck;
    public Stack(int size)
    {
       Stck = new int[size];
       last = -1;
    }

    void push(int x)
    {
      if(last<size){
        Stck[last]=x;
        last++;
      }
    }

    int pop()
    {
        int retval=-1;

          if(last!=-1){
             retval = Stck[last];
            last--;
          }
        return retval;
    }
}
