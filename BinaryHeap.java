import java.util.ArrayList;


public class BinaryHeap<T extends Comparable<? super T>> {
	private ArrayList<T> list = new ArrayList<T>();
	
	public BinaryHeap(){
		list.add(null);
	}
	public BinaryHeap(T[] array){
		list.add(null);
		for(T element : array){
			list.add(element);
		}
	}
	/**
	 * Deletes the smallest element in the heap
	 * @return The deleted element
	 */
	public T deleteMin() {
		if(list.size()==1){
			return null;
		}
		T deleted = list.get(1);
		T toAdd = list.remove(list.size()-1);
		int swapPoint = 1;
		while(swapPoint<list.size()){
			T left=null;
			T right=null;
			if(2*swapPoint<list.size()){
				left = list.get(2*swapPoint);
			}
			if(2*swapPoint+1<list.size()){
				right = list.get(2*swapPoint+1);
			}
			if(left!=null){
				if(left.compareTo(toAdd)<0){
					if(right!=null&&right.compareTo(left)<0){
						list.set(swapPoint, right);
						swapPoint=2*swapPoint+1;
					}
					else{
						list.set(swapPoint, left);
						swapPoint=2*swapPoint;
					}
					continue;
				}
			}
			if(right!=null){
				if(right.compareTo(toAdd)<0){
					list.set(swapPoint, right);
					swapPoint=2*swapPoint+1;
					continue;
				}
			}
			list.set(swapPoint, toAdd);
			break;
			
		}
		return deleted;
	}
	/**
	 * Inserts an element into the heap
	 * @param element
	 */
	public void insert(T element) {
		if(list.size()==1){
			list.add(element);
			return;
		}
		list.add(null);
		int insertPoint = list.size()-1;
		while(insertPoint>1){
			if(list.get(insertPoint/2).compareTo(element)>0){
				list.set(insertPoint, list.get(insertPoint/2));
				insertPoint=insertPoint/2;
			}
			else{
				list.set(insertPoint, element);
				break;
			}
		}
		if(insertPoint==1){
			list.set(1, element);
		}
	}
	/**
	 * Sorts the given array into ascending order
	 * @param array
	 */
	public void sort(T[] array) {
		BinaryHeap<T> heap = new BinaryHeap<T>(array);
		heap.buildHeap();
		for(int i =0; i<array.length; i++){
			array[i] = heap.deleteMin();
		}
		
	}
	/**
	 * Returns a string to represent the heap
	 */
	public String toString(){
		return list.toString();
	}
	/**
	 * Sorts the private ArrayList into a proper heap
	 */
	private void buildHeap(){
		for(int i = list.size()/2;i>0;i--){
			int swapPoint = i;
			T toAdd = list.get(i);
			while(swapPoint<list.size()){
				T left=null;
				T right=null;
				if(2*swapPoint<list.size()){
					left = list.get(2*swapPoint);
				}
				if(2*swapPoint+1<list.size()){
					right = list.get(2*swapPoint+1);
				}
				if(left!=null){
					if(left.compareTo(toAdd)<0){
						if(right!=null&&right.compareTo(left)<0){
							list.set(swapPoint, right);
							swapPoint=2*swapPoint+1;
						}
						else{
							list.set(swapPoint, left);
							swapPoint=2*swapPoint;
						}
						continue;
					}
				}
				if(right!=null){
					if(right.compareTo(toAdd)<0){
						list.set(swapPoint, right);
						swapPoint=2*swapPoint+1;
						continue;
					}
				}
				list.set(swapPoint, toAdd);
				break;
				
			}
		}
	}
}
