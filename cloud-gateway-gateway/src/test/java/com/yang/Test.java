package com.yang;

import java.time.ZonedDateTime;

public class Test {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		ZonedDateTime now = ZonedDateTime.now();
		System.err.println(now);
	}
}
