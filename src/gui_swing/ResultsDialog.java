package src.gui_swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import src.gui_functionality.ResultsDialogFunc;

public class ResultsDialog extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel = new JPanel();
	private JPanel buttonsPannel = new JPanel();
	private JTable table;
	private JButton btnRun;
	private JButton modifyTagsBtn;
	private JButton clearBtn;
	private ResultsDialogFunc rdf;
	
	public ResultsDialog(TagDialog td, FolderDialog fd) {
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("User actions");
		setSize(700, 600);
		setContentPane(panel);
		panel.setLayout(new BorderLayout());
		panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 30));
		
		buttonsPannel.setLayout(new GridLayout(1, 3));
		
		table = new JTable(new DefaultTableModel (new String[][]{}, new String[]{"No.", "Path", "Folder name","Subfolders"}));
		table.getColumnModel().getColumn(0).setPreferredWidth(20);
		table.setAlignmentX(LEFT_ALIGNMENT);
		
		JScrollPane sp = new JScrollPane(table);
		sp.setAlignmentX(LEFT_ALIGNMENT);
		panel.add(sp);
		sp.setMaximumSize(new Dimension(620, 300));
		panel.setVisible(true);
		
		btnRun = new JButton("Run");
		btnRun.setAlignmentX(LEFT_ALIGNMENT);
		btnRun.setMaximumSize(new Dimension(200, 30));
		
		modifyTagsBtn = new JButton("Modify tags");
		modifyTagsBtn.setAlignmentX(CENTER_ALIGNMENT);
		modifyTagsBtn.setMaximumSize(new Dimension(200, 30));
		
		clearBtn = new JButton("Clear user classification");
		clearBtn.setAlignmentX(CENTER_ALIGNMENT);
		clearBtn.setMaximumSize(new Dimension(200, 30));
		
		
		buttonsPannel.add(btnRun);	
		buttonsPannel.add(modifyTagsBtn);	
		buttonsPannel.add(clearBtn);	
		
		panel.add(buttonsPannel,BorderLayout.SOUTH);
		
		rdf = new ResultsDialogFunc(this, td, fd);
		
		setVisible(true);
	}

	public JTable getTable() {
		return table;
	}

	public JButton getBtnRun() {
		return btnRun;
	}

	public JButton getModifyTagsBtn() {
		return modifyTagsBtn;
	}

	public JButton getClearBtn() {
		return clearBtn;
	}

	public ResultsDialogFunc getRdf() {
		return rdf;
	}
	
	
	
}
