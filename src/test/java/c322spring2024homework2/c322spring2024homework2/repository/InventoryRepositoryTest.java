package c322spring2024homework2.c322spring2024homework2.repository;


import c322spring2024homework2.c322spring2024homework2.model.GuitarData;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InventoryRepositoryTest{
    @Test
    void addGuitar() {
        InventoryRepository i = new InventoryRepository();

        GuitarData g1 = new GuitarData("007", 500.0, "Fender", "Dreadnought", "Acoustic", "Mahogany", "Pine");
        i.addGuitar(g1.getSerialNumber(), g1.getPrice(), g1.getBuilder(), g1.getModel(), g1.getType(), g1.getBackWood(), g1.getTopWood());
        assertTrue(i.getGuitar(g1.getSerialNumber()) != null);

        GuitarData g2 = new GuitarData("100", 800.0, "Fender", "King", "Bass", "Birch", "Maple");
        i.addGuitar(g2.getSerialNumber(), g2.getPrice(), g2.getBuilder(), g2.getModel(), g2.getType(), g2.getBackWood(), g2.getTopWood());
        assertTrue(i.getGuitar(g2.getSerialNumber()) != null);
    }


    @Test
    void getGuitar() {
        InventoryRepository i = new InventoryRepository();
        GuitarData expectedGuitarData = new GuitarData("024", 100.0, "Pike", "Aero", "Electric", "Maple", "Pine");
        GuitarData retrievedGuitarData = i.getGuitar(expectedGuitarData.getSerialNumber());
        assertNotNull(retrievedGuitarData);

        assertEquals(expectedGuitarData.getSerialNumber(), retrievedGuitarData.getSerialNumber());
        assertEquals(expectedGuitarData.getPrice(), retrievedGuitarData.getPrice(), 0.0);
        assertEquals(expectedGuitarData.getBuilder(), retrievedGuitarData.getBuilder());
        assertEquals(expectedGuitarData.getModel(), retrievedGuitarData.getModel());
        assertEquals(expectedGuitarData.getType(), retrievedGuitarData.getType());
        assertEquals(expectedGuitarData.getBackWood(), retrievedGuitarData.getBackWood());
        assertEquals(expectedGuitarData.getTopWood(), retrievedGuitarData.getTopWood());

        assertNull(i.getGuitar("123"));


    }


}