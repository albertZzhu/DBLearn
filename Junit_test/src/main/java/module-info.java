module com.dblearn.junit_test {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.dblearn.junit_test to javafx.fxml;
    exports com.dblearn.junit_test;
}