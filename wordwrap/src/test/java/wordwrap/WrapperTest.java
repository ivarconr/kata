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

    @Test
	public void finalTest() {
        String textToWrap =  "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec pellentesque elementum mattis. Donec sit amet risus sed turpis tempor laoreet a eget ligula. Aliquam tempor vehicula urna id posuere. Integer sed mi eu orci volutpat ullamcorper eu eget nibh. Integer eu erat metus, ut dignissim quam. Pellentesque eu erat eu neque commodo vulputate eu ac ligula. Donec ornare volutpat est, quis viverra neque consequat a. Duis magna odio, aliquet congue placerat non, posuere pellentesque mauris. Quisque pretium, massa non scelerisque feugiat, nisl lorem pretium diam, scelerisque gravida elit diam eget eros. Donec nisi mauris, rhoncus non varius sit amet, dapibus in diam. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum adipiscing, est non aliquet cursus, lorem justo auctor elit, vel cursus sem quam eu arcu. Sed a volutpat eros.";

        String expected = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec pellentesque\n" +
                "elementum mattis. Donec sit amet risus sed turpis tempor laoreet a eget ligula.\n" +
                "Aliquam tempor vehicula urna id posuere. Integer sed mi eu orci volutpat\n" +
                "ullamcorper eu eget nibh. Integer eu erat metus, ut dignissim quam.\n" +
                "Pellentesque eu erat eu neque commodo vulputate eu ac ligula. Donec ornare\n" +
                "volutpat est, quis viverra neque consequat a. Duis magna odio, aliquet congue\n" +
                "placerat non, posuere pellentesque mauris. Quisque pretium, massa non\n" +
                "scelerisque feugiat, nisl lorem pretium diam, scelerisque gravida elit diam\n" +
                "eget eros. Donec nisi mauris, rhoncus non varius sit amet, dapibus in diam.\n" +
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum adipiscing,\n" +
                "est non aliquet cursus, lorem justo auctor elit, vel cursus sem quam eu arcu.\n" +
                "Sed a volutpat eros.";

		assertEquals(expected, Wrapper.wrap(textToWrap, 80));
	}
	
}
