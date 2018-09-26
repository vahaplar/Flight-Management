package com.tav.guis;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import com.tav.store.MysqlConnect;

import net.proteanit.sql.DbUtils;

public class TaskManagement extends JFrame {

	/**
	 * Database Connection
	 */

	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pst = null;

	private JPanel contentPane;
	private JTable taskTable;
	private String tableIndex;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TaskManagement frame = new TaskManagement();
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
	public TaskManagement() {

		// Establish Connection
		conn = MysqlConnect.ConnectDb();

		setTitle("Flight Management");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Tolgahan\\eclipse-workspace\\FlightManagement\\bin\\tavico.png"));
		lblNewLabel.setBounds(12, 13, 106, 62);
		contentPane.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Menu", TitledBorder.RIGHT,
				TitledBorder.TOP, null, null));
		panel.setBounds(130, 13, 652, 62);
		contentPane.add(panel);

		JButton btnFlight = new JButton("Flights");
		btnFlight.setOpaque(false);
		btnFlight.setContentAreaFilled(false);
		btnFlight.setBorderPainted(false);
		btnFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				FlightManagement fm = new FlightManagement();
				fm.setVisible(true);
				TaskManagement.this.dispose();
			}
		});
		panel.add(btnFlight);

		JButton btnTask = new JButton("Tasks");
		btnTask.setOpaque(false);
		btnTask.setContentAreaFilled(false);
		btnTask.setBorderPainted(true);
		panel.add(btnTask);

		JButton btnUser = new JButton("Users");
		btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserManagement um = new UserManagement();
				um.setVisible(true);
				TaskManagement.this.dispose();
			}
		});
		btnUser.setOpaque(false);
		btnUser.setContentAreaFilled(false);
		btnUser.setBorderPainted(false);
		panel.add(btnUser);

		JButton btnCity = new JButton("Cities");
		btnCity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CityManagement cm = new CityManagement();
				cm.setVisible(true);
				TaskManagement.this.dispose();
			}
		});
		btnCity.setOpaque(false);
		btnCity.setContentAreaFilled(false);
		btnCity.setBorderPainted(false);
		panel.add(btnCity);

		JButton btnAirline = new JButton("Airlines");
		btnAirline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AirlineManagement air = new AirlineManagement();
				air.setVisible(true);
				TaskManagement.this.dispose();

			}
		});
		btnAirline.setOpaque(false);
		btnAirline.setContentAreaFilled(false);
		btnAirline.setBorderPainted(false);
		panel.add(btnAirline);

		JButton btnResource = new JButton("Resources");
		btnResource.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResourceManagement res = new ResourceManagement();
				res.setVisible(true);
				TaskManagement.this.dispose();
			}
		});
		btnResource.setOpaque(false);
		btnResource.setContentAreaFilled(false);
		btnResource.setBorderPainted(false);
		panel.add(btnResource);

		JButton btnRoles = new JButton("Roles");
		btnRoles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RoleManagement role = new RoleManagement();
				role.setVisible(true);
				TaskManagement.this.dispose();
			}
		});
		btnRoles.setOpaque(false);
		btnRoles.setContentAreaFilled(false);
		btnRoles.setBorderPainted(false);
		panel.add(btnRoles);

		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Login l = new Login();
				l.setVisible(true);
				TaskManagement.this.dispose();

			}
		});
		btnLogout.setOpaque(false);
		btnLogout.setContentAreaFilled(false);
		btnLogout.setBorderPainted(false);
		panel.add(btnLogout);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(UIManager.getColor("Button.focus")));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(22, 87, 746, 465);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(UIManager.getColor("Button.focus")));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(12, 39, 270, 39);
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));

		JTextPane searchTask = new JTextPane();
		searchTask.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(searchTask);

		JButton btnSearch = new JButton("Search");
		panel_2.add(btnSearch);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					String sql = "select concat(airline.airline_code,' ', arrival.flight_no) as 'Arrival No',"
							+ "city_name as 'Origin',arrival_date as 'Arrival Date',arrival_time as 'Arrival Time',"
							+ "airline_name as 'Airline Name',concat(airline.airline_code,' ', departure.flight_no) as 'Departure No',"
							+ "city_name as 'Destination',departure_date as 'Departure Date',departure_time as 'Departure Time',"
							+ "airline_name as 'Airline Name' from task inner join arrival on task.arrival_id=arrival.arrival_id "
							+ "inner join departure on task.departure_id=departure.departure_id "
							+ "inner join airline on airline.airline_id=arrival.airline_id "
							+ "inner join city on arrival.city_id=city.city_id "
							+ "where concat(airline.airline_code,' ', arrival.flight_no) like '%" + searchTask.getText()
							+ "%' or concat(airline.airline_code,' ', departure.flight_no) like '%"
							+ searchTask.getText() + "%'";
					;
					pst = conn.prepareStatement(sql);
					rs = pst.executeQuery();

					taskTable.setModel(DbUtils.resultSetToTableModel(rs));

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}

			}
		});
		btnSearch.setForeground(UIManager.getColor("Button.foreground"));
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSearch.setBackground(UIManager.getColor("Button.light"));

		JButton btnResources = new JButton("Add Resources");
		btnResources.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					String sql="";
					pst = conn.prepareStatement(sql);
					pst.executeUpdate();

					JOptionPane.showMessageDialog(null, "Delete successful!");

				} catch (Exception ex) {

					JOptionPane.showMessageDialog(null, ex);
				}

			}
		});
		btnResources.setForeground(UIManager.getColor("CheckBox.foreground"));
		btnResources.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnResources.setBackground(UIManager.getColor("Button.light"));
		btnResources.setBounds(532, 28, 192, 57);
		btnResources.setEnabled(false);
		panel_1.add(btnResources);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 112, 721, 340);
		panel_1.add(scrollPane);

		// Table instantiation and properties below
		taskTable = new JTable() {
			@Override
			public boolean isCellEditable(int row, int column) {
				// This is how we disable editing:
				return false;
			}
		};

		scrollPane.setViewportView(taskTable);

		taskTable.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {

				btnResources.setEnabled(true);
				int i = taskTable.getSelectedRow();
				tableIndex = taskTable.getValueAt(i, 0).toString();

			}
		});

		btnSearch.doClick();

	}
}
