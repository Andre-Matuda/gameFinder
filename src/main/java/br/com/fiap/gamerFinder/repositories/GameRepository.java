package br.com.fiap.gamerFinder.repositories;

import br.com.fiap.gamerFinder.domain.game.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {

    List<Game> findByGenreId(Long genreId);
}
