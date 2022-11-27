import infastructure.ApplicationFactory;
import javax.swing.*;
import java.io.IOException;

public class Application {

    public static void main(String[] args)  {
        try {
            ApplicationFactory.build();
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException |
                 IllegalAccessException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
