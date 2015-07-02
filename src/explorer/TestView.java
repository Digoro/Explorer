package explorer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;

public class TestView extends ViewPart{
	public TestView() {
	}

	public static final String ID = "Explorer.testView";

	public boolean isReadableFile(String path) {
		if (path == null)
			return false;
		File f = new File(path);
		if (f.isFile() == false || f.canRead() == false)
			return false;
		else
			return true;
	}

	public String load(String path) {
		try {
			BufferedReader r = new BufferedReader(new FileReader(path));
			StringBuffer sb = new StringBuffer();
			try {
				String line = r.readLine();
				while (line != null) {
					sb.append(line).append("\n");
					line = r.readLine();
				}
			} finally {
				if (r != null)
					r.close();
			}
			return sb.toString();
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public void createPartControl(Composite parent) {
		String path = "C:\\";
		
		this.setPartName(path);
		Composite top = new Composite(parent, SWT.NONE);
		top.setLayout(new FillLayout());
		Text text = new Text(top, SWT.MULTI);
		if (isReadableFile(path) == false)
			text.setText("can't read" + path);
		else
			text.setText(load(path));

	}

	public void setFocus() {
	}
}
