package com.example.skill.skill.application.skill;

import com.example.skill.application.category.interfaces.INFCategoryRepository;
import com.example.skill.application.skill.SkillApplicationService;
import com.example.skill.application.skill.events.CreateSkillEvent;
import com.example.skill.application.skill.events.DeleteSkillEvent;
import com.example.skill.application.skill.events.EditSkillEvent;
import com.example.skill.application.skill.interfaces.INFSkillJpaToSkillConvertor;
import com.example.skill.application.skill.interfaces.INFSkillRepository;
import com.example.skill.application.skill.interfaces.INFSkillToSkillJpaConvertor;
import com.example.skill.domain.common.Identity;
import com.example.skill.domain.common.UniqueIdFactory;
import com.example.skill.infrastructure.category.CategoryJpa;
import com.example.skill.infrastructure.skill.SkillJpa;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.core.env.Environment;

import java.util.Optional;

public class SkillApplicationServiceTest {

    @Mock
    private INFSkillRepository skillRepository;
    @Mock
    private INFCategoryRepository categoryRepository;
    @Mock
    private INFSkillToSkillJpaConvertor skillToSkillJpaConvertor;
    @Mock
    private INFSkillJpaToSkillConvertor skillJpaToSkillConvertor;
    @Mock
    private final Logger LOG = LoggerFactory.getLogger(getClass());
    @InjectMocks
    private SkillApplicationService applicationService;
    @Mock
    private ObjectMapper mapper;
    @Mock
    private RabbitTemplate sender;
    @Mock
    private Environment environment;

    private final Identity ID = UniqueIdFactory.createId();
    private final String NAME = "NameTest";

    @BeforeEach
    void start(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void createSkillListener_When_Given_A_Existing_SkillJpa_Should_Return_Log_Info()  {


    }

    @Test
    public void createSkillListener_When_Given_A_New_SkillJpa_Check_Category(){

    }

    @Test
    public void editSkillListener_When_A_SkillJpa_Is_Present_Call_Edit_Skill_Method(){

    }

    @Test
    public void editSkillListener_When_A_SkillJpa_Is_Empty_Return_Info_Log(){

    }

    @Test
    public void deleteSkillListener_When_A_SkillJpa_Is_Present_Return_Info_Log(){

    }

    @Test
    public void deleteSkillListener_When_A_SkillJpa_Is_Empty_Return_Info_Log(){


    }
}
