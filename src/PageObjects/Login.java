package PageObjects;

import org.openqa.selenium.WebDriver;
import Utilities.*;
public class Login {
	public static void Execute(WebDriver driver) throws Exception{
		 
		//This is to get the values from Excel sheet, passing parameters (Row num &amp; Col num)to getCellData method

		String sUserName = ExcelUtilities.getCellData(1, 1);

		String sPassword = ExcelUtilities.getCellData(1, 2);

	    System.out.println(sUserName);
	    System.out.println(sPassword);
    }
}
