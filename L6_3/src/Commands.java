public enum Commands {
    mkdir, dir, cd, del, copy, word, quit, help;

    public static Commands getCommand(String command) throws IllegalArgumentException {
        switch (command.toLowerCase()) {
            case "mkdir", "md" -> {
                return Commands.mkdir;
            }
            case "dir" -> {
                return Commands.dir;
            }
            case "cd" -> {
                return Commands.cd;
            }
            case "del" -> {
                return Commands.del;
            }
            case "copy" -> {
                return Commands.copy;
            }
            case "word" -> {
                return Commands.word;
            }
            case "quit" -> {
                return Commands.quit;
            }
            case "help" -> {
                return Commands.help;
            }
            default -> {
                throw new IllegalArgumentException();
            }
        }
    }
}