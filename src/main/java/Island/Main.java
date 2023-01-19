package Island;
import IslandSettings.Location.IslandSettings.Island;
import IslandSettings.Location.IslandSettings.IslandSettings;
import IslandSettings.Location.IslandSettings.LifeSimulator;
import IslandSettings.Location.IslandSettings.SettingsReader;

public class Main {

    public static void main(String[] args) {


        IslandSettings settings = SettingsReader.setSettings();

        Island island = new Island(settings.getIslandLength(),settings.getLocationsAmt());
        new LifeSimulator(island, settings.getWorldDuration(), settings.getPeriodOfAction()).runLocations();

    }
}
