package trees.test;
import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import trees.AVLTree;


public class ArbolesAVLTest {

	static AVLTree<Integer> b = new AVLTree<Integer>();
	
	@Test
	public void test1() {
		//Intenta borrar de un árbol vacío
		assertNull(b.removeNode(50));
				
		assertEquals(new Integer(10),b.add(10).getInfo());
		assertEquals("10:FB=0",b.inOrder());
		assertEquals(new Integer(10),b.add(100).getInfo());
		assertEquals("10:FB=1\t100:FB=0",b.inOrder());
		//RDD
		assertEquals(new Integer(60),b.add(60).getInfo());
		assertEquals("10:FB=0\t60:FB=0\t100:FB=0",b.inOrder());
		assertEquals(new Integer(60),b.add(30).getInfo());
		assertEquals("10:FB=1\t30:FB=0\t60:FB=-1\t100:FB=0",b.inOrder());
		assertEquals(new Integer(60),b.add(2).getInfo());
		assertEquals("2:FB=0\t10:FB=0\t30:FB=0\t60:FB=-1\t100:FB=0",b.inOrder());
		//RSI
		assertEquals(new Integer(10),b.add(1).getInfo());
		assertEquals("1:FB=0\t2:FB=-1\t10:FB=0\t30:FB=0\t60:FB=0\t100:FB=0",b.inOrder());
		assertEquals(new Integer(10),b.add(70).getInfo());
		assertEquals("1:FB=0\t2:FB=-1\t10:FB=1\t30:FB=0\t60:FB=1\t70:FB=0\t100:FB=-1",b.inOrder());
		//RDI
		assertEquals(new Integer(10),b.add(90).getInfo());
		assertEquals("1:FB=0\t2:FB=-1\t10:FB=1\t30:FB=0\t60:FB=1\t70:FB=0\t90:FB=0\t100:FB=0",b.inOrder());
		assertEquals(new Integer(10),b.add(23).getInfo());
		assertEquals("1:FB=0\t2:FB=-1\t10:FB=1\t23:FB=0\t30:FB=-1\t60:FB=0\t70:FB=0\t90:FB=0\t100:FB=0",b.inOrder());
		assertEquals(new Integer(10),b.add(43).getInfo());
		assertEquals("1:FB=0\t2:FB=-1\t10:FB=1\t23:FB=0\t30:FB=0\t43:FB=0\t60:FB=0\t70:FB=0\t90:FB=0\t100:FB=0",b.inOrder());
		//RSD
		assertEquals(new Integer(60),b.add(65).getInfo());
		assertEquals("1:FB=0\t2:FB=-1\t10:FB=0\t23:FB=0\t30:FB=0\t43:FB=0\t60:FB=0\t65:FB=0\t70:FB=-1\t90:FB=-1\t100:FB=0",b.inOrder());
		assertEquals(new Integer(60),b.add(13).getInfo());
		assertEquals("1:FB=0\t2:FB=-1\t10:FB=1\t13:FB=0\t23:FB=-1\t30:FB=-1\t43:FB=0\t60:FB=-1\t65:FB=0\t70:FB=-1\t90:FB=-1\t100:FB=0",b.inOrder());
		assertEquals(new Integer(60),b.add(230).getInfo());
		assertEquals("1:FB=0\t2:FB=-1\t10:FB=1\t13:FB=0\t23:FB=-1\t30:FB=-1\t43:FB=0\t60:FB=-1\t65:FB=0\t70:FB=-1\t90:FB=0\t100:FB=1\t230:FB=0",b.inOrder());
		//RDD
		assertEquals(new Integer(60),b.add(110).getInfo());
		assertEquals("1:FB=0\t2:FB=-1\t10:FB=1\t13:FB=0\t23:FB=-1\t30:FB=-1\t43:FB=0\t60:FB=-1\t65:FB=0\t70:FB=-1\t90:FB=0\t100:FB=0\t110:FB=0\t230:FB=0",b.inOrder());
		assertEquals(new Integer(60),b.add(49).getInfo());
		assertEquals("1:FB=0\t2:FB=-1\t10:FB=1\t13:FB=0\t23:FB=-1\t30:FB=0\t43:FB=1\t49:FB=0\t60:FB=-1\t65:FB=0\t70:FB=-1\t90:FB=0\t100:FB=0\t110:FB=0\t230:FB=0",b.inOrder());
		assertEquals(new Integer(60),b.add(7).getInfo());
		assertEquals("1:FB=0\t2:FB=0\t7:FB=0\t10:FB=1\t13:FB=0\t23:FB=-1\t30:FB=0\t43:FB=1\t49:FB=0\t60:FB=-1\t65:FB=0\t70:FB=-1\t90:FB=0\t100:FB=0\t110:FB=0\t230:FB=0",b.inOrder());
		assertEquals(new Integer(60),b.add(40).getInfo());
		assertEquals("1:FB=0\t2:FB=0\t7:FB=0\t10:FB=1\t13:FB=0\t23:FB=-1\t30:FB=0\t40:FB=0\t43:FB=0\t49:FB=0\t60:FB=-1\t65:FB=0\t70:FB=-1\t90:FB=0\t100:FB=0\t110:FB=0\t230:FB=0",b.inOrder());
		//RSD
		assertEquals(new Integer(60),b.add(50).getInfo());
		assertEquals("1:FB=0\t2:FB=0\t7:FB=0\t10:FB=0\t13:FB=0\t23:FB=-1\t30:FB=0\t40:FB=0\t43:FB=1\t49:FB=1\t50:FB=0\t60:FB=-1\t65:FB=0\t70:FB=-1\t90:FB=0\t100:FB=0\t110:FB=0\t230:FB=0",b.inOrder());
		//RDI
		assertEquals(new Integer(60),b.add(20).getInfo());
		assertEquals("1:FB=0\t2:FB=0\t7:FB=0\t10:FB=0\t13:FB=0\t20:FB=0\t23:FB=0\t30:FB=0\t40:FB=0\t43:FB=1\t49:FB=1\t50:FB=0\t60:FB=-1\t65:FB=0\t70:FB=-1\t90:FB=0\t100:FB=0\t110:FB=0\t230:FB=0",b.inOrder());
		//RSI
		assertEquals(new Integer(30),b.add(15).getInfo());
		assertEquals("1:FB=0\t2:FB=0\t7:FB=0\t10:FB=1\t13:FB=1\t15:FB=0\t20:FB=-1\t23:FB=0\t30:FB=0\t40:FB=0\t43:FB=1\t49:FB=1\t50:FB=0\t60:FB=0\t65:FB=0\t70:FB=-1\t90:FB=0\t100:FB=0\t110:FB=0\t230:FB=0",b.inOrder());
		assertEquals(new Integer(30),b.add(3).getInfo());
		assertEquals("1:FB=0\t2:FB=1\t3:FB=0\t7:FB=-1\t10:FB=0\t13:FB=1\t15:FB=0\t20:FB=-1\t23:FB=0\t30:FB=0\t40:FB=0\t43:FB=1\t49:FB=1\t50:FB=0\t60:FB=0\t65:FB=0\t70:FB=-1\t90:FB=0\t100:FB=0\t110:FB=0\t230:FB=0",b.inOrder());
		
		//Añade un elemento que ya existe
		assertNull(b.add(3));
		assertEquals("1:FB=0\t2:FB=1\t3:FB=0\t7:FB=-1\t10:FB=0\t13:FB=1\t15:FB=0\t20:FB=-1\t23:FB=0\t30:FB=0\t40:FB=0\t43:FB=1\t49:FB=1\t50:FB=0\t60:FB=0\t65:FB=0\t70:FB=-1\t90:FB=0\t100:FB=0\t110:FB=0\t230:FB=0",b.inOrder());
	}
	
	@Test
	public void test2() {
		//Borro una hoja
		assertEquals(new Integer(30),b.removeNode(3).getInfo());
		assertEquals("1:FB=0\t2:FB=0\t7:FB=0\t10:FB=1\t13:FB=1\t15:FB=0\t20:FB=-1\t23:FB=0\t30:FB=0\t40:FB=0\t43:FB=1\t49:FB=1\t50:FB=0\t60:FB=0\t65:FB=0\t70:FB=-1\t90:FB=0\t100:FB=0\t110:FB=0\t230:FB=0",b.inOrder());
		
		//Borra un elemento con un hijo
		assertEquals(new Integer(30),b.removeNode(110).getInfo());
		assertEquals("1:FB=0\t2:FB=0\t7:FB=0\t10:FB=1\t13:FB=1\t15:FB=0\t20:FB=-1\t23:FB=0\t30:FB=0\t40:FB=0\t43:FB=1\t49:FB=1\t50:FB=0\t60:FB=0\t65:FB=0\t70:FB=-1\t90:FB=0\t100:FB=1\t230:FB=0",b.inOrder());
		
		//Borra un elemento con dos hijos
		assertEquals(new Integer(30),b.removeNode(90).getInfo());
		assertEquals("1:FB=0\t2:FB=0\t7:FB=0\t10:FB=1\t13:FB=1\t15:FB=0\t20:FB=-1\t23:FB=0\t30:FB=0\t40:FB=0\t43:FB=1\t49:FB=1\t50:FB=0\t60:FB=0\t65:FB=0\t70:FB=1\t100:FB=1\t230:FB=0",b.inOrder());
		
		
		//Borra la raiz (30)
		assertEquals(new Integer(23),b.removeNode(30).getInfo());
		assertEquals("1:FB=0\t2:FB=0\t7:FB=0\t10:FB=0\t13:FB=0\t15:FB=0\t20:FB=0\t23:FB=1\t40:FB=0\t43:FB=1\t49:FB=1\t50:FB=0\t60:FB=0\t65:FB=0\t70:FB=1\t100:FB=1\t230:FB=0",b.inOrder());
		
		//Borro 1\t7\t13
		assertEquals(new Integer(23),b.removeNode(1).getInfo());
		assertEquals(new Integer(23),b.removeNode(7).getInfo());
		assertEquals(new Integer(23),b.removeNode(13).getInfo());
		assertEquals("2:FB=0\t10:FB=1\t15:FB=1\t20:FB=0\t23:FB=1\t40:FB=0\t43:FB=1\t49:FB=1\t50:FB=0\t60:FB=0\t65:FB=0\t70:FB=1\t100:FB=1\t230:FB=0",b.inOrder());
		
		//Borro 20. RSD 2,0
		assertEquals(new Integer(60),b.removeNode(20).getInfo());
		assertEquals("2:FB=0\t10:FB=0\t15:FB=0\t23:FB=1\t40:FB=0\t43:FB=1\t49:FB=1\t50:FB=0\t60:FB=-1\t65:FB=0\t70:FB=1\t100:FB=1\t230:FB=0",b.inOrder());
		
		//Borro el 230. RDI  -2, 1
		assertEquals(new Integer(43),b.removeNode(230).getInfo());
		assertEquals("2:FB=0\t10:FB=0\t15:FB=0\t23:FB=-1\t40:FB=0\t43:FB=0\t49:FB=1\t50:FB=0\t60:FB=0\t65:FB=0\t70:FB=0\t100:FB=0",b.inOrder());
		
		//Borro 23
		assertEquals(new Integer(43),b.removeNode(23).getInfo());
		assertEquals("2:FB=0\t10:FB=-1\t15:FB=-1\t40:FB=0\t43:FB=0\t49:FB=1\t50:FB=0\t60:FB=0\t65:FB=0\t70:FB=0\t100:FB=0",b.inOrder());
		
		//Borro 43 (raiz) y RSI sobre el nodo 15
		assertEquals(new Integer(40),b.removeNode(43).getInfo());
		assertEquals("2:FB=0\t10:FB=0\t15:FB=0\t40:FB=1\t49:FB=1\t50:FB=0\t60:FB=0\t65:FB=0\t70:FB=0\t100:FB=0",b.inOrder());
		
	}
}
