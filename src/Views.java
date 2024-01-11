package src;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Views extends JFrame {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPane;

    /**
     * Create the frame.
     */
    public Views() {
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(390, 280, 284, 149);
        contentPane = new JPanel();
        contentPane.setBackground(Color.RED);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(0, 2, 0, 0));
        JButton btnNewButton = new JButton("CoachJoinTeam");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GUI.v1();
                dispose();
            }
        });
        btnNewButton.setBackground(Color.BLACK);
        btnNewButton.setForeground(Color.WHITE);
        contentPane.add(btnNewButton);
        JButton View2 = new JButton("View2");
        View2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GUI.v2();
                dispose();
            }
        });
        View2.setBackground(Color.BLACK);
        View2.setForeground(Color.WHITE);
        contentPane.add(View2);
        JButton View3 = new JButton("View3");
        View3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GUI.v3();
                dispose();
            }
        });
        View3.setBackground(Color.BLACK);
        View3.setForeground(Color.WHITE);
        contentPane.add(View3);

        JButton btnNewButton_1 = new JButton("Cancel");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnNewButton_1.setBackground(Color.BLACK);
        btnNewButton_1.setForeground(Color.WHITE);
        contentPane.add(btnNewButton_1);
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Views frame = new Views();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

