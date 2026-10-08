package br.com.fiap.gamerFinder.controller;

import br.com.fiap.gamerFinder.domain.assembler.GameAssembler;
import br.com.fiap.gamerFinder.domain.game.Game;
import br.com.fiap.gamerFinder.repositories.GameRepository;
import br.com.fiap.gamerFinder.repositories.GenreRepository;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/games")
public class GameController {

    private final GameRepository gameRepository;
    private final GameAssembler gameAssembler;


    public GameController(GameRepository gameRepository, GameAssembler gameAssembler) {
        this.gameRepository = gameRepository;
        this.gameAssembler = gameAssembler;
    }

    @GetMapping
    public Map<String, List<EntityModel<Game>>> getAllGames() {
        List<EntityModel<Game>> gameList = gameRepository.findAll().stream()
                .map(gameAssembler::toModel)
                .toList();

        return Map.of("gameList", gameList);
    }

    @GetMapping("/{id}")
    public EntityModel<Game> getGameById(@PathVariable Long id) {
        var game = gameRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Game não encontrado com id: " + id
                )
        );

        return gameAssembler.toModel(game);
    }

    @GetMapping("/genres/{genreId}")
    public List<Game> findByGenreId(@PathVariable Long genreId){
        return gameRepository.findByGenreId(genreId);
    }

    @GetMapping("/platforms/{platformId}")
    public List<Game> findByPlatformId(@PathVariable Long platformId) {
        return gameRepository.findByGenreId(platformId);
    }
}
