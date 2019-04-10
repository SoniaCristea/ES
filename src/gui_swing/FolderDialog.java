package gui_swing;

import java.awt.Dimension;
import java.awt.Font;

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
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

public class FolderDialog extends JFrame{
	
	private JPanel panel = new JPanel();
	
	public FolderDialog(){
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setSize(500, 500);
		setContentPane(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 30));
		
		JCheckBox considerSubfoldersCB = new JCheckBox("Consider subfolders");
		considerSubfoldersCB.setFont(new Font("Sans Serif", Font.BOLD, 17));
		
		JLabel folderName = new JLabel("Enter folder name: ");
		folderName.setFont(new Font("Sans Serif", Font.BOLD, 15));
		folderName.setAlignmentX(LEFT_ALIGNMENT);
		
		JTextField folderNameTxt = new JTextField();
		folderNameTxt.setMaximumSize(new Dimension(430, 30));
		folderNameTxt.setAlignmentX(LEFT_ALIGNMENT);
		folderName.setLabelFor(folderNameTxt);
		
		JButton addFolderBtn = new JButton("Add folder");
		addFolderBtn.setMaximumSize(new Dimension(150, 30));
		
		String[][] data = {};
		String[] columnNames = { "No.", "Folder name"};
		JTable table = new JTable(data, columnNames);
		table.setAlignmentX(LEFT_ALIGNMENT);
		table.getModel().addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				// TODO Auto-generated method stub
				
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
		

		JScrollPane sp = new JScrollPane(table);
		sp.setAlignmentX(LEFT_ALIGNMENT);
		panel.add(sp);
		sp.setMaximumSize(new Dimension(430, 100));
		panel.setVisible(true);
		
		setVisible(true);
	}
	
}
