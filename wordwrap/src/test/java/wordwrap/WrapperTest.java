package wordwrap;

import static org.junit.Assert.*;

import org.junit.Test;

public class WrapperTest {

	@Test
	public void shouldNotWrap() {
		assertEquals("foobar", Wrapper.wrap("foobar", 10));
		assertEquals("barfoo", Wrapper.wrap("barfoo", 10));
	}
	
	@Test
	public void shouldWrapTwoWords() {
		assertEquals("two\nwords", Wrapper.wrap("two words", 5));
	}
	
	@Test
	public void shouldNotWrapTwoWords() {
		assertEquals("two words", Wrapper.wrap("two words", 10));
	}
	
	@Test
	public void shouldWrapTooLongWord() {
		assertEquals("toolongwor\nd", Wrapper.wrap("toolongword", 10));
	}
	
	@Test
	public void shouldWrapTwice() {
		assertEquals("too\nlon\ng", Wrapper.wrap("toolong", 3));
	}
	
	@Test
	public void shouldNotWrapAllSpaces() {
		assertEquals("one two\nthree", Wrapper.wrap("one two three", 8));
	}
	
	@Test
	public void shouldWrapOnSpaceAndLongWord() {
		assertEquals("one\nlong\nword", Wrapper.wrap("one longword", 4));
	}
	
	@Test
	public void shouldWrapFullSentenceCorrectly() {
		assertEquals("Pizza\nbesti\nlling\nfra\nDolly\nDimpl\nes", Wrapper.wrap("Pizza bestilling fra Dolly Dimples", 5));
		assertEquals("Pizza\nbesti\nlling\nfra\nDolly\nDimpl\nes", Wrapper.wrap("Pizzabestilling fra Dolly Dimples", 5));
	}	
	
	@Test
	public void shouldHandleLeadingSpaces() {
		assertEquals("one\ntwo", Wrapper.wrap("     one       two     ", 3));
		assertEquals("on\ne\ntw\no", Wrapper.wrap("     one       two     ", 2));
	}
	
	@Test
	public void shouldWrapWithWidthOfOne() {
		assertEquals("o\nn\ne\nt\nw\no", Wrapper.wrap("one two", 1));
	}
	
	@Test
	public void shouldFail() {
		assertNotSame("on\ne\ntwo", Wrapper.wrap("on\ne\rtwo", 3));
	}
	
}
