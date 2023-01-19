package Island;

public interface Mortal {

    default boolean isDead(Double satiety) {
        return satiety <= satiety * 0.5;
    }
}
