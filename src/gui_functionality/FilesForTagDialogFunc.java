package src.gui_functionality;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import src.extensions.Document;
import src.extensions.DocumentFolder;
import src.extensions.Tag;
import src.gui_swing.ClassificatioResultDialog;
import src.gui_swing.FilesForTagDialog;
import src.gui_swing.FolderDialog;
import src.gui_swing.ResultsDialog;
import src.gui_swing.TagDialog;
import src.gui_swing.TagsForFileDialog;

public class FilesForTagDialogFunc {
	private JTable table = new JTable();

	private int counter = 0;
	private ArrayList<Tag> tags=new ArrayList<>();
	
	private TagDialogFunc df;
	private TagsForFileDialogFunc tfd;


	public FilesForTagDialogFunc(FilesForTagDialog rd,TagsForFileDialog tfd, TagDialog d) {

		this.tfd=tfd.getUdf();
		this.df = d.getTdf();
		table = rd.getTable();
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		tags=df.getTags();
		
		for(Tag t :tags){
			if((t.getName()).equals(this.tfd.getTagName())){
				for(Document file:t.getFiles()){
					String tt=file.getTags().toString()+file.getUserSelectedTags().toString();
					model.addRow(new String[] { Integer.toString(++counter), file.getName(), file.getPath(),tt });
					
				}
			}
			
		}
		
	}
	
	

	public ArrayList<Tag> getTags() {
		return tags;
	}

}
