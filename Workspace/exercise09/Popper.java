/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package exercise9;

/**
 *
 * @author student
 */
public class Popper extends Thread {
    Stack ref;

    public Popper(Stack ref)
    {
        this.ref =ref;
    }

    @Override
    public void run() {

        while(ref.last!=-1)
        {
            this.ref.pop();
        }
    }



}
