import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

public class FolderDialog extends Composite {
  private Text text;
  static Display display = new Display();
  private int index=0;
  private ArrayList<Document> txtFiles;
 
  /**
   * Create the composite.
   * @param parent
   * @param style
   */
  public FolderDialog(Composite parent, int style) {
      super(parent, style);
      setLayout(new FillLayout(SWT.HORIZONTAL));
      
      Composite composite = new Composite(this, SWT.NONE);
      composite.setLayout(new GridLayout(1, false));
      
      Button btnPreferredSite = new Button(composite, SWT.CHECK);
      btnPreferredSite.setText("Consider subfolders");
      
      Label lblColumnWidth = new Label(composite, SWT.NONE);
      lblColumnWidth.setText("Enter folder name:");
      
      Composite composite_1 = new Composite(composite, SWT.NONE);
      GridLayout gl_composite_1 = new GridLayout(2, false);
      gl_composite_1.marginHeight = 0;
      gl_composite_1.marginWidth = 0;
      composite_1.setLayout(gl_composite_1);
      composite_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
      
      text = new Text(composite_1, SWT.BORDER);
      text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
      
      Button btnNewButton = new Button(composite_1, SWT.NONE);
      btnNewButton.setLayoutData(new GridData(SWT.FILL, SWT.RIGHT, true, false, 1, 1));
      btnNewButton.setText("Add");
     


      Composite composite_2 = new Composite(composite, SWT.NONE);
//      GridLayout gl_composite_2 = new GridLayout(2, false);
//      gl_composite_2.marginHeight = 0;
//      gl_composite_2.marginWidth = 0;
//      composite_2.setLayout(gl_composite_2);
//      composite_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
      
      Table table = new Table(composite_2, SWT.BORDER | SWT.V_SCROLL
    	        | SWT.H_SCROLL);
    	    table.setHeaderVisible(true);
    	    table.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
    	  //  table.setSize(250, 500);
    	    String[] titles = { "No.", "Folder Name" };

    	  //  for (int loopIndex = 0; loopIndex < titles.length; loopIndex++) {
    	      TableColumn column1 = new TableColumn(table, SWT.NULL);
    	      column1.setWidth(40);
    	      column1.setText(titles[0]);
    	      
    	      TableColumn column2 = new TableColumn(table, SWT.NULL);
    	      column2.setWidth(400);
    	      column2.setText(titles[1]);
    	   // }

//    	    for (int loopIndex = 0; loopIndex < 24; loopIndex++) {
//    	      TableItem item = new TableItem(table, SWT.NULL);
//    	      
//    	      item.setText("Item " + loopIndex);
//    	      item.setText(0, "Item " + loopIndex);
//    	      item.setText(1, "Yes");
//    	      item.setText(2, "No");
//    	      item.setText(3, "A table item");
//    	    }

//    	    for (int loopIndex = 0; loopIndex < titles.length; loopIndex++) {
//    	      table.getColumn(loopIndex).pack();
//    	    }

    	   // table.setBounds(25, 25, 200, 200);
    	    table.setSize(470, 360);
    	    //table.setSize(table.computeSize(SWT.DEFAULT, 300));
    	    table.addListener(SWT.Selection, new Listener() {
    	      public void handleEvent(Event event) {
//    	        if (event.detail == SWT.CHECK) {
//    	          text.setText("You checked " + event.item);
//    	        } else {
//    	          text.setText("You selected " + event.item);
//    	        }
    	      }
    	    });
    	    
    	    
    	      Button enterTagBtn = new Button(composite_2, SWT.NONE);
    	      enterTagBtn.setLayoutData(new GridData(SWT.FILL, SWT.RIGHT, true, false, 1, 1));
    	      enterTagBtn.setText("Enter tag");

    	      enterTagBtn.addListener(SWT.Selection, new Listener() {
    	          public void handleEvent(Event e) {
    	              switch (e.type) {
    	              case SWT.Selection:
    	               // System.out.println("Button pressed");
    	                String enteredText=text.getText();
    	                if(enteredText == null || enteredText.isEmpty()){
    	                	MessageBox messageBox = new MessageBox(new Shell(display), SWT.ICON_WARNING );
    	                    
    	                    messageBox.setText("Warning");
    	                    messageBox.setMessage("Folder name cannot be empty");
    	                    messageBox.open();
    	                }
    	                break;
    	             
    	              }
    	            }
    	          });
    	      
    	      btnNewButton.addListener(SWT.Selection, new Listener() {
    	          public void handleEvent(Event e) {
    	              switch (e.type) {
    	              case SWT.Selection:
    	                System.out.println("Button pressed");
    	                String enteredText=text.getText();
    	                if(enteredText == null || enteredText.isEmpty()){
    	                	MessageBox messageBox = new MessageBox(new Shell(display), SWT.ICON_WARNING );
    	                    
    	                    messageBox.setText("Warning");
    	                    messageBox.setMessage("Folder name cannot be empty");
    	                    messageBox.open();
    	                }
    	                txtFiles=new ArrayList<>();
    	                ArrayList<Document> files=searchInFolder(text.getText());
    	                if(files.size()>0){
    	                	for(Document f:files){
    	                		TableItem item = new TableItem(table, SWT.NULL);
    	           	      
    	                		item.setText(0, index+"");
    	                		item.setText(1, f.getName());
    	                		index++;
    	                	}
    	                }
    	                break;
    	             
    	              }
    	            }
    	          });
     
 
  }
  
  public ArrayList<Document> searchInFolder(String folderr){
	  File folder = new File(folderr);
	  
	  if (folder.isDirectory()) {
	         File[] listOfFiles = folder.listFiles();
	         if (listOfFiles.length < 1)System.out.println(
	            "There is no File inside Folder");
	         else System.out.println("List of Files & Folder");
	         for (File file : listOfFiles) {
	            if(!file.isDirectory() && file.getName().endsWith(".txt")){
					try {
						System.out.println(
						   file.getCanonicalPath().toString());
						txtFiles.add(new Document(file.getName(),file.getCanonicalPath().toString(),false));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            }else if(file.isDirectory()){
					try {
						searchInFolder(file.getCanonicalPath().toString());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            }
	        
	         }
	      } 
	      else System.out .println("There is no Folder @ given path :" + folderr);
	  return txtFiles;
	  
  }
  
  public static void main(String[] args) {
     
      
      final Shell shell = new Shell(display);
      shell.setLayout(new FillLayout());
      shell.setSize(500,500);
 
      //
      Composite parent = new Composite(shell, SWT.NONE);
      
      FillLayout fillLayout= new FillLayout();
      fillLayout.type= SWT.VERTICAL;
      
      parent.setLayout(fillLayout);
 
      	FolderDialog f=new FolderDialog(parent, SWT.NONE);
      
      // Windows back to natural size.
    //  shell.pack();
      //
      shell.open();
      while (!shell.isDisposed()) {
          if (!display.readAndDispatch())
              display.sleep();
      }
      // tear down the SWT window
      display.dispose();
  }

}