package com.solncev;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Марат on 12.12.2016.
 */
public class ChatThread extends Thread {
    private Socket socket;
    private ChatWindow chatWindow;
    private BufferedReader bufferedReader;
    private PrintWriter printWriter;

    public ChatThread(Socket socket, ChatWindow chatWindow) throws IOException {
        this.socket = socket;
        this.chatWindow = chatWindow;
        this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.printWriter = new PrintWriter(socket.getOutputStream(), true);
    }

    public PrintWriter getPrintWriter() {
        return printWriter;
    }

    public void run() {
        try {
            String s;
            JTextArea jta = chatWindow.getChatArea();
            while (true) {
                s = bufferedReader.readLine();
                jta.setText(jta.getText() + "\nЧук: " + s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
