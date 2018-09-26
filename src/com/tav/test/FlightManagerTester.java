package com.tav.test;

import java.awt.EventQueue;

import com.tav.guis.Login;

public class FlightManagerTester {

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

}
