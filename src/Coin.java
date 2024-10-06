import java.util.Random;

public class Coin {
    Scene scene;
    public String coinSign = "$";
    public int coinCol;
    public int coinRow;
    Random random = new Random();

    public Coin(Scene scene){
        this.scene = scene;
    }

    public void addCoin() {
        coinCol = random.nextInt(scene.maxCol);
        coinRow = random.nextInt(scene.maxRow);

        if (scene.map[coinRow][coinCol].equals(scene.blankSpace)){
            scene.map[coinRow][coinCol] = coinSign;
        } else {
            addCoin();
        }
    }
}
