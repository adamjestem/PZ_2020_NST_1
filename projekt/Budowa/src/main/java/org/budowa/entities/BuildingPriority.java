package org.budowa.entities;

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
}
