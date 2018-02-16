
package com.mycompany.app;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

public class App {
    public static List < String > chooseAndMerge(Integer[] index1, List < Integer > index2, String[] set1, List < String > set2) {
    	if(index1 == null || index2 == null || set1 == null || set2 == null) {
    		System.out.println("Null parameters.");
    		return null;
    	}
    	List < String > result = new ArrayList < String >();
        for(Integer x : index1) {
        	if(x >= 0 && x < set1.length)
        		result.add(set1[x]);
        }
        for(Integer x : index2) {
        	if(x >= 0 && x < set2.size())
        		result.add(set2.get(x));
        }
        Collections.sort(result);
        return result;
    }


	public static void main(String[] args) {
        port(getHerokuAssignedPort());

        get("/", (req, res) -> "Hello, World");

        post("/compute", (req, res) -> {

			
			//in1
			String input1 = req.queryParams("input1");
			Scanner sc1 = new Scanner(input1);
			sc1.useDelimiter("[;\r\n]+");
			ArrayList<Integer> inputList1 = new ArrayList<>();
			while (sc1.hasNext()) {
				int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
				inputList1.add(value);
			}
			System.out.println(inputList1);

			//in2
			String input2 = req.queryParams("input2");
			Scanner sc2 = new Scanner(input2);
			sc2.useDelimiter("[;\r\n]+");
			ArrayList<Integer> inputList2 = new ArrayList<>();
			while (sc2.hasNext()) {
				int value = Integer.parseInt(sc2.next().replaceAll("\\s",""));
				inputList2.add(value);
			}
			System.out.println(inputList2);

			//in3
			String input3 = req.queryParams("input3");
			Scanner sc3 = new Scanner(input3);
			sc3.useDelimiter("[;\r\n]+");
			ArrayList<String> inputList3 = new ArrayList<>();
			while (sc3.hasNext()) {
				String value = sc3.next().replaceAll("\\s","");
				inputList3.add(value);
			}
			System.out.println(inputList3);

			//in4
			String input4 = req.queryParams("input4");
			Scanner sc4 = new Scanner(input3);
			sc4.useDelimiter("[;\r\n]+");
			ArrayList<String> inputList4 = new ArrayList<>();
			while (sc4.hasNext()) {
				String value = sc4.next().replaceAll("\\s","");
				inputList4.add(value);
			}
			System.out.println(inputList4);

			Integer[] in1 = inputList1.toArray(new Integer[inputList1.size()]);
			ArrayList<Integer> in2 = inputList2;
			String[] in3 = inputList3.toArray(new String[inputList3.size()]);
			ArrayList<String> in4 = inputList4;

			List<String> result = App.chooseAndMerge(in1, in2, in3, in4);

			Map map = new HashMap();
			map.put("result", result);
			return new ModelAndView(map, "compute.mustache");
			},

		new MustacheTemplateEngine());


        get("/compute",
            (rq, rs) -> {
              Map map = new HashMap();
              map.put("result", "not computed yet!");
              return new ModelAndView(map, "compute.mustache");
            },
            new MustacheTemplateEngine());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}