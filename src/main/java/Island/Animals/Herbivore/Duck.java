package Island.Animals.Herbivore;

import Island.Animals.Animal;
import Island.Setting.Location;
import Island.AnimalSetting.JsonAnimalHuntChanceReader;
import Island.Setting.Randomizer;
import Island.Plant.Plant;

import java.util.*;

import static Island.Plant.Plant.PLANT_STRING;

public class Duck extends Herbivore{
    public Duck(double weight, double satiety, int speed) {
        super(weight, satiety, speed);
    }

    @Override
    public void eat(Location location) {
        safeEat(location);
    }

    private void safeEat(Location location) {
        location.getLock().lock();
        try {
            if (this.isHungry()) {

                Queue<Plant> plants = location.getPlants();
                Map<String, Queue<Animal>> animals = location.getAnimals();

                Map<String, Integer> huntChance = getRndPray();
                String preyName = (String) huntChance.keySet().toArray()[0];
                int attempt = Randomizer.getRndNum(2, 5);

                if (preyName.equals(PLANT_STRING)) {   // constant
                    while ((attempt >= 0) && (isHungry())) {
                        if (!(plants.isEmpty())) {
                            Plant eatenPlant = plants.remove();
                            eatPlant(this, eatenPlant);
                        }
                        attempt--;
                    }
                } else if ((animals.containsKey(preyName)) && animals.get(preyName).size() != 0) {

                    Animal prey = animals.get(preyName).peek();

                    while ((attempt >= 0) && (isHungry())) {
                        if (isHuntSuccessful(huntChance.get(preyName), prey)) {
                            animals.get(preyName).remove(this);
                        }
                        attempt--;
                    }
                }
            }
        } finally {
            location.getLock().unlock();
        }

    }

    private boolean isHuntSuccessful(Integer chance, Animal prey) {
        if (getHuntResult(chance)) {
            eatAnimal(this, prey);
            return true;
        }
        return false;
    }

    private boolean getHuntResult(Integer chance) {
        return Randomizer.getRndNum(100) <= chance;
    }

    private void eatAnimal(Animal hunter, Animal prey) {
        double newSatiety = hunter.getCurrentSatiety() + (prey.getWeight());
        hunter.setCurrentSatiety(Math.min(newSatiety, hunter.getSatiety()));
    }

    private void eatPlant(Animal hunter, Plant plant) {
        double newSatiety = hunter.getCurrentSatiety() + (plant.getWeight());
        hunter.setCurrentSatiety(Math.min(newSatiety, hunter.getSatiety()));
    }

    private Map<String, Integer> getRndPray() {
        Map<String, Integer> huntChance = JsonAnimalHuntChanceReader.getHuntingChanceMap(getName());

        List<String> prayName = new ArrayList<>(huntChance.keySet());
        int rndNum = Randomizer.getRndNum(prayName.size());

        Map<String, Integer> result = new HashMap<>();

        String rndPrayName = prayName.get(rndNum);
        result.put(rndPrayName, huntChance.get(rndPrayName));

        return result;
    }

}