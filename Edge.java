
import java.util.TreeSet;
import java.util.Vector;
import java.util.HashSet;

class Edge implements Comparable<Edge>
{
	protected Edge [][] edgeArray= new Edge [26][26];
	private int rows=0;
	private int columns=0;
	String vertexA="";
	String vertexB="";
    int weight;

    public Edge(String string, String string2, int weight)
    {
        this.vertexA = string;
        this.vertexB = string2;
        this.weight = weight;
    }
    public Edge(){
    	
    }
    public int getRows()
    {
        return rows;
    }
    public int getColumns()
    {
        return columns;
    }
    public String getVertexA()
    {
        return   vertexA ;
    }
    public String getVertexB()
    {
    	return  vertexB ;
    }
    public int getWeight()
    {
        return weight;
    }
    /*public void addEdge(String vertexA,String vertexB, int weight){
		
		if(columns<=rows){
		edgeArray[rows][columns]=new Edge(vertexA,vertexB,weight);
		columns++;
		}
		else{
			edgeArray[rows][columns]=new Edge(vertexA,vertexB,weight);
			rows++;
		}
		

	}*/
   
   
    public String toString()
    {
    	return vertexA + vertexB ;
    			//" : Weight = " + weight ;
    }
    public int compareTo(Edge edge)
    {
    	//== is not compared so that duplicate values are not eliminated. 
    	return (this.weight < edge.weight) ? -1: 1;
    }
}
