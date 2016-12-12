package com.solncev;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by Марат on 12.12.2016.
 */
public class ChatWindow extends JFrame {
    protected static final String HOST = "localhost";
    protected static final int PORT = 3456;
    private static ChatThread chatThread;
    protected JTextArea chatArea;
    protected JTextArea textArea;
    private JButton sendButton;
    private JScrollPane jChatScrollPane;
    private JScrollPane jTextScrollPane;

    public ChatWindow() {
        initComponents();
    }

    private void initComponents() {
        createButtons();
        createTextAreas();
        createScrollPanes();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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

    public void SendButtonActionPerformed(ActionEvent actionEvent) {
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

    public JTextArea getTextArea() {
        return textArea;
    }
}
