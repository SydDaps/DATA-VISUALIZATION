

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JSeparator;
import javax.swing.SwingConstants;



public class lineGraph extends JPanel {
    
	public static int[] values =  new int[100];
	public static String[] label = new String[100];
	 int x =0;
	 int size =0;
	 int rows = 0;
	 Random rand = new Random();
	 static Home data = new Home();
	public static void main(String[] args) {
		 int[] values = new int[100];
		 String[] label = new String[100];
	     data.setData(values, label);
		 JFrame myField = new JFrame();
	     myField.setSize(1000, 800);
	     myField.setVisible(true);
	    
	     
	     myField.getContentPane().add(new lineGraph(values,label, 7));
	     myField.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
        
	}
	
	
	
	
	public lineGraph(int[] values,String[] label,int rows) {
		this.values = values;
		this.label = label;
		this.rows  = rows;
		setBackground(new Color(248, 248, 255));
		setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setLayout(null);
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		
		Graphics2D g2 = (Graphics2D) g;
		Font font = new Font("Arial", Font.PLAIN, 25);    
		AffineTransform affineTransform = new AffineTransform();
		affineTransform.rotate(Math.toRadians(55), 0, 0);
		Font rotatedFont = font.deriveFont(affineTransform);
		g2.setFont(rotatedFont);
		int t = 0;
		int s1 = 605;
		int s2 = 600;
		for(int a =0 ; a < 11; a++) {
			g.setFont(new Font("Arial", Font.PLAIN, 15));
			g.drawString(""+t, 30, s1);
			g.fillRect(100, s2, 800, 1);
		t += 1000;
		s1 -= 50;
		s2 -= 50;
		
	}
		
				
	
		

	 x = 150;
	 size = rows ;
	for(int a = 0; a < rows  ;a++) {
		Double y1 = (double) (600-(values[a]/20));
		Double y2 = (double) (600-(values[a+1]/20));
		g.setColor(new Color(255, 160, 122));
		
		g2.setStroke(new BasicStroke(3));
		g2.draw(new Line2D.Double(x,y1, x+50, y2));
		g.fillOval(x-5,600-(values[a]/20) -5, 10, 10); 
		
		
		g.setColor(Color.black);
		g2.setFont(rotatedFont);
    	g2.drawString(label[a],x,610);
    	if(size - a == 1) {
    	g.setColor(new Color(255, 160, 122));
    	g.fillOval((x-5)+50,600-(values[a+1]/20) -5, 10, 10); 	
    	
    	g.setColor(Color.black);
    	g2.drawString(label[a+1],x+50,610);
    	}
    	x += 50; 
	}
	
	
}
	
	
	
}
