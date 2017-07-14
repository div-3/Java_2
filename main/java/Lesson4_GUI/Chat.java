package Lesson4_GUI;

import javax.swing.*;
import java.awt.*;

/**
 1. Создать окно для клиентской части чата: большое текстовое поле для отображения переписки в центре окна.
 Однострочное текстовое поле для ввода сообщений и кнопка для отсылки сообщений на нижней панели. Сообщение
 должно отсылаться либо по нажатию кнопки на форме, либо по нажатию кнопки Enter.
 При «отсылке» сообщение перекидывается из нижнего поля в центральное.
 */
public class Chat extends JFrame {
    JTextArea messageHistory;
    JTextField messageInput;

    public Chat() {
        //Определяем параметры окна
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(400, 200, 600, 800);
        setTitle("My Swing Chat");

        //Создаём структуру интерфейса на основе нескольких JPanel
        JPanel centralPanel = new JPanel();
        centralPanel.setLayout(new BorderLayout());
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        add(centralPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        //Добавляем прокручиваемый JTextArea для окна сообщений
        messageHistory = new JTextArea();
        messageHistory.setForeground(Color.DARK_GRAY);
        Font historyFont = new Font("Arial", Font.PLAIN, 15);
        messageHistory.setEnabled(false);
        messageHistory.setFont(historyFont);

        JScrollPane jsp = new JScrollPane(messageHistory);
        centralPanel.add(jsp, BorderLayout.CENTER);

        //Добавляем JTextField для ввода сообщения
        messageInput = new JTextField();
        Font inputFont = new Font("Arial", Font.PLAIN, 17);
        messageInput.setFont(inputFont);
        messageInput.addActionListener(e -> sendMessage());
        bottomPanel.add(messageInput, BorderLayout.CENTER);

        //Добавляем JButton для отправки сообщений
        JButton btnSendMessage = new JButton("Send");
        btnSendMessage.setPreferredSize(new Dimension(70, 35));
        btnSendMessage.addActionListener(e -> sendMessage());
        bottomPanel.add(btnSendMessage, BorderLayout.EAST);

        setVisible(true);

        //После открытия окна чата установка фокуса ввода на поле для написания сообщения
        messageInput.grabFocus();
    }

    public void sendMessage() {
        messageHistory.append(messageInput.getText() + "\n");
        messageInput.setText("");
        messageInput.grabFocus();
    }
}