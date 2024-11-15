package FrameWork1.Setup;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class TestNgAnnotations 
{
	@Test
	public void DependsMethod() {
		System.out.println("Depends method");
	}

	@Test(dependsOnMethods = {"DependsMethod"})
	public void DependentMethod()
	{
		System.out.println("am dependent");
	}
	
	@Test(groups = "Smoke")
	public void SmokeTest() {
		System.out.println("Smoke Testing");
	} 
	@Test(enabled = true)
	public void EnabledMethod()
	{
		System.out.println("am enabled");
	}
	@Test(timeOut = 4000)
	public void TimeOut() {
		System.out.println("time Out");
	}
	@Parameters({"URL"})
	@Test
	public void Parameterization(String URL)
	{
		System.out.println(URL);
	}
	@DataProvider
	public Object[][] DataPRovider()
	{
		return new Object[][] {{"Anushka","ArabianHorse","SexyFigure"}};
	}
	@Test(dataProvider ="DataPRovider")
	public void GetData(String Name,String Adjective, String Figure)
	{
		System.out.print(Name+" "+Adjective+" "+Figure);
	}
}
