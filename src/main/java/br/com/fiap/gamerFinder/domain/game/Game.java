package br.com.fiap.gamerFinder.domain.game;

import br.com.fiap.gamerFinder.domain.genre.Genre;
import br.com.fiap.gamerFinder.domain.plataform.Platform;
import br.com.fiap.gamerFinder.infra.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

@Entity
public class Game extends BaseEntity {

    private String title;

    private String description;

    private LocalDate releaseDate;

    private Double rating;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @ManyToOne
    @JoinColumn(name = "platform_id")
    private Platform platform;

    private String coverUrl;

    @Column(name = "backdrop_url")
    private String backDrop;

    @Column(name = "in_wishlist")
    private boolean inWishList;

    public Game() {
    }

    public Game(String title, String description, LocalDate releaseDate,
                Double rating, Genre genre, Platform platform,
                String coverUrl, String backDrop, boolean inWishList) {
        this.title = title;
        this.description = description;
        this.releaseDate = releaseDate;
        this.rating = rating;
        this.genre = genre;
        this.platform = platform;
        this.coverUrl = coverUrl;
        this.backDrop = backDrop;
        this.inWishList = inWishList;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getBackDrop() {
        return backDrop;
    }

    public void setBackDrop(String backDrop) {
        this.backDrop = backDrop;
    }

    public boolean isInWishList() {
        return inWishList;
    }

    public void setInWishList(boolean inWishList) {
        this.inWishList = inWishList;
    }
}