package mk.ukim.finki.mk.lab;

import mk.ukim.finki.mk.lab.model.Balloon;
import mk.ukim.finki.mk.lab.model.Manufacturer;
import mk.ukim.finki.mk.lab.service.BalloonService;
import mk.ukim.finki.mk.lab.service.ManufacturerService;
import mk.ukim.finki.mk.lab.service.OrderService;
import mk.ukim.finki.mk.lab.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Optional;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class LabApplicationTests {

    MockMvc mockMvc;


    @Autowired
    UserService userService;

    @Autowired
    ManufacturerService manufacturerService;

    @Autowired
    OrderService orderService;

    @Autowired
    BalloonService balloonService;

    private static Optional<Balloon> b1;
    private static Manufacturer m1;

    private static boolean dataInitialized = false;

    @BeforeEach
    public void setup(WebApplicationContext wac) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        initData();
    }
    private void initData() {
        if (!dataInitialized) {
            m1 = manufacturerService.save("m1","c1","a1");
            manufacturerService.save("m2","c2","a2");
            b1 = balloonService.save("b1","b1",m1.getId());
            balloonService.save("b2", "b2",m1.getId());
            dataInitialized = true;
        }
    }

    @Test
    void contextLoads() {
    }
    @Test
    public void testGetBalloons() throws Exception {
        MockHttpServletRequestBuilder balloonsRequest = MockMvcRequestBuilders.get("/balloons");
        this.mockMvc.perform(balloonsRequest)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("lista"))
                .andExpect(MockMvcResultMatchers.model().attribute("bodyContent", "listBalloons"))
                .andExpect(MockMvcResultMatchers.view().name("master-template"));

    }
    @Test
    public void testDeleteProduct() throws Exception {
        Optional<Balloon> balloon = this.balloonService.save("test", "test baaloon", m1.getId());
        MockHttpServletRequestBuilder productDeleteRequest = MockMvcRequestBuilders
                .delete("/balloons/delete/" + balloon.get().getId());

        this.mockMvc.perform(productDeleteRequest)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/balloons"));
    }

}
