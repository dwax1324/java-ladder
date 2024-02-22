public class Bridge {

    boolean hasBridge;
    public Bridge(Generator generator) {
        this.hasBridge = generator.generate();
    }

    public boolean getState() {
        return true;
    }
}
