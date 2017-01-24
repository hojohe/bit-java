/*
 *	E : Element
 *	K : Key
 *	V : Value
 *	T : Type
 *	N : Number
 */
package day14;

public class Box04<K, V> {
	private K key;
	private V value;

	public Box04(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}
	public V getValue() {
		return value;
	}
}