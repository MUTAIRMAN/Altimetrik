package Objects;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class UtilityFunction {

	public void TakesScreenshotdriver(String scnShotname, WebDriver driver) throws IOException {
		TakesScreenshot sh = (TakesScreenshot) driver;
		File SrcFile = sh.getScreenshotAs(OutputType.FILE);
		File destFile = new File(System.getProperty("user.dir") + "/" + scnShotname + ".jpeg");
		FileHandler.copy(SrcFile, destFile);
	}

	public List<Object> ReadJson(String filePath) throws IOException, ParseException {
		List<Object> str = new ArrayList<Object>();

		JSONParser parser = new JSONParser();

		try (Reader reader = new FileReader(filePath)) {

			JSONObject jsonObject = (JSONObject) parser.parse(reader);
			System.out.println(jsonObject);

			String name = (String) jsonObject.get("name");
			str.add(name);
			long age = (Long) jsonObject.get("age");
			str.add(age);

			return str;
		}

	}
}
