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
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.tav.store.MysqlConnect;

import net.proteanit.sql.DbUtils;

public class RoleManagement extends JFrame {

	/**
	 * Database Connection
	 */

	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pst = null;

	private JPanel contentPane;
	private JTable roleTable;
	private String tableIndex;
	private JTextField roleCodeField;
	private JTextField roleDescField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RoleManagement frame = new RoleManagement();
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
	public RoleManagement() {
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
				RoleManagement.this.dispose();
			}
		});
		panel.add(btnFlight);

		JButton btnTask = new JButton("Tasks");
		btnTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TaskManagement tm = new TaskManagement();
				tm.setVisible(true);
				RoleManagement.this.dispose();
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
				RoleManagement.this.dispose();

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
				RoleManagement.this.dispose();
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
				RoleManagement.this.dispose();
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
				RoleManagement.this.dispose();

			}
		});
		btnResource.setOpaque(false);
		btnResource.setContentAreaFilled(false);
		btnResource.setBorderPainted(false);
		panel.add(btnResource);

		JButton btnRoles = new JButton("Roles");
		btnRoles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnRoles.setOpaque(false);
		btnRoles.setContentAreaFilled(false);
		btnRoles.setBorderPainted(true);
		panel.add(btnRoles);

		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Login l = new Login();
				l.setVisible(true);
				RoleManagement.this.dispose();

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
		panel_2.setBounds(12, 13, 722, 115);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(UIManager.getColor("Button.focus")));
		panel_2.setBackground(Color.WHITE);

		JLabel roleCodeLabel = new JLabel("Role Code");
		roleCodeLabel.setBounds(27, 31, 96, 16);
		panel_2.add(roleCodeLabel);

		JLabel roleNameLabel = new JLabel("Role Description");
		roleNameLabel.setBounds(27, 71, 102, 16);
		panel_2.add(roleNameLabel);

		roleCodeField = new JTextField();
		roleCodeField.setBounds(135, 28, 116, 22);
		panel_2.add(roleCodeField);
		roleCodeField.setColumns(10);

		roleDescField = new JTextField();
		roleDescField.setColumns(10);
		roleDescField.setBounds(135, 68, 116, 22);
		panel_2.add(roleDescField);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(UIManager.getColor("Button.focus")));
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(12, 141, 270, 39);
		panel_1.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 2, 0, 0));

		JTextPane searchRole = new JTextPane();
		searchRole.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_3.add(searchRole);

		JButton btnSearch = new JButton("Search");
		panel_3.add(btnSearch);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					String sql = "select role_code as 'Role Code',role_description as 'Role Description' from role where role_description like '%"
							+ searchRole.getText() + "%'";
					pst = conn.prepareStatement(sql);
					rs = pst.executeQuery();

					roleTable.setModel(DbUtils.resultSetToTableModel(rs));

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}

			}
		});
		btnSearch.setForeground(UIManager.getColor("Button.foreground"));
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSearch.setBackground(UIManager.getColor("Button.light"));

		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(515, 43, 134, 39);
		panel_2.add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					String sql = "INSERT INTO role (role_code, role_description) VALUES (?, ?)";

					pst = conn.prepareStatement(sql);

					pst.setString(1, roleCodeField.getText());
					pst.setString(2, roleDescField.getText());

					pst.executeUpdate();
					btnSearch.doClick();

				} catch (Exception ex) {

					JOptionPane.showMessageDialog(null, ex);
				}

			}
		});
		btnAdd.setForeground(UIManager.getColor("CheckBox.foreground"));
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAdd.setBackground(UIManager.getColor("Button.light"));

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					String sql = "delete from role where role_code=?";

					pst = conn.prepareStatement(sql);
					pst.setString(1, tableIndex);
					pst.executeUpdate();

					btnSearch.doClick();

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
			}
		});
		btnDelete.setForeground(Color.BLACK);
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDelete.setBackground(UIManager.getColor("Button.light"));
		btnDelete.setBounds(600, 141, 134, 37);
		btnDelete.setEnabled(false);
		panel_1.add(btnDelete);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					String sqlArr = "update role set role_code=?, role_description=? where role_code=? ";

					pst = conn.prepareStatement(sqlArr);

					pst.setString(1, roleCodeField.getText());
					pst.setString(2, roleDescField.getText());
					pst.setString(3, tableIndex);

					pst.executeUpdate();
					btnSearch.doClick();

				} catch (Exception ex) {

					JOptionPane.showMessageDialog(null, ex);
				}
			}
		});
		btnUpdate.setForeground(Color.BLACK);
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdate.setBackground(UIManager.getColor("Button.light"));
		btnUpdate.setBounds(454, 141, 134, 37);
		btnUpdate.setEnabled(false);
		panel_1.add(btnUpdate);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 193, 721, 259);
		panel_1.add(scrollPane);

		// Table instantiation and properties below
		roleTable = new JTable() {
			@Override
			public boolean isCellEditable(int row, int column) {
				// This is how we disable editing:
				return false;
			}
		};

		scrollPane.setViewportView(roleTable);

		roleTable.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				
				btnUpdate.setEnabled(true);
				btnDelete.setEnabled(true);
				int i = roleTable.getSelectedRow();
				tableIndex = roleTable.getValueAt(i, 0).toString();
				roleCodeField.setText(roleTable.getValueAt(i, 0).toString());
				roleDescField.setText(roleTable.getValueAt(i, 1).toString());
			}
		});

		btnSearch.doClick();
	}

}
