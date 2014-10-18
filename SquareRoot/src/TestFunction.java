/**
 * 
 * @author Matt Matero
 *
 */
public class TestFunction {
	public static void main(String[] args){
		//tests ancient babylonian sqrt function
		System.out.println(Function.AncientSqrt(4)); // should be 2 
		System.out.println();
		System.out.println(Function.AncientSqrt(12)); //should be around 3.4641016151377545870548926830117
		System.out.println();
		System.out.println(Function.AncientSqrt(-5)); //should be 0.0
		System.out.println();
		System.out.println(Function.AncientSqrt(3.5)); //should be around 1.8708286933869706927918743661583
		System.out.println();
		System.out.println(Function.binSerSqrt(128,.0001)); //should be around 11.313708498984760390413509793678
		System.out.println();
		System.out.println(Function.binSerSqrt(4, .001)); //should be 2
		System.out.println();
		System.out.println(Function.binSerSqrt(-3, 0)); //should be 0.0
		System.out.println();
		System.out.println(Function.binSerSqrt(2.3, .0000001)); //should be around 1.5165750888103101108513650872564
	}
}
