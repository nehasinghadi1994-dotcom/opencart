package utilities;

import java.io.IOException;
import org.testng.annotations.DataProvider;

public class DataProviders {

@DataProvider(name="loginData")
public String [][] getData() throws IOException {

String path="C:\\Users\\hp\\eclipse-workspace\\Java_Project_With_Selenium\\Opencart28\\testData\\loginData.xlsx";

excelUtility xlutil=new excelUtility(path);

int totalRows=xlutil.getRowCount(path,"Sheet1");
int totalCells=xlutil.getCellCount(path,"Sheet1",1);

String loginData[][]=new String[totalRows][totalCells];

for(int r=1; r<=totalRows;r++)
{
for(int c=0;c<totalCells;c++)
{
loginData[r-1][c]=xlutil.getCellData(path,"Sheet1",r,c);
}
}

return loginData;

}
}