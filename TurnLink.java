package hw4;
import api.Crossable;
import api.Path;
import api.Point;
import api.PositionVector;
public class TurnLink extends AbstractLink implements Crossable {
	/*
	 * Allows train to go from path a-c and b/c to a
	*/
	private Point lastpointa;
	private Point lastpointb;
	private Point lastpointc;
	public TurnLink(Point endpointA, Point endpointB, Point endpointC) {
		lastpointa = endpointA;
		lastpointb = endpointB;
		lastpointc = endpointC;
		
	}
	@Override
	public Point getConnectedPoint(Point point) {
		// TODO Auto-generated method stub
		if (point == lastpointa) {
			return lastpointc;
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
	public void shiftPoints(PositionVector positionVector) {
		// TODO Auto-generated method stub
		Path brandnewpath;
		Point alpha = positionVector.getPointA();
		Path analysis = alpha.getPath();
		
		if (analysis == lastpointa.getPath()) {
			
			brandnewpath = lastpointc.getPath();
			
			
			if(lastpointb.getPointIndex() > 1) {
				positionVector.setPointA(brandnewpath.getHighpoint());
				positionVector.setPointB(brandnewpath.getPointByIndex(brandnewpath.getHighpoint().getPointIndex() - 1));
			}
			else {
				positionVector.setPointA(lastpointc);
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
