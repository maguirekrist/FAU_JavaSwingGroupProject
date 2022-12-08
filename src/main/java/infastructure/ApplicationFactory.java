package infastructure;

import com.google.gson.reflect.TypeToken;
import infastructure.repository.UserRepository;
import model.Product;
import model.User;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class ApplicationFactory {

    public static void build() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());

        //Initialize repositories
        JsonRepository<Product> productsRepository = new JsonRepository<>("products", new TypeToken<ArrayList<Product>>(){});
        UserRepository userRepository = new UserRepository("users", new TypeToken<>(){});

        javax.swing.SwingUtilities.invokeLater(() -> {
            new ViewManager(productsRepository, userRepository);
        });

//        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }));
    }

}
