package cracking.stringarrays;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;


public class CompressionTest {

	private Compression compression = new Compression();
	
	@Test
	public void compressBasic(){
		assertThat(compression.compress("aabcccccaaa"), is("a2b1c5a3"));
		assertThat(compression.compress("ab"), is("ab"));
		assertThat(compression.compress("a"), is("a"));
		assertThat(compression.compress("aaaaaaaaaaaaaa"), is("a14"));
		assertThat(compression.compress("rrrrttukk"), is("r4t2u1k2"));
	}

	@Test
	public void compressBasicBad(){
		assertThat(compression.compressBad("aabcccccaaa"), is("a2b1c5a3"));
		//assertThat(compression.compressBad("ab"), is("ab"));
		//assertThat(compression.compressBad("a"), is("a"));
		assertThat(compression.compressBad("aaaaaaaaaaaaaa"), is("a14"));
		//assertThat(compression.compressBad("rrrrttukk"), is("r4t2u1k2"));
	}

	@Test
	public void compressBetter(){
		assertThat(compression.compressBetter("aabcccccaaa"), is("a2b1c5a3"));
		assertThat(compression.compressBetter("aaaaaaaaaaaaaa"), is("a14"));
	}

	@Test
	public void compressAlternate(){
		assertThat(compression.compressAlternate("aabcccccaaa"), is("a2b1c5a3"));
		assertThat(compression.compressAlternate("aaaaaaaaaaaaaa"), is("a14"));
	}
}
