package com.solncev;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Created by Марат on 11.12.2016.
 */
public class Server extends JFrame {
    private static final int PORT = 3456;
    private static ServerThread serverThread;
    private JTextArea chatArea;
    private JButton sendButton;
    private JTextArea textArea;
    private JScrollPane jChatScrollPane;
    private JScrollPane jTextScrollPane;

    public Server() {
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
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, e);
        } catch (InstantiationException e) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, e);
        } catch (IllegalAccessException e) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, e);
        } catch (javax.swing.UnsupportedLookAndFeelException e) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, e);
        }

        EventQueue.invokeLater(() -> {
            try {
                ServerSocket serverSocket = new ServerSocket(PORT);
                Socket socket = serverSocket.accept();
                Server server = new Server();
                serverThread = new ServerThread(socket, server);
                serverThread.start();
                server.setVisible(true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public JTextArea getChatArea() {
        return chatArea;
    }

    private void initComponents() {
        createButtons();
        createTextAreas();
        createScrollPanes();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Сервер");
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        setGroups(layout);
        pack();
    }

    private void createButtons() {
        sendButton = new JButton();
        sendButton.setText("Отправить");
        sendButton.addActionListener(this::SendButtonActionPerformed);
    }

    private void createScrollPanes() {
        jChatScrollPane = new JScrollPane();
        jChatScrollPane.setViewportView(chatArea);
        jTextScrollPane = new JScrollPane();
        jTextScrollPane.setViewportView(textArea);
    }

    private void createTextAreas() {
        chatArea = new JTextArea();
        textArea = new JTextArea();
        chatArea.setColumns(25);
        chatArea.setRows(5);
        chatArea.setEditable(false);
        textArea.setColumns(25);
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
        serverThread.getPrintWriter().println(textArea.getText());
        textArea.setText("");
    }

    private static class ServerThread extends Thread {
        private Socket socket;
        private Server server;
        private BufferedReader bufferedReader;
        private PrintWriter printWriter;

        public ServerThread(Socket socket, Server server) throws IOException {
            this.socket = socket;
            this.server = server;
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.printWriter = new PrintWriter(socket.getOutputStream(), true);
        }

        public PrintWriter getPrintWriter() {
            return printWriter;
        }

        public void run() {
            try {
                String s;
                JTextArea jta = server.getChatArea();
                while (true) {
                    s = bufferedReader.readLine();
                    jta.setText(jta.getText() + "\nЧук: " + s);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
