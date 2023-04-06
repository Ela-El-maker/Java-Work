
public abstract class Table {
	protected String woodType;
	protected int numOfDrawers;
	protected int numOfTables;
	protected int length;
	protected int width;
	protected double price;
	/**
	 * @param woodType
	 * @param numOfDrawers
	 * @param length
	 * @param width
	 * @param price
	 */
	public Table(String woodType, int numOfDrawers,int numOfTables, int length, int width, double price) {
		this.woodType = woodType;
		this.numOfDrawers = numOfDrawers;
		this.numOfTables = numOfTables;
		this.length = length;
		this.width = width;
		this.price = price;
	}
	/**
	 * @return the numOfTables
	 */
	public int getNumOfTables() {
		return numOfTables;
	}
	/**
	 * @param numOfTables the numOfTables to set
	 */
	public void setNumOfTables(int numOfTables) {
		this.numOfTables = numOfTables;
	}
	/**
	 * @return the woodType
	 */
	public String getWoodType() {
		return woodType;
	}
	/**
	 * @param woodType the woodType to set
	 */
	public void setWoodType(String woodType) {
		this.woodType = woodType;
	}
	/**
	 * @return the numOfDrawers
	 */
	public int getNumOfDrawers() {
		return numOfDrawers;
	}
	/**
	 * @param numOfDrawers the numOfDrawers to set
	 */
	public void setNumOfDrawers(int numOfDrawers) {
		this.numOfDrawers = numOfDrawers;
	}
	/**
	 * @return the length
	 */
	public int getLength() {
		return length;
	}
	/**
	 * @param length the length to set
	 */
	public void setLength(int length) {
		this.length = length;
	}
	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}
	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	public abstract double calculatePrice();
	
}
class StandardTable extends Table{
	
	
	/**
	 * @param woodType
	 * @param numOfDrawers
	 * @param length
	 * @param width
	 * @param price
	 */
	//constructor
	public StandardTable(String woodType, int numOfDrawers,int numOfTables, int length, int width, double price) {
		super(woodType, numOfDrawers,numOfTables, length, width, price);
		// TODO Auto-generated constructor stub
		this.price=calculatePrice();
	}
	
	public double calculatePrice() {
		double area=length*width;
		double basePrice=42500*numOfTables;
		 if(area>9600) {
			 double extraArea=area-9600;
			 double extraCost=extraArea*825;
			 return basePrice+extraCost;
		 }
		 if(numOfTables>1) {
			 double discount=basePrice*0.05;
			 basePrice-=discount;
		 }
		 if(numOfDrawers>0) {
			 double drawerPrice=2500+(numOfDrawers-1)*2000;
			 basePrice+=drawerPrice*numOfTables;
		 }
		return basePrice;
	}
}
class CustomTable extends Table{
	/**
	 * @param woodType
	 * @param numOfDrawers
	 * @param length
	 * @param width
	 * @param price
	 */
	public CustomTable(String woodType, int numOfDrawers,int numOfTables, int length, int width, double price) {
		super(woodType, numOfDrawers,numOfTables, length, width, price);
		// TODO Auto-generated constructor stub
	}
	
	public double calculatePrice() {
	    double basePrice = 42500 * numOfTables;
	    double area = length * width;
	    double additionalCost = (area - 9600) * 825;

	    if (woodType.equals("Mahogany")) {
	        additionalCost += 3000;
	    } else if (woodType.equals("Oak")) {
	        additionalCost += 2015;
	    }

	    additionalCost += numOfDrawers * 2500;

	    double totalPrice = basePrice + additionalCost;

	    if (numOfTables > 1) {
	        double discount = totalPrice * 0.05;
	        totalPrice -= discount;
	    }

	    return totalPrice;
	}

}
