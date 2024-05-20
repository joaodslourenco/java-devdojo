package academy.devdojo.maratonajava.javacore.ZZKjunit.dominio;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MangaTest {
    private Manga manga1;
    private Manga manga2;

    @BeforeEach
    public void setup() {
        manga1 = new Manga("One Piece", 1100);
        manga2 = new Manga("One Piece", 1100);
        // manga2 = new Manga("Kimetsu no Yaiba", 50);
    }

    @Test
    @DisplayName("Manga accessors return data.")
    public void accessors_ReturnData_WhenInitialized() {
        assertEquals("One Piece", manga1.name());
        assertEquals(1100, manga1.episodes());
    }

    @Test
    @DisplayName("Two Mangas are equal when initialized with same values")
    public void equals_ReturnTrue_WhenObjectsAreTheSame() {
        assertEquals(manga1, manga2);
    }

    @Test
    @DisplayName("Two Mangas have equal hashcode when initialized with same values")
    public void hashcode_ReturnTrue_WhenObjectsAreTheSame() {
        assertEquals(manga1.hashCode(), manga2.hashCode());
    }

    @Test
    @DisplayName("Two Mangas have equal hashcode when initialized with same values")
    public void constructor_ThrowNullPointerException_WhenNameIsNull() {
        assertThrows(NullPointerException.class, () -> new Manga(null, 12));
    }

    @Test
    @DisplayName("Manga is a record class")
    public void isRecord_ReturnTrue_WhenCalledFromManga() {
        assertTrue(Manga.class.isRecord());
    }
}