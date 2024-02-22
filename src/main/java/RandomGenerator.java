import java.util.Random;

public class RandomGenerator implements Generator{
    public boolean generate() {
        return new Random().nextBoolean();
    }
}
