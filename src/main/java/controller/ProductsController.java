package controller;

import infastructure.IRepository;
import infastructure.JsonRepository;
import infastructure.MemoryRepository;
import model.Product;
import view.ProductsView;

import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ProductsController {

    private ProductsView _view;

    private IRepository<Product> _productsRepository;
    public ProductsController(ProductsView view, IRepository<Product> productsRepository) {
        this._view = view;
        this._productsRepository = productsRepository;

        _productsRepository.addObserver(view);

        _view.handleSearch(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {
                var search = _view.getSearch();
                var filteredList = _productsRepository.list(p -> p.getLabel().toLowerCase().contains(search.toLowerCase()));
                MemoryRepository<Product> temp = new MemoryRepository<>(filteredList);
                temp.addObserver(view);
                temp.notifyObservers();
                temp.removeObserver(view);
            }
        });
    }

    private void searchProducts(KeyEvent e) {
        System.out.println(_view.getSearch());
    }
}
