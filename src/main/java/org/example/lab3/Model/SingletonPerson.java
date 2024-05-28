package org.example.lab3.Model;

/**
 * @author Julius Jauga 5 gr. 1 pogr.
 * Class for Singleton object of person
 */
public class SingletonPerson {
    private static SingletonPerson instance;
    private Person person = new Person.Builder().build();

    /**
     * Getting Person from Singleton.
     * @return Person object.
     */
    public Person getPerson() {
        return person;
    }

    /**
     * Setting Person for Singleton.
     * @param person Person object.
     */
    public void setPerson(Person person) {
        this.person = person;
    }

    /**
     * Method for getting instance from singleton object, if no instance, creates new.
     * @return SingletonPerson object.
     */
    public static SingletonPerson getInstance() {
        if (instance == null) {
            instance = new SingletonPerson();
        }
        return instance;
    }
}
