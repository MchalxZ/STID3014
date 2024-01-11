package src;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_update extends JFrame {

    private static final long serialVersionUID = 1L;
    public static JTextField textField = new JTextField();
    public static JTextField textField_1 = new JTextField();
    public static JTextField textField_2 = new JTextField();
    public static JTextField textField_3 = new JTextField();
    public static JTextField textField_4 = new JTextField();
    public static JTextField textField_5 = new JTextField();
    public static JTextField textField_6 = new JTextField();
    public static JTextField textField_7 = new JTextField();
    public static JLabel lblNewLabel = new JLabel(GUI.val1);
    public static JLabel lblNewLabel_1 = new JLabel(GUI.val2);
    public static JLabel lblNewLabel_2 = new JLabel(GUI.val3);
    public static JLabel lblNewLabel_3 = new JLabel(GUI.val4);
    public static JLabel lblNewLabel_4 = new JLabel(GUI.val5);
    public static JLabel lblNewLabel_5 = new JLabel(GUI.val6);
    public static JLabel lblNewLabel_6 = new JLabel(GUI.val7);
    public static JLabel lblNewLabel_7 = new JLabel(GUI.val8);
    public static JComboBox playerNoComboBox = GUI.playerNumComboBox;
    public static JComboBox teamNoComboBox = GUI.teamNumComboBox;
    public static JComboBox coachComboBox = GUI.coachComboBox;
    public static JComboBox comboBox = new JComboBox(new Object[]{"pitcher", "catcher", "first baseman",
            "second baseman", "shortstop", "third baseman", "center fielder", "right fielder", "left fielder"});
    public static JLabel updateKeylbl = new JLabel();
    JDBC h = new JDBC();
    private final JPanel contentPane;


    public GUI_update() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(70, 100, 356, 471);
        contentPane = new JPanel();
        contentPane.setBorder(
                new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 0, 255), new Color(0, 255, 255),
                        new Color(255, 0, 0), new Color(255, 200, 0)), new LineBorder(new Color(0, 0, 0), 3)));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblNewLabel_3 = new JLabel(GUI.val4);
        textField = new JTextField();
        textField.setBounds(173, 46, 143, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        lblNewLabel = new JLabel(GUI.val1);
        lblNewLabel.setBounds(30, 49, 133, 14);
        contentPane.add(lblNewLabel);
        lblNewLabel_4 = new JLabel(GUI.val5);

        coachComboBox = new JComboBox();
        coachComboBox.setBounds(173, 45, 143, 21);
        contentPane.add(coachComboBox);

        lblNewLabel_1 = new JLabel(GUI.val2);
        lblNewLabel_1.setBounds(30, 86, 133, 14);
        contentPane.add(lblNewLabel_1);

        lblNewLabel_2 = new JLabel(GUI.val3);
        lblNewLabel_2.setBounds(30, 121, 133, 14);
        contentPane.add(lblNewLabel_2);

        comboBox.setBounds(171, 83, 143, 20);
        contentPane.add(comboBox);

        lblNewLabel_3.setBounds(30, 156, 133, 14);
        contentPane.add(lblNewLabel_3);

        lblNewLabel_4.setBounds(30, 191, 133, 14);
        contentPane.add(lblNewLabel_4);

        textField_1 = new JTextField();
        textField_1.setBounds(171, 83, 145, 20);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        updateKeylbl.setBounds(43, 19, 275, 14);
        contentPane.add(updateKeylbl);
        JButton btnNewButton = new JButton("Update");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String batNum = "";
                String manufacturerName = "";
                String teamNum = "";
                String coachName = "";
                String phoneNum = "";
                String playerNum = "";
                String position = "";
                String playerName = "";
                int playerAge = 0;
                int numOfYears = 0;
                int numOfTeamsPlayed = 0;
                double battingAvg = 0;
                String separation = null;
                int pastGame = 0;
                String city = "";
                String teamName = "";
                String managerName = "";
                String typeOfExp = "";
                TableClass s = new TableClass(GUI.tableNames);
                switch (GUI.tableNames) {
                    case "bat":
                        s = new TableClass(GUI.tableNames);
                        batNum = textField.getText();
                        manufacturerName = textField_1.getText();
                        teamNum = (String) teamNoComboBox.getSelectedItem();
                        break;
                    case "coacher":
                        s = new TableClass(GUI.tableNames);
                        coachName = textField.getText();
                        phoneNum = textField_1.getText();
                        teamNum = (String) teamNoComboBox.getSelectedItem();
                        break;
                    case "current_player":
                        s = new TableClass(GUI.tableNames);
                        playerNum = textField.getText();
                        position = (String) comboBox.getSelectedItem();
                        playerName = textField_4.getText();
                        playerAge = Integer.parseInt(textField_3.getText());
                        teamNum = (String) teamNoComboBox.getSelectedItem();
                        numOfYears = Integer.parseInt(textField_5.getText());
                        numOfTeamsPlayed = Integer.parseInt(textField_6.getText());
                        battingAvg = Double.parseDouble(textField_7.getText());
                        updateKeylbl = new JLabel("Update Primary Key: " + GUI.textField.getText() + " (" + GUI.val1 + ")");
                        break;
                    case "historical_player":
                        s = new TableClass(GUI.tableNames);
                        playerNum = textField.getText();
                        playerName = textField_1.getText();
                        playerAge = Integer.parseInt(textField_4.getText());
                        separation = textField_3.getText();
                        teamNum = (String) teamNoComboBox.getSelectedItem();
                        updateKeylbl = new JLabel("Update Primary Key: " + GUI.textField.getText() + " (" + GUI.val1 + ")");
                        break;
                    case "player_team":
                        s = new TableClass(GUI.tableNames);
                        teamNum = (String) teamNoComboBox.getSelectedItem();
                        playerNum = (String) playerNoComboBox.getSelectedItem();
                        pastGame = Integer.parseInt(textField_1.getText());
                        updateKeylbl = new JLabel("Update Primary Key: " + GUI.comboBox_1.getSelectedItem() + " (" + GUI.val1 + ")");
                        break;
                    case "team":
                        s = new TableClass(GUI.tableNames);
                        teamNum = textField.getText();
                        teamName = textField_1.getText();
                        city = textField_2.getText();
                        managerName = textField_3.getText();
                        updateKeylbl = new JLabel("Update Primary Key: " + GUI.textField.getText() + " (" + GUI.val1 + ")");
                        break;
                    case "workexperience":
                        s = new TableClass(GUI.tableNames);
                        coachName = (String) coachComboBox.getSelectedItem();
                        typeOfExp = textField_1.getText();
                        numOfYears = Integer.parseInt(textField_2.getText());
                        updateKeylbl = new JLabel("Update Primary Key: " + GUI.comboBox_1.getSelectedItem() + " (" + GUI.val1 + ")");
                        break;
                }
                if (JOptionPane.showConfirmDialog(null, "Are you sure?", "Confirmation", JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE, null) == 0) {
                    UPDATE ad = new UPDATE(null, null, null, null, 0, null, 0, 0, 0, null, null, null, null, null, 0, null, null, null);
                    switch (GUI.tableNames) {
                        case "bat":
                            ad = new UPDATE(null, null, null, null, 0, teamNum, 0, 0, 0, null, batNum, manufacturerName, null, null, 0, null, null, null);
                            h.updateData(s.getPrimaryVal(), GUI.tableNames, s, ad);
                            break;
                        case "coacher":
                            ad = new UPDATE(null, phoneNum, null, null, 0, teamNum, 0, 0, 0, coachName, null, null, null, null, 0, null, null, null);
                            h.updateData(s.getPrimaryVal(), GUI.tableNames, s, ad);
                            break;
                        case "current_player":
                            ad = new UPDATE(playerNum, null, position, playerName, playerAge, teamNum, numOfYears, numOfTeamsPlayed, battingAvg, null, null, null, null, null, 0, null, null, null);
                            h.updateData(s.getPrimaryVal(), GUI.tableNames, s, ad);
                            break;
                        case "historical_player":
                            ad = new UPDATE(playerNum, null, null, playerName, playerAge, teamNum, 0, 0, 0, null, null, null, separation, null, 0, null, null, null);
                            h.updateData(s.getPrimaryVal(), GUI.tableNames, s, ad);
                            break;
                        case "player_team":
                            ad = new UPDATE(playerNum, null, null, null, 0, teamNum, 0, 0, 0, null, null, null, null, null, pastGame, null, null, null);
                            h.updateData(s.getPrimaryVal(), GUI.tableNames, s, ad);
                            break;
                        case "team":
                            ad = new UPDATE(null, null, null, null, 0, teamNum, 0, 0, 0, null, null, null, null, teamName, 0, managerName, city, null);
                            h.updateData(s.getPrimaryVal(), GUI.tableNames, s, ad);
                            break;
                        case "workexperience":
                            ad = new UPDATE(null, null, null, null, 0, null, numOfYears, 0, 0, coachName, null, null, null, null, 0, null, null, typeOfExp);
                            h.updateData(s.getPrimaryVal(), GUI.tableNames, s, ad);
                            break;
                    }
                    dispose();
                    GUI.view(GUI.tableNames);
                } else {
                    System.out.println("no");
                }
            }
        });
        btnNewButton.setBounds(126, 375, 89, 23);
        contentPane.add(btnNewButton);

        textField_2 = new JTextField();
        textField_2.setBounds(173, 119, 143, 20);
        contentPane.add(textField_2);
        textField_2.setColumns(10);

        textField_3.setBounds(173, 154, 143, 20);
        contentPane.add(textField_3);
        textField_3.setColumns(10);

        textField_4.setBounds(173, 191, 143, 20);
        contentPane.add(textField_4);
        textField_4.setColumns(10);

        playerNoComboBox = new JComboBox();
        playerNoComboBox.setBounds(173, 45, 143, 21);
        contentPane.add(playerNoComboBox);

        teamNoComboBox = new JComboBox();
        teamNoComboBox.setBounds(173, 121, 143, 20);
        contentPane.add(teamNoComboBox);

        textField_5 = new JTextField();
        textField_5.setBounds(173, 227, 143, 20);
        contentPane.add(textField_5);
        textField_5.setColumns(10);

        textField_6 = new JTextField();
        textField_6.setBounds(173, 269, 143, 20);
        contentPane.add(textField_6);
        textField_6.setColumns(10);

        textField_7 = new JTextField();
        textField_7.setBounds(173, 311, 143, 20);
        contentPane.add(textField_7);
        textField_7.setColumns(10);

        lblNewLabel_5 = new JLabel("New label");
        lblNewLabel_5.setBounds(30, 230, 133, 14);
        contentPane.add(lblNewLabel_5);

        lblNewLabel_6 = new JLabel("New label");
        lblNewLabel_6.setBounds(30, 272, 133, 14);
        contentPane.add(lblNewLabel_6);

        lblNewLabel_7 = new JLabel("New label");
        lblNewLabel_7.setBounds(30, 314, 133, 14);
        contentPane.add(lblNewLabel_7);


    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GUI_update frame = new GUI_update();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

