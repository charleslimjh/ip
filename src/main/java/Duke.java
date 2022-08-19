import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    private ArrayList<Task> db;
    private Scanner sc;

    public Duke() {
        this.sc = new Scanner(System.in);
        this.db = new ArrayList<>(10);
    }

    /**
     * Welcome message that is printed upon starting the bot.
     */
    public void greet() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
    }

    /**
     * Prompts the user for input.
     * @param sc Scanner object to read user input
     * @return User input for processing
     */
    public String getInput(Scanner sc) {
        System.out.println("What can I do for you?");
        return sc.nextLine();
    }

    /**
     * Checks the user input and performs the necessary instruction.
     * @param s User input
     * @return 0 if "bye" is input, 1 for successfully running any other instruction
     */
    public int processInput(String s) {
        String[] userInput = s.split(" ", 2);

        if (s.equals("bye")) {
            System.out.println("Bye. Hope to see you again!");
            return 0;
        } else if (s.equals("list")) {
            for (int i = 0; i < db.size(); i++) {
                System.out.println(i + 1 + ". " + db.get(i).toString());
            }
            return 1;
        } else if (userInput[0].equals("mark")) {
            Task tmp = db.get(Integer.parseInt(userInput[1]) - 1);
            tmp.setDone();
            System.out.println("Nice! I've marked this task as done:");
            System.out.println(tmp);
            return 1;
        } else if (userInput[0].equals("unmark")) {
            Task tmp = db.get(Integer.parseInt(userInput[1]) - 1);
            tmp.setUndone();
            System.out.println("OK, I've marked this task as undone:");
            System.out.println(tmp);
            return 1;
        } else {
            db.add(new Task(s));
            System.out.println("added: " + s);
            return 1;
        }
    }

    // Initializes and starts a Duke instance.
    public static void main(String[] args) {
        Duke duke = new Duke();

        duke.greet();
        while (true) {
            String input = duke.getInput(duke.sc);
            if (duke.processInput(input) == 0) {
                break;
            }
            System.out.println();
        }
    }
}
