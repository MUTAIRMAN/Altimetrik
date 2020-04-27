package Test.com.muthuAltimetrik;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.json.Json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * Hello world!
 *
 */
public class App {

	public static JSONObject add(String key, String val) {
		JSONObject jt = new JSONObject();
		jt.put(key, val);
		return jt;
	}

	public static void main(String[] args) throws IOException {
		List<JSONObject> li = new ArrayList<JSONObject>();
		JSONArray js = new JSONArray();

		String st;
		int i = 0, j = 0;
		FileReader f = new FileReader("C:\\Users\\Muthukumar\\Desktop\\SampleFiles\\muthu2.txt");
		BufferedReader fi = new BufferedReader(f);
		while ((st = fi.readLine()) != null) {
			if (st.contains("name"))
				li.add(App.add("name", st.substring(5)));
			else
				li.add(App.add("no", st.substring(3)));

		}
		js.add(li);
		System.out.println(js);

		fi.close();
		f.close();
// System.out.println(str);

	}
}
