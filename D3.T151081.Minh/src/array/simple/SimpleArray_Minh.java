/**
 * 
 */
package array.simple;

import java.util.Scanner;
import java.util.function.IntPredicate;

import javax.naming.PartialResultException;
import javax.swing.text.html.parser.Parser;

/**
 * @author US
 *
 */
public class SimpleArray_Minh {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sLine72="";
		String sLine53="";
	
		  int count72=0;
		  int count53=0;
		int n = 0;
		Scanner scan = new Scanner(System.in);
		System.out.print("Nhap vao 1 so: ");
		n = scan.nextInt();
		  int[] number72 = new int[n];
		  int[] number53 = new int[n];
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			System.out.print("Nhap vao n so: ");
			arr[i] = scan.nextInt();
		}
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 7 == 0 || arr[i] % 2 == 0) {
				number72[i]=arr[i];
			       count72++;
			       sLine72=sLine72 + number72[i]+" ";
			}
			if (arr[i] %5==0 && arr[i]%3!=0) {
			       number53[i]=arr[i];
			       count53++;
			       sLine53=sLine53 +  number53[i]+ " ";
			}
		}
		  System.out.println("Number chia het cho 7 || 2: " +sLine72);
		  System.out.println("Chia het cho 5 nhung khong chia het cho 3: " + sLine53);
		scan.close();
	}

}
