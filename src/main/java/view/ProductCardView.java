package view;

import infastructure.Observer;
import infastructure.ViewManager;
import model.Product;
import view.utility.LinkLabel;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ProductCardView extends JPanel implements IProductView {

    private Product _product;

    private JButton _addButton;

    public ProductCardView(Product product) {
        this._product = product;

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(Color.WHITE);
        this.setBorder(new CompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));

        JLabel label = new JLabel();
        label.setText(product.getLabel());
        label.setFont(new Font("Courier", Font.BOLD, 16));
        label.addMouseListener(new LinkLabel());


        JLabel desc = new JLabel();
        desc.setText(product.getDescription());

        JLabel price = new JLabel();
        price.setText("$" + String.valueOf(product.getPrice()));
        price.setFont(new Font("Courier", Font.BOLD, 14));

        _addButton = new JButton();
        _addButton.setText("Add to Cart");

        this.add(label);
        this.add(desc);
        this.add(price);
        this.add(_addButton);
    }

    @Override
    public void handleAddToCart(ActionListener e) {
        _addButton.addActionListener(e);
    }

    @Override
    public Product getProduct() {
        return _product;
    }
}
