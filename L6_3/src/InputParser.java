import java.util.*;

public class InputParser {
    public Commands command;
    public List<String> arguments = null;

    public String input;

    private void setValues(Commands command, List<String> arguments) {
        this.command = command;
        this.arguments = arguments;
    }

    private void validateSyntax(Commands parsed, List<String> arguments) throws IllegalArgumentException {
        if (parsed == null && arguments == null)
            throw new IllegalArgumentException();

        if ((parsed == Commands.quit
                || parsed == Commands.dir
                || parsed == Commands.word
                || parsed == Commands.help)
                && (arguments.size() != 0))
            throw new IllegalArgumentException();
        else if ((parsed == Commands.mkdir
                || parsed == Commands.cd
                || parsed == Commands.del)
                && arguments.size() != 1)
            throw new IllegalArgumentException();
        else if (parsed == Commands.copy && arguments.size() != 2)
            throw new IllegalArgumentException();
    }

    public InputParser(String input) throws IllegalArgumentException {
        this.input = input;

        List<String> split = new ArrayList<>(Arrays.stream(input.split(" ")).toList());

        Commands command = Commands.getCommand(split.get(0));
        split.remove(0);

        this.validateSyntax(command, split);
        this.setValues(command, split);
    }
}
