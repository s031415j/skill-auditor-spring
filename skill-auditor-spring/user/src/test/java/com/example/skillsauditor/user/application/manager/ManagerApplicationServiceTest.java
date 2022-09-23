package com.example.skillsauditor.user.application.manager;

import com.example.skillsauditor.user.application.manager.interfaces.INFManagerJpaToManagerConvertor;
import com.example.skillsauditor.user.application.manager.interfaces.INFManagerRepository;
import com.example.skillsauditor.user.application.manager.interfaces.INFManagerToManagerJpaConvertor;
import com.example.skillsauditor.user.application.staff.interfaces.INFStaffJpaToStaffConvertor;
import com.example.skillsauditor.user.application.staff.interfaces.INFStaffRepository;
import com.example.skillsauditor.user.domain.common.Identity;
import com.example.skillsauditor.user.domain.common.UniqueIDFactory;
import com.example.skillsauditor.user.domain.manager.interfaces.commands.category.INFCreateCategoryCommand;
import com.example.skillsauditor.user.ui.manager.interfaces.INFManagerApplicationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.core.env.Environment;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ManagerApplicationServiceTest {

    @InjectMocks
    INFManagerApplicationService applicationService;

    @Mock
    private INFManagerRepository managerRepository;
    @Mock
    private INFManagerJpaToManagerConvertor managerJpaToManagerConvertor;
    @Mock
    private INFManagerToManagerJpaConvertor managerToManagerJpaConvertor;

    @Mock
    private INFStaffJpaToStaffConvertor staffJpaToStaffConvertor;
    @Mock
    private INFStaffRepository staffRepository;
    @Mock
    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Mock
    private Environment environment;
    @Mock
    private RabbitTemplate sender;
    @Mock
    private ObjectMapper mapper;


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
    void start(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void createCategory_When_Given_A_INFCreateCategoryCommand_Message_Sent_To_Queue() throws JsonProcessingException {
        String event = "EventTest";

        INFCreateCategoryCommand createCommand = Mockito.mock(INFCreateCategoryCommand.class);

        Mockito.when(createCommand.getName()).thenReturn("test");
        Mockito.when(mapper.writeValueAsString(Mockito.any())).thenReturn(event);

        applicationService.createCategory(createCommand);
        Mockito.verify(sender, Mockito.times(1))
                .convertAndSend(environment.getProperty("rabbitmq.exchange"),
                        environment.getProperty("rabbitmq.createCategoryQueueRoutingKey"),
                        event);




    }


    @Test
    public void test02_When_Given_A_INFEditCategoryCommand_Message_Sent_To_Queue(){

    }

    @Test
    public void test03_When_Given_A_INFDeleteCategoryCommand_Message_Sent_To_Queue(){

    }

    @Test
    public void test04_When_Given_A_INFCreateSkillCommand_Message_Sent_To_Queue(){

    }

    @Test
    public void test05_When_Given_A_INFEditSkillCommand_Message_Sent_To_Queue(){

    }

    @Test
    public void test06_When_Given_A_INFDeleteSkillCommand_Message_Sent_To_Queue(){

    }

    @Test
    public void test07_Given_Staff_Has_Skills_Return_True(){

    }

    @Test
    public void test08_When_Given_A_Manager_Id_And_Staff_Id_Staff_Added_To_Team(){

    }

}
