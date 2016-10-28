package net.minis.bdd.sit;

import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
public class _TestCaseRunner {

	public static void main(String[] args) {
		JUnitCore.runClasses(_TestCaseRunner.class);
	}

}
