//package vask.spring.microservices.planner.utils.rest.resttemplate;
//
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
//import ru.javabegin.micro.planner.entity.User;
//
//@Component
//
//// спец. класс для вызова микросервисов пользователей с помощью RestTemplate
//public class UserRestBuilder {
//
//    private static final String baseUrl = "http://localhost:8765/planner-users/user/";
//
//    // проверка - существует ли пользователь
//    public boolean userExists(Long userId){
//
//        // для примера - как использовать RestTemplate (но он уже deprecated)
//        RestTemplate restTemplate = new RestTemplate();
//        HttpEntity<Long> request = new HttpEntity(userId);
//
//        ResponseEntity<User> response = null;
//        // если нужно получить объект - просто вызываете response.getBody() и произойдет автоматическая конвертация из JSON в POJO
//        // в текущем вызове нам не нужен объект, т.к. мы просто проверяем, есть ли такой пользователь
//
//        try {
//
//            // вызов сервиса
//            response = restTemplate.exchange(baseUrl+"/id", HttpMethod.POST, request, User.class);
//
//            if (response.getStatusCode() == HttpStatus.OK) { // если статус был 200
//                return true;
//            }
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//        return false; // если статус не был 200
//
//    }
//
//}
