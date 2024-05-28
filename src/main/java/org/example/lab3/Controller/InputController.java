package org.example.lab3.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.lab3.MainApplication;
import org.example.lab3.Model.SingletonPerson;
import org.example.lab3.Model.Person;

import java.io.IOException;

/**
 * @author Julius Jauga 5 gr. 1 pogr.
 * Input controller class, designed to take input and then send it in one of three ways.
 */
public class InputController {

    @FXML
    private DatePicker birth_date;

    @FXML
    private TextField first_name;

    @FXML
    private TextField last_name;
    public static int dataSendOption;

    /**
     * Method to send data using Singleton object.
     * @param event
     * @throws IOException
     */
    @FXML
    void sendUsingSingleton(ActionEvent event) throws IOException {
        dataSendOption = 3;
        SingletonPerson singletonPerson = SingletonPerson.getInstance();
        singletonPerson.setPerson(new Person.Builder()
                .withFirstName(first_name.getText())
                .withLastName(last_name.getText())
                .withBirthDate(birth_date)
                .build());
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("output2-view.fxml"));
        OutputController outputController = new OutputController();

        fxmlLoader.setController(outputController);
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        stage.setTitle("output");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Method to send data using "UserData" methods.
     * @param event
     * @throws IOException
     */
    @FXML
    void sendUsingUserData(ActionEvent event) throws IOException {
        dataSendOption = 1;
        Person person = new Person.Builder()
                .withFirstName(first_name.getText())
                .withLastName(last_name.getText())
                .withBirthDate(birth_date)
                .build();
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setUserData(person);
        stage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("output1-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);

        stage.setTitle("output");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Method to send data using Input and Output controller classes.
     * @param event
     * @throws IOException
     */
    @FXML
    void sendUsingControllerClasses(ActionEvent event) throws IOException {
        dataSendOption = 2;
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("output3-view.fxml"));
        OutputController outputController = new OutputController();
        Person sendPerson = new Person.Builder()
                .withFirstName(first_name.getText())
                .withLastName(last_name.getText())
                .withBirthDate(birth_date)
                .build();
        outputController.setPerson(sendPerson);
        fxmlLoader.setController(outputController);
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        stage.setTitle("output");
        stage.setScene(scene);
        stage.show();
    }
}
