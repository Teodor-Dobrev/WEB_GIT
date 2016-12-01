// Used a tutorial for Linked List in Java and some StackOverflow
package bg.elsys.ip.rest;

public class Link{

	public String phoneName;
	public int phoneWeightInG;
	public double phoneDisplayWidthInInches;
	public String phoneDisplayResolutionInPixels;
	public String phoneAndroidOSNumber;
	
	public Link next;
	
	public Link(String phoneName, int phoneWeightInG,double phoneDisplayWidthInInches2, String phoneDisplayResolutionInPixels, String phoneAndroidOSNumber) {
		this.phoneName = phoneName;
		this.phoneWeightInG = phoneWeightInG;
		this.phoneDisplayWidthInInches = phoneDisplayWidthInInches2;
		this.phoneDisplayResolutionInPixels = phoneDisplayResolutionInPixels;
		this.phoneAndroidOSNumber = phoneAndroidOSNumber;
	}
	
	public void display() {
		System.out.print(phoneName + "; ");
		System.out.print(phoneWeightInG + "; ");
		System.out.print(phoneDisplayWidthInInches + "; ");
		System.out.print(phoneDisplayResolutionInPixels + "; ");
		System.out.println(phoneAndroidOSNumber);
	}
	
	public String toString() {
		return phoneName;
	}
	
	public Link() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {

		LinkList theLinkedList = new LinkList();
		
		theLinkedList.insertFirstLink("Google Pixel XL", 168, 5.5, "1440 x 2560", "7.1");
		theLinkedList.insertFirstLink("Asus Zenfone 3 Max ZC553KL", 175, 5.5, "1080 x 1920", "6.0.1");
		theLinkedList.insertFirstLink("Lenovo A6600 Plus", 142, 5.0, "720 x 1280 ", "6.0");
		theLinkedList.insertFirstLink("Lenovo K6", 140, 5.0, "1080 x 1920", "6.0");
		theLinkedList.insertFirstLink("Samsung Galaxy S7", 152, 5.1, "1440 x 2560", "6.0");
		theLinkedList.insertFirstLink("Samsung Galaxy S7 edge", 157, 5.5, "1440 x 2560", "6.0");
		theLinkedList.insertFirstLink("Samsung Galaxy A3", 132, 4.7, "720 x 1280", "5.1.1");
		theLinkedList.insertFirstLink("Samsung Galaxy Note5", 171, 5.7, "1440 x 2560", "5.1.1");
		theLinkedList.insertFirstLink("Google Pixel", 143, 5.0, "1080 x 1920", "7.1");
		
		theLinkedList.display();
	
	}
}


class LinkList {
	
	public Link firstLink;
	
	LinkList() {
		firstLink = null;
	}
	
	public boolean isEmpty() {
		return (firstLink == null);
	}
	
	public void insertFirstLink(String phoneName, int phoneWeightInG,double phoneDisplayWidthInInches, String phoneDisplayResolutionInPixels, String phoneAndroidOSNumber){
		Link newLink = new Link(phoneName, phoneWeightInG, phoneDisplayWidthInInches, phoneDisplayResolutionInPixels, phoneAndroidOSNumber);
		newLink.next = firstLink;
		firstLink = newLink;
	}
	
	public Link removeFirst() {
		Link linkReference = firstLink;
		if (!isEmpty()) {
			firstLink = firstLink.next;
		} else {
			System.out.println("Empty LinkedList");
		}
		return linkReference;
	}
	
	public void display() {
		Link theLink = firstLink;
		while (theLink != null) {
			theLink.display();
			System.out.println("Next Link: " + theLink.next);
			theLink = theLink.next;
			System.out.println();
		}
	}
	
	public Link findPhoneName(String phoneName) {
		Link theLink = firstLink;
		if (!isEmpty()) {
			while (theLink.phoneName.toLowerCase() != phoneName.toLowerCase()) {
				if (theLink.next == null) {
					return null;
				} else {
					theLink = theLink.next;
				}
			}
		} else {
			System.out.println("Empty LinkedList");
		}
		
		return theLink;
	}
	
	public Link findPhoneWeightInG(int phoneWeightInG) {
		Link theLink = firstLink;
		if (!isEmpty()) {
			while (theLink.phoneWeightInG != phoneWeightInG) {
				if (theLink.next == null) {
					return null;
				} else {
					theLink = theLink.next;
				}
			}
		} else {
			System.out.println("Empty LinkedList");
		}
		
		return theLink;
	}
	
	public Link removeFirstMatchhingLink(String phoneName) {
		Link currentLink = firstLink;
		Link PreviousLink = firstLink;
		
		while (currentLink.phoneName.toLowerCase() != phoneName.toLowerCase()) {
			if (currentLink.next == null) {
				return null;
			} else {
				PreviousLink = currentLink;
				currentLink = currentLink.next;
			}
		}
		
		if (currentLink == firstLink) {
			firstLink = firstLink.next;
		} else {
			PreviousLink.next = currentLink.next;
		}
		
		return currentLink;
	}
}
