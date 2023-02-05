package com.romualdo.servicos_web.client;

import com.romualdo.servicos_web.response.CharacterResponse;
import com.romualdo.servicos_web.response.EpisodeResponse;
import com.romualdo.servicos_web.response.ListOfEpisodesResponse;
import com.romualdo.servicos_web.response.LocationResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Slf4j
@Service
public class RickAndMortyClient {
    private final WebClient webClient;

        public RickAndMortyClient(WebClient.Builder builder) {
            webClient = builder.baseUrl("https://rickandmortyapi.com/api").build();

        }

        public Mono<CharacterResponse> findACharacterById(String id) {
            log.info("Buscando personagem com o id [{}]", id);
            return webClient
                    .get()
                    .uri("/character/" + id)
                    .accept(APPLICATION_JSON)
                    .retrieve()
                    .onStatus(HttpStatus::is4xxClientError,
                            error -> Mono.error(new RuntimeException("verifique os parâmetros informados")))
                    .bodyToMono(CharacterResponse.class);
        }

        public Mono<LocationResponse> findALocationById(String id) {
            log.info("Buscando localizacao com o id [{}]", id);
            return webClient
                    .get()
                    .uri("/location/" + id)
                    .accept(APPLICATION_JSON)
                    .retrieve()
                    .onStatus(HttpStatus::is4xxClientError,
                            error -> Mono.error(new RuntimeException("verifique os parâmetros informados")))
                    .bodyToMono(LocationResponse.class);
        }


        public Mono<EpisodeResponse> findAEpisodeById(String id) {
            log.info("Buscando episodio com o id [{}]", id);
            return webClient
                    .get()
                    .uri("/episode/" + id)
                    .accept(APPLICATION_JSON)
                    .retrieve()
                    .onStatus(HttpStatus::is4xxClientError,
                            error -> Mono.error(new RuntimeException("verifique os parâmetros informados")))
                    .bodyToMono(EpisodeResponse.class);
        }

        public Flux<ListOfEpisodesResponse> ListAllEpisodes() {
            log.info("Listando todos os episodios cadastrados");
            return webClient
                    .get()
                    .uri("/episode")
                    .accept(APPLICATION_JSON)
                    .retrieve()
                    .onStatus(HttpStatus::is4xxClientError,
                            error -> Mono.error(new RuntimeException("verifique os parâmetros informados")))
                    .bodyToFlux(ListOfEpisodesResponse.class);
        }
}
