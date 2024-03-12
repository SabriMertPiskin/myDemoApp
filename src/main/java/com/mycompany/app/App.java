package com.mycompany.app;
import java.util.ArrayList;
import java.util.Arrays;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;
import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

/**
 * Hello world!
 *
 */
public class App 
{
    
    public static String meaningfulOperation(ArrayList<Integer> array, Integer[] arrInt, int i, String[] strArr) {
        if (strArr.length < 1) return "";

        StringBuilder resultBuilder = new StringBuilder();

        // Processing array list of integers
        if (array != null) {
            for (int index : array) {
                if (index >= 0 && index < strArr.length) {
                    resultBuilder.append(strArr[index]);
                }
            }
        }

        // Processing array of integers
        if (arrInt != null) {
            for (int index : arrInt) {
                if (index >= 0 && index < strArr.length) {
                    resultBuilder.append(strArr[index]);
                }
            }
        }

        // Processing integer parameter
        if (i >= 0 && i < strArr.length) {
            resultBuilder.append(strArr[i]);
        }

        return resultBuilder.toString();
    }
      public static void main(String[] args) {
        port(getHerokuAssignedPort());

        get("/", (req, res) -> "Hello, World");

        post("/compute", (req, res) -> {
          System.out.println("input1: "+req.queryParams("input1"));
          System.out.println("input2: "+req.queryParams("input2"));
          System.out.println("input3: "+req.queryParams("input3"));
          System.out.println("input4: "+req.queryParams("input4"));

          String i1 = req.queryParams("input1");
          String i2 = req.queryParams("input2");
          String i3 = req.queryParams("input3");
          String i4 = req.queryParams("input4");
          System.out.println("stringler"+i1 + "\n"+i2 + "\n"+i3 + "\n"+i4 + "\n");  
          java.util.Scanner sc1 = new java.util.Scanner(i1);
          java.util.Scanner sc2 = new java.util.Scanner(i2);
          java.util.Scanner sc3 = new java.util.Scanner(i3);
          java.util.Scanner sc4 = new java.util.Scanner(i4);
          sc1.useDelimiter("[;\r\n]+");
          sc2.useDelimiter("[;\r\n]+");
          sc3.useDelimiter("[;\r\n]+");
          sc4.useDelimiter("[;\r\n]+");
          java.util.ArrayList<Integer> inputList = new java.util.ArrayList<>();
          while (sc1.hasNextInt())
          {
            int value = sc1.nextInt();
            inputList.add(value);
          }
          java.util.ArrayList<Integer> inputList2 = new java.util.ArrayList<>(); 
          while (sc2.hasNextInt())
          {
            int value = sc2.nextInt();
            inputList2.add(value);
          }
          Integer[] intArr = new Integer[inputList2.size()];
          intArr = inputList2.toArray(intArr);

          int inputInteger = sc3.nextInt();
          java.util.ArrayList<String> strArrList = new java.util.ArrayList<>();
          
          while (sc4.hasNext())
          {
            String value = sc4.next().replaceAll("\\s","");
            strArrList.add(value);
          }
          String[] strArr = new String[strArrList.size()];
          strArr = strArrList.toArray(strArr);
          String result = App.meaningfulOperation(inputList,intArr,inputInteger,strArr);
          Map map = new HashMap();
          map.put("result", result);
          return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


        get("/compute",
            (rq, rs) -> {
              Map map = new HashMap();
              map.put("result", "henüz hesaplanmadı");
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

