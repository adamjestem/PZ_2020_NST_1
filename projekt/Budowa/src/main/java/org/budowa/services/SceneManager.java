package org.budowa.services;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.budowa.App;
import org.budowa.flow.Flow;
import org.budowa.flow.FlowsRegistry;
import org.budowa.router.Route;
import org.budowa.router.Routes;

import java.io.IOException;

/**
 * Scene manager MUST be a singleton!
 */
public class SceneManager {
    private static SceneManager sceneManager;

    public static SceneManager inject() {
        if (SceneManager.sceneManager == null) {
            SceneManager.sceneManager = new SceneManager();
        }
        return SceneManager.sceneManager;
    }

    /**
     * Stage
     */
    private Stage stage;

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    /**
     * Scene
     */
    private Scene scene;

    public Scene getScene() {
        return scene;
    }

    /**
     * Public methods
     */
    public void closeWindow() {
        stage.close();
    }

    public void createScene(String fxmlName, String title) throws IOException {
        this.scene = new Scene(loadFXML(fxmlName));
        this.stage.setScene(scene);
        this.stage.setTitle(title);
        this.stage.show();
    }

    public void createStartingScene() {
        var defaultScene = FlowsRegistry.getFXML(Flow.USERS_LIST);
        var defaultTitle = Routes.getRouteData(Route.USERS_LIST).title;
        try {
            this.createScene(defaultScene, defaultTitle);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
}
