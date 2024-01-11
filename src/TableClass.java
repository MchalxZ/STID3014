package src;

public class TableClass {
    private final String[] batColumn = {"batNum", "manufacturerName", "teamNum"};
    private final String[] coachColumn = {"coachName", "phoneNum", "teamNum"};
    private final String[] current_playerColumn = {"playerNum", "position", "playerName", "playerAge", "teamNum", "numOfYears", "numOfTeamsPlayed", "battingAverage"};
    private final String[] historical_playerColumn = {"playerNum", "playerName", "playerAge", "separationDate",
            "teamNum"};
    private final String[] player_teamColumn = {"teamNum", "playerNum", "pastGame"};
    private final String[] teamColumn = {"teamNum", "teamName", "city", "managerName"};
    private final String[] workexperienceColumn = {"coachName", "typeOfExperience", "numOfYear"};
    private String backVal;
    private String caseVal;
    private String[] columnVal;
    private String primaryVal;
    private String updateFormat;

    TableClass(String x) {
        caseVal = x;
        switch (x) {
            case "bat":
                setBackVal(batColumnFormat());
                setColumnVal(batColumn);
                setPrimaryVal(batColumn[0]);
                setUpdateFormat(updateBatFormat());
                break;
            case "coacher":
                setBackVal(coacherColumnFormat());
                setColumnVal(coachColumn);
                setPrimaryVal(coachColumn[0]);
                setUpdateFormat(updateCoacherFormat());
                break;
            case "current_player":
                setBackVal(current_playerColumnFormat());
                setColumnVal(current_playerColumn);
                setPrimaryVal(current_playerColumn[0]);
                setUpdateFormat(updateCurrentPlayerFormat());
                break;
            case "historical_player":
                setBackVal(historical_playerColumnFormat());
                setColumnVal(historical_playerColumn);
                setPrimaryVal(historical_playerColumn[0]);
                setUpdateFormat(updateHistoricalPlayerFormat());
                break;
            case "player_team":
                setBackVal(player_teamColumnFormat());
                setColumnVal(player_teamColumn);
                setPrimaryVal(player_teamColumn[1]);
                setUpdateFormat(updatePlayerTeamFormat());
                break;
            case "team":
                setBackVal(teamColumnFormat());
                setColumnVal(teamColumn);
                setPrimaryVal(teamColumn[0]);
                setUpdateFormat(updateTeamFormat());
                break;
            case "workexperience":
                setBackVal(workexperienceColumnFormat());
                setColumnVal(workexperienceColumn);
                setPrimaryVal(workexperienceColumn[0]);
                setUpdateFormat(updateWorkexperienceFormat());
                break;
        }
    }

    public String getPrimaryVal() {
        return primaryVal;
    }

    public void setPrimaryVal(String primaryVal) {
        this.primaryVal = primaryVal;
    }

    public String getCaseVal() {
        return caseVal;
    }

    public void setCaseVal(String caseVal) {
        this.caseVal = caseVal;
    }

    public String[] getColumnVal() {
        return columnVal;
    }

    public void setColumnVal(String[] columnVal) {
        this.columnVal = columnVal;
    }

    private String updateWorkexperienceFormat() {
        return "coachName = ?, typeOfExperience = ?, numOfYear = ?";
    }

    private String updateTeamFormat() {
        return "teamNum = ?, teamName = ?, city = ?, managerName = ?";
    }

    private String updatePlayerTeamFormat() {
        return "teamNum = ?, playerNum = ?, pastGame = ?";
    }

    private String updateHistoricalPlayerFormat() {
        return "playerNum = ?, playerName = ?, playerAge = ?, separationDate = ?, teamNum = ?";
    }

    private String updateCurrentPlayerFormat() {
        return "playerNum = ?, position = ?, playerName = ?, playerAge = ?, teamNum = ?, numOfYears = ?, numOfTeamsPlayed = ?, battingAverage = ?";
    }

    private String updateCoacherFormat() {
        return "coachName = ?, phoneNum = ?, teamNum = ?";
    }

    public String getUpdateFormat() {
        return updateFormat;
    }

    public void setUpdateFormat(String updateFormat) {
        this.updateFormat = updateFormat;
    }

    public String getBackVal() {
        return backVal;
    }

    public void setBackVal(String backVal) {
        this.backVal = backVal;
    }

    public String updateBatFormat() {
        return "batNum = ?, manufacturerName = ?, teamNum = ?";

    }

    public String batColumnFormat() {
        return " (batNum, manufacturerName, teamNum) VALUES (?, ?, ?)";
    }

    public String coacherColumnFormat() {
        return " (coachName, phoneNum, teamNum) VALUES (?, ?, ?)";
    }

    public String current_playerColumnFormat() {
        return " (playerNum, position, playerName, playerAge, teamNum, numOfYears, numOfTeamsPlayed, battingAverage) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    }

    public String historical_playerColumnFormat() {
        return " (playerNum, playerName, playerAge, separationDate, teamNum) VALUES (?, ?, ?, ?, ?)";
    }

    public String player_teamColumnFormat() {
        return " (teamNum, playerNum, pastGame) VALUES (?, ?, ?)";
    }

    public String teamColumnFormat() {
        return " (teamNum, teamName, city, managerName) VALUES (?, ?, ?, ?)";
    }

    public String workexperienceColumnFormat() {
        return " (coachName, typeOfExperience, numOfYear) VALUES (?, ?, ?)";
    }

}