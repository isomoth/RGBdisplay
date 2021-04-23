package rGBDisplay;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RGBDisplayPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private Color RGBcolor;
	private JLabel lblNewLabel;
	private JTextField txtR;
	private JTextField txtG;
	private JTextField txtB;
	private JButton btnShowColor;

	public RGBDisplayPanel() {

		showTextListenerDemo();
	}
	private void showTextListenerDemo() {
		setPreferredSize(new Dimension(275, 150));

		lblNewLabel = new JLabel("Fill in the amount of red, green and blue: ");

		txtR = new JTextField();
		txtG = new JTextField();
		txtB = new JTextField();

		txtR.setEnabled(true);
		txtR.setText("0");
		txtR.setColumns(10);

		txtG = new JTextField();
		txtG.setEnabled(true);
		txtG.setText("0");
		txtG.setColumns(10);

		txtB = new JTextField();
		txtB.setEnabled(true);
		txtB.setText("0");
		txtB.setColumns(10);


		btnShowColor = new JButton("Show color");
		btnShowColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Generate a color from three integer values combined (the amount of Red, Green and Blue) 
				int R = Integer.parseInt(txtR.getText());
				int G = Integer.parseInt(txtG.getText());
				int B = Integer.parseInt(txtB.getText());
				RGBcolor = new Color(R, G, B);
				repaint();
			}
		});

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap(10, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
										.addComponent(txtR, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(txtG, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(txtB, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btnShowColor)
										.addGap(33))
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
										.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE)
										.addContainerGap())))
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGap(22)
						.addComponent(lblNewLabel)
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtR, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnShowColor))
						.addContainerGap(78, Short.MAX_VALUE))
				);
		setLayout(groupLayout);

	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

			g.setColor(RGBcolor);
			g.fillRect(35, 100, 200, 35);
	}
}
