import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public static void runUserCommand(String userInput) throws IOException, InterruptedException {
    String cmd = "ls " + userInput;

    Process proc = Runtime.getRuntime().exec(new String[] { "sh", "-c", cmd });

    try (BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()))) {
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }

    int exitCode = proc.waitFor();
    System.out.println("Exit code: " + exitCode);
}
