package br.com.fiap.gamerFinder.domain.assembler;

import br.com.fiap.gamerFinder.controller.GameController;
import br.com.fiap.gamerFinder.domain.game.Game;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class GameAssembler implements RepresentationModelAssembler<Game, EntityModel<Game>> {

    @Override
    public EntityModel<Game> toModel(Game game){

        return EntityModel.of(
                game,
                linkTo(methodOn(GameController.class).getGameById(game.getId())).withSelfRel(),
                linkTo(methodOn(GameController.class).getAllGames()).withRel("listAll"),
                linkTo(methodOn(GameController.class).findByGenreId(game.getGenre().getId())).withRel("listByGenre"),
                linkTo(methodOn(GameController.class).findByPlatformId(game.getPlatform().getId())).withRel("listByPlat")
        );
    }
}
