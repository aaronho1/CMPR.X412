import java.util.ArrayList;

/**
 * 
 */

/**
 * @author AaronHo
 *
 */
public interface IGrader {
	public void readScore();

	public void calcLetterGrade();

	public void calcAverages(ArrayList<Integer> testScores);

	public void printGrade();

	public void displayAverages();

	public void doCleanup();
}
