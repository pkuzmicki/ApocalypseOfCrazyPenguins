import java.util.ArrayList;
import java.util.Random;

public class Monster {
    Scene scene;
    public String monsterSign = "M";
    public int monsterRow;
    public int monsterCol;
    public ArrayList<Monster> monsters;
    Random random = new Random();


    public Monster(Scene scene){
        this.scene = scene;
        monsters = new ArrayList<>();
        monsterRow = random.nextInt(2) * 10;
        monsterCol = random.nextInt(scene.maxCol);
    }

    public void addMonster(Monster monster) {
        if (monsters.isEmpty()) {
            Monster firstMonster = new Monster(scene);
            monsters.add(firstMonster);
            drawMonster(firstMonster);
            return;
        }

        for (Monster existingMonster : monsters) {
            if (existingMonster.monsterRow == monster.monsterRow && existingMonster.monsterCol == monster.monsterCol) {
                Monster newMonster = new Monster(scene);
                addMonster(newMonster);
                break;
            }
        }

        monsters.add(monster);
        drawMonster(monster);
    }

    public void moveMonsters(){
        for (Monster monster : monsters) {
            moveMonster(monster);
        }
    }

    public void moveMonster(Monster monster){
        Random random = new Random();
        boolean isMoveDone = false;

        while (!isMoveDone){
            int nextMove = random.nextInt(4)+1;
            switch (nextMove){
                case 1:
                    if (monster.monsterCol > 0 && isAreaFreeToMove(monster.monsterRow, monster.monsterCol - 1)){
                        eraseMonster(monster);
                        monster.monsterCol -= 1;
                        drawMonster(monster);
                        isMoveDone = true;
                    }
                    break;
                case 2:
                    if (monster.monsterCol < scene.maxCol - 1 && isAreaFreeToMove(monster.monsterRow, monster.monsterCol + 1)){
                        eraseMonster(monster);
                        monster.monsterCol += 1;
                        drawMonster(monster);
                        isMoveDone = true;
                    }
                    break;
                case 3:
                    if (monster.monsterRow > 0 && isAreaFreeToMove(monster.monsterRow - 1, monster.monsterCol)){
                        eraseMonster(monster);
                        monster.monsterRow -= 1;
                        drawMonster(monster);
                        isMoveDone = true;
                    }
                    break;
                case 4:
                    if (monster.monsterRow < scene.maxRow - 1 && isAreaFreeToMove(monster.monsterRow + 1, monster.monsterCol)){
                        eraseMonster(monster);
                        monster.monsterRow += 1;
                        drawMonster(monster);
                        isMoveDone = true;
                    }
                    break;
            }
        }
    }

    public boolean isAreaFreeToMove(int newRow, int newCol){
        return scene.map[newRow][newCol].equals(scene.blankSpace);
    }

    public void drawMonster(Monster monster){
        scene.map[monster.monsterRow][monster.monsterCol] = monsterSign;
    }

    public void eraseMonster(Monster monster){
        scene.map[monster.monsterRow][monster.monsterCol] = scene.blankSpace;
    }
}
