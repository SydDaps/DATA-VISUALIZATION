import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class PieChart extends JPanel {
	Random rand = new Random();

	public static int[] values =  new int[100];
	public static String[] label = new String[100];
	int start = 0;
	static Home data = new Home();
	 int rows = 0;
	int startx = 0;
	int starty = 0;
	
	
	JPanel panel = new JPanel();
	public static void main(String[] args) {
       
		 int[] values = new int[100];
		 String[] label = new String[100];
	     data.setData(values, label);
	     
		 JFrame myField = new JFrame();
	     myField.setSize(1000, 800);
	     myField.setVisible(true);
	     myField.getContentPane().add(new PieChart(values,label, 4));
	     myField.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  

	}
	
	public PieChart(int[] values,String[] label,int rows) {
		this.values = values;
		this.label = label;
		this.rows  = rows;
		
		setBackground(new Color(248, 248, 255));
		setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBackground(new Color(248, 248, 255));
		panel.setBounds(300, 100, 500, 500);
		add(panel);
		
	}
	
	
	@Override
	public void paint(Graphics g) {
	      drawPie((Graphics2D) g, panel.getBounds());
	   }
	   void drawPie(Graphics2D g, Rectangle area) {
	      double total = 0.0D;
	      for (int i = 0; i < values.length; i++) {
	         total += values[i];
	      }
	      double curValue = 0.0D;
	      int startAngle = 0;
	      startx = 100;
	      starty = 200;
	      for (int i = 0; i < rows; i++) {
	         startAngle = (int) (curValue * 360 / total);
	         int arcAngle = (int) (values[i] * 360 / total);
				float r = rand.nextFloat();
				float gg = rand.nextFloat();
				float b = rand.nextFloat();
				Color randomColor = new Color(r, gg, b);
				g.setColor(randomColor);
        
	         g.fillArc(area.x, area.y, area.width, area.height, 
	         startAngle, arcAngle);
	         curValue += values[i];  
	         
	         g.fillRect(startx, starty, 50, 20);
	         g.setColor(Color.black);
	         g.drawString(label[i], startx+55, starty+15);
	         starty += 30;
	      }
	   }

}
