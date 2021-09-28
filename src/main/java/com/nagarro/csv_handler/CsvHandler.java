package com.nagarro.csv_handler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import com.nagarro.constants.Constants;
import com.nagarro.data_store.DataStore;
import com.nagarro.exception.NewCustomException;
import com.nagarro.product_details.ProductDetails;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

@SuppressWarnings("all")
public class CsvHandler implements Runnable {

	private List<String> updatedFiles;
	private Map<String, FileTime> csvMapWithTime;
	private final AtomicBoolean running = new AtomicBoolean(false);

	public void stop() {
		running.set(false);
	}
	
	@Override
	public void run() {
		csvMapWithTime = new HashMap<>();
		running.set(true);
		while (running.get()) {
			try {
				/*
				 * Search the Directory after a duration of 25 seconds for the
				 * updated or newly added files
				 */
				searchCSVinDirectory();
				Thread.sleep(25*1000);
			} catch (InterruptedException e) {
				System.out.println("Unexpected Error. Please try again");
			} catch (NewCustomException exception) {
				exception.printMessage();
			}
		}
	}

	public void searchCSVinDirectory() throws NewCustomException {
		try {
			File file = new File(Constants.CSV_FILES_URL);
			List<String> updatedFiles = new ArrayList<>();

			String[] filenames = file.list();
			

			/*
			 * Filter out all the csv files newly added csv files and setting
			 * their last modified time as null
			 */

			for (int i = 0; i < filenames.length; i++) {
				if (filenames[i].endsWith(".csv")) {
					if (!csvMapWithTime.containsKey(filenames[i])) {
						csvMapWithTime.put(filenames[i], null);
					}
					
					Path path = Paths.get(Constants.CSV_FILES_URL, filenames[i]);
					BasicFileAttributes fileAttributes = Files.readAttributes(path,
							BasicFileAttributes.class);
					
					if (csvMapWithTime.get(filenames[i]) == null
							|| !csvMapWithTime.get(filenames[i]).equals(
									fileAttributes.lastModifiedTime())) {
						updatedFiles.add(filenames[i]);
						csvMapWithTime.put(filenames[i], fileAttributes.lastModifiedTime());
					}
				}
			}
			this.updatedFiles = updatedFiles;
			/*
			 * If updated files are found then they are added to the Data
			 * Structure
			 */
			if (updatedFiles.size() > 0) {
				addUpdatedFilesData();
			}
		} catch (IOException e) {
			throw new NewCustomException(
					"Problem in Input output operations of File..Reading File Attributes");
		} catch (Exception e) {
			throw new NewCustomException(
					"Unexpected Error while reading CSV file attributes");
		}
	}

	public void addUpdatedFilesData() {
		/*
		 * If the CSV file in the List is a newly added file than it creates a
		 * new entry in the Hash map assigning filename as Key and initializes a
		 * new sub map - Hash map as Value
		 */
		for (int i = 0; i < updatedFiles.size(); i++) {
			try {
				Set<ProductDetails> data = readCsvAddData(updatedFiles.get(i));
				DataStore.getInstance().insertCsvFileData(updatedFiles.get(i), data);
			} catch (NewCustomException exception) {
				exception.printMessage();
			}

		}
	}


	public Set<ProductDetails> readCsvAddData(String csvFile) throws NewCustomException {
		Set<ProductDetails> Data = new HashSet<>();
		csvFile = Constants.CSV_FILES_URL + csvFile;

		try {
			Reader reader = Files.newBufferedReader(Paths.get(csvFile));


            ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
            strategy.setType(ProductDetails.class);
            String[] memberFieldsToBindTo = {"ID", "Name", "color", "gender", "size","price", "rating", "availability"};
            
            
            strategy.setColumnMapping(memberFieldsToBindTo);

            @SuppressWarnings("unchecked")
			CsvToBean<ProductDetails> csvToBean = new CsvToBeanBuilder(reader)
                    .withMappingStrategy(strategy)
                    .withSkipLines(1)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            Iterator<ProductDetails> itrIterator = csvToBean.iterator();

            while(itrIterator.hasNext()) {
            	ProductDetails itr = itrIterator.next();
            	Data.add(itr);	
            }

		} catch (FileNotFoundException e) {
			throw new NewCustomException("Sorry the Files are not Found");
		} catch (IOException e) {
			throw new NewCustomException(
					"Unexpected Input Output Exceptions while Reading the File");
		}
		return Data;
	}

}
