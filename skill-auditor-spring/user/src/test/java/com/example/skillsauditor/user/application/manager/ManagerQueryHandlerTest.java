package com.example.skillsauditor.user.application.manager;

import com.example.skillsauditor.user.application.manager.interfaces.INFManagerJpaToManagerConvertor;
import com.example.skillsauditor.user.application.manager.interfaces.INFManagerRepository;
import com.example.skillsauditor.user.domain.common.Identity;
import com.example.skillsauditor.user.domain.common.UniqueIDFactory;
import com.example.skillsauditor.user.ui.staff.interfaces.INFStaffQueryHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.MockitoAnnotations.openMocks;

public class ManagerQueryHandlerTest {

    private AutoCloseable closeable;

    @Mock
    private INFStaffQueryHandler queryHandler;
    @Mock
    private INFManagerRepository managerRepository;
    @Mock
    private INFManagerJpaToManagerConvertor managerJpaToManagerConvertor;


    private final Identity ID = UniqueIDFactory.createID();
    private final String FIRST_NAME = "FirstTest";
    private final String SURNAME = "SurTest";
    private final String LOG_IN_DETAILS_USERNAME = "UserTest";
    private final String LOG_IN_DETAILS_PASSWORD = "PassTest";
    private final String JOB_ROLE = "STAFF";
    private final String HOUSE_NAME_NUMBER = "1";
    private final String STREET = "StreetTest";
    private final String TOWN = "TownTest";
    private final String POSTCODE = "PostcodeTest";

    @BeforeEach
    public void init(){
        closeable = openMocks(this);
    }


    @Test
    public void test01_When_Given_A_Valid_CategoryId_StaffSkillDTOList_Returned(){

    }

    @Test
    public void test02_If_Staff_Has_Expired_Skills_Return_List_Of_Staff(){

    }

    @Test
    public void test03_If_Staff_Has_No_Expired_Skills_Return_Empty_List(){

    }

    @Test
    public void test04_If_Staff_Has_No_Expired_Skills_Return_Empty_List(){

    }

    @Test
    public void test05_When_Given_A_ManagerId_Return_List_Of_ManagerTeam(){

    }

    @Test
    public void test06_When_Given_A_ManagerId_Return_List_Of_ManagerTeam(){

    }

    @Test
    public void test07_When_Given_A_ManagerId_And_SkillId_Return_List_Of_ManagerTeamDTO(){

    }

    @Test
    public void test07_When_Given_A_ManagerJpa_Return_List_Of_TeamMemberDTO(){

    }

    @Test
    public void test08_When_Given_A_ManagerTeamJpa_Return_List_Of_StaffSkillDTO(){

    }
}
