import java.io.*;
import java.util.*;

public class Main
{
    public void println(String print_statement){
        System.out.println(print_statement);
    }
    
    public void print(String print_statement){
        System.out.print(print_statement);
    }
    
    public HashMap<String, Object> getData(){
        Scanner take_input = new Scanner(System.in);  // Create a Scanner object
        
        print("Enter Name: ");
        String name = take_input.next();
        
        print("Enter ID: ");
        String id = take_input.next();
        
        print("Enter Age: ");
        int age = take_input.nextInt();
        
        print("Enter Phone: ");
        String phone = take_input.next();
        
        HashMap<String, Object> map = new HashMap<>();
        
        map.put("name", name);
        map.put("id", id);
        map.put("age", age);
        map.put("phone", phone);
        
        return map;
    }
    
    public void selectInput(){
        println("Press 1 for Addition");
        println("Press 2 for Retrive By ID");
        println("Press 3 for Delete Record by ID");
    }
    
    public HashMap<String, Object> retriveStudent(String id, ArrayList<HashMap<String , Object>> myArrayMap){
        HashMap<String, Object> retriveData = new HashMap<>();
        for (HashMap<String, Object> item: myArrayMap) {
            if (id.equals(item.get("id"))){
                return item;
            }
        }
        println("No Record is Found!");
        return retriveData;
    }
    
    public ArrayList<HashMap<String , Object>> deleteStudent(String id, ArrayList<HashMap<String , Object>> myArrayMap){
        boolean itemFound = false;
        HashMap<String, Object> deleteData = new HashMap<>();
        for (HashMap<String, Object> item: myArrayMap) {
            if (id.equals(item.get("id"))){
                deleteData = item;
                itemFound = true;
                break;
            }
        }
        if (itemFound){
            myArrayMap.remove(deleteData);
            return myArrayMap;
        }
        else{
            print("No Record is Found!");
            return myArrayMap;
        }
    }

	public static void main(String[] args) {
		Main obj = new Main();  
		Scanner take_input = new Scanner(System.in);  // Create a Scanner object
		ArrayList<HashMap<String , Object>> myArrayMap = new ArrayList<HashMap<String, Object>>();
		String id;
        
		while (true){
		    obj.selectInput();
		    int input = take_input.nextInt();
		    switch (input) {
		        case 1:
		            HashMap<String, Object> data = obj.getData();
            		myArrayMap.add(data);
                    break;
		    
		        case 2:
		            obj.print("Enter ID to retrive: ");
		            id = take_input.next();
		            HashMap<String, Object> retriveData = obj.retriveStudent(id, myArrayMap);
		            obj.print("Retrived Data: ");
		            System.out.println(retriveData);
                    break;
                
                case 3:
		            obj.print("Enter ID to Delete: ");
		            id = take_input.next();
		            ArrayList<HashMap<String , Object>> afterDeletedRecord = obj.deleteStudent(id, myArrayMap);
                    break;
                    
		        default:
		            obj.print("Select Valid Input: ");
		            break;
		    }
		    if (input == 0){
		        break;
		    }
		    obj.print("Data Available in Database => ");
		    System.out.println(myArrayMap);
		    
		}
	}
}
