package src;

public class UPDATE {
    private final String playerNum;
    private final String position;
    private final String playerName;
    private final int playerAge;
    private final String teamNum;
    private final int numOfYears;
    private final int numOfTeamsPlayed;
    private final double battingAverage;
    private final String batNum;
    private final String manufacturerName;
    private final String coachName;
    private final String phoneNum;
    private final int pastGame;
    private final String teamName;
    private final String managerName;
    private final String city;
    private final String typeOfExp;
    private final String Separation;

    UPDATE(String playerNum, String phoneNum, String position, String playerName, int playerAge, String teamNum, int numOfYears, int numOfTeamsPlayed, double battingAvg, String coachName, String batNum, String manufacturerName, String separation, String teamName, int pastGame, String managerName, String city, String typeOfExp) {
        this.playerNum = playerNum;
        this.position = position;
        this.playerName = playerName;
        this.playerAge = playerAge;
        this.teamNum = teamNum;
        this.numOfYears = numOfYears;
        this.numOfTeamsPlayed = numOfTeamsPlayed;
        this.battingAverage = battingAvg;
        this.batNum = batNum;
        this.manufacturerName = manufacturerName;
        this.coachName = coachName;
        this.phoneNum = phoneNum;
        this.pastGame = pastGame;
        this.city = city;
        this.typeOfExp = typeOfExp;
        this.Separation = separation;
        this.teamName = teamName;
        this.managerName = managerName;
    }

    public String getPlayerNum() {
        return playerNum;
    }

    public String getManagerName() {
        return managerName;
    }

    public String getPosition() {
        return position;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getPlayerAge() {
        return playerAge;
    }

    public String getTeamNum() {
        return teamNum;
    }

    public int getNumOfYears() {
        return numOfYears;
    }

    public int getNumOfTeamsPlayed() {
        return numOfTeamsPlayed;
    }

    public double getBattingAverage() {
        return battingAverage;
    }

    public String getBatNum() {
        return batNum;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public String getCoachName() {
        return coachName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public int getPastGame() {
        return pastGame;
    }

    public String getCity() {
        return city;
    }

    public String getTypeOfExp() {
        return typeOfExp;
    }

    public String getSeparation() {
        return Separation;
    }

}
