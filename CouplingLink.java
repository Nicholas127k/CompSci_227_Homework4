package hw4;
	import api.Crossable;
import api.Path;
import api.Point;
import api.PositionVector;


public class CouplingLink extends AbstractLink implements Crossable {
	/*
	 * @Nicholas Kirschbaum
	*So last point hold the two given points and jointtally is set at two because thats how
	*many paths make up a coupling link
	*/
	 private Point lastpoint1;
	 private Point lastpoint2;
	 private int jointtally = 2;
	public CouplingLink(Point endpoint1, Point endpoint2) {
		lastpoint1 = endpoint1;
		lastpoint2 = endpoint2;
	}
	@Override
	public void shiftPoints(PositionVector positionVector) {
		// TODO Auto-generated method stub
		/*
		 * brandnewpath is the path the train is about to be transfered to
		*/
		Path brandnewpath;
		
		
		brandnewpath = lastpoint2.getPath();
		/*
		 * This if else statement sets the new location of the train
		*/
		if(lastpoint2.getPointIndex() > 1) {
			//set one if the value is high
			positionVector.setPointA(brandnewpath.getHighpoint());
			positionVector.setPointB(brandnewpath.getPointByIndex(brandnewpath.getHighpoint().getPointIndex() - 1));
		}
		else {
			//set one if the value is low
			positionVector.setPointA(lastpoint2);
			positionVector.setPointB(brandnewpath.getPointByIndex(1));
		}
		//positionVector.setPointA(lastpoint2);
		//positionVector.setPointB(brandnewpath.getPointByIndex(1));
		
		
	}
	@Override
	public Point getConnectedPoint(Point point) {
		// TODO Auto-generated method stub
		
		if (point == lastpoint1) {
			
			
			return lastpoint2;
		
		}
		else if(point == lastpoint2) {
			
			return lastpoint1;
			
		}
		else{
			return null;
		}
		
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
		return jointtally;
	}

}
