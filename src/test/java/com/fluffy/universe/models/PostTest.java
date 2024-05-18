package com.fluffy.universe.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class PostTest {
    /**
     * Method under test: {@link Post#setDescription(String)}
     * Method under test: {@link Post#getDescription()}
     */
    @Test
    void testDescription() {
        Post post = new Post();
        post.setDescription("The characteristics of someone or something");
        String actualDescription = post.getDescription();
        assertEquals("The characteristics of someone or something", actualDescription);
    }

    /**
     * Method under test: {@link Post#setId(Integer)}
     * Method under test: {@link Post#getId()}
     */
    @Test
    void testId() {
        Post post = new Post();
        post.setId(1);
        Integer actualId = post.getId();
        assertEquals(1, actualId.intValue());
    }

    /**
     * Method under test: {@link Post#setPublicationDateTime(String)}
     * Method under test: {@link Post#getPublicationDateTime()}
     */
    @Test
    void testPublicationDateTime() {
        Post post = new Post();
        post.setPublicationDateTime("2020-03-01");
        String actualPublicationDateTime = post.getPublicationDateTime();
        assertEquals("2020-03-01", actualPublicationDateTime);
    }

    /**
     * Method under test: {@link Post#setTitle(String)}
     * Method under test: {@link Post#getTitle()}
     */
    @Test
    void testTitle() {
        Post post = new Post();
        post.setTitle("Dr");
        String actualTitle = post.getTitle();
        assertEquals("Dr", actualTitle);
    }

    /**
     * Method under test: {@link Post#setUserId(Integer)}
     * Method under test: {@link Post#getUserId()}
     */
    @Test
    void testUserId() {
        Post post = new Post();
        post.setUserId(1);
        Integer actualUserId = post.getUserId();
        assertEquals(1, actualUserId.intValue());
    }

    /**
     * Method under test: {@link Post#setPublicationDateTime(LocalDateTime)}
     */
    @Test
    void testSetPublicationDateTime() {
        Post post = new Post();
        post.setPublicationDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        assertEquals("1970-01-01T00:00:00", post.getPublicationDateTime());
    }
}
