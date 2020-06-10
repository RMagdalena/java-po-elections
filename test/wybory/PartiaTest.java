package wybory;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class PartiaTest {

    @Test
    void testToString() {
        Partia partia = new Partia("PartiaA", 546, new StrategiaZRozmachem());

        System.out.println(partia.toString());
    }
}