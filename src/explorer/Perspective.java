package explorer;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		layout.setEditorAreaVisible(false);

		layout.addStandaloneView(TestView.ID, false, IPageLayout.LEFT,
				0.5f, layout.getEditorArea());
	}
}
