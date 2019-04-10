package gui_swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ResultsDialog extends JFrame{
	
	private JPanel panel = new JPanel();
	private JPanel buttonsPannel = new JPanel();
	
	public ResultsDialog() {
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Results");
		setSize(700, 600);
		setContentPane(panel);
		panel.setLayout(new BorderLayout());
		panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 30));
		
		buttonsPannel.setLayout(new GridLayout(1, 3));
		String[][] data = {};
		String[] columnNames = { "No.", "File name", "Tags","User classified", "User selected tags"};
		JTable table = new JTable(data, columnNames);
		table.setAlignmentX(LEFT_ALIGNMENT);
		
		JScrollPane sp = new JScrollPane(table);
		sp.setAlignmentX(LEFT_ALIGNMENT);
		panel.add(sp);
		sp.setMaximumSize(new Dimension(620, 300));
		panel.setVisible(true);
		
		JButton btnRun = new JButton("Run");
		btnRun.setAlignmentX(LEFT_ALIGNMENT);
		btnRun.setMaximumSize(new Dimension(200, 30));
		
		JButton modifyTagsBtn = new JButton("Modify tags");
		modifyTagsBtn.setAlignmentX(CENTER_ALIGNMENT);
		modifyTagsBtn.setMaximumSize(new Dimension(200, 30));
		
		JButton clearBtn = new JButton("Clear user classification");
		clearBtn.setAlignmentX(CENTER_ALIGNMENT);
		clearBtn.setMaximumSize(new Dimension(200, 30));
		
		
		buttonsPannel.add(btnRun);	
		buttonsPannel.add(modifyTagsBtn);	
		buttonsPannel.add(clearBtn);	
		
		panel.add(buttonsPannel,BorderLayout.SOUTH);
		
		setVisible(true);

	}
	
}
