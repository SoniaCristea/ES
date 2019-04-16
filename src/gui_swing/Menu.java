package gui_swing;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gui_functionality.FolderDialogFunc;
import gui_functionality.ResultsDialogFunc;
import gui_functionality.TagDialogFunc;



public class Menu extends JFrame {

	private JPanel panel = new JPanel();
	private TagDialog td;
	private FolderDialog fd;
	private ResultsDialog rd;

	public Menu() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Menu");
		setSize(400, 350);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 100));
		setContentPane(panel);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		

		JLabel label = createLabel("Choose action:");

		JButton tagDialogBtn = createButton("Choose tags");
		tagDialogBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				td = new TagDialog();
			}
		});

		JButton folderDialogBtn = createButton("Choose folders");
		folderDialogBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fd = new FolderDialog();
			}
		});

		JButton resultsDialogBtn = createButton("Show classification");
		resultsDialogBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				rd = new ResultsDialog(td, fd);
			}
		});

		panel.add(label);
		panel.add(Box.createRigidArea(new Dimension(10, 20)));
		panel.add(tagDialogBtn);
		panel.add(Box.createRigidArea(new Dimension(10, 10)));
		panel.add(folderDialogBtn);
		panel.add(Box.createRigidArea(new Dimension(10, 10)));
		panel.add(resultsDialogBtn);
		panel.add(Box.createRigidArea(new Dimension(10, 10)));

		setVisible(true);

	}

	private JLabel createLabel(String text) {

		JLabel label = new JLabel(text);
		label.setSize(70, 10);
		label.setFont(new Font("Sans Serif", Font.BOLD, 17));
		label.setAlignmentX(RIGHT_ALIGNMENT);

		return label;

	}

	private JButton createButton(String text) {

		JButton button = new JButton(text);
		button.setMaximumSize(new Dimension(150, 30));
		button.setAlignmentX(CENTER_ALIGNMENT);

		return button;
	}

}
