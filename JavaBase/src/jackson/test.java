package jackson;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Objects;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.xml.internal.bind.api.TypeReference;

public class test {

	public static void main(String[] args) {
        //生成较大的json
        List list = new ArrayList();
        for (int i = 0; i < 500000; i++) {
            JsonObject obj = new JsonObject();
//            obj
//            obj.setId(i);
            obj.setName("name" + String.valueOf(i));
            list.add(obj);
        }

        Gson gson = new GsonBuilder().create();
        String str = gson.toJson(list);

//        //1,gson解析
//        long start1 = System.currentTimeMillis();
//        List l = gson.fromJson(str, new TypeToken>() {
//        }.getType());
//        System.out.println("gson time elapse:" + (System.currentTimeMillis() - start1));
//        System.out.println(l.size());

        //2,jackson解析
        ObjectMapper mapper = new Objects();
        long start2 = System.currentTimeMillis();
        List l2 = mapper.readValue(str, new TypeReference>() {
        });
        System.out.println("jackson time elapse:" + (System.currentTimeMillis() - start2));
        System.out.println(l2.size());


	}

}

class JsonObject{
	int Id;
	String name;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
