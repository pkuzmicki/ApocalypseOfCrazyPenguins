import java.util.Scanner;

public class Player {
    Scene scene;
    public String playerSign = "P";
    public int playerRow;
    public int playerCol;
    public int coinsCollected = 0;
    Scanner scanner = new Scanner(System.in);


    public Player(Scene scene){
        this.scene = scene;
        this.playerRow = scene.maxRow / 2;
        this.playerCol = scene.maxCol / 2;
    }

    public void playerCommands(){
        String command = scanner.nextLine();
        if (command.equals("w") || command.equals("a") || command.equals("s") || command.equals("d")){
            switch (command){
                case "w":
                    if (playerRow > 0){
                        erasePlayer();
                        playerRow -= 1;
                        drawPlayer();
                    } else {
                        System.out.println("You can't cross the borders!");
                        playerCommands();
                    }
                    break;
                case "s":
                    if (playerRow < scene.maxRow - 1){
                        erasePlayer();
                        playerRow += 1;
                        drawPlayer();
                    } else {
                        System.out.println("You can't cross the borders!");
                        playerCommands();
                    }
                    break;
                case "d":
                    if (playerCol < scene.maxCol - 1){
                        erasePlayer();
                        playerCol += 1;
                        drawPlayer();
                    } else {
                        System.out.println("You can't cross the borders!");
                        playerCommands();
                    }
                    break;
                case "a":
                    if (playerCol > 0){
                        erasePlayer();
                        playerCol -= 1;
                        drawPlayer();
                    } else {
                        System.out.println("You can't cross the borders!");
                        playerCommands();
                    }
                    break;

            }
        } else {
            System.out.println("Enter a correct command");
            playerCommands();
        }
    }

    public void checkIfCoinCollected(){
        if (playerCol == scene.coin.coinCol && playerRow == scene.coin.coinRow){
            coinsCollected++;
            scene.coin.addCoin();
        }
    }


    public boolean checkIfMonsterNearby(){
        //sprawdz w polu gracza
        if (scene.map[playerRow][playerCol].equals(scene.monster.monsterSign)){
            scene.endTheGame();
            return true;
        }
        //sprawdz nad
        if (playerRow > 0 && scene.map[playerRow - 1][playerCol].equals(scene.monster.monsterSign)){
            scene.endTheGame();
            return true;
        }
        //sprawdz pod
        if (playerRow < scene.maxRow - 1 && scene.map[playerRow + 1][playerCol].equals(scene.monster.monsterSign)){
            scene.endTheGame();
            return true;
        }
        //sprawdz z lewej
        if (playerCol > 0 && scene.map[playerRow][playerCol - 1].equals(scene.monster.monsterSign)){
            scene.endTheGame();
            return true;
        }
        //sprawdz z prawej
        if (playerCol < scene.maxCol - 1 && scene.map[playerRow][playerCol + 1].equals(scene.monster.monsterSign)) {
            scene.endTheGame();
            return true;
        }
        return false;
    }

    public void drawPlayer(){
        scene.map[playerRow][playerCol] = playerSign;
    }

    public void erasePlayer(){
        scene.map[playerRow][playerCol] = scene.blankSpace;
    }
}
