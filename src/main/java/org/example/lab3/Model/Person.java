package org.example.lab3.Model;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;

import java.util.Date;

/**
 * @author Julius Jauga 5 gr. 1 pogr.
 * Person class, can hold the data that is designed in FXML file.
 * Works with builder method.
 */
public class Person {
    private String first_name;
    private String last_name;
    private int dataSendOption;
    @FXML
    private DatePicker birth_date;

    /**
     * Private constructor called from builder class.
     * @param builder builder parameter.
     */
    private Person(Builder builder) {
        this.first_name = builder.name;
        this.last_name = builder.lastName;
        this.birth_date = builder.birthDate;
        this.dataSendOption = builder.dataSendOption;
    }

    /**
     * Message that will be displayed in output.
     * @return String message.
     */
    public String message() {
        return "Sveiki " + getFirst_name() + " " + getLast_name() + ". ";
    }

    /**
     * Getter
     * @return String first name of person.
     */
    public String getFirst_name() {
        return first_name;
    }
    /**
     * Setter for first name.
     * @param first_name
     */
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    /**
     * Getter
     * @return String for last name.
     */
    public String getLast_name() {
        return last_name;
    }

    /**
     * Setter for last name
     * @param last_name
     */
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    /**
     * Getter
     * @return Datepicker Birth date.
     */
    public DatePicker getBirth_date() {
        return birth_date;
    }

    /**
     * Setter
     * @param birth_date
     */
    public void setBirth_date(DatePicker birth_date) {
        this.birth_date = birth_date;
    }

    /**
     * Getter
     * @return int Data send option.
     */
    public int getDataSendOption() {
        return dataSendOption;
    }

    /**
     * Setter
     * @param dataSendOption
     */
    public void setDataSendOption(int dataSendOption) {
        this.dataSendOption = dataSendOption;
    }

    /**
     * @author Julius Jauga 5 gr. 1 pogr.
     * Builder class for Person class.
     */
    public static class Builder {
        private String name;
        private String lastName;
        private DatePicker birthDate;
        private int dataSendOption;

        /**
         * Set first name.
         * @param name
         * @return Builder
         */
        public Builder withFirstName(String name) {
            this.name = name;
            return this;
        }

        /**
         * Set last name.
         * @param lastName
         * @return Builder
         */
        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        /**
         * Set birthdate.
         * @param birthDate
         * @return Builder
         */
        public Builder withBirthDate(DatePicker birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        /**
         * Set dataSendOption
         * @param dataSendOption
         * @return Builder
         */
        public Builder withDataSendOption(int dataSendOption) {
            this.dataSendOption = dataSendOption;
            return this;
        }

        /**
         * Build method
         * @return Person object, called constructor from Person class.
         */
        public Person build() {
            return new Person(this);
        }
    }
}
