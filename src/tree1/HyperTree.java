package tree1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.Scrollable;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.ExpandVetoException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

	public class HyperTree extends JFrame implements ActionListener{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private JTree tree,tree1,tmp;
		int i=0,k=-1;
		private JButton b1,b2,b3,b4;
		private JPanel p1,p2;
		DefaultMutableTreeNode a[]= new DefaultMutableTreeNode[100];
		DefaultMutableTreeNode tmpp[]= new DefaultMutableTreeNode[100];
		public HyperTree() throws IOException{
			
			  String st="";
			  
		      Document doc = Jsoup.connect("http://localhost:8000/b.html").get();
//			  Document doc = Jsoup.parse(html);			  		   
//		      Elements elements = doc.select("*");
		      Elements ele = doc.children();
		      p1=new JPanel();
		      p2=new JPanel();
		      b1=new JButton("Root");
		      b2=new JButton("Head");
		      b3=new JButton("Prime");
		      b4=new JButton("Tail");
		      
		      for(Element ee : ele)
		      {		    	  	    
		    	  a[i++]=new DefaultMutableTreeNode(ee.tagName());	
		    	  
		    	  rec(ee);
		      }	 
//		      
		      int ch;		      
		      
//		      Scanner sc=new Scanner(System.in);
//		      ch=sc.nextInt();
		      ch=4;	      
		      if(ch==1)
		      {
		    	  a[0].remove(0);
		    	  
		      }		  	    
		      else if(ch==2)
		      {
		    	  tree = new JTree(a[0]);
			        add(tree);
//		    	  tmp= new JTree(a[0].getFirstChild());
//		    	  add(tmp);
		      }
		      else if(ch==3)
		      {
//		    	  int tm;
//		    	  System.out.println("\nEnter the Number :");
//		    	  sc=new Scanner(System.in);
//		    	  tm=sc.nextInt();
//		    	  while(tm<k)
//		    	  {
		    		  a[0].remove(1); 
//		    	  }
		      }
		      
		      if(ch!=2)
		      {
		    	 		    	 		    	  		    	  
		      }
		      
//		      Abc tmp=this;
		      b1.addActionListener(this);
		      b2.addActionListener(this);
		      b3.addActionListener(this);
		      b4.addActionListener(this);
//		      this.add(b1);
		      b1.setBounds(10, 10, 15, 15);
		      b2.setBounds(10, 30, 15, 15);
		      b3.setBounds(10, 50, 15, 15);
		      b4.setBounds(10, 70, 15, 15);
//		      b1.setSize(10,10);
		      b1.setVisible(true);
		      b2.setVisible(true);
		      b3.setVisible(true);
		      b4.setVisible(true);
		      p1.setBounds(0, 0, 100, 150);
		      p1.setVisible(true);
		      p1.add(b1);
		      p1.add(b2);
		      p1.add(b3);
		      p1.add(b4);
		      p2.setBounds(15, 15, 200, 200);
		      
		      this.add(p1);
		      this.add(p2);
		        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        this.setTitle("JTree Example");       
		        this.pack();
		        this.setSize(500,500);
		        this.setVisible(true);	
//		        this.setVisible(false);
		       
//		        this.setVisible(true);	
//		        this.setLayout(null);
	}
	public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
					new HyperTree();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
//		
		if(e.getSource()==b1)
		{
			tree=null;
			System.arraycopy(a, 0, tmpp, 0, 100);
			tree = new JTree(tmpp[0]);
		}
		else if(e.getSource()==b2)
		{
			tree=null;			
			System.arraycopy(a, 0, tmpp, 0, 100);
			tmpp[0].remove(1); 			
			tree = new JTree(tmpp[0]);			
		}
		else if(e.getSource()==b3)
		{
			tree=null;
			
			System.arraycopy(a, 0, tmpp, 0, 100);
			tree= new JTree(tmpp[0].getFirstChild());
		}
		else if(e.getSource()==b4)
		{
			tree=null;			
			System.arraycopy(a, 0, tmpp, 0, 100);
			tmpp[0].remove(0);
			tree= new JTree(tmpp[0]);
		}
	    tree.setBounds(15,0,100,100);
		for(int i=0;i<tree.getRowCount();i++)
		{
			  tree.expandRow(i);
		}
//		remove(p2);
		p2.removeAll();
//		add(p2);
		p2.add(tree);
		p2.setVisible(true);
//		JScrollPane panelPane = new JScrollPane(p2);
//		add(panelPane);
		repaint();
		revalidate();
		
//		tmp.add(p2);
	}
	public void rec(Element ele)
	{		
		k++;
		int m=0;
		Elements aa=ele.children();
		if(!aa.isEmpty())
		{
			m=i-1;	
		}
		
		
		for(Element ee : aa)
		{
			
			a[i]=new DefaultMutableTreeNode(ee.tagName());
//			System.out.println(ee.tagName() + " :"+ "i=" + i+ "k=" + k + "m=" + m + "\n");
			a[m].add(a[i]);
			i++;
//			if(ee.tagName()!="br" && ee.tagName()!="img")
//			{
				rec(ee);					
				k--;
//			}
			
		}
		if(!aa.isEmpty())
		{
			m--;
		}
		
	}
}
