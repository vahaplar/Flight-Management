package com.tav.guis;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.tav.store.MysqlConnect;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.sql.*;

public class Login extends JFrame {

	/**
	 * Database Connection 
	 */

	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pst = null;

	private JPanel contentPane;
	private JTextField usernameField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {

		// Establish Connection
		conn = MysqlConnect.ConnectDb();

		setResizable(false);
		setTitle("Flight Management");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsername.setBounds(290, 315, 81, 16);
		contentPane.add(lblUsername);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(290, 364, 81, 16);
		contentPane.add(lblPassword);

		usernameField = new JTextField();
		usernameField.setBounds(372, 312, 116, 22);
		contentPane.add(usernameField);
		usernameField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(372, 361, 116, 22);
		contentPane.add(passwordField);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				/*
				 * Login via connecting database
				 */

				try {
					String sql = "select * from user "
							+ "inner join user_role on user.user_id=user_role.user_id "
							+ "where username=? and password=?";
					pst = conn.prepareStatement(sql);
					pst.setString(1, usernameField.getText());
					pst.setString(2, String.valueOf(passwordField.getPassword()));
					rs = pst.executeQuery();
					
					//Checking if the logging account is administrator or not
					
					if(rs.next()){
						
						long isAdmin = rs.getLong("role_id");
						
						if (isAdmin==1) {
							
							FlightManagement fm = new FlightManagement();
							fm.setVisible(true);
							Login.this.dispose();
							
						}else{
							
							FlightSearch fs = new FlightSearch();
							fs.setVisible(true);
							Login.this.dispose();
							
						}
					}else{
						
						JOptionPane.showMessageDialog(null, "Username or Password is wrong. Please try again!");
						passwordField.setText("");
					}
						

				} catch (Exception e) {

					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		btnLogin.setBounds(336, 424, 97, 25);
		contentPane.add(btnLogin);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Tolgahan\\eclipse-workspace\\FlightManagement\\bin\\tav.png"));
		lblNewLabel.setBounds(205, 88, 416, 190);
		contentPane.add(lblNewLabel);
	}
}
