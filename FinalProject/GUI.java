
import javax.swing.JFrame;

/**
 * Write a description of class GUI here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GUI
{
    // instance variables - replace the example below with your own
    public static void main (String[] args){
    JFrame frame = new JFrame("DogMeetsAnotherDog");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //GUIPanel panel = new GUIPanel();
    
    frame.getContentPane().add(new GUIPanel());
    
    frame.pack();
    frame.setVisible(true);
    }
}
