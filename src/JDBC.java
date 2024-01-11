package src;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Vector;

public class JDBC {
    private static final String url = "URL";
    private static final String user = "USERNAME";
    private static final String password = "PASSWORD";

    public static void viewData(String tName, DefaultTableModel a) {
        try (Connection conn = DriverManager.getConnection(url, user, "")) {
            String sql = "SELECT * FROM " + tName;
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            switch (tName) {
                case "bat":
                    while (resultSet.next()) {
                        a.addRow(new Object[]{resultSet.getString("batNum"), resultSet.getString("manufacturerName"),
                                resultSet.getString("teamNum")});
                    }
                case "coacher":
                    while (resultSet.next()) {
                        a.addRow(new Object[]{resultSet.getString("coachName"), resultSet.getString("phoneNum"),
                                resultSet.getString("teamNum")});
                    }
                case "current_player":
                    while (resultSet.next()) {
                        a.addRow(new Object[]{resultSet.getString("playerNum"), resultSet.getString("position"),
                                resultSet.getString("playerName"), resultSet.getInt("playerAge"),
                                resultSet.getString("teamNum"), resultSet.getInt("numOfYears"),
                                resultSet.getInt("numOfTeamsPlayed"), resultSet.getDouble("battingAverage")});
                    }
                case "historical_player":
                    while (resultSet.next()) {
                        a.addRow(new Object[]{resultSet.getString("playerNum"), resultSet.getString("playerName"),
                                resultSet.getInt("playerAge"), resultSet.getString("separationDate"),
                                resultSet.getString("teamNum")});
                    }
                case "player_team":
                    while (resultSet.next()) {
                        a.addRow(new Object[]{resultSet.getString("teamNum"), resultSet.getString("playerNum"),
                                resultSet.getInt("pastGame")});
                    }
                case "team":
                    while (resultSet.next()) {
                        a.addRow(new Object[]{resultSet.getString("teamNum"), resultSet.getString("teamName"),
                                resultSet.getString("city"), resultSet.getString("managerName")});
                    }
                case "workexperience":
                    while (resultSet.next()) {
                        a.addRow(new Object[]{resultSet.getString("coachName"), resultSet.getString("typeOfExperience"),
                                resultSet.getInt("numOfYear")});
                    }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void Views1(DefaultTableModel a) throws SQLException {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT t.teamNum, c.coachName, t.teamName, t.managerName, c.phoneNum FROM team t JOIN coacher c ON t.teamNum = c.teamNum";
            try (Statement statement = conn.createStatement();
                 ResultSet resultSet = statement.executeQuery(sql)) {
                while (resultSet.next()) {
                    String teamNum = resultSet.getString("t.teamNum");
                    String coachName = resultSet.getString("c.coachName");
                    String teamName = resultSet.getString("t.teamName");
                    String managerName = resultSet.getString("t.managerName");
                    String phoneNum = resultSet.getString("c.phoneNum");
                    a.addRow(new Object[]{teamNum, coachName, teamName, managerName, phoneNum});
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void Views2(DefaultTableModel a) throws SQLException {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT t.managerName, c.coachName FROM team t, coacher c WHERE t.teamNum = c.teamNum";
            try (Statement statement = conn.createStatement();
                 ResultSet resultSet = statement.executeQuery(sql)) {
                while (resultSet.next()) {
                    String managerName = resultSet.getString("t.managerName");
                    String coachName = resultSet.getString("c.coachName");
                    a.addRow(new Object[]{managerName, coachName});
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void Views3(DefaultTableModel a) throws SQLException {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT teamName,COUNT(DISTINCT c.playerNum) AS NumOfCurrentPlayer,COUNT(DISTINCT h.playerNum) AS NumOfPastPlayer FROM team t, current_player c, historical_player h WHERE t.teamNum = c.teamNum AND t.teamNum = h.teamNum GROUP BY teamName";
            try (Statement statement = conn.createStatement();
                 ResultSet resultSet = statement.executeQuery(sql)) {
                while (resultSet.next()) {
                    String teamName = resultSet.getString("teamName");
                    int numOfCurrent = resultSet.getInt("NumOfCurrentPlayer");
                    int numOfPast = resultSet.getInt("NumOfPastPlayer");
                    a.addRow(new Object[]{teamName, numOfCurrent, numOfPast});
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void populateComboBox(JComboBox comboBox, String tableName, String columnName) {
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement statement = conn.createStatement();
            String query = "SELECT DISTINCT " + columnName + " FROM " + tableName;
            ResultSet resultSet = statement.executeQuery(query);
            Vector items = new Vector<>();
            while (resultSet.next()) {
                items.add(resultSet.getString(columnName));
            }
            comboBox.setModel(new DefaultComboBoxModel<>(items));
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error fetching data.");
        }
    }

    public static void setValues(String tableName, String primaryKeyColumnName, Object primaryKeyValue) {
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            String sql = "SELECT * FROM " + tableName + " WHERE " + primaryKeyColumnName + " = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setObject(1, primaryKeyValue);
            ResultSet resultSet = statement.executeQuery();
            switch (tableName) {
                case "bat":
                    while (resultSet.next()) {
                        GUI_update.textField.setText(resultSet.getString("batNum"));
                        GUI_update.textField_1.setText(resultSet.getString("manufacturerName"));
                    }
                case "coacher":
                    while (resultSet.next()) {
                        GUI_update.textField.setText(resultSet.getString("coachName"));
                        GUI_update.textField_1.setText(resultSet.getString("phoneNum"));
                        GUI_update.textField_2.setText(resultSet.getString("teamNum"));
                    }
                case "current_player":
                    while (resultSet.next()) {
                        GUI_update.textField.setText(resultSet.getString("playerNum"));
                        GUI_update.textField_3.setText(String.valueOf(resultSet.getInt("playerAge")));
                        GUI_update.textField_4.setText(resultSet.getString("playerName"));
                        GUI_update.textField_5.setText(String.valueOf(resultSet.getInt("numOfYears")));
                        GUI_update.textField_6.setText(String.valueOf(resultSet.getInt("numOfTeamsPlayed")));
                        GUI_update.textField_7.setText(String.valueOf(resultSet.getDouble("battingAverage")));
                    }
                case "historical_player":
                    while (resultSet.next()) {
                        GUI_update.textField.setText(resultSet.getString("playerNum"));
                        GUI_update.textField_1.setText(resultSet.getString("playerName"));
                        GUI_update.textField_3.setText(resultSet.getString("separationDate"));
                        GUI_update.textField_4.setText(String.valueOf(resultSet.getInt("playerAge")));
                    }
                case "player_team":
                    while (resultSet.next()) {
                        GUI_update.textField_1.setText(String.valueOf(resultSet.getInt("pastGame")));
                    }
                case "team":
                    while (resultSet.next()) {
                        GUI_update.textField.setText(resultSet.getString("teamNum"));
                        GUI_update.textField_1.setText(resultSet.getString("teamName"));
                        GUI_update.textField_2.setText(resultSet.getString("city"));
                        GUI_update.textField_3.setText(resultSet.getString("managerName"));
                    }
                case "workexperience":
                    while (resultSet.next()) {
                        GUI_update.textField_1.setText(resultSet.getString("typeOfExperience"));
                        GUI_update.textField_2.setText(resultSet.getString("numOfYear"));
                    }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void searchByPrimaryKey(String tableName, String primaryKeyColumnName, Object primaryKeyValue) {
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            String sql = "SELECT * FROM " + tableName + " WHERE " + primaryKeyColumnName + " = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setObject(1, primaryKeyValue);
            ResultSet resultSet = statement.executeQuery();
            GUI.x.setRowCount(0);
            switch (tableName) {
                case "bat":
                    while (resultSet.next()) {
                        GUI.x.addRow(new Object[]{resultSet.getString("batNum"), resultSet.getString("manufacturerName"),
                                resultSet.getString("teamNum")});
                    }
                case "coacher":
                    while (resultSet.next()) {
                        GUI.x.addRow(new Object[]{resultSet.getString("coachName"), resultSet.getString("phoneNum"),
                                resultSet.getString("teamNum")});
                    }
                case "current_player":
                    while (resultSet.next()) {
                        GUI.x.addRow(new Object[]{resultSet.getString("playerNum"), resultSet.getString("position"),
                                resultSet.getString("playerName"), resultSet.getInt("playerAge"),
                                resultSet.getString("teamNum"), resultSet.getInt("numOfYears"),
                                resultSet.getInt("numOfTeamsPlayed"), resultSet.getDouble("battingAverage")});
                    }
                case "historical_player":
                    while (resultSet.next()) {
                        GUI.x.addRow(new Object[]{resultSet.getString("playerNum"), resultSet.getString("playerName"),
                                resultSet.getInt("playerAge"), resultSet.getString("separationDate"),
                                resultSet.getString("teamNum")});
                    }
                case "player_team":
                    while (resultSet.next()) {
                        GUI.x.addRow(new Object[]{resultSet.getString("teamNum"), resultSet.getString("playerNum"),
                                resultSet.getInt("pastGame")});
                    }
                case "team":
                    while (resultSet.next()) {
                        GUI.x.addRow(new Object[]{resultSet.getString("teamNum"), resultSet.getString("teamName"),
                                resultSet.getString("city"), resultSet.getString("managerName")});
                    }
                case "workexperience":
                    while (resultSet.next()) {
                        GUI.x.addRow(new Object[]{resultSet.getString("coachName"),
                                resultSet.getString("typeOfExperience"), resultSet.getInt("numOfYear")});
                    }
            }
            GUI.table.setModel(GUI.x);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertData(String playerNum, String phoneNum, String position, String playerName, int playerAge, String teamNum, int numOfYears, int numOfTeamsPlayed, double battingAvg, String coachName, String batNum, String manufacturerName, String separationDate, String teamName, int pastGame, String managerName, String city, String typeOfExp, String tableName,
                           TableClass tc) {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "INSERT INTO " + tableName + tc.getBackVal();
            PreparedStatement statement = conn.prepareStatement(sql);
            switch (tableName) {
                case "bat":
                    statement.setString(1, batNum);
                    statement.setString(2, manufacturerName);
                    statement.setString(3, teamNum);
                    break;
                case "coacher":
                    statement.setString(1, coachName);
                    statement.setString(2, phoneNum);
                    statement.setString(3, teamNum);
                    break;
                case "current_player":
                    statement.setString(1, playerNum);
                    statement.setString(2, position);
                    statement.setString(3, playerName);
                    statement.setInt(4, playerAge);
                    statement.setString(5, teamNum);
                    statement.setInt(6, numOfYears);
                    statement.setInt(7, numOfTeamsPlayed);
                    statement.setDouble(8, battingAvg);
                    break;
                case "historical_player":
                    statement.setString(1, playerNum);
                    statement.setString(2, playerName);
                    statement.setInt(3, playerAge);
                    statement.setString(4, separationDate);
                    statement.setString(5, teamNum);
                    break;
                case "player_team":
                    statement.setString(1, teamNum);
                    statement.setString(2, playerNum);
                    statement.setInt(3, pastGame);
                    break;
                case "team":
                    statement.setString(1, teamNum);
                    statement.setString(2, teamName);
                    statement.setString(3, city);
                    statement.setString(4, managerName);
                    break;
                case "workexperience":
                    statement.setString(1, coachName);
                    statement.setString(2, typeOfExp);
                    statement.setInt(3, numOfYears);
                    break;
            }
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Duplicate primary key! Try again");
        }
    }

    public void updateData(String id, String table, TableClass s, UPDATE a) {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "UPDATE " + table + " SET " + s.getUpdateFormat() + " WHERE " + id + " = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            switch (table) {
                case "bat":
                    statement.setString(1, a.getBatNum());
                    statement.setString(2, a.getManufacturerName());
                    statement.setString(3, a.getTeamNum());
                    statement.setString(4, GUI.textField.getText());
                    break;
                case "coacher":
                    statement.setString(1, a.getCoachName());
                    statement.setString(2, a.getPhoneNum());
                    statement.setString(3, a.getTeamNum());
                    statement.setString(4, GUI.textField.getText());
                    break;
                case "current_player":
                    statement.setString(1, a.getPlayerNum());
                    statement.setString(2, a.getPosition());
                    statement.setString(3, a.getPlayerName());
                    statement.setInt(4, a.getPlayerAge());
                    statement.setString(5, a.getTeamNum());
                    statement.setInt(6, a.getNumOfYears());
                    statement.setInt(7, a.getNumOfTeamsPlayed());
                    statement.setDouble(8, a.getBattingAverage());
                    statement.setString(9, GUI.textField.getText());
                    break;
                case "historical_player":
                    statement.setString(1, a.getPlayerNum());
                    statement.setString(2, a.getPlayerName());
                    statement.setInt(3, a.getPlayerAge());
                    statement.setString(4, a.getSeparation());
                    statement.setString(5, a.getTeamNum());
                    statement.setString(6, GUI.textField.getText());
                    break;
                case "player_team":
                    statement.setString(1, a.getTeamNum());
                    statement.setString(2, a.getPlayerNum());
                    statement.setInt(3, a.getPastGame());
                    statement.setString(4, (String) GUI.playerNumComboBox.getSelectedItem());
                    break;
                case "team":
                    statement.setString(1, a.getTeamNum());
                    statement.setString(2, a.getTeamName());
                    statement.setString(3, a.getCity());
                    statement.setString(4, a.getManagerName());
                    statement.setString(5, GUI.textField.getText());
                    break;
                case "workexperience":
                    statement.setString(1, a.getCoachName());
                    statement.setString(2, a.getTypeOfExp());
                    statement.setInt(3, a.getNumOfYears());
                    statement.setString(4, (String) GUI.coachComboBox.getSelectedItem());
                    break;
            }
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Update failed! Try again");
        }

    }

    public void deleteData(String id, String tableName, TableClass s) {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "DELETE FROM " + tableName + " WHERE " + s.getPrimaryVal() + " = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Delete failed! Try again");
        }
    }

}