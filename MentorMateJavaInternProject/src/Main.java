import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class Main {
	
	public static JSONObject jsonDefinition;
	public static JSONArray jsonEmployees;
	
	public static void main(String args[]){
		
	  JSONParser jsonParser = new JSONParser();
		
	  try{
	    // read from definition file  
	    FileReader readerDefinition = new FileReader(args[1]);
            jsonDefinition = (JSONObject) jsonParser.parse(readerDefinition);
            
	    int topPerformersThreshold = Integer.parseInt(jsonDefinition.get("topPerformersThreshold").toString());
            boolean useExperienceMultiplier = Boolean.parseBoolean(jsonDefinition.get("useExperienceMultiplier").toString());
            int periodLimit = Integer.parseInt(jsonDefinition.get("periodLimit").toString());
            Definition definition = new Definition(topPerformersThreshold, useExperienceMultiplier, periodLimit);
            
            // read from data file  
            FileReader readerEmpoyees = new FileReader(args[0]);
            jsonEmployees = (JSONArray) jsonParser.parse(readerEmpoyees);
            
            Employee[] employees = new Employee[jsonEmployees.size()];
            
            for(int i = 0; i < employees.length; i++){
            	JSONObject jsonObject = (JSONObject) jsonEmployees.get(i);
            	
            	    String name = jsonObject.get("name").toString();
	                int totalSales = Integer.parseInt(jsonObject.get("totalSales").toString());
	                int salesPeriod = Integer.parseInt(jsonObject.get("salesPeriod").toString());
	                double experienceMultiplier = Double.parseDouble(jsonObject.get("experienceMultiplier").toString());
            	
	            Employee currentEmployee = employees[i];
            	currentEmployee = new Employee(name, totalSales, salesPeriod, experienceMultiplier);
            	currentEmployee.calculateScore(definition);
            	employees[i] = currentEmployee;
            	
            }
            
            // filter employees that have score that is within the top X percent of the results
            
            ArrayList<Employee> topEmployees = new ArrayList<>();
            Arrays.sort(employees, Comparator.comparing(Employee::getScore).reversed());
            int numberOfemployees = employees.length;
            int numberOfTopEmployees = (int)((topPerformersThreshold / 100.0) * numberOfemployees);
            
            // if the data file contains a low number of employees , set number of top employees to 1 
            if(numberOfTopEmployees == 0){
            	numberOfTopEmployees = 1;
            }
            
            for(int i = 0; i< numberOfTopEmployees; i++){
            	Employee emp = employees[i];
            	topEmployees.add(emp);
            }
            
            // generate result.csv
            
            File newCsv = new File("result.csv");
            if(newCsv.createNewFile()){
                System.out.println("result.csv File Created in Project root directory");
                
            }else System.out.println("File result.csv already exists in the project root directory");
            
            
            FileWriter csvWriter = new FileWriter(newCsv);  
            csvWriter.append("Name, Score\r\n");
            for(int i = 0; i < topEmployees.size(); i++){
            	// filter topEpmployees that have sales period that is equal or less than the periodLimit property
            	if( topEmployees.get(i).getSalesPeriod() <= periodLimit ){
            	csvWriter.append(topEmployees.get(i).getName() + " , ");
                csvWriter.append(Double.toString(topEmployees.get(i).getScore()) + "\r\n");
            	}

            }     
                
            csvWriter.flush();  
            csvWriter.close();
                          
           
		}catch(ParseException e ){
			 System.out.println(e);
		}catch (Exception e) {
            System.out.println(e);
        }
		
	
		}
		
	

}
