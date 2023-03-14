package managerservicepublisher;

import java.util.ArrayList;
import java.util.Scanner;

public class QuizPublisherImpl implements IQuizPublisher {

    private ArrayList<Product> clothes;
    private ArrayList<Product> digital;
    private ArrayList<Product> food;
    private ArrayList<Product> other;
    private Scanner scanner;

    public QuizPublisherImpl() {

        scanner = new Scanner(System.in);

        // add initial data to the clothes
        clothes = new ArrayList<>();
        clothes.add(new Product("Shirt", "Polo","Rs.2300.00",  "Medium", "2023-05-30", 15));
        clothes.add(new Product("T-Shirt","Nike", "Rs.600.00",  "Small", "2023-06-30",13));
        clothes.add(new Product("Sweater", "Tommy Hilfiger","Rs.4500.00",  "2023-05-30", "Wool", 11));
        clothes.add(new Product("Dress",  "Zara","Rs.2800.00", "Medium", "2023-04-30", 31));
        clothes.add(new Product("Jacket","The North Face", "Rs.7500.00",  "X-Large", "2023-04-30", 11));

        // add initial data to the food
        food = new ArrayList<>();
        food.add(new Product("Cheddar Cheese", "Amul", "Rs.300.00", "500g", "2023-04-30", 1));
        food.add(new Product("Maggi Noodles", "Nestle", "Rs.12.00", "70g", "2023-07-01", 5));
        food.add(new Product("Peanut Butter", "Skippy", "Rs.400.00", "500g", "2024-03-01", 1));
        food.add(new Product("Olive Oil", "Borges", "Rs.500.00", "1L", "2025-02-15", 1));
        food.add(new Product("Frozen Pizza", "DiGiorno", "Rs.400.00", "400g", "2023-09-30", 2));

        // add initial data to digital
        digital = new ArrayList<>();
        digital.add(new Product("MacBook Air", "Apple", "Rs.85,000.00", "1.29kg", "2022-10-01", 11));
        digital.add(new Product("Xbox Series X", "Microsoft", "Rs.49,990.00", "4.45kg", "2021-11-20", 21));
        digital.add(new Product("Samsung Galaxy S21", "Samsung", "Rs.69,999.00", "0.17kg", "2021-02-15", 13));
        digital.add(new Product("Sony WH-1000XM4", "Sony", "Rs.29,990.00", "0.25kg", "2020-09-10", 14));
        digital.add(new Product("Fitbit Charge 5", "Fitbit", "Rs.14,999.00", "0.025kg", "2022-01-01", 11));

        other = new ArrayList<>();
        other.add(new Product("Leather Wallet", "Montblanc", "Rs.30,000.00", "0.1kg", "2022-04-01", 11));
        other.add(new Product("Ceramic Vase", "Jonathan Adler", "Rs.7,500.00", "0.5kg", "2022-06-15", 12));
        other.add(new Product("Metallic Pen Set", "Parker", "Rs.4,000.00", "0.2kg", "2022-03-10", 15));
        other.add(new Product("Handheld Vacuum Cleaner", "Dyson", "Rs.25,000.00", "1.5kg", "2021-11-30", 11));
        other.add(new Product("Hiking Backpack", "The North Face", "Rs.8,500.00", "1kg", "2022-02-01", 21));

    }

    @Override
    public void addNewProduct() {
        char addNewProduct;
        int Type;

        do {
            System.out.println("-----------------------------------------------------------------");
            System.out.println("  Please select the category you would like to add: ");
            System.out.println("-----------------------------------------------------------------");

            displayMenu();

            Type = scanner.nextInt();
            scanner.nextLine();

            switch (Type) {
                case 1:
                    clothes.add(getProductData("Clothes"));
                    break;
                case 2:
                    digital.add(getProductData("Food"));
                    break;
                case 3:
                    food.add(getProductData("Digital Device"));
                    break;
                case 4:
                    other.add(getProductData("Other"));
                    break;
                default:
                    System.out.println("Invalid type");
            }

            System.out.println("Would you like to add another ? (Y/N)");
            addNewProduct = scanner.next().charAt(0);
        } while (addNewProduct == 'y' || addNewProduct == 'Y');
    }

    @Override
    public void displayProducts() {
        char displayProducts;
        int Type;

        do {
            System.out.println("-----------------------------------------------------------------");
            System.out.println("  Please select the category you would like to see: ");
            System.out.println("-----------------------------------------------------------------");

            displayMenu();

            Type = scanner.nextInt();
            scanner.nextLine();

            switch (Type) {
                case 1:
                    displayProductData(clothes);
                    break;
                case 2:
                    displayProductData(digital);
                    break;
                case 3:
                    displayProductData(food);
                    break;
                case 4:
                    displayProductData(other);
                    break;
                default:
                    System.out.println("Invalid  type");
            }

            System.out.println("\n Would you like to see another category? (Y/N)");
            displayProducts = scanner.next().charAt(0);
        } while (displayProducts == 'y' || displayProducts == 'Y');
        return;
    }

   

    @Override
    public void removeProduct() {
        int removeProduct;
        char deleteMore;
        int Type;
        ArrayList<Product> selectedProduct = null;

        do {
            System.out.println("-----------------------------------------------------------------");
            System.out.println("Please select product you would like to remove: ");
            System.out.println("-----------------------------------------------------------------");
            displayMenu();
            Type = scanner.nextInt();
            scanner.nextLine();

            switch (Type) {
                case 1:
                    selectedProduct = clothes;
                    break;
                case 2:
                    selectedProduct = digital;
                    break;
                case 3:
                    selectedProduct = food;
                    break;
                case 4:
                    selectedProduct = other;
                    break;
                default:
                    System.out.println("Invalid product type");
            }
            displayProductData(selectedProduct);
            System.out.println("Enter the number of the product you would like to remove: ");
            removeProduct = scanner.nextInt();
            scanner.nextLine();
            if (removeProduct > 0 && removeProduct <= selectedProduct.size()) {
                selectedProduct.remove(removeProduct - 1);
                System.out.println("-----------------------------------------------------------------");
                System.out.println("              Product removed successfully!                         ");
                System.out.println("-----------------------------------------------------------------\n");
            } else {
                System.out.println("-----------------------------------------------------------------");
                System.out.println("              Invalid product number!                              ");
                System.out.println("-----------------------------------------------------------------\n");
            }
            System.out.println("Do you want to remove another product? (Y/N)");
            deleteMore = scanner.next().charAt(0);
        } while (deleteMore == 'Y' || deleteMore == 'y');
    }

    @Override
    public void updateProduct() {
        int updateProduct;
        char updateMore;
        int Type;
        char updateState;
        ArrayList<Product> selectedProduct = null;

        do {
            System.out.println("-----------------------------------------------------------------");
            System.out.println("Please select the product type  you would like to update: ");
            System.out.println("-----------------------------------------------------------------");
            displayMenu();
            Type = scanner.nextInt();
            scanner.nextLine();

            switch (Type) {
                case 1:
                    selectedProduct = clothes;
                    break;
                case 2:
                    selectedProduct = digital;
                    break;
                case 3:
                    selectedProduct = food;
                    break;
                case 4:
                    selectedProduct = other;
                    break;
                default:
                    System.out.println("Invalid product type");
            }

            displayProductData(selectedProduct);
            System.out.println("Enter the number of the product you would like to update: ");
            updateProduct = scanner.nextInt();
            scanner.nextLine();
            if (updateProduct > 0 && updateProduct <= selectedProduct.size()) {
                Product product = new Product();
                System.out.println("Do you want to update the Product Name? (Y/N)");
                updateState = scanner.nextLine().charAt(0);
                if (updateState == 'Y' || updateState == 'y') {
                    System.out.println("Enter the Product Name: ");
                    product.setProductName(scanner.nextLine());
                } else {
                    product.setProductName(selectedProduct.get(updateProduct - 1).getProductName());
                }
                System.out.println("Do you want to update the Product Brand? (Y/N)");
                updateState = scanner.nextLine().charAt(0);
                if (updateState == 'Y' || updateState == 'y') {
                    System.out.println("Enter the new Product Brand: ");
                    product.setBrand(scanner.nextLine());
                } else {
                    product.setBrand(selectedProduct.get(updateProduct - 1).getBrand());
                }
                System.out.println("Do you want to update the Product Price? (Y/N)");
                updateState = scanner.nextLine().charAt(0);
                if (updateState == 'Y' || updateState == 'y') {
                    System.out.println("Enter the new Product Price: ");
                    product.setPrice(scanner.nextLine());
                } else {
                    product.setPrice(selectedProduct.get(updateProduct - 1).getPrice());
                }
                System.out.println("Do you want to update the Product Size/Weight? (Y/N)");
                updateState = scanner.nextLine().charAt(0);
                if (updateState == 'Y' || updateState == 'y') {
                    System.out.println("Enter the new Product Size/Weight? ");
                    product.setSizeNweight(scanner.nextLine());
                } else {
                    product.setSizeNweight(selectedProduct.get(updateProduct - 1).getSizeNweight());
                }
                System.out.println("Do you want to update the Product Manufactured Date ? (Y/N)");
                updateState = scanner.nextLine().charAt(0);
                if (updateState == 'Y' || updateState == 'y') {
                    System.out.println("Enter the new Product Manufactured Date: ");
                    product.setManufacturedDate(scanner.nextLine());
                } else {
                    product.setManufacturedDate(selectedProduct.get(updateProduct - 1).getManufacturedDate());
                }
                System.out.println("Do you want to update the product stock? (Y/N)");
                updateState = scanner.nextLine().charAt(0);
                if (updateState == 'Y' || updateState == 'y') {
                    System.out.println("Enter the new product stock?: ");
                    product.setQty(scanner.nextInt());
                } else {
                    product.setQty(selectedProduct.get(updateProduct - 1).getQty());
                }
                selectedProduct.remove(updateProduct - 1);
                selectedProduct.add(updateProduct - 1, product);

                System.out.println("-----------------------------------------------------------------");
                System.out.println("              Product updated successfully!                         ");
                System.out.println("-----------------------------------------------------------------\n");
            } else {
                System.out.println("-----------------------------------------------------------------");
                System.out.println("              Invalid product number!                              ");
                System.out.println("-----------------------------------------------------------------\n");
            }
            System.out.println("Do you want to update another product? (Y/N)");
            updateMore = scanner.next().charAt(0);
        } while (updateMore == 'Y' || updateMore == 'y');
    }

    

    private void displayProductData(ArrayList<Product> products) {
        int productNumber = 1;
        for (Product product : products) {
            System.out.println(productNumber + ". " + product.toString());
            productNumber++;
        }
    }

    private Product getProductData(String ProductType) {
        Product newProduct = new Product();
        System.out.println("Please enter a " + ProductType + "Type: ");
        newProduct.setProductName(scanner.nextLine());
        System.out.println("Please eneter the brand of the product : ");
        newProduct.setBrand(scanner.nextLine());
        System.out.println("Please enter the price of the product: ");
        newProduct.setPrice(scanner.nextLine());
        System.out.println("Please enter size/weight of the product ");
        newProduct.setSizeNweight(scanner.nextLine());
        System.out.println("Please enter expiry date(food)/manufactured date of the product[yyyy/mm/dd]: ");
        newProduct.setManufacturedDate(scanner.nextLine());
        System.out.println("Please enter available quantity of the product: ");
        newProduct.setQty(scanner.nextInt());
        return newProduct;
    }

    private void displayMenu() {
        System.out.println("1. Clothes");
        System.out.println("2. Food");
        System.out.println("3. Digital Products");
        System.out.println("4. Other");
    }
}
