package Island.AnimalSetting;

import Island.Animals.Animal;
import Island.Setting.Island;
import Island.Setting.Location;

public class AnimalTask {
    private final Animal animal;

    private final Island island;
    private final Location location;
    public AnimalTask(Animal animal, Island island, Location location) {
        this.animal = animal;
        this.island = island;
        this.location = location;
    }
    public void simulateAnimalLife() {
        animal.move(location, island);
        animal.eat(location);
        animal.reproduce(location);
        animal.killAnimal(location);
    }
}
