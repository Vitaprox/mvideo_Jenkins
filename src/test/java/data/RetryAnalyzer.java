package data;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    int retryAttemptsCounter = 0;

    int maxRetryLimit = 1;

    public boolean retry(ITestResult result){
        if(!result.isSuccess()){
            if(retryAttemptsCounter < maxRetryLimit){
                retryAttemptsCounter++;
                return true;
            }
        }
        return false;
    }
}
