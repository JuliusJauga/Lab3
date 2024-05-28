package org.example.lab3.Model;

import org.example.lab3.Controller.OutputController;

/**
 * @author Julius Jauga 5 gr. 1 pogr.
 * Class for representing a command for getting the data using "UserData" methods.
 * Implements the Command interface for execute method.
 */
public class UserMethodCommand implements Command {
    private Person person;

    /**
     * Constructor for UserMethodCommand
     * @param person Person object.
     */
    public UserMethodCommand(Person person) {
        this.person = person;
    }
    /**
     * Executes the command using "User data"
     * @param controller the output controller on which the command operates
     */
    @Override
    public void execute(OutputController controller) {
        controller.data_send_method.setText("UserData");
        controller.first_name.setText(person.getFirst_name());
        controller.last_name.setText(person.getLast_name());
        controller.birth_date.setValue(person.getBirth_date().getValue());

        PersonInterface personDec = new SimplePerson.Builder().withPerson(person).build();
        personDec = new AgeDecorator.Builder().withDecorator(personDec).withPerson(person).build();
        personDec = new ZodiacDecorator.Builder().withDecorator(personDec).withPerson(person).build();
        personDec = new ChineseZodiacDecorator.Builder().withDecorator(personDec).withPerson(person).build();
        personDec = new BirthdayDecorator.Builder().withDecorator(personDec).withPerson(person).build();
        personDec = new PlanetAgeDecorator.Builder().withDecorator(personDec).withPerson(person).build();

        controller.message.setText(personDec.message());
    }
}
