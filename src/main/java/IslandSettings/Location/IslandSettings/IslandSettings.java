package IslandSettings.Location.IslandSettings;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

    public class IslandSettings {
        @Getter
        private int islandLength = 10;
        @Getter
        private int islandWidth= 10;
        @JsonIgnore
        private int locationsAmt;
        @Getter
        private int worldDuration = 7000;
        @Getter
        private int periodOfAction= 1000;


        public int getLocationsAmt() {
            return islandLength * islandWidth;
        }
}
