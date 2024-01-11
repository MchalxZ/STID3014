package src;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class GUI extends JFrame {

    private static final long serialVersionUID = 1L;
    public static JTextField textField = new JTextField();
    public static String val1 = "";
    public static String val2 = "";
    public static String val3 = "";
    public static String val4 = "";
    public static String val5 = "";
    public static String val6 = "";
    public static String val7 = "";
    public static String val8 = "";
    public static String tableNames = "";
    public static JTable table;
    public static JComboBox playerNumComboBox = new JComboBox();
    public static JComboBox teamNumComboBox = new JComboBox();
    public static JComboBox coachComboBox = new JComboBox();
    public static DefaultTableModel x = new DefaultTableModel();
    public static JComboBox comboBox_1 = new JComboBox();
    private static JTextField textField_1 = new JTextField();
    private static JTextField textField_2 = new JTextField();
    private static JTextField textField_3 = new JTextField();
    private static JTextField textField_4 = new JTextField();
    private static JTextField textField_5 = new JTextField();
    private static JTextField textField_6 = new JTextField();
    private static JTextField textField_7 = new JTextField();
    private static final JLabel lblNewLabel_3 = new JLabel("New label");
    private static final JLabel lblNewLabel_5 = new JLabel("numofYears");
    private static final JLabel lblNewLabel_6 = new JLabel("numofTeamsPlayed");
    private static final JLabel lblNewLabel_7 = new JLabel("battingAverage");
    private static final JDBC connect = new JDBC();
    private final String[] comboBoxVal = {"bat", "coacher", "current_player", "historical_player",
            "player_team", "team", "workexperience"};
    private final ImageIcon a = new ImageIcon("\"C:\\Users\\lixia\\Pictures\\Picture3.png\"");
    private final JPanel contentPane;
    private JPanel panel1;
    private TableClass c = new TableClass("");


    /**
     * Create the frame.
     */
    public GUI() {

        setForeground(SystemColor.textText);
        setFont(new Font("Ink Free", Font.BOLD | Font.ITALIC, 15));
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\lixia\\Downloads\\icons8-baseball-16.png"));
        setTitle("Baseball Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 868, 524);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);
        JComboBox comboBox = new JComboBox();
        comboBox.setBackground(Color.GRAY);
        comboBox.setFont(new Font("Century Schoolbook", Font.PLAIN, 15));
        comboBox.setModel(new DefaultComboBoxModel(new String[]{"bat", "coacher", "current_player",
                "historical_player", "player_team", "team", "workexperience"}));
        comboBox.setBounds(96, 190, 640, 249);
        comboBox.setSelectedIndex(-1);
        contentPane.add(comboBox);
        JLabel lblNewLabel_2 = new JLabel("teamNum");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_2.setForeground(Color.GREEN);
        lblNewLabel_2.setBounds(38, 90, 109, 14);
        contentPane.add(lblNewLabel_2);

        table = new JTable();
        table.setFont(new Font("Times New Roman", Font.ITALIC, 17));
        table.setBackground(SystemColor.activeCaption);
        table.setBorder(null);
        table.setEnabled(false);
        table.setBounds(10, 180, 570, 133);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(27, 241, 797, 222);
        contentPane.add(scrollPane);
        scrollPane.setViewportView(table);
        textField = new JTextField();
        textField.setBackground(Color.GRAY);
        textField.setToolTipText("");
        textField.setBounds(232, 48, 135, 23);
        contentPane.add(textField);
        textField.setColumns(10);
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel.setForeground(Color.GREEN);
        lblNewLabel.setBounds(38, 51, 109, 20);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1.setForeground(Color.GREEN);
        lblNewLabel_1.setBounds(482, 47, 169, 21);
        contentPane.add(lblNewLabel_1);

        textField_1 = new JTextField();
        textField_1.setBackground(Color.GRAY);
        textField_1.setColumns(10);
        textField_1.setBounds(661, 48, 135, 20);
        textField_1.setVisible(false);
        textField_2.setVisible(false);
        textField_3.setVisible(false);
        textField_4.setVisible(false);
        textField_5.setVisible(false);
        textField_6.setVisible(false);
        textField_7.setVisible(false);
        lblNewLabel.setVisible(false);
        lblNewLabel_1.setVisible(false);
        contentPane.add(textField_1);


        textField_2 = new JTextField();
        textField_2.setBackground(Color.GRAY);
        textField_2.setColumns(10);
        textField_2.setBounds(232, 89, 135, 20);
        contentPane.add(textField_2);

        textField_3 = new JTextField();
        textField_3.setBackground(Color.GRAY);
        textField_3.setBounds(661, 89, 135, 20);
        contentPane.add(textField_3);
        textField_3.setColumns(10);

        textField_4 = new JTextField();
        textField_4.setBackground(Color.GRAY);
        textField_4.setBounds(232, 124, 135, 20);
        contentPane.add(textField_4);
        textField_4.setColumns(10);

        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_3.setForeground(Color.GREEN);
        lblNewLabel_3.setBounds(482, 85, 169, 14);
        contentPane.add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("New label");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_4.setForeground(Color.GREEN);
        lblNewLabel_4.setBounds(38, 120, 121, 22);
        contentPane.add(lblNewLabel_4);

        teamNumComboBox = new JComboBox();
        teamNumComboBox.setBackground(Color.GRAY);
        teamNumComboBox.setBounds(232, 89, 135, 21);
        contentPane.add(teamNumComboBox);

        playerNumComboBox = new JComboBox();
        playerNumComboBox.setBackground(Color.GRAY);
        playerNumComboBox.setBounds(232, 48, 135, 22);
        contentPane.add(playerNumComboBox);

        coachComboBox = new JComboBox();
        coachComboBox.setBackground(Color.GRAY);
        coachComboBox.setBounds(232, 45, 135, 22);
        contentPane.add(coachComboBox);

        JLabel lblTable = new JLabel("Table");
        lblTable.setFont(new Font("Yu Gothic UI", Font.BOLD, 89));
        lblTable.setForeground(Color.GREEN);
        lblTable.setBounds(299, 82, 250, 97);
        contentPane.add(lblTable);
        comboBox_1 = new JComboBox();
        comboBox_1.setBackground(Color.GRAY);
        comboBox_1.setModel(new DefaultComboBoxModel(new String[]{"pitcher", "catcher", "first baseman",
                "second baseman", "shortstop", "third baseman", "center fielder", "right fielder", "left fielder"}));
        comboBox_1.setBounds(661, 45, 135, 21);
        contentPane.add(comboBox_1);
        lblNewLabel_2.setVisible(false);
        lblNewLabel_3.setVisible(false);
        lblNewLabel_4.setVisible(false);
        JButton btnNewButton_1 = new JButton("Insert");
        btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\lixia\\Downloads\\icons8-add-gradient (1)\\icons8-add-24.png"));
        btnNewButton_1.setBackground(Color.CYAN);
        btnNewButton_1.setFont(new Font("Georgia", Font.ITALIC, 18));
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String a = (String) comboBox.getSelectedItem();
                String teamNum = "";
                String batNum = "";
                String playerNum = "";
                String playerName = "";
                int playerAge = 0;
                String teamName = "";
                int numOfYears = 0;
                int numOfTeamsPlayed = 0;
                double battAvg = 0;
                switch (a) {
                    case "bat":
                        c = new TableClass(a);
                        batNum = textField.getText();
                        String manufacturerName = textField_1.getText();
                        teamNum = (String) teamNumComboBox.getSelectedItem();
                        connect.insertData(null, null, null, null, 0, teamNum, 0, 0, 0, null, batNum, manufacturerName, null, null, 0, null, null, null, a, c);
                        break;
                    case "coacher":
                        c = new TableClass(a);
                        String coachName = textField.getText();
                        String phoneNum = textField_1.getText();
                        teamNum = (String) teamNumComboBox.getSelectedItem();
                        connect.insertData(null, phoneNum, null, null, 0, teamNum, 0, 0, 0, coachName, null, null, null, null, 0, null, null, null, a, c);
                        break;
                    case "current_player":
                        c = new TableClass(a);
                        playerNum = textField.getText();
                        String position = (String) comboBox_1.getSelectedItem();
                        playerName = textField_4.getText();
                        playerAge = Integer.parseInt(textField_3.getText());
                        teamNum = (String) teamNumComboBox.getSelectedItem();
                        numOfYears = Integer.parseInt(textField_5.getText());
                        numOfTeamsPlayed = Integer.parseInt(textField_6.getText());
                        battAvg = Double.parseDouble(textField_7.getText());
                        connect.insertData(playerNum, null, position, playerName, playerAge, teamNum, numOfYears, numOfTeamsPlayed, battAvg, null, null, null, null, null, 0, null, null, null, a, c);
                        break;
                    case "historical_player":
                        c = new TableClass(a);
                        playerNum = textField.getText();
                        playerName = textField_1.getText();
                        playerAge = Integer.parseInt(textField_4.getText());
                        String SeparationDate = textField_3.getText();
                        teamNum = (String) teamNumComboBox.getSelectedItem();
                        connect.insertData(playerNum, null, null, playerName, playerAge, teamNum, 0, 0, 0, null, null, null, SeparationDate, null, 0, null, null, null, a, c);
                        break;
                    case "player_team":
                        c = new TableClass(a);
                        teamNum = (String) teamNumComboBox.getSelectedItem();
                        playerNum = (String) playerNumComboBox.getSelectedItem();
                        int passGame = Integer.parseInt(textField_1.getText());
                        connect.insertData(playerNum, null, null, null, 0, teamNum, 0, 0, 0, null, null, null, null, null, passGame, null, null, null, a, c);
                        break;
                    case "workexperience":
                        c = new TableClass(a);
                        coachName = (String) coachComboBox.getSelectedItem();
                        String typeOfExperience = textField_1.getText();
                        numOfYears = Integer.parseInt(textField_2.getText());
                        connect.insertData(null, null, null, null, 0, null, numOfYears, 0, 0, coachName, null, null, null, null, 0, null, null, typeOfExperience, a, c);
                        break;
                    case "team":
                        c = new TableClass(a);
                        teamNum = textField.getText();
                        teamName = textField_1.getText();
                        String city = textField_2.getText();
                        String managerName = textField_3.getText();
                        connect.insertData(null, null, null, null, 0, teamNum, 0, 0, 0, null, null, null, null, teamName, 0, managerName, city, null, a, c);
                        break;
                }
                view(a);
                dfClear();
            }
        });
        btnNewButton_1.setBounds(20, 195, 142, 33);
        contentPane.add(btnNewButton_1);

        JButton btnNewButton_1_1 = new JButton("Update");
        btnNewButton_1_1.setIcon(new ImageIcon("C:\\Users\\lixia\\Downloads\\icons8-update-24.png"));
        btnNewButton_1_1.setBackground(Color.CYAN);
        btnNewButton_1_1.setFont(new Font("Georgia", Font.ITALIC, 18));
        btnNewButton_1_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switch ((String) comboBox.getSelectedItem()) {
                    case "bat":
                    case "coacher":
                    case "current_player":
                    case "historical_player":
                    case "team":
                        if (textField.getText().equals("")) {
                            JOptionPane.showMessageDialog(null, "Primary key is null");
                            return;
                        }
                        break;
                }
                tableNames = (String) comboBox.getSelectedItem();
                GUI_update s = new GUI_update();
                GUI_update.textField.setVisible(true);
                GUI_update.textField_1.setVisible(true);
                GUI_update.textField_2.setVisible(true);
                GUI_update.textField_3.setVisible(false);
                GUI_update.textField_4.setVisible(false);
                GUI_update.textField_5.setVisible(false);
                GUI_update.textField_6.setVisible(false);
                GUI_update.textField_7.setVisible(false);
                GUI_update.lblNewLabel_3.setVisible(false);
                GUI_update.lblNewLabel_4.setVisible(false);
                GUI_update.lblNewLabel_5.setVisible(false);
                GUI_update.lblNewLabel_6.setVisible(false);
                GUI_update.lblNewLabel_7.setVisible(false);
                GUI_update.playerNoComboBox.setVisible(false);
                GUI_update.teamNoComboBox.setVisible(false);
                GUI_update.comboBox.setVisible(false);
                GUI_update.coachComboBox.setVisible(false);
                s.setVisible(true);
                TableClass sd = new TableClass(tableNames);
                switch (tableNames) {
                    case "bat":
                        JDBC.setValues(tableNames, sd.getPrimaryVal(), textField.getText());
                        GUI_update.teamNoComboBox.setVisible(true);
                        GUI_update.textField_2.setVisible(false);
                        GUI_update.updateKeylbl.setText("Update Primary Key: " + textField.getText() + " (" + GUI.val1 + ")");
                        break;
                    case "coacher":
                        JDBC.setValues(tableNames, sd.getPrimaryVal(), textField.getText());
                        GUI_update.teamNoComboBox.setVisible(true);
                        GUI_update.textField_2.setVisible(false);
                        GUI_update.updateKeylbl.setText("Update Primary Key: " + textField.getText() + " (" + GUI.val1 + ")");
                        break;
                    case "current_player":
                        JDBC.setValues(tableNames, sd.getPrimaryVal(), textField.getText());
                        GUI_update.teamNoComboBox.setVisible(true);
                        GUI_update.textField_2.setVisible(false);
                        GUI_update.comboBox.setVisible(true);
                        GUI_update.textField_3.setVisible(true);
                        GUI_update.textField_4.setVisible(true);
                        GUI_update.textField_5.setVisible(true);
                        GUI_update.textField_6.setVisible(true);
                        GUI_update.textField_7.setVisible(true);
                        GUI_update.lblNewLabel.setText(c.getColumnVal()[0]);
                        GUI_update.lblNewLabel_1.setText(c.getColumnVal()[1]);
                        GUI_update.lblNewLabel_2.setText(c.getColumnVal()[4]);
                        GUI_update.lblNewLabel_3.setText(c.getColumnVal()[3]);
                        GUI_update.lblNewLabel_4.setText(c.getColumnVal()[2]);
                        GUI_update.lblNewLabel_5.setText(c.getColumnVal()[5]);
                        GUI_update.lblNewLabel_6.setText(c.getColumnVal()[6]);
                        GUI_update.lblNewLabel_7.setText(c.getColumnVal()[7]);
                        GUI_update.lblNewLabel_3.setVisible(true);
                        GUI_update.lblNewLabel_4.setVisible(true);
                        GUI_update.lblNewLabel_5.setVisible(true);
                        GUI_update.lblNewLabel_6.setVisible(true);
                        GUI_update.lblNewLabel_7.setVisible(true);
                        GUI_update.updateKeylbl.setText("Update Primary Key: " + textField.getText() + " (" + GUI.val1 + ")");
                        break;
                    case "historical_player":
                        JDBC.setValues(tableNames, sd.getPrimaryVal(), textField.getText());
                        GUI_update.teamNoComboBox.setVisible(true);
                        GUI_update.lblNewLabel_3.setVisible(true);
                        GUI_update.lblNewLabel_4.setVisible(true);
                        GUI_update.textField_3.setVisible(true);
                        GUI_update.textField_4.setVisible(true);
                        GUI_update.textField_2.setVisible(false);
                        GUI_update.updateKeylbl.setText("Update Primary Key: " + textField.getText() + " (" + GUI.val1 + ")");
                        break;
                    case "player_team":
                        JDBC.setValues(tableNames, sd.getPrimaryVal(), playerNumComboBox.getSelectedItem());
                        GUI_update.textField.setVisible(false);
                        GUI_update.playerNoComboBox.setVisible(true);
                        GUI_update.teamNoComboBox.setVisible(true);
                        GUI_update.textField_2.setVisible(false);
                        GUI_update.updateKeylbl.setText("Update Primary Key: " + playerNumComboBox.getSelectedItem() + " (" + GUI.val1 + ")");
                        break;
                    case "team":
                        JDBC.setValues(tableNames, sd.getPrimaryVal(), textField.getText());
                        GUI_update.textField_3.setVisible(true);
                        GUI_update.lblNewLabel_3.setVisible(true);
                        GUI_update.updateKeylbl.setText("Update Primary Key: " + textField.getText() + " (" + GUI.val1 + ")");
                        break;
                    case "workexperience":
                        JDBC.setValues(tableNames, sd.getPrimaryVal(), coachComboBox.getSelectedItem());
                        GUI_update.coachComboBox.setVisible(true);
                        GUI_update.textField.setVisible(false);
                        GUI_update.updateKeylbl.setText("Update Primary Key: " + coachComboBox.getSelectedItem() + " (" + GUI.val1 + ")");
                        break;

                }
                JDBC.populateComboBox(GUI_update.teamNoComboBox, "team", "teamNum");
                JDBC.populateComboBox(GUI_update.playerNoComboBox, "current_player", "playerNum");
                JDBC.populateComboBox(GUI_update.coachComboBox, "coacher", "coachName");

            }
        });
        btnNewButton_1_1.setBounds(194, 195, 147, 33);
        contentPane.add(btnNewButton_1_1);

        JButton btnNewButton_1_2 = new JButton("Delete");
        btnNewButton_1_2.setBackground(Color.CYAN);
        btnNewButton_1_2.setIcon(new ImageIcon("C:\\Users\\lixia\\Downloads\\icons8-delete-24.png"));
        btnNewButton_1_2.setFont(new Font("Georgia", Font.ITALIC, 18));
        btnNewButton_1_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if ((!comboBox.getSelectedItem().equals("workexperience")) && (!comboBox.getSelectedItem().equals("player_team"))) {
                    if (textField.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Primary Key null!");
                        return;
                    }
                }
                String tableName = (String) comboBox.getSelectedItem();
                TableClass a = new TableClass(tableName);
                String pk = "";
                if (tableName.equals("player_team")) {
                    pk = (String) playerNumComboBox.getSelectedItem();
                } else if (tableName.equals("workexperience")) {
                    pk = (String) coachComboBox.getSelectedItem();
                } else {
                    pk = textField.getText();
                }
                switch (JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the record of " + pk,
                        "Confirmation", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION)) {
                    case 0:
                        connect.deleteData(pk, tableName, a);
                        break;
                }
                view(tableName);
                dfClear();
            }
        });
        btnNewButton_1_2.setBounds(365, 196, 147, 33);
        contentPane.add(btnNewButton_1_2);

        JButton btnNewButton_1_3 = new JButton("Search");
        btnNewButton_1_3.setBackground(Color.CYAN);
        btnNewButton_1_3.setIcon(new ImageIcon("C:\\Users\\lixia\\Downloads\\icons8-search-24.png"));
        btnNewButton_1_3.setFont(new Font("Georgia", Font.ITALIC, 18));
        btnNewButton_1_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String y = "";
                switch ((String) comboBox.getSelectedItem()) {
                    case "bat":
                    case "coacher":
                    case "current_player":
                    case "historical_player":
                    case "team":
                        y = textField.getText();
                        break;
                    case "player_team":
                        y = (String) playerNumComboBox.getSelectedItem();
                        break;
                    case "workexperience":
                        y = (String) coachComboBox.getSelectedItem();
                        break;
                }
                TableClass d = new TableClass((String) comboBox.getSelectedItem());
                JDBC.searchByPrimaryKey((String) comboBox.getSelectedItem(), d.getPrimaryVal(), y);
                if (table.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(null, "Primary Key not found!");
                    textField.setText("");
                    return;
                } else {
                    textField.setText("");
                }
                dfClear();
            }
        });
        btnNewButton_1_3.setBounds(537, 195, 142, 33);
        contentPane.add(btnNewButton_1_3);

        JPanel panel = new JPanel();
        panel.setBackground(Color.MAGENTA);
        panel.setBorder(new LineBorder(new Color(0, 0, 0), 5));
        FlowLayout flowLayout = (FlowLayout) panel.getLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        panel.setBounds(27, 241, 797, 222);
        contentPane.add(panel);


        JButton btnNewButton = new JButton("View");
        btnNewButton.setBackground(Color.CYAN);
        btnNewButton.setIcon(new ImageIcon("C:\\Users\\lixia\\Downloads\\icons8-view-24.png"));
        btnNewButton.setFont(new Font("Georgia", Font.ITALIC, 18));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Views w = new Views();
                w.setVisible(true);
                dfClear();
            }
        });
        btnNewButton.setBounds(704, 195, 135, 33);
        contentPane.add(btnNewButton);

        textField_5 = new JTextField();
        textField_5.setBackground(Color.GRAY);
        textField_5.setBounds(661, 124, 135, 20);
        contentPane.add(textField_5);
        textField_5.setColumns(10);

        textField_6 = new JTextField();
        textField_6.setBackground(Color.GRAY);
        textField_6.setBounds(232, 159, 135, 20);
        contentPane.add(textField_6);
        textField_6.setColumns(10);

        textField_7 = new JTextField();
        textField_7.setBackground(Color.GRAY);
        textField_7.setBounds(661, 159, 135, 20);
        contentPane.add(textField_7);
        textField_7.setColumns(10);

        lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_5.setForeground(Color.GREEN);
        lblNewLabel_5.setBounds(482, 118, 169, 21);
        contentPane.add(lblNewLabel_5);


        lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_6.setForeground(Color.GREEN);
        lblNewLabel_6.setBounds(36, 156, 169, 22);
        contentPane.add(lblNewLabel_6);

        lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_7.setForeground(Color.GREEN);
        lblNewLabel_7.setBounds(482, 153, 169, 22);
        contentPane.add(lblNewLabel_7);
        JLabel imageLbl = new JLabel(new ImageIcon("C:\\Users\\lixia\\Pictures\\What-is-Mongo-DB.jpg"));
        imageLbl.setVerticalAlignment(SwingConstants.TOP);
        imageLbl.setLocation(0, -140);
        imageLbl.setSize(978, 637);


        contentPane.add(imageLbl);
        lblNewLabel.setVisible(false);
        lblNewLabel_1.setVisible(false);
        lblNewLabel_2.setVisible(false);
        lblNewLabel_3.setVisible(false);
        lblNewLabel_4.setVisible(false);
        lblNewLabel_5.setVisible(false);
        lblNewLabel_6.setVisible(false);
        lblNewLabel_7.setVisible(false);
        coachComboBox.setVisible(false);
        playerNumComboBox.setVisible(false);
        teamNumComboBox.setVisible(false);
        comboBox_1.setVisible(false);
        textField.setVisible(false);
        textField_1.setVisible(false);
        textField_2.setVisible(false);
        textField_3.setVisible(false);
        textField_4.setVisible(false);
        textField_5.setVisible(false);
        textField_6.setVisible(false);
        textField_7.setVisible(false);
        btnNewButton.setVisible(false);
        btnNewButton_1.setVisible(false);
        btnNewButton_1_1.setVisible(false);
        btnNewButton_1_2.setVisible(false);
        btnNewButton_1_3.setVisible(false);
        table.setVisible(false);
        panel.setVisible(false);
        scrollPane.setVisible(false);
        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblTable.setBounds(222, 16, 46, 14);
                comboBox.setBounds(292, 12, 220, 22);
                btnNewButton.setVisible(true);
                btnNewButton_1.setVisible(true);
                btnNewButton_1_1.setVisible(true);
                btnNewButton_1_2.setVisible(true);
                btnNewButton_1_3.setVisible(true);
                table.setVisible(true);
                panel.setVisible(true);
                scrollPane.setVisible(true);
                String a = (String) comboBox.getSelectedItem();
                for (String b : comboBoxVal) {
                    if (b.equals(a)) {
                        view(b);
                    }
                    textField.setVisible(true);
                    textField_1.setVisible(true);
                    textField_2.setVisible(true);
                    lblNewLabel.setVisible(true);
                    lblNewLabel_1.setVisible(true);
                    lblNewLabel_2.setVisible(true);
                    lblNewLabel_3.setVisible(false);
                    lblNewLabel_4.setVisible(false);
                    lblNewLabel_5.setVisible(false);
                    lblNewLabel_6.setVisible(false);
                    lblNewLabel_7.setVisible(false);
                    textField_3.setVisible(false);
                    textField_4.setVisible(false);
                    textField_5.setVisible(false);
                    textField_6.setVisible(false);
                    textField_7.setVisible(false);
                    comboBox_1.setVisible(false);
                    teamNumComboBox.setVisible(false);
                    playerNumComboBox.setVisible(false);
                    coachComboBox.setVisible(false);
                    GUI_update.lblNewLabel_3.setVisible(false);
                    GUI_update.lblNewLabel_4.setVisible(false);
                    GUI_update.textField_3.setVisible(false);
                    GUI_update.textField_4.setVisible(false);
                    val4 = "";
                    val5 = "";
                    val6 = "";
                    val7 = "";
                    val8 = "";
                }
                switch (a) {
                    case "bat":
                        c = new TableClass("bat");
                        val1 = c.getPrimaryVal();
                        val2 = c.getColumnVal()[1];
                        val3 = c.getColumnVal()[2];
                        lblNewLabel.setText(c.getColumnVal()[0]);
                        lblNewLabel_1.setText(c.getColumnVal()[1]);
                        lblNewLabel_2.setText(c.getColumnVal()[2]);
                        JDBC.populateComboBox(teamNumComboBox, "team", c.getColumnVal()[2]);
                        textField_2.setVisible(false);
                        teamNumComboBox.setVisible(true);
                        tableNames = a;
                        break;
                    case "coacher":
                        c = new TableClass("coacher");
                        JDBC.populateComboBox(coachComboBox, "coacher", c.getColumnVal()[0]);
                        JDBC.populateComboBox(teamNumComboBox, "team", c.getColumnVal()[2]);
                        lblNewLabel.setText(c.getColumnVal()[0]);
                        lblNewLabel_1.setText(c.getColumnVal()[1]);
                        lblNewLabel_2.setText(c.getColumnVal()[2]);
                        val1 = c.getPrimaryVal();
                        val2 = c.getColumnVal()[1];
                        val3 = c.getColumnVal()[2];
                        textField_2.setVisible(false);
                        teamNumComboBox.setVisible(true);
                        GUI_update.teamNoComboBox.setVisible(true);
                        GUI_update.textField_2.setVisible(true);
                        break;
                    case "current_player":
                        c = new TableClass("current_player");
                        val1 = c.getPrimaryVal();
                        val2 = c.getColumnVal()[1];
                        val3 = c.getColumnVal()[2];
                        val4 = c.getColumnVal()[3];
                        val5 = c.getColumnVal()[4];
                        val6 = c.getColumnVal()[5];
                        val7 = c.getColumnVal()[6];
                        val8 = c.getColumnVal()[7];
                        JDBC.populateComboBox(playerNumComboBox, "current_player", c.getColumnVal()[0]);
                        JDBC.populateComboBox(teamNumComboBox, "team", c.getColumnVal()[4]);
                        lblNewLabel.setText(c.getColumnVal()[0]);
                        lblNewLabel_1.setText(c.getColumnVal()[1]);
                        lblNewLabel_2.setText(c.getColumnVal()[4]);
                        lblNewLabel_3.setText(c.getColumnVal()[3]);
                        lblNewLabel_4.setText(c.getColumnVal()[2]);
                        textField_1.setVisible(false);
                        textField_2.setVisible(false);
                        teamNumComboBox.setVisible(true);
                        lblNewLabel_3.setVisible(true);
                        lblNewLabel_4.setVisible(true);
                        lblNewLabel_5.setVisible(true);
                        lblNewLabel_6.setVisible(true);
                        lblNewLabel_7.setVisible(true);
                        textField_3.setVisible(true);
                        textField_4.setVisible(true);
                        textField_5.setVisible(true);
                        textField_6.setVisible(true);
                        textField_7.setVisible(true);
                        comboBox_1.setVisible(true);
                        GUI_update.lblNewLabel_3.setVisible(true);
                        GUI_update.textField_3.setVisible(true);
                        GUI_update.lblNewLabel_4.setVisible(true);
                        GUI_update.textField_4.setVisible(true);
                        break;
                    case "historical_player":
                        c = new TableClass("historical_player");
                        val1 = c.getPrimaryVal();
                        val2 = c.getColumnVal()[1];
                        val3 = c.getColumnVal()[4];
                        val4 = c.getColumnVal()[3];
                        val5 = c.getColumnVal()[2];
                        JDBC.populateComboBox(playerNumComboBox, "current_player", c.getColumnVal()[0]);
                        JDBC.populateComboBox(teamNumComboBox, "team", c.getColumnVal()[4]);
                        lblNewLabel.setText(c.getColumnVal()[0]);
                        lblNewLabel_1.setText(c.getColumnVal()[1]);
                        lblNewLabel_2.setText(c.getColumnVal()[4]);
                        lblNewLabel_3.setText(c.getColumnVal()[3]);
                        lblNewLabel_4.setText(c.getColumnVal()[2]);
                        lblNewLabel_3.setVisible(true);
                        lblNewLabel_4.setVisible(true);
                        GUI_update.lblNewLabel_3.setVisible(true);
                        GUI_update.textField_3.setVisible(true);
                        GUI_update.lblNewLabel_4.setVisible(true);
                        GUI_update.textField_4.setVisible(true);
                        textField_2.setVisible(false);
                        textField_3.setVisible(true);
                        textField_4.setVisible(true);
                        teamNumComboBox.setVisible(true);
                        break;
                    case "player_team":
                        c = new TableClass("player_team");
                        val1 = c.getPrimaryVal();
                        val2 = c.getColumnVal()[2];
                        val3 = c.getColumnVal()[0];
                        JDBC.populateComboBox(teamNumComboBox, "team", c.getColumnVal()[0]);
                        JDBC.populateComboBox(playerNumComboBox, "current_player", c.getColumnVal()[1]);
                        teamNumComboBox.setVisible(true);
                        playerNumComboBox.setVisible(true);
                        textField.setVisible(false);
                        textField_2.setVisible(false);
                        lblNewLabel.setText(c.getColumnVal()[1]);
                        lblNewLabel_1.setText(c.getColumnVal()[2]);
                        lblNewLabel_2.setText(c.getColumnVal()[0]);
                        break;
                    case "team":
                        c = new TableClass("team");
                        val1 = c.getPrimaryVal();
                        val2 = c.getColumnVal()[1];
                        val3 = c.getColumnVal()[2];
                        val4 = c.getColumnVal()[3];
                        JDBC.populateComboBox(teamNumComboBox, a, c.getColumnVal()[0]);
                        lblNewLabel.setText(c.getColumnVal()[0]);
                        lblNewLabel_1.setText(c.getColumnVal()[1]);
                        lblNewLabel_2.setText(c.getColumnVal()[2]);
                        lblNewLabel_3.setText(c.getColumnVal()[3]);
                        GUI_update.lblNewLabel_3.setVisible(true);
                        GUI_update.textField_3.setVisible(true);
                        lblNewLabel_3.setVisible(true);
                        textField_3.setVisible(true);
                        break;
                    case "workexperience":
                        c = new TableClass("workexperience");
                        val1 = c.getPrimaryVal();
                        val2 = c.getColumnVal()[1];
                        val3 = c.getColumnVal()[2];
                        JDBC.populateComboBox(coachComboBox, "coacher", c.getColumnVal()[0]);
                        coachComboBox.setVisible(true);
                        textField.setVisible(false);
                        lblNewLabel.setText(c.getColumnVal()[0]);
                        lblNewLabel_1.setText(c.getColumnVal()[1]);
                        lblNewLabel_2.setText(c.getColumnVal()[2]);
                        break;
                }
            }

            private void generalGUIsetting() {
                textField.setVisible(true);
                textField_1.setVisible(true);
                textField_2.setVisible(true);
                lblNewLabel_1.setVisible(true);
                lblNewLabel_2.setVisible(true);
                lblNewLabel_3.setVisible(false);
                lblNewLabel_4.setVisible(false);
                textField_3.setVisible(false);
                textField_4.setVisible(false);
                comboBox_1.setVisible(false);
                teamNumComboBox.setVisible(false);
                lblNewLabel.setVisible(true);
            }

        });
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GUI frame = new GUI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void view(String b) {
        TableClass d = new TableClass(b);
        x = new DefaultTableModel(new Object[][]{}, d.getColumnVal()) {
            final Class[] columnTypes = new Class[]{String.class, Object.class, Object.class, Object.class, Object.class,
                    Object.class, Object.class, Object.class};

            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
        };
        table.setModel(x);
        JDBC.viewData(b, x);
    }

    public static void v1() {
        try {
            x = new DefaultTableModel(new Object[][]{}, new String[]{"teamNum", "coachName", "teamName", "managerName", "phoneNum"}) {
                final Class[] columnTypes = new Class[]{String.class, String.class, String.class, String.class, String.class};

                public Class getColumnClass(int columnIndex) {
                    return columnTypes[columnIndex];
                }
            };
            table.setModel(x);
            JDBC.Views1(x);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    public static void v2() {
        try {
            x = new DefaultTableModel(new Object[][]{}, new String[]{"managerName", "coachName"}) {
                final Class[] columnTypes = new Class[]{String.class, String.class};

                public Class getColumnClass(int columnIndex) {
                    return columnTypes[columnIndex];
                }
            };
            table.setModel(x);
            JDBC.Views2(x);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    public static void v3() {
        try {
            x = new DefaultTableModel(new Object[][]{}, new String[]{"teamName", "numOfCurrentPlayer", "numOfPastPlayer"}) {
                final Class[] columnTypes = new Class[]{String.class, String.class, String.class};

                public Class getColumnClass(int columnIndex) {
                    return columnTypes[columnIndex];
                }
            };
            table.setModel(x);
            JDBC.Views3(x);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    public static void dfClear() {
        textField.setText("");
        textField_1.setText("");
        textField_2.setText("");
        textField_3.setText("");
        textField_4.setText("");
        textField_5.setText("");
        textField_6.setText("");
        textField_7.setText("");
        comboBox_1.setSelectedIndex(-1);
        coachComboBox.setSelectedIndex(-1);
        teamNumComboBox.setSelectedIndex(-1);
    }
}

