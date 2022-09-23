package com.example.skillsauditor.user.domain.manager;

import com.example.skillsauditor.user.domain.common.IdentifiedValueObject;
import com.example.skillsauditor.user.domain.common.FullName;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class ManagerTeam extends IdentifiedValueObject {

    private String managerId;
    private String staffId;
    private FullName fullName;

    public ManagerTeam(){
    }

    public static ManagerTeam managerTeamOf(String managerId,String staffId, FullName fullName) {
        return new ManagerTeam (managerId, staffId, fullName);
    }

}
