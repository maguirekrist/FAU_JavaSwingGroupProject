package infastructure;

import com.google.gson.reflect.TypeToken;
import controller.*;
import infastructure.repository.IUserRepository;
import model.Product;
import model.User;
import model.UserType;
import view.LoginView;
import view.ProductCreateView;
import view.ProductsView;
import view.RegisterView;
import view.components.MenuBar;
import view.utility.ProductCardFactory;
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
    private IUserRepository _userRepository;

    //ViewManager takes Repositories
    public ViewManager(
            IRepository<Product> productsRepository,
            IUserRepository userRepository
    ) {
        super("OOP Group Project MVC");
        _productsRepository = productsRepository;
        _userRepository = userRepository;

        _cardLayout = new CardLayout();
        this.setLayout(_cardLayout);

        //setup views
        var productCreateView = new ProductCreateView();
        var loginView = new LoginView();
        var productsView = new ProductsView(_productsRepository, new ProductCardFactory(this));
        var registerView = new RegisterView();
        var menuBar = new MenuBar();

        //add views to cardLayout
        this.add(productCreateView, Views.AddProduct.name());
        this.add(loginView, Views.Login.name());
        this.add(productsView, Views.Home.name());
        this.add(registerView, Views.Register.name());

        //setup controllers
        new ProductCreateController(this, productCreateView, productsRepository);
        new MenuBarController(this, menuBar);
        new ProductsController(productsView, productsRepository);
        new RegistrationController(this, registerView, userRepository);
        new LoginController(this, loginView, userRepository);

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
