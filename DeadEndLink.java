package hw4;

import api.Crossable;
import api.Point;
import api.PositionVector;

/*
 * This code does nothing but stay the same spot :)
*/
public class DeadEndLink extends AbstractLink implements Crossable{
	
	public DeadEndLink() {
		
	}

	@Override
	public void shiftPoints(PositionVector positionVector) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Point getConnectedPoint(Point point) {
		// TODO Auto-generated method stub
		return null;
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
		return 1;
	}

}
