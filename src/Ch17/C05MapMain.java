package Ch17;

import java.util.HashMap;
import java.util.Map;

class AuthController{
	//ID/PW 저장
	private static Map<String,Integer> map = new HashMap();
	
	//CRUD
	public static boolean Insert(String id, Integer pw) {
		if(map.containsKey(id)) {
			System.out.println("[ERROR]동일 ID가 존재합니다.");
			return false;
		}
		map.put(id,pw);
		return true;
	}
	public static Integer Select(String id) {
		return map.get(id);
	}
	public static  Map<String,Integer> SelectAll() {
		for(String key : map.keySet())
			System.out.println("KEY : " + key + " VAL : " + map.get(key));
		return map;
	}
	public static boolean Update(String id, Integer pw) {
		map.replace(id, pw);
		return true;
	}
	public static boolean Delete(String id) {
		map.remove(id);
		return true;
	}
	
}


public class C05MapMain {

	public static void main(String[] args) {
		//INSERT
		AuthController.Insert("aaa", 111);
		AuthController.Insert("bbb", 222);
		AuthController.Insert("bbb", 555);
		AuthController.Insert("ccc", 333);
		AuthController.Insert("ddd", 444);
		
		//SELECT
		AuthController.Select("ccc");
		
		//SELECTALL
		AuthController.SelectAll();
	}
}
