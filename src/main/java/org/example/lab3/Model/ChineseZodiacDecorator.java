package org.example.lab3.Model;

/**
 * @author Julius Jauga 5 gr. 1 pogr.
 * A class designed to decorate a person object with aditional information about the Person.
 * This class extends the PersonDecorator class to add functionality to message method. This decorator adds chinese Zodiac sign information.
 */
public class ChineseZodiacDecorator extends PersonDecorator {
    private final Person decoratedPerson;
    /**
     * Private constructor for ChineseZodiacDecorator
     * @param builder Builder
     */
    private ChineseZodiacDecorator(ChineseZodiacDecorator.Builder builder) {
        super(builder.personInterface);
        this.decoratedPerson = builder.person;
    }

    /**
     * Method to get the chinese Zodiac in lithuanian.
     * @return String Chinese Zodiac in lithuanian
     */
    public String getChineseZodiac() {
        String[] zodiacAnimals = {"Žiurkė", "Jautis", "Tigras", "Kiškis", "Drakonas", "Gyvatė", "Arklys", "Ožka", "Beždžionė", "Gaidys", "Šuo", "Kiaulė"
        };
        int zodiacIndex = (decoratedPerson.getBirth_date().getValue().getYear() - 1900) % 12;
        if (zodiacIndex < 0) {
            zodiacIndex += 12;
        }
        return zodiacAnimals[zodiacIndex];
    }
    /**
     * Adds additional content to the message.
     * @return the message from the decorated person concatenated with new information.
     */
    @Override
    public String message() {
        return super.message() + "Jūsų kinų zodiako ženklas yra " + getChineseZodiac() + ". ";
    }
    /**
     * @author Julius Jauga 5 gr. 1 pogr.
     * Builder class for ChineseZodiacDecorator.
     */
    public static class Builder {
        Person person;
        PersonInterface personInterface;
        /**
         * Adding PersonInterface to Decorator.
         * @param personInterface PersonInterface object.
         * @return Builder to ChineseZodiacDecorator class.
         */
        public ChineseZodiacDecorator.Builder withDecorator(PersonInterface personInterface) {
            this.personInterface = personInterface;
            return this;
        };
        /**
         * Adding Person to Decorator.
         * @param person Person object.
         * @return Builder to ChineseZodiacDecorator class.
         */
        public ChineseZodiacDecorator.Builder withPerson(Person person) {
            this.person = person;
            return this;
        }
        /**
         * Building the object.
         * @return new ChineseZodiacDecorator.
         */
        public ChineseZodiacDecorator build() {
            return new ChineseZodiacDecorator(this);
        }
    }
}
