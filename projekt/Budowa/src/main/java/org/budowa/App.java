package org.budowa;

import javafx.application.Application;
import javafx.stage.Stage;
import org.budowa.router.Router;
import org.budowa.services.SceneManager;


/**
 * JavaFX App
 */
public class App extends Application {
    private SceneManager sceneManager = SceneManager.inject();
    private Router router = Router.inject();

    @Override
    public void start(Stage stage) throws Exception {
        this.sceneManager.setStage(stage);
        this.router.goToBuildingDetail(1);
    }

    public static void main(String[] args) throws Exception {
        launch(args);
    }
}
