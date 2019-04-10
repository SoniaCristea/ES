package gui_swing;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import org.eclipse.swt.events.MouseAdapter;


public class TagDialog extends JFrame {

	private JPanel panel = new JPanel();

	public TagDialog() {

		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setSize(500, 500);
		setContentPane(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 30));

		JLabel tagName = new JLabel("Enter tag name: ");
		tagName.setFont(new Font("Sans Serif", Font.BOLD, 15));
		tagName.setAlignmentX(LEFT_ALIGNMENT);
		JTextField nameTxtField = new JTextField();
		nameTxtField.setMaximumSize(new Dimension(430, 30));
		nameTxtField.setAlignmentX(LEFT_ALIGNMENT);
		tagName.setLabelFor(nameTxtField);

		JLabel tagTreshold = new JLabel("Enter tag treshold:");
		tagTreshold.setFont(new Font("Sans Serif", Font.BOLD, 15));
		JTextField tresholdTxtField = new JTextField();
		tresholdTxtField.setMaximumSize(new Dimension(430, 30));
		tresholdTxtField.setAlignmentX(LEFT_ALIGNMENT);
		tagTreshold.setLabelFor(tresholdTxtField);

		JButton addTagBtn = new JButton("Add tag");
		addTagBtn.setMaximumSize(new Dimension(150, 30));

		String[][] data = {};
		String[] columnNames = { "No.", "Tag name", "Treshold" };
		JTable table = new JTable(data, columnNames);
		table.setAlignmentX(LEFT_ALIGNMENT);
		table.getModel().addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				// TODO Auto-generated method stub
				
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
		
		JScrollPane sp = new JScrollPane(table);
		sp.setAlignmentX(LEFT_ALIGNMENT);
		panel.add(sp);
		sp.setMaximumSize(new Dimension(430, 100));
		panel.setVisible(true);

		setVisible(true);
	}
//
//	public static void main(String[] args) {
//
//		TagDialog td = new TagDialog();
//	}

}
