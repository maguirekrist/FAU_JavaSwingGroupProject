package infastructure;

import com.google.gson.reflect.TypeToken;
import controller.MenuBarController;
import controller.ProductCreateController;
import model.Product;
import model.User;
import model.UserType;
import view.LoginView;
import view.ProductCreateView;
import view.ProductsView;
import view.components.MenuBar;
import view.utility.Views;

import javax.swing.*;
import java.awt.*;
import java.util.Stack;

public class ViewManager extends JFrame {

    private Views _activeView;

    private CardLayout _cardLayout;
    private Stack<Views> _viewHistory = new Stack<>();

    //Repositories
    private IRepository<Product> _productsRepository;
    private IRepository<Product> _shoppingCartRepository;

    //ViewManager takes Repositories
    public ViewManager(
            IRepository<Product> productsRepository,
            IRepository<Product> shoppingCartRepository
    ) {
        super("OOP Group Project MVC");
        _productsRepository = productsRepository;
        _shoppingCartRepository = shoppingCartRepository;


        _cardLayout = new CardLayout();
        this.setLayout(_cardLayout);

        //setup views
        var productCreateView = new ProductCreateView();
        var loginView = new LoginView();
        var productsView = new ProductsView(_productsRepository);

        var menuBar = new MenuBar(new User("maguire", "pass123", UserType.SELLER));

        this.add(productCreateView, Views.AddProduct.name());
        this.add(loginView, Views.Login.name());
        this.add(productsView, Views.Home.name());

        //setup controllers
        new ProductCreateController(this, productCreateView, productsRepository);
        new MenuBarController(this, menuBar);

        this.setJMenuBar(menuBar);

        changeView(Views.Login); //sets initial view

        this.pack();
        this.setSize(new Dimension(800, 800));
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public Views getActiveView() {
        return _activeView;
    }

    public void changeView(Views view) {
        _activeView = view;
        _cardLayout.show(this.getContentPane(), view.name());
        _viewHistory.push(view);
    }

    public void goBack() {
        _activeView = _viewHistory.pop();
        _cardLayout.show(this.getContentPane(), _activeView.name());
    }
}