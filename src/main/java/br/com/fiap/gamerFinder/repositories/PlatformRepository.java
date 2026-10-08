package br.com.fiap.gamerFinder.repositories;

import br.com.fiap.gamerFinder.domain.plataform.Platform;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlatformRepository extends JpaRepository<Platform, Long> {
}
