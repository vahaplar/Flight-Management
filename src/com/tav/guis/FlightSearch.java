package com.tav.guis;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import com.tav.store.MysqlConnect;
import net.proteanit.sql.DbUtils;

public class FlightSearch extends JFrame {

	/**
	 * Database Connection
	 */

	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pst = null;

	// Window mode is designated as true when Add button is pressed or false
	// when Update button pressed

	boolean windowMode = true;

	// Panel and table definitions
	private JPanel contentPane;
	private JTable flightTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FlightSearch frame = new FlightSearch();
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
	public FlightSearch() {
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
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(667, 13, 115, 62);
		contentPane.add(panel);

		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(0, 0, 115, 62);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Login l = new Login();
				l.setVisible(true);
				FlightSearch.this.dispose();

			}
		});
		panel.setLayout(null);
		btnLogout.setOpaque(false);
		btnLogout.setContentAreaFilled(false);
		btnLogout.setBorderPainted(false);
		panel.add(btnLogout);

		JToggleButton btnArrivals;
		JToggleButton btnDepartures;

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(12, 88, 770, 464);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(11, 13, 746, 39);
		panel_1.add(panel_2);
		panel_2.setBorder(new LineBorder(UIManager.getColor("Button.focus")));
		panel_2.setBackground(Color.WHITE);
		panel_2.setLayout(null);
		
		JTextPane searchFlight = new JTextPane();
		searchFlight.setBounds(12, 1, 598, 37);
		panel_2.add(searchFlight);
		searchFlight.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(613, 1, 133, 37);
		panel_2.add(btnSearch);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					if (windowMode == true) {
						String sql = "select concat(airline.airline_code,' ', arrival.flight_no) as 'Flight No',"
								+ "city_name as 'Origin',arrival_date as 'Arrival Date',arrival_time as 'Arrival Time',"
								+ "airline_name as 'Airline Name' from arrival "
								+ "inner join city on arrival.city_id=city.city_id "
								+ "inner join airline on arrival.airline_id=airline.airline_id "
								+ "where concat(airline.airline_code,' ', arrival.flight_no) like '%"
								+ searchFlight.getText() + "%'";
						pst = conn.prepareStatement(sql);
						rs = pst.executeQuery();

						flightTable.setModel(DbUtils.resultSetToTableModel(rs));

					} else if (windowMode == false) {
						String sql = "select concat(airline.airline_code,' ', departure.flight_no) as 'Flight No',"
								+ "city_name as 'Destination',departure_date as 'Departure Date',departure_time as 'Departure Time',"
								+ "airline_name as 'Airline Name' from departure "
								+ "inner join city on departure.city_id=city.city_id "
								+ "inner join airline on departure.airline_id=airline.airline_id "
								+ "where concat(airline.airline_code,' ', departure.flight_no) like '%"
								+ searchFlight.getText() + "%'";
						pst = conn.prepareStatement(sql);
						rs = pst.executeQuery();

						flightTable.setModel(DbUtils.resultSetToTableModel(rs));
					} else {

						JOptionPane.showMessageDialog(null, "Please select one of Arrivals or Departures options");
					}

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				} 
			}
		});
		btnSearch.setForeground(UIManager.getColor("Button.foreground"));
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSearch.setBackground(UIManager.getColor("Button.light"));

		btnArrivals = new JToggleButton("Arrivals");
		btnArrivals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					String sql = "select concat(airline.airline_code,' ', arrival.flight_no) as 'Flight No',"
							+ "city_name as 'Origin',arrival_date as 'Arrival Date',arrival_time as 'Arrival Time',"
							+ "airline_name as 'Airline Name' from arrival "
							+ "inner join city on arrival.city_id=city.city_id "
							+ "inner join airline on arrival.airline_id=airline.airline_id "
							+ "where concat(airline.airline_code,' ', arrival.flight_no) like '%"
							+ searchFlight.getText() + "%'";
					pst = conn.prepareStatement(sql);
					rs = pst.executeQuery();

					flightTable.setModel(DbUtils.resultSetToTableModel(rs));

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
			}
		});
		btnArrivals.setForeground(UIManager.getColor("CheckBox.foreground"));
		btnArrivals.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnArrivals.setBackground(UIManager.getColor("Button.light"));
		btnArrivals.setBounds(10, 65, 133, 29);
		panel_1.add(btnArrivals);


		
		

		btnDepartures = new JToggleButton("Departures");
		btnDepartures.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					windowMode = false;
					String sql = "select concat(airline.airline_code,' ', departure.flight_no) as 'Flight No',"
							+ "city_name as 'Destination',departure_date as 'Departure Date',departure_time as 'Departure Time',"
							+ "airline_name as 'Airline Name' from departure "
							+ "inner join city on departure.city_id=city.city_id "
							+ "inner join airline on departure.airline_id=airline.airline_id "
							+ "where concat(airline.airline_code,' ', departure.flight_no) like '%"
							+ searchFlight.getText() + "%'";

					pst = conn.prepareStatement(sql);
					rs = pst.executeQuery();

					flightTable.setModel(DbUtils.resultSetToTableModel(rs));

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		btnDepartures.setForeground(UIManager.getColor("Button.foreground"));
		btnDepartures.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDepartures.setBackground(UIManager.getColor("Button.light"));
		btnDepartures.setBounds(142, 65, 133, 29);
		panel_1.add(btnDepartures);

		ButtonGroup arrDep = new ButtonGroup();
		arrDep.add(btnArrivals);
		arrDep.add(btnDepartures);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 93, 746, 358);
		panel_1.add(scrollPane);

		// Table instantiation and properties below
		flightTable = new JTable() {
			@Override
			public boolean isCellEditable(int row, int column) {
				// This is how we disable editing:
				return false;
			}
		};

		scrollPane.setViewportView(flightTable);

		// Default state of the window
		btnArrivals.doClick();
		btnSearch.doClick();
	}

}
