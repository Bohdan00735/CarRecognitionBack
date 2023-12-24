package com.masterwork.carrecognition.service;

import com.masterwork.carrecognition.config.TestConfig;
import com.masterwork.carrecognition.dto.LastSearchExtendedDto;
import com.masterwork.carrecognition.model.LastSearch;
import com.masterwork.carrecognition.model.User;
import com.masterwork.carrecognition.repository.LastSearchRepository;
import com.masterwork.carrecognition.repository.UserRepository;
import com.masterwork.carrecognition.service.impl.LastSearchServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest(classes = LastSearchServiceImpl.class)
@ContextConfiguration(classes = TestConfig.class)
public class LastSearchServiceTest {

    @MockBean
    LastSearchRepository lastSearchRepository;
    @MockBean
    UserRepository userRepository;
    @Autowired
    LastSearchService lastSearchService;


    @Test
    void shouldAddNewLastSearch() {

        LastSearchExtendedDto toSave = new LastSearchExtendedDto("Audi","1.jpg",1L);
        User founded = new User(toSave.getUserId());
        LastSearch lastSearch = new LastSearch().builder()
                .header(toSave.getHeader())
                .imageUrl(toSave.getImageUrl())
                .user(founded)
                .build();
        LastSearch saved = new LastSearch().builder()
                .id(1L)
                .header(toSave.getHeader())
                .imageUrl(toSave.getImageUrl())
                .user(founded)
                .build();

        when(userRepository.findById(toSave.getUserId())).thenReturn(Optional.of(founded));
        when(lastSearchRepository.save(lastSearch)).thenReturn(saved);

        lastSearchService.addLastSearchToUser(toSave);

    }
}
