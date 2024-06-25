package com.example.demo.Service;

import com.example.demo.Exception.FailedToGetProductsException;
import com.example.demo.Exception.ProductDoesNotExistException;
import com.example.demo.Model.Product;
import com.example.demo.Repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProductService {
    private ProductRepository productRepository;

    public String deleteProduct(Integer id) {
        if(!productRepository.existsById(id)) {
            throw new ProductDoesNotExistException("Product with id " + id + " does not exist");
        }
        productRepository.deleteById(id);

        return "Product with id: " + id + " deleted";
    }

    public Product updateProduct(Integer id, Product newProduct) {
        return productRepository.findById(id)
                .map(product -> {
                    product.setName(newProduct.getName());
                    product.setPrice(newProduct.getPrice());
                    product.setDescription(newProduct.getDescription());
                    product.setId(newProduct.getId());
                    return productRepository.save(product);
                }).orElseThrow(() -> new ProductDoesNotExistException("Order with id " + id + " does not exist"));
    }

    public Product findProductById(Integer id) {
        Optional<Product> product = productRepository.findById(id);
        return product.orElseThrow(() -> new ProductDoesNotExistException("This order does not exist"));
    }

    public List<Product> getAllProducts(){
        List<Product> products = productRepository.findAll();

        try{
            List<Product> products1 = productRepository.findAll();
            System.out.println(products1);
        }catch (Exception e){
            throw new FailedToGetProductsException();
        }

        //Stream
//        double totalPriceOfProducts = products.stream().mapToDouble(Product::getPrice).sum();
//        //for loop
//        for(int i=0;i<products.size();i++){
//            totalPriceOfProducts+=products.get(i).getPrice();
//        }
//
//        // forEach
//        for(Product product : products){
//            totalPriceOfProducts += product.getPrice();
//        }
//
//        // Using a while loop and iterator
//        Iterator<Product> productIterator = products.iterator();
//        while(productIterator.hasNext()) {
//            Product product = productIterator.next();
//            totalPriceOfProducts += product.getPrice();
//        }
//
//        //do while
//        do {
//            Product product = productIterator.next();
//            totalPriceOfProducts += product.getPrice();
//        } while (productIterator.hasNext());


//        double totalPriceOfProductsLessThan100 = 0;
//        double totalPriceOfProductsGreaterOrEqualThan100 = 0;
//
//        for (Product product : products) {
//            if (product.getPrice() < 100) {
//                totalPriceOfProductsLessThan100 += product.getPrice();
//            }
//            else{
//                totalPriceOfProductsGreaterOrEqualThan100 += product.getPrice();
//            }
//
//            switch(product.getName()){
//                case "check":
//                    System.out.println("Was checking everything was working");
//                case "Heater":
//                    System.out.println("Heater was working");
//                case "Water":
//                    System.out.println("Water was working");
//                default:
//                    System.out.println("Other items");
//            }
//        }
//
//        System.out.println(totalPriceOfProductsGreaterOrEqualThan100);
//        System.out.println(totalPriceOfProductsLessThan100);
//        System.out.println(totalPriceOfProducts);

//
//        List<Integer> number = Arrays.asList(1,2,3,3,4);
//        number.forEach(System.out::println);
//        //This would out 1 2 3 3 4

//       //SETS
//        Set<Integer> number1 = new HashSet<>(number);
//        number1.forEach(System.out::println);
//        // This would output 1 2 3 4 - Will only output the unique numbers

//  //      COLLECTIONS
//        Collections.sort(products);
//        Collections.min(products);
//        Collections.max(products);
//        Collections.reverse(products);
//
//        System.out.println(Collections.min(products));
//
//        products.stream().filter(product -> product.getPrice() > 10).forEach(System.out::println);
//        List<Product> cheapProducts = products.stream().filter(product -> product.getPrice() < 10).toList();
//
//        System.out.println(products);
//
//        try{
//            Product product = products.get(1000);
//        }catch (Exception e){
//            System.err.println("There seems to not be 100 products " + e.getMessage());
//        }


        return products;
    }
}
