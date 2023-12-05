package alotra.milktea.model;

import alotra.milktea.entity.RoleEntity;
import alotra.milktea.entity.UserEntity;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminUserModel {
    private UserEntity user;
    private String rolename;
}
