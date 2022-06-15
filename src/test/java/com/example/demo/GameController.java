package com.example.demo;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.game.starter.model.Game;
import com.game.starter.repository.GameRepository;
import com.game.starter.service.GameDAO;

@SpringBootTest(classes = GameController.class)
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class GameController {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	com.game.starter.controller.GameController controller;

	@Mock
	GameRepository repo;

	@Mock
	GameDAO dao;

	@org.junit.Test
	public void getGames() throws Exception {
		when(repo.findAll()).thenReturn(null);

		mockMvc.perform(get("http://localhost:8080/game").contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().is2xxSuccessful());

	}

	@org.junit.Test
	public void putGames() throws Exception {

		mockMvc.perform(put("http://localhost:8080/game").contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().is4xxClientError());

	}

	@org.junit.Test
	public void deleteGames() throws Exception {
		when(repo.findAll()).thenReturn(null);

		mockMvc.perform(delete("http://localhost:8080/game").contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().is4xxClientError());

	}

	@org.junit.Test
	public void getGamesWhenRepoLoaded() throws Exception {
		Game game = new Game();
		game.setGameName("Cricket");

		repo.save(game);

		mockMvc.perform(get("http://localhost:8080/game").contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().is2xxSuccessful());

		List<Game> list = new ArrayList<Game>();
		list.add(game);
		when(repo.findAll()).thenReturn(list);
		mockMvc.perform(get("http://localhost:8080/game").contentType(MediaType.APPLICATION_JSON_VALUE)).andReturn()
				.getResponse().getContentAsString().contains("Cricket");

	}

}