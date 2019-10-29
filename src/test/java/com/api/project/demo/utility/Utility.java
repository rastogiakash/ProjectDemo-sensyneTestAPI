package com.api.project.demo.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.Assert;

import com.api.project.demo.base.SerenityBase;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;

import io.restassured.response.Response;

public class Utility extends SerenityBase {

    /**
     * @author akash rastogi
     * @description Method to alter the desired key values in the JSON and
     *              returning the JSON as string
     * @return alteredJson as string
     */

    public static synchronized String alterJson(String jsonName,
            Map<String, String> jsonValues) {
        String jsonString = null;

        try {
            URL file = Resources.getResource(
                    "configFiles/jsonFiles/RequestJson/" + jsonName + ".txt");
            jsonString = Resources.toString(file, Charsets.UTF_8);

            for (Map.Entry<String, String> keyVal : jsonValues.entrySet()) {
                jsonString = jsonString.replaceAll(keyVal.getKey(),
                        keyVal.getValue());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonString;
    }

    /**
     * 
     * @param response
     * @param jsonName
     */
    public static void validateJsonSchema(Response response, String jsonName) {
        try {
            InputStream inputStream = response.asInputStream();
            JSONObject reponseSchema = new JSONObject(
                    new JSONTokener(inputStream));
            JSONObject expectedJsonSchema = new JSONObject(
                    new JSONTokener(
                            Resources
                                    .getResource(
                                            "configFiles/jsonFiles/responseValidatorJson/"
                                                    + jsonName + ".txt")
                                    .openStream()));
            Schema schema = SchemaLoader.load(expectedJsonSchema);
            schema.validate(reponseSchema);
        } catch (Exception e) {
            Assert.assertFalse(
                    "Error while validating response json schema: " + e, true);

        }
    }

    /**
     * 
     * @return
     */
    public static String getRandomUsername() {
        String alphaNumeric = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder userName = new StringBuilder();
        userName.append("qa-glp-");
        Random rnd = new Random();
        while (userName.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * alphaNumeric.length());
            userName.append(alphaNumeric.charAt(index));
        }

        return userName.toString();
    }

    /**
     * 
     * @return
     */
    public static String getRandomNumber() {
        String numeric = "56789";
        StringBuilder randNumber = new StringBuilder();
        Random rnd = new Random();
        while (randNumber.length() < 1) { // length of the random string.
            int index = (int) (rnd.nextFloat() * numeric.length());
            randNumber.append(numeric.charAt(index));
        }

        return randNumber.toString();
    }

    /**
     * 
     * @return
     */
    public static String getRandomString() {
        String numeric = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder randString = new StringBuilder();
        Random rnd = new Random();
        while (randString.length() < 5) { // length of the random string.
            int index = (int) (rnd.nextFloat() * numeric.length());
            randString.append(numeric.charAt(index));
        }

        return randString.toString();
    }

    /**
     * 
     * @return
     */
    public static String getRandomAlphaNumericString() {
        String numeric = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder randAlphaNumericString = new StringBuilder();
        Random rnd = new Random();
        while (randAlphaNumericString.length() < 5) { // length of the random
                                                      // string.
            int index = (int) (rnd.nextFloat() * numeric.length());
            randAlphaNumericString.append(numeric.charAt(index));
        }

        return randAlphaNumericString.toString();
    }

    /**
     * 
     * @param jsonName
     * @return
     */
    public static String readJson(String jsonName) {
        try {
            URL file = Resources.getResource(
                    "configFiles/jsonFiles/RequestJson/" + jsonName + ".txt");
            String jsonString = Resources.toString(file, Charsets.UTF_8);
            return jsonString;
        } catch (Exception e) {

            System.out.println("Error while altering json : " + e);
            return null;
        }
    }

    /**
     * 
     * @param base_url
     * @param ApiEndpoint
     * @return
     */
    public static String createEndPoint(String base_url, String ApiEndpoint) {
        System.out.println(base_url + ApiEndpoint);
        return base_url + ApiEndpoint;
    }

    /**
     * 
     * @param jsonSchema
     * @return
     */
    public static String readResponseJsonSchema(String jsonSchema) {
        try {
            URL file = Resources
                    .getResource("configFiles/jsonFiles/ResponseJsonSchema/"
                            + jsonSchema + ".json");
            String jsonString = Resources.toString(file, Charsets.UTF_8);
            return jsonString;
        } catch (Exception e) {

            System.out.println("Error while altering json : " + e);
            return null;
        }
    }

    /**
     * 
     * @param map
     */
    public static void HashMapReset(Map<String, String> map) {
        map.clear();
    }

    /**
     * Set data to property file
     * 
     * @param key
     * @param data
     */

    public static void setDynamicProperty(String key, String data) {
        FileOutputStream fileOut = null;
        FileInputStream fileIn = null;
        try {
            Properties configProperty = new Properties();
            ClassLoader classloader = Thread.currentThread()
                    .getContextClassLoader();
            URL filePath = classloader.getResource(
                    "configFiles/propertiesFile/Dynamic.properties");
            File file = new File(filePath.getPath());
            fileIn = new FileInputStream(file);
            configProperty.load(fileIn);
            configProperty.setProperty(key, data);
            fileOut = new FileOutputStream(file);
            configProperty.store(fileOut, "Dynamic Properties");

        } catch (Exception ex) {

        } finally {

            try {
                fileOut.close();
            } catch (IOException ex) {

            }
        }
    }

    /**
     * Get data from property file
     * 
     * @param key
     * @param data
     */

    public static String getProperty(String PropertyName) {
        String value = null;
        try {

            ClassLoader classloader = Thread.currentThread()
                    .getContextClassLoader();
            URL filePath = classloader.getResource(
                    "configFiles/propertiesFile/Static.properties");
            File file = new File(filePath.getPath());
            FileInputStream fileInput = new FileInputStream(file);
            Properties properties = new Properties();
            properties.load(fileInput);
            fileInput.close();
            value = properties.getProperty(PropertyName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }

    /**
     * 
     * @param PropertyName
     * @return
     */

    public static String getDynamicProperty(String PropertyName) {
        String value = null;
        try {

            ClassLoader classloader = Thread.currentThread()
                    .getContextClassLoader();
            URL filePath = classloader.getResource(
                    "configFiles/propertiesFile/Dynamic.properties");
            File file = new File(filePath.getPath());
            FileInputStream fileInput = new FileInputStream(file);
            Properties properties = new Properties();
            properties.load(fileInput);
            fileInput.close();
            value = properties.getProperty(PropertyName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }

    /**
     * 
     * @param jsonName
     * @param keys
     * @return
     * @throws IOException
     */
    public static String removeKeyFromJson(String jsonName,
            ArrayList<String> keys) throws IOException {

        JSONObject testObject = null;
        try {
            URL file = Resources.getResource(
                    "configFiles/jsonFiles/RequestJson/" + jsonName + ".txt");
            String jsonString = Resources.toString(file, Charsets.UTF_8);
            testObject = new JSONObject(jsonString);
            for (int i = 0; i < keys.size(); i++) {
                if (keys.get(i).contains(":")) {
                    String[] field = keys.get(i).split(":");
                    testObject.getJSONObject(field[0]).remove(field[1]);
                    // System.out.println(testObject.toString()); // This prints
                    // out the json string
                } else {
                    testObject.remove(keys.get(i));
                    // System.out.println(testObject.toString()); // This prints
                    // out the json string
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return testObject.toString();
    }

    /**
     * 
     * @param map
     * @return
     */
    public static String convertMapToJsonString(Map<String, String> map) {
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonString = null;
        // convert map to JSON String
        try {
            jsonString = mapperObj.writeValueAsString(map);
            System.out.println(jsonString);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return jsonString;

    }

}
