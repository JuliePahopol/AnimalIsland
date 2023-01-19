package Island.Plant;

import IslandSettings.Location.IslandSettings.Location;

public class PlantTask {
    private final Plant plant;

    private final Location location;


    public PlantTask(Plant plant, Location location) {
        this.plant = plant;
        this.location = location;
    }

    public void simulatePlantLife(){
        plant.growPlant(location);
    }
}
