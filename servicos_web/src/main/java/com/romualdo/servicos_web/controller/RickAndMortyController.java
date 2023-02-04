package com.romualdo.servicos_web.controller;

import com.romualdo.servicos_web.client.RickAndMortyClient;
import com.romualdo.servicos_web.response.CharacterResponse;
import com.romualdo.servicos_web.response.EpisodeResponse;
import com.romualdo.servicos_web.response.ListOfEpisodesResponse;
import com.romualdo.servicos_web.response.LocationResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/webclient")
@AllArgsConstructor
public class RickAndMortyController {
    RickAndMortyClient rickAndMortyClient;


    @GetMapping("/character/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<CharacterResponse> getCharacterById(@PathVariable String id) {
        return rickAndMortyClient.findACharacterById(id);

    }


    @GetMapping("/location/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<LocationResponse> getLocationById(@PathVariable String id) {
        return rickAndMortyClient.findALocationById(id);

    }


    @GetMapping("/episode/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<EpisodeResponse> getEpisodeById(@PathVariable String id) {
        return rickAndMortyClient.findAEpisodeById(id);

    }


    @GetMapping("/episodes")
    @ResponseStatus(HttpStatus.OK)
    public Flux<ListOfEpisodesResponse> ListAllEpisodes() {
        return rickAndMortyClient.ListAllEpisodes();

    }
}
