package com.ds;
import java.util.ArrayList;

public class Heap {

void insert (ArrayList <Integer> al, int number){
//get size of the passed list
int size= al.size();
//if size is 0 then heap is empty add it
if (size==0)
al.add(number);
//if size is > 0
else
{
//then add in the last of the list
al.add(number);
//iterate from non leaf nodes till root node
for (int i= al.size()/2 -1; i>=0; i--)
//heapify from the last non leaf node till root to build heap in order
heapify(al,i);
}
}

void heapify (ArrayList <Integer> al, int index){
//set largest index to passed index of non leaf node
int largestIndex=index;
//get left and right child index
int leftChildIndex=2*index +1;
int rightChildIndex=2*index +2;
//get size of  the list
int size= al.size();
/*check if leftChildIndex is not greater than array list size and if leftChild is greater than rightChild then
set largestindex to leftchild index as it has larger value
*/
if (leftChildIndex < size && al.get(leftChildIndex) > al.get(largestIndex))
largestIndex=leftChildIndex;
//check the same condition for right child 
if (rightChildIndex < size && al.get(rightChildIndex) > al.get(largestIndex))
largestIndex=rightChildIndex;
/* if largestIndex is not the root index then swap values and set index to largestIndex as now the root is 
the largest node and heapify recursively if largest is not at the root/top */
if (largestIndex!=index)
{
//swap values
int temp= al.get(largestIndex);
al.set(largestIndex, al.get(index));
al.set(index, temp);
//swap(al.get(largestIndex),al.get(index));
heapify(al,largestIndex);
}

}

void delete(ArrayList<Integer>al, int number) {
	//get the size of the list
	int size= al.size();
	int i;
	//iterate the list till node to be deleted is found
	for ( i=0; i< size; i++)
	{
		if (number==al.get(i))
			break;
	}
	//set temp to node to be deleted
	int temp= al.get(i);
	//swap last value to index of node to be deleted and move node to be deleted to last
	al.set(i, al.get(size -1));
	al.set(size -1 , temp);
	//remove last node as it is now the node to be deleted
	al.remove(size-1);
	//heapify 
	for (int j=size/2 -1 ; j >=0; j--)
		heapify(al,j);
}
void swap (int a, int b){
int temp= a;
a=b;
b=temp;
}

void printHeap(ArrayList <Integer> al)
{
for (Integer listValue : al)
System.out.print(listValue+" ");
}

public static void main(String[] args)
{
	//create an integer ArrayList
ArrayList<Integer> heapList=new ArrayList <Integer>();
//get size of list that would be 0
int size= heapList.size();
//create heap and insert values
Heap hp= new Heap();
hp.insert(heapList,7);
hp.insert(heapList,6);
hp.insert(heapList,5);
hp.insert(heapList,4);
hp.insert(heapList,10);
hp.insert(heapList, 12);
//display Heap
System.out.println("Heap Structure: ");
hp.printHeap(heapList);
hp.delete(heapList, 7);
//display Heap after deletion
System.out.println("\nHeap Structure: ");
hp.printHeap(heapList);

}

}

