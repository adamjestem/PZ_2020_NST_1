package org.budowa.entities;

public enum UserRole {
    WORKER,
    MANAGER,
    OWNER;


    @Override
    public String toString() {
        switch (this) {
            case MANAGER:
                return "Menadżer";
            case OWNER:
                return "Właściciel";
            case WORKER:
                return "Pracownik";
            default:
                return "Nieznana";
        }
    }
}
