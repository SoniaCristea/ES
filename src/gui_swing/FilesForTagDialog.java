package src.gui_swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import src.gui_functionality.ClassificationResultDialogFunc;
import src.gui_functionality.FilesForTagDialogFunc;

public class FilesForTagDialog extends JFrame{
	
	private JPanel panel = new JPanel();
	private JPanel buttonsPannel = new JPanel();
	private JTable table;

	
	public FilesForTagDialog(TagsForFileDialog td,TagDialog fd) {
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("User actions");
		setSize(700, 600);
		setContentPane(panel);
		panel.setLayout(new BorderLayout());
		panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 30));
		
		buttonsPannel.setLayout(new GridLayout(1, 3));
		
		table = new JTable(new DefaultTableModel (new String[][]{}, new String[]{"No.", "File name", "Path","Tags"}));
		table.getColumnModel().getColumn(0).setPreferredWidth(20);
		table.setAlignmentX(LEFT_ALIGNMENT);
		
		JScrollPane sp = new JScrollPane(table);
		sp.setAlignmentX(LEFT_ALIGNMENT);
		panel.add(sp);
		sp.setMaximumSize(new Dimension(620, 300));
		panel.setVisible(true);
		
		
	
		panel.add(buttonsPannel,BorderLayout.SOUTH);
		
//		ClassificationResultDialogFunc rdf = 
				new FilesForTagDialogFunc(this,td,fd);
		
		setVisible(true);
	}

	public JTable getTable() {
		return table;
	}


	
}