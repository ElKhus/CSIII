import java.util.List;
import java.util.ArrayList;

public class Runner
{

    public static void main(String[] args)
    {
        simpleGraph();
        testRoyalFamily();
        familyTree();

    }

    private static void simpleGraph()
    {
        System.out.println("*** Simple Graph *** ");

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

        System.out.println("Depth First Search: ");
        for (int i = 0; i< dfsResults.size(); i++)
        {
            System.out.print(dfsResults.get(i));
        }

        System.out.println("\nBreadth First Search: ");
        for (int i = 0; i< bfsResults.size(); i++)
        {
            System.out.print(bfsResults.get(i));
        }   
        System.out.println(" ");
    }

    private static void testRoyalFamily()
    {
        System.out.println("\n*** British Royal Family *** ");

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

        System.out.println("Depth First Search: ");
        for (int i = 0; i< dfsResults.size(); i++)
        {
            if (i == dfsResults.size() -1)
                System.out.print(dfsResults.get(i) + " ");
            else
                System.out.print(dfsResults.get(i) + ",  ");
        }

        System.out.println("\nBredth First Search: ");
        for (int i = 0; i< bfsResults.size(); i++)
        {
            if (i == bfsResults.size() -1)
                System.out.print(bfsResults.get(i) + " ");
            else
                System.out.print(bfsResults.get(i) + ",  ");
        }
        System.out.println(" ");
    }

    private static void familyTree()
    {
        System.out.println("\n*** Family Tree *** ");

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

        System.out.println("Depth First Search: ");
        for (int i = 0; i< dfsResults.size(); i++)
        {
            if (i == dfsResults.size() -1)
                System.out.print(dfsResults.get(i) + " ");
            else
                System.out.print(dfsResults.get(i) + ",  ");
        }

        System.out.println("\nBreadth First Search: ");
        for (int i = 0; i< bfsResults.size(); i++)
        {
            if (i == bfsResults.size() -1)
                System.out.print(bfsResults.get(i) + " ");
            else
                System.out.print(bfsResults.get(i) + ",  ");
        }
        System.out.println(" ");
    }

}
