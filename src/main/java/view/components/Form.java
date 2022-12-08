package view.components;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import java.awt.*;

//Form is an example of the template method pattern
//We want our forms to have a specific look, but we also want subclasses to define the specific actions/elements in the form
//By using the template method pattern we can control for common actions like the layout code whilst also keeping form specific things
//in the control of subclasses
public abstract class Form extends JPanel {
    private int gridYLevel = 0;

    private GridBagConstraints _gbc;

    protected JPanel _formPanel;
    protected GridBagConstraints _formGrid;

    protected Form(String title) {
        this.setLayout(new GridBagLayout());
        _gbc = new GridBagConstraints();

        _formPanel = new JPanel();
        _formPanel.setLayout(new GridBagLayout());
        _formGrid = new GridBagConstraints();
        _formGrid.fill = GridBagConstraints.HORIZONTAL;
        _formGrid.gridy = 0;
        _formGrid.gridx = 0;
        _formGrid.weightx = 1;

        constructForm();

        _formPanel.setPreferredSize(new Dimension(400, 400));
        _formPanel.setMaximumSize(new Dimension(400, 400));
        _formPanel.setBorder(new CompoundBorder(
                BorderFactory.createTitledBorder(title),
                BorderFactory.createEmptyBorder(20, 20, 20, 20)));

        this.add(_formPanel, _gbc);
    }

    public abstract void constructForm();

    protected void addComponentToForm(JComponent c) {
        _formGrid.gridy = gridYLevel++;
        _formPanel.add(c, _formGrid);
    }
}
