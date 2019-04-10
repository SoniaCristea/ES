package gui_swing;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.temporal.JulianFields;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.DimensionUIResource;

import org.eclipse.swt.widgets.Layout;

public class Menu extends JFrame {

	private JPanel panel = new JPanel();

	public Menu() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 400);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createEmptyBorder(70, 50, 50, 120));
		setContentPane(panel);

		JLabel label = createLabel("Choose action:");

		JButton tagDialogBtn = createButton("Choose tags");
		tagDialogBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TagDialog td = new TagDialog();
				td.setVisible(true);

			}
		});

		JButton folderDialogBtn = createButton("Choose folders");
		folderDialogBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FolderDialog fd = new FolderDialog();
				fd.setVisible(true);

			}
		});

		JButton resultsDialogBtn = createButton("View results");

		JButton userClassifBtn = createButton("Classify");

		panel.add(label);
		panel.add(Box.createRigidArea(new Dimension(10, 20)));
		panel.add(tagDialogBtn);
		panel.add(Box.createRigidArea(new Dimension(10, 10)));
		panel.add(folderDialogBtn);
		panel.add(Box.createRigidArea(new Dimension(10, 10)));
		panel.add(resultsDialogBtn);
		panel.add(Box.createRigidArea(new Dimension(10, 10)));
		panel.add(userClassifBtn);

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

	public static void main(String[] args) {

		Menu menu = new Menu();
	}

}
