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

import com.game.starter.model.Score;
import com.game.starter.repository.ScoreRepository;
import com.game.starter.service.ScoreDAO;

@SpringBootTest(classes = ScoreController.class)
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class ScoreController {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	com.game.starter.controller.ScoreController controller;

	@Mock
	ScoreRepository repo;

	@Mock
	ScoreDAO dao;

	@org.junit.Test
	public void getGames() throws Exception {
		when(repo.findAll()).thenReturn(null);

		mockMvc.perform(get("http://localhost:8080/score").contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().is4xxClientError());

	}

	@org.junit.Test
	public void putGames() throws Exception {

		mockMvc.perform(put("http://localhost:8080/score/").contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().is4xxClientError());

	}

	@org.junit.Test
	public void deleteGames() throws Exception {
		when(repo.findAll()).thenReturn(null);

		mockMvc.perform(delete("http://localhost:8080/score").contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().is4xxClientError());

	}

	@org.junit.Test
	public void getGamesWhenRepoLoaded() throws Exception {
		Score score = new Score();
		score.setScore(10);

		repo.save(score);

		mockMvc.perform(get("http://localhost:8080/score").contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().is4xxClientError());

		List<Score> list = new ArrayList<Score>();
		list.add(score);
		when(repo.findAll()).thenReturn(list);
		mockMvc.perform(get("http://localhost:8080/score").contentType(MediaType.APPLICATION_JSON_VALUE)).andReturn()
				.getResponse().getContentAsString().contains("Cricket");

	}

}