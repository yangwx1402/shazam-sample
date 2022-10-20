package com.coolcollege.sample.dubbo.provider;

import com.coolcollege.sample.dubbo.constants.Constants;
import com.coolcollege.sample.dubbo.dto.UserDTO;
import com.coolcollege.sample.dubbo.facade.UserServiceFacade;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@DubboService(registry = "zk",version = Constants.DUBBO_SERVICE_VERSION, group = Constants.DUBBO_SERVICE_GROUP, timeout = Constants.DUBBO_SERVICE_TIMEOUT)
public class UserServiceFacadeImpl implements UserServiceFacade {

    private Map<Long,UserDTO> userMapping = new ConcurrentHashMap<>();

    @Override
    public List<UserDTO> listUser() {
        return Optional.ofNullable(userMapping).orElseGet(ConcurrentHashMap::new).values().stream().collect(Collectors.toList());
    }

    @Override
    public UserDTO findUserById(Long id) {
        return userMapping.get(id);
    }

    @Override
    public void addUser(UserDTO userDTO) {
        userMapping.put(userDTO.getId(),userDTO);
    }
}
