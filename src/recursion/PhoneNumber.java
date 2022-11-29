package recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PhoneNumber {

    public static ArrayList<String> phoneNumberMnemonics(String phoneNumber) {
        // Write your code here.
        ArrayList<String> answer = new ArrayList<String>();
        answer.add("");
        Map<String, String> map = new HashMap<String, String>();
        map.put("2","abc");
        map.put("3","def");
        map.put("4","ghi");
        map.put("5","jkl");
        map.put("6","mno");
        map.put("7","pqrs");
        map.put("8","tuv");
        map.put("9","wxyz");
        String[] numbers= phoneNumber.split("");
        String tempword="";
        for(String s:numbers){

            if(s.equals("1") || s.equals("0")){
                // just append to the word
                ArrayList<String> lst = new ArrayList<>();
                for(String str: answer){
                    String temp = str + s;
                    lst.add(temp);

                }
                answer=lst;
            }else{
                String charcs = map.get(s);
                //append each character from charcs to existing word
                String [] eles = charcs.split("");
                ArrayList<String> lst = new ArrayList<>();
                for(String str: answer){
                    for(String st: eles){
                        String temp = str + st;
                        lst.add(temp);
                    }
                }
                answer=lst;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String phoneNumber ="1905";
        System.out.println(phoneNumberMnemonics(phoneNumber));
    }
}
