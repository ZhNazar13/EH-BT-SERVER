package kz.bcc.tutorial.balatime.service.impl;

import kz.bcc.tutorial.balatime.model.Role;
import kz.bcc.tutorial.balatime.repository.RoleRepository;
import kz.bcc.tutorial.balatime.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    RoleRepository roleRepository;

    @Override
    public Role create(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role getById(Integer id){
        Optional<Role> optionalRole = roleRepository.findById(id);
        if(optionalRole.isPresent()){
            return roleRepository.findById(id).get();
        } else{
            return null;
        }
    }

    @Override
    public List<Role> getAll(){
        return roleRepository.findAll();
    }

    @Override
    public void delete(Integer id){
        Role role = getById(id);
        if(role != null){
            roleRepository.delete(role);
        }
    }
}
