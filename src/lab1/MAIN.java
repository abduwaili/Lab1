package lab1;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

/**
 * @since  2017/9/05
 * @author °¢¶Å
 * @×¢£ºµ¥´Ê´¦ÀíÍêÒÔºó±ØÐë°´³öÏÖµÄÑ­Ðò·ÅÈë¶ÔÓ¦µÄÈÝÆ÷ÖÐ;
 * lab7提交
 */
public class MAIN 
{
	
	 /**
	 * @±äÁ¿Ãû£ºstring[] word_orginal;
	 * @×÷ÓÃ£º´æ·Å¶ÁÈ¡ÎÄ±¾ÖÐµÄµ¥´Ê
	 * Ïê½â£º
	 *	      ¶ÁÈ¡ÎÄ±¾ºó£¬Ö»ÁôÏÂÎÄ±¾ÖÐµÄÓ¢ÎÄµ¥´Ê²¢È«²¿×ª»»Ð¡Ð´£¬ÔÚ½«Æä°´³öÏÖµÄÑ­Ðò²ð·Ö³Éµ¥´Ê£¬ÒÀ´Î·ÅÈëÊý×éwords_originalÖÐ£¬
	 *	      µ«ÊÇ²¢²»¶ÔÖØ¸´³öÏÖµÄµ¥´Ê½øÐÐ´¦Àí£¬¼´µ¥´Ê"a"³öÏÖÁËÈý´Î£¬ÄÇÃ´¾Í°´ÕÕ³öÏÖµÄÑ­Ðò´æ´¢Èý´Î£¬ËùÒÔwords_originalµÄ³¤¶È
	 *	  µÈÓÚÎÄ±¾µ¥´ÊµÄ×ÛºÏ
	 */	
	public String[] words_original;	//³õÊ¼µÄËùÓÐµ¥´ÊÊý×é,°´¶Á½øÀ´µÄÊý¾ÝÖÐµÄ´ÎÐòÒÀ´Î½«ÎÄÕÂ²ð·Ö³Éµ¥´Ê
	
	public Vector<String> edge=new Vector<>();//¶¥µãÊý×é
	
	/**
	 * @±äÁ¿Ãû£º int vertex;
	 * @×÷ÓÃ£º ¶¥µã¸öÊý
	 * Ïê½â£º
	 * 	  Æä³¤¶ÈµÈÓÚÎÄ±¾ÖÐµ¥´ÊµÄÖÖÀà¸öÊý£»
	 *   ÒÔÏÂÈÝÆ÷£ºedge_weight£¬edge_edge£¬vertex_number£¬number_vertex£¬edge_matrixµÄ³¤¶ÈÈ«²¿µÈÓÚvextex
	 */
	public int vertex;
	
	
	/**
	 * @±äÁ¿Ãû£ºHashMap edge_weight
	 * @×÷ÓÃ£º    ±ßºÍÈ¨ÖØ¼üÖµ¶Ô
	 * Ïê½â£º
	 * 	  Èç¹ûµ¥´ÊAµ½BÓÐÂ·¾¶£¬ÄÇÃ´½« key= "A -> B",value=È¨Öµ£¨¼´"A -> B"³öÏÖµÄ´ÎÊý£©;
	 *   ¿ÉÒÔ°´ÕÕÄ³¸ö±ß"A - >B"È¡³öÆäÈ¨Öµ
	 */
	public Map<String, Integer> edge_weight=new HashMap<String,Integer>();
	
	
		//½«ËùÓÐµÄ±ß¶Ô°´Ë³Ðò±£´æÏÂÀ´£»Èç£º±ßA,B±ä³É "A -> B"·ÅÈëedge_edgeÖÐ(¿ÉÒÔ°´Ñ­Ðò¶Á³öÀ´)
	/**
	 * @±äÁ¿Ãû£ºVector edge_edge
	 * @×÷ÓÃ£º    ´æ·Å±ß
	 * Ïê½â£º      
	 * 	  ½«ËùÓÐ±ß°´ÕÕÔÚÎÄ±¾ÖÐ³öÏÖµÄ´ÎÐò·ÅÈëedge_edgeÖÐ£¬ÈôÄ³Ìõ±ß "A -> B"ÏÈºó³öÏÖÁ½´Î£¬ÄÇÃ´Æð³öÏÖÎ»ÖÃÒÔµÚÒ»´Î³öÏÖµÄÎª×¼
	 */
	public Vector<String> edge_edge=new Vector<String>();
	

	/**
	 * @±äÁ¿Ãû£ºMap vertex_number
	 * @×÷ÓÃ£º ¸ù¾Ý¶¥µãÃû¿ÉÈ¡³öÆð¶ÔÓ¦µÄÊý×Ó£¬Õâ¸öÊý×ÖÃ¿¸ö¶¥µãÊÇÎ¨Ò»µÄ
	 * Ïê½â£º
	 * 	  ¶ÔÎÄ±¾ÖÐµÄÃ¿Ò»¸ö¶¥µã¸ù¾ÝÆð³öÏÖµÄ´ÎÐò¶ÔÓ¦Ò»¸öÊý×ÖÖµ£¬ÒòÎªÁÚ½Ó¾ØÕóÖÐÓÃÊý×ÖÀ´±íÊ¾±ß£»Õâ¸öÊý×ÖÊÇ°´ÕÕ¶¥µãÔÚÎÄ±¾ÖÐ³öÏÖµÄ´ÎÐò´ÓÁãµÝÔöµÄ£»
	 *   ±ÈÈç¶¥µãAºÍBÓÐÂ·¾¶£¬¶¥µãA¶ÔÓ¦Î¨Ò»Ò»¸öÊý×Öi£¬¶¥µãB¶ÔÓ¦Î¨Ò»Ò»¸öÊý×Öj,ÄÇÃ´ÁÚ½Ó¾ØÕóedge_matrix[i][j]µÈÓÚ"A -> B"È¨Öµ;
	 *   number_vertix¿É°´ÕÕÊý×Ö¶ÁÈ¡¶ÔÓ¦µ¥´Ê£»vertex_number¿É°´ÕÕµ¥´Ê¶Á³ö¶ÔÓ¦µÄÊý×Ö,Á½Õß¿ÉÒÔ¶ÔÕÕÊ¹ÓÃ£¬ÊÇµÄÁÙ½ç¾ØÕóºÍ¶¥µã¹ØÏµ¸üÁé»î
	 * 
	 */
	public Map<String, Integer> vertex_number=new HashMap<String,Integer>();
	
	
	/**
	 * @±äÁ¿Ãû£ºMap number_vertex
	 * @×÷ÓÃ£º ¸ù¾ÝÄ³¸öÊý×ÖÖµ£¬¿ÉÈ¥È¡³öÆä¶ÔÓ¦µÄ¶¥µãÃû³Æ£¨Óëvertex_numberÕýºÃÏà·´£©
	 * Ïê½â£º
	 * 	   ÔÚvertex_numberÖÐÒÑ¾­¸øÃ¿¸ö¶¥µã¶ÔÕÕÒ»¸öÊý×Ö£¬¼´¿ÉÓÃ¶¥µãÃû³ÆÈ¡³ö¶ÔÓ¦µÄÊý×Ö£¬ÄÇÃ´number_vextex¿ÉÒÔ¸ù¾Ý¶¥µã±àºÅÈ¡³ö¶¥µãÃû³Æ
	 *   ±ÈÈçedge_matrix[i][j]±íÊ¾µÚi¸ö¶¥µãµ½µÚj¸ö¶¥µãµÄÂ·¾¶£¬ÄÇÃ´´ËÊ±Ö»ÒªÕÒ³öÊý×Öi,j¶ÔÓ¦µÄ¶¥µãÃû³Æ¼´¿ÉÖªµÀÄÇÁ½Ìõ±ß´æÔÚÂ·¾¶
	 */
	public Map<Integer,String> number_vertex=new HashMap<Integer,String>();
	
	/**
	 * @int[][] edge_matrix;
	 * @×÷ÓÃ£º ÓÐÏòÍ¼ÁÚ½Ó¾ØÕó
	 * @³õÊ¼Öµ£º10000
	 * Ïê½â£º
	 * 	      ÒòÎªÔÚvertex_numberºÍnumber_vertexÖÐÒÑ¾­½«Ã¿¸ö¶¥µãÓëÎ¨Ò»µÄ±àºÅ¶ÔÓ¦£¬ÄÇÃ´¿ÉÓÃÁÚ½Ó¾ØÕó±íÊ¾ËùÓÐ±àºÅÖ®¼äµÄ±ß¹ØÏµ£»
	 *    £¨ÒòÎª±àºÅºÍ¶¥µãÃû³ÆÏà»¥¶ÔÓ¦£¬ËùÓÐ¿ÉÖªµÀÃ¿¸ö¶¥µãÖ®¼äµÄÂ·¾¶¹ØÏµ£©
	 *    
	 */
	public int [][] edge_matrix=null;
	
	//³õÊ¼»¯ÁÚ½Ó¾ØÕóµÄÖµ£¬Èç¹ûÈ¨ÖµÎª10000£¬ÔòÃ»ÓÐÂ·¾¶
	int max_weight=100000;
	
	
	//Ò»¸öµãµ½ËùÓÐµãµÄÂ·¾¶
	public GraphViz gv_1 = new GraphViz();
	
	
	/*************************************************************************
	 * Õ¹Ê¾ÓÐÏòÍ¼
	 *************************************************************************/
	//public void showDirectedGraph(Vector<String> edge_vec
	public void showDirectedGraph()
	{
		GraphViz gv = new GraphViz();
	     gv.addln(gv.start_graph());
	     
	     /**
	      * °´Ñ­Ðò±éÀú±ßÈÝÆ÷£¬ÒÀ´ÎÈ¡³öÃ¿Ìõ±ßºÍ´Ë±ßµÄÈ¨ÖØ£¬È¨ÖØ×÷ÎªÂ·¾¶µÄlabel;
	      */
		for(int i=0;i<this.edge_edge.size();i++)
		{

			String add_edge=this.edge_edge.elementAt(i);//Ò»¶Ô±ß
			String strweight=this.edge_weight.get(add_edge).toString();//±ßµÄÈ¨Öµ
			String style=add_edge+"[ label="+strweight+"]"+";";
			gv.add(style);
		}
		
		gv.addln(gv.end_graph()); //½«ËùÓÐ±ß´«¸ødotÎÄ¼þ
	    String type = "jpg";
	    File out = new File("out." + type);   
	    
	    /**
	     * gv.getDotSource()--½«Í¼Æ¬×ª»»³É×Ö·û´®¸ñÊ½
	     * gv.getGraph( gv.getDotSource(), type ) --½«×Ö·û´®×ª»»³É×Ö½ÚÊý×é
	     * writeGraphToFile --½«Í¼Æ¬Êä³öµ½ÎÄ¼þoutÖÐ
	     */
	    gv.writeGraphToFile( gv.getGraph( gv.getDotSource(), type ), out );
	    
	    try {
			Desktop.getDesktop().open(new File("OUT.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	/*************************************************************************
	 * ²éÑ¯ÇÅ´Ê
	 * @param word1
	 * @param word2
	 * @return Èç¹ûÓÐÒ»¸ö»ò¶à¸öbridgewordsÔò·µ»Øbridgewords;
	 * 		      Èç¹ûÄ³¸öµ¥´Ê²»ÔÚÍ¼ÖÐÔò·µ»Ø£º"No "+word1+" or "+word2+ " in the graph!";
	 * 		    Èç¹ûÁ½¸öµ¥´ÊÖ®¼äÓÐÂ·¾¶£¬»òÕßÃ»ÓÐbridgeword·µ»Ø£º"N0 bridge words from "+word1+" to "+word2+"!"
	 **************************************************************************/
	public String queryBridgeWords(String word1, String word2)
	{
		
		String bridgewords="";	//·µ»ØµÄ×Ö·û´®£¬¼ÇÂ¼bridgewords
		
		String temp=word1+" -> "+word2; //Á¬¸öµ¥´Ê×é³ÉµÄ±ßÃû³Æ
		
		//Èç¹û¶¥µãword1µ½word2ÓÐÏàÁÚÂ·¾¶ÔòÁ½¸öµ¥´ÊÖ®¼äÃ»ÓÐbridgeword
		if(this.edge_edge.contains(temp)==true)
		{
			return ("N0 bridge words from "+word1+" to "+word2+"!");
		}
		//Èç¹ûÁ½¸öµ¥´Ê²»ÏàÁÚ£¬²é¿´ÕâÁ½¸öµ¥´ÊÔÚ²»ÔÚ¶¥µã¼¯ÖÐ
		else if(this.vertex_number.containsKey(word1) && this.vertex_number.containsKey(word2))
		{
			int wordnum1=this.vertex_number.get(word1);
			int wordnum2=this.vertex_number.get(word2);
		
			for(int i=0;i<this.vertex;i++)
			{
				if(this.edge_matrix[wordnum1][i]!=this.max_weight)
				{
					if(this.edge_matrix[i][wordnum2]!=this.max_weight)
					{
						bridgewords+=this.number_vertex.get(i)+", ";			
					}
				}
			}
			//Èç¹ûÒ»¸öbridgeword¶¼Ã»ÓÐ
			if(bridgewords=="")
			{
				return ("No bridge words from "+word1+" to "+word2+"!");
			}
			//Èç¹ûÕÒµ½ÁË
			bridgewords="The bridge words from "+word1+" to "+word2+" are: "+bridgewords;
		}

		//word1»òÕßword2²»ÔÚ¶¥µã¼¯ÖÐ
		else if(this.vertex_number.containsKey(word1)==false || this.vertex_number.containsKey(word2)==false)
		{
			bridgewords=bridgewords+"No "+word1+" or "+word2+ " in the graph!";
			return bridgewords;
		}
		//Èôµ¥´ÊÔÚÎÄ±¾ÖÐ£¬µ«ÊÇÃ»ÓÐbridge word»òÕßÁ½¸öµ¥´ÊÖ®¼äÓÐÂ·¾¶
		else {
			return ("No bridge words from "+word1+" to "+word2+"!");
		}
		return bridgewords;
	}
	
	
	
	/**************************************************************************
	 * ¸ù¾ÝÇÅ´ÊÐÎ³ÉÐÂµÄÎÄ±¾
	 * @param inputText
	 * @return
	 ************************************************************************/
	public String generateNewText(String inputText)
	{
		//½«inputText°´ÕÕ¿Õ¸ñ²ð·Ö²ð·Ö³Éµ¥´Ê£¬ÒÀ´Î·ÅÈë×Ö·û´®Êý×éÖÐ,inputText±¾Éí²¢²»±ä
		String strtemp=inputText.replaceAll("[^a-zA-Z]+", " ").toLowerCase();
		String[] inputWords=strtemp.split("[\\s]");
	    String result="";
	    
		for(int i=0;i<inputWords.length-1;i++)
		{
			//vector.add(inputWords[i]);
			result=result+inputWords[i]+" ";//¼ÓÈëÊäÈëÎÄ±¾µÄµÚÒ»¸öµ¥´Ê
			Vector<String> vectemp=new Vector<>();//´æ·ÅËùÓÐÇÅ´Ê£¬ºóÃæËæ»ú²úÉúÏÂ±íÑ¡È¡ÆäÖÐÒ»¸ö
			

			//Èç¹ûÁ½¸öµ¥´Ê¶¼ÔÚÔ­À´µÄÎÄ±¾ÖÐ
			if(this.vertex_number.containsKey(inputWords[i]) && this.vertex_number.containsKey(inputWords[i+1]))
			{
				int wordnum1=this.vertex_number.get(inputWords[i]);
				int wordnum2=this.vertex_number.get(inputWords[i+1]);
				for(int j=0;j<this.vertex;j++)
				{
					if(this.edge_matrix[wordnum1][j]!=this.max_weight)
					{
						if(this.edge_matrix[j][wordnum2]!=this.max_weight)
						{
							if(this.edge_matrix[wordnum1][wordnum2]==this.max_weight)//Á½¸öµ¥´ÊÖ®¼ä²»ÄÜÓÐÂ·¾¶
							{
								vectemp.add(this.number_vertex.get(j));
							}
						}
					}
				}
			}
			
			//Èç¹ûvectemp²»¿Õ£¬¼´ÀïÃæÓÐbridge word,´ÓÆäÖÐËæ»úÑ¡È¡Ò»¸ö
			if(vectemp.isEmpty()==false)
			{
				Random r=new Random();
				int index=r.nextInt(vectemp.size());//²úÉúvectemp³¤¶ÈÖ®ÄÚµÄËæ»úÊý
				result=result+vectemp.get(index)+" ";
				vectemp.clear();
			}
		}
		result=result+inputWords[inputWords.length-1];//¼ÓÉÏÊäÈëÎÄ±¾×îºóÒ»¸öµ¥´Ê
		return result;
	}
	
	
	
	
	
	/************************************************************************
	 * @param word1
	 * @param word2
	 * @return Á½¸öµãÖ®¼äµÄ×î¶ÌÂ·¾¶
	 ***********************************************************************/
	public String calcShortestPath(String word1, String word2)
	{
		Vector<String> min_pass_edge=new Vector<>();//¼ÇÂ¼Á½µã¼äµÄÂ·¾¶£¨°üÀ¨ÕâÁ©¸öµã£©
		String returnstring="";//¼ÇÂ¼ÁÁµã¼äµÄÂ·¾¶£¨°üÀ¨ÁÁµã£©
		//¼ÇÂ¼Á½¸ö¶¥µãÖ®¼äµÄ×î¶ÌÂ·¾¶Ëù¾­¹ýµÄ±ßºÍ¶ÔÓ¦µÄÈ¨Öµ
		Map<String, Integer> min_edge_weigth=new HashMap<String, Integer>();//ÁÁµã×î¶ÌÂ·¾¶¾­¹ýµÄ±ßºÍÈ¨Öµ
		
		//ÏÈÅÐ¶ÏÕâÁ½¸öµ¥´ÊÊÇ·ñÔÚ¶¥µã¼¯ÖÐ
		if(this.vertex_number.containsKey(word1)==false || this.vertex_number.containsKey(word2)==false)
		{
			return  "No "+word1+" or "+word2+ "in the graph!";
		}
		
		//String resultstring="";//·µ»ØÖµ
		int[][] D=new int[this.vertex][this.vertex];
		int[][] P=new int[this.vertex][this.vertex];//±íÊ¾±àºÅÎªi,j±ßÖ®¼äµÄ×î¶ÌÂ·¾¶
		for(int i=0;i<this.vertex;i++)
		{
			for(int j=0;j<this.vertex;j++)
			{
				D[i][j]=this.edge_matrix[i][j];
				P[i][j]=-1;
			}
		}

		for(int k=0;k<this.vertex;k++)
		{
			for(int i=0;i<this.vertex;i++)
			{
				for(int j=0;j<this.vertex;j++)
				{
					if(D[i][k]+D[k][j] <D[i][j])
					{
						D[i][j]=D[i][k]+D[k][j];
						P[i][j]=k;
					}
				}
			}
		}
		 
		int i=this.vertex_number.get(word1);
		int j=this.vertex_number.get(word2);
		 min_pass_edge.add(word1);
		if(D[i][j]!=this.max_weight &&i!=j)
        { 
            print_minpass(P, i, j,min_pass_edge);
        }
		min_pass_edge.add(word2);
		
		
		//Èç¹ûÁ½¸öµ¥´Ê²»¿É´ï
		if(min_pass_edge.size()==2 && min_pass_edge.get(0)==word1&&min_pass_edge.get(1)==word2&&this.edge_edge.contains(word1+" -> "+word2)==false)
		{
			return "No pass from "+word1+" to "+word2+ " !";
		}
		
		
		//½«Â·¾¶ÉÏµÄ¶¥µã¼ÓÈëreturnresultÖÐ
		for(int k=0;k<min_pass_edge.size()-1;k++)
		{
			returnstring=returnstring+min_pass_edge.get(k)+" -> ";
		}
		returnstring=returnstring+min_pass_edge.get(min_pass_edge.size()-1)+" -> ";//¼ÓÈë×îºóÒ»¸öµ¥´Ê
		 
		//Õ¹Ê¾×î¶ÌÂ·¾¶Í¼
		 
		 //½«ÁÁµã¼äµÄ×î¶ÌÂ·¾¶¾­¹ýµÄ±ßºÍÈ¨Öµ¼ÓÈëmin_edge_weightÖÐ,
		 for(int k=0;k<min_pass_edge.size()-1;k++)
		 {
			 String frist=min_pass_edge.get(k);
			 String next=min_pass_edge.get(k+1);
			 String tempstring=frist+" -> "+next;//±ß
			 int fristnum=this.vertex_number.get(frist);	//Á½¸ö¶¥µãµÄ±àºÅ
			 int nextnumm=this.vertex_number.get(next);
			 int tempweigt=this.edge_matrix[fristnum][nextnumm];//È¨Öµ
			 min_edge_weigth.put(tempstring, tempweigt);
		 }
		 
		 //	»æÖÆ±ßµÄÊ±ºò£¬Èç¹û±ßÔÚmin_edge_weightÖÐÓÃÍ¹ÏÔµÄÑÕÉ«±êÊ¶·ñÔòÓÃÄ¬ÈÏÑÕÉ«
		GraphViz gv = new GraphViz();
	    gv.addln(gv.start_graph());	
	    for(int k=0;k<this.edge_edge.size();k++)
		{			
			String add_edge=this.edge_edge.elementAt(k);//Ò»¶Ô±ß
			String strweight=this.edge_weight.get(add_edge).toString();//±ßµÄÈ¨Öµ
			String style=null;	
				
			//Èç¹û±ßadd_edgeÔÚmin_edge_weightÖÐ,ÔòÑÕÉ«ÎªºìÉ«
			if(min_edge_weigth.containsKey(add_edge))
			{
				 style=add_edge+"[ color=red,label="+strweight+"]"+";";
			}
		
			//·ñÔòÎªÄ¬ÈÏ
			else {
				style=add_edge+"[ label="+strweight+"]"+";";
			}				
		
			gv.add(style);
		}
			
		gv.addln(gv.end_graph());
        //System.out.println(gv.getDotSource());  
		String type = "gif";
	    File out = new File("minpass." + type);    
	    gv.writeGraphToFile( gv.getGraph( gv.getDotSource(), type ), out );		 
	    try {
			Desktop.getDesktop().open(new File("minpass.GIF"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return returnstring;
	}
	
	
	
	
	
	
	
	/**Ëæ»úÓÎ×ß*******************************************************************************
	 *@author °¢¶Å
	 *@Á÷³Ì£ºÊ×ÏÈ³ÌÐòËæ»úÉú³ÉÒ»¸ö¶¥µã¸öÊý·¶Î§Ö®ÄÚµÄÊý×Ö£¬ÒÔ´ËÊý×ÖÎªÆðµã¡£ÈçÐÂµÚÒ»¸öÆðµãÊÇAÔòÑ¡³öÓëAÏàÁÚµÄËùÓÐ¶¥µã·ÅÈëÒ»¸övectempÖÐ£¬
	 *		ÔÙ´ÓÆäÖÐËæ»úÑ¡³öÒ»¸ö¶¥µãB£¬²¢ÐÎ³É×Ö·û´®"A - >B"·ÅÈëÒ»¸övecresultÖÐ£¬Èç¹ûvecresultÖÐÒÑ¾­ÓÐ´Ë±ß£¬Ôò½áÊø¡£»òÕß
	 *		Ñ¡µ½Ò»¸öÐÂµÄ¶¥µã²»´æÔÚ³ö±ßÔò½áÊø£¬½«Ç°ÃæµÄËùÓÐ³öÏÖµÄ¶¥µã½µÈëresultstringÖÐ²¢·µ»Ø£¡
	 *		Ã¿´ÎÑ¡³öÏÂÒ»Ìõ±ß£¬Ôò´Ë³ÉÎªstrat_number£¬ÖØ¸´ÉÏÃæµÄ²Ù×÷
	 * 
	 *******************************************************************************************/
	public String randomWalk()
	{
		//Ëæ»úÓÎ×ßµÄÂ·¾¶
		String strresult="";
		
		//¼ÇÂ¼³öÏÖ¹ýµÄ±ß£¬Èç¹ûÖØ¸´³öÏÖÔò½áÊø
		Vector<String> vecresult=new Vector<>();
		
		//²úÉú¶¥µã¸öÊývertex·¶Î§Ö®ÄÚµÄÒ»¸öÊý×Ö,½«¸ÃÊý×Ö¶ÔÓ¦µÄ¶¥µã×÷ÎªÆðÊ¼Î»ÖÃ
		Random r=new Random();
		
		//µÚÒ»¸ö¶¥µã¶ÔÓ¦µÄ±àºÅ
		int frist_number=r.nextInt(vertex);
		
		//String strat_edge=this.number_vertex.get(frist_number);//ÆäÊµ¶¥µã
		//½«µÚÒ»¸ö±ß¼ÓÈëstrresultÖÐ
		strresult=strresult+this.number_vertex.get(frist_number)+" ";
		
		Scanner in=new Scanner(System.in);
		System.out.print("ÊÇ·ñ¼ÌÐø(Y/N): ");
		String choose1=in.next();
		if(choose1.equals("N") ||choose1.equals("n"))
		{
			in.close();
			return strresult;
		}
		if(choose1.equals("Y") ||choose1.equals("y"))
		{
			System.out.println(strresult);
		}
		
		while(true)
		{		
				
			Vector<String> vectemp=new Vector<>();
		    for(int j=0;j<vertex;j++)
		    {
		    	//½«ÓÚfrist_numberÓÐÂ·¾¶µÄ¶¥µãÃû³Æ·ÅÈëvectempÖÐ
		    	if(edge_matrix[frist_number][j]!=this.max_weight)
		    	{	
		    		vectemp.add(this.number_vertex.get(j));
		    	}
		    }
		    
		    //Èç¹ûvectemp¿Õ£¬¼´frist_number¶¥µãÃ»ÓÐ³öÂ·£¬Ôò½áÊø
		    if(vectemp.isEmpty())
		    {
		    	break;
		    }
		    //vectempÀïÃæÊÇÓöÉÏÒ»¸ö±ßfrist_numberÓÐÂ·¾¶µÄËùÓÐ¶¥µã
		    if(vectemp.isEmpty()==false)//Èçfrist_number¶ÔÓ¦µÄ±ßÓÐÏÂÒ»Ìõ±ß
		    {
		    	//´ÓvectempÖÐËæÑ¡³öÒ»¸ö¶¥µã
		    	Random r1=new Random();
				int next_number=r1.nextInt(vectemp.size());
				//Èç¹û±ß "strat_number -> next "Ã»³öÏÖ¹ýÔò¼ÌÐø£¬·ñÔò½áÊø²¢·µ»Ø½á¹û,´ÓvectempÖÐÈ¡³öËæ¼´±ßvectemp.get(next_number)
				String temp=this.number_vertex.get(frist_number)+" -> "+vectemp.get(next_number);
				
				//Èç¹û¸Ä±äÊÇµÚÒ»Ìõ±ß£¬Ôò½áÊø
				//if(vecresult.contains(temp)==false)
				
				if(vecresult.isEmpty()==true)
				{
					vecresult.add(temp);
					strresult=strresult+vectemp.get(next_number)+" ";
					//next_number¶ÔÓ¦µÄ±ß³ÉÎªÐÂµÄÆðÊ¼µãfrist_number£¬
					frist_number=this.vertex_number.get(vectemp.get(next_number));
					
					 System.out.print("ÊÇ·ñ¼ÌÐø(Y/N): ");
					 String choose=in.next();
					if(choose.equals("Y")||choose.equals("y"))
					{
						System.out.println(strresult);
						continue;
					}
					else {
						break;
					}
					
				}
				
				//Èô¸Ã±ßtempÔÚvecresutl³öÏÖ¹ýÔò½áÊø
			
				 if(vecresult.get(0).equals(temp)==false)
				{
					//Ã»ÓÐ³öÏÖ¹ýÔò½«£¬Õâ¶Ô±ßtemp·ÅÈëvecresultÖÐ
					vecresult.add(temp);
					strresult=strresult+vectemp.get(next_number)+" ";
					//next_number¶ÔÓ¦µÄ±ß³ÉÎªÐÂµÄÆðÊ¼µãfrist_number£¬
					frist_number=this.vertex_number.get(vectemp.get(next_number));
				}	
				 else 
				{
					strresult=strresult+vectemp.get(next_number)+" ";
					break;
				}
		    }
		    
		    System.out.print("ÊÇ·ñ¼ÌÐø(Y/N): ");
			String choose=in.next();
			if(choose.equals("Y")||choose.equals("y"))
			{
				System.out.println(strresult);
				continue;
			}
			else {
				break;
			}
		}
		in.close();
		return  strresult;
	}
	
	
	
	

	
		
		/*************************************************************************
		 * @author °¢¶Å
		 * @param args
		 **************************************************************************/
	public static void main(String[] args) 
	{
			MAIN obj1=new MAIN();
			String str=new String();
			Scanner cin=new Scanner(System.in);
			

			while(true)
			{
				System.out.println("1- ´ÓÎÄ¼þ¶ÁÈ¡Êý¾Ý! 2-ÊÖ¶¯Ð´ÈëÊý¾Ý!");
				System.out.print("ÇëÊäÈëÑ¡Ôñ:");
				String choose=cin.nextLine();
				if(choose.equals("1"))
				{
					/**
					 * ´ÓÎÄ¼þ¶ÁÈëÊý¾Ý£¬²¢¶ÔÆä½øÐÐ´¦Àí£¬×îºó½«ËùÓÐµ¥´Ê°´ÎÄ±¾ÖÐµÄÑ­Ðò²ð·Ö¸´ÖÆ¸øobj1.words_original
					 */
					str="";
					System.out.print("ÇëÊäÈëÎÄ¼þÂ·¾¶:");
					
					String StrFilename=cin.nextLine();
					// StrFilename="input.txt";
					try {
						File file1=new File(StrFilename);
						FileReader fr=new FileReader(file1);
						BufferedReader br=new BufferedReader(fr);
						
						String temp=null;
						int i=1;
						while((temp=br.readLine()) != null)
						{
							if(i==1)
							{
								str=str+temp;//µÚÒ»ÐÐÇ°Ãæ²»¼Ó¿Õ¸ñ
							}
							else {
								str=str+" "+temp;//Ã¿¶ÁÒ»ÐÐ¼ÓÒ»¸ö¿Õ¸ñ
							}
							i++;
						}
						br.close();
					}catch (Exception e) {
						e.printStackTrace();
					}
					
					break;
				}
				if(choose.equals("2"))
				{
					System.out.print("ÇëÊäÈëÎÄ±¾:");
					str=cin.nextLine();
					break;
				}
			}
			
			
			String str1=str.replaceAll("[^a-zA-Z]+", " ");
			String str2=str1.toLowerCase();
			obj1.words_original=str2.split("[\\s]");
			
		
			
			/**	
			 * ³õÊ¼»¯edge_edge  ;  edge_weight
			* Éú³ÉÍ¼   ,½«Ã¿Ìõ±ß×ª»»³É×Ö·û´®¶Ô¼ÓÈëmap edge_weight ÖÐ£»ÆäÖÐkeyÊÇ±ß£¬valueÊÇÈ¨Öµ£¨±ß³öÏÖµÄ´ÎÊý£©,¼ÆËãÃ¿Ìõ±ß³öÏÖµÄ¸öÊý
			* Í¬Ê± ½«Ã¿Ò»Ìõ"A -> B"±ß°´³öÏÖµÄ´ÎÊý´æ·Å vector edge_edgeÖÐ(ÊÇÎªÁË½«±ß°´Ñ­Ðò¶Á³öÀ´)
			*/
			for(int i=0;i<obj1.words_original.length-1;i++)
			{
				String temp=obj1.words_original[i]+" -> "+obj1.words_original[i+1];
				
				//µÚÒ»´Î¼ÓÈëÊ±È¨ÖµÎª1
				if(obj1.edge_weight.containsKey(temp)==false)
				{
					obj1.edge_edge.add(temp);//½«ÐÂµÄÒ»¶Ô±ß·Å½øvector edge_degeºóÃæ(ÈôÖØ¸´³öÏÖÔò°´ÕÕµÚÒ»´Î²åÈëµÄÎª×¼
					obj1.edge_weight.put(temp, 1);
				}
				
				//Èç¹ûÒÑ¾­ÓÐÁË±ßºÍÈ¨Öµ£¬ÔòÈ¨Öµ¼ÓÒ»
				else {
					int nutemp=obj1.edge_weight.get(temp);
					nutemp+=1;
					obj1.edge_weight.put(temp, nutemp);
				}
			}
			
			
			/**	
			 * ³õÊ¼»¯ vertex_number   ; number_vertex
			 * ´ÓÍ·µ½Î²±éÀúÔ­À´µÄµ¥´Ê±í£¬¶ÔÃ¿Ò»¸öµ¥´Ê°´ÕÕÎÄ±¾ÖÐ³öÏÖµÄ´ÎÊý¸øÓè0....µÄÖµ£¬ÈôÓÐÖØ¸´³öÏÖµÄµ¥´Ê£¬ÔòÒÔµÚÒ»´Î¸øÓèµÄÖµÎª×¼
			 * ¸øÃ¿¸ö¶¨µã¸³¸øÒ»¸öÖµ£¬À´±íÊ¾Ã¿¸ö¶¨µãÔÚÁÚ½Ó¾ØÕóµÄ±íÊ¾µÄÊý×Ö
			 */
			int number=-1;//Ã¿Ìõ±ß¶ÔÓ¦µÄÊý×Ö£¬´ÓÁã¿ªÊ¼
			for(int i=0;i<obj1.words_original.length;i++)
			{
				//vertex_number£¬number_vertexÃ¿¸ökeyºÍvalueÏà·´
				if( obj1.vertex_number.containsKey(obj1.words_original[i])==false)
				{
					number+=1;
					obj1.vertex_number.put(obj1.words_original[i], number);
					obj1.number_vertex.put(number,obj1.words_original[i]);
					obj1.edge.add(obj1.words_original[i]);
				}
			}
			obj1.vertex=obj1.number_vertex.size();
	
			//ÁÚ½Ó¾ØÕó³õÊ¼»¯£¬È«²¿Îªmax_weight
			obj1.edge_matrix=new int[obj1.vertex][obj1.vertex];
			for(int i=0;i<obj1.vertex;i++)
			{
				for(int j=0;j<obj1.vertex;j++)
				{
					obj1.edge_matrix[i][j]=obj1.max_weight;
				}
			}
			
			// ´´½¨ÓÐÏòÍ¼,´´½¨ÁÚ½Ó¾ØÕó£»
			for(int i=0;i<obj1.vertex;i++)
			{
				for(int j=0;j<obj1.vertex;j++)
				{
					String edgei=obj1.number_vertex.get(i);
					String edgej=obj1.number_vertex.get(j);
					//Èç¹ûÕâÁ½¸ö±ßÖ®¼äÓÐÂ·¾¶
					if(obj1.edge_weight.containsKey(edgei+" -> "+edgej))
					{
						int weight=obj1.edge_weight.get(edgei+" -> "+edgej);
						obj1.edge_matrix[i][j]=weight;
					}
				}
			}
			
				
	
			//Õ¹Ê¾ÓÐÏòÍ¼
			obj1.showDirectedGraph();
	
			
			// ²éÑ¯ÇÅ´Ê
			System.out.println("******************* ²éÑ¯Á½¸öµ¥´ÊÖ®¼äµÄÇÅ´Ê******************* :");
			System.out.print("please input word 1 :");
			String word1=cin.nextLine();
			System.out.print("please input word 2 :");
			String word2=cin.nextLine();	
			String BridgeWords=obj1.queryBridgeWords(word1, word2);
			System.out.println(BridgeWords);
			
	
			//¸ù¾ÝÇÅ´ÊÐÎ³ÉÐÂÐÂÎÄ±¾
			System.out.println(" \n******************* ¸ù¾ÝÇÅ´ÊÐÎ³ÉÐÂÐÂÎÄ±¾*******************  :");
			System.out.print("ÇëÊäÈëÎÄ±¾ :");
			String NewTex=cin.nextLine();
			System.out.println(obj1.generateNewText(NewTex));
			
		
	  		//Çó×î¶ÌÂ·¾¶
			System.out.println(" \n ******************* Á½¸öµ¥´ÊÖ®¼äµÄ×î¶ÌÂ·¾¶:******************* ");
			System.out.print("please input word 1 :");
			 word1=cin.nextLine();
			System.out.print("please input word 2 :");
			 word2=cin.nextLine();
	  		 String minpass=obj1.calcShortestPath(word1, word2);
			 System.out.println("Á½µã¼äµÄ×î¶ÌÂ·¾¶ÊÇ£º "+minpass);
			 
			 //Ò»¸öµãµ½ËùÓÐµãµÄ×î¶ÌÂ·¾¶
			 System.out.println(" \n ******************* Ò»¸öµ¥´Êµ½ËùÓÐµ¥´ÊÖ®¼äµÄ×î¶ÌÂ·¾¶:******************* ");
			 obj1.gv_1.addln(obj1.gv_1.start_graph());	
			 System.out.print("ÇëÊäÈëÒ»¸öµ¥´Ê:");
			 String word3=cin.nextLine();
			 obj1.calcShortestPath(word3);
			
			//Ëæ»úÓÎ×ß
			 System.out.println(" \n *******************Ëæ»úÓÎ×ß*******************");
	        String ResutlRanWalk=obj1.randomWalk();
	        System.out.print(ResutlRanWalk);
    		cin.close();	
 
			try {
				File file1=new File("outrandwalk.txt");
				FileWriter fr=new FileWriter(file1);
				fr.write(ResutlRanWalk);
				fr.close();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		    try {
				Desktop.getDesktop().open(new File("outrandwalk.txt"));
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
		
	
	/**
	 * showDirectedGraph();µÄ¸¨Öúº¯Êý£¬¼ÇÂ¼Â·¾¶
	 */
	public void print_minpass(int p[][],int i,int j,Vector<String> min_pass_edge)
	{
		int k=p[i][j];
		if(k != -1)
		{
			print_minpass(p, i, k,min_pass_edge);
			min_pass_edge.addElement(this.number_vertex.get(k));
			print_minpass(p, k, j,min_pass_edge);	
		}
	}
	
	
	 public void calcShortestPath(String word1)
	 {
		 	String strcolor="";
			try {
				File file1=new File("color.txt");
				FileReader fr=new FileReader(file1);
				BufferedReader br=new BufferedReader(fr);
				
				String temp=null;
				int i=1;
				while((temp=br.readLine()) != null)
				{
					if(i==1)
					{
						strcolor=strcolor+temp;//µÚÒ»ÐÐÇ°Ãæ²»¼Ó¿Õ¸ñ
					}
					else {
						strcolor=strcolor+" "+temp;//Ã¿¶ÁÒ»ÐÐ¼ÓÒ»¸ö¿Õ¸ñ
					}
					i++;
				}
				br.close();
			}catch (Exception e) {
				e.printStackTrace();}
			String str1=strcolor.replaceAll("[^a-zA-Z]+", " ");
			String str2=str1.toLowerCase();
			String[] colors=str2.split("[\\s]");
			
	
			String c;
			 for(int i=0;i<this.edge.size();i++)
			 {
				 if(colors.length-1==i)
				 {
					  c=colors[0];
				 }
				else {
					 c=colors[i];
				}
				 if(this.edge.get(i).equals(word1) ==false&&this.edge.contains(word1))
				 {
					 this.calcShortestPath(word1, this.edge.get(i),c);
				 }
			 }
			 
			    for(int k=0;k<this.edge_edge.size();k++)
				{			
					String add_edge=this.edge_edge.elementAt(k);//Ò»¶Ô±ß
					String strweight=this.edge_weight.get(add_edge).toString();//±ßµÄÈ¨Öµ
					this.gv_1.add(add_edge+"[ label="+strweight+"]"+";");
				}
			    
			    this.gv_1.addln(this.gv_1.end_graph());
		        //System.out.println(gv.getDotSource());  
				String type = "gif";
			    File out = new File("minpass_1." + type);    
			    this.gv_1.writeGraphToFile( this.gv_1.getGraph( this.gv_1.getDotSource(), type ), out );
			    
			    try {
					Desktop.getDesktop().open(new File("minpass_1." + type));
				} catch (IOException e) {
					e.printStackTrace();
				}
	 }
	 
	 
	 
		/************************************************************************
		 * @param word1
		 * @param word2
		 * @return Á½¸öµãÖ®¼äµÄ×î¶ÌÂ·¾¶
		 ***********************************************************************/
		public void calcShortestPath(String word1, String word2,String cl)
		{
			Vector<String> min_pass_edge=new Vector<>();//¼ÇÂ¼Á½µã¼äµÄÂ·¾¶£¨°üÀ¨ÕâÁ©¸öµã£©			
			//String resultstring="";//·µ»ØÖµ
			int[][] D=new int[this.vertex][this.vertex];
			int[][] P=new int[this.vertex][this.vertex];//±íÊ¾±àºÅÎªi,j±ßÖ®¼äµÄ×î¶ÌÂ·¾¶
			for(int i=0;i<this.vertex;i++)
			{
				for(int j=0;j<this.vertex;j++)
				{
					D[i][j]=this.edge_matrix[i][j];
					P[i][j]=-1;
				}
			}

			for(int k=0;k<this.vertex;k++)
			{
				for(int i=0;i<this.vertex;i++)
				{
					for(int j=0;j<this.vertex;j++)
					{
						if(D[i][k]+D[k][j] <D[i][j])
						{
							D[i][j]=D[i][k]+D[k][j];
							P[i][j]=k;
						}
					}
				}
			}
			 
			int i=this.vertex_number.get(word1);
			int j=this.vertex_number.get(word2);
			 min_pass_edge.add(word1);
			if(D[i][j]!=this.max_weight &&i!=j)
	        { 
	            print_minpass(P, i, j,min_pass_edge);
	        }
			min_pass_edge.add(word2);
			 
			 //½«ÁÁµã¼äµÄ×î¶ÌÂ·¾¶¾­¹ýµÄ±ßºÍÈ¨Öµ¼ÓÈëmin_edge_weightÖÐ,
			 for(int k=0;k<min_pass_edge.size()-1;k++)
			 {
				 String frist=min_pass_edge.get(k);
				 String next=min_pass_edge.get(k+1);
				 String tempstring=frist+" -> "+next;//±ß
	
				 String style=tempstring+"[ color="+cl+"]"+";";
				 this.gv_1.add(style); 
			 }
		}
}



