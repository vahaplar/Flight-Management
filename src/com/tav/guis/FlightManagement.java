package com.tav.guis;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Font;
import com.tav.store.MysqlConnect;
import net.proteanit.sql.DbUtils;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;

public class FlightManagement extends JFrame {

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
	private String tableIndex;
	private String airlineIndex;
	private String flightIndex;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FlightManagement frame = new FlightManagement();
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
	public FlightManagement() {

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
		btnFlight.setBorderPainted(true);
		btnFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnFlight);

		JButton btnTask = new JButton("Tasks");
		btnTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				TaskManagement tm = new TaskManagement();
				tm.setVisible(true);
				FlightManagement.this.dispose();

			}
		});
		btnTask.setOpaque(false);
		btnTask.setContentAreaFilled(false);
		btnTask.setBorderPainted(false);
		panel.add(btnTask);

		JButton btnUser = new JButton("Users");
		btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				UserManagement um = new UserManagement();
				um.setVisible(true);
				FlightManagement.this.dispose();

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
				FlightManagement.this.dispose();
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
				FlightManagement.this.dispose();

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
				FlightManagement.this.dispose();
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
				FlightManagement.this.dispose();
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
				FlightManagement.this.dispose();

			}
		});
		btnLogout.setOpaque(false);
		btnLogout.setContentAreaFilled(false);
		btnLogout.setBorderPainted(false);
		panel.add(btnLogout);

		JToggleButton btnArrivals;
		JToggleButton btnDepartures;

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(UIManager.getColor("Button.focus")));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(22, 87, 746, 112);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAdd.setForeground(UIManager.getColor("Button.foreground"));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Add
				AddUpdateFlight au = new AddUpdateFlight(true);
				au.setVisible(true);
				FlightManagement.this.dispose();

			}
		});
		btnAdd.setBackground(UIManager.getColor("Button.light"));
		btnAdd.setBounds(400, 13, 103, 86);
		panel_1.add(btnAdd);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Update

				AddUpdateFlight au = new AddUpdateFlight(false);
				au.setVisible(true);
				FlightManagement.this.dispose();

				try {

					if (windowMode == true) {

						String sql = "select * from task " + "inner join arrival on task.arrival_id=arrival.arrival_id "
								+ "inner join departure on task.departure_id=departure.departure_id "
								+ "inner join airline on airline.airline_id=arrival.airline_id and airline.airline_id=departure.airline_id "
								+ "where concat(airline.airline_code,' ', arrival.flight_no) like '%" + tableIndex
								+ "%'";

						pst = conn.prepareStatement(sql);
						rs = pst.executeQuery();

						while (rs.next()) {

							au.arrNo.setText(rs.getString("arrival.flight_no"));
							au.arrTime.setText(rs.getString("arrival.arrival_time"));

							au.depNo.setText(rs.getString("departure.flight_no"));
							au.depTime.setText(rs.getString("departure.departure_time"));
						}
					} else if (windowMode == false) {

						String sql = "select * from task " + "inner join arrival on task.arrival_id=arrival.arrival_id "
								+ "inner join departure on task.departure_id=departure.departure_id "
								+ "inner join airline on airline.airline_id=arrival.airline_id and airline.airline_id=departure.airline_id "
								+ "where concat(airline.airline_code,' ', departure.flight_no) like '%" + tableIndex
								+ "%'";

						pst = conn.prepareStatement(sql);
						rs = pst.executeQuery();

						while (rs.next()) {

							au.arrNo.setText(rs.getString("arrival.flight_no"));
							au.arrTime.setText(rs.getString("arrival.arrival_time"));

							au.depNo.setText(rs.getString("departure.flight_no"));
							au.depTime.setText(rs.getString("departure.departure_time"));

						}

					} else {
						JOptionPane.showMessageDialog(null, "Please select one of Arrivals or Departures options");
					}

				} catch (Exception ex) {

					JOptionPane.showMessageDialog(null, ex);
				}

			}
		});
		btnUpdate.setForeground(UIManager.getColor("Button.foreground"));
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnUpdate.setBackground(UIManager.getColor("Button.light"));
		btnUpdate.setBounds(515, 13, 103, 86);
		panel_1.add(btnUpdate);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Delete
				try {

					if (windowMode == true) {

						String sqlArr = "delete a from arrival a "
								+ "inner join airline r on r.airline_id=a.airline_id " + "where airline_code like '%"
								+ airlineIndex + "%' and flight_no like '%" + flightIndex + "%'";

						pst = conn.prepareStatement(sqlArr);
						pst.executeUpdate();

						JOptionPane.showMessageDialog(null, "Delete successful!");

					} else if (windowMode == false) {

						String sqlDep = "delete d from departure d "
								+ "inner join airline r on r.airline_id=d.airline_id " + "where airline_code like '%"
								+ airlineIndex + "%' and flight_no like '%" + flightIndex + "%'";

						pst = conn.prepareStatement(sqlDep);
						pst.executeUpdate();

						JOptionPane.showMessageDialog(null, "Delete successful!");

					} else {
						JOptionPane.showMessageDialog(null, "Please select one of Arrivals or Departures options");
					}

				} catch (Exception ex) {

					JOptionPane.showMessageDialog(null, ex);
				}

			}
		});
		btnDelete.setForeground(UIManager.getColor("CheckBox.foreground"));
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDelete.setBackground(UIManager.getColor("Button.light"));
		btnDelete.setBounds(630, 13, 103, 86);
		panel_1.add(btnDelete);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(UIManager.getColor("Button.focus")));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(12, 39, 270, 39);
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));

		JTextPane searchFlight = new JTextPane();
		searchFlight.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(searchFlight);

		JButton btnSearch = new JButton("Search");
		panel_2.add(btnSearch);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				btnUpdate.setEnabled(false);
				btnDelete.setEnabled(false);

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

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(12, 212, 770, 340);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		btnArrivals = new JToggleButton("Arrivals");
		btnArrivals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Clicking Arrivals button
				btnUpdate.setEnabled(false);
				btnDelete.setEnabled(false);

				try {

					windowMode = true;
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
		btnArrivals.setBounds(12, 13, 133, 29);
		panel_3.add(btnArrivals);

		btnDepartures = new JToggleButton("Departures");
		btnDepartures.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// Clicking Departures button
				btnUpdate.setEnabled(false);
				btnDelete.setEnabled(false);
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
		btnDepartures.setBounds(144, 13, 133, 29);
		panel_3.add(btnDepartures);

		ButtonGroup arrDep = new ButtonGroup();
		arrDep.add(btnArrivals);
		arrDep.add(btnDepartures);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 41, 746, 286);
		panel_3.add(scrollPane);

		// Table instantiation and properties below
		flightTable = new JTable() {
			@Override
			public boolean isCellEditable(int row, int column) {
				// This is how we disable editing:
				return false;
			}
		};

		scrollPane.setViewportView(flightTable);

		flightTable.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {

				btnUpdate.setEnabled(true);
				btnDelete.setEnabled(true);
				int i = flightTable.getSelectedRow();
				tableIndex = flightTable.getValueAt(i, 0).toString();
				airlineIndex = flightTable.getValueAt(i, 0).toString().replaceAll("[^A-Za-z]+", "");
				flightIndex = flightTable.getValueAt(i, 0).toString().replaceAll("[^\\d.]", "");

			}
		});

		// Default state of the window
		btnArrivals.doClick();
		btnSearch.doClick();
	}
}
