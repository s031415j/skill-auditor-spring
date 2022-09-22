package com.example.skillsauditor.user.domain.manager;

import com.example.skillsauditor.user.application.manager.ManagerApplicationService;
import com.example.skillsauditor.user.application.manager.interfaces.INFManagerJpaToManagerConvertor;
import com.example.skillsauditor.user.application.manager.interfaces.INFManagerRepository;
import com.example.skillsauditor.user.application.manager.interfaces.INFManagerToManagerJpaConvertor;
import com.example.skillsauditor.user.application.staff.interfaces.INFStaffRepository;
import com.example.skillsauditor.user.domain.common.Identity;
import com.example.skillsauditor.user.domain.common.UniqueIDFactory;
import com.example.skillsauditor.user.domain.manager.interfaces.commands.category.INFCreateCategoryCommand;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.MockitoAnnotations.openMocks;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ManagerApplicationServiceTest {
    private AutoCloseable closeable;

    @InjectMocks
    ManagerApplicationService applicationService;
    @Mock
    private INFManagerRepository managerRepository;
    @Mock
    private INFStaffRepository staffRepository;
    @Mock
    private INFManagerJpaToManagerConvertor managerJpaToManagerConvertor;
    @Mock
    private INFManagerToManagerJpaConvertor managerToManagerJpaConvertor;

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
    public void test01_When_Given_A_INFCreateCategoryCommand_Message_To_Queue(){
        INFCreateCategoryCommand mockCCC = Mockito.mock(INFCreateCategoryCommand.class);

        Mockito.when(mockCCC.getName()).thenReturn("name");
        Mockito.when()
    }

}
