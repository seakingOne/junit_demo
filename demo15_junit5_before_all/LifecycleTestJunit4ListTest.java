package demo15_junit5_before_all;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;



public class LifecycleTestJunit4ListTest {
    protected List<Integer> fEmpty;
    protected List<Integer> fFull;


    @BeforeEach
    void setUp() {
    	  fEmpty = new ArrayList<Integer>();
          fFull = new ArrayList<Integer>();
          fFull.add(1);
          fFull.add(2);
          fFull.add(3);
    }

    @AfterEach
    void tearDown() {
    	fEmpty=null;
    	fFull=null;
    }
    
    @Test
    public void testCapacity() {
        int size = fFull.size();
        for (int i = 0; i < 100; i++) {
            fFull.add(new Integer(i));
        }
        assertTrue(fFull.size() == 100 + size);
    }
    
    @Test
    public void testContains() {
        assertTrue(fFull.contains(1));
        assertTrue(!fEmpty.contains(1));
    }
    
    @Test
    public void testElementAt() {
        int i = fFull.get(0);
        assertTrue(i == 1);

        try {
            fFull.get(fFull.size());
        } catch (IndexOutOfBoundsException e) {
            return;
        }
        fail("Should raise an ArrayIndexOutOfBoundsException");
    }
    
    @Test
    public void testRemoveAll() {
        fFull.removeAll(fFull);
        fEmpty.removeAll(fEmpty);
        assertTrue(fFull.isEmpty());
        assertTrue(fEmpty.isEmpty());
    }
    
    @Test
    public void testRemoveElement() {
        fFull.remove(new Integer(3));
        assertTrue(!fFull.contains(3));
    }
}