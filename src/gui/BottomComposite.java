package src.gui;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
 
public class BottomComposite extends Composite {
  private Text text;
 
  /**
   * Create the composite.
   * @param parent
   * @param style
   */
  public BottomComposite(Composite parent, int style) {
      super(parent, style);
      setLayout(new FillLayout(SWT.HORIZONTAL));
      
      Composite composite = new Composite(this, SWT.NONE);
      composite.setLayout(new GridLayout(1, false));
      
     
      
     
      text = new Text(composite, SWT.BORDER | SWT.MULTI);
      text.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
 
  }
 
  @Override
  protected void checkSubclass() {
      // Disable the check that prevents subclassing of SWT components
  }
 
}