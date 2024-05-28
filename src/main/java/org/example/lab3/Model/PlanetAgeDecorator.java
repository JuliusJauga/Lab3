package org.example.lab3.Model;

import java.time.LocalDate;
import java.time.Period;
/**
 * @author Julius Jauga 5 gr. 1 pogr.
 * A class designed to decorate a person object with aditional information about the Person.
 * This class extends the PersonDecorator class to add functionality to message method. This decorator adds age on different planets' information.
 */
public class PlanetAgeDecorator extends PersonDecorator {
    private static final double EARTH_YEAR = 1.0;
    private static final double MERCURY_YEAR = 0.2408467;
    private static final double VENUS_YEAR = 0.61519726;
    private static final double MARS_YEAR = 1.8808158;
    private static final double JUPITER_YEAR = 11.862615;
    private static final double SATURN_YEAR = 29.447498;
    private static final double URANUS_YEAR = 84.016846;
    private static final double NEPTUNE_YEAR = 164.79132;
    private final Person decoratedPerson;
    /**
     * Private constructor for PlanetAgeDecorator
     * @param builder Builder
     */
    private PlanetAgeDecorator(PlanetAgeDecorator.Builder builder) {
        super(builder.personInterface);
        this.decoratedPerson = builder.person;
    }

    /**
     * Method to calculate age on different planets.
     * @param earthAge Age on earth.
     * @param orbitalPeriod Orbital speeds of different planets.
     * @return double New age.
     */
    public static double calculateAgeOnPlanet(double earthAge, double orbitalPeriod) {
        return earthAge / orbitalPeriod;
    }

    /**
     * Gets age of Person
     * @return Period between two dates.
     */
    public Period getAge() {
        return Period.between(decoratedPerson.getBirth_date().getValue(), LocalDate.now());
    }
    /**
     * Adds additional content to the message.
     * @return the message from the decorated person concatenated with new information.
     */
    @Override
    public String message() {
        return super.message() + " Jūsų amžius Marso metais: " + String.format("%.2f", calculateAgeOnPlanet(getAge().getYears(), MARS_YEAR));
    }
    /**
     * @author Julius Jauga 5 gr. 1 pogr.
     * Builder class for PlanetAgeDecorator.
     */
    public static class Builder {
        Person person;
        PersonInterface personInterface;
        /**
         * Adding PersonInterface to Decorator.
         * @param personInterface PersonInterface object.
         * @return Builder to PlanetAgeDecorator class.
         */
        public PlanetAgeDecorator.Builder withDecorator(PersonInterface personInterface) {
            this.personInterface = personInterface;
            return this;
        }
        /**
         * Adding Person to Decorator.
         * @param person Person object.
         * @return Builder to PlanetAgeDecorator class.
         */
        public PlanetAgeDecorator.Builder withPerson(Person person) {
            this.person = person;
            return this;
        }
        /**
         * Building the object.
         * @return new PlanetAgeDecorator.
         */
        public PlanetAgeDecorator build() {
            return new PlanetAgeDecorator(this);
        }
    }
}
