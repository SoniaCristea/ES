package src.gui_functionality;


import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import src.extensions.Document;
import src.extensions.Tag;
import src.gui_swing.ClassificatioResultDialog;
import src.gui_swing.ResultsDialog;

public class ClassificationResultDialogFunc  {

	private JTable table = new JTable();

	private int counter = 0;
	private ArrayList<Document> classifiedFiles=new ArrayList<>();
	
	private ResultsDialogFunc df;

	public ClassificationResultDialogFunc(ClassificatioResultDialog rd, ResultsDialog d) {

		this.df = d.getRdf();
		table = rd.getTable();
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		classifiedFiles=df.getClassifiedFiles();
		
		for(Document file:classifiedFiles){
			String isUserClass = "";
			if (file.isUserClassified()) {
				isUserClass = "yes";
			} else {
				isUserClass = "no";
			}
			
			
			ArrayList<String> s = new ArrayList<>();
			// tags from the folder's tag list

			for (Tag t : file.getTags()) {
				s.add(t.getName());
			}

			// user classified tags
			ArrayList<String> s1 = new ArrayList<>();
			for (Tag t : file.getUserSelectedTags()) {
				s1.add(t.getName());
			}
			
			model.addRow(new String[] { Integer.toString(++counter), file.getName(), s.toString(), isUserClass, s1.toString() });
		}
		
	}
	
	

	public ArrayList<Document> getClassifiedFiles() {
		return classifiedFiles;
	}

}
