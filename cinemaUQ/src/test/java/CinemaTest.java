import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CinemaTest {
    Cinema cinema= new Cinema("CinemaUQ", "nit123", "Armenia");

    @Test
    void cinemaTengaDatosCorrectos() {
        assertEquals("CINEMAUQ", cinema.getNombre());
        assertEquals("12345", cinema.getNit());
        assertEquals("Armenia", cinema.getDireccion());
    }
}
