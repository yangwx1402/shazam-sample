package org.example.provider.impl;

import com.alipay.sofa.runtime.api.annotation.SofaService;
import com.alipay.sofa.runtime.api.annotation.SofaServiceBinding;
import org.example.provider.UserService;
import org.springframework.stereotype.Component;


@SofaService(interfaceType = UserService.class,uniqueId = "org.example.provider.UserService",bindings = { @SofaServiceBinding(bindingType = "bolt") })
@Component
public class UserServiceImpl implements UserService {
    @Override
    public String addUser(String name, int age) {
        return System.currentTimeMillis()+"";
    }
}
