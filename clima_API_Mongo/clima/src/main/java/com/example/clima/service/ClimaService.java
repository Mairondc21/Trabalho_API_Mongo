package com.example.clima.service;


import com.example.clima.model.ClimaEntity;
import com.example.clima.repository.ClimaRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ClimaService {

    @Autowired
    private ClimaRepository climaRepository;
    public String preverTempo(){
        String dadosMetereologicos = "";
        String apiURL = "https://apiadvisor.climatempo.com.br/api/v1/anl/synoptic/locale/BR?token=12b3e1a01ec62614cd4a9ac2c939f981";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiURL, String.class);

        if(responseEntity.getStatusCode().is2xxSuccessful()){
            System.out.println("Código de status: " + responseEntity.getStatusCode() );
            dadosMetereologicos = responseEntity.getBody();
            System.out.println(dadosMetereologicos);
        }else{
            dadosMetereologicos = "Falha ao obter dados metereológicos. Código de status: " + responseEntity.getStatusCode();
        }
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            JsonNode jsonNode = objectMapper.readTree(dadosMetereologicos);
            for (JsonNode node : jsonNode) {
                String country = node.get("country").asText();
                String date = node.get("date").asText();
                String text = node.get("text").asText();


                ClimaEntity climaEntity = new ClimaEntity();

                climaEntity.setCountry(country);
                climaEntity.setDate(date);
                climaEntity.setText(text);

                inserir(climaEntity);
            }

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return dadosMetereologicos;
    }

    public ClimaEntity inserir(ClimaEntity user) {
        return climaRepository.save(user);
    }
}
