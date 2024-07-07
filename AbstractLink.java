package hw4;

import api.Crossable;
import api.Point;
import api.PositionVector;

public abstract class AbstractLink extends java.lang.Object implements Crossable{
	public AbstractLink() {
		
	}
	@Override
	public Point getConnectedPoint(Point highPoint) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void shiftPoints(PositionVector positionVector) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void trainEnteredCrossing() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void trainExitedCrossing() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int getNumPaths() {
		// TODO Auto-generated method stub
		return 0;
	}

}
