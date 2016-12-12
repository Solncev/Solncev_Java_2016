package com.solncev;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Created by Марат on 11.12.2016.
 */
public class Server extends ChatWindow {
    private static ChatThread chatThread;

    public Server() {
        super();
    }

    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | UnsupportedLookAndFeelException | IllegalAccessException e) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, e);
        }

        EventQueue.invokeLater(() -> {
            try {
                ServerSocket serverSocket = new ServerSocket(PORT);
                Socket socket = serverSocket.accept();
                Server server = new Server();
                chatThread = new ChatThread(socket, server);
                chatThread.start();
                server.setVisible(true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void SendButtonActionPerformed(ActionEvent actionEvent) {
        chatArea.setText(
                getChatArea().getText() + "\nВы: " + getTextArea().getText()
        );
        chatThread.getPrintWriter().println(getTextArea().getText());
        getTextArea().setText("");
    }
}

