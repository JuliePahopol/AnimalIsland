package Island.Setting;
import Island.Setting.IslandSettings;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class SettingsReader {
    private static final String SETTINGS_FILE = "src/main/resources/Settings.json";

    public static IslandSettings setSettings() {

        File file = new File(SETTINGS_FILE);

        ObjectMapper mapper = new ObjectMapper();

        IslandSettings islandSetting = new IslandSettings();
        try {
            islandSetting = mapper.readValue(file, IslandSettings.class);
        } catch (IOException e) {
            System.out.println("Something went wrong with " + SETTINGS_FILE + "file.");
        }
        return islandSetting;
    }
}
