package org.budowa;

import javafx.application.Application;
import javafx.stage.Stage;
import org.budowa.services.SceneManager;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {
    private SceneManager sceneManager = SceneManager.create();

    @Override
    public void start(Stage stage) throws IOException {
        this.sceneManager.setStage(stage);
        this.sceneManager.createDefaultScene();
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
