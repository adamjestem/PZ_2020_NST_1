import database.DbConnector;
import entities.Role;
import javafx.application.Application;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class Budowa extends Application {

    public static void main(String[] args) throws Exception {
        DbConnector dbConnector = new DbConnector();
        dbConnector.setSessionFactory();
        SessionFactory sessionFactory = dbConnector.getSessionFactory();
        Session session = sessionFactory.openSession();
        // \|/ do usunięcia w dalszych taskach - zostawiam narazie do testów żeby każdy mógł sobie sprawdzić połączenie
        List<Role> roles = session.createQuery("from Roles", Role.class).getResultList();
        System.out.println(roles.get(0).getRoleName());
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

    }
}
