package com.example.Spring.Example.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "tblFilm")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    private Long filmId;  // Khóa chính (film_id)

    @Column(name = "title", nullable = false, unique = true)
    private String title;  // Tên phim (không null)

    @Column(name = "description")
    private String description;  // Mô tả (có thể null)

    @Column(name = "release_year")
    private Integer releaseYear;  // Năm phát hành

    @ManyToOne
    @JoinColumn(name = "language_id", referencedColumnName = "language_id", nullable = false)
    private Language language;  // Khóa ngoại trỏ tới bảng language

    @ManyToOne
    @JoinColumn(name = "original_language_id", referencedColumnName = "language_id")
    private Language originalLanguage;  // Khóa ngoại trỏ tới bảng language (có thể null)

    @Column(name = "rental_duration")
    private Integer rentalDuration;  // Thời gian cho thuê

    @Column(name = "rental_rate", precision = 5)
    private Double rentalRate;  // Tỷ lệ cho thuê

    @Column(name = "length")
    private Integer length;  // Chiều dài phim (có thể null)

    @Column(name = "replacement_cost")
    private Integer replacementCost;  // Chi phí thay thế

    @Column(name = "rating", length = 10)
    private String rating;  // Xếp hạng phim

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((filmId == null) ? 0 : filmId.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((releaseYear == null) ? 0 : releaseYear.hashCode());
        result = prime * result + ((language == null) ? 0 : language.hashCode());
        result = prime * result + ((originalLanguage == null) ? 0 : originalLanguage.hashCode());
        result = prime * result + ((rentalDuration == null) ? 0 : rentalDuration.hashCode());
        result = prime * result + ((rentalRate == null) ? 0 : rentalRate.hashCode());
        result = prime * result + ((length == null) ? 0 : length.hashCode());
        result = prime * result + ((replacementCost == null) ? 0 : replacementCost.hashCode());
        result = prime * result + ((rating == null) ? 0 : rating.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Film other = (Film) obj;
        if (filmId == null) {
            if (other.filmId != null)
                return false;
        } else if (!filmId.equals(other.filmId))
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (releaseYear == null) {
            if (other.releaseYear != null)
                return false;
        } else if (!releaseYear.equals(other.releaseYear))
            return false;
        if (language == null) {
            if (other.language != null)
                return false;
        } else if (!language.equals(other.language))
            return false;
        if (originalLanguage == null) {
            if (other.originalLanguage != null)
                return false;
        } else if (!originalLanguage.equals(other.originalLanguage))
            return false;
        if (rentalDuration == null) {
            if (other.rentalDuration != null)
                return false;
        } else if (!rentalDuration.equals(other.rentalDuration))
            return false;
        if (rentalRate == null) {
            if (other.rentalRate != null)
                return false;
        } else if (!rentalRate.equals(other.rentalRate))
            return false;
        if (length == null) {
            if (other.length != null)
                return false;
        } else if (!length.equals(other.length))
            return false;
        if (replacementCost == null) {
            if (other.replacementCost != null)
                return false;
        } else if (!replacementCost.equals(other.replacementCost))
            return false;
        if (rating == null) {
            if (other.rating != null)
                return false;
        } else if (!rating.equals(other.rating))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Film [filmId=" + filmId + ", title=" + title + ", description=" + description + ", releaseYear="
                + releaseYear + ", language=" + language + ", originalLanguage=" + originalLanguage
                + ", rentalDuration=" + rentalDuration + ", rentalRate=" + rentalRate + ", length=" + length
                + ", replacementCost=" + replacementCost + ", rating=" + rating + "]";
    }

    public Film(Long filmId, String title, String description, Integer releaseYear, Language language,
            Language originalLanguage, Integer rentalDuration, Double rentalRate, Integer length,
            Integer replacementCost, String rating) {
        this.filmId = filmId;
        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
        this.language = language;
        this.originalLanguage = originalLanguage;
        this.rentalDuration = rentalDuration;
        this.rentalRate = rentalRate;
        this.length = length;
        this.replacementCost = replacementCost;
        this.rating = rating;
    }

    public Film() {
    }

    public Long getFilmId() {
        return filmId;
    }

    public void setFilmId(Long filmId) {
        this.filmId = filmId;
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

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Language getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(Language originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public Integer getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(Integer rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public Double getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(Double rentalRate) {
        this.rentalRate = rentalRate;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(Integer replacementCost) {
        this.replacementCost = replacementCost;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
