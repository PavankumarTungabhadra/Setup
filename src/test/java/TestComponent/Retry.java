package TestComponent;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		int Count=0;
		int maxCount=1;
		if (Count<maxCount) {
			return true;
		}
		return false;
	}

}
