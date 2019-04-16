package src.gui_swing;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import src.gui_functionality.TagsForFileDialogFunc;
import src.gui_functionality.UserAssignDialogFunc;

public class TagsForFileDialog extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel = new JPanel();
	private JButton addFolderBtn;
	private JTable table;
	
	private TagsForFileDialogFunc udf;
	
	public TagsForFileDialog(FolderDialog fd,TagDialog td){
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Show Files for tag");
		setSize(500, 500);
		setContentPane(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 30));

		addFolderBtn = new JButton("Choose tag for file");
		addFolderBtn.setMaximumSize(new Dimension(150, 30));
		
		
		table = new JTable(new DefaultTableModel (new String[][]{}, new String[]{"No.", "Tag"}));
		table.setAlignmentX(LEFT_ALIGNMENT);
		table.getColumnModel().getColumn(1).setPreferredWidth(300);
		
		JScrollPane sp = new JScrollPane(table);
		sp.setAlignmentX(LEFT_ALIGNMENT);
		sp.setMaximumSize(new Dimension(430, 100));
		
		JButton btnClose = new JButton("OK");
		btnClose.setAlignmentX(LEFT_ALIGNMENT);
		btnClose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		panel.add(Box.createRigidArea(new Dimension(10, 10)));
		panel.add(addFolderBtn);
		panel.add(Box.createRigidArea(new Dimension(10, 10)));
		panel.add(sp);
		panel.add(Box.createRigidArea(new Dimension(10, 10)));
		panel.add(btnClose);
		panel.setVisible(true);
		
		udf = new TagsForFileDialogFunc(this,fd,td);
		setVisible(true);
	}

	public TagsForFileDialogFunc getUdf() {
		return udf;
	}

	public JButton getAddFolderBtn() {
		return addFolderBtn;
	}

	public JTable getTable() {
		return table;
	}
	
}
	
	
