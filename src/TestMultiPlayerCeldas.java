import java.util.Random;

import core.ArcadeMachine;

/**
 * Created with IntelliJ IDEA.
 * User: Raluca
 * Date: 12/04/16
 * This is a Java port from Tom Schaul's VGDL - https://github.com/schaul/py-vgdl
 * Modified: Juan Manuel Rodríguez, 75.68 Celdas, fi.uba.ar: http://materias.fi.uba.ar/7568/
 */
public class TestMultiPlayerCeldas
{

    public static void main(String[] args)
    {
        //Controladores disponibles de ejemplo:
        String doNothingController = "controllers.multiPlayer.doNothing.Agent";
        String randomController = "controllers.multiPlayer.sampleRandom.Agent";
        String oneStepController = "controllers.multiPlayer.sampleOneStepLookAhead.Agent";
        String sampleMCTSController = "controllers.multiPlayer.sampleMCTS.Agent";
        String sampleOLMCTSController = "controllers.multiPlayer.sampleOLMCTS.Agent";
        String sampleGAController = "controllers.multiPlayer.sampleGA.Agent";
        String humanController = "controllers.multiPlayer.human.Agent";
        String celdasController = "fiubaceldas.grupo00.Agent";

        //definir acá los controladores usados para el juego (se necesitan 2 controladores separados por un espacio)
        String controllers = humanController + " " + celdasController;
        //String controllers = sampleOLMCTSController + " " + sampleOLMCTSController;

        //ubicación de los juegos disponibles:
        String gamesPath = "examples/2player/";
        String gameName = "sokoban";
        
        
        //otros settings
        boolean visuals = true;
        int seed = new Random().nextInt();

        //Qué nivel se utiliza
        int gameIdx = 0;
        int levelIdx = 0; //level names from 0 to 4 (game_lvlN.txt).
        String game = gamesPath + gameName + ".txt";
        String level1 = gamesPath + gameName + "_lvl" + levelIdx +".txt";

        //nombre de archivo en doned se guardaran las acciones ejecutadas. Si es null no guardará nada
        String recordActionsFile = null;//"actions_" + games[gameIdx] + "_lvl" + levelIdx + "_" + seed + ".txt"; 

        // 1. descomentar la línea de abajo para que el juego inicie para dos jugadores humanos
//        ArcadeMachine.playOneGameMulti(game, level1, recordActionsFile, seed);
        
        //2. Esta línea sirve para iniciar el juego para dos controllers (es decir los agentes inteligentes). Si se quiere que uno de los jugadores
        //sea humano, cambiar el último paramtro (0) a 1.
        ArcadeMachine.runOneGame(game, level1, visuals, controllers, recordActionsFile, seed, 0);

        //3. Esta línea permite repetir un juego desde un archivo de acciones, que se haya grabado previamente
//        String readActionsFile = recordActionsFile;
//        ArcadeMachine.replayGame(game, level1, visuals, readActionsFile);

        // 4. Las siguientes líneas permiten jugar un mismo juego en N niveles M veces
//        String level2 = gamesPath + games[gameIdx] + "_lvl" + 1 +".txt";
//        int M = 3;
//        for(int i=0; i<games.length; i++){
//        	game = gamesPath + games[i] + ".txt";
//        	level1 = gamesPath + games[i] + "_lvl" + levelIdx +".txt";
//        	ArcadeMachine.runGames(game, new String[]{level1}, M, controllers, null);
//        }


    }
}
