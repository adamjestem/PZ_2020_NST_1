package org.budowa;

import javafx.application.Application;
import javafx.stage.Stage;
import org.budowa.database.DbConnector;
import org.budowa.entities.Role;
import org.budowa.services.SceneManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.IOException;
import java.util.List;

/**
 * JavaFX App
 */
public class App extends Application {
    private SceneManager sceneManager = SceneManager.inject();

    @Override
    public void start(Stage stage) throws Exception {
        this.sceneManager.setStage(stage);
        this.sceneManager.createStartingScene();
    }

    public static void main(String[] args) throws Exception {
        // dodajcie sobie role i odkomentujcie to
//        DbConnector dbConnector = new DbConnector();
//        dbConnector.setSessionFactory();
//        SessionFactory sessionFactory = dbConnector.getSessionFactory();
//        Session session = sessionFactory.openSession();
//        List<Role> roles = session.createQuery("from Role", Role.class).list();
//        System.out.println(roles.get(0).getRoleName());
        launch(args);
    }
}
