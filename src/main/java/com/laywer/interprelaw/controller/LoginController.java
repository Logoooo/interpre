package com.laywer.interprelaw.controller;

import com.laywer.interprelaw.enums.ApiResponseEnum;
import com.laywer.interprelaw.model.ApiResponse;
import com.laywer.interprelaw.model.User;
import com.laywer.interprelaw.service.IUserService;
import com.laywer.interprelaw.util.ApiResponseUtil;
import com.laywer.interprelaw.util.JwtUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static java.lang.System.out;

@Controller
@RequestMapping(value = "/user", method = RequestMethod.POST)
@CrossOrigin
public class LoginController {
    @Resource
    private IUserService userservice;

    @PostMapping("/login")
    @ResponseBody
    public ApiResponse login(String username, String password, HttpServletRequest request, HttpServletResponse response){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        //身份验证是否成功
        User checkedUser = this.userservice.checkUser(user);
        if (checkedUser != null){

            //返回token
            String token = JwtUtil.sign(checkedUser.getUsername(),checkedUser.getuId());

            if (token!=null){
                System.out.println(ApiResponseUtil.getApiResponse(token));
                return ApiResponseUtil.getApiResponse(token);
            }
            //登陆成功
            request.getSession().setAttribute("user",checkedUser);
//            out.print("yes");
        }
//            out.print("no");
            return ApiResponseUtil.getApiResponse(ApiResponseEnum.LOGIN_FAIL);

//        out.flush();
//        out.close();
    }
}
