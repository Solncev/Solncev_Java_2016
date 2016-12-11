package com.solncev;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Марат on 11.12.2016.
 */
public class Client extends JFrame {
    private static final String HOST = "localhost";
    private static final int PORT = 3456;
    private static ClientThread clientThread;
    private JTextArea chatArea;
    private JButton sendButton;
    private JTextArea textArea;
    private JScrollPane jChatScrollPane;
    private JScrollPane jTextScrollPane;

    public Client() {
        initComponents();
    }

    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException e) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, e);
        } catch (InstantiationException e) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, e);
        } catch (IllegalAccessException e) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, e);
        } catch (javax.swing.UnsupportedLookAndFeelException e) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, e);
        }
        EventQueue.invokeLater(() -> {
            try {
                Socket socket = new Socket(HOST, PORT);
                Client c = new Client();
                clientThread = new ClientThread(socket, c);
                clientThread.start();
                c.setVisible(true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void initComponents() {
        createButtons();
        createTextAreas();
        createScrollPanes();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Клиент");
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        setGroups(layout);
        pack();
    }

    public JTextArea getChatArea() {
        return chatArea;
    }

    private void createButtons() {
        sendButton = new JButton();
        sendButton.setText("Отправить");
        sendButton.addActionListener(this::SendButtonActionPerformed);
    }

    private void createScrollPanes() {
        jChatScrollPane = new JScrollPane();
        jTextScrollPane = new JScrollPane();
        jChatScrollPane.setViewportView(chatArea);
        jTextScrollPane.setViewportView(textArea);
    }

    private void createTextAreas() {
        chatArea = new JTextArea();
        textArea = new JTextArea();
        chatArea.setColumns(20);
        chatArea.setRows(5);
        chatArea.setEditable(false);
        textArea.setColumns(20);
        textArea.setRows(5);
    }

    public void setGroups(GroupLayout layout) {
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jChatScrollPane, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jTextScrollPane, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(sendButton, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                                )))
                                .addContainerGap(80, Short.MAX_VALUE))
        );

        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(40, Short.MAX_VALUE)
                                .addComponent(jChatScrollPane, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(sendButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        )
                                        .addComponent(jTextScrollPane))
                                .addGap(60, 60, 60))
        );
    }

    private void SendButtonActionPerformed(ActionEvent actionEvent) {
        chatArea.setText(
                chatArea.getText() + "\nВы: " + textArea.getText()
        );
        clientThread.getPrintWriter().println(textArea.getText());
        textArea.setText("");
    }

    private static class ClientThread extends Thread {
        private Socket socket;
        private Client client;
        private BufferedReader bufferedReader;
        private PrintWriter printWriter;

        public ClientThread(Socket socket, Client client) throws IOException {
            this.socket = socket;
            this.client = client;
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.printWriter = new PrintWriter(socket.getOutputStream(), true);
        }

        public PrintWriter getPrintWriter() {
            return printWriter;
        }

        public void run() {
            try {
                String s;
                JTextArea jta = client.getChatArea();
                while (true) {
                    s = bufferedReader.readLine();
                    jta.setText(jta.getText() + "\nГек: " + s);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

