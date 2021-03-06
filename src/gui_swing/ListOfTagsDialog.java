package src.gui_swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import src.gui_functionality.ListOfTagsDialogFunc;
import src.gui_swing.TagDialog;

public class ListOfTagsDialog extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel = new JPanel();
	private JPanel buttonsPannel = new JPanel();
	private JButton addTagBtn;
	private JTable table;
	private JButton btnClose;
	private JButton deleteBtn;
	
	private ListOfTagsDialogFunc tdf;

	public ListOfTagsDialog(UserAssignDialog ud,TagDialog tdff) {

		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Tags");
		setSize(500, 500);
		setContentPane(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 30));
		
		buttonsPannel.setLayout(new GridLayout(1, 2));

		JLabel tagName = new JLabel("Select tag for file: ");
		tagName.setFont(new Font("Sans Serif", Font.BOLD, 15));
		tagName.setAlignmentX(LEFT_ALIGNMENT);
		
		addTagBtn = new JButton("Add tag");
		addTagBtn.setAlignmentX(LEFT_ALIGNMENT);
		addTagBtn.setMaximumSize(new Dimension(150, 30));
		
		deleteBtn = new JButton("Delete tag");
		deleteBtn.setAlignmentX(LEFT_ALIGNMENT);
		deleteBtn.setMaximumSize(new Dimension(150, 30));

		table = new JTable(new DefaultTableModel (new String[][]{}, new String[]{ "No.", "Tag name", "Treshold" }));
		table.setAlignmentX(LEFT_ALIGNMENT);
//		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		JScrollPane sp = new JScrollPane(table);
		sp.setAlignmentX(LEFT_ALIGNMENT);
		sp.setMaximumSize(new Dimension(430, 100));
		
		buttonsPannel.add(addTagBtn);
		buttonsPannel.add(deleteBtn);
		
		btnClose = new JButton("OK");
		btnClose.setAlignmentX(LEFT_ALIGNMENT);
		btnClose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		
		panel.add(tagName);
		panel.add(Box.createRigidArea(new Dimension(10, 15)));
		panel.add(buttonsPannel,BorderLayout.SOUTH);
//		panel.add(addTagBtn);
//		panel.add(Box.createRigidArea(new Dimension(10, 15)));
		panel.add(sp);
		panel.add(Box.createRigidArea(new Dimension(10, 15)));
		panel.add(btnClose);
		panel.setVisible(true);
		
		tdf = new ListOfTagsDialogFunc(this,tdff,ud);
		setVisible(true);
	}
	
	
	public JButton getBtnClose() {
		return btnClose;
	}
	
	public JButton getBtnDelete() {
		return deleteBtn;
	}

	public void setBtnDeleteVisible(boolean flag) {
		deleteBtn.setVisible(flag);
	}


	public ListOfTagsDialogFunc getTdf() {
		return tdf;
	}

	public JButton getAddTagBtn(){
		return addTagBtn;
	}
	
	public JTable getTagDialogTable(){
		return table;
	}

//	public JTextField getNameTxtField() {
//		return nameTxtField;
//	}
//
//	public JTextField getTresholdTxtField() {
//		return tresholdTxtField;
//	}
//	

}