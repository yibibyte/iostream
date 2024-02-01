package chat.chatG;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Server {
    private final List<PrintWriter> clients = new ArrayList<>();
    private final JTextArea chatArea;

    public static void main(String[] args) {
        new Server().startServer();
    }

    public Server() {
        JFrame frame = new JFrame("Чат Сервера");
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
                broadcastMessage("Сервер: " + messageField.getText());
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

    public void startServer() {
        try (ServerSocket serverSocket = new ServerSocket(8099)) {
            System.out.println("Сервер запущен. Ожидание клиентов...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Подключен новый клиент: " + clientSocket);

                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                clients.add(out);

                new Thread(new ClientHandler(clientSocket, out)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void broadcastMessage(String message) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                chatArea.append(message + "\n");
            }
        });

        for (PrintWriter client : clients) {
            client.println(message);
        }
    }

    private class ClientHandler implements Runnable {
        private final Socket socket;
        private final PrintWriter out;

        public ClientHandler(Socket socket, PrintWriter out) {
            this.socket = socket;
            this.out = out;
        }

        @Override
        public void run() {
            try {
                Scanner in = new Scanner(socket.getInputStream());

                while (in.hasNextLine()) {
                    String message = in.nextLine();
                    broadcastMessage(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                clients.remove(out);
            }
        }
    }
}

