/* **********************************************
 * Duale Hochschule Baden-Württemberg Karlsruhe
 * Prof. Dr. Jörn Eisenbiegler
 * 
 * Vorlesung Übersetzerbau
 * Praxis LL(1)-Parser für X
 * - Testfall-Utility für Scanner
 * 
 * **********************************************
 */


package de.dhbw.compiler.xparser_ll1.test;

import static org.junit.Assert.assertEquals;

import java.io.StringReader;

import de.dhbw.compiler.xparser_ll1.JFlexXScanner;
import de.dhbw.compiler.xparser_ll1.TokenBuffer;
import de.dhbw.compiler.xparser_ll1.Tree;
import de.dhbw.compiler.xparser_ll1.XParser;

public abstract class ParseTreeTest {
	
	protected void testParseTree(String in, String expected) throws Exception {
		JFlexXScanner scanner = new JFlexXScanner(new StringReader(in));
		TokenBuffer 	buffer	= new TokenBuffer(scanner);
		XParser			parser	= new XParser(buffer);
		
		Tree out = parser.parseProgram();
		
		if (out==null) {
			assertEquals(expected, out);
		} else {
			assertEquals(expected, out.toString());
		}
	}
	
}
