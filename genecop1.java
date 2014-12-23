import java.util.*;
class genecop1
{
	void construct(Node<T> node,int l,String vir,int x)
	{
		Node<T> child=new Node<T>();
		child.children=new ArrayList<Node<T>>();
		child.data=new T();
		Node<T> child1=new Node<T>();
		child1.data=new T();
		//node.children=new ArrayList<Node<T>>();
		if(l>=vir.length()-1)
		return;
		if((node.children).isEmpty())
		{
			(child.data).hex=vir.charAt(l);
			if(l==(vir.length()-2))
			(child.data).list=x;
			else
			(child.data).list=0;
			(node.children).add(child);
			System.out.println((child.data).hex);
			//System.out.println("DDDDDDDD");
			construct(child,++l,vir,x);
			return;
		}
		//return;
		int i;
		for(i=0;i<(node.children).size();i++)
		{
			child1=(node.children).get(i);
			if((child1.data).hex==vir.charAt(l))
			{System.out.println("ZZZZZZZ");
			break;}
		}
		if(i<(node.children).size())
		{
			if(l==(vir.length()-2))
			(child1.data).list=x;
			System.out.println("VVVVVVVVV");
			child=child1;
		}
		if(i==(node.children).size())
		{
			//Node<T> child=new Node<T>();
			(child.data).hex=vir.charAt(l);
			//System.out.println("NNNNNNNNN");
			if(l==(vir.length()-2))
			(child.data).list=x;
			else
			(child.data).list=0;
			(node.children).add(child);
		}
		System.out.println((child.data).hex);
		//System.out.println("YYYYYYYYY");
		construct(child,++l,vir,x);
		return;
	}
	void traversal(Node<T> node)
	{
		Node<T> child=new Node<T>();
		if((node.children).isEmpty())
		return;
		else
		{
			for(int i=0;i<(node.children).size();i++)
			{
				child=(node.children).get(i);
				traversal(child);
				//System.out.println((child.data).hex);
			}
		}
		return;
	}
	void search(Node<T> node,int g,int count,Node<T> parent,int k)
	{
		char v;
		int j=0;
		//System.out.println("#####"+g);
		//System.out.println("@@@@@@@"+k);
		input1 i1=new input1();
		List<Node<T>> children3=new ArrayList<Node<T>>();
		children3=node.children;
		database d2=new database();
		List<viruscop> viruses1=d2.viruses;
		d2.connect();
		v=i1.getcontent(g);
		Node<T> child=new Node<T>();
		if((node.children).isEmpty())
		{
			//j=(node.data).list;
			node=parent;
			//g=g-((viruses1.get(j-1)).virussignature).length()+1;
			//System.out.println("#####"+g);
			g=k;k=k+1;
			search(node,++g,count,parent,k);
			return;
		}
		if(v=='\0')
		{
			if(count==0)
			System.out.println("no virus detected");
			return;
		}
		int i=0;
		//Node<T> child=new Node<T>();
		for(i=0;i<children3.size();i++)
		{
			child=children3.get(i);
			if((child.data).hex==v)
			{
				node=child;
				if((child.data).list!=0)
				{
					j=(child.data).list;
					System.out.println("virus detected"+(viruses1.get(j-1)).virussignature+"$$$$$$$$"+(viruses1.get(j-1)).virusname);
					count++;
				}
				break;
			}
			//else
			//{node=parent;System.out.println("^^^^^^^^^");g=k;k=k+1;}
		}
		if(i==children3.size())
		{node=parent;System.out.println("^^^^^^^^^");g=k;k=k+1;}
		search(node,++g,count,parent,k);
		return;
	}
	public static void main(String args[])
	{
		Node<T> parent=new Node<T>();
		//System.out.println(parent);
		T data1=new T();
		data1.hex='*';
		data1.list=0;
		parent.data=data1;
		parent.children=new ArrayList<Node<T>>();
		database d2=new database();
		//d2.connect();
		List<viruscop> viruses1=d2.viruses;
		d2.connect();
		viruscop v2;
		String vir;
		int l=0;
		int x=0;
		for(int i=0;i<2;i++)
		{
			v2=viruses1.get(i);
			vir=v2.virussignature;
			x=i+1;
			//System.out.println(vir.length());
			//System.out.println(x);
			genecop1 g1=new genecop1();
			//System.out.println(g1);
			g1.construct(parent,0,vir,x);
		}
		if((parent.children).isEmpty())
		System.out.println("TTTTTTT");
		else
		System.out.println("PPPPPPPPPPP");
		for(int j=0;j<(parent.children).size();j++)
		System.out.println(j);
		int g=0,count=0,k=0;
		genecop1 g2=new genecop1();
		g2.traversal(parent);
		g2.search(parent,g,count,parent,k);
	}
}
			