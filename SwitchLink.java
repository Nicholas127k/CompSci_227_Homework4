package hw4;
import api.Crossable;
import api.Path;
import api.Point;
import api.PositionVector;
public class SwitchLink extends AbstractLink implements Crossable{
	/*
	 * Allows train to go any of the three paths
	*/
	private Point lastpointa;
	private Point lastpointb;
	private Point lastpointc;
	private boolean leftorright = false; 
	private boolean crossing = false;
	public SwitchLink(Point endpointA,Point endpointB,Point endpointC) {
		/*
		 * @Nicholas Kirschbaum
		*So last point hold the three given points 
		*/
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
		
		if ((analysis == lastpointa.getPath()) && (leftorright == true)) {
			
			brandnewpath = lastpointc.getPath();
			
			positionVector.setPointA(lastpointc);
			positionVector.setPointB(brandnewpath.getPointByIndex(1));
		}
		else if((analysis == lastpointa.getPath()) && (leftorright == false)) {
			brandnewpath = lastpointb.getPath();
			
			if(lastpointb.getPointIndex() > 1) {
				positionVector.setPointA(brandnewpath.getHighpoint());
				positionVector.setPointB(brandnewpath.getPointByIndex(brandnewpath.getHighpoint().getPointIndex() - 1));
			}
			else {
				positionVector.setPointA(brandnewpath.getPointByIndex(0));
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
				positionVector.setPointA(brandnewpath.getPointByIndex(0));
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
				positionVector.setPointA(brandnewpath.getPointByIndex(0));
				positionVector.setPointB(brandnewpath.getPointByIndex(1));
			}
			
		}
		
	}
	@Override
	public Point getConnectedPoint(Point point) {
		// TODO Auto-generated method stub
		if (point == lastpointa && (leftorright == true)) {
			return lastpointc;
		}
		else if (point == lastpointa && (leftorright == false)) {
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
		crossing = true;
	}
	@Override
	public void trainExitedCrossing() {
		// TODO Auto-generated method stub
		crossing = false;
	}
	@Override
	public int getNumPaths() {
		// TODO Auto-generated method stub
		return 3;
	}
	public void setTurn(boolean b) {
		// TODO Auto-generated method stub
		if(crossing == false) {
			leftorright = b;
		}
	}
	
	
	

}
