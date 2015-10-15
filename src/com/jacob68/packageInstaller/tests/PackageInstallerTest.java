package com.jacob68.packageInstaller.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;

import org.junit.Test;

import com.jacob68.packageInstaller.Node;
import com.jacob68.packageInstaller.PackageInstaller;

/**
 * Test class that runs JUnit tests on the {@linkplain PackageInstaller} class
 * methods.
 * 
 * @author Jacobus LaFazia
 */
public class PackageInstallerTest {

	/**
	 * Runs list size tests on the convertPackagesToNodes() method for all valid
	 * test arrays.
	 */
	@Test
	public void inputOutputListSizesOnConvertPackagesShouldMatch() {
		PackageInstaller installer = new PackageInstaller();

		System.out.print("\nSTART--Convert Packages List Sizes Test--");

		for (int i = 0; i < 4; i++) {
			// Get input package list
			String[] input;
			switch (i) {
			case 0:
				input = TestHelper.getValidSimpleSmall();
				System.out.print("\n------Test: Simple Small------");
				break;
			case 1:
				input = TestHelper.getValidSimpleLarge();
				System.out.print("\n------Test: Simple Large------");
				break;
			case 2:
				input = TestHelper.getValidSmall();
				System.out.print("\n------Test: Small------");
				break;
			default:
				input = TestHelper.getValidLarge();
				System.out.print("\n------Test: Large------");
				break;
			}
			// Print out the input
			System.out.print("\nInput: "
					+ TestHelper.convertArrayToString(input));

			// Convert package list to node list
			installer.convertPackagesToNodes(input);
			ArrayList<Node> nodes = installer.getNodes();
			// Print out the nodes list
			System.out.print("\nOutput: "
					+ TestHelper.convertNodeListToString(nodes, true));

			// Print pass or fail
			if (input.length == nodes.size()) {
				System.out.print("\n    PASSED");

			} else {
				System.out.print("\n    FAIL");
				System.out.print("\nEND\n");
			}

			assertEquals("Input list size (" + input.length
					+ ") must equal output list size (" + nodes.size() + ")",
					input.length, nodes.size());
		}

		System.out.print("\nEND\n");
	}

	/**
	 * Runs list size tests on the computeDependencies() method for all valid
	 * test arrays.
	 */
	@Test
	public void inputOutputListSizesOnComputeDependenciesShouldMatch() {
		PackageInstaller installer = new PackageInstaller();

		System.out.print("\nSTART--Compute Dependencies List Sizes Test--");

		for (int i = 0; i < 4; i++) {
			// Get input package list
			String[] input;
			switch (i) {
			case 0:
				input = TestHelper.getValidSimpleSmall();
				System.out.print("\n------Test: Simple Small------");
				break;
			case 1:
				input = TestHelper.getValidSimpleLarge();
				System.out.print("\n------Test: Simple Large------");
				break;
			case 2:
				input = TestHelper.getValidSmall();
				System.out.print("\n------Test: Small------");
				break;
			default:
				input = TestHelper.getValidLarge();
				System.out.print("\n------Test: Large------");
				break;
			}
			// Print out the input
			System.out.print("\nInput: "
					+ TestHelper.convertArrayToString(input));

			// Convert package list to node list
			installer.convertPackagesToNodes(input);

			// Compute dependency list
			ArrayList<Node> resolved = installer.computeDependencies(installer
					.getNodes());
			// Print out the output
			System.out.print("\nOutput: "
					+ TestHelper.convertNodeListToString(resolved, false));

			// Print pass or fail
			if (input.length == resolved.size()) {
				System.out.print("\n    PASSED");

			} else {
				System.out.print("\n    FAIL");
				System.out.print("\nEND\n");
			}

			assertEquals(
					"Input list size (" + input.length
							+ ") must equal output list size ("
							+ resolved.size() + ")", input.length,
					resolved.size());
		}

		System.out.print("\nEND\n");
	}

	@Test
	public void packageListsShouldBeValid() {
		PackageInstaller installer = new PackageInstaller();

		System.out.print("\nSTART--Valid Package Lists Test--");

		for (int i = 0; i < 4; i++) {
			// Get input package list
			String[] input;
			switch (i) {
			case 0:
				input = TestHelper.getValidSimpleSmall();
				System.out.print("\n------Test: Simple Small------");
				break;
			case 1:
				input = TestHelper.getValidSimpleLarge();
				System.out.print("\n------Test: Simple Large------");
				break;
			case 2:
				input = TestHelper.getValidSmall();
				System.out.print("\n------Test: Small------");
				break;
			default:
				input = TestHelper.getValidLarge();
				System.out.print("\n------Test: Large------");
				break;
			}
			// Print out the input
			System.out.print("\nInput: "
					+ TestHelper.convertArrayToString(input));

			// Convert package list to node list
			installer.convertPackagesToNodes(input);

			// Compute dependency list
			ArrayList<Node> resolved = installer.computeDependencies(installer
					.getNodes());

			// Print pass or fail
			if (resolved != null) {
				// Print out the output
				System.out.print("\nOutput: "
						+ TestHelper.convertNodeListToString(resolved, false));
				System.out.print("\n    PASSED");

			} else {
				System.out.print("\nOutput: NULL");
				// TODO get error message from PackageInstaller
				System.out.print("\n    FAIL");
				System.out.print("\nEND\n");
			}

			assertNotNull("Package list " + input.toString()
					+ " should generate a Non-Null dependency list", resolved);
		}

		System.out.print("\nEND\n");
	}

	@Test
	public void packageListsShouldBeCyclic() {
		PackageInstaller installer = new PackageInstaller();

		System.out.print("\nSTART--Cyclic Package Lists Test--");

		for (int i = 0; i < 4; i++) {
			// Get input package list
			String[] input;
			switch (i) {
			case 0:
				input = TestHelper.getCyclicSimpleSmall();
				System.out.print("\n------Test: Simple Small------");
				break;
			case 1:
				input = TestHelper.getCyclicSimpleLarge();
				System.out.print("\n------Test: Simple Large------");
				break;
			case 2:
				input = TestHelper.getCyclicSmall();
				System.out.print("\n------Test: Small------");
				break;
			default:
				input = TestHelper.getCyclicLarge();
				System.out.print("\n------Test: Large------");
				break;
			}
			// Print out the input
			System.out.print("\nInput: "
					+ TestHelper.convertArrayToString(input));

			// Convert package list to node list
			installer.convertPackagesToNodes(input);

			// Compute dependency list
			ArrayList<Node> resolved = installer.computeDependencies(installer
					.getNodes());

			// Print pass or fail
			if (resolved == null) {
				System.out.print("\nOutput: NULL");
				// TODO get error message from PackageInstaller
				System.out.print("\n    PASSED");

			} else {
				// Print out the output
				System.out.print("\nOutput: "
						+ TestHelper.convertNodeListToString(resolved, false));
				System.out.print("\n    FAIL");
				System.out.print("\nEND\n");
			}

			assertNull("Package list " + input.toString()
					+ " is cyclic and should generate a Null dependency list",
					resolved);
		}

		System.out.print("\nEND\n");
	}

}
