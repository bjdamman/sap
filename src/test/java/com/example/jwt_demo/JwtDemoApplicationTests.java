package com.example.jwt_demo;

import com.example.jwt_demo.model.Product;
import com.example.jwt_demo.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.bytebuddy.utility.dispatcher.JavaDispatcher;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@AutoConfigureWebTestClient
@SpringBootTest
@AutoConfigureMockMvc
class JwtDemoApplicationTests {

	//@Test
	//void contextLoads() {
	//}
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Mock
    ProductRepository productRepository;

    @Test
    void getProduct() throws Exception {

        Product product = new Product(null,"Hiaat","2");

        //ArrayList<Product> products = (ArrayList<Product>) Arrays.asList(product);

        when(productRepository.findById(anyLong())).thenReturn(Optional.of(product));
        //when(listsService.findById(anyString())).thenReturn(lookupResponse);

        //Book bookToCreate = new Book(null, "New Book", "New Author");

        // Send POST request
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/test/product")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isUnauthorized())
                .andReturn();

        // Deserialize response
        //Product createdProduct = objectMapper.readValue(result.getResponse().getContentAsString(), Product.class);

        System.out.println("Test");
        // Assertions
        //assertNotNull(createdProduct.getId());
        //assertEquals(createdProduct.getName(), createdProduct.getName());
        //assertEquals(createdProduct.getCategory(), createdProduct.getCategory());


        //mockMvc.perform(get("/id/1"))
        //        .andExpect(status().isOk())
        //        .andExpect(jsonPath("$.type", equalTo("123456")));

    }









}
