@Test
public void testSubSet() {
    int[] set1 = {1, 2, 3};
    List<List<Integer>> expected1 = new ArrayList<>();
    expected1.add(new ArrayList<>());
    expected1.add(Arrays.asList(1));
    expected1.add(Arrays.asList(2));
    expected1.add(Arrays.asList(3));
    expected1.add(Arrays.asList(1, 2));
    expected1.add(Arrays.asList(1, 3));
    expected1.add(Arrays.asList(2, 3));
    expected1.add(Arrays.asList(1, 2, 3));
    assertEquals(expected1, subSet(set1));

    int[] set2 = {4, 5, 6};
    List<List<Integer>> expected2 = new ArrayList<>();
    expected2.add(new ArrayList<>());
    expected2.add(Arrays.asList(4));
    expected2.add(Arrays.asList(5));
    expected2.add(Arrays.asList(6));
    expected2.add(Arrays.asList(4, 5));
    expected2.add(Arrays.asList(4, 6));
    expected2.add(Arrays.asList(5, 6));
    expected2.add(Arrays.asList(4, 5, 6));
    assertEquals(expected2, subSet(set2));

    int[] set3 = {7};
    List<List<Integer>> expected3 = new ArrayList<>();
    expected3.add(new ArrayList<>());
    expected3.add(Arrays.asList(7));
    assertEquals(expected3, subSet(set3));
}