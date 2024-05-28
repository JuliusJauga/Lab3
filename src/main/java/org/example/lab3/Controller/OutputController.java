package org.example.lab3.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.lab3.Model.*;

/**
 * @author Julius Jauga 5 gr. 1 pogr.
 * Class designed to take input and form output from input controller.
 */
public class OutputController {

    private Person person;
    @FXML
    public DatePicker birth_date;

    @FXML
    public TextField first_name;

    @FXML
    public TextField last_name;
    @FXML
    public TextArea message;
    @FXML
    public Label data_send_method;

    /**
     * Method to get data from input controller in one of three ways.
     * @param event
     */
    @FXML
    void getData(ActionEvent event) {
        message.setWrapText(true);
        switch (InputController.dataSendOption) {
            case 1:
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                Person userData = (Person) stage.getUserData();
                UserMethodCommand userDataCommand = new UserMethodCommand(userData);
                userDataCommand.execute(this);
                break;
            case 2:
                ControlCommand controlCommand = new ControlCommand(getPerson());
                controlCommand.execute(this);
                break;
            case 3:
                SingletonCommand singletonCommand = new SingletonCommand();
                singletonCommand.execute(this);
                break;
        }
    }

    /**
     * Method to get Person object. One of the ways of getting data from input controller.
     * @return Person object.
     */
    public Person getPerson() {
        return person;
    }

    /**
     * Method to set the Person object.
     * @param person Person object
     */
    public void setPerson(Person person) {
        this.person = person;
    }
}
