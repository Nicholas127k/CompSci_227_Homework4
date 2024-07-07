package hw4;
import api.Crossable;
import api.Path;
import api.Point;
import api.PositionVector;
public class StraightLink extends AbstractLink implements Crossable {
	/*
	 * @Nicholas Kirschbaum
	*So last point hold the three given points 
	*This code allows a train to cross paths a to b, b to a, and c to a
	*/
	private Point lastpointa;
	private Point lastpointb;
	private Point lastpointc;
	public StraightLink(Point endpointA, Point endpointB, Point endpointC) {
		lastpointa = endpointA;
		lastpointb = endpointB;
		lastpointc = endpointC;
	}
	
	@Override
	public void shiftPoints(PositionVector positionVector) {
		// TODO Auto-generated method stub
		/*
		*analysis is the path that user is currently on 
		*with the code following placing the train on the correct space after crossing the intersection
		*/
		Path brandnewpath;
		Point alpha = positionVector.getPointA();
		Path analysis = alpha.getPath();
		
		if (analysis == lastpointa.getPath()) {
			
			brandnewpath = lastpointb.getPath();
			
			if(lastpointb.getPointIndex() > 1) {
				positionVector.setPointA(brandnewpath.getHighpoint());
				positionVector.setPointB(brandnewpath.getPointByIndex(brandnewpath.getHighpoint().getPointIndex() - 1));
			}
			else {
				positionVector.setPointA(lastpointb);
				positionVector.setPointB(brandnewpath.getPointByIndex(1));
			}
		}
		else if(analysis == lastpointb.getPath()) {
			brandnewpath = lastpointa.getPath();
			
			if(lastpointa.getPointIndex() > 1) {
				positionVector.setPointA(brandnewpath.getHighpoint());
				positionVector.setPointB(brandnewpath.getPointByIndex(brandnewpath.getHighpoint().getPointIndex() - 1));
			}
			else {
				positionVector.setPointA(lastpointa);
				positionVector.setPointB(brandnewpath.getPointByIndex(1));
			}
			
		}
		else if(analysis == lastpointc.getPath()) {
			brandnewpath = lastpointa.getPath();
			
			if(lastpointa.getPointIndex() > 1) {
				positionVector.setPointA(brandnewpath.getHighpoint());
				positionVector.setPointB(brandnewpath.getPointByIndex(brandnewpath.getHighpoint().getPointIndex() - 1));
			}
			else {
				positionVector.setPointA(lastpointa);
				positionVector.setPointB(brandnewpath.getPointByIndex(1));
			}
		}
		//positionVector.getPointB() == lastpointc
		//brandnewpath = lastpoint2.getPath();
		//int twoindex = lastpoint2.getPointIndex();
		//positionVector.setPointA(lastpoint2);
		//positionVector.setPointB(brandnewpath.getPointByIndex(twoindex + 1));
		//if(lastpointa.getPointIndex() > 1) {
			//set one if the value is high
			//positionVector.setPointA(brandnewpath.getHighpoint());
			//positionVector.setPointB(brandnewpath.getPointByIndex(brandnewpath.getNumPoints() - 1));
		//}
	}
	@Override
	public Point getConnectedPoint(Point point) {
		// TODO Auto-generated method stub
		if (point == lastpointa) {
			return lastpointb;
		}
		else if(point == lastpointb) {
			return lastpointa;
		}
		else if(point == lastpointc) {
			return lastpointa;
		}
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
		return 3;
	}

}
