package com.inti.ProjetFinalPiscineSpring.controller;



import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import com.inti.ProjetFinalPiscineSpring.repository.PersonneRepository;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(PersonneController.class)
public class PersonneControllerTests
{
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private PersonneRepository personneRepository;
	
	@Test
	@DisplayName("Test affichage de toutes les personnes")
	public void testAffichageAllPersonne()
	{
		try
		{
			mockMvc.perform(get("/listPersons"))
			.andExpect(status().isOk())
			.andExpect(view().name("personnes"))
			.andExpect(content().string(containsString("Email")))
			.andDo(print());
			
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
