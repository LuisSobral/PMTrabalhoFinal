package ClassesDeXML;

import ClassesObjetos.PosGraduacao;
import ClassesObjetos.Programa;
import org.junit.Test;
import static org.junit.Assert.*;

public class LerProgramasTest {
    
    @Test
    public void testLeituraDeProgramas() throws Exception {
        
        PosGraduacao pos = new PosGraduacao();
        LerProgramas xmlProgramas = new LerProgramas();
        
        xmlProgramas.leituraDeProgramas(pos);
        
        Programa programaTest = new Programa("PPGI-UNIRIO");
        
        assertEquals(programaTest.getNome(), pos.pegaProgramas(0).getNome());
    }
    
}
