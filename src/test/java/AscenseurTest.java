import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AscenseurTest {
    @Test
    void testDescendre() throws InterruptedException {
        Ascenseur ascenseur[] = {new Ascenseur(20)};
        Usager usager = new Usager(3, 0);
        usager.appeller_l_ascenseur(ascenseur);
        System.out.println(ascenseur[0]);
        assertEquals('H', ascenseur[0].dirrection);
    }
    @Test
    void testMonter() throws InterruptedException {
        Ascenseur ascenseur[] = {new Ascenseur(20)};
        Usager usager = new Usager(3, 0);
        usager.appeller_l_ascenseur(ascenseur);
        System.out.println(ascenseur[0]);
        assertEquals('H', ascenseur[0].dirrection);
    }

}
