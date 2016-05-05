
import java.util.TreeSet;
import java.util.Vector;
import java.util.HashSet;




class KruskalEdges
{
	
    Vector<HashSet<String>> vertexGroups = new Vector<HashSet<String>>();
    TreeSet<Edge> kruskalEdges = new TreeSet<Edge>();

    public TreeSet<Edge> getEdges()
    {
        return kruskalEdges;
    }
    HashSet<String> getVertexGroup(String vertex)
    {
        for (HashSet<String> vertexGroup : vertexGroups) {
            if (vertexGroup.contains(vertex)) {
                return vertexGroup;
            }
        }
        return null;
    }

    /**
     * The edge to be inserted has 2 vertices - A and B
     * We maintain a vector that contains groups of vertices.
     * We first check if either A or B exists in any group
     * If neither A nor B exists in any group
     *     We create a new group containing both the vertices.
     * If one of the vertices exists in a group and the other does not
     *     We add the vertex that does not exist to the group of the other vertex
     * If both vertices exist in different groups
     *     We merge the two groups into one
     * All of the above scenarios mean that the edge is a valid Kruskal edge
     * In that scenario, we will add the edge to the Kruskal edges    
     * However, if both vertices exist in the same group
     *     We do not consider the edge as a valid Kruskal edge
     */
    public void insertEdge(Edge edge)
    {
        String vertexA = edge.getVertexA();
        String vertexB = edge.getVertexB();

        HashSet<String> vertexGroupA = getVertexGroup(vertexA);
        HashSet<String> vertexGroupB = getVertexGroup(vertexB);

        if (vertexGroupA == null) {
            kruskalEdges.add(edge);
            if (vertexGroupB == null) {
                HashSet<String> htNewVertexGroup = new HashSet<String>();
                htNewVertexGroup.add(vertexA);
                htNewVertexGroup.add(vertexB);
                vertexGroups.add(htNewVertexGroup);
            }
            else {
                vertexGroupB.add(vertexA);        	
            }
        }
        else {
            if (vertexGroupB == null) {
                vertexGroupA.add(vertexB);
                kruskalEdges.add(edge);
            }
            else if (vertexGroupA != vertexGroupB) {
                vertexGroupA.addAll(vertexGroupB);
                vertexGroups.remove(vertexGroupB);
                kruskalEdges.add(edge);
            }
        }
    }
}

