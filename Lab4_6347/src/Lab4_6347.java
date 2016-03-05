import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Lab4_6347 extends JFrame {
	
	    public Lab4_6347(){
	        super("Lab 4");
	        ScreenSaver saver = new ScreenSaver();
	        setLayout(new BorderLayout());
	        add(saver, BorderLayout.CENTER);
	    }//end of Constructor
	    
	   class ScreenSaver extends JPanel implements ActionListener, MouseWheelListener{
		   
	        private int x[] = new int[60];
	        private int y[] = new int[60];
	      
	        private int numOfLines = 0;
	        private int radius = 10;
	        private int delay = 1000;
	        private Timer timer = null; 
	    
	        public ScreenSaver(){
	            timer = new Timer(1000, this);
	            timer.start();
	            timer.addActionListener(this);
	        }
	        
	        @Override
	        public void actionPerformed(ActionEvent e){
	        	
	        	if(numOfLines<60){
	            double maxX = getSize(null).getWidth();
	            double maxY = getSize(null).getHeight();
	            
	            //Divided the both centerX and centerY in order to start from the center
	            
	            int centerX = (int) maxX/2;
	            int centerY = (int) maxY/2;
	            double x = centerY + radius * Math.cos(numOfLines * Math.PI/6);
	            double y = centerX + radius * Math.sin(numOfLines * Math.PI/6);
	            radius += 1;
	            this.x[numOfLines] = (int) x;
	            this.y[numOfLines] = (int) y;
	            numOfLines++;
	        	}else if(numOfLines == 60){
	                numOfLines = 0;
	                radius = 10;
	                repaint();
	        	}
	            repaint();
	            
	        }//end of actionPerformed method
	        
	        public void paintComponent(Graphics g){
	        
	            super.paintComponents(g);
	            g.clearRect(0,0,(int)getSize().getWidth(),((int)getSize().getHeight()));
	            g.setColor(Color.BLUE);
	            g.drawPolyline(x, y, numOfLines-1);
	            
	        }//end of paintComponent method

	        @Override
	        public void mouseWheelMoved(MouseWheelEvent e) {
	          
	        }
	    }// end of Inner class

	    public static void main(String[] args){
	    	
	        Lab4_6347 lab4 = new Lab4_6347();
	        lab4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        lab4.setSize(200, 210);
	        lab4.setResizable(true);
	        lab4.setVisible(true);
	        
	    }//end of Main Method
}//end of class Lab4_5347
