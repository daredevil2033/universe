package com.fluffy.universe.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

import com.fluffy.universe.models.Role;
import com.fluffy.universe.models.User;
import com.fluffy.universe.utils.ServerData;
import com.fluffy.universe.utils.SessionKey;
import com.fluffy.universe.utils.SessionUtils;
import io.javalin.Javalin;
import io.javalin.http.Context;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

class PostControllerTest {
    private PostController postController;
    private Context context;

    @BeforeEach
    void setUp() {
        context = mock(Context.class);
        ServerData serverData = new ServerData();
        when(context.sessionAttribute(SessionKey.SERVER_DATA)).thenReturn(serverData);
        Javalin javalin = mock(Javalin.class);
        postController = new PostController(javalin);
        User user = mock(User.class);
        when(user.getId()).thenReturn(1);
        when(SessionUtils.getCurrentUser(context)).thenReturn(user);
    }

    /**
     * Method under test: {@link PostController#indexPage(Context)}
     */
    @Test
    void testIndexPage() {
        postController.indexPage(context);
        verify(context, times(1)).redirect("/");
        fail("CircleCI test");
    }

    /**
     * Method under test: {@link PostController#createPage(Context)}
     */
    @Test
    void testCreatePage() {
        InOrder inOrder = inOrder(context);
        postController.createPage(context);
        inOrder.verify(context).sessionAttribute("model");
        inOrder.verify(context).render("/views/pages/models/post/create.vm",null);
        inOrder.verify(context).sessionAttribute("serverData");
    }

    /**
     * Method under test: {@link PostController#editPage(Context)}
     */
    @Test
    void testEditPage() {
        InOrder inOrder = inOrder(context);
        postController.editPage(context);
        inOrder.verify(context).sessionAttribute("model");
        inOrder.verify(context).render("/views/pages/models/post/edit.vm",null);
        inOrder.verify(context).sessionAttribute("serverData");
    }

    /**
     * Method under test: {@link PostController#registerRoutes(Javalin)}
     */
    @Test
    void testRegisterRoutes() {
        Javalin javalin = mock(Javalin.class);
        InOrder inOrder = inOrder(javalin);
        PostController postController = new PostController(javalin);
        postController.registerRoutes(javalin);
        inOrder.verify(javalin).get(eq("/posts"), any(), eq(Role.GUEST));
        inOrder.verify(javalin).get(eq("/posts/create"), any(), eq(Role.USER));
        inOrder.verify(javalin).get(eq("/posts/{post}/edit"), any(), eq(Role.USER));
        inOrder.verify(javalin).get(eq("/posts/{post}"), any(), eq(Role.GUEST), eq(Role.USER));
        inOrder.verify(javalin).post(eq("/posts"), any(), eq(Role.USER));
    }

    /**
     * Method under test: {@link PostController#PostController(Javalin)}
     */
    @Test
    void testNewPostController() {
        PostController newPostController = new PostController(mock(Javalin.class));
        assertEquals("/posts", newPostController.baseUrl);
    }
}
