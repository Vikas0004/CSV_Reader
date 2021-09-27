package com.nagarro.input_handler;

import java.util.*;

import com.nagarro.output_handler.OutputHandler;
import com.nagarro.product_details.ProductDetails;

public class InputHandler {
    private static final Set<String> sizeChart =
            new HashSet<>(Arrays.asList("xs", "s", "m", "l", "xl", "xxl"));
    private static final Set<String> genderRecommendation =
            new HashSet<>(Arrays.asList("m", "f", "u"));

    ProductDetails inputDetails;
    Scanner sc;
    private String itemColor;
    private String itemGender;
    private String itemSize;
    private int preference;


    public InputHandler() {
        this.inputDetails = new ProductDetails();
        sc = new Scanner(System.in);
    }

    public void getUserInput() {
        
    	
    	getColor();
        getSize();
        getGender();
        getOutputPreference();
    }

    public ProductDetails getInputDetails() {
        return inputDetails;
    }

    private void getOutputPreference() {
        System.out.println("Choose the output preference from below options : " + "\n" +
                "1 : Sort By Price " + "\n" +
                "2 : Sort By rating" + "\n" +
                "3 : Sort By Price and Rating" + "\n");

        try {
            preference = sc.nextInt();

        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
            sc.next();
            getOutputPreference();
        } finally {
            switch (preference) {
                case 1:
                case 2:
                case 3:
                    inputDetails.setPreference(preference);
                    break;
                default:
                    System.out.println("Enter a valid preference");
                    getOutputPreference();
            }
        }

    }
    private void getSize() {
        System.out.println("Enter the size: ");
        try {
            itemSize = sc.nextLine();
            if(!sizeChart.contains(itemSize.toLowerCase())) {
                throw new IllegalArgumentException();
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Please Enter a valid size");
            getSize();
        } catch (InputMismatchException e) {
            System.out.println("Please Enter a Valid Input");
            sc.next();
            getSize();
        } finally {
            inputDetails.setSize(itemSize);
        }

    }


    private void getColor() {
        System.out.println("Enter the Color of a T shirt : ");
        try {
            itemColor = sc.nextLine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            getColor();
        } finally {
            inputDetails.setColor(itemColor);
        }
    }

    private void getGender() {
        System.out.println("Gender Recommendation : ");
        try {
            itemGender = sc.nextLine();
            if(!genderRecommendation.contains(itemGender.toLowerCase())) {
                throw new IllegalArgumentException();
            }


        } catch (IllegalArgumentException e) {
            System.out.println("Please specify an appropriate gender");
            getGender();
        } catch (InputMismatchException e) {
            System.out.println("Please Enter a Valid Input");
            sc.next();
            getGender();
        } finally {
            inputDetails.setGender(itemGender);
        }
    }
}


