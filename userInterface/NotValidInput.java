package userInterface;

public class NotValidInput extends Throwable {
    public NotValidInput(String please_give_input_in_range) {
        super(please_give_input_in_range);
    }
}
