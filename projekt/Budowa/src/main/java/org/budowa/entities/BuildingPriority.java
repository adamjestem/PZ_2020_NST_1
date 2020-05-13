package org.budowa.entities;

import javafx.scene.image.Image;
import org.budowa.App;

public enum BuildingPriority {
    LOW,
    MEDIUM,
    HIGH;

    @Override
    public String toString() {
        switch (this) {
            case LOW:
                return "Niski";
            case MEDIUM:
                return "Średni";
            case HIGH:
                return "Wysoki";
        }
        return "Nieznany";
    }

    public String getColor() {
        switch (this) {
            case LOW:
                return "#2ECC71";
            case MEDIUM:
                return "#F1C40F";
            case HIGH:
                return "#E74C3C";
        }
        return "#000000";
    }

    public Image getImage() {
        switch (this) {
            case LOW:
                return new Image(App.class.getResource("icons/low-priority.png").toString());
            case MEDIUM:
                return new Image(App.class.getResource("icons/medium-priority.png").toString());
            case HIGH:
                return new Image(App.class.getResource("icons/high-priority.png").toString());
        }
        return null;
    }
}
