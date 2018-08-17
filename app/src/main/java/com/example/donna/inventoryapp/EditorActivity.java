package com.example.donna.inventoryapp;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;
import com.example.donna.inventoryapp.data.BooksDBHelper;
import com.example.donna.inventoryapp.data.BooksContract.BookEntry;

public class EditorActivity extends AppCompatActivity {

    /**
     * EditText field to add book title
     */
    private EditText mBookEditText;

    /**
     * EditText field to enter the books price
     */
    private EditText mPriceEditText;

    /**
     * EditText field to enter the book quantity
     */
    private EditText mQuantitytEditText;

    /**
     * EditText field to enter the supplier name
     */
    private EditText mSupplerEditText;

    /**
     * EditText field to enter the suppliers phone
     */
    private EditText mPhonetEditText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        // Find all relevant views that we will need to read user input from
        mBookEditText = (EditText) findViewById(R.id.edit_book_name);
        mPriceEditText = (EditText) findViewById(R.id.edit_book_price);
        mQuantitytEditText = (EditText) findViewById(R.id.edit_quantity);
        mSupplerEditText = (EditText) findViewById(R.id.edit_supplier_name);
        mPhonetEditText = (EditText) findViewById(R.id.edit_phone);
    }
        /**
         * Get user input from editor and save new book into database.
         */
        private void insertBook() {
            // Read from input fields
            // Use trim to eliminate leading or trailing white space
            String nameString = mBookEditText.getText().toString().trim();
            String priceString = mPriceEditText.getText().toString().trim();
            int price = Integer.parseInt(priceString);
            String quantityString = mQuantitytEditText.getText().toString().trim();
            int qty = Integer.parseInt(quantityString);
            String supplierString = mSupplerEditText.getText().toString().trim();
            String supplierPhoneString = mPhonetEditText.getText().toString().trim();


            // Create database helper
            BooksDBHelper mDbHelper = new BooksDBHelper(this);

            // Gets the database in write mode
            SQLiteDatabase db = mDbHelper.getWritableDatabase();

            // Create a ContentValues object where column names are the keys,
            // and pet attributes from the editor are the values.
            ContentValues values = new ContentValues();
            values.put(BookEntry.COLUMN_BOOK_NAME, nameString);
            values.put(BookEntry.COLUMN_BOOK_PRICE, price);
            values.put(BookEntry.COLUMN_BOOK_QUANTITY, qty);
            values.put(BookEntry.COLUMN_BOOK_SUPPLIER, supplierString);
            values.put(BookEntry.COLUMN_BOOK_SUPPLIER_PHONE, supplierPhoneString);


            // Insert a new row for pet in the database, returning the ID of that new row.
            long newRowId = db.insert(BookEntry.TABLE_NAME, null, values);

            // Show a toast message depending on whether or not the insertion was successful
            if (newRowId == -1) {
                // If the row ID is -1, then there was an error with insertion.
                Toast.makeText(this, "Error with saving book", Toast.LENGTH_SHORT).show();
            } else {
                // Otherwise, the insertion was successful and we can display a toast with the row ID.
                Toast.makeText(this, "Book saved with row id: " + newRowId, Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu options from the res/menu/menu_editor.xml file.
            // This adds menu items to the app bar.
            getMenuInflater().inflate(R.menu.menu_editor, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // User clicked on a menu option in the app bar overflow menu
            switch (item.getItemId()) {
                // Respond to a click on the "Save" menu option
                case R.id.action_save:
                    // Save pet to database
                    insertBook();
                    // Exit activity
                    finish();
                    return true;
                // Respond to a click on the "Delete" menu option
                case R.id.action_delete:
                    // Do nothing for now
                    return true;
                // Respond to a click on the "Up" arrow button in the app bar
                case android.R.id.home:
                    // Navigate back to parent activity (CatalogActivity)
                    NavUtils.navigateUpFromSameTask(this);
                    return true;
            }
            return super.onOptionsItemSelected(item);
        }

}
