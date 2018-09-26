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
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import com.tav.store.MysqlConnect;
import net.proteanit.sql.DbUtils;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import com.tav.pojos.Role;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;

public class UserManagement extends JFrame {

	/**
	 * Database Connection
	 */

	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pst = null;

	private JPanel contentPane;
	private JTable userTable;
	private String tableIndex;
	private JPasswordField passwordField;
	private JPasswordField confirmField;
	private JTextField usernameField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserManagement frame = new UserManagement();
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
	public UserManagement() {

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
				UserManagement.this.dispose();
			}
		});
		panel.add(btnFlight);

		JButton btnTask = new JButton("Tasks");
		btnTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TaskManagement tm = new TaskManagement();
				tm.setVisible(true);
				UserManagement.this.dispose();
			}
		});
		btnTask.setOpaque(false);
		btnTask.setContentAreaFilled(false);
		btnTask.setBorderPainted(false);
		panel.add(btnTask);

		JButton btnUser = new JButton("Users");
		btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUser.setOpaque(false);
		btnUser.setContentAreaFilled(false);
		btnUser.setBorderPainted(true);
		panel.add(btnUser);

		JButton btnCity = new JButton("Cities");
		btnCity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CityManagement cm = new CityManagement();
				cm.setVisible(true);
				UserManagement.this.dispose();
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
				UserManagement.this.dispose();

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
				UserManagement.this.dispose();

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
				UserManagement.this.dispose();
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
				UserManagement.this.dispose();

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
		panel_2.setBounds(12, 13, 722, 163);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(UIManager.getColor("Button.focus")));
		panel_2.setBackground(Color.WHITE);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(24, 44, 104, 16);
		panel_2.add(lblUsername);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(24, 79, 104, 16);
		panel_2.add(lblPassword);

		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setBounds(24, 108, 104, 16);
		panel_2.add(lblConfirmPassword);

		JComboBox<Role> roleCombo = new JComboBox<Role>();
		roleCombo.setBounds(351, 73, 116, 22);
		panel_2.add(roleCombo);
		fillRoleCombo(roleCombo);

		JLabel lblRole = new JLabel("Role");
		lblRole.setBounds(305, 76, 56, 16);
		panel_2.add(lblRole);

		passwordField = new JPasswordField();
		passwordField.setBounds(140, 73, 116, 22);
		panel_2.add(passwordField);

		confirmField = new JPasswordField();
		confirmField.setBounds(140, 105, 116, 22);
		panel_2.add(confirmField);

		usernameField = new JTextField();
		usernameField.setBounds(140, 41, 116, 22);
		panel_2.add(usernameField);
		usernameField.setColumns(10);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(UIManager.getColor("Button.focus")));
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(12, 189, 270, 39);
		panel_1.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 2, 0, 0));

		JTextPane searchUser = new JTextPane();
		searchUser.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_3.add(searchUser);

		JButton btnSearch = new JButton("Search");
		panel_3.add(btnSearch);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					String sql = "select username as 'Username',role_code as 'Role Code' "
							+ "from user inner join user_role on user.user_id=user_role.user_id "
							+ "inner join role on user_role.role_id=role.role_id " + "where username like '%"
							+ searchUser.getText() + "%'";
					pst = conn.prepareStatement(sql);
					rs = pst.executeQuery();

					userTable.setModel(DbUtils.resultSetToTableModel(rs));

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}

			}
		});
		btnSearch.setForeground(UIManager.getColor("Button.foreground"));
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSearch.setBackground(UIManager.getColor("Button.light"));

		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(515, 64, 134, 39);
		panel_2.add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					// Check Confirm Password
					if (String.valueOf(passwordField.getPassword())
							.equals(String.valueOf(confirmField.getPassword()))) {
						
						String sql = "INSERT INTO user (username, password) VALUES (?, ?)";
						pst = conn.prepareStatement(sql);
						String user = usernameField.getText();
						pst.setString(1, user);
						pst.setString(2, String.valueOf(passwordField.getPassword()));

						pst.executeUpdate();
						
						long idIndex = getUserID(usernameField.getText());
						
						String sql2 = "INSERT INTO user_role (user_id, role_id) VALUES(?, ?)";
						pst = conn.prepareStatement(sql2);
						
						
						pst.setLong(1, idIndex);
						pst.setLong(2, getRoleID(roleCombo));
						
						pst.executeUpdate();

						btnSearch.doClick();

					} else {

						JOptionPane.showMessageDialog(null, "Password fields do not match!");

					}

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
			public void actionPerformed(ActionEvent arg0) {

				try {

					String sql = "delete from user where username=?";

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
		btnDelete.setBounds(600, 189, 134, 37);
		btnDelete.setEnabled(false);
		panel_1.add(btnDelete);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					// Check Confirm Password
					if (String.valueOf(passwordField.getPassword())
							.equals(String.valueOf(confirmField.getPassword()))) {

						String sql = "update user set username=?, password=? where username=?";
						pst = conn.prepareStatement(sql);
						pst.setString(1, usernameField.getText());
						pst.setString(2, String.valueOf(passwordField.getPassword()));
						pst.setString(3, tableIndex);

						pst.executeUpdate();
						btnSearch.doClick();

					} else {

						JOptionPane.showMessageDialog(null, "Password fields do not match!");

					}

				} catch (Exception ex) {

					JOptionPane.showMessageDialog(null, ex);
				}
			}
		});
		btnUpdate.setForeground(Color.BLACK);
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdate.setBackground(UIManager.getColor("Button.light"));
		btnUpdate.setBounds(454, 189, 134, 37);
		btnUpdate.setEnabled(false);
		panel_1.add(btnUpdate);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 241, 721, 211);
		panel_1.add(scrollPane);

		// Table instantiation and properties below
		userTable = new JTable() {
			@Override
			public boolean isCellEditable(int row, int column) {
				// This is how we disable editing:
				return false;
			}
		};

		scrollPane.setViewportView(userTable);

		userTable.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {

				btnUpdate.setEnabled(true);
				btnDelete.setEnabled(true);
				int i = userTable.getSelectedRow();
				tableIndex = userTable.getValueAt(i, 0).toString();
				usernameField.setText(userTable.getValueAt(i, 0).toString());

			}
		});

		btnSearch.doClick();

	}

	private void fillRoleCombo(JComboBox<Role> comboBox) {

		try {

			String sql = "select * from role group by role_code";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {

				long id = rs.getLong("role_id");
				String code = rs.getString("role_code");
				String description = rs.getString("role_description");

				comboBox.addItem(new Role(id, code, description));

			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);

		}

	}

	private long getRoleID(JComboBox<Role> comboBox) {
		Role item = (Role) comboBox.getSelectedItem();
		return item.getID();
	}

	private long getUserID(String username) {
		
		long index = 0;
		
		try {

			String sql = "select user_id,username from user where username=?";
			pst = conn.prepareStatement(sql);

			pst.setString(1, username);
			rs = pst.executeQuery();
			while (rs.next()) {

				index = rs.getLong("user_id");
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);

		}
		
		return index;
		
	}

}
