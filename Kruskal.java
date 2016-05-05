

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.TreeSet;

import javax.swing.JOptionPane;

public class Kruskal
{
	
	static TreeSet<Edge> edges = new TreeSet<Edge>(); //create an array of objects which hold the edges
	//create an string object intialized alphabetically
	static String [] strConstant= new String []{"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};	
	//this hold the name of the imput file put by the user
	String input_File="";
	//this helps to input the name of the file from the user
	JOptionPane pane=new JOptionPane();
	
	
	public Kruskal(){
		
		
	}
	public String getInputFileName(){
		Kruskal k=new Kruskal();
		
		 k.readInGraphData();
		 return input_File;
		
	}
	 public void readInGraphData() {
		    
		 
	
		 	String input_File="";
		 	int vertexFrom=0;
		 	int vertexto=0;
		 	int value = 0;
			//String temp="";
			String [] tempArray =null;
			
			
			
			input_File=pane.showInputDialog("Please Enter a Text File!");
			
			try {
				
				BufferedReader reader=new BufferedReader(new FileReader(input_File));
				String line=null;
				String input = "";
				

				
				
				while((line=reader.readLine())!=null){

					line=reader.readLine();
							
							String temp=line;
							//System.out.println(line+"hello");
							tempArray=temp.split("\\s");
					
							//StringTokenizer stringTokenizer = new StringTokenizer(temp, " ");
							for (int i=0;i<=tempArray.length;i++) 
			                {   
								
			                    if(!(tempArray[i].isEmpty()) )
			                    {
			                       // if(vertexFrom<1){
			                    	value = Integer.valueOf(tempArray[i].trim());
			                        
			                        //System.out.println(s);
			                        //else value = Integer.parseInt(tempArray[i].trim());
			                   //}
			                  
			                    
			                   
			                   
			                    	Edge edge1= new Edge(strConstant[vertexFrom],strConstant[vertexto],value);
			                    	edges.add(edge1);
			                    	
			                    	System.out.println("edge:" + edge1 + " "+  vertexFrom +" " +vertexto);
			                    	System.out.println(value);
			                    	vertexto++;
			                    }
			                    
			                   
			                   //System.out.println(tempArray[i+1]);
			                   //System.out.println(vertexto);
			                    //ke.insertEdge(edge1);
			                    //edge1.addEdge(String.valueOf(vertexfrom),String.valueOf(vertexto),value);
			                   // vertexto++;
							//for(int i=0;i<tempArray.length;i++){
								//value=Integer.valueOf(tempArray[i]);
								//System.out.println(value);
								//
								//
								
							}
							//System.out.println(vertexFrom);
							vertexFrom++;
							vertexto=0;
				}
				reader.close();
				}
							//System.out.println(vertexFrom);
				
				
			
							catch (IOException e) {
						    	System.out.println("File not found!");
						        //
						      }
							//vertexfrom++;
							//vertexto='A';
						//}
				
				//for(int i=0;i<edge1.edgeArray.length;i++){
				// for (Edge edge : edges) {
						//System.out.println(edge.toString());
					//}
			}
    public static void main(String[] args) throws IOException
    {
    	String tempKruskal="";
    	//InputFile a= new InputFile();
		//a.readInGraphData();
        //TreeSet is used to sort the edges before passing to the algorithm
        //TreeSet<Edge> edges = new TreeSet<Edge>();
        


        Kruskal krus=new Kruskal();
        krus.readInGraphData();
        //edges.add(krus.readInGraphData());
        
        //for(int i=0;i<tempEdge.getRows();i++){
        	//for (int j=0;j<tempEdge.getColumns();j++){
        		
        		//System.out.println(tempEdge.edgeArray.toString() + " ");
        	//}
       // }

        System.out.println("Graph");
        KruskalEdges vv = new KruskalEdges();

        for (Edge edge : edges) {
            //System.out.println(edge);
            vv.insertEdge(edge);
        }
       
        File fout = new File("Graph1MST.txt");
    	FileOutputStream fos = new FileOutputStream(fout);
       // }
        try {
        	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
			for (Edge edge : vv.getEdges()) {
		          try {
					bw.write(edge.toString() );
					bw.newLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			bw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        

        System.out.println("Kruskal algorithm");
        int total = 0;
        for (Edge edge : vv.getEdges()) {
           //System.out.println(edge);
        	tempKruskal+=edge.toString() + "/n";
            total += edge.getWeight();
            
        }
        System.out.println("Total weight is " + tempKruskal);
    }
}
