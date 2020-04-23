package org.budowa.entities;

public enum BuildingStatus {
    TODO,
    FOUNDATIONS,
    WALLS,
    CEILING,
    ROOF,
    DONE;


    @Override
    public String toString() {
        switch (this) {
            case DONE:
                return "Gotowy";
            case CEILING:
                return "Strop";
            case ROOF:
                return "Dach";
            case TODO:
                return "Do zrobienia";
            case WALLS:
                return "Mury";
            case FOUNDATIONS:
                return "Fundamenty";
        }
        return "Inny";
    }
}
