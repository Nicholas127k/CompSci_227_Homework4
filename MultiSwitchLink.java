package hw4;
import api.Crossable;
import api.Path;
import api.Point;
import api.PointPair;
import api.PositionVector;
/*
 * This code is similar to multifixed link but allows the user to choose where the train is going as long 
 * as it is not allready crossing
*/
public class MultiSwitchLink extends AbstractLink implements Crossable{
	private PointPair[] connect;
	private boolean entered = false;
	public MultiSwitchLink(PointPair[] connections) {
		connect = connections;
	}
	
	public void switchConnection(PointPair pointPair,int index) {
		if(entered = false) {
			connect[index] = pointPair;
		}
	}

	@Override
	public void shiftPoints(PositionVector positionVector) {
		// TODO Auto-generated method stub
		Path brandnewpath = null;
		Point point = positionVector.getPointA();
		Point point2 = positionVector.getPointB();
		int stuff = 0;
		
		
		
		
		for(int i = 0; i < connect.length; i++) {
			if(connect[i].getPointA() == point || connect[i].getPointA() == point2) {
				brandnewpath = connect[i].getPointB().getPath();
				stuff = connect[i].getPointB().getPointIndex();
			}
			else if(connect[i].getPointB() == point || connect[i].getPointB() == point2) {
				brandnewpath = connect[i].getPointA().getPath();
				stuff = connect[i].getPointA().getPointIndex();
			}
		}
		if(stuff > 1) {
			positionVector.setPointA(brandnewpath.getHighpoint());
			positionVector.setPointB(brandnewpath.getPointByIndex(brandnewpath.getHighpoint().getPointIndex() - 1));
		}
		else {
			positionVector.setPointA(brandnewpath.getPointByIndex(0));
			positionVector.setPointB(brandnewpath.getPointByIndex(1));
		}
	}

	@Override
	public Point getConnectedPoint(Point point) {
		// TODO Auto-generated method stub
		Point fin = null;
		for(int i = 0; i < connect.length; i++) {
			if(connect[i].getPointA() == point) {
				fin = connect[i].getPointB();
			}
			else if(connect[i].getPointB() == point) {
				fin = connect[i].getPointA();
			}
		}
		return fin;
	}

	@Override
	public void trainEnteredCrossing() {
		// TODO Auto-generated method stub
		 entered = true;
	}

	@Override
	public void trainExitedCrossing() {
		// TODO Auto-generated method stub
		entered = false;
	}

	@Override
	public int getNumPaths() {
		// TODO Auto-generated method stub
		
		return connect.length;
	}

}
