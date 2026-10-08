package br.com.fiap.gamerFinder.repositories;

import br.com.fiap.gamerFinder.domain.genre.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
