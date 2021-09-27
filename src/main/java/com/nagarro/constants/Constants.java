package com.nagarro.constants;

public class Constants {
	
	public static final String  CSV_FILES_URL = "C:\\Users\\vikasbhalla\\Desktop\\files\\";
	
	public static final String NOT_FOUND = "Sorry ! No Items Found Matching Your Search !!";
	
	public static final String WELCOME_MESSAGE = "Welcome to T-Shirts Search Programm";
	
	public static final String ENTER_SIZE = "Enter Your Size (XS, S, M, L, XL, XXL) :";
	
	public static final String ENTER_COLOR = "Enter Color of T-Shirt You Want To Search For: ";

	public static final String ENTER_GENDER = "Enter Gender Prefrence (M, F, U) :";	
	
	public static final String ENTER_OUTPUT_PREFERENCES = "Choose the output preference from below options : \r\n"
			+ " 1 : Sort By Price  \r\n"
			+ " 2 : Sort By rating \r\n"
			+ " 3 : Sort By Price and Rating";
	
	public static void main(String[] args) {
		System.out.println(ENTER_OUTPUT_PREFERENCES);
	}
}
