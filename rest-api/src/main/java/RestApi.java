import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;

class RestApi {

    private List<User> listOfUsers;

    public RestApi(User... users){
        listOfUsers = Arrays.asList(users);
    }

    public String get(String url){
        if(url.equals("/users")){
            JSONObject r = new JSONObject();
            JSONArray users = new JSONArray();
            for(User user : listOfUsers){
                users.put(user);
            }
            r.put("users", users);
            return r.toString();
        }
        return null;
    }

    public JSONObject get(String url, JSONObject payload){
        return null;
    }

    public JSONObject post(String url, JSONObject payload){
        if(url.equals("/add")){

        }
        return null;
    }
}