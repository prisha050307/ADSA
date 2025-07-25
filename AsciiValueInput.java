import java.util.Scanner;

public class AsciiValueInput
 {
  public static void main(String[] args)
{
           Scanner scanner = new Scanner(System.in);
           System.out.print("enter a character: ");
           char ch =scanner.next().charAt(0);
           int ascii = (int) ch;
           System.out.print("the ASC II value of ' " +ch+ "' is: " + ascii);
  }
}