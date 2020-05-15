module org.budowa {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.persistence;
    requires java.sql;
    requires org.hibernate.orm.core;
    requires java.naming;

    requires net.bytebuddy;
    requires java.xml.bind;
    requires com.sun.xml.bind;
    requires com.fasterxml.classmate;
    requires itextpdf;

    requires commons.codec;

    opens org.budowa to javafx.fxml;
    opens org.budowa.flow.login to javafx.fxml;
    opens org.budowa.flow.manager to javafx.fxml;
    opens org.budowa.flow.owner to javafx.fxml;
    opens org.budowa.flow.kanban to javafx.fxml;
    opens org.budowa.flow.shared to javafx.fxml;
    opens org.budowa.flow.buildings to javafx.fxml;
    opens org.budowa.flow.users to javafx.fxml;
    opens org.budowa.services to javafx.fxml;
    opens org.budowa.flow.worker to javafx.fxml;

    exports org.budowa;
    exports org.budowa.repositories;
    exports org.budowa.entities;
    exports org.budowa.services;
}
