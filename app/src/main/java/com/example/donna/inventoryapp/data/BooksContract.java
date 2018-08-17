package com.example.donna.inventoryapp.data;

import android.provider.BaseColumns;

public final class BooksContract {
    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    private BooksContract() {}

    /**
     * Inner class that defines constant values for the books database table.
     * Each entry in the table represents a single pet.
     */
    public static final class BookEntry implements BaseColumns {

        /** Name of database table for pets */
        public final static String TABLE_NAME = "books";

        /**
         * Unique ID for book (only for use in the database table).
         *
         * Type: INTEGER
         */
        public final static String _ID = BaseColumns._ID;

        /**
         * Name of the book.
         *
         * Type: TEXT
         */
        public final static String COLUMN_BOOK_NAME ="name";

        /**
         * Price of the pet.
         *
         * Type: Int
         */
        public final static String COLUMN_BOOK_PRICE ="price";

        /**
         * Quantity of the books.
         *
         * Type: INTEGER
         */
        public final static String COLUMN_BOOK_QUANTITY  ="quantity";

        /**
         * Book supplier
         *
         * Type: TEXT
         */
        public final static String COLUMN_BOOK_SUPPLIER = "supplier";

        /**
         * Supploer phone number.
         *
         * Type: INTEGER
         */
        public final static String COLUMN_BOOK_SUPPLIER_PHONE = "supplier_phone";

}
}
