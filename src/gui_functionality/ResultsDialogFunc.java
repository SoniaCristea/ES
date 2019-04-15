package gui_functionality;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import extensions.Document;
import extensions.Tag;
import gui_swing.FolderDialog;
import gui_swing.ResultsDialog;
import gui_swing.TagDialog;

public class ResultsDialogFunc {

	private JTable table = new JTable();
	private JButton btnRun = new JButton();
	private JButton modifyTagsBtn = new JButton();
	private JButton clearBtn = new JButton();

	private int counter = 0;
	private TagDialogFunc tdf;
	private FolderDialogFunc fdf;
	private ArrayList<Tag> userClassifiedTags = new ArrayList<>();
	private DefaultTableModel model;

	public ResultsDialogFunc(ResultsDialog rd, TagDialog td, FolderDialog fd) {

		this.tdf = td.getTdf();
		this.fdf = fd.getFdf();

		table = rd.getTable();
		btnRun = rd.getBtnRun();
		modifyTagsBtn = rd.getModifyTagsBtn();
		clearBtn = rd.getClearBtn();

		model = (DefaultTableModel) table.getModel();
		ArrayList<Document> folders = fdf.getFolders();
		userClassifiedTags = tdf.getTags();

		for (Document d : folders) {
			d.setUserSelectedTags(userClassifiedTags);
			String isUserClass = "";
			if (d.isUserClassified()) {
				isUserClass = "yes";
			} else {
				isUserClass = "no";
			}

			// am vrut sa afisez doar numele Tag-ului, nu si treshold si blabla
			// sa arate mai frumos in tabel cand se afiseaza

			ArrayList<Tag> docTags = d.getTags();
			ArrayList<String> s = new ArrayList<>();
			// tags from the folder's tag list

			for (Tag t : docTags) {
				s.add(t.getName());
			}

			// user classified tags
			ArrayList<String> s1 = new ArrayList<>();
			for (Tag t : userClassifiedTags) {
				s1.add(t.getName());
			}
			model.addRow(new String[] { Integer.toString(++counter), d.getName(), s.toString(), isUserClass, s1.toString() });
		}
		
		
		modifyTagsBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				int index = table.getSelectedRow();
				if(index < 0) {
					JOptionPane.showMessageDialog(rd, "No row selected!");
					return;
				}
				td.setVisible(true);
				ArrayList<Tag> newTags = td.getTdf().getTags();
				ArrayList<String> tagNames = extractTagNames(newTags);
				table.setValueAt(tagNames, index, 4);
				model.fireTableDataChanged();
				
			}

		});
		
	}
	
	private ArrayList<String> extractTagNames(ArrayList<Tag> newTags) {
		
		ArrayList<String> list = new ArrayList<>();
		
		for(Tag t : newTags) {
			list.add(t.getName());
		}
		
		return list;
	}

}
