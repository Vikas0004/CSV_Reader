package com.nagarro.input_handler;

import java.util.*;
import com.nagarro.constants.Constants;
import com.nagarro.product_details.ProductDetails;

@SuppressWarnings("all")
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

        System.out.println(Constants.WELCOME_MESSAGE);
    	getColor();
        getSize();
        getGender();
        getOutputPreference();
    }

    public ProductDetails getInputDetails() {
        return inputDetails;
    }

    private void getOutputPreference() {
        System.out.println(Constants.ENTER_OUTPUT_PREFERENCES);

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
        System.out.println(Constants.ENTER_SIZE);
        try {
            itemSize = sc.nextLine();
            if(!sizeChart.contains(itemSize.toLowerCase())) {
                throw new IllegalArgumentException();
            }

        } catch (IllegalArgumentException e) {
            System.out.println(Constants.ENTER_VALID_SIZE);
            getSize();
        } catch (InputMismatchException e) {
            System.out.println(Constants.ENTER_VALID_INPUT);
            sc.next();
            getSize();
        } finally {
            inputDetails.setSize(itemSize);
        }

    }


    private void getColor() {
        System.out.println(Constants.ENTER_COLOR);
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
        System.out.println(Constants.ENTER_GENDER);
        try {
            itemGender = sc.nextLine();
            if(!genderRecommendation.contains(itemGender.toLowerCase())) {
                throw new IllegalArgumentException();
            }


        } catch (IllegalArgumentException e) {
            System.out.println(Constants.ENTER_VALID_GENDER);
            getGender();
        } catch (InputMismatchException e) {
            System.out.println(Constants.ENTER_VALID_INPUT);
            sc.next();
            getGender();
        } finally {
            inputDetails.setGender(itemGender);
        }
    }
}


