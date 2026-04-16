/*
 * Decompiled with CFR 0.152.
 */
package linker.resourcer.encoder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class CShell {
    private BufferedWriter shellInput;
    private BufferedReader shellOutput;
    private Process shellProcess;

    public CShell() throws Exception {
        ProcessBuilder processBuilder = new ProcessBuilder("sh");
        processBuilder.redirectErrorStream(true);
        this.shellProcess = processBuilder.start();
        this.shellInput = new BufferedWriter(new OutputStreamWriter(this.shellProcess.getOutputStream()));
        this.shellOutput = new BufferedReader(new InputStreamReader(this.shellProcess.getInputStream()));
    }

    public void close() {
        try {
            this.shellInput.write("exit\n");
            this.shellInput.flush();
            this.shellProcess.destroy();
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public String sendCommand(String charSequence) {
        try {
            this.shellInput.write((String)charSequence);
            this.shellInput.newLine();
            this.shellInput.flush();
            charSequence = new StringBuilder();
            charSequence = ((StringBuilder)charSequence).append("___CMD_END___").append(System.currentTimeMillis()).toString();
            Appendable appendable = this.shellInput;
            CharSequence charSequence2 = new StringBuilder();
            ((Writer)appendable).write(((StringBuilder)charSequence2).append("echo ").append((String)charSequence).toString());
            this.shellInput.newLine();
            this.shellInput.flush();
            appendable = new StringBuilder();
            while ((charSequence2 = this.shellOutput.readLine()) != null) {
                if (((String)charSequence2).contains(charSequence)) return ((StringBuilder)appendable).toString().trim();
                ((StringBuilder)appendable).append((String)charSequence2).append("\n");
            }
            return ((StringBuilder)appendable).toString().trim();
        }
        catch (Exception exception) {
            return "ERROR: " + exception.getMessage();
        }
    }
}

