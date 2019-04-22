import junit.framework.*; 
import java.util.*;

public class Lab31Tester extends TestCase
{
    public void testCircleGraph()
    {
        AdjacencyListGraph<String> g = new AdjacencyListGraph<String>();
        g.add("A");
        g.add("B");
        g.add("C");
        g.add("D");
        g.add("E");

        g.addEdge("A", "B");
        g.addEdge("B", "C");
        g.addEdge("C", "D");
        g.addEdge("D", "E");
        g.addEdge("E", "A");

        SearchAlgrorithms<String> search = new SearchAlgrorithms<String>(g);
        List<String> dfsResults = search.depthFirstSearch("A");
        List<String> bfsResults = search.breadthFirstSearch("A");

        assertEquals("", "[A, B, C, D, E]", dfsResults.toString());
        assertEquals("", "[A, B, C, D, E]", bfsResults.toString());
    }

    public void testDisconnectedGraph()
    {
        AdjacencyListGraph<Integer> g = new AdjacencyListGraph<Integer>();
        g.add(0);
        g.add(1);
        g.add(2);
        g.add(3);
        g.add(4);
        g.add(5);
        g.add(6);
        g.add(7);
        g.add(8);

        g.addEdge(0, 1);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(1, 2);
        g.addEdge(3, 4);

        g.addEdge(7, 6);
        g.addEdge(6, 7);
        g.addEdge(6, 8);
        g.addEdge(8, 6);

        SearchAlgrorithms<Integer> search = new SearchAlgrorithms<Integer>(g);
        List<String> dfsResults = search.depthFirstSearch(0);
        List<String> bfsResults = search.breadthFirstSearch(0);

        assertEquals("", "[0, 1, 2, 3, 4]", dfsResults.toString());
        assertEquals("", "[0, 1, 2, 3, 4]", bfsResults.toString());

        search = new SearchAlgrorithms<Integer>(g);
        dfsResults = search.depthFirstSearch(6);
        bfsResults = search.breadthFirstSearch(6);

        assertEquals("", "[6, 7, 8]", dfsResults.toString());
        assertEquals("", "[6, 7, 8]", bfsResults.toString());
    }

    public void testGraph12NodesDFS()
    {
        AdjacencyListGraph<Integer> g = new AdjacencyListGraph<Integer>();
        g.add(0);
        g.add(1);
        g.add(2);
        g.add(3);
        g.add(4);
        g.add(5);
        g.add(6);
        g.add(7);
        g.add(8);
        g.add(9);
        g.add(10);
        g.add(11);
        g.add(12);

        g.addEdge(0, 1);
        g.addEdge(1, 0);
        g.addEdge(1, 2);
        g.addEdge(2, 1);
        g.addEdge(1, 5);
        g.addEdge(5, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 2);
        g.addEdge(2, 6);
        g.addEdge(6, 2);
        g.addEdge(6, 11);
        g.addEdge(11, 6);
        g.addEdge(6, 5);
        g.addEdge(5, 6);
        g.addEdge(3, 7);
        g.addEdge(7, 3);
        g.addEdge(7, 12);
        g.addEdge(12, 7);
        g.addEdge(11, 12);
        g.addEdge(12, 11);
        g.addEdge(11, 10);
        g.addEdge(10, 11);
        g.addEdge(10, 5);
        g.addEdge(5, 10);
        g.addEdge(10, 9);
        g.addEdge(9, 10);
        g.addEdge(9, 8);
        g.addEdge(8, 9);
        g.addEdge(8, 4);
        g.addEdge(4, 8);
        g.addEdge(0, 4);
        g.addEdge(4, 0);

        SearchAlgrorithms<Integer> search = new SearchAlgrorithms<Integer>(g);
        List<Integer> dfsResults = search.depthFirstSearch(0);
        List<Integer> bfsResults = search.breadthFirstSearch(0);

        assertEquals("", "[0, 1, 2, 3, 7, 12, 11, 6, 5, 10, 9, 8, 4]", dfsResults.toString());
    }

    public void testGraph12NodesBFS()
    {
        AdjacencyListGraph<Integer> g = new AdjacencyListGraph<Integer>();
        g.add(0);
        g.add(1);
        g.add(2);
        g.add(3);
        g.add(4);
        g.add(5);
        g.add(6);
        g.add(7);
        g.add(8);
        g.add(9);
        g.add(10);
        g.add(11);
        g.add(12);

        g.addEdge(0, 1);
        g.addEdge(1, 0);
        g.addEdge(1, 2);
        g.addEdge(2, 1);
        g.addEdge(1, 5);
        g.addEdge(5, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 2);
        g.addEdge(2, 6);
        g.addEdge(6, 2);
        g.addEdge(6, 11);
        g.addEdge(11, 6);
        g.addEdge(6, 5);
        g.addEdge(5, 6);
        g.addEdge(3, 7);
        g.addEdge(7, 3);
        g.addEdge(7, 12);
        g.addEdge(12, 7);
        g.addEdge(11, 12);
        g.addEdge(12, 11);
        g.addEdge(11, 10);
        g.addEdge(10, 11);
        g.addEdge(10, 5);
        g.addEdge(5, 10);
        g.addEdge(10, 9);
        g.addEdge(9, 10);
        g.addEdge(9, 8);
        g.addEdge(8, 9);
        g.addEdge(8, 4);
        g.addEdge(4, 8);
        g.addEdge(0, 4);
        g.addEdge(4, 0);

        SearchAlgrorithms<Integer> search = new SearchAlgrorithms<Integer>(g);
        List<Integer> dfsResults = search.depthFirstSearch(0);
        List<Integer> bfsResults = search.breadthFirstSearch(0);

        assertEquals("", "[0, 1, 4, 2, 5, 8, 3, 6, 10, 9, 7, 11, 12]", bfsResults.toString());
    }

    public void testGraph49()
    {
        AdjacencyListGraph<String> g = new AdjacencyListGraph<String>();
        g.add("1");
        g.add("2");
        g.add("3");
        g.add("4");
        g.add("6");
        g.add("0");
        g.add("7");

        g.addEdge("0", "1");
        g.addEdge("1", "3");
        g.addEdge("3", "2");
        g.addEdge("2", "1");
        g.addEdge("3", "4");
        g.addEdge("4", "5");
        g.addEdge("5", "7");
        g.addEdge("7", "6");
        g.addEdge("6", "4");

        SearchAlgrorithms<String> search = new SearchAlgrorithms<String>(g);
        List<String> dfsResults = search.depthFirstSearch("0");
        List<String> bfsResults = search.breadthFirstSearch("0");

        assertEquals("", "[0, 1, 3, 2, 4, 5, 7, 6]", dfsResults.toString());
        assertEquals("", "[0, 1, 3, 2, 4, 5, 7, 6]", bfsResults.toString());
    }

    public void testGraph417()
    {
        AdjacencyListGraph<Integer> g = new AdjacencyListGraph<Integer>();
        g.add(0);
        g.add(1);
        g.add(2);
        g.add(3);
        g.add(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(1, 4);
        g.addEdge(1, 3);
        g.addEdge(3, 4);
        g.addEdge(2, 4);

        SearchAlgrorithms<Integer> search = new SearchAlgrorithms<Integer>(g);
        List<Integer> dfsResults = search.depthFirstSearch(0);
        List<Integer> bfsResults = search.breadthFirstSearch(0);

        assertEquals("", "[0, 1, 3, 4, 2]", dfsResults.toString());
        assertEquals("", "[0, 1, 2, 3, 4]", bfsResults.toString());
    }

    public void testFamilyTree()
    {
        AdjacencyListGraph<String> g = new AdjacencyListGraph<String>();
        g.add("Anakin");
        g.add("Luke");
        g.add("Leia");
        g.add("Ben");
        g.add("Tom Brady");
        g.add("Bill Belichick");

        g.addEdge("Anakin", "Luke");
        g.addEdge("Anakin", "Leia");
        g.addEdge("Luke", "Bill Belichick");
        g.addEdge("Leia", "Ben");
        g.addEdge("Luke", "Tom Brady"); 

        SearchAlgrorithms<String> search = new SearchAlgrorithms<String>(g);
        List<String> dfsResults = search.depthFirstSearch("Anakin");
        List<String> bfsResults = search.breadthFirstSearch("Anakin");

        assertEquals("", "[Anakin, Leia, Ben, Luke, Bill Belichick, Tom Brady]", dfsResults.toString());
        assertEquals("", "[Anakin, Leia, Luke, Ben, Bill Belichick, Tom Brady]", bfsResults.toString());
    }

    public void testRoyalFamily()
    {
        AdjacencyListGraph<String> g = new AdjacencyListGraph<String>();
        g.add("King George VI");
        g.add("Princess Margaret");
        g.add("David, Viscount Linley");
        g.add("Lady Sarah");
        g.add("Samuel Chatto");
        g.add("Arthur Chatto");
        g.add("Charles Armstrong-Jones");
        g.add("Margarita Armstrong-Jones");
        g.add("Queen Elizabeth II");
        g.add("Charles, Prince of Wales");
        g.add("Prince William of Wales");
        g.add("Prince George of Cambridge");
        g.add("Prince Harry of Wales");
        g.add("Anne, Princess Royal");
        g.add("Peter Phillips");
        g.add("Savannah Phillips");
        g.add("Isla Phillips");
        g.add("Zara Tindall");
        g.add("Andrew, Duke of York");
        g.add("Princess Beatrice of York");
        g.add("Princess Eugenie of York");
        g.add("Edward, Earl of Wessex");
        g.add("Lady Louise Windsor");
        g.add("James, Viscount Severn");      

        g.addEdge("King George VI", "Princess Margaret");
        g.addEdge("King George VI", "Queen Elizabeth II");
        g.addEdge("Princess Margaret", "David, Viscount Linley");
        g.addEdge("Princess Margaret", "Lady Sarah");
        g.addEdge("Lady Sarah", "Arthur Chatto"); 
        g.addEdge("Lady Sarah", "Samuel Chatto");
        g.addEdge("David, Viscount Linley", "Charles Armstrong-Jones");
        g.addEdge("David, Viscount Linley", "Margarita Armstrong-Jones");
        g.addEdge("Queen Elizabeth II", "Charles, Prince of Wales");
        g.addEdge("Queen Elizabeth II", "Anne, Princess Royal");
        g.addEdge("Queen Elizabeth II", "Andrew, Duke of York");
        g.addEdge("Queen Elizabeth II", "Earl of Wessex");
        g.addEdge("Charles, Prince of Wales", "Prince William of Wales");
        g.addEdge("Charles, Prince of Wales", "Prince Harry of Wales");
        g.addEdge("Prince William of Wales", "Prince George of Cambridge");
        g.addEdge("Anne, Princess Royal", "Peter Phillips");
        g.addEdge("Anne, Princess Royal", "Zara Tindall");
        g.addEdge("Peter Phillips", "Savannah Phillips");
        g.addEdge("Peter Phillips", "Isla Phillips");
        g.addEdge("Leia", "Ben");
        g.addEdge("Peter Phillips ", "Ben");        
        g.addEdge("Andrew, Duke of York", "Princess Beatrice of York");
        g.addEdge("Andrew, Duke of York", "Princess Eugenie of York");
        g.addEdge("Earl of Wessex", "Lady Louise Windsor");
        g.addEdge("Earl of Wessex", "James, Viscount Severn");

        SearchAlgrorithms<String> search = new SearchAlgrorithms<String>(g);
        List<String> dfsResults = search.depthFirstSearch("Queen Elizabeth II");
        List<String> bfsResults = search.breadthFirstSearch("Queen Elizabeth II");
        
        assertEquals("", "[Queen Elizabeth II, Andrew, Duke of York, Princess Beatrice of York, Princess Eugenie of York, Anne, Princess Royal, Peter Phillips, Isla Phillips, Savannah Phillips, Zara Tindall, Charles, Prince of Wales, Prince Harry of Wales, Prince William of Wales, Prince George of Cambridge]", dfsResults.toString());
        assertEquals("", "[Queen Elizabeth II, Andrew, Duke of York, Anne, Princess Royal, Charles, Prince of Wales, Princess Beatrice of York, Princess Eugenie of York, Peter Phillips, Zara Tindall, Prince Harry of Wales, Prince William of Wales, Isla Phillips, Savannah Phillips, Prince George of Cambridge]", bfsResults.toString());
        
        dfsResults = search.depthFirstSearch("King George VI");
        bfsResults = search.breadthFirstSearch("King George VI");

        assertEquals("", "[King George VI, Princess Margaret, David, Viscount Linley, Charles Armstrong-Jones, Margarita Armstrong-Jones, Lady Sarah, Arthur Chatto, Samuel Chatto, Queen Elizabeth II, Andrew, Duke of York, Princess Beatrice of York, Princess Eugenie of York, Anne, Princess Royal, Peter Phillips, Isla Phillips, Savannah Phillips, Zara Tindall, Charles, Prince of Wales, Prince Harry of Wales, Prince William of Wales, Prince George of Cambridge]", dfsResults.toString());
        assertEquals("", "[King George VI, Princess Margaret, Queen Elizabeth II, David, Viscount Linley, Lady Sarah, Andrew, Duke of York, Anne, Princess Royal, Charles, Prince of Wales, Charles Armstrong-Jones, Margarita Armstrong-Jones, Arthur Chatto, Samuel Chatto, Princess Beatrice of York, Princess Eugenie of York, Peter Phillips, Zara Tindall, Prince Harry of Wales, Prince William of Wales, Isla Phillips, Savannah Phillips, Prince George of Cambridge]", bfsResults.toString());
    }
}