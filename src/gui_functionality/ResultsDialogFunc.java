package src.gui_functionality;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import src.extensions.Document;
import src.extensions.DocumentFolder;
import src.extensions.Tag;
import src.gui_swing.ClassificatioResultDialog;
import src.gui_swing.FolderDialog;
import src.gui_swing.ListOfTagsDialog;
import src.gui_swing.ResultsDialog;
import src.gui_swing.TagDialog;
import src.gui_swing.UserAssignDialog;
import src.util.Classifier;

public class ResultsDialogFunc {

	private JTable table = new JTable();
	private JButton btnRun = new JButton();
	private JButton modifyTagsBtn = new JButton();
	private JButton clearBtn = new JButton();

	private int counter = 0;
	private TagDialogFunc tdf;
	private FolderDialogFunc fdf;
	// private ArrayList<Tag> userClassifiedTags = new ArrayList<>();
	// private DefaultTableModel model;
	private Classifier c;
	private ArrayList<Document> classifiedFiles = new ArrayList<>();

	public ResultsDialogFunc(ResultsDialog rd, TagDialog td, FolderDialog fd) {

		this.tdf = td.getTdf();
		this.fdf = fd.getFdf();

		table = rd.getTable();
		btnRun = rd.getBtnRun();
		modifyTagsBtn = rd.getModifyTagsBtn();
		clearBtn = rd.getClearBtn();

		DefaultTableModel model = (DefaultTableModel) table.getModel();
		ArrayList<DocumentFolder> folders = fdf.getFolders();
		// userClassifiedTags = tdf.getTags();

		for (DocumentFolder f : folders) {
			String considerSufolders = f.isConsiderSubfolders() ? "yes" : "no";
			model.addRow(new String[] { Integer.toString(++counter), f.getFullPath(), f.getName(), considerSufolders });
		}

		modifyTagsBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				int index = table.getSelectedRow();
				if (index < 0) {
					JOptionPane.showMessageDialog(rd, "No row selected!");
					return;
				}
				new UserAssignDialog(fd, td);
				// td.setVisible(true);
				// ArrayList<Tag> newTags = td.getTdf().getTags();
				// ArrayList<String> tagNames = extractTagNames(newTags);
				// table.setValueAt(tagNames, index, 4);
				// model.fireTableDataChanged();

			}

		});

		btnRun.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				int index = table.getSelectedRow();
				if (index < 0) {
					JOptionPane.showMessageDialog(rd, "No row selected!");
					return;
				}
				String folder = (String) table.getModel().getValueAt(index, 1);
				System.out.println(folder);

				for (DocumentFolder f : folders) {
					if (f.getFullPath().equals(folder))
						c = new Classifier(tdf);
					classifiedFiles = c.classify(f);
				}
				new ClassificatioResultDialog(rd);

			}

		});

		clearBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				for (Document d : classifiedFiles) {

					ArrayList<Tag> userSelectedTags = d.getUserSelectedTags();
					userSelectedTags = new ArrayList<Tag>();
					d.setUserSelectedTags(userSelectedTags);
					d.setUserClassified(false);
				}
			}
		});
	}

	private ArrayList<String> extractTagNames(ArrayList<Tag> newTags) {

		ArrayList<String> list = new ArrayList<>();

		for (Tag t : newTags) {
			list.add(t.getName());
		}

		return list;
	}

	public ArrayList<Document> getClassifiedFiles() {
		return classifiedFiles;
	}

}
