package com.codiform.moo;

import junit.framework.Assert;

import org.junit.Test;

import com.codiform.moo.curry.Update;

/**
 * A test for the simple cases of update.
 * 
 * <p>There are lots of ugly edge cases in update; it might be best to simply suggest that you stay
 * away from update except in simple cases, rather than attempt to handle all the ugly possibilities.<p>
 */
public class SimpleUpdateTest {

	/**
	 * Can update instance values on an instance; this is pure reflection, not taking Translation into account yet.
	 */
	@Test
	public void testCanUpdateInstanceValues() {
		Ordinal ordinal = new Ordinal(1, "First");
		Assert.assertEquals(1, ordinal.getRank());
		Assert.assertEquals("First", ordinal.getName());

		OrdinalDto dto = new OrdinalDto(2, "Second");
		Update.from(dto).to(ordinal);
		Assert.assertEquals(2, ordinal.getRank());
		Assert.assertEquals("Second", ordinal.getName());
	}

	public static class OrdinalDto {
		private int rank;
		private String name;

		public OrdinalDto(int rank, String name) {
			this.rank = rank;
			this.name = name;
		}

		public int getRank() {
			return rank;
		}

		public String getName() {
			return name;
		}
	}

	public static class Ordinal {
		private int rank;
		private String name;

		public Ordinal(int rank, String name) {
			this.rank = rank;
			this.name = name;
		}

		public int getRank() {
			return rank;
		}

		public String getName() {
			return name;
		}
	}
}
