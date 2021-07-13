package figure;

public interface LineListener {

	public void linePressed(double x, double y, double[] xData, double[] yData);

	public void lineReleased(double x, double y, double[] xData, double[] yData);

	public void lineDragged(double x, double y, double[] xData, double[] yData);

}