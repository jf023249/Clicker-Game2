package clickGame;

import java.lang.Math;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollBar;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

//Add functions called by buttons




//__________________________________________________________________________________________________

public class ClickGame {

	public int money = 0;
	public boolean flag = false;
	int multiplier = 1;
	public boolean flag2 = false;
	public int fifteenCount = 0;
	public int fiveCount = 0;
	public int oneCount = 0;
	
	
	
	
	
	
	private static JFrame frame;
	private static JTextField textField;
	private static JTextArea textArea;
	private static JScrollBar sb;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClickGame window = new ClickGame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	public ClickGame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 568, 523);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnAdd = new JButton("Add 1");
		btnAdd.setBounds(17, 296, 209, 158);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddOne add = new AddOne();
				add.start();
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnAdd);
		
		JButton btnAddEvery = new JButton("1");
		btnAddEvery.setBounds(225, 0, 63, 39);
		btnAddEvery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddOnePerSec persec = new AddOnePerSec();
				persec.start();
			}
		});
		
		JButton btnAdd5Every = new JButton("5");
		btnAdd5Every.setBounds(225, 51, 63, 39);
		btnAdd5Every.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddFivePerSec fivepersec = new AddFivePerSec();
				fivepersec.start();
			}
		}); 
		
		JButton btnAdd15Every = new JButton("15");
		btnAdd15Every.setBounds(225, 102, 63, 39);
		btnAdd15Every.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddFifteenPerSec fifteenpersec = new AddFifteenPerSec();
				fifteenpersec.start();
			}
		}); 
		
		
		
		frame.getContentPane().add(btnAddEvery);
		frame.getContentPane().add(btnAdd5Every);
		frame.getContentPane().add(btnAdd15Every);
		
		textField = new JTextField();
		textField.setBounds(0, 0, 226, 39);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setEditable(false);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(17, 51, 190, 230);
		frame.getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(324, 37, 209, 413);
		frame.getContentPane().add(textArea_1);
		textArea_1.setEditable(false);
		
		textArea_1.append("Prices: \n ------------ \n Ones: 50 \n Fives: 250 \n Fifteens: 3000 ");
		
		
		sb = scrollPane.getVerticalScrollBar();
		
		
		Update update = new Update();
		RandomBoost random = new RandomBoost();
		random.start();
		update.start();
		
		flag = false;
		
			
		}
	
	class Update extends Thread{
		public void run() {
			int loop = 1;
			while(loop == 1)
			{
			textField.setText("Money: $" + String.valueOf(money));
			}
		}
	}
	
	class AddOne extends Thread{
		
		
		public void run() {
			try {
				money += multiplier;	
				sb.setValue( sb.getMaximum() );

			}
			catch(Exception e){
				System.out.println("The exceptions are: " + e);
			}
		}
	}

	class AddOnePerSec extends Thread{
		public boolean wait = false;
		public void run() {
			try {
					if((money-50) >=0)
					{
					money-=50;
					oneCount++;
					textArea.append("You now have " + oneCount + " ones. \n");
					sb.setValue( sb.getMaximum() );
					while(1==1)
					{
						money = money + multiplier;
						Thread.sleep(1000);
					}
					}
					else
					{
						textArea.append("Not enough money to buy that. \n");

					}
				
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}
	
	class AddFivePerSec extends Thread{
		public boolean wait = false;
		public void run() {
			try {
					if((money-250) >=0)
					{
					money-=250;
					fiveCount++;
					textArea.append("You now have " + fiveCount + " fives. \n");
					sb.setValue( sb.getMaximum() );
					while(1 == 1)
					{
						money = money + multiplier;
						Thread.sleep(200);
					}
					}
					else
					{
						textArea.append("Not enough money to buy that. \n");
					}
				
					
			}
			catch(Exception e){
				e.printStackTrace();
				}
		}
		
	}
	
	class AddFifteenPerSec extends Thread{
		public void run() {
			try {
				if((money-3000) >=0)
				{
				money-=3000;
				fifteenCount++;
				textArea.append("You now have " + fifteenCount + " fifteens. \n");
				sb.setValue( sb.getMaximum() );
				while(1==1)
				{
					money = money + multiplier;
					Thread.sleep(66);
				}
				}
				else
				{
					textArea.append("Not enough money to buy that. \n");
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}
	
	class RandomBoost extends Thread{
		public void run() {
			System.out.println("random working");
			try {
				int loop = 1;
			while (loop == 1)
			{
		double random = Math.random();
		if(random <= .2) {
			multiplier = 15;
			textArea.append("Multiplier boost engaged!\n Click Click Click!!! \n");
			sb.setValue( sb.getMaximum() );
			Thread.sleep(10000);
			multiplier = 1;
			textArea.append("Boost over.");
		}
		else {
			Thread.sleep(30000);
		}
		}
		}
		catch(Exception e) {e.printStackTrace();}
	}
	}
}

