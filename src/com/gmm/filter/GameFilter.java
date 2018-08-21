package com.gmm.filter;

import java.nio.charset.Charset;

//google's library
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

// Class using Bloom filter 
public class GameFilter {
	BloomFilter<String> nameFilter;

	public GameFilter() {
		buildBloomFilter();
	}

	private void buildBloomFilter() { // creating bloomfilters with max of 10 values with 0.01 error rate
		this.nameFilter = BloomFilter.create(Funnels.stringFunnel(Charset.defaultCharset()), 10, 0.01);

		/*
		 * The bloom filter can be constructed from seperate connection to database or
		 * from file Here, for simplicity, the values are hard feeded to the filter
		 */
		this.nameFilter.put("skyrim".toUpperCase());
		this.nameFilter.put("Dota 2".toUpperCase());
		this.nameFilter.put("Injustice 2".toUpperCase());
		this.nameFilter.put("Final fantasy xv".toUpperCase());
		this.nameFilter.put("warcraft 3".toUpperCase());
		this.nameFilter.put("claw".toUpperCase());
	}

	//to check for name values before accessing the database
	public boolean mightContain(String name) {
		if (this.nameFilter.mightContain(name.toUpperCase()))
			return true;
		else
			return false;
	}
}
