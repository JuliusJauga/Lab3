package org.example.lab3.Model;

/**
 * @author Julius Jauga 5 gr. 1 pogr.
 * Simple implementation of PersonInterface using Person object.
 */
public class SimplePerson implements PersonInterface {
    private Person person;

    /**
     * Constructor for SimplePerson class using Builder.
     * @param builder Builder
     */
    private SimplePerson(Builder builder) {
        this.person = builder.person;
    }
    /**
     * Generates simple greeting message.
     * @return the message.
     */
    @Override
    public String message() {
        return "Sveiki " + person.getFirst_name() + " " + person.getLast_name() + ". ";
    }

    /**
     * @author Julius Jauga 5 gr. 1 pogr.
     * Builder class for SimplePerson class.
     */
    public static class Builder {
        Person person;

        /**
         * Add Person object.
         * @param person Person object.
         * @return Builder of SimplePerson
         */
        public SimplePerson.Builder withPerson(Person person) {
            this.person = person;
            return this;
        }

        /**
         * Builds the new object.
         * @return SimplePerson object.
         */
        public SimplePerson build() {
            return new SimplePerson(this);
        }
    }
}
