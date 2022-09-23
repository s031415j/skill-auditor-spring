package com.example.skillsauditor.user.application.staff;

import com.example.skillsauditor.user.application.staff.interfaces.INFStaffRepository;
import com.example.skillsauditor.user.domain.common.Identity;
import com.example.skillsauditor.user.domain.common.UniqueIDFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.MockitoAnnotations.openMocks;

public class StaffQueryHandlerTest {

    private AutoCloseable closeable;

    @Mock
    private INFStaffRepository repository;


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
    public void test01_If_No_Staff_Have_Expired_Skills_Return_Empty_List(){

    }

    @Test
    public void test02_If_Staff_Have_Expired_Skills_Return_List_Of_StaffDTO(){

    }
}
