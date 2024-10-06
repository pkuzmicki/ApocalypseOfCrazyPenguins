public class Main {
    public static void main(String[] args) {
        Scene scene = new Scene();

        scene.turn = 1;
        scene.setScene();
        scene.player.drawPlayer();
        scene.coin.addCoin();

        while (scene.turn > 0){
            //ustawianie nowego potwora ->
            if (scene.turn % 3 == 0){
                scene.monster.addMonster(new Monster(scene));
            }

            //ruch gracza ->
            scene.drawScene();
            System.out.println("Turn: " + scene.turn + "| Coins: " + scene.player.coinsCollected);
            System.out.println("Enter a command");
            scene.player.playerCommands();
            scene.player.checkIfCoinCollected();

            //ruch potworów -> powtórzenie pętli
            scene.monster.moveMonsters();
            if (!scene.player.checkIfMonsterNearby()){
                scene.turn++;
            }
            System.out.println();
        }
    }
}