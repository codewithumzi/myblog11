package com.myblog.myblog11.xPracticeExamples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//coversion of objects to dto
public class loginMain {
    public static void main(String[] args) {
        List<Login> logins = Arrays.asList(
//   [com.myblog.myblog11.Login@506c589e, com.myblog.myblog11.Login@69d0a921, com.myblog.myblog11.Login@446cdf90]

                new Login("umar", "testing"),
                new Login("shakir", "testing"),
                new Login("akib", "testing")
        );
        List<LoginDto> dtos = logins.stream().map(login -> mapToDto(login)).collect(Collectors.toList());
        System.out.println(dtos);
    }
     static  LoginDto mapToDto(Login login){
        LoginDto dto=new LoginDto();
        dto.setUserName(login.getUsername());
        dto.setPassword(login.getPassword());
        return dto;
    }
}