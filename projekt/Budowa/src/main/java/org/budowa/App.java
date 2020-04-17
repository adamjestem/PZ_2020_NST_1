package org.budowa;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("LoginScene"));
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) throws Exception {
//        DbConnector dbConnector = new DbConnector();
//        dbConnector.setSessionFactory();
//        SessionFactory sessionFactory = dbConnector.getSessionFactory();
//        Session session = sessionFactory.openSession();
//        // \|/ do usunięcia w dalszych taskach - zostawiam narazie do testów żeby każdy mógł sobie sprawdzić połączenie
//        List<Role> roles = session.createQuery("from Roles", Role.class).getResultList();
//        System.out.println(roles.get(0).getRoleName());
        launch(args);
    }
}