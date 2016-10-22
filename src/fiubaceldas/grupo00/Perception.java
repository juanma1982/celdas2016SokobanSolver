package fiubaceldas.grupo00;
/**
 * @author  Juan Manuel Rodríguez
 * @date 21/10/2016
 * */

import java.util.ArrayList;

import core.game.Observation;
import core.game.StateObservationMulti;

public class Perception {

	
	/*Legend:
	 *  w: WALL
		A: Agent A
		1: Box
		0: box destination
		B: Agent B
		.: empty space
	 * 
	 * */
	private char[][] level = null;
	private int sizeWorldWidthInPixels;
	private int sizeWorldHeightInPixels;
	private int levelWidth;
	private int levelHeight;
	private int spriteSizeWidthInPixels;
	private int spriteSizeHeightInPixels;

	
	public Perception(StateObservationMulti stateObs){
		 	ArrayList<Observation>[][] grid = stateObs.getObservationGrid();
	        ArrayList<Observation> observationList;
	        Observation o;
	        
	        
	        this.sizeWorldWidthInPixels= stateObs.getWorldDimension().width;
	        this.sizeWorldHeightInPixels= stateObs.getWorldDimension().height;
	        this.levelWidth = stateObs.getObservationGrid().length;
	        this.levelHeight = stateObs.getObservationGrid()[0].length;
	        this.spriteSizeWidthInPixels =  stateObs.getWorldDimension().width / levelWidth;
	        this.spriteSizeHeightInPixels =  stateObs.getWorldDimension().height / levelHeight;

	        this.level = new char[levelHeight][levelWidth];
	        for(int i=0;i< levelWidth; i++){
	        	for(int j=0;j< levelHeight; j++){
	        		observationList = (grid[i][j]);
	        		 if(!observationList.isEmpty()){
	        			 o = observationList.get(observationList.size()-1);
	        			 if(o.category == 4){
	        				 if(o.itype == 3){
	        					 this.level[j][i] = '0';
	        				 }else if(o.itype == 0){
	        					 this.level[j][i] = 'w';	 
	        				 }
	        				 
	        			 }else if(o.category == 0){        				 
	        				 if(o.itype == 5){
	        					 this.level[j][i] = 'A';
	        				 }else if(o.itype == 6){
	        					 this.level[j][i] = 'B';
	        				 }
	        			 }else if(o.category == 6){
	        				 this.level[j][i] = '1';
	        			 }else{	        				 
	        				 this.level[j][i] = '?';
	        			 }
	        		 }else{
	        			 this.level[j][i] = '.';
	        		 }
	        	}	        	
	        }
	}
	
	public char getAt(int i, int j){
		return level[i][j];
	}
	
	
	public char[][] getLevel(){
		return level;
	}
	
	public int getSizeWorldWidthInPixels() {
		return sizeWorldWidthInPixels;
	}
	
	public int getSizeWorldHeightInPixels() {
		return sizeWorldHeightInPixels;
	}

	
	public int getLevelWidth() {
		return levelWidth;
	}

	
	public int getLevelHeight() {
		return levelHeight;
	}

	public int getSpriteSizeWidthInPixels() {
		return spriteSizeWidthInPixels;
	}

	
	public int getSpriteSizeHeightInPixels() {
		return spriteSizeHeightInPixels;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder("");
		if(level!=null){
			 for(int i=0;i< level.length; i++){
		        	for(int j=0;j<  level[i].length; j++){
		        		sb.append(level[i][j]);
		        	}
		        	sb.append("\n");
			 }
		}
		return sb.toString();
	}
	
}
