import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import model.QLSVModel;
import view.QLSVView;

public class QLSVController {
    private QLSVModel model;
    private QLSVView view;

    public QLSVController(QLSVModel model, QLSVView view) {
        this.model = model;
        this.view = view;

        // Add action listeners to the view's buttons
        // this.view.addSaveButtonListener(new SaveButtonListener());
        // this.view.addEditButtonListener(new EditButtonListener());
        // this.view.addSwitchViewButtonListener(new SwitchViewButtonListener());
    }


}
