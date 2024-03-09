import java.util.*;
public class lewss{
    public static void add(String name,Integer num, HashMap<String,ArrayList<Integer>> phoneBook ){
        try{
            boolean isExist = phoneBook.get(name).isEmpty();
            

            ArrayList<Integer> someTime = phoneBook.get(name);
            someTime.add(num);
            phoneBook.put(name, someTime);
        }catch(Exception e){
            ArrayList<Integer> nums = new ArrayList<>();
            nums.add(num);
            phoneBook.put(name, nums);

        }
        
    }
    public static void deleteNum(String name, Integer num, HashMap<String,ArrayList<Integer>> phoneBook){
        try{
            ArrayList<Integer> nums = phoneBook.get(name);
            int indexOfNum = nums.indexOf(num);
            nums.remove(indexOfNum);
            phoneBook.put(name,nums);
        }
        catch(Exception e){
            System.out.println("Такого контакта не существует");
        }
    }
    public static void delete(String name, HashMap<String,ArrayList<Integer>> phoneBook){
        try{phoneBook.remove(name);}
        catch(Exception e){
            System.out.println("Такого контакта не существует");
        }
    }
    public static HashMap<Integer,String> sort(HashMap<String,ArrayList<Integer>> phoneBook){
        HashMap<Integer,String> phoneSort = new HashMap<>();
        HashMap<String,ArrayList<Integer>> phoneClone = new HashMap<>();
        for(String nam: phoneBook.keySet()){
            phoneClone.put(nam, phoneBook.get(nam));
        }
        for(int i = 0; i < phoneBook.size();i++){
            String maxName = null;
            int maxNumber = 0;
            for(String nam: phoneClone.keySet()){
                if(phoneClone.get(nam).size() > maxNumber){
                    maxName = nam;
                }
            }
            phoneSort.put(i, maxName);
            phoneClone.remove(maxName);
        }
        return phoneSort;
        
    }
    public static void print(HashMap<String,ArrayList<Integer>> phoneBook){
        HashMap<Integer,String> phoneSorted = sort(phoneBook);
        for(int i = 0; i < phoneBook.size(); i++){
            if(phoneBook.get(phoneSorted.get(i)).size() == 1){
            System.out.println(String.format("Контакт: %s, Номер:   %d", phoneSorted.get(i),phoneBook.get(phoneSorted.get(i)).get(0)));
        }
        else{
            System.out.println(String.format("Контакт: %s, Номера: %d ", phoneSorted.get(i),phoneBook.get(phoneSorted.get(i)).get(0)));
            for(int j = 1; j < phoneBook.get(phoneSorted.get(i)).size();j++){
                System.out.println(String.format("                      %d;", phoneBook.get(phoneSorted.get(i)).get(j)));
            }
            
        }
        }
    }
    public static void main(String[] args) {
        HashMap<String,ArrayList<Integer>> pb = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        boolean programmIsWork = true;

        while (programmIsWork) {

        System.out.println("Выберите комманду, которую хотите выполнить:");
        System.out.println("1 - добавить контакт");
        System.out.println("2 - удалить номер из контакта"); 
        System.out.println("3 - удалить сам контакт"); 
        System.out.println("4 - покозать список контактов");
        System.out.println("0 - завершить работу программы");   
        
        String numOfAction = scanner.nextLine();
        switch (numOfAction) {
            case "1":
                System.out.println("");
                System.out.println("Введите имя контакта: ");
                String name = scanner.nextLine();
                System.out.println("Введите  номер контакта: ");
                Integer num = scanner.nextInt();
                add(name,num,pb);
                System.out.println("");
                break;
            case"2":
            System.out.println("");
            System.out.println("Введите имя контакта, номер которого стоит удалить: ");
            String name1 = scanner.nextLine();
            System.out.println("Введите номер, который стоит удалить: ");
            Integer num1 = scanner.nextInt();
            deleteNum(name1, num1, pb);
            System.out.println("");
                break;
            case"3":
            System.out.println("");
            System.out.println("Введите имя контакта, который стоит удалить: ");
            String name2 = scanner.nextLine();
                
            delete(name2, pb);
            System.out.println("");
                    break;
            case"4":
            
            print(pb);
            System.out.println("");
                break;
            case"0":
            programmIsWork = false;
                break;
            default:
            System.out.println("");
            System.out.println("Вы ввели неизвестную комманду. Попробуйте снова");
            System.out.println("");
                break;
        }
    }
    }
}