package view;

import view.components.ImageFileChooser;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Optional;

public class ProductCreateView extends JPanel {

    //Layout information
    private int gridYLevel = 0;
    private JPanel formPanel;
    private GridBagConstraints formGrid;

    //Form Components
    private JLabel nameLabel;
    private JTextField nameInput;
    private JLabel descriptionLabel;
    private JTextArea descriptionArea;
    private JLabel costLabel;
    private JTextField costInput;
    private JLabel priceLabel;
    private JTextField priceInput;
    private JLabel quantityLabel;
    private JSpinner quantityInput;
    private JLabel imageLabel;
    private JButton imageButton;
    private JButton createButton;

    private Optional<File> selectedFile;

    private JLabel formError;

    public ProductCreateView() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());
        formGrid = new GridBagConstraints();
        formGrid.fill = GridBagConstraints.HORIZONTAL;
        formGrid.gridy = 0;
        formGrid.gridx = 0;
        formGrid.weightx = 1;

        nameLabel = new JLabel("Name");
        nameInput = new JTextField();
        nameLabel.setLabelFor(nameInput);

        addComponentToForm(nameLabel);
        addComponentToForm(nameInput);

        descriptionLabel = new JLabel("Description");
        descriptionArea = new JTextArea();
        descriptionArea.setLineWrap(true);
        descriptionArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        descriptionArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println(descriptionLabel.getVerticalTextPosition());
                super.keyTyped(e);
            }
        });
        addComponentToForm(descriptionLabel);
        addComponentToForm(descriptionArea);

        costLabel = new JLabel("Cost");
        costInput = new JTextField();
        addComponentToForm(costLabel);
        addComponentToForm(costInput);

        priceLabel = new JLabel("Price");
        priceInput = new JTextField();
        addComponentToForm(priceLabel);
        addComponentToForm(priceInput);

        quantityLabel = new JLabel("Quantity");
        addComponentToForm(quantityLabel);
        SpinnerModel model = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
        quantityInput = new JSpinner(model);
        addComponentToForm(quantityInput);

        //Image Chooser
        ImageFileChooser fc = new ImageFileChooser();
        imageLabel = new JLabel();
        imageLabel.setText("Image");
        imageButton = new JButton();
        imageButton.setText("Upload Image");
        imageButton.addActionListener((e) -> {
            int returnVal = fc.showOpenDialog(this);

            if(returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                selectedFile = Optional.of(file);
            }
        });
        addComponentToForm(imageLabel);
        addComponentToForm(imageButton);

        formError = new JLabel();
        formError.setVisible(false);

        addComponentToForm(formError);

        createButton = new JButton("Create");

        formGrid.ipady = 10;
        formGrid.gridheight = 40;
        formGrid.weighty = 20;
        formGrid.fill = GridBagConstraints.HORIZONTAL;

        addComponentToForm(createButton);

        formPanel.setPreferredSize(new Dimension(400, 400));
        formPanel.setMaximumSize(new Dimension(400, 400));
        formPanel.setBorder(new CompoundBorder(
        BorderFactory.createTitledBorder("Create New Product"),
        BorderFactory.createEmptyBorder(20, 20, 20, 20)));

        this.add(formPanel, gbc);
    }

    public String getName() {
        return this.nameInput.getText();
    }

    public String getDescription() {
        return this.descriptionArea.getText();
    }

    public double getPrice() throws ParseException {
        return DecimalFormat.getNumberInstance().parse(this.priceInput.getText()).doubleValue();
    }

    public double getCost() throws ParseException {
        return DecimalFormat.getNumberInstance().parse(this.costInput.getText()).doubleValue();
    }

    public int getQuantity() throws ParseException {
        return DecimalFormat.getNumberInstance().parse(this.quantityInput.getValue().toString()).intValue();
    }

    public Optional<File> getFile() {
        return this.selectedFile;
    }

    public void submitProduct(ActionListener actionListener) {
        createButton.addActionListener(actionListener);
    }

    private void addComponentToForm(JComponent c) {
        formGrid.gridy = gridYLevel++;
        formPanel.add(c, formGrid);
    }

    public void setFormError(String error) {
        formError.setVisible(true);
        formError.setForeground(Color.RED);
        formError.setText(error);
        formError.setFont(new Font("Courier", Font.BOLD, 14));
    }
}
