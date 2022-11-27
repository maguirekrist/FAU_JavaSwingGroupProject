package controller;


import infastructure.IRepository;
import infastructure.ViewManager;
import model.Product;
import view.ProductCreateView;
import view.utility.FileUtils;
import view.utility.Views;

import java.io.File;
import java.text.ParseException;

public class ProductCreateController {


    private IRepository<Product> _productRepository;

    private ViewManager _viewManager;

    //Repository pattern says we can make our dependencies the interface so we can always change which repository engine we use for data persistence later
    public ProductCreateController(ViewManager viewManager, ProductCreateView view, IRepository<Product> productRepository) {
        this._productRepository = productRepository;
        this._viewManager = viewManager;

        view.submitProduct(e -> {
            Product newProduct = null;

            try {
               newProduct = new Product(view.getName(), view.getPrice(), view.getCost(), view.getQuantity(), view.getDescription());
            } catch (ParseException ex) {
                view.setFormError("Invalid form submission: " + ex.getMessage());
            }

            if(newProduct != null && view.getFile() != null && view.getFile().isPresent())
                newProduct.setImageUrl(handleFileUpload(view.getName(), view.getFile().get()));

            _productRepository.insert(newProduct);
            _productRepository.save();
            _viewManager.changeView(Views.Home);
        });
    }

    private String handleFileUpload(String productName, File file) {
        String newFileLocation = "/pictures/%s.%s".formatted(productName, FileUtils.getExtension(file));
        file.renameTo(new File(newFileLocation));
        return newFileLocation;
    }
}
