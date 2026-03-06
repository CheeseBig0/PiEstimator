import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PiEstimator{
//the following code is just to jog your memory about how labels and buttons work!
//implement your Pi Estimator as described in the project. You may do it all in main below or you 
//may implement additional functions if you feel it necessary.
	
public static void main(String[] args) {  
	    JFrame f=new JFrame("Pi Estimator");  
	    JButton runButton=new JButton("Start");  
		f.add(runButton);
	    //JLabel example = new JLabel(Double.toString(Math.PI));
	    //f.add(example);
	      
	    f.setSize(300,300);  
	    f.setLayout(new GridLayout(4, 1));  
	    f.setVisible(true);
		
		runButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(runButton.getText() == "Pause") {
					runButton.setText("Continue");
				} else { runButton.setText("Pause"); }
			}
		});

	} 

	public void run() {
		
	}
}


