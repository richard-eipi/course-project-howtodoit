package helpers;

import javafx.scene.control.Control;
import javafx.scene.layout.Pane;

/**
 * This class has some helper methods for setting up the scene for GUI.
 */
public class GUISceneSetUp {
    /**
     * Returns the top-left x-position required to center the control horizontally in the given pane.
     *
     * @param pane    the pane view root
     * @param control ex: button, text area, etc.
     * @return the corresponding top-left x-position
     */
    public static double xForCenter(Pane pane, Control control) {
        return (pane.getWidth() - control.getPrefWidth()) / 2;
    }
}
