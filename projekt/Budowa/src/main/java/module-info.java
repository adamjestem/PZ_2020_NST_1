module org.budowa {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.persistence;
    requires java.sql;
    requires org.hibernate.orm.core;

    opens org.budowa to javafx.fxml;
    opens org.budowa.flow.login to javafx.fxml;
    exports org.budowa;
}