package src.gui_swing;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import src.gui_functionality.FolderDialogFunc;

public class FolderDialog extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel = new JPanel();
	private JCheckBox considerSubfoldersCB;
	private JTextField folderNameTxt;
	private JButton addFolderBtn;
	private JTable table;
	
	private FolderDialogFunc fdf;
	
	public FolderDialog(){
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Folders");
		setSize(500, 500);
		setContentPane(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 30));
		
		considerSubfoldersCB = new JCheckBox("Consider subfolders");
		considerSubfoldersCB.setFont(new Font("Sans Serif", Font.ITALIC, 17));
		
		JLabel folderName = new JLabel("Folder name: ");
		folderName.setFont(new Font("Sans Serif", Font.BOLD, 15));
		folderName.setAlignmentX(LEFT_ALIGNMENT);
		
		folderNameTxt = new JTextField();
		folderNameTxt.setMaximumSize(new Dimension(430, 30));
		folderNameTxt.setAlignmentX(LEFT_ALIGNMENT);
		folderName.setLabelFor(folderNameTxt);
		
		addFolderBtn = new JButton("Choose folder");
		addFolderBtn.setMaximumSize(new Dimension(150, 30));
		
		
		table = new JTable(new DefaultTableModel (new String[][]{}, new String[]{"No.", "Folder name"}));
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
		
		panel.add(considerSubfoldersCB);
		panel.add(Box.createRigidArea(new Dimension(10, 10)));
		panel.add(folderName);
		panel.add(Box.createRigidArea(new Dimension(10, 10)));
		panel.add(folderNameTxt);
		panel.add(Box.createRigidArea(new Dimension(10, 10)));
		panel.add(addFolderBtn);
		panel.add(Box.createRigidArea(new Dimension(10, 10)));
		panel.add(sp);
		panel.add(Box.createRigidArea(new Dimension(10, 10)));
		panel.add(btnClose);
		panel.setVisible(true);
		
		fdf = new FolderDialogFunc(this);
		setVisible(true);
	}

	public FolderDialogFunc getFdf() {
		return fdf;
	}


	public JCheckBox getConsiderSubfoldersCB() {
		return considerSubfoldersCB;
	}

	public JTextField getFolderNameTxt() {
		return folderNameTxt;
	}

	public JButton getAddFolderBtn() {
		return addFolderBtn;
	}

	public JTable getTable() {
		return table;
	}
	
	
	
}
