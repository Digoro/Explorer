package explorer;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		layout.setEditorAreaVisible(false);

		layout.addStandaloneView(TestView.ID, true, IPageLayout.LEFT,
				0.5f, layout.getEditorArea());
		
		layout.addStandaloneView(TestView2.ID, true, IPageLayout.RIGHT,
				0.5f, layout.getEditorArea());
	}
}
