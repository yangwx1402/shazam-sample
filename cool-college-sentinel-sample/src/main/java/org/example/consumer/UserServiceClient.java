package org.example.consumer;


import com.alipay.sofa.runtime.api.annotation.SofaReference;
import com.alipay.sofa.runtime.api.annotation.SofaReferenceBinding;
import org.example.provider.UserService;
import org.springframework.stereotype.Component;

@Component
public class UserServiceClient {

    @SofaReference(interfaceType = UserService.class,uniqueId = "org.example.provider.UserService",binding = @SofaReferenceBinding(bindingType = "bolt"))
    private UserService userService;

    public String addUser(String name,int age){
        return userService.addUser(name,age);
    }
}
