package com.finance_dashboard.backend.services.impls;
import com.finance_dashboard.backend.enums.*;
import com.finance_dashboard.backend.repository.*;
import com.finance_dashboard.backend.models.*;
import com.finance_dashboard.backend.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role findByName(ERole eRole) {
        return roleRepository.findByName(eRole)
                .orElseThrow(() -> new RuntimeException("Role is not found."));
    }
}
