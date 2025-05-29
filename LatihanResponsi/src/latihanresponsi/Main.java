package latihanresponsi;

import latihanresponsi.model.ModelApotek;
import latihanresponsi.view.ViewApotek;
import latihanresponsi.controller.ControllerApotek;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            ModelApotek model = new ModelApotek();
            ViewApotek view = new ViewApotek();
            ControllerApotek controller = new ControllerApotek(view);
            view.setVisible(true);
        });
    }
}
