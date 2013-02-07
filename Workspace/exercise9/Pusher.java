/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package exercise9;

/**
 *
 * @author student
 */
public class Pusher extends Thread{

  Stack ref;

    public Pusher(Stack ref)
    {
        this.ref =ref;
    }

    @Override
    public void run() {

    for(int i=0; i<10; i++)
        {   this.ref.push(i);
        }
    }
   
}
