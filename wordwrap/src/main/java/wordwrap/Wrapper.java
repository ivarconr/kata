package wordwrap;

public class Wrapper {

	private static final String SPACE = " ";
	private static final String NEW_LINE = "\n";

	public static String wrap(String text, int columnWidth) {
		text = text.trim();
		if (text.length() <= columnWidth) {
			return text;
		}
		String line = text.substring(0, columnWidth);
		int pivotPoint = line.lastIndexOf(SPACE);
		if (pivotPoint == -1) {
			pivotPoint = columnWidth;
		}
		String thisLine = line.substring(0, pivotPoint);
		String remainingText = text.substring(pivotPoint);
		return thisLine + NEW_LINE + wrap(remainingText, columnWidth);
	}
}
