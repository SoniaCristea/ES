package src.gui;
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

public class ResultDialog extends Composite{
	 private Text text;
	  static Display display = new Display();
	 
	  /**
	   * Create the composite.
	   * @param parent
	   * @param style
	   */
	  public ResultDialog(Composite parent, int style) {
	      super(parent, style);
	      setLayout(new FillLayout(SWT.HORIZONTAL));
	      
	      Composite composite = new Composite(this, SWT.NONE);
	      composite.setLayout(new GridLayout(1, false));
	 
	      Composite composite_2 = new Composite(composite, SWT.NONE);
//	      GridLayout gl_composite_2 = new GridLayout(2, false);
//	      gl_composite_2.marginHeight = 0;
//	      gl_composite_2.marginWidth = 0;
//	      composite_2.setLayout(gl_composite_2);
//	      composite_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
	      
	      Table table = new Table(composite_2, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL | SWT.CHECK);
	      table.setHeaderVisible(true);
	      table.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
	    	  //  table.setSize(250, 500);
	    	    String[] titles = { "No.", "Filename" , "Tags", "User classified" , "User selected tags"};

	    	  //  for (int loopIndex = 0; loopIndex < titles.length; loopIndex++) {
	    	      TableColumn column1 = new TableColumn(table, SWT.NULL);
	    	      column1.setWidth(40);
	    	      column1.setText(titles[0]);
	    	      
	    	      TableColumn column2 = new TableColumn(table, SWT.NULL);
	    	      column2.setWidth(180);
	    	      column2.setText(titles[1]);
	    	      
	    	      TableColumn column3 = new TableColumn(table, SWT.NULL);
	    	      column3.setWidth(400);
	    	      column3.setText(titles[2]);
	    	      
	    	      TableColumn column4 = new TableColumn(table, SWT.NULL);
	    	      column4.setWidth(100);
	    	      column4.setText(titles[3]);
	    	      
	    	      TableColumn column5 = new TableColumn(table, SWT.NULL);
	    	      column5.setWidth(400);
	    	      column5.setText(titles[4]);
	    	      
//	    	      Button b = new Button(table, SWT.CHECK);
//	    	      b.pack();
	    	   // }

	    	    for (int loopIndex = 0; loopIndex < 24; loopIndex++) {
	    	      TableItem item = new TableItem(table, SWT.NULL);
	    	      
	    	      item.setText("Item " + loopIndex);
	    	      item.setText(0, "Item " + loopIndex);
	    	      item.setText(1, "Yes");
	    	      item.setText(2, "No");
	    	      item.setText(3, "A table item");
	    	    }

//	    	    for (int loopIndex = 0; loopIndex < titles.length; loopIndex++) {
//	    	      table.getColumn(loopIndex).pack();
//	    	    }

	    	   // table.setBounds(25, 25, 200, 200);
	    	    table.setSize(1150, 500);
	    	    //table.setSize(table.computeSize(SWT.DEFAULT, 300));
	    	    table.addListener(SWT.Selection, new Listener() {
	    	      public void handleEvent(Event event) {
//	    	        if (event.detail == SWT.CHECK) {
//	    	          text.setText("You checked " + event.item);
//	    	        } else {
//	    	          text.setText("You selected " + event.item);
//	    	        }
	    	      }
	    	    });
	     
	    	    
	    	    Composite composite_1 = new Composite(composite, SWT.NONE);
	    	    GridLayout gl_composite_1 = new GridLayout(3, false);
	    	    gl_composite_1.marginHeight = 0;
	    	    gl_composite_1.marginWidth = 0;
	    	    composite_1.setLayout(gl_composite_1);
	    	    composite_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
	 

	    	      Button runBtn = new Button(composite_1, SWT.NONE);
	    	      runBtn.setLayoutData(new GridData(SWT.FILL, SWT.RIGHT, true, false, 1, 1));
	    	      runBtn.setText("Run");

	    	      runBtn.addListener(SWT.Selection, new Listener() {
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
	    	                break;
	    	             
	    	              }
	    	            }
	    	          });
	    	      
	    	      Button modifyTagBtn = new Button(composite_1, SWT.NONE);
	    	      modifyTagBtn.setLayoutData(new GridData(SWT.FILL, SWT.RIGHT, true, false, 1, 1));
	    	      modifyTagBtn.setText("Modifiy Tags");

	    	      modifyTagBtn.addListener(SWT.Selection, new Listener() {
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
	    	                break;
	    	             
	    	              }
	    	            }
	    	          });

	    	      Button clearUsrClassBtn = new Button(composite_1, SWT.NONE);
	    	      clearUsrClassBtn.setLayoutData(new GridData(SWT.FILL, SWT.RIGHT, true, false, 1, 1));
	    	      clearUsrClassBtn.setText("Clear user classification");

	    	      clearUsrClassBtn.addListener(SWT.Selection, new Listener() {
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
	    	                break;
	    	             
	    	              }
	    	            }
	    	          });
	  }
	  
	  public static void main(String[] args) {
	     
	      
	      final Shell shell = new Shell(display);
	      shell.setLayout(new FillLayout());
	      shell.setSize(1200,700);
	 
	      //
	      Composite parent = new Composite(shell, SWT.NONE);
	      
	      FillLayout fillLayout= new FillLayout();
	      fillLayout.type= SWT.VERTICAL;
	      
	      parent.setLayout(fillLayout);
	 
	      ResultDialog f=new ResultDialog(parent, SWT.NONE);
	      
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
