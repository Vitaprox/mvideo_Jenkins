package listeners;

import io.qameta.allure.Attachment;
import io.qameta.allure.testng.AllureTestNg;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IInvokedMethod;
import org.testng.ITestResult;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class AllureListener extends AllureTestNg {

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }


    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (testResult.getStatus() != ITestResult.SUCCESS) {
            takeScreenshot();
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        result.getMethod().getMethodName();
        if (hasGroupBug(result)) {
            addBugToTestName(result);
        }
    }

    private void addBugToTestName(ITestResult result) {
        try {
            Files.walk(Path.of("C:/Users/dspakhomov/IdeaProjects/Mvideo-autotests/target/allure-results"))
                    .filter(el -> el.toString().endsWith("-result.json"))
                    .forEach(el -> {
                        ;
                        JSONObject jsonObject = getJsonObject(el);
                        String name = jsonObject.get("name").toString();
                        if (result.getMethod().getMethodName().equals(name)) {
                            addBugToTestName(name, jsonObject, el);
                        }

                    });
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private void addBugToTestName(String name, JSONObject jsonObject, Path path) {
        jsonObject.put("name", ">>BUG<< " + name);
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(path.toFile());
            writer.print(jsonObject.toJSONString());
            writer.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private JSONObject getJsonObject(Path path) {
        FileReader reader = null;
        try {
            reader = new FileReader(path.toFile());
            JSONParser jsonParser = new JSONParser();
            return (JSONObject) jsonParser.parse(reader);
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }

    }

    private boolean hasGroupBug(ITestResult result) {
        AtomicBoolean flag = new AtomicBoolean(false);
        List<String> groups = List.of(result.getMethod().getGroups());
        if (groups.size() != 0) {
            groups.stream().forEach(group -> {
                if (group.equals("bug"))
                    flag.set(true);
            });
        }
        return flag.get();
    }


}
