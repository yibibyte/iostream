package chat.chatG;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private PrintWriter out;
    private JTextArea chatArea;

    public static void main(String[] args) {
        new Client().startClient();
    }

    public Client() {
        JFrame frame = new JFrame("Чат Клиент");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        JTextField messageField = new JTextField();
        JButton sendButton = new JButton("Отправить");
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage("Клиент: " + messageField.getText());
                messageField.setText("");
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(messageField, BorderLayout.CENTER);
        panel.add(sendButton, BorderLayout.EAST);
        frame.add(panel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    public void startClient() {
        try {
            Socket socket = new Socket("localhost", 8099);
            out = new PrintWriter(socket.getOutputStream(), true);

            Scanner in = new Scanner(socket.getInputStream());

            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (in.hasNextLine()) {
                        String message = in.nextLine();
                        updateChatArea(message);
                    }
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendMessage(String message) {
        out.println(message);
    }
    private void sendMessage(JTextField messageField) {
        String message = messageField.getText();
        out.println(message);
        messageField.setText("");
    }
    private void updateChatArea(String message) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                chatArea.append(message + "\n");
            }
        });
    }
}
