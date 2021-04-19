package sample;

public class GameData {

    public static void main(String[] args) {

        String arcadeGame = args[0];
        ArcadeGame.read(arcadeGame);

        ConsoleGame Game2 = new ConsoleGame(2018, "Grand Theft Auto V", 20000000, "Action Adventure", "Rockstar North", "Rockstar Games");

        ElectronicGame.describeAll();
    }
}

