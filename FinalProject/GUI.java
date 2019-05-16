
import javax.swing.JFrame;

/**
 * GUI runs the graphical interface for the DogMeetsAnotherDog application.
 *
 * @author (Willa Sun, Shirley Lei, Emily Yin)
 * @version (May 15th, 2019)
 */
public class GUI
{
    public static void main (String[] args){
        //create frame, called DogMeetsAnotherDog
        JFrame frame = new JFrame("DogMeetsAnotherDog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Add GUI Panel to frame
        frame.getContentPane().add(new GUIPanel());
        frame.pack();
        frame.setVisible(true);
    }
}
