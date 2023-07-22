package utilities;

import org.testng.annotations.DataProvider;
import java.io.IOException;

public class DataProviders {
	
	//Data provider method 1
	
	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException
	{
		String path = ".\\testData\\Opencart_DataFile.xls";
		ExcelUtility xlutil= new ExcelUtility(path);
		
		int totalrows = xlutil.getRowCount("Sheet1");
		int totalcols = xlutil.getCellCount("Sheet1",1);
		
		String logindata[][] = new String[totalrows][totalcols];
		
		for(int i=1;i<=totalrows;i++)
		{
			for(int j=0; j<=totalcols;j++)
			{
				logindata[i-1][j] = xlutil.getCellData("Sheet1",i,j);
			}
		}
		return logindata;
	}
	
	//DataProvider method 2
	
	//DataProvider method 3

}
