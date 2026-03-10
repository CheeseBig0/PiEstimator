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
		
		ThreadRunner NewRunner = new ThreadRunner();
		NewRunner.start();
		NewRunner.running = false;
		System.out.println("letting it run");
		

		runButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NewRunner.running = !NewRunner.running;
				System.out.println(runButton.getText());
				if(NewRunner.running) {
					runButton.setText("Pause");
				} else {
					runButton.setText("Continue");
				}

				synchronized(NewRunner) {
					NewRunner.notify();
				}
			}
		});
		
	}

	public static class ThreadRunner extends Thread {

		boolean running;
		public void run() {

			double isLess = 0;
			double trials = 0;

			while(true) {
				synchronized(this) {
					while(!running) {
						try {
							wait();
						}
						catch(InterruptedException e) {}
					}
				}

				

				for(int i=0; i<1000000; i++) {
					double x = Math.random();
					double y = Math.random();
					if(x*x + y*y < 1) {
						isLess++;
					}
					trials++;
					//System.out.println("Less than 1: " + isLess);
				}
				double estimate = 4*(double)isLess/trials;
				System.out.println("Trials: " + Math.round(trials));
				System.out.println("Estimate: "+estimate);
				
			}
		}
	}

	
	

	

}


