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

    public BuildingStatus getNext() {
        switch (this) {
            case TODO:
                return FOUNDATIONS;
            case FOUNDATIONS:
                return WALLS;
            case WALLS:
                return CEILING;
            case CEILING:
                return ROOF;
            case ROOF:
            case DONE:
                return DONE;
        }
        return DONE;
    }

    public BuildingStatus getPrevious() {
        switch (this) {
            case TODO:
            case FOUNDATIONS:
                return TODO;
            case WALLS:
                return FOUNDATIONS;
            case CEILING:
                return WALLS;
            case ROOF:
                return CEILING;
            case DONE:
                return ROOF;
        }
        return TODO;
    }
}
