package com.example.demo;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Home {
	@GetMapping("/gilmar/{id}")
	public String getGilmar(@PathVariable int id) {
		return "seu id é "+String.valueOf(id);
	}
	
	
	@PostMapping("/gilmar")
	public String postGilmar(@RequestBody String body) {
		JSONObject json = new JSONObject(body);
		JSONArray teste = json.getJSONArray("data");
		String nomes = "";
		for(var i = 0; i < teste.length(); i ++) {
			String data = teste.getJSONObject(i).getString("nome");
			nomes += data;
		}
		return String.valueOf(nomes);
	}
	
}
