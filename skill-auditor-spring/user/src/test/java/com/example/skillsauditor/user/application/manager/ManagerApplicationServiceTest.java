package com.example.skillsauditor.user.application.manager;

import com.example.skillsauditor.user.application.manager.interfaces.INFManagerJpaToManagerConvertor;
import com.example.skillsauditor.user.application.manager.interfaces.INFManagerRepository;
import com.example.skillsauditor.user.application.manager.interfaces.INFManagerToManagerJpaConvertor;
import com.example.skillsauditor.user.application.staff.interfaces.INFStaffRepository;
import com.example.skillsauditor.user.domain.common.*;
import com.example.skillsauditor.user.domain.manager.Manager;
import com.example.skillsauditor.user.domain.manager.interfaces.commands.category.INFCreateCategoryCommand;
import com.example.skillsauditor.user.domain.manager.interfaces.commands.category.INFDeleteCategoryCommand;
import com.example.skillsauditor.user.domain.manager.interfaces.commands.category.INFEditCategoryCommand;
import com.example.skillsauditor.user.domain.manager.interfaces.commands.skill.INFCreateSkillCommand;
import com.example.skillsauditor.user.domain.manager.interfaces.commands.skill.INFDeleteSkillCommand;
import com.example.skillsauditor.user.domain.manager.interfaces.commands.skill.INFEditSkillCommand;
import com.example.skillsauditor.user.infrastructure.manager.ManagerJpa;
import com.example.skillsauditor.user.infrastructure.staff.StaffJpa;
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
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.core.env.Environment;

import java.util.Optional;

import static com.example.skillsauditor.user.domain.common.JobRole.MANAGER;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ManagerApplicationServiceTest {

    @InjectMocks
    ManagerApplicationService applicationService;

    @Mock
    private INFManagerRepository managerRepository;
    @Mock
    private INFManagerJpaToManagerConvertor managerJpaToManagerConvertor;
    @Mock
    private INFManagerToManagerJpaConvertor managerToManagerJpaConvertor;

    @Mock
    private INFStaffRepository staffRepository;

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
    public void editCategory_When_Given_A_INFEditCategoryCommand_Message_Sent_To_Queue() throws JsonProcessingException {
        String event = "EventTest";

        INFEditCategoryCommand editCommand = Mockito.mock(INFEditCategoryCommand.class);

        Mockito.when(editCommand.getName()).thenReturn("test");
        Mockito.when(editCommand.getCategoryId()).thenReturn("11");
        Mockito.when(mapper.writeValueAsString(Mockito.any())).thenReturn(event);

        applicationService.editCategory(editCommand);
        Mockito.verify(sender, Mockito.times(1))
                .convertAndSend(environment.getProperty("rabbitmq.exchange"),
                        environment.getProperty("rabbitmq.createCategoryQueueRoutingKey"),
                        event);

    }

    @Test
    public void deleteCategory_When_Given_A_INFDeleteCategoryCommand_Message_Sent_To_Queue() throws JsonProcessingException {
        String event = "EventTest";

        INFDeleteCategoryCommand deleteCommand = Mockito.mock(INFDeleteCategoryCommand.class);

        Mockito.when(deleteCommand.getCategoryId()).thenReturn("11");
        Mockito.when(mapper.writeValueAsString(Mockito.any())).thenReturn(event);

        applicationService.deleteCategory(deleteCommand);
        Mockito.verify(sender, Mockito.times(1))
                .convertAndSend(environment.getProperty("rabbitmq.exchange"),
                        environment.getProperty("rabbitmq.createCategoryQueueRoutingKey"),
                        event);
    }

    @Test
    public void createSkill_When_Given_A_INFCreateSkillCommand_Message_Sent_To_Queue() throws JsonProcessingException {
        String event = "EventTest";

        INFCreateSkillCommand createCommand = Mockito.mock(INFCreateSkillCommand.class);

        Mockito.when(createCommand.getName()).thenReturn("test");
        Mockito.when(createCommand.getCategoryId()).thenReturn("11");

        Mockito.when(mapper.writeValueAsString(Mockito.any())).thenReturn(event);

        applicationService.createSkill(createCommand);
        Mockito.verify(sender, Mockito.times(1))
                .convertAndSend(environment.getProperty("rabbitmq.exchange"),
                        environment.getProperty("rabbitmq.createCategoryQueueRoutingKey"),
                        event);
    }

    @Test
    public void editSkill_When_Given_A_INFEditSkillCommand_Message_Sent_To_Queue() throws JsonProcessingException {
        String event = "EventTest";

        INFEditSkillCommand editCommand = Mockito.mock(INFEditSkillCommand.class);

        Mockito.when(editCommand.getName()).thenReturn("test");

        Mockito.when(mapper.writeValueAsString(Mockito.any())).thenReturn(event);

        applicationService.editSkill(editCommand);
        Mockito.verify(sender, Mockito.times(1))
                .convertAndSend(environment.getProperty("rabbitmq.exchange"),
                        environment.getProperty("rabbitmq.createCategoryQueueRoutingKey"),
                        event);
    }

    @Test
    public void deleteSkill_When_Skill_Is_Not_In_Use_Message_Sent_To_Queue() throws JsonProcessingException {
        String event = "EventTest";

        INFDeleteSkillCommand deleteCommand = Mockito.mock(INFDeleteSkillCommand.class);

        Mockito.when(deleteCommand.getSkillId()).thenReturn("11");

        Mockito.when(mapper.writeValueAsString(Mockito.any())).thenReturn(event);

        applicationService.deleteSkill(deleteCommand);
        Mockito.verify(sender, Mockito.times(1))
                .convertAndSend(environment.getProperty("rabbitmq.exchange"),
                        environment.getProperty("rabbitmq.createCategoryQueueRoutingKey"),
                        event);
    }


    @Test
    public void addStaffToTeam_If_ManagerJpa_And_StaffJpa_Is_Present_Add_Team_Member(){

        Optional<ManagerJpa> managerJpa = createManagerJpaMock();
        Optional<StaffJpa> staffJpa = createStaffJpaMock();

        Manager manager = createManagerMock();

        Mockito.when(managerRepository.findById(Mockito.any())).thenReturn(managerJpa);
        Mockito.when(staffRepository.findById(Mockito.any())).thenReturn(staffJpa);

        Mockito.when(managerJpaToManagerConvertor.convert(Mockito.any())).thenReturn(manager);
        Mockito.when(managerToManagerJpaConvertor.convert(manager)).thenReturn(managerJpa.get());

        applicationService.addStaffToTeam("1", "2");

        Mockito.verify(managerRepository, Mockito.times(1)).save(managerJpa.get());
    }



    private Manager createManagerMock() {
        FullName fullName = new FullName(FIRST_NAME, SURNAME);
        LoginDetails loginDetails = new LoginDetails(LOG_IN_DETAILS_USERNAME, LOG_IN_DETAILS_PASSWORD);
        Address address = new Address(HOUSE_NAME_NUMBER, STREET, TOWN, POSTCODE);

        Manager manager = new Manager(ID, fullName, loginDetails, MANAGER, address);

        return manager;
    }

    private Optional<StaffJpa> createStaffJpaMock() {
        StaffJpa staffJpa = new StaffJpa(ID.id(), FIRST_NAME, SURNAME, LOG_IN_DETAILS_USERNAME, LOG_IN_DETAILS_PASSWORD, JOB_ROLE, HOUSE_NAME_NUMBER, STREET, TOWN, POSTCODE);

        return Optional.of(staffJpa);
    }

    private Optional<ManagerJpa> createManagerJpaMock() {
        ManagerJpa mangerJpa = new ManagerJpa(ID.id(), FIRST_NAME, SURNAME, LOG_IN_DETAILS_USERNAME, LOG_IN_DETAILS_PASSWORD, JOB_ROLE, HOUSE_NAME_NUMBER, STREET, TOWN, POSTCODE);

        return Optional.of(mangerJpa);
    }

}
