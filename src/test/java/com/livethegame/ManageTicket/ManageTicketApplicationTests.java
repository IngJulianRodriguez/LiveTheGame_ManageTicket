package com.livethegame.ManageTicket;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.livethegame.ManageTicket.common.TicketResponseMapper;
import com.livethegame.ManageTicket.controller.ManageTicketRestController;
import com.livethegame.ManageTicket.dto.TicketRequest;
import com.livethegame.ManageTicket.dto.TicketResponse;
import com.livethegame.ManageTicket.repository.TicketRepository;
import com.livethegame.ManageTicket.services.TicketService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Base64;

@WebMvcTest(ManageTicketRestController.class)
@AutoConfigureMockMvc
class ManageTicketApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TicketRepository TicketRepository;

    @MockBean
    private TicketService TicketService;
    @MockBean
    private TicketResponseMapper TicketResponseMapper;

    private static final String PASSWORD = "admin";
    private static final String Ticket = "admin";


    @Test
    public void testManageTicket_Business_WithoutAuthorization() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/list")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    @Test
    public void testManageTicket_Business_testUnauthorizedAccess() throws Exception {
        Base64.Encoder encoder = Base64.getEncoder();
        String encodingParaUsuarioSinPermiso = encoder.encodeToString(("usuario" + ":" + "password").getBytes());
        mockMvc.perform(MockMvcRequestBuilders.get("/list")
                        .header("Authorization", "Basic " + encodingParaUsuarioSinPermiso)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isUnauthorized());
    }
    private String asJsonString(Object obj) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(obj);
    }

}
