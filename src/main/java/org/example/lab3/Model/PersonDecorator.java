package org.example.lab3.Model;

/**
 * @author Julius Jauga 5 gr. 1 pogr.
 * Abstract class for decorating Person object implementing PersonInterface.
 */
public abstract class PersonDecorator implements PersonInterface {
    protected PersonInterface decoratedPerson;
    /**
     * Constructs a PersonDecorator object with the specified decorated person.
     * @param decoratedPerson the person to be decorated
     */
    public PersonDecorator (PersonInterface decoratedPerson) {
        this.decoratedPerson = decoratedPerson;
    }
    /**
     * Retrieves the message from the decorated person.
     * @return the message from the decorated person
     */
    @Override
    public String message() {
        return decoratedPerson.message();
    }
}
