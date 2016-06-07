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
    JFrame emojis = new JFrame("Text Emojis");    
    JTextField textField = new JTextField(28);
    JTextArea messageArea = new JTextArea(8, 40);
    JButton anger = new JButton("Angry");
    JButton happy = new JButton("Happy");
    JButton sad = new JButton("Sad");
    JButton shoobadooba = new JButton("Shooba Dooba");
    JButton dongers = new JButton("Raise ur Dongers");
    JButton shrug = new JButton("Shrug");
    JButton confused = new JButton("Confused");
    JButton tableflip = new JButton("Flip Table");
    JButton pingpong = new JButton("Ping Pong");
 
    public DoobaClient() {
        textField.setEditable(false);
        messageArea.setEditable(false);
	emojis.setSize(175, 300);
        emojis.getContentPane().setLayout(new BoxLayout(emojis.getContentPane(), BoxLayout.Y_AXIS));
	emojis.getContentPane().add(shoobadooba);
	emojis.getContentPane().add(anger);
	emojis.getContentPane().add(happy);
	emojis.getContentPane().add(sad);
	emojis.getContentPane().add(confused);
	emojis.getContentPane().add(dongers);
	emojis.getContentPane().add(shrug);
	emojis.getContentPane().add(tableflip);
	emojis.getContentPane().add(pingpong);
        frame.getContentPane().add(textField, "North");
        frame.getContentPane().add(new JScrollPane(messageArea), "Center");
        frame.pack();

        shoobadooba.addActionListener(new ActionListener(){
		
		public void actionPerformed(ActionEvent e){
		    out.println("( ͡° ͜ʖ ͡°)");
		}
	    });

	anger.addActionListener(new ActionListener(){
		
		public void actionPerformed(ActionEvent e){
		    out.println("ヽ(ｏ`皿′ｏ)ﾉ");
		}
	    });
	happy.addActionListener(new ActionListener(){
		
		public void actionPerformed(ActionEvent e){
		    out.println("(✿◠‿◠)");
		}
	    });
	sad.addActionListener(new ActionListener(){
		
		public void actionPerformed(ActionEvent e){
		    out.println("༼ ༎ຶ ෴ ༎ຶ༽");
		}
	    });

	confused.addActionListener(new ActionListener(){
		
		public void actionPerformed(ActionEvent e){
		    out.println("「(°ヘ°)");
		}
	    });
		
	dongers.addActionListener(new ActionListener(){
		
		public void actionPerformed(ActionEvent e){
		    out.println("ヽ༼ຈل͜ຈ༽ﾉ raise your dongers ヽ༼ຈل͜ຈ༽ﾉ");
		}
	    });

	shrug.addActionListener(new ActionListener(){
		
		public void actionPerformed(ActionEvent e){
		    out.println("¯\\_(ツ)_/¯");
		}
	    });

	tableflip.addActionListener(new ActionListener(){
		
		public void actionPerformed(ActionEvent e){
		    out.println("(╯°□°）╯︵ ┻━┻");
		}
	    });

	pingpong.addActionListener(new ActionListener(){
		
		public void actionPerformed(ActionEvent e){
		    out.println("( •_•)O*¯`·.¸.·´¯`°Q(•_• )");
		}
	    });


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

    private String getPort() {
        return JOptionPane.showInputDialog(
					   frame,
					   "Enter port of the server",
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

	String s = (String)getServerAddress();
	InetAddress server = InetAddress.getByName(s);
	int p = Integer.parseInt(getPort()); 
	SocketAddress addr = new InetSocketAddress(server, p);
	Socket socket = new Socket() ;
	socket.connect(addr);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
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
        client.emojis.setVisible(true);
        client.run();
    }

}
