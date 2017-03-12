package com.TicTac;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class Home extends JFrame {

	/**
	 * 
	 */
	String p1,p2;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JButton btn7,btn6,btn5,btn4,btn3,btn2,btn1,btn8,btn9; 
	String X="X",O="O";
	boolean p=true;
	String cur="";
	private JPanel panel2;
	private JPanel panel;
	private JTextField tf1;
	private JTextField tf2;
	private JButton btnPlay;
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	private JLabel lblNone;
	private JTextPane txtpnEnterThePlayer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new MetalLookAndFeel());
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 441, 333);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		contentPane.setLayout(new GridLayout(1,0,0,0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(250, 128, 114));
		contentPane.add(tabbedPane);
		
		tabbedPane.addChangeListener(new ChangeListener(){

			@Override
			public void stateChanged(ChangeEvent e) {
				if (((JTabbedPane)e.getSource()).getSelectedIndex()==0){
					Home.this.setSize(new Dimension(320,365));
					Home.this.setLocationRelativeTo(null);
					Home.this.setResizable(false);
				}
				else if (((JTabbedPane)e.getSource()).getSelectedIndex()==1){
					if (tf1.getText().equals("") || tf2.getText().equals("")) {
						tabbedPane.setSelectedIndex(0);
						JOptionPane.showMessageDialog(null, "Please Enter Player Name!");
					}
					else
					Home.this.setResizable(true);
				}
			}
			
		});
		
		panel2 = new JPanel();
		tabbedPane.addTab("SETTINGS", panel2);
		panel2.setPreferredSize(new Dimension(300,300));
		SpringLayout sl_panel2 = new SpringLayout();
		panel2.setLayout(sl_panel2);
		
		JLabel lblPlayer = new JLabel("Player 1 :");
		sl_panel2.putConstraint(SpringLayout.NORTH, lblPlayer, 120, SpringLayout.NORTH, panel2);
		sl_panel2.putConstraint(SpringLayout.WEST, lblPlayer, 26, SpringLayout.WEST, panel2);
		lblPlayer.setFont(new Font("Maiandra GD", Font.PLAIN, 20));
		panel2.add(lblPlayer);
		
		JLabel lblPlayer_1 = new JLabel("Player 2 :");
		sl_panel2.putConstraint(SpringLayout.NORTH, lblPlayer_1, 155, SpringLayout.NORTH, panel2);
		sl_panel2.putConstraint(SpringLayout.WEST, lblPlayer_1, 26, SpringLayout.WEST, panel2);
		sl_panel2.putConstraint(SpringLayout.SOUTH, lblPlayer, -10, SpringLayout.NORTH, lblPlayer_1);
		lblPlayer_1.setFont(new Font("Maiandra GD", Font.PLAIN, 20));
		panel2.add(lblPlayer_1);
		
		tf1 = new JTextField();
		tf1.setFont(new Font("Maiandra GD", Font.PLAIN, 15));
		sl_panel2.putConstraint(SpringLayout.EAST, lblPlayer, -15, SpringLayout.WEST, tf1);
		sl_panel2.putConstraint(SpringLayout.NORTH, tf1, 0, SpringLayout.NORTH, lblPlayer);
		sl_panel2.putConstraint(SpringLayout.WEST, tf1, 134, SpringLayout.WEST, panel2);
		sl_panel2.putConstraint(SpringLayout.EAST, tf1, -20, SpringLayout.EAST, panel2);
		tf1.setPreferredSize(new Dimension(100, 10));
		panel2.add(tf1);
		tf1.setColumns(10);
		
		tf2 = new JTextField();
		tf2.setFont(new Font("Maiandra GD", Font.PLAIN, 15));
		sl_panel2.putConstraint(SpringLayout.NORTH, tf2, 160, SpringLayout.NORTH, panel2);
		sl_panel2.putConstraint(SpringLayout.SOUTH, tf1, -13, SpringLayout.NORTH, tf2);
		sl_panel2.putConstraint(SpringLayout.WEST, tf2, 135, SpringLayout.WEST, panel2);
		sl_panel2.putConstraint(SpringLayout.EAST, lblPlayer_1, -16, SpringLayout.WEST, tf2);
		sl_panel2.putConstraint(SpringLayout.EAST, tf2, -20, SpringLayout.EAST, panel2);
		panel2.add(tf2);
		tf2.setColumns(10);
		
		btnPlay = new JButton("PLAY");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p1=tf1.getText();
				p2=tf2.getText();
				if (p1.equals("") || p2.equals("")){
					tabbedPane.setSelectedIndex(0);
					Home.this.setResizable(false);
					JOptionPane.showMessageDialog(null, "Please Enter Player Name!");
				}
				else {
					tabbedPane.setSelectedIndex(1);
					if(p==true)
						lblNone.setText(p1+"'s Turn");
					else
						lblNone.setText(p2+"'s Turn");
				}
			}
		});
		sl_panel2.putConstraint(SpringLayout.SOUTH, tf2, -25, SpringLayout.NORTH, btnPlay);
		sl_panel2.putConstraint(SpringLayout.SOUTH, lblPlayer_1, -17, SpringLayout.NORTH, btnPlay);
		sl_panel2.putConstraint(SpringLayout.NORTH, btnPlay, 213, SpringLayout.NORTH, panel2);
		sl_panel2.putConstraint(SpringLayout.WEST, btnPlay, 45, SpringLayout.WEST, panel2);
		sl_panel2.putConstraint(SpringLayout.EAST, btnPlay, -162, SpringLayout.EAST, panel2);
		btnPlay.setFont(new Font("Maiandra GD", Font.PLAIN, 20));
		btnPlay.setForeground(new Color(255, 255, 255));
		btnPlay.setBackground(new Color(250, 128, 114));
		btnPlay.setFocusPainted(false);
		btnPlay.setMaximumSize(new Dimension(50,50));
		panel2.add(btnPlay);
		
		
		lblNewLabel = new JLabel("Status :");
		sl_panel2.putConstraint(SpringLayout.SOUTH, btnPlay, -4, SpringLayout.NORTH, lblNewLabel);
		sl_panel2.putConstraint(SpringLayout.WEST, lblNewLabel, 23, SpringLayout.WEST, panel2);
		sl_panel2.putConstraint(SpringLayout.EAST, lblNewLabel, -211, SpringLayout.EAST, panel2);
		sl_panel2.putConstraint(SpringLayout.NORTH, lblNewLabel, -42, SpringLayout.SOUTH, panel2);
		sl_panel2.putConstraint(SpringLayout.SOUTH, lblNewLabel, -2, SpringLayout.SOUTH, panel2);
		lblNewLabel.setFont(new Font("Maiandra GD", Font.PLAIN, 20));
		panel2.add(lblNewLabel);
		
		btnNewButton = new JButton("RESET");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p=true;
				cur="";
				btn1.setText("");
				btn2.setText("");
				btn3.setText("");
				btn4.setText("");
				btn5.setText("");
				btn6.setText("");
				btn7.setText("");
				btn8.setText("");
				btn9.setText("");
			}
		});
		sl_panel2.putConstraint(SpringLayout.NORTH, btnNewButton, 25, SpringLayout.SOUTH, tf2);
		btnNewButton.setFocusPainted(false);
		sl_panel2.putConstraint(SpringLayout.WEST, btnNewButton, 32, SpringLayout.EAST, btnPlay);
		sl_panel2.putConstraint(SpringLayout.EAST, btnNewButton, -37, SpringLayout.EAST, panel2);
		btnNewButton.setBackground(new Color(250, 128, 114));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Maiandra GD", Font.PLAIN, 20));
		panel2.add(btnNewButton);
		
		lblNone = new JLabel("None");
		sl_panel2.putConstraint(SpringLayout.SOUTH, btnNewButton, -7, SpringLayout.NORTH, lblNone);
		sl_panel2.putConstraint(SpringLayout.NORTH, lblNone, 6, SpringLayout.SOUTH, btnPlay);
		sl_panel2.putConstraint(SpringLayout.WEST, lblNone, 6, SpringLayout.EAST, lblNewLabel);
		sl_panel2.putConstraint(SpringLayout.SOUTH, lblNone, 0, SpringLayout.SOUTH, panel2);
		sl_panel2.putConstraint(SpringLayout.EAST, lblNone, -34, SpringLayout.EAST, panel2);
		lblNone.setFont(new Font("Maiandra GD", Font.PLAIN, 16));
		panel2.add(lblNone);
		
		txtpnEnterThePlayer = new JTextPane();
		sl_panel2.putConstraint(SpringLayout.NORTH, txtpnEnterThePlayer, 10, SpringLayout.NORTH, panel2);
		sl_panel2.putConstraint(SpringLayout.WEST, txtpnEnterThePlayer, 10, SpringLayout.WEST, panel2);
		sl_panel2.putConstraint(SpringLayout.EAST, txtpnEnterThePlayer, 290, SpringLayout.WEST, panel2);
		txtpnEnterThePlayer.setForeground(new Color(255, 255, 255));
		txtpnEnterThePlayer.setBackground(new Color(250, 128, 114));
		txtpnEnterThePlayer.setFont(new Font("Maiandra GD", Font.PLAIN, 14));
		txtpnEnterThePlayer.setEditable(false);
		txtpnEnterThePlayer.setText("Enter the Player names and click the 'PLAY' button to start the game. To reset the game at any time, click the 'RESET' button. Status is continuously shown on the status bar.");
		sl_panel2.putConstraint(SpringLayout.SOUTH, txtpnEnterThePlayer, 107, SpringLayout.NORTH, panel2);
		panel2.add(txtpnEnterThePlayer);
		pack();
		
		
		panel = new JPanel();
		tabbedPane.addTab("GAME", panel);
		panel.setLayout(new GridLayout(3,3));
		
		tabbedPane.setForeground(Color.WHITE);
		
		tabbedPane.setFocusable(false);
		
		btn7 = new JButton("");
		btn7.setForeground(Color.WHITE);
		btn7.setFont(new Font("Malgun Gothic", Font.PLAIN, 50));
		btn7.setFocusPainted(false);
		btn7.setBorder(new BevelBorder(1,Color.WHITE,Color.WHITE));
		btn7.setBackground(new Color(250, 128, 114));
		panel.add(btn7);
		
		btn5 = new JButton("");
		btn5.setForeground(Color.WHITE);
		btn5.setFont(new Font("Malgun Gothic", Font.PLAIN, 50));
		btn5.setFocusPainted(false);
		btn5.setBorder(new BevelBorder(1,Color.WHITE,Color.WHITE));
		btn5.setBackground(new Color(250, 128, 114));
		panel.add(btn5);
		
		btn4 = new JButton("");
		btn4.setForeground(Color.WHITE);
		btn4.setFont(new Font("Malgun Gothic", Font.PLAIN, 50));
		btn4.setFocusPainted(false);
		btn4.setBorder(new BevelBorder(1,Color.WHITE,Color.WHITE));
		btn4.setBackground(new Color(250, 128, 114));
		panel.add(btn4);
		
		btn3 = new JButton("");
		btn3.setForeground(Color.WHITE);
		btn3.setFont(new Font("Malgun Gothic", Font.PLAIN, 50));
		btn3.setFocusPainted(false);
		btn3.setBorder(new BevelBorder(1,Color.WHITE,Color.WHITE));
		btn3.setBackground(new Color(250, 128, 114));
		panel.add(btn3);
		
		btn2 = new JButton("");
		btn2.setForeground(Color.WHITE);
		btn2.setFont(new Font("Malgun Gothic", Font.PLAIN, 50));
		btn2.setFocusPainted(false);
		btn2.setBorder(new BevelBorder(1,Color.WHITE,Color.WHITE));
		btn2.setBackground(new Color(250, 128, 114));
		panel.add(btn2);
		
		btn1 = new JButton("");
		btn1.setForeground(Color.WHITE);
		btn1.setFont(new Font("Malgun Gothic", Font.PLAIN, 50));
		btn1.setFocusPainted(false);
		btn1.setBorder(new BevelBorder(1,Color.WHITE,Color.WHITE));
		btn1.setBackground(new Color(250, 128, 114));
		panel.add(btn1);
		
		btn6 = new JButton("");
		btn6.setForeground(Color.WHITE);
		btn6.setFont(new Font("Malgun Gothic", Font.PLAIN, 50));
		btn6.setFocusPainted(false);
		btn6.setBorder(new BevelBorder(1,Color.WHITE,Color.WHITE));
		btn6.setBackground(new Color(250, 128, 114));
		panel.add(btn6);
		
		btn8 = new JButton("");
		btn8.setForeground(Color.WHITE);
		btn8.setFont(new Font("Malgun Gothic", Font.PLAIN, 50));
		btn8.setFocusPainted(false);
		btn8.setBorder(new BevelBorder(1,Color.WHITE,Color.WHITE));
		btn8.setBackground(new Color(250, 128, 114));
		panel.add(btn8);
		
		btn9 = new JButton("");
		btn9.setForeground(Color.WHITE);
		btn9.setFont(new Font("Malgun Gothic", Font.PLAIN, 50));
		btn9.setFocusPainted(false);
		btn9.setBorder(new BevelBorder(1,Color.WHITE,Color.WHITE));
		btn9.setBackground(new Color(250, 128, 114));
		panel.add(btn9);
		pack();
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (p==true && btn7.getText().equals("")){
					btn7.setText(X);
					p=false;
					lblNone.setText(p2+"'s Turn");
				}
				else if (p==false && btn7.getText().equals("")){
					btn7.setText(O);
					p=true;
					lblNone.setText(p1+"'s Turn");
				}
				Home.this.run();
			}
		});
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (p==true && btn5.getText().equals("")){
					btn5.setText(X);
					p=false;
					lblNone.setText(p2+"'s Turn");
				}
				else if (p==false && btn5.getText().equals("")){
					btn5.setText(O);
					p=true;
					lblNone.setText(p1+"'s Turn");
				}
				Home.this.run();
			}
		});
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (p==true && btn4.getText().equals("")){
					btn4.setText(X);
					p=false;
					lblNone.setText(p2+"'s Turn");
				}
				else if (p==false && btn4.getText().equals("")){
					btn4.setText(O);
					p=true;
					lblNone.setText(p1+"'s Turn");
				}
				Home.this.run();
			}
		});
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (p==true && btn3.getText().equals("")){
					btn3.setText(X);
					p=false;
					lblNone.setText(p2+"'s Turn");
				}
				else if (p==false && btn3.getText().equals("")){
					btn3.setText(O);
					p=true;
					lblNone.setText(p1+"'s Turn");
				}
				Home.this.run();
			}
		});
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (p==true && btn2.getText().equals("")){
					btn2.setText(X);
					p=false;
					lblNone.setText(p2+"'s Turn");
				}
				else if(p==false && btn2.getText().equals("")) {
					btn2.setText(O);
					p=true;
					lblNone.setText(p1+"'s Turn");
				}
				Home.this.run();
			}
		});
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (p==true && btn1.getText().equals("")){
					btn1.setText(X);
					p=false;
					lblNone.setText(p2+"'s Turn");
				}
				else if (p==false && btn1.getText().equals("")) {
					btn1.setText(O);
					p=true;
					lblNone.setText(p1+"'s Turn");
				}
				Home.this.run();
			}
		});
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (p==true && btn6.getText().equals("")){
					btn6.setText(X);
					p=false;
					lblNone.setText(p2+"'s Turn");
				}
				else if (p==false && btn6.getText().equals("")){
					btn6.setText(O);
					p=true;
					lblNone.setText(p1+"'s Turn");
				}
				Home.this.run();
			}
		});
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (p==true && btn8.getText().equals("")){
					btn8.setText(X);
					p=false;
					lblNone.setText(p2+"'s Turn");
				}
				else if (p==false && btn8.getText().equals("")){
					btn8.setText(O);
					p=true;
					lblNone.setText(p1+"'s Turn");
				}
				Home.this.run();
			}
		});
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (p==true && btn9.getText().equals("")){
					btn9.setText(X);
					p=false;
					lblNone.setText(p2+"'s Turn");
				}
				else if (p==false && btn9.getText().equals("")){
					btn9.setText(O);
					p=true;
					lblNone.setText(p1+"'s Turn");
				}
				Home.this.run();
			}
		});
	}
	public void run(){
		cur = (btn7.getText().equals("X") || btn7.getText().equals("O"))? btn7.getText() : "";
		
		if (btn7.getText().equals(btn5.getText()) && btn7.getText().equals(btn4.getText()) && !cur.equals("")){
			if (cur.equals("X"))
				JOptionPane.showMessageDialog(null, p1+" wins!!",null,JOptionPane.INFORMATION_MESSAGE);
			else if (cur.equals("O"))
				JOptionPane.showMessageDialog(null, p2+" wins!",null,JOptionPane.INFORMATION_MESSAGE);
			cur="";
			btn1.setText("");
			btn2.setText("");
			btn3.setText("");
			btn4.setText("");
			btn5.setText("");
			btn6.setText("");
			btn7.setText("");
			btn8.setText("");
			btn9.setText("");
			p=true;
			lblNone.setText("Game Finished");
		}
		if (btn7.getText().equals(btn6.getText()) && btn7.getText().equals(btn3.getText()) && !cur.equals("")){
			if (cur.equals("X"))
				JOptionPane.showMessageDialog(null, p1+" wins!!",null,JOptionPane.INFORMATION_MESSAGE);
			else if (cur.equals("O"))
				JOptionPane.showMessageDialog(null, p2+" wins!",null,JOptionPane.INFORMATION_MESSAGE);
			cur="";
			btn1.setText("");
			btn2.setText("");
			btn3.setText("");
			btn4.setText("");
			btn5.setText("");
			btn6.setText("");
			btn7.setText("");
			btn8.setText("");
			btn9.setText("");
			p=true;
			lblNone.setText("Game Finished");
		}
		if (btn7.getText().equals(btn2.getText()) && btn7.getText().equals(btn9.getText()) && !cur.equals("")){
			if (cur.equals("X"))
				JOptionPane.showMessageDialog(null, p1+" wins!!",null,JOptionPane.INFORMATION_MESSAGE);
			else if (cur.equals("O"))
				JOptionPane.showMessageDialog(null, p2+" wins!",null,JOptionPane.INFORMATION_MESSAGE);
			cur="";
			btn1.setText("");
			btn2.setText("");
			btn3.setText("");
			btn4.setText("");
			btn5.setText("");
			btn6.setText("");
			btn7.setText("");
			btn8.setText("");
			btn9.setText("");
			p=true;
			lblNone.setText("Game Finished");
		}
		cur = (btn4.getText().equals("X") || btn4.getText().equals("O"))? btn4.getText() : "";
		if (btn4.getText().equals(btn1.getText()) && btn4.getText().equals(btn9.getText()) && !cur.equals("")){
			if (cur.equals("X"))
				JOptionPane.showMessageDialog(null, p1+" wins!!",null,JOptionPane.INFORMATION_MESSAGE);
			else if (cur.equals("O"))
				JOptionPane.showMessageDialog(null, p2+" wins!",null,JOptionPane.INFORMATION_MESSAGE);
			cur="";
			btn1.setText("");
			btn2.setText("");
			btn3.setText("");
			btn4.setText("");
			btn5.setText("");
			btn6.setText("");
			btn7.setText("");
			btn8.setText("");
			btn9.setText("");
			p=true;
			lblNone.setText("Game Finished");
		}
		if (btn4.getText().equals(btn2.getText()) && btn4.getText().equals(btn6.getText()) && !cur.equals("")){
			if (cur.equals("X"))
				JOptionPane.showMessageDialog(null, p1+" wins!!",null,JOptionPane.INFORMATION_MESSAGE);
			else if (cur.equals("O"))
				JOptionPane.showMessageDialog(null, p2+" wins!",null,JOptionPane.INFORMATION_MESSAGE);
			cur="";
			btn1.setText("");
			btn2.setText("");
			btn3.setText("");
			btn4.setText("");
			btn5.setText("");
			btn6.setText("");
			btn7.setText("");
			btn8.setText("");
			btn9.setText("");
			p=true;
			lblNone.setText("Game Finished");
		}
		cur = (btn5.getText().equals("X") || btn5.getText().equals("O"))? btn5.getText() : "";
		if (btn5.getText().equals(btn2.getText()) && btn5.getText().equals(btn8.getText()) && !cur.equals("")){
			if (cur.equals("X"))
				JOptionPane.showMessageDialog(null, p1+" wins!!",null,JOptionPane.INFORMATION_MESSAGE);
			else if (cur.equals("O"))
				JOptionPane.showMessageDialog(null, p2+" wins!",null,JOptionPane.INFORMATION_MESSAGE);
			cur="";
			btn1.setText("");
			btn2.setText("");
			btn3.setText("");
			btn4.setText("");
			btn5.setText("");
			btn6.setText("");
			btn7.setText("");
			btn8.setText("");
			btn9.setText("");
			p=true;
			lblNone.setText("Game Finished");
		}
		cur = (btn1.getText().equals("X") || btn1.getText().equals("O"))? btn1.getText() : "";
		if (btn1.getText().equals(btn2.getText()) && btn1.getText().equals(btn3.getText()) && !cur.equals("")){
			if (cur.equals("X"))
				JOptionPane.showMessageDialog(null, p1+" wins!!",null,JOptionPane.INFORMATION_MESSAGE);
			else if (cur.equals("O"))
				JOptionPane.showMessageDialog(null, p2+" wins!",null,JOptionPane.INFORMATION_MESSAGE);
			cur="";
			btn1.setText("");
			btn2.setText("");
			btn3.setText("");
			btn4.setText("");
			btn5.setText("");
			btn6.setText("");
			btn7.setText("");
			btn8.setText("");
			btn9.setText("");
			p=true;
			lblNone.setText("Game Finished");
		}
		cur = (btn9.getText().equals("X") || btn9.getText().equals("O"))? btn9.getText() : "";
		if (btn9.getText().equals(btn8.getText()) && btn9.getText().equals(btn6.getText()) && !cur.equals("")){
			if (cur.equals("X"))
				JOptionPane.showMessageDialog(null, p1+" wins!!",null,JOptionPane.INFORMATION_MESSAGE);
			else if (cur.equals("O"))
				JOptionPane.showMessageDialog(null, p2+" wins!",null,JOptionPane.INFORMATION_MESSAGE);
			cur="";
			btn1.setText("");
			btn2.setText("");
			btn3.setText("");
			btn4.setText("");
			btn5.setText("");
			btn6.setText("");
			btn7.setText("");
			btn8.setText("");
			btn9.setText("");
			p=true;
			lblNone.setText("Game Finished");
		}
		else if (!(btn1.getText().equals("") || btn2.getText().equals("") || btn3.getText().equals("") || btn4.getText().equals("") ||
				btn5.getText().equals("") || btn6.getText().equals("") || btn7.getText().equals("") || btn8.getText().equals("") ||
				btn9.getText().equals(""))){
			JOptionPane.showMessageDialog(null, "Draw Game!",null,JOptionPane.OK_OPTION);
			cur="";
			btn1.setText("");
			btn2.setText("");
			btn3.setText("");
			btn4.setText("");
			btn5.setText("");
			btn6.setText("");
			btn7.setText("");
			btn8.setText("");
			btn9.setText("");
			p=true;
			lblNone.setText("Game Finished");
		}
	
	}
}
