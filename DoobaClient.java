import java.util.*;
import java.net.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.lang.Runtime;
public class DoobaClient{

    BufferedReader in;
    PrintWriter out;
    JFrame frame = new JFrame("Shooba Dooba Talks");
    JTextField textField = new JTextField(40);
    JTextArea messageArea = new JTextArea(8, 40);

 
    public DoobaClient() {

        textField.setEditable(false);
        messageArea.setEditable(false);
        frame.getContentPane().add(textField, "North");
        frame.getContentPane().add(new JScrollPane(messageArea), "Center");
        frame.pack();

        textField.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                out.println(textField.getText());
                textField.setText("");
            }
        });
    }


    private String getServerAddress() {
        return JOptionPane.showInputDialog(
            frame,
            "Enter IP Address of the Server:",
            "Welcome to the Chatter",
            JOptionPane.QUESTION_MESSAGE);
    }


    private String getName() {
        return JOptionPane.showInputDialog(
            frame,
            "Choose a screen name:",
            "Screen name selection",
            JOptionPane.PLAIN_MESSAGE);
    }


    private void run() throws IOException {

    Socket socket = new Socket("localhost",) ;
        in = new BufferedReader(new InputStreamReader(
            socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);

        while (true) {
            String line = in.readLine();
            if (line.startsWith("SUBMITNAME")) {
                out.println(getName());
            } else if (line.startsWith("NAMEACCEPTED")) {
                textField.setEditable(true);
            } else if (line.startsWith("MESSAGE")) {
                messageArea.append(line.substring(8) + "\n");
            }
        }
	}
    public static void main(String[] args) throws Exception {
        DoobaClient client = new DoobaClient();
        client.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        client.frame.setVisible(true);
        client.run();
    }

}
