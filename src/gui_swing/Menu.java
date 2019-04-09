package gui_swing;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
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

public class Menu extends JFrame{
	
	private JPanel panel = new JPanel();
	
	public Menu() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350, 400);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		//top left bottom right
		panel.setBorder(BorderFactory.createEmptyBorder(70, 50, 50, 100));
		setContentPane(panel);
		
		JLabel label = new JLabel("Choose action: ");
		label.setSize(70, 10);
		label.setFont(new Font("Sans Serif", Font.BOLD, 17));
		label.setAlignmentX(RIGHT_ALIGNMENT);
		
		JButton tagDialogBtn = new JButton("Choose tags");
		tagDialogBtn.setMaximumSize(new Dimension(150, 30));
		tagDialogBtn.setAlignmentX(CENTER_ALIGNMENT);
		
		JButton folderDialogBtn = new JButton("Choose folders");
		folderDialogBtn.setMaximumSize(new Dimension(150, 30));
		folderDialogBtn.setAlignmentX(CENTER_ALIGNMENT);
		
		JButton resultsDialogBtn = new JButton("View results");
		resultsDialogBtn.setMaximumSize(new Dimension(150, 30));
		resultsDialogBtn.setAlignmentX(CENTER_ALIGNMENT);
		
		JButton userClassifBtn = new JButton("Classify folder");
		userClassifBtn.setMaximumSize(new Dimension(150, 30));
		userClassifBtn.setAlignmentX(CENTER_ALIGNMENT);

		
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
	
	public static void main(String[] args) {
		
		Menu menu = new Menu();
	}

}
