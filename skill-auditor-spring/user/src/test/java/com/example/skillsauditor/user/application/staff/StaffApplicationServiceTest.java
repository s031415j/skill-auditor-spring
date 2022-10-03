package com.example.skillsauditor.user.application.staff;

import com.example.skillsauditor.user.application.staff.interfaces.INFStaffJpaToStaffConvertor;
import com.example.skillsauditor.user.application.staff.interfaces.INFStaffRepository;
import com.example.skillsauditor.user.application.staff.interfaces.INFStaffToStaffJpaConvertor;
import com.example.skillsauditor.user.domain.common.*;
import com.example.skillsauditor.user.domain.common.interfaces.INFEditStaffCommand;
import com.example.skillsauditor.user.domain.common.staffSkill.ExpiryDate;
import com.example.skillsauditor.user.domain.common.staffSkill.StaffSkill;
import com.example.skillsauditor.user.domain.common.staffSkill.StrengthOfSkill;
import com.example.skillsauditor.user.domain.common.staffSkill.interfaces.INFAddStaffSkillCommand;
import com.example.skillsauditor.user.domain.common.staffSkill.interfaces.INFDeleteStaffSkillCommand;
import com.example.skillsauditor.user.domain.common.staffSkill.interfaces.INFEditStaffSkillCommand;
import com.example.skillsauditor.user.infrastructure.staff.StaffJpa;
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

import static com.example.skillsauditor.user.domain.common.JobRole.STAFF;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StaffApplicationServiceTest {

    @InjectMocks
    StaffApplicationService applicationService;
    @Mock
    private INFStaffRepository staffRepository;
    @Mock
    private INFStaffJpaToStaffConvertor staffJpaToStaffConvertor;
    @Mock
    private INFStaffToStaffJpaConvertor staffToStaffJpaConvertor;

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

    public StaffApplicationServiceTest() {
    }

    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void deleteStaffSkill_When_A_StaffJpa_Is_Present_Repository_Is_Called_Once(){

        Optional<StaffJpa> staffJpa = createStaffJpaMock();
        Staff staff = createStaffMock();

        INFDeleteStaffSkillCommand deleteStaffSkillCommand = Mockito.mock(INFDeleteStaffSkillCommand.class);

        Mockito.when(staffRepository.findById(Mockito.any())).thenReturn(staffJpa);
        Mockito.when(staffJpaToStaffConvertor.convert(staffJpa.get())).thenReturn(staff);
        Mockito.when(staffToStaffJpaConvertor.convert(staff)).thenReturn(staffJpa.get());
        Mockito.when(deleteStaffSkillCommand.getStaffId()).thenReturn("11");
        Mockito.when(deleteStaffSkillCommand.getSkillId()).thenReturn("11");

        applicationService.deleteStaffSkill(deleteStaffSkillCommand);
        Mockito.verify(staffRepository, Mockito.times(1)).save(staffJpa.get());

    }

    @Test
    void addStaffSkill_When_A_StaffJpa_Is_Present_Repository_Is_Called_Once() {

        Optional<StaffJpa> staffJpa = createStaffJpaMock();
        Staff staff = createStaffMock();
        INFAddStaffSkillCommand command = Mockito.mock(INFAddStaffSkillCommand.class);

        Mockito.when(staffRepository.findById(Mockito.anyString())).thenReturn(staffJpa);
        Mockito.when(staffJpaToStaffConvertor.convert(staffJpa.get())).thenReturn(staff);

        Mockito.when(command.getStaffId()).thenReturn("1");
        Mockito.when(command.getSkillId()).thenReturn("1");
        Mockito.when(command.getStrengthOfSkill()).thenReturn("BEGINNER");
        Mockito.when(command.getExpiryDate()).thenReturn(new ExpiryDate(1, 2023));

        Mockito.when(staffToStaffJpaConvertor.convert(staff)).thenReturn(staffJpa.get());
        Mockito.when(command.getStaffId()).thenReturn("1");

        applicationService.addStaffSkill(command);
        Mockito.verify(staffRepository, Mockito.times(1)).save(staffJpa.get());

    }


    @Test
    void editStaffSkill_When_A_StaffJpa_Is_Present_Repository_Is_Called_Once() {
        Optional<StaffJpa> staffJpa = createStaffJpaMock();
        Staff staff = createStaffMock();
        INFEditStaffSkillCommand command = Mockito.mock(INFEditStaffSkillCommand.class);

        Mockito.when(staffRepository.findById(Mockito.anyString())).thenReturn(staffJpa);
        Mockito.when(staffJpaToStaffConvertor.convert(staffJpa.get())).thenReturn(staff);

        Mockito.when(command.getStaffId()).thenReturn(ID.toString());
        Mockito.when(command.getSkillId()).thenReturn("1");
        Mockito.when(command.getStrengthOfSkill()).thenReturn("BEGINNER");
        Mockito.when(command.getExpiryDate()).thenReturn(new ExpiryDate(1, 2023));

        Mockito.when(staffToStaffJpaConvertor.convert(staff)).thenReturn(staffJpa.get());
        Mockito.when(command.getStaffId()).thenReturn("1");

        applicationService.editStaffSkill(command);
        Mockito.verify(staffRepository, Mockito.times(1)).save(staffJpa.get());

    }

    @Test
    void editStaff_When_A_StaffJpa_Is_Present_Repository_Is_Called_Once() {
        Optional<StaffJpa> staffJpa = createStaffJpaMock();
        Staff staff1 = createStaffMock();
        INFEditStaffCommand command = Mockito.mock(INFEditStaffCommand.class);

        Mockito.when(command.getStaffId()).thenReturn("1");
        Mockito.when(staffRepository.findById(Mockito.anyString())).thenReturn(staffJpa);
        Mockito.when(staffJpaToStaffConvertor.convert(staffJpa.get())).thenReturn(staff1);

        Mockito.when(command.getFullName()).thenReturn(getFullNameMock());
        Mockito.when(command.getLoginDetails()).thenReturn(getLoginDetailsMock());
        Mockito.when(command.getJobRole()).thenReturn(JOB_ROLE);
        Mockito.when(command.getAddress()).thenReturn(getAddressMock());

        applicationService.editStaff(command);
        Mockito.verify(staffRepository, Mockito.times(1)).save(staffJpa.get());

    }

    private Address getAddressMock() {
        return new Address(HOUSE_NAME_NUMBER, STREET, TOWN, POSTCODE);
    }

    private LoginDetails getLoginDetailsMock() {
        return new LoginDetails(LOG_IN_DETAILS_USERNAME, LOG_IN_DETAILS_PASSWORD);
    }

    private FullName getFullNameMock() {
        return new FullName(FIRST_NAME, SURNAME);
    }


    private Staff createStaffMock() {

        Staff staff = new Staff(ID, getFullNameMock(), getLoginDetailsMock(), STAFF, getAddressMock());
        StaffSkill staffSkill = new StaffSkill("11", "11", StrengthOfSkill.BEGINNER, new ExpiryDate(11,2023));
        staff.addStaffSkill(staffSkill);

        return staff;
    }

    private Optional<StaffJpa> createStaffJpaMock() {
        StaffJpa staffJpa = new StaffJpa(ID.id(), FIRST_NAME, SURNAME, LOG_IN_DETAILS_USERNAME, LOG_IN_DETAILS_PASSWORD, JOB_ROLE, HOUSE_NAME_NUMBER, STREET, TOWN, POSTCODE);

        return Optional.of(staffJpa);
    }

}
