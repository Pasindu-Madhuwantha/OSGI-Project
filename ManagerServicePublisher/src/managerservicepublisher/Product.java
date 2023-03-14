package managerservicepublisher;

public class Product {
    private String productName;
    private String brand;
    private String price;
    private String sizeNweight;
    private String manufacturedDate;
    private int qty;


    public Product() {

    }

    /**
     * @param productName
     * @param brand
     * @param price
     * @param sizeNweight
     * @param manufacturedDate
     * @param qty
     */
    public Product(String productName, String brand, String price, String sizeNweight, String manufacturedDate, int qty) {
        this.productName = productName;
        this.brand = brand;
        this.price = price;
        this.sizeNweight = sizeNweight;
        this.manufacturedDate = manufacturedDate;
        this.qty = qty;
    }

   
    public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getSizeNweight() {
		return sizeNweight;
	}

	public void setSizeNweight(String sizeNweight) {
		this.sizeNweight = sizeNweight;
	}

	public String getManufacturedDate() {
		return manufacturedDate;
	}

	public void setManufacturedDate(String manufacturedDate) {
		this.manufacturedDate = manufacturedDate;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	/**
     * @return correct answer
     */
    public String getCorrectAnswer() {
        switch (qty) {
            case 1:
                return brand;
            case 2:
                return price;
            case 3:
                return sizeNweight;
            case 4:
                return manufacturedDate;
        }
        return "";
    }

    @Override
    public String toString() {
        return    "Product Name=" + productName + '\n' +
                "\t Product Brand = " + brand + '\n' +
                "\t Product Price = " + price + '\n' +
                "\t Product Size/Weight = " + sizeNweight + '\n' +
                "\t Prodcut Expiry(food)/Manufactured Date = " + manufacturedDate + '\n' +
                "\t Product Availabe Quantity = " + qty ;
        
     
    }


}
