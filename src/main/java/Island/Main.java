package Island;
import Island.Setting.Island;
import Island.Setting.IslandSettings;
import Island.Setting.LifeSimulator;
import Island.Setting.SettingsReader;

public class Main {

    public static void main(String[] args) {


        IslandSettings settings = SettingsReader.setSettings();

        Island island = new Island(settings.getIslandLength(),settings.getLocationsAmt());
        new LifeSimulator(island, settings.getWorldDuration(), settings.getPeriodOfAction()).runLocations();

    }
}
