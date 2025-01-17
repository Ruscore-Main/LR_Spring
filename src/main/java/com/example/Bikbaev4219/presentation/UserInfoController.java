package com.example.Bikbaev4219.presentation;

import com.example.Bikbaev4219.UserInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserInfoController {
//    @PostMapping("/user")
//    public String userStatus(@RequestBody UserInfo user) {
//        if (user.isEnabled()) {
//            return String.format("Hello! %s. Your account is enabled.", user.getName());
//        } else {
//            return String.format(
//                    "Hello! Nice to see you, %s! Your account is disabled",
//                    user.getName()
//            );
//        }
//    }

    @PostMapping("/user-info")
    public String userStatus(@RequestBody List<UserInfo> userList) {
        return String.format("Added %d users", userList.size());
    }


}
