import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class RestApi {

    private List<User> listOfUsers;

    public RestApi(User... users){
        listOfUsers = new ArrayList<>(Arrays.asList(users));
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

    public String get(String url, JSONObject payload){
        JSONObject r = new JSONObject();
        if(url.equals("/users")){
            List<Object> users = payload.getJSONArray("users").toList();
            List<User> foundUsers = new ArrayList<>();
            users.stream().filter(x -> {
                for(User user : listOfUsers){
                    if(user.name().equals(x)){
                        foundUsers.add(User.builder().setName((String) x ).build());
                    }
                }
                return true;
            }).collect(Collectors.toList());
            JSONArray ja = new JSONArray();
            for(User user : foundUsers){
                JSONObject userJSON = new JSONObject();
                userJSON.put("name", user.name());
                userJSON.put("owes", new JSONObject(user.owes()));
                userJSON.put("owedBy", new JSONObject(user.owedBy()));
                userJSON.put("balance", 0.0);
                ja.put(userJSON);
            }
            r.put("users", ja);
        }
        return r.toString();
    }

    public String post(String url, JSONObject payload){
        if(url.equals("/add")){
            //creates a new clean user
            String userName = payload.getString("user");
            User newUser = User.builder().setName(userName).build();
            listOfUsers.add(newUser);
            JSONObject newUserJSON = new JSONObject();
            newUserJSON.put("name", newUser.name());
            newUserJSON.put("owes", Collections.emptyMap());
            newUserJSON.put("owedBy", Collections.emptyMap());
            newUserJSON.put("balance", 0.0);
            return newUserJSON.toString();
        }
        return null;
    }
}