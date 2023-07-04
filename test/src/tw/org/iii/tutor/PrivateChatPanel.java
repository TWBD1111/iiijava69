package tw.org.iii.tutor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrivateChatPanel extends JPanel {
    private JTextArea chatArea;
    private JTextField messageField;

    public PrivateChatPanel() {
        setLayout(new BorderLayout());

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);
        add(scrollPane, BorderLayout.CENTER);

        messageField = new JTextField();
        add(messageField, BorderLayout.SOUTH);

        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = messageField.getText();
                sendMessage(message);
                messageField.setText("");
            }
        });
        add(sendButton, BorderLayout.EAST);
    }

    private void sendMessage(String message) {
        // 在这里实现发送消息的逻辑
        // 可以将消息发送给特定的用户或服务器
        // 根据您的需求自行实现
        chatArea.append("You: " + message + "\n");
    }
}