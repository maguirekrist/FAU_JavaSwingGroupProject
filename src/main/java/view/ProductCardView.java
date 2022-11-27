package view;

import infastructure.Observer;
import infastructure.ViewManager;
import model.Product;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ProductCardView extends JPanel implements Observer<Product> {

    private Product product;

    public ProductCardView(Product product) {
        this.product = product;

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(Color.WHITE);
        this.setBorder(new CompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));

        JLabel label = new JLabel();
        label.setText(product.getLabel());
        label.setFont(new Font("Courier", Font.BOLD, 16));

        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                label.setCursor(new Cursor(Cursor.HAND_CURSOR));
                label.setForeground(Color.BLUE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                label.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                label.setForeground(Color.BLACK);
            }
        });

        JLabel desc = new JLabel();
        desc.setText(product.getDescription());

        JLabel price = new JLabel();
        price.setText("$" + String.valueOf(product.getPrice()));
        price.setFont(new Font("Courier", Font.BOLD, 14));

        JButton addToCart = new JButton();
        addToCart.setText("Add to Cart");

        this.add(label);
        this.add(desc);
        this.add(price);
        this.add(addToCart);
    }

    @Override
    public void update(Product obj) {

    }

}
