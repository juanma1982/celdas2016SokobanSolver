package fiubaceldas.grupo00;

import core.game.StateObservationMulti;
import core.player.AbstractMultiPlayer;
import ontology.Types.ACTIONS;
import tools.ElapsedCpuTimer;


public class Agent extends AbstractMultiPlayer {

	
	public Agent(StateObservationMulti stateObs, ElapsedCpuTimer elapsedTimer, int playerID) {
	}
	
	@Override
	public ACTIONS act(StateObservationMulti stateObs, ElapsedCpuTimer elapsedTimer) {
		 Perception perception = new Perception(stateObs);
	        System.out.println(perception.toString());
		return ACTIONS.ACTION_NIL;
	}

}
