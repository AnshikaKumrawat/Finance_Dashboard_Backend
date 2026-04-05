package com.finance_dashboard.backend.services;
import com.finance_dashboard.backend.enums.*;
import com.finance_dashboard.backend.models.*;
import org.springframework.stereotype.Service;

@Service
public interface RoleService {
    Role findByName(ERole eRole);
}