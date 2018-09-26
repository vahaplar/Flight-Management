package com.tav.guis;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import com.tav.store.MysqlConnect;
import com.tav.pojos.*;
import com.toedter.calendar.JDateChooser;

public class AddUpdateFlight extends JFrame {

	/**
	 * Database Connection
	 */

	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pst = null;

	private JPanel contentPane;
	public JTextField arrNo;
	public JTextField arrTime;
	public JTextField depNo;
	public JTextField depTime;
	public JComboBox<City> arrOrigin;
	public JComboBox<City> depDestination;
	public JComboBox<Airline> arrAirline;
	public JComboBox<Airline> depAirline;
	public JDateChooser arrDate;
	public JDateChooser depDate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JOptionPane.showMessageDialog(null, "Window in testing mode...");
					AddUpdateFlight frame = new AddUpdateFlight(true);
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
	public AddUpdateFlight(boolean windowMode) {

		// Establish Connection
		conn = MysqlConnect.ConnectDb();

		setResizable(false);

		/*
		 * windowMode variable is set in Flight Management GUI it designates
		 * whether the adding or updating operation will be done by the GUI
		 * 
		 */

		if (windowMode) {
			setTitle("Add Flight");
		} else {
			setTitle("Update Flight");
		}

		// Override what happens when you click X button on top
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		AddUpdateFlight.this.addWindowListener(new java.awt.event.WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				FlightManagement fm = new FlightManagement();
				fm.setVisible(true);
				e.getWindow().dispose();
			}
		});

		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Tolgahan\\eclipse-workspace\\FlightManagement\\bin\\tavico.png"));
		label.setBounds(12, 13, 106, 62);
		contentPane.add(label);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(
				new TitledBorder(null, "Arrival Information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(22, 88, 760, 200);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Flight No");
		lblNewLabel.setBounds(65, 53, 56, 16);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Origin");
		lblNewLabel_1.setBounds(65, 115, 56, 16);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Arr. Date");
		lblNewLabel_2.setBounds(320, 53, 56, 16);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Arr. Time");
		lblNewLabel_3.setBounds(320, 115, 56, 16);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Airline");
		lblNewLabel_4.setBounds(632, 83, 56, 16);
		panel.add(lblNewLabel_4);

		arrNo = new JTextField();
		arrNo.setBounds(136, 50, 116, 22);
		panel.add(arrNo);
		arrNo.setColumns(10);

		arrOrigin = new JComboBox<City>();
		arrOrigin.setBounds(136, 112, 116, 22);
		panel.add(arrOrigin);
		fillCityCombo(arrOrigin);

		arrAirline = new JComboBox<Airline>();
		arrAirline.setBounds(602, 112, 116, 22);
		panel.add(arrAirline);
		fillAirlineCombo(arrAirline);

		arrTime = new JTextField();
		arrTime.setColumns(10);
		arrTime.setBounds(388, 112, 116, 22);
		panel.add(arrTime);

		arrDate = new JDateChooser();
		arrDate.setBounds(388, 53, 116, 22);
		panel.add(arrDate);
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(
				new TitledBorder(null, "Departure Information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(22, 300, 760, 200);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel label_1 = new JLabel("Flight No");
		label_1.setBounds(55, 47, 56, 16);
		panel_1.add(label_1);

		JLabel lblDestination = new JLabel("Destination");
		lblDestination.setBounds(40, 109, 71, 16);
		panel_1.add(lblDestination);

		JLabel lblDesDate = new JLabel("Dep. Date");
		lblDesDate.setBounds(310, 47, 56, 16);
		panel_1.add(lblDesDate);

		JLabel lblDesTime = new JLabel("Dep. Time");
		lblDesTime.setBounds(310, 109, 56, 16);
		panel_1.add(lblDesTime);

		JLabel label_5 = new JLabel("Airline");
		label_5.setBounds(622, 77, 56, 16);
		panel_1.add(label_5);

		depNo = new JTextField();
		depNo.setColumns(10);
		depNo.setBounds(126, 44, 116, 22);
		panel_1.add(depNo);

		depDestination = new JComboBox<City>();
		depDestination.setBounds(126, 106, 116, 22);
		panel_1.add(depDestination);
		fillCityCombo(depDestination);

		depAirline = new JComboBox<Airline>();
		depAirline.setBounds(592, 106, 116, 22);
		panel_1.add(depAirline);
		fillAirlineCombo(depAirline);

		depTime = new JTextField();
		depTime.setColumns(10);
		depTime.setBounds(378, 106, 116, 22);
		panel_1.add(depTime);

		depDate = new JDateChooser();
		depDate.setBounds(378, 47, 116, 22);
		panel_1.add(depDate);

		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				arrNo.setText("");
				arrTime.setText("");
				arrDate.setCalendar(null);
				arrAirline.setSelectedIndex(0);
				arrOrigin.setSelectedIndex(0);
				depNo.setText("");
				depTime.setText("");
				depDate.setCalendar(null);
				depAirline.setSelectedIndex(0);
				depDestination.setSelectedIndex(0);

			}
		});
		btnClear.setBounds(263, 513, 97, 25);
		contentPane.add(btnClear);

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// Check if adding or updating
				if (windowMode == true) {

					// Add flight
					try {

						String sqlArr = "INSERT INTO arrival (airline_id, flight_no, city_id, "
								+ "arrival_date, arrival_time) VALUES (?, ?, ?, ?, ?)";

						String sqlDep = "INSERT INTO departure (airline_id, flight_no, city_id, "
								+ "departure_date, departure_time) VALUES (?, ?, ?, ?, ?)";

						pst = conn.prepareStatement(sqlArr);

						pst.setLong(1, getComboAirlineID(arrAirline));
						pst.setString(2, arrNo.getText());
						pst.setLong(3, getComboCityID(arrOrigin));
						pst.setDate(4, convertUtilToSql(arrDate.getDate()));
						pst.setString(5, arrTime.getText());

						pst.executeUpdate();

						pst = conn.prepareStatement(sqlDep);

						pst.setLong(1, getComboAirlineID(depAirline));
						pst.setString(2, depNo.getText());
						pst.setLong(3, getComboCityID(depDestination));
						pst.setDate(4, convertUtilToSql(depDate.getDate()));
						pst.setString(5, depTime.getText());

						pst.executeUpdate();

						// Assign a task for the recently created flights

						try {
							String sql = "insert into task (arrival_id,departure_id)"
									+ " select arrival_id, departure_id from arrival join departure"
									+ " where arrival.flight_no=" + arrNo.getText() + " and arrival.airline_id="
									+ getComboAirlineID(arrAirline) + " and departure.flight_no=" + depNo.getText()
									+ " and departure.airline_id=" + getComboAirlineID(depAirline);

							pst = conn.prepareStatement(sql);
							pst.executeUpdate();

							

						} catch (Exception e) {

							JOptionPane.showMessageDialog(null, e);
						}
						
						JOptionPane.showMessageDialog(null, "Flight successfully added!");
						
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, ex);
					}

				} else {

					// Update flight

					JOptionPane.showMessageDialog(null, "Flight successfully updated!");

				}

				AddUpdateFlight.this.dispose();
				FlightManagement fm = new FlightManagement();
				fm.setVisible(true);
			}
		});
		btnSave.setBounds(435, 513, 97, 25);
		contentPane.add(btnSave);

	}

	// Fill combo boxes

	private void fillCityCombo(JComboBox<City> comboBox) {

		try {

			String sql = "select * from city";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				long id = rs.getLong("city_id");
				String code = rs.getString("city_code");
				String name = rs.getString("city_name");

				comboBox.addItem(new City(id, code, name));

			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);

		}

	}

	private void fillAirlineCombo(JComboBox<Airline> comboBox) {

		try {

			String sql = "select * from airline";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				long id = rs.getLong("airline_id");
				String code = rs.getString("airline_code");
				String name = rs.getString("airline_name");

				comboBox.addItem(new Airline(id, code, name));

			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);

		}

	}

	// Reaching the ID of selected combo box item

	private long getComboCityID(JComboBox<City> comboBox) {
		City item = (City) comboBox.getSelectedItem();
		return item.getID();
	}

	private long getComboAirlineID(JComboBox<Airline> comboBox) {
		Airline item = (Airline) comboBox.getSelectedItem();
		return item.getID();
	}

	private static java.sql.Date convertUtilToSql(java.util.Date uDate) {

		java.sql.Date sDate = new java.sql.Date(uDate.getTime());

		return sDate;

	}
}
