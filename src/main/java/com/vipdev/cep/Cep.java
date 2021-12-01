package com.vipdev.cep;

import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Cep {

	@GetMapping("/cep/{cep}")
	public ResponseEntity<Object> getCep(@PathVariable String cep) {
		String pattern = "[0-9]+";
		cep = cep.replace("-", "");
		String response = "";
		int status = 200;
		if(cep.length() == 8 &&  cep.matches(pattern)){
			RestTemplate restTemplate = new RestTemplate();
			String url = "https://viacep.com.br/ws/"+cep+"/json/";
			JSONObject retorno = new JSONObject(restTemplate.getForObject(url, String.class));
			try {
				String rua = retorno.getString("logradouro");
				response = rua;
			} catch (JSONException e) {
				response = "CEP não encontrada";
				status = 401;
			}
			
		}else{
			response =  "não é CEP";
			status = 501;
		}
		HashMap<String, Object> map = new HashMap<>();
        map.put("status", String.valueOf(status));
        map.put("message", response);
            
        return new ResponseEntity<Object>(map, HttpStatus.OK);
		
	}
	
	
	
}
