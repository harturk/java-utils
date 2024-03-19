import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bash {

    private static void Bash(String command) throws Exception {
        try {
            // Bash command to execute example
            // String command = "bc -l <<< 5*5";

            // Create ProcessBuilder
            ProcessBuilder processBuilder = new ProcessBuilder();
            processBuilder.command("bash", "-c", command);

            // Start the process
            Process process = processBuilder.start();

            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            process.waitFor();

            in.close();
            System.exit(0);

            // Wait for the command to finish
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
