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

public class TagDialog extends Composite {
  private Text tagText;
  private Text thresholdText;
  static Display display = new Display();
  private Shell shell;
 
  /**
   * Create the composite.
   * @param parent
   * @param style
   */
  public TagDialog(Composite parent, int style) {
      super(parent, style);
      shell=new Shell(Display.getCurrent());
      setLayout(new FillLayout(SWT.HORIZONTAL));
      
      Composite composite = new Composite(this, SWT.NONE);
      composite.setLayout(new GridLayout(1, false));
      
      Label lblColumnWidth = new Label(composite, SWT.NONE);
      lblColumnWidth.setText("Enter tag name:");
      
      Composite composite_1 = new Composite(composite, SWT.NONE);
      GridLayout gl_composite_1 = new GridLayout(2, false);
      gl_composite_1.marginHeight = 0;
      gl_composite_1.marginWidth = 0;
      composite_1.setLayout(gl_composite_1);
      composite_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
      
      tagText = new Text(composite_1, SWT.BORDER);
      tagText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
      
      
      
      Label lblThreshold = new Label(composite, SWT.NONE);
      lblThreshold.setText("Enter tag threshold:");
      
      Composite composite_2 = new Composite(composite, SWT.NONE);
      GridLayout gl_composite_2 = new GridLayout(2, false);
      gl_composite_2.marginHeight = 0;
      gl_composite_2.marginWidth = 0;
      composite_2.setLayout(gl_composite_2);
      composite_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
      
      thresholdText = new Text(composite_2, SWT.BORDER);
      thresholdText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
      
      Button btnNewButton = new Button(composite_2, SWT.NONE);
      btnNewButton.setLayoutData(new GridData(SWT.FILL, SWT.RIGHT, true, false, 1, 1));
      btnNewButton.setText("Add Tag");
      
      btnNewButton.addListener(SWT.Selection, new Listener() {
          public void handleEvent(Event e) {
              switch (e.type) {
              case SWT.Selection:
                System.out.println("Button pressed");
                String enteredTagText=tagText.getText();
                String enteredThresholdText=thresholdText.getText();
                
                if((enteredTagText == null || enteredTagText.isEmpty()) && (enteredThresholdText == null || enteredThresholdText.isEmpty())){
                	MessageBox messageBox = new MessageBox(new Shell(Display.getCurrent()), SWT.ICON_WARNING );
                    
                    messageBox.setText("Warning");
                    messageBox.setMessage("Name and threshold cannot be empty");
                    messageBox.open();
                    break;
                }
                
                if(enteredTagText == null || enteredTagText.isEmpty()){
                	MessageBox messageBox = new MessageBox(new Shell(Display.getCurrent()), SWT.ICON_WARNING );
                    
                    messageBox.setText("Warning");
                    messageBox.setMessage("Tag name cannot be empty");
                    messageBox.open();
                }
                if(enteredThresholdText == null || enteredThresholdText.isEmpty()){
                	MessageBox messageBox = new MessageBox(new Shell(Display.getCurrent()), SWT.ICON_WARNING );
                    
                    messageBox.setText("Warning");
                    messageBox.setMessage("Threshold cannot be empty");
                    messageBox.open();
                }
                break;
             
              }
            }
          });


      
//      Button btnNewButton = new Button(composite_1, SWT.NONE);
//      btnNewButton.setLayoutData(new GridData(SWT.FILL, SWT.RIGHT, true, false, 1, 1));
//      btnNewButton.setText("Add");



      Composite composite_3 = new Composite(composite, SWT.NONE);
//      GridLayout gl_composite_3 = new GridLayout(2, false);
//      gl_composite_3.marginHeight = 0;
//      gl_composite_3.marginWidth = 0;
//      composite_3.setLayout(gl_composite_3);
//      composite_3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
      
      Table table = new Table(composite_3, SWT.BORDER | SWT.V_SCROLL
    	        | SWT.H_SCROLL);
    	    table.setHeaderVisible(true);
    	    table.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
    	  //  table.setSize(250, 500);
    	    String[] titles = { "No.", "Tag Name" , "Threshold" };

    	    TableColumn column1 = new TableColumn(table, SWT.NULL);
    	    column1.setWidth(40);
  	      	column1.setText(titles[0]);
  	      
  	      	TableColumn column2 = new TableColumn(table, SWT.NULL);
  	      	column2.setWidth(335);
  	      	column2.setText(titles[1]);
  	      	
  	      TableColumn column3 = new TableColumn(table, SWT.NULL);
	      	column3.setWidth(70);
	      	column3.setText(titles[2]);
  	      	
    	    for (int loopIndex = 0; loopIndex < 24; loopIndex++) {
    	      TableItem item = new TableItem(table, SWT.NULL);
    	      
    	      item.setText("Item " + loopIndex);
    	      item.setText(0, "Item " + loopIndex);
    	      item.setText(1, "Yes");
    	      item.setText(2, "No");
    	      item.setText(3, "A table item");
    	    }

//    	    for (int loopIndex = 0; loopIndex < titles.length; loopIndex++) {
//    	      table.getColumn(loopIndex).pack();
//    	    }
//
//    	    table.setBounds(25, 25, 200, 200);
    	    table.setSize(470, 360);

    	    table.addListener(SWT.Selection, new Listener() {
    	      public void handleEvent(Event event) {
//    	        if (event.detail == SWT.CHECK) {
//    	          text.setText("You checked " + event.item);
//    	        } else {
//    	          text.setText("You selected " + event.item);
//    	        }
    	      }
    	    });
     
 
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
 
      	TagDialog f=new TagDialog(parent, SWT.NONE);
      
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