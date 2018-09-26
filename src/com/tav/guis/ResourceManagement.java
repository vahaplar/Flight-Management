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
import javax.swing.JComboBox;
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

public class ResourceManagement extends JFrame {

	/**
	 * Database Connection
	 */

	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pst = null;

	private JPanel contentPane;
	private JTable resourceTable;
	private String tableIndex;
	private JTextField resCode;
	private JTextField resDesc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResourceManagement frame = new ResourceManagement();
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
	public ResourceManagement() {
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
				ResourceManagement.this.dispose();
			}
		});
		panel.add(btnFlight);

		JButton btnTask = new JButton("Tasks");
		btnTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TaskManagement tm = new TaskManagement();
				tm.setVisible(true);
				ResourceManagement.this.dispose();
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
				ResourceManagement.this.dispose();

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
				ResourceManagement.this.dispose();
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
				ResourceManagement.this.dispose();
			}
		});
		btnAirline.setOpaque(false);
		btnAirline.setContentAreaFilled(false);
		btnAirline.setBorderPainted(false);
		panel.add(btnAirline);

		JButton btnResource = new JButton("Resources");
		btnResource.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnResource.setOpaque(false);
		btnResource.setContentAreaFilled(false);
		btnResource.setBorderPainted(true);
		panel.add(btnResource);

		JButton btnRoles = new JButton("Roles");
		btnRoles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RoleManagement role = new RoleManagement();
				role.setVisible(true);
				ResourceManagement.this.dispose();
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
				ResourceManagement.this.dispose();

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

		JLabel roleCodeLabel = new JLabel("Resource Code");
		roleCodeLabel.setBounds(28, 31, 95, 16);
		panel_2.add(roleCodeLabel);

		JLabel roleDescLabel = new JLabel("Resource Desc");
		roleDescLabel.setBounds(28, 71, 101, 16);
		panel_2.add(roleDescLabel);

		JComboBox<String> resourceComboBox = new JComboBox<String>();
		resourceComboBox.setBounds(362, 52, 116, 22);
		panel_2.add(resourceComboBox);
		fillResourceCombo(resourceComboBox);

		resCode = new JTextField();
		resCode.setBounds(135, 28, 116, 22);
		panel_2.add(resCode);
		resCode.setColumns(10);

		resDesc = new JTextField();
		resDesc.setColumns(10);
		resDesc.setBounds(135, 68, 116, 22);
		panel_2.add(resDesc);

		JLabel lblResource = new JLabel("Resource Type");
		lblResource.setBounds(263, 55, 93, 16);
		panel_2.add(lblResource);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(UIManager.getColor("Button.focus")));
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(12, 141, 270, 39);
		panel_1.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 2, 0, 0));

		JTextPane searchResource = new JTextPane();
		searchResource.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_3.add(searchResource);

		JButton btnSearch = new JButton("Search");
		panel_3.add(btnSearch);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					String sql = "select resource_code as 'Resource Code',resource_description as 'Description',"
							+ "resource_type as 'Resource Type' " + "from resource where resource_code like '%"
							+ searchResource.getText() + "%'";
					pst = conn.prepareStatement(sql);
					rs = pst.executeQuery();

					resourceTable.setModel(DbUtils.resultSetToTableModel(rs));

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

					String sqlArr = "INSERT INTO resource (resource_code, "
							+ "resource_description, resource_type) VALUES (?, ?, ?)";

					pst = conn.prepareStatement(sqlArr);

					pst.setString(1, resCode.getText());
					pst.setString(2, resDesc.getText());
					pst.setString(3, resourceComboBox.getSelectedItem().toString());

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
			public void actionPerformed(ActionEvent arg0) {

				try {

					String sql = "delete from resource where resource_code=?";
					
					pst = conn.prepareStatement(sql);
					pst.setString(1,tableIndex);
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

					String sqlArr = "update resource set resource_code=?, resource_description=?, resource_type=? where resource_code=? ";

					pst = conn.prepareStatement(sqlArr);
					
					pst.setString(1, resCode.getText());
					pst.setString(2, resDesc.getText());
					pst.setString(3, resourceComboBox.getSelectedItem().toString());
					pst.setString(4, tableIndex);
					

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
		resourceTable = new JTable() {
			@Override
			public boolean isCellEditable(int row, int column) {
				// This is how we disable editing:
				return false;
			}
		};

		scrollPane.setViewportView(resourceTable);

		resourceTable.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				
				btnUpdate.setEnabled(true);
				btnDelete.setEnabled(true);
				int i = resourceTable.getSelectedRow();
				tableIndex = resourceTable.getValueAt(i, 0).toString();
				resCode.setText(resourceTable.getValueAt(i, 0).toString());
				resDesc.setText(resourceTable.getValueAt(i, 1).toString());
								
			}
		});

		btnSearch.doClick();
		

	}

	private void fillResourceCombo(JComboBox<String> comboBox) {

		try {

			String sql = "select resource_type from resource group by resource_type";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {

				String type = rs.getString("resource_type");
				comboBox.addItem(type);

			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);

		}

	}
}
