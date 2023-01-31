package Island.Plant;

import Island.Setting.Randomizer;
import Island.Setting.Location;
import lombok.Getter;

public class Plant {
    public static final String PLANT_STRING = "Island/Plant";
    public static final String PLANT_ICON = "\uD83C\uDF3F";
    public static final int MAX_AMOUNT_OF_PLANT = 200;
    @Getter
    private final int weight;

    public Plant() {
        this.weight = 1;
    }

    public void growPlant(Location location){
        safeGrowPlant(location);
    }

    private void safeGrowPlant(Location location) {
        location.getLock().lock();
        try{
            int currentAmtPlants = location.getPlantsAmt();

            if (currentAmtPlants < MAX_AMOUNT_OF_PLANT) {

                int newPlants = Randomizer.getRndNum(1,5);

                for (int i = 0; i < newPlants; i++) {
                    location.getPlants().add(new Plant());
                }
            }

        }finally {
            location.getLock().unlock();
        }
    }
}