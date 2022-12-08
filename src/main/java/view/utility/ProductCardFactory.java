package view.utility;

import controller.ProductController;
import infastructure.ViewManager;
import model.Product;
import view.ProductCardView;

public class ProductCardFactory {

    private ViewManager _viewManager;

    public ProductCardFactory(ViewManager viewManager) {
        this._viewManager = viewManager;
    }

    public ProductCardView createProductCardView(Product product) {
        var productView = new ProductCardView(product);
        new ProductController(_viewManager, productView);

        return productView;
    }

}
