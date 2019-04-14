package gui_swing;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import extensions.Tag;
import gui_functionality.TagDialogFunc;



public class TagDialog extends JFrame {

	private JPanel panel = new JPanel();
	private JButton addTagBtn;
	private JTable table;
	private JTextField nameTxtField;
	private JTextField tresholdTxtField;

	public TagDialog() {

		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Tags");
		setSize(500, 500);
		setContentPane(panel);
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 30));

		JLabel tagName = new JLabel("Enter tag name: ");
		tagName.setFont(new Font("Sans Serif", Font.BOLD, 15));
		tagName.setAlignmentX(LEFT_ALIGNMENT);
		
		nameTxtField = new JTextField();
		nameTxtField.setMaximumSize(new Dimension(430, 30));
		nameTxtField.setAlignmentX(LEFT_ALIGNMENT);
		tagName.setLabelFor(nameTxtField);

		JLabel tagTreshold = new JLabel("Enter tag treshold:");
		tagTreshold.setFont(new Font("Sans Serif", Font.BOLD, 15));
		
		tresholdTxtField = new JTextField();
		tresholdTxtField.setMaximumSize(new Dimension(430, 30));
		tresholdTxtField.setAlignmentX(LEFT_ALIGNMENT);
		tagTreshold.setLabelFor(tresholdTxtField);

		addTagBtn = new JButton("Add tag");
		addTagBtn.setMaximumSize(new Dimension(150, 30));

		table = new JTable(new DefaultTableModel (new String[][]{}, new String[]{ "No.", "Tag name", "Treshold" }));
		table.setAlignmentX(LEFT_ALIGNMENT);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		JScrollPane sp = new JScrollPane(table);
		sp.setAlignmentX(LEFT_ALIGNMENT);
		sp.setMaximumSize(new Dimension(430, 100));
		
		JButton closeBtn = new JButton("OK");
		closeBtn.setAlignmentX(LEFT_ALIGNMENT);
		closeBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
			}
		});
		
		panel.add(tagName);
		panel.add(Box.createRigidArea(new Dimension(10, 10)));
		panel.add(nameTxtField);
		panel.add(Box.createRigidArea(new Dimension(10, 10)));
		panel.add(tagTreshold);
		panel.add(Box.createRigidArea(new Dimension(10, 10)));
		panel.add(tresholdTxtField);
		panel.add(Box.createRigidArea(new Dimension(10, 15)));
		panel.add(addTagBtn);
		panel.add(Box.createRigidArea(new Dimension(10, 15)));
		panel.add(sp);
		panel.add(Box.createRigidArea(new Dimension(10, 15)));
		panel.add(closeBtn);
		panel.setVisible(true);
		
		TagDialogFunc tdf = new TagDialogFunc(this);
		
		setVisible(true);
	}
	

	public JButton getAddTagBtn(){
		return addTagBtn;
	}
	
	public JTable getTagDialogTable(){
		return table;
	}

	public JTextField getNameTxtField() {
		return nameTxtField;
	}

	public JTextField getTresholdTxtField() {
		return tresholdTxtField;
	}

}
