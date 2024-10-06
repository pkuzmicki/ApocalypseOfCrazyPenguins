public class Scene {
    public String blankSpace = "░";
    public int turn = 1;
    int maxCol = 31;
    int maxRow = 11;
    public String[][] map = new String[maxRow][maxCol];

    Player player = new Player(this);
    Monster monster = new Monster(this);
    Coin coin = new Coin(this);


    public void setScene(){
        for (int row = 0; row < maxRow; row++) {
            for (int col = 0; col < maxCol; col++){
                map[row][col] = blankSpace;
            }
        }
    }

    public void drawScene(){
        for (int row = 0; row < maxRow; row++) {
            for (int col = 0; col < maxCol; col++){
                System.out.printf(map[row][col]);
            }
            System.out.println();
        }
    }

    public void endTheGame(){
        drawScene();
        System.out.println("Congratulations! You survived " + turn + " turns and collected " + player.coinsCollected +" coins!");
        turn = 0;
    }

}
