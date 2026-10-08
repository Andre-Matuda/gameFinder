package br.com.fiap.gamerFinder.domain.genre;

import br.com.fiap.gamerFinder.infra.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Genre extends BaseEntity {


    private String name;
}
