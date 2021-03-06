import org.json.JSONArray;
import org.json.JSONObject;

import java.math.BigDecimal;
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
        }else if(url.equals("/iou")){
            String lender = payload.getString("lender");
            String borrower = payload.getString("borrower");
            BigDecimal amount = payload.getBigDecimal("amount");
            //deals with lender and borrower
            for(User user : listOfUsers){
                if(user.name().equals(lender)){
                    User.Builder userCopy = User.builder().setName(user.name());
                    //.owedBy(borrower, amount.doubleValue()).build();
                    user.owedBy().forEach(x -> userCopy.owedBy(x.name, x.amount));
                    userCopy.owedBy(borrower, amount.doubleValue());
                    user.owes().forEach(x -> userCopy.owes(x.name, x.amount));
                    listOfUsers.set(listOfUsers.indexOf(user), userCopy.build());
                }else if(user.name().equals(borrower)){
                    User.Builder userCopy = User.builder().setName(user.name());
                    user.owedBy().forEach(x -> userCopy.owedBy(x.name, x.amount));
                    user.owes().forEach(x -> userCopy.owes(x.name, x.amount));
                    userCopy.owes(lender, amount.doubleValue());
                    listOfUsers.set(listOfUsers.indexOf(user), userCopy.build());
                }
            }
            JSONObject js = new JSONObject();
            JSONArray jsa = new JSONArray();
            List<String> namesOfTransactionPair = new ArrayList<>(Arrays.asList(lender, borrower));
            for(String name : namesOfTransactionPair){
                for(User user : listOfUsers){
                    if(user.name().equals(name)){
                        JSONObject jso = new JSONObject();
                        jso.put("name", user.name());
                        JSONObject jsoOwes = new JSONObject();
                        JSONObject jsoOwedBy = new JSONObject();
                        for(Iou el : user.owes()){
                            jsoOwes.put(el.name, el.amount);
                        }
                        for(Iou el : user.owedBy()){
                            jsoOwedBy.put(el.name, el.amount);
                        }
                        jso.put("owes", jsoOwes);
                        jso.put("owedBy", jsoOwedBy);
                        double balance = 0.0;
                        BigDecimal sumOfMoneyOwedByOthers = user.owedBy()
                                .stream().map(x -> new BigDecimal(x.amount)).reduce(BigDecimal.ZERO, BigDecimal::add);
                        BigDecimal sumOfMoneyOwedByTheUser = user.owes()
                                .stream().map(x -> new BigDecimal(x.amount)).reduce(BigDecimal.ZERO, BigDecimal::add);
                        balance+= (sumOfMoneyOwedByOthers.subtract(sumOfMoneyOwedByTheUser)).doubleValue();
                        jso.put("balance", balance);
                        jsa.put(jso);
                    }
                }
            }
            js.put("users", jsa);
            return js.toString();
        }
        return null;
    }
}