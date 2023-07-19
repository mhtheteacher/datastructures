package com.ds;

public class TrieImplementation {

	static class Node{
		Node [] children;
		boolean eow;
		
		Node(){
			children= new Node[26];
			
			for (int i=0; i< 26 ;i++)
			{
				children[i]=null;
				eow=false;
			} 
		}
	}
	static Node root= new Node();
		public static void insert(String word) {
			Node curr=root;
			for (int j=0; j<word.length();j++) {
				int index= word.charAt(j)- 'a';
				if (curr.children[index]==null)
					curr.children[index]=new Node();
				if (j==word.length()-1)
					curr.children[index].eow=true;
				curr=curr.children[index];
			}
		}
		
		public static boolean search (String key) {
			Node curr=root;
			for (int i=0; i < key.length();i++)
			{
				int index= key.charAt(i)-'a';
				if (curr.children[index]==null)
					return false;
				if (i==key.length()-1 && curr.children[index].eow==false)
					return false;
				
				curr=curr.children[index];
			}
			
			return true;
			
		}
		
		public static boolean startsWith(String prefix) {
			Node curr=root;
			for (int i=0; i < prefix.length();i++) {
				int index=prefix.charAt(i)-'a';
				if (curr.children[index]==null)
					return false;
				curr=curr.children[index];
			}
			return true;
		}
		
			 public static void main(String[] args) {

               		 //case 1 : insert and search
		         String []words= {"the","a","there","their","any"};
		         for (int i=0; i<words.length;i++)
			   insert(words[i]);
		
		         System.out.println("contains the: "+search("the"));
		         System.out.println("contains this: "+search("this"));
		         System.out.println("contains a: "+search("a"));

				 //case 2 : insert and search prefix 
			String []words= {"net","network","networking", "none"};
			String key="net";
				for (int i=0; i<words.length;i++)
				{	insert(words[i]);
				}
			System.out.println("contains the prefix: "+startsWith(key));


		

	}

}
