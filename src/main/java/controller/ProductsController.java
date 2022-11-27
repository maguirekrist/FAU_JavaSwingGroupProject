package controller;

import infastructure.IRepository;
import infastructure.JsonRepository;
import model.Product;
import view.ProductsView;

public class ProductsController {

    private ProductsView _view;

    private IRepository<Product> _productsRepository;
    public ProductsController(ProductsView view, IRepository<Product> productsRepository) {
        this._view = view;
        this._productsRepository = productsRepository;

        _productsRepository.addObserver(view);
    }
}
